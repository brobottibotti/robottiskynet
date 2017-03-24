import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.util.Stopwatch;




public class Time implements Runnable{
	
	Control control;
	Stopwatch stopwatch = new Stopwatch();
	public void setobjects(Control c)
	{
		this.control = c;
	}
	
	
	
	public void run() {
		while(!control.stop){
		
		}
	}

}
