import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class Steering {

	Control control;
	boolean direction;
	float maxspeed = 400;
	public void setobjects(Control c)
	{
		this.control=c;
	}
	
	
	
	public void turnRight(){
		Motor.C.setSpeed((float)(maxspeed*0.4));
		Motor.A.setSpeed((float)(maxspeed));
		
		Motor.C.forward();
		Motor.A.forward();
		

	}
	public void turnLeft(){

		Motor.C.setSpeed((float)(maxspeed));
		Motor.A.setSpeed((float)(maxspeed*0.4));
		
		Motor.C.forward();
		Motor.A.forward();

	}
	public void forward(){
		Motor.C.setSpeed((float)(maxspeed));
		Motor.A.setSpeed((float)(maxspeed));
		
		Motor.C.forward();
		Motor.A.forward();
		
	}
	
	public void backward(){
		Motor.C.setSpeed((float)(maxspeed));
		Motor.A.setSpeed((float)(maxspeed));
		
		Motor.C.backward();
		Motor.A.backward();
	}


	
	

		
	

}
