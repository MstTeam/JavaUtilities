package net.mst.utilities.mathematical.formats;

import net.mst.utilities.mathematical.Binary;

public enum HexChar {
	
	TEN        ("A", 10),
	ELEVEN     ("B", 11),
	TWELVE     ("C", 12),
	THIRTEEN   ("D", 13),
	FOURTEEN   ("E", 14),
	FIFTEEN    ("F", 15);
	
	private String hexValue = "";
	private int decimal = 0;
	
	private HexChar(String hexValue, int decimal) {
		
		this.hexValue = hexValue;
		this.decimal = decimal;
		
	}
	
	static String ofDecimal(long Decimal) {
		
		long dec = Decimal;
		
		if(dec < 10) {
			return String.valueOf(dec);
		}else {
			
			for(HexChar number : HexChar.values()) {
				if(number.decimal == dec) {
					
					return number.hexValue;
					
				}
			}
			
		}
		
		return "0";
		
	}
	
	static String ofBinary(String BinaryString) {
		
		return ofDecimal(new Binary(BinaryString).toDecimal());
		
	}
	
	static String getBinary(String Char) {
		
		for(HexChar number : HexChar.values()) {
			
			if(number.hexValue.equals(Char)) {
				return Binary.fromDecimal(number.decimal);
			}
			
		}
		
		if(Integer.valueOf(Char) < 10) {
			return Binary.fromDecimal(Integer.valueOf(Char));
		}
		
		return "0";
		
	}

}
