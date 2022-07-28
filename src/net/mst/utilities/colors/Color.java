package net.mst.utilities.colors;

public class Color {
	
	protected int r;
	protected int g;
	protected int b;
	
	public Color(int Red, int Green, int Blue) {
		
		this.r = Red;
		this.g = Green;
		this.b = Blue;
		
		autoFormat();
		
	}
	
	Color() {
		
		
		
	}
	
	public static Color of(int Red, int Green, int Blue) {
		
		return new Color(Red, Green, Blue);
		
	}
	
	public int getR() {
		
		return this.r;
		
	}
	
	public int getG() {
		
		return this.g;
		
	}
	
	public int getB() {
		
		return this.b;
		
	}
	
	public Hex toHex() {
		
		return new Hex(this.r, this.g, this.b);
		
	}
	
	public String toArray() {
		
		return String.format("{\"r\":%s, \"g\":%s, \"b\":%s}", this.r, this.g, this.b);
		
	}
	
	private void autoFormat() {
		
		if(this.r > 255) {
			
			this.r = 255;
			
		}
		
		if(this.g > 255) {
			
			this.r = 255;
			
		}

		if(this.b > 255) {
	
			this.r = 255;
	
		}
		
	}

}
