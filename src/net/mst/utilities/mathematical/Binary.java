package net.mst.utilities.mathematical;

import java.util.Arrays;

import net.mst.utilities.strings.Editor;

public class Binary {
	
	private String binary;

	public Binary(String Binary) {
		
		this.binary = format(Binary);
		
	}
	
	public static String fromDecimal(Integer Decimal) {
		
		String binaryString = "";
		
		while(Decimal > 0) {
			
			binaryString = (Decimal % 2) + binaryString;
			
			Decimal /= 2;
			
		}
		
		return binaryString;
		
	}
	
	public long toDecimal() {
		
		long value = 0;
		long currentValue = 1;
		
		for(int i = binary.length() - 1; i >= 0; i--) {
			
			switch(binary.charAt(i)) {
			
				case '1': value += currentValue;
			
			}
			
			currentValue *= 2;
			
		}
		
		return value;
		
	}
	
	public String[] splitBytes(Integer ByteLength) {
		
		return splitBytes(ByteLength, true);
		
	}
	
	public String[] splitBytes(Integer ByteLength, Boolean allowFirstNull) {
		
		String bin = Editor.edit(binary).setLength(-(binary.length() + (ByteLength-(binary.length() % ByteLength))), '0');
		
		String[] array = new String[bin.length() / ByteLength];
		
		for(int i = 0; i < (bin.length() / ByteLength); i++) {
			
			array[i] = bin.substring((i*ByteLength), (i*ByteLength) + ByteLength);
			
		}
		
		if(!allowFirstNull) {
			if(array[0].equals("0000")) {
				return Arrays.copyOfRange(array, 1, array.length);
			}
		}
		
		return array;
		
	}
	
	public Binary addBinary(Binary Binary) {
		
		int length = Binary.getBinary().length();
		if(binary.length() > length) {
			
			length = binary.length();
			
		}
		
		String summand = Editor.edit(Binary.getBinary()).setLength(-length, '0');
		
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
	
	public String getBinary() {
		
		return binary;
		
	}
	
	public static String format(String String) {
		
		String formatted = String.replaceAll("[^0-1]", "");
		
		if(formatted.equals("")) {
			return "0";
		}
		
		return formatted;
		
	}
	
	public static String isHigher(String Higher, String Lower) {
		
		
		
	}

}
