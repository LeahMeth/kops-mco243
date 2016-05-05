package kops.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public abstract class Scheduler {
	
	private static final int TIME_SLICE = 10;
	protected static final int OVER_HEAD = 3;
	private static final Random RAND = new Random();
	private int numJobsCompleted;
	protected int totalTime;
	private ArrayList<Job> jobs;

	public Scheduler() {
		this.numJobsCompleted = 0;
		this.totalTime = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		try {
			jobs = (ArrayList<Job>) Arrays.asList(
					new Job("1", Priority.High, JobType.Computation, 100, sdf
							.parse("1/1/2000")),
					new Job("2", Priority.Low, JobType.IO, 100, sdf
							.parse("1/2/2000")),
					new Job("3", Priority.Medium, JobType.IO, 100, sdf
							.parse("1/3/2000")),
					new Job("4", Priority.High, JobType.Computation, 100, sdf
							.parse("1/4/2000")),
					new Job("5", Priority.Low, JobType.IO, 100, sdf
							.parse("1/5/2000")),
					new Job("6", Priority.High, JobType.Computation, 100, sdf
							.parse("1/6/2000")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getNumJobsCompleted() {
		return numJobsCompleted;
	}

	public int getTotalTime() {
		return totalTime;
	}

	protected int executeJob(Job job) {
		job.setState(JobState.Running);

		job.setLastRanAtTime(System.currentTimeMillis());

		int actualTimeSlice = computeActualTimeSlice(job);
		job.decrementTimeLeftToRun(actualTimeSlice);

		if (job.isFinished()) {
			jobs.remove(0);
			numJobsCompleted++;
		} else {
			job.setState(JobState.Ready);
		}
		return actualTimeSlice;
	}
	
	private int computeActualTimeSlice(Job job) {
		int timeLeftToRun = job.getTimeLeftToRun();

		if (job.getType() == JobType.IO) {
			return Math.min(timeLeftToRun, RAND.nextInt(TIME_SLICE));
		} else {
			return Math.min(timeLeftToRun, TIME_SLICE);
		}
	}
}
