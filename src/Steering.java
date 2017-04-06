import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Steering {

	Control control;

	/**
	 * @see <a
	 *      href="lejos.robotics.navigation.DifferentialPilot">lejos.robotics.navigation.DifferentialPilot</a>
	 */
	private DifferentialPilot diffpilot = new DifferentialPilot(2.2f, 4.7f,
			Motor.A, Motor.C);

	/**
	 * M‰‰ritt‰‰ hallintaolion viitteen
	 * 
	 * @param c
	 *            control olion viite
	 */
	public Steering(Control c) {
		this.control = c;
	}

	// oikealle k‰‰ntymismetodi
	/**
	 * Metodi hidastaa vasemmanpuoleisen moottorin nopeutta niin, ett‰ robotti
	 * k‰‰ntyy vasemmalle.
	 * 
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/Motor.html">lejos.nxt.Motor</a>
	 */
	public void turnLeft() {
		Motor.C.setSpeed((float) (control.getSpeed() * 0.3));
		Motor.A.setSpeed((control.getSpeed()));
		Motor.C.forward();
		Motor.A.forward();

	}

	/**
	 * Metodi hidastaa oikeanpuoleisen moottorin nopeutta niin, ett‰ robotti
	 * k‰‰ntyy oikealle.
	 * 
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/Motor.html">lejos.nxt.Motor</a>
	 */
	public void turnRight() {
		Motor.C.setSpeed((control.getSpeed()));
		Motor.A.setSpeed((float) (control.getSpeed() * 0.3));
		Motor.C.forward();
		Motor.A.forward();
	}

	// eteenp‰in liikkumismetodi
	/**
	 * Metodi asettaa robotille nopeuden ja k‰skee sit‰ liikkumaan eteenp‰in.
	 * 
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/Motor.html">lejos.nxt.Motor</a>
	 */
	public void forward() {
		Motor.C.setSpeed((control.getSpeed()));
		Motor.A.setSpeed((control.getSpeed()));
		Motor.C.forward();
		Motor.A.forward();

	}

	// taaksepp‰in liikkumis metodi
	/**
	 * asettaa robotille maksimi nopeuden ja k‰skytt‰‰ sit‰ liikkumaan
	 * taaksep‰in.
	 * 
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/Motor.html">lejos.nxt.Motor</a>
	 */
	public void backward() {
		Motor.C.setSpeed((control.getSpeed()));
		Motor.A.setSpeed((control.getSpeed()));
		Motor.C.backward();
		Motor.A.backward();
	}

	/**
	 * Metodi asettaa moottorien nopeudeksi 0
	 * 
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/Motor.html">lejos.nxt.Motor</a>
	 */
	public void fullstop() {
		Motor.C.setSpeed(0);
		Motor.A.setSpeed(0);
	}

	/**
	 * V‰ist‰mis manˆˆveri, joka k‰‰nt‰‰ robottia ensin oikealle, ajaa robottia
	 * eteenp‰in ja lopuksi k‰‰ntyy takaisin vasemmalle.
	 * 
	 * @see <a
	 *      href="lejos.robotics.navigation.DifferentialPilot">lejos.robotics.navigation.DifferentialPilot</a>
	 */
	public void dodgeManeuver() {
		if (control.sense() < 255) {
			diffpilot.setRotateSpeed(100);
			diffpilot.rotate(50);
			diffpilot.setTravelSpeed(5);
			diffpilot.travel(10);
			diffpilot.rotate(-90);
			control.setPilot(4);
		}
	}

	/**
	 * Differential pilotin k‰‰ntymis metodi
	 * 
	 * @param i
	 *            Pilotille annettava integer, jolla m‰‰ritet‰‰n k‰‰nnytt‰v‰
	 *            et‰isyys.
	 * @see <a
	 *      href="lejos.robotics.navigation.DifferentialPilot">lejos.robotics.navigation.DifferentialPilot</a>
	 */
	public void diffRotate(int i) {
		diffpilot.setRotateSpeed(100);
		diffpilot.rotate(i);
	}

}
