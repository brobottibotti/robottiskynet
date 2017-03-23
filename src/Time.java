import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.util.Stopwatch;


public class Time implements Runnable{
	
	Control control;
	Stopwatch stopwatch = new Stopwatch();
	Stopwatch stopwatch2 = new Stopwatch();

	
	public void setobjects(Control c)
	{
		this.control = c;
	}
	
	public void timer(){
		int timesec = stopwatch.elapsed();
		       
		
		LCD.drawString("Aika:", 0, 0);
		LCD.drawInt(timesec/1000, 5, 0);
		
		
	}
	
	public void run() {
		while(!control.stop){
		timer();
		}
	}

}
