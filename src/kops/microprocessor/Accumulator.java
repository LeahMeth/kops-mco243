package kops.microprocessor;

public class Accumulator {
	
	private char letter;
	//private Address address;
	private Word word;
	
	public Accumulator(char letter){
		this.letter = letter;
	}
	
	private void setWord(Address address){
		this.word = address.getContents();
	}
	
	private Word getWord(){
		return this.word;
	}
	

}
