package net.mst.utilities.timer;

public class DelayedAction extends Thread {
	
	private DelayedActionThread thread;
	
	public DelayedAction(Task Task, long Interval) {
		
		thread = new DelayedActionThread(Task, Interval);
		
		thread.start();
		
	}
	
	public DelayedAction(Task Task, long Interval, TimerUnit TimerUnit) {
		
		thread = new DelayedActionThread(Task, TimerUnit.getMilliseconds(Interval));
		
		thread.start();
		
	}

}

class DelayedActionThread extends Thread {
	
	private Task task;
	private long delay = 0;
	
	DelayedActionThread(Task Task, long Interval) {
		
		this.task = Task;
		this.delay = Interval;
		
	}
	
	@Override
	public void run() {
		
		long end = System.currentTimeMillis() + delay;
		
		while(System.currentTimeMillis() < end) {}
		
		task.execute();
		
	}
	
}