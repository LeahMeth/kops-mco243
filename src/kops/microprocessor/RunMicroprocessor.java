package kops.microprocessor;

import java.io.FileNotFoundException;

public class RunMicroprocessor {

	public static void main(String[] args) {
		Microprocessor micro;
		try {
			micro = new Microprocessor("./mach.in");
			micro.run();
			System.out.println(micro.getOutput());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
