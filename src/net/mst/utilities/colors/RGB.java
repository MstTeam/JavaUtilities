package net.mst.utilities.colors;

public class RGB extends Color {
	
	private RGB(int r, int g, int b) {
		
		super(r, g, b);
		
	}
	
	public static RGB of(int Red, int Green, int Blue) {
		
		return new RGB(Red, Green, Blue);
		
	}

}
