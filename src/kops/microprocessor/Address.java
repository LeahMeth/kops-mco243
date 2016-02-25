package kops.microprocessor;

public class Address {

	private char firstWord;
	private char secondWord;
	private String address;

	public Address(String string) {
		this.address = string;
		this.firstWord = string.charAt(0);
		this.secondWord = string.charAt(1);
	}

	public String getAddress() {
		return this.address;
	}

	public char getFirstWord() {
		return firstWord;
	}

	public char getSecondWord() {
		return secondWord;
	}

	
}
