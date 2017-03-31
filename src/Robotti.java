import java.io.File;

import lejos.nxt.Button;
import lejos.nxt.remote.NXTCommand;

public class Robotti {

	public static void main(String[] args) {

		Control control = new Control();
		Thread timer = new Thread(control.time);
		timer.start();
		Thread color = new Thread(control.colorsensor);
		color.start();
		// p‰‰looppi
		while (!control.getStop()) {
			control.Pilot();
		}

	}

}
