import lejos.nxt.Motor;


public class Steering implements Runnable{
	
	public void Dodge(){
		Right();
		Forward();
		Left();
		
	}
	public void Right(){
		Motor.C.rotate(-1500);
		Motor.B.rotate(1500);
	}
	public void Forward(){
		Motor.C.forward();
		Motor.B.forward();
	}
	public void Left(){
		Motor.C.rotate(1500);
		Motor.B.rotate(-1500);
		
	}

}
