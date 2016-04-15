package kops.scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class JobSchedular implements Runnable {

	private static final int TIME_SLICE = 10;
	private static final int OVER_HEAD = 3;
	private static final Random RAND = new Random();
	
	private List<Job> jobs;
	private Comparator<Job> comparator;

	private int numJobsCompleted = 0;
	private int totalTime = 0;


	public JobSchedular(List<Job> jobs, PriorityJobComparator priorityJobComparator) {
		this.comparator = priorityJobComparator;
		this.jobs = jobs;
	}

	public void run(){
		
		Job lastJob = null;
		
		while(!jobs.isEmpty()){
			Collections.sort(jobs, comparator);
			Job job = jobs.get(0);
			int actualTimeSlice = executeJob(job);
			totalTime += actualTimeSlice;
		
			if(job != lastJob){
				totalTime += OVER_HEAD;
				lastJob = job;
			}
		
		}
		
		
	}

	
	/**
	 * 
	 * @param job
	 * @return amount of time took to do job
	 */
	private int executeJob(Job job) {
		job.setState(JobState.Running);
		
		job.setLastRanAtTime(System.currentTimeMillis());
		
		
		int actualTimeSlice = computeActualTimeSlice(job);
		job.decrementTimeLeftToRun(actualTimeSlice);	

		
		if(job.isFinished()){
			jobs.remove(0);
			numJobsCompleted++;
		}
		else{
			job.setState(JobState.Ready);
		}
		return actualTimeSlice;
	}

	private int computeActualTimeSlice(Job job) {
		int timeLeftToRun = job.getTimeLeftToRun();
		
		if(job.getType() == JobType.IO){
			return Math.min(timeLeftToRun, RAND.nextInt(TIME_SLICE));
		}
		else{
			 return Math.min(timeLeftToRun, TIME_SLICE);
		}
	}

	public static void main(String[] args) {

		List<Job> jobs = Arrays.asList(
				new Job("1", Priority.High, JobType.Computation, 100),
				new Job("2", Priority.Low, JobType.IO, 100),
				new Job("3", Priority.Medium, JobType.IO, 100),
				new Job("4", Priority.High, JobType.Computation, 100),
				new Job("5", Priority.Low, JobType.IO, 100),
				new Job("6", Priority.High, JobType.Computation, 100),
				new Job("7", Priority.High, JobType.Computation, 100),
				new Job("8", Priority.Low, JobType.IO, 100),
				new Job("9", Priority.Medium, JobType.IO, 100),
				new Job("10", Priority.High, JobType.Computation, 100),
				new Job("11", Priority.Low, JobType.IO, 100),
				new Job("12", Priority.High, JobType.Computation, 100)
				);
		
		JobSchedular schedular = new JobSchedular(new ArrayList<Job>(jobs), new PriorityJobComparator());
		schedular.run();
		
		System.out.println(String.format("numJobsCompleted = %d totalTime = %d",
				schedular.getNumJobsCompleted(),
				schedular.getTotalTime()));
		
		
	}

	private Object getTotalTime() {
		return this.totalTime;
	}

	private Object getNumJobsCompleted() {
		return this.numJobsCompleted;
	}
}
