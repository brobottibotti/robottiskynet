import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Steering {

	Control control;
	private float dodgespeed = 100;
	private DifferentialPilot diffpilot = new DifferentialPilot(2.2f, 4.7f,
			Motor.A, Motor.C);

	
	public Steering(Control c) {
		this.control = c;
	}

	// oikealle k‰‰ntymis metodi
	public void turnLeft() {
		Motor.C.setSpeed((float) (control.getSpeed() * 0.3));
		Motor.A.setSpeed((control.getSpeed()));
		Motor.C.forward();
		Motor.A.forward();

	}

	// vasemmalle k‰‰ntymis metodi
	public void turnRight() {
		Motor.C.setSpeed((control.getSpeed()));
		Motor.A.setSpeed((float) (control.getSpeed() * 0.3));
		Motor.C.forward();
		Motor.A.forward();
	}

	// eteenp‰in liikkumis metodi
	public void forward() {
		Motor.C.setSpeed((control.getSpeed()));
		Motor.A.setSpeed((control.getSpeed()));
		Motor.C.forward();
		Motor.A.forward();

	}

	// taaksepp‰in liikkumis metodi
	public void backward() {
		Motor.C.setSpeed((control.getSpeed()));
		Motor.A.setSpeed((control.getSpeed()));
		Motor.C.backward();
		Motor.A.backward();
	}

	public void fullstop() {
		Motor.C.setSpeed(0);
		Motor.A.setSpeed(0);
	}

	public void rotateRight(int angle) {
		Motor.C.setSpeed((float) (dodgespeed));
		Motor.A.setSpeed((float) (dodgespeed));
		Motor.C.rotate(angle, true);
		Motor.A.rotate(-angle, true);
	}

	public void rotateLeft(int angle) {
		Motor.C.setSpeed((float) (dodgespeed));
		Motor.A.setSpeed((float) (dodgespeed));
		Motor.C.rotate(-angle, true);
		Motor.A.rotate(angle, true);
	}

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

	public void diffRotate(int i) {
		diffpilot.setRotateSpeed(100);
		diffpilot.rotate(i);
	}

}
