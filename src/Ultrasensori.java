import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;


public class Ultrasensori{
	Control control;
	int etaisyys;
	UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S4);
		
	public void setobjects(Control c){
		this.control = c;
	}
	
	public int etaisyys(){
		etaisyys = ultra.getDistance();
		return etaisyys;
		//LCD.clear();
		//LCD.drawString("Distance: " + etaisyys, 0, 3);
		}
	
	}


