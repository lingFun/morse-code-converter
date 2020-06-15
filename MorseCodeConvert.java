package LingFangCSC221HW3;

//Ling Fang
//CSC221 Assignment 3
//MorseCodeConvert.java

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MorseCodeConvert {
	// ArrayList holds objects of type MorseCode
	final ArrayList<MorseCode> listMorseCode = new ArrayList<MorseCode>(); // Morse code arrayList
	
	//Non-default constructor 
	//Accepts file name as parameter
	public MorseCodeConvert(String fileName) throws FileNotFoundException{
		Scanner scanner = null;
		
		//Attempt to open the file
		try {
			scanner = new Scanner (new FileInputStream(new File(fileName)));
			//System.out.println("File open successful.");
			
			String line;
			String[] s;
			//Read file line by line and store the valid MorseCodes to the ArrayList
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				s = line.split("	");
				if( s.length == 2) {
					try {
						MorseCode mo = new MorseCode(s[0].charAt(0),s[1]);
						listMorseCode.add(mo);
					}
					catch (Exception e)
					{
			            //e.printStackTrace(); 
			            System.out.println(e);
					}
				}
				//Handle empty line
				else if( s[0].length() ==0 || s[0] == null) {
					System.out.println("Invalid line: Skipping empty line ");
				}
				//Display invalid line
				else {
					System.out.println("Invalid line: " + line);
				}
			}
		   }
		
		catch (FileNotFoundException e) {
			System.out.println("Failed to open file: " + fileName);
			//e.printStackTrace(); 
		}

		finally {
			if(scanner != null)
				scanner.close();
		}		
	}
	
	//Prints the entire content of the ArrayList
	public void printEncodingList() {
		for (MorseCode i : listMorseCode) {
			System.out.println("(\'" + Character.toString(i.getCharacter()) + "\', " + i.getEncoding() + ")");
		}
		
	}
	
	//Accepts a string parameter and prints the corresponding MorseCode for that string
	public void encodeString(String s) {
		//print empty line if pass an empty string
		if (s == "" || s == null )
			System.out.println("");
		
		//Encoding the string one by one character
		else {
			String encodeS = "";
			char[] chars = s.toCharArray();
			for(char i : chars) {
				//Skip the whitespace
				if(i == ' ')
					continue;
				else
					encodeS = encodeS.concat(encodeChar(i).concat(" "));
			}
			System.out.println(encodeS);
		}
	}
	
	//Accepts the file name as parameter and prints the corresponding MorseCode for the entire file's content
	public void encodeFile(String fileName) throws FileNotFoundException {
		Scanner scanner = null;
		//Attempt to open the file and encoding line by line
		try {
			scanner = new Scanner (new FileInputStream(new File(fileName)));
			System.out.println("File open successful.");
			String line = null;
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				encodeString(line);				
			}
		   }
		
		catch (FileNotFoundException | NullPointerException e) {
			System.out.println("Failed to open file: " + fileName);
			//e.printStackTrace(); 
		  }

		finally {
			if(scanner != null)
				scanner.close();
		}
	}
	
	//Accepts a character parameter and return the corresponding encoding string
	public String encodeChar(char c) {
		String e = "";
		
		if(Character.isLetter(c))
			c = Character.toUpperCase(c);
			

		for(MorseCode i : listMorseCode) {	
			if(c == i.getCharacter()) {
				e = i.getEncoding();
				break;
			}
		}
		
		//if char c is not in the listMorseCode, will display "?"
		if(e == "" || e == null)
			e = "?";
			
		return e;		
	}
}
