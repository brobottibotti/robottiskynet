import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Printer {

	Control control;
	
	public void setobjects(Control c)
	{
		this.control=c;
	}
	//lis‰‰ koordinaatit
	public static void print(String a)
	{
		LCD.drawString(a, 0, 0);
	}
	public void clprint(String a)
	{
		LCD.clear();
		LCD.drawString(a, 0, 0);
	}
	public void printint(int a, int x, int y){
		
		LCD.drawInt(a, x, y);
	}
	
}
