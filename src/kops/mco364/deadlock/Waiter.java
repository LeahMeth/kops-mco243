package kops.mco364.deadlock;

//Philosophers must ask the Waiter before picking up a fork


public class Waiter {

	public synchronized boolean tryToEat(Fork a, Fork b){
		if (!a.isInUse() && !b.isInUse()){
			a.setInUse(true);
			b.setInUse(true);
			return true;
		}
		
		return false;
	}
	
}
