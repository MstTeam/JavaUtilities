package net.mst.utilities.timer;

public abstract class Task {
	
	private Timer timer;
	
	public Task() {
		
		
		
	}

	public abstract void execute();
	
	public void cancel() {
		
		this.timer.cancel();
		
	}
	
	public void setInterval(Long Interval) {
		
		this.timer.setInterval(Interval);
		
	}
	
	public void setTimer(Timer Timer) {
		
		this.timer = Timer;
		
	}
	
	public void pause() {
		
		this.timer.pause();
		
	}
	
	public void resume() {
		
		this.timer.resume();
		
	}
	
	public void setTask(Task Task) {
		
		this.timer.setTask(Task);
		
	}
	
}

