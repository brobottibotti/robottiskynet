import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;


public class Colorsensor implements Runnable {
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	int blackcolor;
	int whitecolor;
	Control control;
	public void setobjects(Control c)
	{
		this.control=c;
	}

	public void checkcolor(){
		while(!control.stop){
		//ajastin
		control.danceRight();
		blackcolor = colorsensor.getLightValue();
		control.danceLeft();
		whitecolor = colorsensor.getLightValue();
		
		LCD.drawInt(whitecolor, 0, 1);
		LCD.drawInt(blackcolor, 0, 2);
		/*if(color < 15){
			control.vaihdasuunta();
		}else{control.danceLeft();}*/
		}
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		colorsensor.setFloodlight(true);
		checkcolor();
	}
	
}
