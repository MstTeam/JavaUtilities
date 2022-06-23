package net.mst.utilities.timer;

public abstract class Task implements Runnable {
	
	private Timer timer;
	
	public Task() {
		
		
		
	}

	@Override
	public abstract void execute();
	
	public void cancel() {
		
		this.timer.cancel();
		
	}
	
	public void setInterval(Long Interval) {
		
		this.timer.setInterval(Interval);
		
	}
	
	/*public void setTempInterval(Long Interval, Integer Rotations) {
		
		this.timer.setTempInterval(Interval, Rotations);
		
	}*/
	
	public void setTimer(Timer Timer) {
		
		this.timer = Timer;
		
	}
	
	public void pause() {
		
		this.timer.pause();
		
	}
	
	public void resume() {
		
		this.timer.resume();
		
	}
	
}
