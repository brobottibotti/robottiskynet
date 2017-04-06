import lejos.util.Stopwatch;

public class Time{

	private int endtime;
	Control control;
	Stopwatch stopwatch = new Stopwatch();

	// Ajan tulostus
	public Time(Control c) {
		this.control = c;
	}

	public int getTime() {
		return stopwatch.elapsed() / 1000;
	}

	public int endTime() {
		endtime = this.getTime();
		return endtime;
	}
	

}
