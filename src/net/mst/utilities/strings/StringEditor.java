package net.mst.utilities.strings;

public class StringEditor {
	
	private String raw = "";
	
	public StringEditor(String Raw) {
		
		this.raw = Raw;
		
	}
	
	public static StringEditor edit(String Raw) {
		
		return new StringEditor(Raw);
		
	}
	
	public String setLength(Integer Length, Character Filler) {
		
		if(Length < 0) {
			
			for(int i = (Length + raw.length()); i < 0; i++) {
				
				this.raw = Filler + this.raw;
				
			}
			
			return this.raw;
			
		}
		
		if(raw.length() > Length) {
			
			this.raw = raw.substring(0, Length);
			return this.raw;
			
		}
		
		if(raw.length() < Length) {
			
			for(int i = 0; i < (Length - raw.length()); i++) {
				
				this.raw += Filler;
				
			}
			
			return this.raw;
			
		}
		
		return this.raw;
		
	}
	
	public String insertAtIndex(String insertedString, Integer Index) {
		
		String[] tempArray = {raw.substring(0, Index), raw.substring(Index, raw.length() - 1)};
		raw = String.join("", tempArray[0], insertedString, tempArray[1]);
		
		return this.raw;
		
	}
	
	public String insertAtInterval(String insertedString, Integer Interval) {
		
		for(int i = 0; i <= raw.length(); i++) {
			
			if(i > raw.length()) {continue;}

			String[] tempArray = {raw.substring(0, i), raw.substring(i, raw.length())};
			raw = String.join("", tempArray[0], insertedString, tempArray[1]);
			i += (insertedString.length());
			
			i += (Interval - 1);
			
		}
		
		return this.raw;
		
	}
	
	public String insertAtInterval(Integer Interval, String... insertedStrings) {
		
		int count = 0;
		
		for(int i = 0; i <= raw.length(); i++) {
			
			if(i > raw.length()) {continue;}

			String[] tempArray = {raw.substring(0, i), raw.substring(i, raw.length())};
			raw = String.join("", tempArray[0], insertedStrings[count], tempArray[1]);
			i += (insertedStrings[count].length());
			
			i += (Interval - 1);
			
			count++;
			
		}
		
		return this.raw;
		
	}

}
