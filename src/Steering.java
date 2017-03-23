import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class Steering {

	Control control;
	boolean direction;
	public void setobjects(Control c)
	{
		this.control=c;
	}
	
	
	
	public void turnRight(){
		Motor.C.setSpeed(500);
		Motor.A.setSpeed(500);
		
		Motor.C.forward();
		Motor.A.backward();
		

	}
	public void turnLeft(){

		Motor.C.setSpeed(500);
		Motor.A.setSpeed(500);
		
		Motor.C.backward();
		Motor.A.forward();

	}
	public void forward(){
		Motor.C.setSpeed(500);
		Motor.A.setSpeed(500);
		
		Motor.C.forward();
		Motor.A.forward();
		
	}


	
	

		
	

}
