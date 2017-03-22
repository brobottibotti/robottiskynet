import lejos.nxt.Button;


public class Robotti {
	
	public static void main(String[] args) {
		//Varisensori vari = new Varisensori();
		//Ultrasensori ultra = new Ultrasensori();
		
		//Thread lanka2 = new Thread(ultra);
		//lanka2.start();
		Control control = new Control();
		Steering steering = new Steering();
		Time time = new Time();
		Colorsensor colorsensor = new Colorsensor();
		control.setobjects(time, steering, colorsensor);
		steering.setobjects(control);
		time.setobjects(control);
		colorsensor.setobjects(control);
		
		Thread timer = new Thread(time);
		timer.start();
		Thread lanka1 = new Thread(colorsensor);
		lanka1.start();
		
		
		
		
	}

}
