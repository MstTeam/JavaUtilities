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
		
		try {
			sleep(interval);
		} catch (InterruptedException e1) {
			//
		}
		
		while(running) {
			
			long startMillis = System.currentTimeMillis();
			
			task.execute();
			
			if(!paused) {
				
				long tempLong = interval;
				
				if(tempIntervalTimes > 0) {
					
					tempIntervalTimes = tempIntervalTimes - 1;
					
					if(tempInterval > 0) {
						
						tempLong = tempInterval;
						
					}
					
				}
				
				tempLong = tempLong - (System.currentTimeMillis() - startMillis);
				
				try {
					sleep(tempLong);
				} catch (InterruptedException e) {
					//
				}
				
			}
			
		}
		
		interrupt();
		
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
