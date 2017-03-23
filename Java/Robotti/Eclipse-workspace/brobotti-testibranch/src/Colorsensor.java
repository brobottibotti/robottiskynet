import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

public class Colorsensor implements Runnable {
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	int blackcolor;
	int whitecolor;
	Control control;

	public void setobjects(Control c) {
		this.control = c;
	}

	//värien nouto
	
	public void checkcolor() {

			colorsensor.setFloodlight(true);
			if (colorsensor.getLightValue() < 20) {
				control.turnRight();
			} else if (colorsensor.getLightValue() >40) {
				control.turnLeft();
			}else{
				control.forward();
			}

			
		

	}

	public void run() {
		// TODO Auto-generated method stub
		colorsensor.setFloodlight(true);
		while (!control.stop) {
			checkcolor();
		}
	}

}
