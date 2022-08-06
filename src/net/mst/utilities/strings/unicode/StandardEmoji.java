package net.mst.utilities.strings.unicode;

public enum StandardEmoji {
	
	grinning ("U+1F600");
	
	private String escape = "";
	
	private StandardEmoji(String Unicode) {
		
		this.escape = Unicode;
		
	}
	
	public String getEscape() {
		
		return "\u20ac";
		
	}

}
