package net.mst.utilities.timer;

public class Timer {
	
	private TimerThread thread;
	private boolean highPrecision = false;
	
	public Timer() {
		
		
		
	}
	
	public Timer(boolean enableHighPrecision) {
		
		this.highPrecision = true;
		
	}
	
	public Timer schedule(Task Task, long Interval) {
		
		Task.setTimer(this);
		
		thread = new TimerThread(Interval, Task, highPrecision);
		
		thread.start();
		
		return this;
		
	}
	
	public Timer schedule(Task Task, long Interval, TimerUnit TimeUnit) {
		
		Task.setTimer(this);
		
		thread = new TimerThread(TimeUnit.getMilliseconds(Interval), Task, highPrecision);
		
		thread.start();
		
		return this;
		
	}
	
	public Timer setInterval(Long Interval) {
		
		thread.setInterval(Interval, -1);
		
		return this;
		
	}
	
	public Timer setTempInterval(Long Interval, Integer Rotations) {
		
		thread.setInterval(Interval, Rotations);
		
		return this;
		
	}
	
	public void cancel() {
		
		thread.cancel();
		
	}
	
	public Timer setTask(Task Task) {
		
		this.thread.setTask(Task);
		
		return this;
		
	}
	
	public Timer pause() {
		
		this.thread.setPaused(true);
		
		return this;
		
	}
	
	public Timer resume() {
		
		this.thread.setPaused(false);
		
		return this;
		
	}

}

class TimerThread extends Thread {
	
	private boolean running = true;
	private boolean paused = false;
	
	private long interval;
	private int tempIntervalTimes = -1;
	private long tempInterval = -1;
	private Task task;
	
	private boolean highPrecision = false;
	
	public TimerThread(long Interval, Task Task) {
		
		this.interval = Interval;
		this.task = Task;
		
	}
	
	public TimerThread(long Interval, Task Task, boolean highPrecision) {
		
		this.interval = Interval;
		this.task = Task;
		this.highPrecision = highPrecision;
		
	}
	
	@Override
	public void run() {
		
		waitTime(interval);
		
		while(running) {
			
			if(!paused) {
				
				long start = System.currentTimeMillis();
				
				task.execute();
				
				if(tempIntervalTimes > 0) {
					
					tempIntervalTimes = tempIntervalTimes - 1;
					
					if(tempInterval > 0) {
						
						waitTime(tempInterval - (System.currentTimeMillis() - start));
						
					}
					
				}else {
					
					waitTime(interval - (System.currentTimeMillis() - start));
					
				}
				
			}
			
		}
		
		interrupt();
		
	}
	
	private void waitTime(long Milliseconds) {
		
		if(highPrecision) {
			
			setPaused(true);
			
			long end = System.nanoTime() + (Milliseconds * 1000000);
			
			while(System.nanoTime() < end) {}
			
			setPaused(false);
			
		}else {
			
			try {
				sleep(Milliseconds);
			} catch (InterruptedException e) {
				//
			}
			
		}
		
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
	
	public void setTask(Task Task) {
		
		this.task = Task;
		
	}

}
