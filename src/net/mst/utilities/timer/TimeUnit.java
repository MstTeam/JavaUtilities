package net.mst.utilities.timer;

public enum TimeUnit {
	
	SECONDS (1000),
	MINUTES (60*1000),
	HOURS (60*60*1000);
	
	private long msPer = 0;
	
	private TimeUnit(long msPer) {
		
		
		
	}
	
	public long getMilliseconds(long Number) {
		
		return this.msPer * Number;
		
	}

}
