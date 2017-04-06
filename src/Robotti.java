public class Robotti {

	public static void main(String[] args) {
		Control control = new Control();
		Thread color = new Thread(control.colorsensor);
		control.Receive();
		Thread ultra = new Thread(control.ultrasensor);

		color.start();
		ultra.start();
		// p‰‰looppi
		while (!control.getStop()) {
			control.Pilot();
		}

	}

}
