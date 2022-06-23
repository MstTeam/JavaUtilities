package net.mst.utilities.timer;

public class Timer {
	
	private TimerThread thread;
	
	public Timer() {
		
		
		
	}
	
	public void schedule(Task Task, long Interval) {
		
		Task.setTimer(this);
		
		thread = new TimerThread(Interval, Task);
		
		thread.start();
		
	}
	
	public void setInterval(Long Interval) {
		
		thread.setInterval(Interval, -1);
		
	}
	
	/*private void setTempInterval(Long Interval, Integer Rotations) {
		
		thread.setInterval(Interval, Rotations);
		
	}
	*/
	
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
