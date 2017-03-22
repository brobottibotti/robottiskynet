import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class Control {

	Time time;
	Steering steering;
	String testi;

	public void setobjects(Time t, Steering s) {
		this.steering = s;
		this.time = t;
	}

	public void vaihdasuunta() {

		if (steering.suunta) {
			LCD.clear();
			LCD.drawInt(4, 0, 0);
			danceRight();
			steering.suunta = false;
			LCD.drawString("Juu", 4, 5);

		} else {
			LCD.clear();
			LCD.drawInt(5, 0, 1);
			danceLeft();
			steering.suunta = true;
			LCD.drawString("Juu", 4, 5);
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void danceRight() {
		steering.danceRight();

	}

	public void danceLeft() {
		steering.danceLeft();

	}

}
