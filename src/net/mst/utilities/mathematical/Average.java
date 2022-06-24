package net.mst.utilities.mathematical;

import java.text.DecimalFormat;
import java.util.Collection;

public class Average {
	
	public static double from(Collection<Number> Numbers) {
		
		return getAverage(Numbers);
		
	}
	
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
