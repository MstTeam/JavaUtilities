package net.mst.utilities.colors;

import java.util.HashMap;

import net.mst.utilities.strings.Editor;

public class Hex extends Color {
	
	private static HashMap<Character, Integer> hexadecimal = new HashMap<>();
	
	private String code = "";
	
	Hex(int r, int g, int b) {
		
		super(r, g, b);
		
	}
	
	public Hex(Integer ColorCode) {
		
		code = Integer.toHexString(ColorCode);
		
		autoFormat();
		toRGB(code);
		
	}
	
	public Hex(String ColorCode) {
		
		this.code = ColorCode;
		
		autoFormat();
		toRGB(code);
		
	}
	
	private void autoFormat() {
		
		code = Editor.edit(code.replace("#", "").replaceAll("[^0-9a-fA-F]", "0")).setLength(-6, '0');
		
		System.out.println(code);
		
	}
	
	private void toRGB(String code) {
		
		int[] positions = new int[6];
		
		for(int i = 0; i < code.length(); i++) {
			
			char ind = code.charAt(i);
			System.out.println(ind + " / " + ofHex(ind));
			positions[i] = ofHex(ind);
			
		}
		
		for(int i : positions) {
			
			System.out.println(i);
			
		}
			
		this.r = (positions[0] * 16) + positions[1];
		this.g = (positions[2] * 16) + positions[3];
		this.b = (positions[4] * 16) + positions[5];
		
	}
	
	private int ofHex(Character Character) {
		
		switch(Character) {
		
		case '0': return 0;
		case '1': return 1;
		case '2': return 2;
		case '3': return 3;
		case '4': return 4;
		case '5': return 5;
		case '6': return 6;
		case '7': return 7;
		case '8': return 8;
		case '9': return 9;
		case 'A': case 'a': return 10;
		case 'B': case 'b': return 11;
		case 'C': case 'c': return 12;
		case 'D': case 'd': return 13;
		case 'E': case 'e': return 14;
		case 'F': case 'f': return 15;
		
		}
		
		return 0;
		
	}

}
