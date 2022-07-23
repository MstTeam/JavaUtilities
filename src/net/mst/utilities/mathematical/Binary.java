package net.mst.utilities.mathematical;

import exceptions.FormatException;
import net.mst.utilities.strings.StringEditor;

public class Binary {
	
	private String binary;

	public static Binary fromDecimal(Integer Decimal) {
		
		String binaryString = "";
		
		while(Decimal > 0) {
			
			binaryString = (Decimal % 2) + binaryString;
			
			Decimal /= 2;
			
		}
		
		return new Binary(binaryString);
		
	}
	
	public static Binary fromBinary(String Binary) {
		
		if(!Binary.matches("[0-1]+")) {
			
			throw new FormatException("Binary must only contain valid binary numbers (0/1)");
			
		}
		
		return new Binary(Binary);
		
	}
	
	private Binary(String Binary) {
		
		this.binary = Binary;
		
	}
	
	public String returnBinaryString() {
		
		return binary;
		
	}
	
	public String toDecimal() {
		
		String[] array = new String[] {};
		
		int currentValue = 1;
		
		for(int i = binary.length() - 1; i >= 0; i--) {
			
			switch(binary.charAt(i)) {
			
				//case '0': array[array.length] = 
				case '1': 
			
			}
			
			currentValue *= 2;
			
		}
		
		return "";
		
	}
	
	public Binary addBinary(Binary Binary) {
		
		int length = Binary.returnBinaryString().length();
		if(binary.length() > length) {
			
			length = binary.length();
			
		}
		
		String summand = StringEditor.edit(Binary.returnBinaryString()).setLength(-length, '0');
		
		String solution = "";
		String rest = "";
		
		for(int i = (length - 1); i >= 0; i--) {
			
			String sum = (rest + binary.charAt(i) + summand.charAt(i)).replace("0", "");
			
			rest = "";
			
			switch(sum) {
			
				case "111":					solution = 1 + solution; rest += 1; break;
				case "11":					solution = 0 + solution; rest += 1; break;
				case "1":					solution = 1 + solution; break;
				default: 					solution = 0 + solution; break;
			
			}
			
		}
		
		if(rest != "") {
			
			solution = rest + solution;
			
		}
		
		return new Binary(solution);
		
	}

}
