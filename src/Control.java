import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class Control {

	
	Steering steering;
	Time time;
	Colorsensor colorsensor;
	Pilot pilot;
	Printer printer;
	Ultrasensor ultrasensor;
	Music music;
	USBReceiver usbreceiver;
	int pilotType;
	public boolean stop = false;

	public Control() {
		steering = new Steering(this);
		time = new Time(this);
		colorsensor = new Colorsensor(this);
		pilot = new Pilot(this);
		printer = new Printer(this);
		ultrasensor = new Ultrasensor(this);
		music = new Music(this);
		usbreceiver = new USBReceiver(this);
		this.pilotType = 0;
	}

	// Ohjelman sammutus metodi
	public void shutdown() {
		this.stop = !stop;
	}

	// Palauttaa pysäytys booleain arvon
	public boolean getStop() {
		return this.stop;
	}
	//
	//USBReceive
	//
	
	public void Receive(){
		usbreceiver.receive();
	}
	public int getSpeed(){
		return usbreceiver.getSpeed();
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

	public void Printint(int a, int x, int y) {
		printer.printint(a, x, y);
	}

	//
	// Timer
	//
	public void timer() {
		// time.timer();
	}

	public int getTime() {
		return time.getTime();
	}

	public int endTime() {
		return time.endTime();
	}

	//
	// Ultrasensor
	//
	public int sense() {
		return ultrasensor.etaisyys();
	}

	//
	// Colorsensor
	//
	public int getLight() {
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

	public int treshold() {
		return colorsensor.treshold();
	}

	//
	// Steering
	//
	public void steerRun(int i) {
		steering.Run(i);
	}

	public void turnRight() {
		steering.turnRight();
	}

	public void turnLeft() {
		steering.turnLeft();
	}

	public void forward() {
		steering.forward();
	}

	public void fullstop() {
		steering.fullstop();
	}

	//
	// Music
	//

	public void endMusic() {
		music.endMusic();

	}

	public void playMusic(int i) {
		music.playMusic(i);
	}
}
