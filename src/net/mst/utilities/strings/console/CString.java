package net.mst.utilities.strings.console;

import net.mst.utilities.colors.Color;

public class CString {
	
	private static final String ASCII_RESET = "\033[0m";
	private static final String ASCII_CLEAR = "\033[2J";
	
	public static String format(Color Color) {
		
		return String.format("\033[38;2;%s;%s;%sm", Color.getR(), Color.getG(), Color.getB());
		
	}
	
	public static String sequence(Color Color, String Message) {
		
		return ASCII_RESET + String.format("\033[38;2;%s;%s;%sm", Color.getR(), Color.getG(), Color.getB()) + Message + ASCII_RESET;
		
	}
	
	public static String reset() {
		return ASCII_RESET;
	}
	
	public static String clear() {
		return ASCII_CLEAR;
	}

}
