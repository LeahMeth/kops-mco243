package kops.mco364.deadlock;

public class DiningPhilosophers {

	public static void main(String[] args){
		
		Fork f1 = new Fork();
		Fork f2 = new Fork();
		Fork f3 = new Fork();
		Fork f4 = new Fork();
		Fork f5 = new Fork();
		
		Philosopher p1 = new Philosopher(f1, f2);
		Philosopher p2 = new Philosopher(f2, f3);
		Philosopher p3 = new Philosopher(f3, f4);
		Philosopher p4 = new Philosopher(f4, f5);
		Philosopher p5 = new Philosopher(f5, f1);

		
	}
	
	
}
