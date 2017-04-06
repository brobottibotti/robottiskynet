public class Robotti {

	/**
	 * P‰‰luokka jossa k‰nnistet‰‰n color ja ultra sensor s‰ikeet ja kutsutaan
	 * USBReceiver metoria Receive.
	 * 
	 * @see <a
	 *      href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#run()">java.lang.Runnable#run()</a>
	 */
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
