package net.mst.utilities.colors;

public class Hex {
	
	private String code = "";
	
	public Hex(Integer ColorCode) {
		
		this.code = Integer.toString(ColorCode, 16);
		
		System.out.println(code);
		
	}
	
	public Hex(String ColorCode) {
		
		this.code = ColorCode;
		
	}

}
