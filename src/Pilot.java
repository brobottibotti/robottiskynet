import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Pilot {

	Control control;
	
	public void setobjects(Control c)
	{
		this.control=c;
	}
	
	public void Run(int type) {

		switch (type) {
		case 1:
			Test();
			break;
		
		case 2:
			Calibrate();
			break;
		}
	}
	
	

	public void Test() {
		control.Print("moro!");
	}
	
	public void Calibrate(){
		while(!Button.ESCAPE.isPressed()){
			LCD.drawString("black >", 0, 0);
			LCD.drawString("white <", 0, 1);
			LCD.drawString("esc jatka", 0, 2);
			if(Button.RIGHT.isPressed()){control.getBlackLight();}
			else if(Button.LEFT.isPressed()){control.getWhiteLight();}
			else if(Button.ESCAPE.isPressed()){Run(1);}
		}
		
	}

}
