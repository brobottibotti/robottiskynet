import lejos.nxt.Button;


public class Robotti {
	
	public static void main(String[] args) {
		//Varisensori vari = new Varisensori();
		//Ultrasensori ultra = new Ultrasensori();
		//Thread lanka1 = new Thread(vari);
		//lanka1.start();
		//Thread lanka2 = new Thread(ultra);
		//lanka2.start();
		Control control = new Control();
		Steering steering = new Steering();
		Time time = new Time();
		
		control.setobjects(time, steering);
		steering.setobjects(control);
		time.setobjects(control);
		
		Thread timer = new Thread(time);
		timer.start();
		
		
		
	}

}
