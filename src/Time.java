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
	public void timer() {
		control.Printstring("Aika: ", 0, 6);
		control.Printint(stopwatch.elapsed() / 1000, 0, 7);
	}

	// timer säie, joka tulostaa aikaa.
	public void run() {
		while (!control.getStop()) {
			timer();
		}
	}

}
