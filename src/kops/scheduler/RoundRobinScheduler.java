package kops.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RoundRobinScheduler extends Scheduler{
	
	private static final int TIME_SLICE = 10;
	private static final int OVER_HEAD = 3;
	private static final Random RAND = new Random();

	private List<Job> jobs;

	private int numJobsCompleted = 0;
	private int totalTime = 0;

	public RoundRobinScheduler() throws ParseException{
		super();
	}

	public void run() {

		Job lastJob = null;

		while (!jobs.isEmpty()) {

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
