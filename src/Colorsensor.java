import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

public class Colorsensor implements Runnable {
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	Control control;
	int blackcolor;
	int whitecolor;
	boolean mittaus;
	int lightvalue;
	public void setobjects(Control c) {
		this.control = c;
	}

	//värien nouto
	
	public void updatecolor() {
			lightvalue = colorsensor.getLightValue();
			

	}
	public int getLight(){
		return lightvalue;
		
	}
	public void setBlackLight(){
		colorsensor.setFloodlight(true);
		blackcolor = colorsensor.getLightValue()+10;
		

		}
	
	public void setWhiteLight(){
		colorsensor.setFloodlight(true);
		 whitecolor = colorsensor.getLightValue();
	}

	public void run() {
	//	// TODO Auto-generated method stub
	//	colorsensor.setFloodlight(true);
		//vaihda stoppi controllin kautta jossain vaiheessa
		while (!Robotti.stop) {
		updatecolor();
		}
	}

}
