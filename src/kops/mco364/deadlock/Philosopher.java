package kops.mco364.deadlock;

public class Philosopher extends Thread{
	
	
	private Fork f1, f2;
	
	public Philosopher(Fork f1, Fork f2){
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public void run(){
		while(true){
			think();
			eat();
		}
	}
	
	
	
	public void eat(){
		f1.pickUp();
		f2.pickUp();
		
		waitABit();
		
		f1.putDown();
		f2.putDown();
	}
	
	private void waitABit() {
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void think(){
		
	}

}
