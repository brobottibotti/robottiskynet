/**
 * T‰ss‰ luokassa alustetaan toiminnallisten luokkien oliot. {@link}
 */
public class Control {

	Steering steering;
	Time time;
	Colorsensor colorsensor;
	Pilot pilot;
	Printer printer;
	Ultrasensor ultrasensor;
	Music music;
	USBReceiver usbreceiver;
	/**
	 * Muuttuja joka m‰‰ritt‰‰ aktiivisen pilotin
	 */
	int pilotType;
	/**
	 * Boolean muuttuja, joka pit‰‰ ohjelman k‰ynniss‰.
	 */
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

	/**
	 * Sammutus metodi joka vaihtaa p‰‰loopin boolean arvon
	 */
	public void shutdown() {
		this.stop = !stop;
	}

	/**
	 * Palauttaa boolean arvon, joka yll‰pit‰‰ ohjelman p‰‰looppia.
	 * 
	 * @return
	 */
	public boolean getStop() {
		return this.stop;
	}

	//
	// USBReceive
	//

	/**
	 * @see USBReceiver#receive()
	 */
	public void Receive() {
		usbreceiver.receive();
	}

	/**
	 * @see USBReceiver#getSpeed()
	 * @return palauttaa PC:lt‰ saadun nopeuden
	 */
	public int getSpeed() {
		return usbreceiver.getSpeed();
	}

	/**
	 * Vaihtaa pilot luokan switch casen tilaa.
	 * 
	 * @see Pilot#Run(int)
	 */
	public void Pilot() {
		pilot.Run(pilotType);
	}

	/**
	 * Vaihtaa pilotType muuttujan arvon.
	 * 
	 * @param type
	 *            integer muuttuja jolla m‰‰ritet‰‰n pilotType arvo.
	 * @see Pilot#Run(int)
	 */
	public void setPilot(int type) {
		this.pilotType = type;
	}

	//
	// Printer
	//
	/**
	 * @see Printer#printstring(String, int, int)
	 */
	public void Printstring(String s, int x, int y) {
		printer.printstring(s, x, y);
	}

	/**
	 * @see Printer#printint(int, int, int)
	 */
	public void Printint(int a, int x, int y) {
		printer.printint(a, x, y);
	}

	//
	// Timer
	//

	/**
	 * @see Time#getTime
	 */
	public int getTime() {
		return time.getTime();
	}

	/**
	 * @see Time#endTime
	 */
	public int endTime() {
		return time.endTime();
	}

	//
	// Ultrasensor
	//
	/**
	 * @see Ultrasensor#getEtaisyys
	 */
	public int sense() {
		return ultrasensor.getEtaisyys();
	}

	/**
	 * @see Ultrasensor#getIsBlocked
	 */
	public boolean getIsBlocked() {
		return ultrasensor.getIsBlocked();
	}

	//
	// Colorsensor
	//
	/**
	 * @see Colorsensor#getLight
	 */
	public int getLight() {
		return colorsensor.getLight();
	}

	/**
	 * @see Colorsensor#setBlackLight
	 */
	public void setBlackLight() {
		colorsensor.setBlackLight();
	}

	/**
	 * @see Colorsensor#getBlackLight
	 */
	public int getBlackLight() {
		return colorsensor.getBlackLight();
	}

	/**
	 * @see Colorsensor#setWhiteLight
	 */
	public void setWhiteLight() {
		colorsensor.setWhiteLight();
	}

	/**
	 * @see Colorsensor#setBlackLight
	 */
	public int getWhiteLight() {
		return colorsensor.getWhiteLight();
	}

	/**
	 * @see Colorsensor#treshold
	 */
	public int treshold() {
		return colorsensor.treshold();
	}

	//
	// Steering
	//
	/**
	 * @see Steering#diffRotate(int)
	 */
	public void diffRotate(int i) {
		steering.diffRotate(i);
	}

	/**
	 * @see Steering#turnRight
	 */
	public void turnRight() {
		steering.turnRight();
	}

	/**
	 * @see Steering#turnLeft
	 */
	public void turnLeft() {
		steering.turnLeft();
	}

	/**
	 * @see Steering#forward
	 */
	public void forward() {
		steering.forward();
	}

	/**
	 * @see Steering#fullstop
	 */
	public void fullstop() {
		steering.fullstop();
	}

	/**
	 * @see Steering#dodgeManeuver
	 */
	public void dodgeManeuver() {
		steering.dodgeManeuver();
	}

	//
	// Music
	//

	/**
	 * @see Music#playMusic(int)
	 */
	public void playMusic(int i) {
		music.playMusic(i);
	}
}
