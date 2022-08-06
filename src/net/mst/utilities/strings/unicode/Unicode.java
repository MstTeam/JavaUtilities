package net.mst.utilities.strings.unicode;

import net.mst.utilities.mathematical.Binary;
import net.mst.utilities.mathematical.formats.HexDec;
import net.mst.utilities.strings.Editor;

public class Unicode {
	
	private String code = "";
	
	private Unicode(String code) {
		
		this.code = code.replaceAll("(U\\+)", "");
			
	}
	
	public static Unicode fromCode(String Code) {
		return new Unicode(Code);
	}
	
	
	private String formatCode() {
		if(code.length() >= 5) {
			return code.substring(1);
		}
		return code;
	}
	
	private String binary() {
		return Editor.skip(HexDec.getBinary(formatCode()), '0');
	}
	
	private String rawBinary() {
		return Editor.skip(HexDec.getBinary(code), '0');
	}
	
	public String formatHex(UTFType Type) {
		return formatHex(Type, true);
	}
	
	public String formatHex(UTFType Type, boolean withSurrogate) {
		return HexDec.ofBinary(formatBinary(Type, withSurrogate), true);
	}
	
	public String formatBinary(UTFType Type) {
		return formatBinary(Type, true);
	}
	
	public String formatBinary(UTFType Type, boolean withSurrogate) {
		
		String binaryFormatted = Binary.format(rawBinary());
		
		schemes bcode = null;
		for(schemes bc : Type.codes) {
			
			if(bc.freeBits >= binaryFormatted.length()) {	
				bcode = bc;
				break;	
			}
			
		}
		
		String codePoint = "";
		
		if(withSurrogate) {
			codePoint = Editor.edit(binary()).setLength(-(bcode.freeBits), '0');
		}else {
			codePoint = Editor.edit(rawBinary()).setLength(-(bcode.freeBits), '0');
		}
		
		return Editor.edit(bcode.binaryUTF).replace('x', codePoint).replace(" ", "");
		
	}
			
}