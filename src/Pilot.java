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
			Valikko();
			break;
		
		case 2:
			Calibrate();
			break;
		
		case 3:
			Drive();
			break;
		}
	}
	
	

	public void Valikko() {
		control.Print("moro!");
		LCD.drawString("kalibrointi >", 0, 0);
		LCD.drawString("aja <", 0, 1);
		LCD.drawString(" esc sammuta", 0, 2);
		if(Button.RIGHT.isPressed()){Run(2);}
		else if(Button.LEFT.isPressed()){Run(3);}
		else if(Button.ESCAPE.isPressed()){control.stop=false;}
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
	public void Drive(){
		
		
	}

}
