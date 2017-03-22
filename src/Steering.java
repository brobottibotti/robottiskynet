import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class Steering {

	Control control;
	boolean suunta;
	public void setobjects(Control c)
	{
		this.control=c;
	}
	
	
	
	public void danceRight(){
		Motor.C.setSpeed(500);
		Motor.A.setSpeed(500);
		
		Motor.C.forward();
		Motor.A.backward();

	}
	public void danceLeft(){

		Motor.C.setSpeed(500);
		Motor.A.setSpeed(500);
		
		Motor.C.backward();
		Motor.A.forward();

	}


	
	

		
	

}
