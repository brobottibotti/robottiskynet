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
	Ultrasensori ultrasensori;
	int pilotType;

	public void setobjects(Time t, Steering s, Colorsensor v, Printer pr, Pilot pi, Ultrasensori us) {
		this.steering = s;
		this.time = t;
		this.colorsensor = v;
		
		//starting Pilot type
		this.pilotType = 1;
		
		this.pilot = pi;
		this.printer = pr;
		this.ultrasensori = us;
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
	
	public void setBlackLight(){
		colorsensor.setBlackLight();
	}	
	
	public void setWhiteLight(){
		colorsensor.setWhiteLight();
	}
	public void shutdown(){
		Robotti.setStop();
		
	}
	public int sense(){
		return ultrasensori.etaisyys();
	}
}
	


