package net.mst.utilities.timer;

public enum TimerUnit {
	
	SECONDS (1000),
	MINUTES (60*1000),
	HOURS (60*60*1000);
	
	private long msPer = 0;
	
	private TimerUnit(long msPer) {
		
		this.msPer = msPer;
		
	}
	
	public long getMilliseconds(long Number) {
		
		return this.msPer * Number;
		
	}

}
