import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class Ultrasensor implements Runnable {
	Control control;
	/**
	 * Muuttuja joka sis‰lt‰‰ et‰isyyden mahdolliseen esteeseen.
	 */
	int etaisyys;
	UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S4);

	/**
	 * M‰‰ritt‰‰ hallintaolion viitteen
	 * 
	 * @param c
	 *            control olion viite
	 */
	public Ultrasensor(Control c) {
		this.control = c;
	}

	/**
	 * P‰ivitt‰‰ et‰isyys arvoa.
	 * 
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/UltrasonicSensor.html">lejos.util.lejos.nxt.UltrasonicSensor</a>
	 */
	private void updatesensor() {
		etaisyys = ultra.getDistance();
	}

	/**
	 * palauttaa et‰isyys arvon.
	 * 
	 * @return palauttaa et‰isyyden
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/UltrasonicSensor.html">lejos.util.lejos.nxt.UltrasonicSensor</a>
	 */
	public int getEtaisyys() {
		return etaisyys;
	}

	/**
	 * Esteen havaitsemis metodi
	 * 
	 * @return palauttaa boolean arvon, jolla havaitaan esteet.
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/UltrasonicSensor.html">lejos.util.lejos.nxt.UltrasonicSensor</a>
	 */
	public boolean getIsBlocked() {
		if (ultra.getDistance() <= 20) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Ultrasensorin s‰ie, joka p‰ivitt‰‰ sensorin arvoa.
	 * 
	 * @see java.lang.Runnable#run()
	 * @see <a
	 *      href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#run()">java.lang.Runnable#run()</a>
	 */
	public void run() {
		while (!control.getStop()) {
			updatesensor();
		}
	}

}
