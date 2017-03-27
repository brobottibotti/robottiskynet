import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Printer {

	Control control;

	public void setobjects(Control c) {
		this.control = c;
	}

	// tekstin tulostus metodi
	// lis�� koordinaatit
	public static void print(String a) {
		LCD.drawString(a, 0, 0);
	}

	// n�yt�n tyhjennys metodi
	public void clprint(String a) {
		LCD.clear();
		LCD.drawString(a, 0, 0);
	}

	// Integer arvojen tulostamiseen k�ytett�v� metodi
	public void printint(int a, int x, int y) {

		LCD.drawInt(a, x, y);
	}

}
