import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class Control {

	Time time;
	Steering steering;
	Colorsensor colorsensor;
	boolean stop=false;

	public void setobjects(Time t, Steering s, Colorsensor v) {
		this.steering = s;
		this.time = t;
		this.colorsensor = v;
	}

	public void changeDirection() {
		steering.direction = !steering.direction;
		if (steering.direction) {
			LCD.clear();
			LCD.drawInt(4, 0, 0);
			turnRight();
			steering.direction = false;
			LCD.drawString("Juu", 4, 5);
			LCD.drawInt(colorsensor.whitecolor, 3, 5);

		} else {
			LCD.clear();
			LCD.drawInt(5, 0, 1);
			turnLeft();
			steering.direction = true;
			LCD.drawString("Juu", 4, 5);
			LCD.drawInt(colorsensor.blackcolor, 3, 5);
			
		}

	}

	public void turnRight() {
		steering.turnRight();

	}

	public void turnLeft() {
		steering.turnLeft();

	}
	
	public void timer(){
		time.timer();
	}
	public void forward(){
		
		steering.forward();
	}

}
