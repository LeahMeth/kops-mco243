package kops.scheduler;

import java.text.ParseException;

public class RunSchedulers {

	public static void main(String[] args) throws ParseException {

		// choose which scheduler to use - round-robin schedulers don't take a
		// comparator
		RoundRobinScheduler scheduler = new RoundRobinScheduler();

		// run scheduler
		scheduler.run();

		// display results
		System.out.println(String.format(
				"numJobsCompleted = %d totalTime = %d",
				scheduler.getNumJobsCompleted(), scheduler.getTotalTime()));

	}

}
