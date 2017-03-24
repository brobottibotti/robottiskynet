import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class Control {

	Time time;
	Steering steering;
	Colorsensor colorsensor;
	Printer printer;
	Pilot pilot;
	
	boolean stop=false;
	int pilotType;

	public void setobjects(Time t, Steering s, Colorsensor v, Printer pr, Pilot pi) {
		this.steering = s;
		this.time = t;
		this.colorsensor = v;
		
		//starting Pilot type
		this.pilotType = 2;
		
		this.pilot = pi;
		this.printer = pr;
	}


	public void Pilot()
	{
		pilot.Run(pilotType);
	}
	public void setPilot(int type)
	{
		this.pilotType = type;
	}
	
	public void Print(String s)
	{
		printer.print(s);
	}
	

	public void turnRight() {
		steering.turnRight();

	}

	public void turnLeft() {
		steering.turnLeft();

	}
	
	public void timer(){
		//time.timer();
	}
	public void forward(){
		
		steering.forward();
	}
	
	

}
