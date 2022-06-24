package net.mst.utilities.mathematical;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Random {
	
	public static Integer pick(Integer Start, Integer End) {
		
		return (int) (Math.random() * (End-Start+1) + Start);
		
	}
	
	public static Double pick(Double Start, Double End) {
		
		return (Math.random() * (End-Start) + Start);
		
	}
	
	public static <T> T pickOf(Collection<T> Collection) {
		
		if(Collection.isEmpty()) {
			
			return null;
			
		}
		
		List<T> tempList = new ArrayList<T>();
		Collection.forEach(element -> {
			
			tempList.add(element);
			
		});
		
		return tempList.get(pick(0, tempList.size() - 1));
		
	}

}
