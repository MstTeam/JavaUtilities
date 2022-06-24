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
