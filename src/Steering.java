import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class Steering {

	Control control;
	boolean direction;
	float maxspeed = 300;
	float dodgespeed = 100;

	/*public void setobjects(Control c) {
		this.control = c;
	}
	*/
	public Steering(Control c){
		this.control = c;
	}

	// Testi steering switchcase
	public void Run(int type) {
		switch (type) {
		case 1:
			turnLeft();
			break;

		case 2:
			turnRight();
			break;

		case 3:
			forward();
			break;
		case 4:
			fullstop();
			break;

		case 5:
			// dodge();
			break;
		}

	}

	// oikealle k‰‰ntymis metodi
	public void turnLeft() {
		
		Motor.C.setSpeed((float) (maxspeed * 0.3));
		Motor.A.setSpeed((float) (maxspeed));
		Motor.C.forward();
		Motor.A.forward();
		
		
	}

	// vasemmalle k‰‰ntymis metodi
	public void turnRight() {
		
		Motor.C.setSpeed((float) (maxspeed));
		Motor.A.setSpeed((float) (maxspeed * 0.3));
		Motor.C.forward();
		Motor.A.forward();
	}

	// eteenp‰in liikkumis metodi
	public void forward() {
		Motor.C.setSpeed((float) (maxspeed));
		Motor.A.setSpeed((float) (maxspeed ));
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

	public void fullstop() {
		Motor.C.setSpeed(maxspeed * 0);
		Motor.A.setSpeed(maxspeed * 0);

	}
	
	public void rotateRight(int angle){
		Motor.C.setSpeed((float) (dodgespeed));
		Motor.A.setSpeed((float) (dodgespeed));

		Motor.C.rotate(angle, true);
		Motor.A.rotate(-angle, true);
	}
	
	public void rotateLeft(int angle){
		Motor.C.setSpeed((float) (dodgespeed));
		Motor.A.setSpeed((float) (dodgespeed));
		
		Motor.C.rotate(-angle, true);
		Motor.A.rotate(angle, true);
	}

}
