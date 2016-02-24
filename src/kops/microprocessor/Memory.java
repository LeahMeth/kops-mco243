package kops.microprocessor;

public class Memory {

	private Address address;
	private char contents;
	
	public Memory(Address address){
		this.address = address;
	}

	public char getContents() {
		return contents;
	}

	public void setContents(char contents) {
		this.contents = contents;
	}
	
	
}
