package net.mst.utilities.timer;

public class Timer {
	
	private TimerThread thread;
	private boolean highPrecision = false;
	
	public Timer() {
		
		
		
	}
	
	public Timer(boolean enableHighPrecision) {
		
		this.highPrecision = true;
		
	}
	
	public void schedule(Task Task, long Interval) {
		
		Task.setTimer(this);
		
		thread = new TimerThread(Interval, Task, highPrecision);
		
		thread.start();
		
	}
	
	public void schedule(Task Task, long Interval, TimeUnit TimeUnit) {
		
		Task.setTimer(this);
		
		thread = new TimerThread(TimeUnit.getMilliseconds(Interval), Task, highPrecision);
		
		thread.start();
		
	}
	
	public void setInterval(Long Interval) {
		
		thread.setInterval(Interval, -1);
		
	}
	
	public void setTempInterval(Long Interval, Integer Rotations) {
		
		thread.setInterval(Interval, Rotations);
		
	}
	
	public void cancel() {
		
		thread.cancel();
		
	}
	
	public void pause() {
		
		this.thread.setPaused(true);
		
	}
	
	public void resume() {
		
		this.thread.setPaused(false);
		
	}

}
