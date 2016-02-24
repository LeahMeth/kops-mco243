package kops.microprocessor;

import java.util.ArrayList;

public class Address {

	private char firstWord;
	private char secondWord;

	public Address(String string) {
		this.firstWord = string.charAt(0);
		this.secondWord = string.charAt(1);
	}

	public Word getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args){
		
		String string = "0102011311321128FF1E00000000000000000000000000000000000000000000000000000000000000000000000000000"+
				"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"+
				"00000000000000000000000000000000000000000000000000000000000000";
		char[] listw = string.toCharArray();
		System.out.println(listw.length);
	}
}
