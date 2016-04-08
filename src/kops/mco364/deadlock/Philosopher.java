package kops.mco364.deadlock;

import java.util.logging.Logger;

public class Philosopher extends Thread {

	private Fork f1;
	private Fork f2;
	private String name;
	private Waiter waiter;
	
	private static final Logger LOGGER  = Logger.getLogger(Philosopher.class.getName());


	public Philosopher(String name, Waiter waiter, Fork f1, Fork f2) {
		this.name = name;
		this.f1 = f1;
		this.f2 = f2;
		this.waiter = waiter;
	}

	public void run() {
		while (true) {
			think();
			eat();
		}
	}

	public void eat() {
		
		LOGGER.info(this.toString()+" attempting to eat");
		if(waiter.tryToEat(f1, f2)){
			LOGGER.info(this.toString()+" eating");
			waitForAFewSeconds(5);
			f1.setInUse(true);
			f2.setInUse(true);

		}
		
		
		
	}

	public void think() {
		waitForAFewSeconds(2);
		LOGGER.info(this.toString()+" thinking");
		f1.setInUse(false);
		f2.setInUse(false);
	}

	private void waitForAFewSeconds(int seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Philosopher " + name;
	}

}
