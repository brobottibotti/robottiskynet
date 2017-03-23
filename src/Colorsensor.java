import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

public class Colorsensor implements Runnable {
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	Control control;
	int blacklight;
	int whitelight;

	public void setobjects(Control c) {
		this.control = c;
	}

	//värien nouto
	
	public void checkcolor() {

			if (colorsensor.getLightValue() < blacklight) {
				control.turnRight();
			} else if (colorsensor.getLightValue() >whitelight) {
				control.turnLeft();
			}else{
				control.forward();
			}

	}
	public void getBlackLight(){
		
		blacklight = colorsensor.getLightValue();
		
	}
	public void getWhiteLight(){
		 whitelight = colorsensor.getLightValue();
	}

	@Override
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
