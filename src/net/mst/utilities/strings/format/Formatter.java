package net.mst.utilities.strings.format;

import java.io.File;
import java.util.ArrayList;

import net.mst.utilities.strings.Editor;

public class Formatter {
	
	public static String getFileExtension(File File) {
		
		String[] array = File.getName().split(".");
		
		return array[array.length - 1];
		
	}
	
	public static String getFileName(File File) {
		
		ArrayList<String> arrayList = new ArrayList<>();
		
		for(String string : File.getName().split("\\.")) {
			
			arrayList.add(string);
			
		}
		
		arrayList.remove(arrayList.size() - 1);
		
		String[] array = new String[arrayList.size()];
		array = arrayList.toArray(array);
		
		return Editor.connect('.', array);
		
	}

}
