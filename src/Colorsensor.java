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
		while (!control.stop) {
			
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		colorsensor.setFloodlight(true);
		checkcolor();
	}

}
