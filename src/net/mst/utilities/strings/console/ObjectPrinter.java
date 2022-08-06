package net.mst.utilities.strings.console;

public class ObjectPrinter {
	
	public static <T> String print(T[] Array) {
		
		String returnString = "";
		
		for(T t : Array) {
			
			returnString += ", " + t.toString();
			
		}
		
		if(returnString.equals("")) {
			return "[]";
		}
		
		return "[" + returnString.substring(2) + "]";
		
	}

}
