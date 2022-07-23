package net.mst.utilities.mathematical;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Picks random values of given collection or range
 */
public class Random {
	
	
	/**
	 * Returns an random integer in a range
	 * @param Start The starting point of the range
	 * @param End The end point of the range
	 * @return Integer between two given integer values
	 */
	public static Integer pick(Integer Start, Integer End) {
		
		return (int) (Math.random() * (End-Start+1) + Start);
		
	}
	
	/**
	 * Returns an random double in a range
	 * @param Start The starting point of the range
	 * @param End The end point of the range
	 * @return Double between two given double values
	 */
	public static Double pick(Double Start, Double End) {
		
		return (Math.random() * (End-Start) + Start);
		
	}
	
	/**
	 * Returns an random element of a collection
	 * @param Collection The collection with all values
	 * @param <T> Type of the objects
	 * @return Random element of collection
	 */
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
