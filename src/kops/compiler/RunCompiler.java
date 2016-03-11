package kops.compiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class RunCompiler {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"assemblyLanguage.txt"));
			Compiler compiler = new Compiler(reader);
			System.out.println(compiler.getMachineCode());				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
