import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class Steering {

	Control control;
	boolean direction;
	float maxspeed = 400;

	public void setobjects(Control c) {
		this.control = c;
	}

	// oikealle k‰‰ntymis metodi
	public void turnRight() {
		Motor.C.setSpeed((float) (maxspeed * 0.4));
		Motor.A.setSpeed((float) (maxspeed));
		Motor.C.forward();
		Motor.A.forward();
	}

	// vasemmalle k‰‰ntymis metodi
	public void turnLeft() {
		Motor.C.setSpeed((float) (maxspeed));
		Motor.A.setSpeed((float) (maxspeed * 0.4));
		Motor.C.forward();
		Motor.A.forward();
	}

	// eteenp‰in liikkumsi metodi
	public void forward() {
		Motor.C.setSpeed((float) (maxspeed));
		Motor.A.setSpeed((float) (maxspeed));
		Motor.C.forward();
		Motor.A.forward();
	}

	// taaksepp‰in liikkumis metodi
	public void backward() {
		Motor.C.setSpeed((float) (maxspeed));
		Motor.A.setSpeed((float) (maxspeed));

		Motor.C.backward();
		Motor.A.backward();
	}

}
