import lejos.nxt.Button;
import lejos.nxt.LCD;


public class Robotti {
		
	public static void main(String[] args) {
		boolean menu = true;
		Control control = new Control();
		Steering steering = new Steering();
		Time time = new Time();
		Colorsensor colorsensor = new Colorsensor();
		
		while(menu){
			LCD.drawString("Musta >", 0, 0);
			LCD.drawInt(colorsensor.blackcolor, 0, 1);
			if(Button.RIGHT.isPressed()){
				colorsensor.getBlackLight();
			}
			LCD.drawString("< Valkoinen", 0, 2);

			LCD.drawInt(colorsensor.whitecolor, 0, 3);
			if(Button.LEFT.isPressed()){
				colorsensor.getWhiteLight();
			}
			LCD.drawString("Kaynnista esc", 0, 5);
			if(Button.ESCAPE.isPressed()){
				menu = false;
				LCD.clear();
			}
		}
		
		control.setobjects(time, steering, colorsensor);
		steering.setobjects(control);
		time.setobjects(control);
		colorsensor.setobjects(control);
		
		Thread timer = new Thread(time);
		timer.start();
		Thread color = new Thread(colorsensor);
		color.start();
		
		
		
		
	}

}
