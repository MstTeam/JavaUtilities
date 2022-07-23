package net.mst.utilities.mathematical;

import java.text.DecimalFormat;
import java.util.Collection;

/**
 * Calculates the average of numbers and returns the rounded result as a double
 */

public class Average {
	
	private Average() {}
	
	/**
	 * Returns the average of a collection of <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Number.html">numbers</a> 
	 * @param Numbers Collection of <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Number.html">numbers</a> 
	 * @return Average as double
	 */
	
	public static double from(Collection<Number> Numbers) {
		
		return getAverage(Numbers);
		
	}
	
	/**
	 * Returns the average of a collection of numbers with 
	 * @param Numbers Collection of Numbers
	 * @return Average as double
	 */
	
	public static double from(Collection<Number> Numbers, Integer RoundingDigits) {
		
		double tempDouble = getAverage(Numbers);
		
		if(RoundingDigits < 0) {
			
			return tempDouble;
			
		}
		
		String format = "0.0";
		
		for(int i = 0; i < RoundingDigits; i++) {
			
			format = format + "0";
			
		}

		return Double.valueOf(new DecimalFormat(format).format(tempDouble).replace(",", "."));
		
	}
	
	private static double getAverage(Collection<Number> Numbers) {
			
		double average = 0;
			
		if(Numbers.isEmpty()) {
				
			return average;
				
		}
			
		for(Number value : Numbers) {
				
			average = average + value.doubleValue();
				
		}
			
		return average / Numbers.size();
			
	}

}
