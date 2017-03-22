import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
import lejos.util.Stopwatch;
import lejos.util.Timer;
import lejos.util.TimerListener;


public class Varisensori implements Runnable{
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	int color;
	Control control;
	public void setobjects(Control c)
	{
		this.control=c;
	}

	public void checkcolor(){
		while(!control.stop){
		
		color = colorsensor.getLightValue();
		colorsensor.setFloodlight(true);
		if(color < 20){
			control.danceRight();
		}else{control.danceLeft();}
	}
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		checkcolor();
		
	}
	




}
