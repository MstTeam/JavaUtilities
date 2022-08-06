package net.mst.utilities.strings.unicode;

public enum UTFType {

	UTF8 (schemes.UTF8_1, schemes.UTF8_2, schemes.UTF8_3, schemes.UTF8_4),
	UTF16 (schemes.UTF16_bmp, schemes.UTF16_overbmp),
	UTF32;
	
	schemes[] codes;
	
	private UTFType(schemes... byteCodes) {
		
		this.codes = byteCodes;
		
	}
	
}

enum schemes {
	
	UTF8_1 ("0xxxxxxx", 7),
	UTF8_2 ("110xxxxx 10xxxxxx", 11),
	UTF8_3 ("1110xxxx 10xxxxxx 10xxxxxx", 16),
	UTF8_4 ("11110xxx 10xxxxxx 10xxxxxx 10xxxxxx", 21),
	
	UTF16_bmp ("xxxxxxxx xxxxxxxx", 16),
	UTF16_overbmp ("110110xx xxxxxxxx 110111xx xxxxxxxx", 20);
	
	String binaryUTF = "";
	Integer freeBits = 0;
	
	private schemes(String BinaryUTF, Integer FreeBits) {
		
		this.binaryUTF = BinaryUTF;
		this.freeBits = FreeBits;
		
	}
}
