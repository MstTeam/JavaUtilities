package net.mst.utilities.timer;

public class TimerThread extends Thread {
	
	private boolean running = true;
	private boolean paused = false;
	
	private long interval;
	private int tempIntervalTimes = -1;
	private long tempInterval = -1;
	private Task task;
	
	public TimerThread(long Interval, Task Task) {
		
		this.interval = Interval;
		this.task = Task;
		
	}
	
	public void run() {
		
		waitTime(interval);
		
		while(running) {
			
			if(!paused) {
				
				long start = System.currentTimeMillis();
				
				task.execute();
				
				long tempLong = interval;
				
				if(tempIntervalTimes > 0) {
					
					tempIntervalTimes = tempIntervalTimes - 1;
					
					if(tempInterval > 0) {
						
						tempLong = tempInterval;
						
					}
					
				}
				
				tempLong = tempLong - (System.currentTimeMillis() - start);
					
				waitTime(tempLong);
				
			}
			
		}
		
		interrupt();
		
	}
	
	private void waitTime(long Milliseconds) {
		
		setPaused(true);
		
		long end = System.nanoTime() + (Milliseconds * 1000000);
		
		while(System.nanoTime() < end) {}
		
		setPaused(false);
		
	}
	
	public void cancel() {
		
		running = false;
		
	}
	
	public void setInterval(Long Interval, Integer Times) {
		
		if(Times > 0) {
			
			this.tempIntervalTimes = Times;
			this.tempInterval = Interval;
			
		}else {
			
			this.interval = Interval;
			
		}
		
	}
	
	public void setPaused(Boolean isPaused) {
		
		this.paused = isPaused;
		
	}

}
