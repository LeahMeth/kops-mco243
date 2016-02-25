package kops.microprocessor;

public class Accumulator {
	
	private String word;
	
	public Accumulator(){
		this.word = "0"; 	//default
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	public String getWord(){
		return this.word;
	}
	

}
