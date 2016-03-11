package kops.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RunCompiler {

	public static void main(String[] args) {
		try {
			Scanner reader = new Scanner(new File("assemblyLanguage.txt"));
			Compiler compiler = new Compiler(reader);
			System.out.println(compiler.getMachineCode());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
