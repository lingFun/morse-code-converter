package LingFangCSC221HW3;

//Ling Fang
//CSC221 Assignment 3
//MorseCode.java

public class MorseCode {

	private char character;
	private String encoding;
	
	//Non-default constructor
	//Only accepts char values of ASCII between 32 and 90
	MorseCode(char character, String encoding) throws Exception {
		if( character < 32 || character > 90 || encoding==null || encoding.length()<1) {
			throw new Exception("The character " + character + " is not a supported Morse character.");
		}
		else {
			this.character = character;
			this.encoding = encoding;
		}
	}
	
	//2 setters and 2 getters
	public char getCharacter() {
		
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	
}
