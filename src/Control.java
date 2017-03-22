import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class Control {

	Time time;
	Steering steering;
	Colorsensor colorsensor;
	String testi;
	boolean stop=false;

	public void setobjects(Time t, Steering s, Colorsensor v) {
		this.steering = s;
		this.time = t;
		this.colorsensor = v;
	}

	public void vaihdasuunta() {
		steering.suunta = !steering.suunta;
		if (steering.suunta) {
			LCD.clear();
			LCD.drawInt(4, 0, 0);
			danceRight();
			steering.suunta = false;
			LCD.drawString("Juu", 4, 5);
			LCD.drawInt(colorsensor.whitecolor, 3, 5);

		} else {
			LCD.clear();
			LCD.drawInt(5, 0, 1);
			danceLeft();
			steering.suunta = true;
			LCD.drawString("Juu", 4, 5);
			LCD.drawInt(colorsensor.blackcolor, 3, 5);
			
		}

	}

	public void danceRight() {
		steering.danceRight();

	}

	public void danceLeft() {
		steering.danceLeft();

	}

}
