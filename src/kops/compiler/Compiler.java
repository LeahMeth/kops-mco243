package kops.compiler;

import java.io.IOException;
import java.util.Scanner;

public class Compiler {

	private StringBuilder machineCode;
	private Scanner reader;
	
	public Compiler(Scanner reader) throws IOException {
		machineCode = new StringBuilder();
		this.reader = reader;
		while(reader.hasNext()){
			executeInstruction();
		}
		
	}
	
	private void executeInstruction() throws IOException {
		switch(reader.next()){
		case "LD":
			machineCode.append("0");
			machineCode.append(decToHex(reader.next()));
			System.out.println(machineCode.toString());
			break;
		case "ST":
			machineCode.append("1");
			machineCode.append(decToHex(reader.next()));
			System.out.println(machineCode.toString());
			break;
		case "SWP":
			machineCode.append("2");
			System.out.println(machineCode.toString());
			break;
		case "ADD":
			machineCode.append("3");
			System.out.println(machineCode.toString());
			break;
		case "INC":
			machineCode.append("4");
			System.out.println(machineCode.toString());
			break;
		case "DEC":
			machineCode.append("5");
			System.out.println(machineCode.toString());
			break;
		case "BZ":
			machineCode.append("6");
			machineCode.append(decToHex(reader.next()));
			System.out.println(machineCode.toString());
			break;
		case "BR":
			machineCode.append("7");
			machineCode.append(decToHex(reader.next()));
			System.out.println(machineCode.toString());
			break;
		case "STP":
			machineCode.append("8");
			System.out.println(machineCode.toString());
			break;
		case "DATA":
			while(reader.hasNext()){
				machineCode.append(reader.next());
			}
			break;	
		}
		
	}


	public String decToHex(String string){
		int decimal = Integer.parseInt(string);
		return Integer.toHexString(decimal).toUpperCase();
	}
	

	public String getMachineCode() {
		return machineCode.toString();
	}

}
