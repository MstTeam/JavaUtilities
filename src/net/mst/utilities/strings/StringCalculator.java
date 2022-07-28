package net.mst.utilities.strings;

public class StringCalculator {
	
	public static String add(String... Summands) {
		
		String[] summands = prepareStrings(Summands);
			
		String solution = "";
		int rest = 0;
			
		for(int i = (summands[0].length() - 1); i >= 0; i--) {
			
			int i1 = (Character.getNumericValue(summands[0].charAt(i)) + rest);
			
			for(int pos = 1; pos < summands.length; pos++) {
				
				i1 += Character.getNumericValue(summands[pos].charAt(i));
				
			}
			
			if(i1 > 9) {
				
				rest = (i1 / 10);
				solution = (i1 % 10) + solution;
				
			}else {
				
				solution = i1 + solution;
				rest = 0;
				
			}
			
		}
		
		while(rest > 0) {
			
			if(rest > 9) {
				
				solution = (rest % 10) + solution;
				rest = (rest / 10);
				
			}else {
				
				solution = rest + solution;
				rest = 0;
				
			}
			
		}
		
		return solution;
		
	}
	
	private static String[] prepareStrings(String... RawStrings) {
		
		String[] stringArray = new String[RawStrings.length];
		
		int highest = 0;
		
		for(String string : RawStrings) {
			
			if(string.matches("[0-9]+")) {
				
				if(highest < string.length()) {
					
					highest = string.length();
					
				}
				
			}
			
		}
		
		for(int pos = 0; pos < RawStrings.length; pos++) {
			
			if(RawStrings[pos].matches("[0-9]+")) { 
				
				stringArray[pos] = Editor.edit(RawStrings[pos]).setLength(- (highest), '0');
				
			}
			
		}
		
		return stringArray;
		
	}

}
