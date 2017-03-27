import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Printer {

	Control control;

	public void setobjects(Control c) {
		this.control = c;
	}

	// tekstin tulostus metodi
	// lisää koordinaatit
	public void printstring(String a, int x, int y) {
		LCD.drawString(a, x, y);
	}

	// näytön tyhjennys metodi
	public void clprint(String a) {
		LCD.clear();
		LCD.drawString(a, 0, 0);
	}

	// Integer arvojen tulostamiseen käytettävä metodi
	public void printint(int a, int x, int y) {

		LCD.drawInt(a, x, y);
	}

}
