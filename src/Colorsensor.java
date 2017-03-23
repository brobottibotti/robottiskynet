import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

public class Colorsensor implements Runnable {
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	Control control;
	int blackcolor;
	int whitecolor;

	public void setobjects(Control c) {
		this.control = c;
	}

	//värien nouto
	
	public void checkcolor() {

			if (colorsensor.getLightValue() < blackcolor) {
				control.turnRight();
			} else if (colorsensor.getLightValue() >whitecolor) {
				control.turnLeft();
			}else{
				control.forward();
			}

	}
	public void getBlackLight(){
		
		blackcolor = colorsensor.getLightValue();
		
	}
	public void getWhiteLight(){
		 whitecolor = colorsensor.getLightValue();
	}

	public void run() {
		// TODO Auto-generated method stub
		colorsensor.setFloodlight(true);
		getBlackLight();
		getWhiteLight();
		while (!control.stop) {
			checkcolor();
		}
	}

}
