package kops.microprocessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Microprocessor {

	private StringBuilder output;
	private Scanner fileInput;
	private int index;
	private Accumulator accA;
	private Accumulator accB;
	private Memory memory;
	private int addressInDec;
	private Address address;
	private int tempInt;

	public Microprocessor(String string) throws FileNotFoundException {
		this.fileInput = new Scanner(new File(string));
		this.output = new StringBuilder();
		this.index = 0;
		this.accA = new Accumulator();
		this.accB = new Accumulator();
		this.memory = new Memory(fileInput.next());
	}

	public void run() {
		while (fileInput.hasNext()) {
			// execute instructions
			while (!memory.getContent(index).equals("8")) {
				switch (memory.getContent(index)) {

				// LD - load A with contents of memory with following address
				case "0":
					index++;
					address = new Address(memory.getContent(index++)
							+ memory.getContent(index++));
					this.addressInDec = getDecimal(address);
					this.accA.setWord(memory.getContent(addressInDec));
					System.out.println("Loaded A with "+memory.getContent(addressInDec)+"from address in dec"+addressInDec);
					break;

				// ST - write contents of A to memory with the following address
				case "1":
					index++;
					address = new Address(memory.getContent(index++)
							+ memory.getContent(index++));
					this.addressInDec = getDecimal(address);
					memory.setContent(addressInDec, accA.getWord());
					System.out.println("wrote "+accA.getWord()+"from A to address"+addressInDec);
					break;

				// SWP - swap contents of A and B
				case "2":
					index++;
					String tempWord = accA.getWord();
					accA.setWord(accB.getWord());
					accB.setWord(tempWord);
					System.out.println("Swapped a and b");
					break;

				// ADD - add contents of accumulators.
				// Put low word of sum in A and high word in B
				case "3":
					index++;
					int content1 = Integer.parseInt(accA.getWord(), 16);
					int content2 = Integer.parseInt(accB.getWord(), 16);
					int sum = content1 + content2;
					//convert into hex and place in accumulators
					String hexValue = Integer.toHexString(sum);
					String hexSumLow = hexValue.split("")[0];
					String hexSumHigh = hexValue.split("")[1];
					accA.setWord(hexSumHigh);
					accB.setWord(hexSumLow);
					System.out.println("added "+content1+"from a and "+content2+"from b...");
					System.out.println("and got "+hexSumLow+" "+hexSumHigh);
					break;

				// INC - increment A
				case "4":
					index++;
					String incrementHex;
					tempInt = Integer.parseInt(accA.getWord(), 16);
					tempInt++;
					if(tempInt == 16){
						incrementHex = "0";
					}
					else{
						incrementHex = Integer.toHexString(tempInt);
					}
					accA.setWord(incrementHex);					
					System.out.println("incremented a and got "+incrementHex);
					break;

				// DEC - decrement A
				case "5":
					index++;
					String decrementHex;
					tempInt = Integer.parseInt(accA.getWord(), 16);
					tempInt--;
					if(tempInt == -1){
						decrementHex = "F";
					}
					else{
						decrementHex = Integer.toHexString(tempInt);
					}
					accA.setWord(decrementHex);	
					System.out.println("decremented a and got "+decrementHex);
					break;

				// BZ - if A is 0, execute the command at following address
				case "6":
					index++;
					if(accA.getWord().equals("0")){
						address = new Address(memory.getContent(index++) + memory.getContent(index++));
						index = getDecimal(address);
						System.out.println("A was 0 so jumped to "+index);
					}
					else{	//ignore argument
						index += 2;
						System.out.println("A was not 0");
					}
					break;

				// BR - execute command at following address
				case "7":
					address = new Address(memory.getContent(++index) + memory.getContent(++index));
					index = getDecimal(address);	
					System.out.println("jumped to "+index);
					break;

				// STP stop the program
				case "8":
					System.out.println("Stopped execution");
					return;

				}
			}
			
			output.append(memory.getMemory()) ;
			output.append("\n");
			System.out.println(output.toString());
		}
		fileInput.close();

	}

	public int getDecimal(Address hex) {
		return Integer.parseInt(hex.getAddress(), 16);
	}

	public String getOutput() {
		return this.output.toString();
	}

}
