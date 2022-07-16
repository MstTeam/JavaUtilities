package net.mst.utilities.randomstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import net.mst.utilities.mathematical.Random;

public class RandomString {
	
	private Integer length;
	private HashSet<Character> charset;
	
	public RandomString(Integer Length, HashSet<Character> Charset) {
		
		this.length = Length;
		this.charset = Charset;
		
	}
	
	public List<String> getOptions() {
		
		List<String> options = new ArrayList<>();
		
		for(Character character : charset) {
			
			options.add(String.valueOf(character));
			
		}
		
		for(int i = 1; i < length; i++) {
			
			options = generateNext(options);
			
		}
		
		return options;
		
	}
	
	private List<String> generateNext(List<String> original) {
		
		List<String> tempList = new ArrayList<String>();
		
		for(String string : original) {
			
			for(Character character : charset) {
				
				tempList.add(string + character);
				
			}
			
		}
		
		return tempList;
		
	}
	
	public long getOptionCount() {
		
		return (long) Math.pow(charset.size(), length);
		
	}
	
	public String generateRandom() {
		
		String tempString = "";
		
		for(int i = 0; i < length; i++) {
			
			tempString = tempString + Random.pickOf(charset);
			
		}
		
		return tempString;
		
	}

}
