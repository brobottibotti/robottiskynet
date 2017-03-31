import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.util.Stopwatch;

public class Time implements Runnable {

	Control control;
	Stopwatch stopwatch = new Stopwatch();

	public void setobjects(Control c) {
		this.control = c;
	}

	// Ajan tulostus
	// vaihda print olioon
	// vaihda pilot luokkaan
	public Time(Control c) {
		this.control = c;
	}

	public int getTime() {
		return stopwatch.elapsed() / 1000;
	}

	public int endTime() {
		final int endtime = this.getTime();
		return endtime;

	}

	// timer säie, joka tulostaa aikaa.
	public void run() {
		// while (!control.getStop()) {

		// }
	}

}
