package kops.microprocessor;

public class RunMicroprocessor {

	public static void main(String[] args) {
		Microprocessor micro = new Microprocessor();
		micro.readInput("mach.in");
		System.out.println(micro.getOutput());

	}

}
