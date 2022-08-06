package net.mst.utilities.mathematical.formats;

import net.mst.utilities.mathematical.Binary;
import net.mst.utilities.strings.Editor;

public class HexDec {
	
	public static String ofBinary(String Binary) {
		
		return ofBinary(Binary, false);
		
	}
	
	public static String ofBinary(String Binary, boolean allowFirstNull) {
		
		String[] binary = new Binary(Binary).splitBytes(4, false);
		
		String hexString = "";
		
		for(int i = 0; i < binary.length; i++) {
			
			if(!allowFirstNull) {
				if(i == 0 && binary[i].equals("0000")) {
					continue;
				}
			}
			
			hexString += HexChar.ofBinary(binary[i]);
			
		}
		
		return hexString;
		
	}
	
	public static String ofDecimal(long Decimal) {
		
		String hexString = "";
		
		long divisor = Decimal;
		
		while(divisor / 16 > 0) {
			hexString = HexChar.ofDecimal(divisor % 16) + hexString;
			divisor = divisor / 16;
		}
		
		return hexString;
		
	}
	
	public static String getBinary(String HexDec) {
		
		String binary = "";
		HexDec.replaceAll("[^0-9a-fA-F]", "");
		
		for(int i = 0; i < HexDec.length(); i++) {
			
			binary += Editor.edit(HexChar.getBinary(String.valueOf(HexDec.charAt(i)))).setLength(-4, '0');
			
		}
		
		return binary;
		
	}

}
