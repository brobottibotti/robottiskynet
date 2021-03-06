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

	public void setobjects(Time t, Steering s, Colorsensor v, Printer pr,
			Pilot pi, Ultrasensori us) {
		this.steering = s;
		this.time = t;
		this.colorsensor = v;
		this.pilot = pi;
		this.printer = pr;
		this.ultrasensori = us;
		// starting Pilot type
		this.pilotType = 1;

	}

	// Ohjelman sammutus metodi
	public void shutdown() {
		Robotti.setStop();
	}

	// Palauttaa pys�ytys booleain arvon
	public boolean getStop() {
		return Robotti.stop;
	}

	//
	// Pilot
	//
	public void Pilot() {
		pilot.Run(pilotType);
	}

	public void setPilot(int type) {
		this.pilotType = type;
	}

	//
	// Printer
	//
	public void Printstring(String s, int x, int y) {
		printer.printstring(s, x, y);
	}
	
	public void Printint(int a, int x, int y){
		printer.printint(a, x, y);
	}

	//
	// Timer
	//
	public void timer() {
		// time.timer();
	}

	//
	// Ultrasensor
	//
	public int sense() {
		return ultrasensori.etaisyys();
	}

	//
	// Colorsensor
	//
	public int getLight(){
		return colorsensor.getLight();
	}
	public void setBlackLight() {
		colorsensor.setBlackLight();
	}

	public int getBlackLight() {
		return colorsensor.getBlackLight();
	}

	public void setWhiteLight() {
		colorsensor.setWhiteLight();
	}

	public int getWhiteLight() {
		return colorsensor.getWhiteLight();
	}

	//
	// Steering
	//
	public void turnRight() {
		steering.turnRight();
	}

	public void turnLeft() {
		steering.turnLeft();
	}

	public void forward() {
		steering.forward();
	}

}
