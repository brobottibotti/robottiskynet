import lejos.nxt.Button;

public class Robotti {
	public static boolean stop = false;

	public static void main(String[] args) {

		// olioiden alustus
		Control control = new Control();
		Steering steering = new Steering();
		Time time = new Time();
		Colorsensor colorsensor = new Colorsensor();
		Pilot pilot = new Pilot();
		Printer printer = new Printer();
		Ultrasensori ultrasensor = new Ultrasensori();

		// eri luokkiin l‰hetett‰v‰t olioiden arvot
		control.setobjects(time, steering, colorsensor, printer, pilot,
				ultrasensor);
		steering.setobjects(control);
		time.setobjects(control);
		colorsensor.setobjects(control);
		printer.setobjects(control);
		pilot.setobjects(control);
		ultrasensor.setobjects(control);

		Thread timer = new Thread(time);
		timer.start();
		Thread color = new Thread(colorsensor);
		color.start();
		// p‰‰looppi
		while (!stop) {
			control.Pilot();
		}

	}

	// sammutus metodi
	public static void setStop() {
		stop = !stop;
	}

}
