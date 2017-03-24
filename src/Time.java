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
	
	public void timer(){
		LCD.drawString("Aika: ", 0, 0);
		LCD.drawInt(stopwatch.elapsed()/1000, 0, 1);
	}
	

	public void run() {
		//while(!control.stop){
		//timer();
		//}
	}
	

}
