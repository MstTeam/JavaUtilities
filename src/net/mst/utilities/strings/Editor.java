package net.mst.utilities.strings;

public class Editor {
	
	private String raw = "";
	
	public Editor(String Raw) {
		
		this.raw = Raw;
		
	}
	
	public static Editor edit(String Raw) {
		
		return new Editor(Raw);
		
	}
	
	public static String connect(Character Connector, String... Strings) {
		
		String connectedString = "";
		
		for(String string : Strings) {
			
			connectedString += string + Connector;
			
		}
		
		return connectedString;
		
	}
	
	public String setLength(Integer Length, Character Filler) {
		
		if(Length < 0) {
			
			for(int i = (Length + raw.length()); i < 0; i++) {
				
				raw = Filler + raw;
				
			}
			
		}
		
		if(Length <= this.raw.length() && Length >= 0) {
			
			return raw.substring(0, Length);
			
		}
		
		if(Length > raw.length()) {
			
			for(int i = raw.length(); i < Length; i++) {
				
				raw += Filler;
				
			}
			
		}
		
		return raw;
		
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
			
			String insert = insertedStrings[insertedStrings.length - 1];
			
			if(count < insertedStrings.length) {
				insert = insertedStrings[count];
			}

			String[] tempArray = {raw.substring(0, i), raw.substring(i, raw.length())};
			raw = String.join("", tempArray[0], insert, tempArray[1]);
			i += (insert.length());
			
			i += (Interval - 1);
			
			count++;
			
		}
		
		return this.raw;
		
	}

}
