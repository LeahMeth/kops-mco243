package kops.microprocessor;

public class Memory {

	private String[] words;
		
	public Memory(String input){
		this.words = input.split("");
	}

	public String[] getMemory() {
		return words;
	}

	public void setContent(int index, String word) {
		//CONVERT FROM HEX TO DECIMAL
		//int addressToDecimal = address.getAddress();
		//this.words[addressToDecimal] = word;
		words[index] = word;
	}
	
	public String getContent(int index){
		return words[index];
	}
	
	
}
