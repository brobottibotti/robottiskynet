
public class Robotti {
	
	public static void main(String[] args) {
		Varisensori vari = new Varisensori();
		Ultrasensori ultra = new Ultrasensori();
		Thread lanka1 = new Thread(vari);
		lanka1.start();
		Thread lanka2 = new Thread(ultra);
		lanka2.start();
		
	}

}
