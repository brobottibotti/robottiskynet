import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class Ultrasensor implements Runnable {
	Control control;
	int etaisyys;
	UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S4);

	public Ultrasensor(Control c) {
		this.control = c;
	}

	public void setobjects(Control c) {
		this.control = c;
	}

	private void updatesensor() {
		etaisyys = ultra.getDistance();
	}

	// etäisyyden asetus ja palautus metodi
	public int getEtaisyys() {
		return etaisyys;
	}

	public boolean getIsBlocked() {
		if (ultra.getDistance() <= 20) {
			return true;
		} else {
			return false;
		}
	}

	public void run() {
		while (!control.getStop()) {
			updatesensor();
		}
	}

}
