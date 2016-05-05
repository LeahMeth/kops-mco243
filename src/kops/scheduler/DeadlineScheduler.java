package kops.scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class DeadlineScheduler extends Scheduler{
	
	private static final int OVER_HEAD = 3;
	private static final Random RAND = new Random();

	private List<Job> jobs;
	private Comparator<Job> comparator;


	public DeadlineScheduler() {
		this.comparator = new DeadlineComparator();
	}

	public void run() {

		Job lastJob = null;

		while (!jobs.isEmpty()) {
			Collections.sort(jobs, comparator);
			Job job = jobs.get(0);
			int actualTimeSlice = executeJob(job);
			totalTime += actualTimeSlice;
			
			

			if (job != lastJob) {
				totalTime += OVER_HEAD;
				lastJob = job;
			}

		}

	}

}
