package kops.microprocessor;

import java.io.BufferedReader;

public class Memory {

	private String[] words;
	private StringBuilder wordsList;
		
	public Memory(BufferedReader in){
		wordsList = new StringBuilder();
		this.words = in.split("");
	}

	public String getMemory() {
		for(int i = 0; i < words.length; i++){
			wordsList.append(words[i]);
		}
		return wordsList.toString();
	}

	public void setContent(int index, String word) {
		words[index] = word;
	}
	
	public String getContent(int index){
		return words[index];
	}
	
	
}
