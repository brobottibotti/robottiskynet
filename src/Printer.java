import lejos.nxt.LCD;

public class Printer {

	Control control;

	/**
	 * M‰‰ritt‰‰ hallintaolion viitteen
	 * 
	 * @param c
	 *            control olion viite
	 */
	public Printer(Control c) {
		this.control = c;
	}

	/**
	 * Tekstin tulostus metodi
	 * 
	 * @param a
	 *            Tulostettava teksti
	 * @param x
	 *            LCD:n X koordinaatti
	 * @param y
	 *            LCD:n Y koordinaatti
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/LCD.html">lejos.nxt.LCD</a>
	 */
	public void printstring(String a, int x, int y) {
		LCD.drawString(a, x, y);
	}

	/**
	 * Numeroiden tulostus metodi
	 * 
	 * @param a
	 *            Tulostettava int arvo
	 * @param x
	 *            LCD:n X koordinaatti
	 * @param y
	 *            LCD:n Y koordinaatti
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/LCD.html">lejos.nxt.LCD</a>
	 */
	public void printint(int a, int x, int y) {

		LCD.drawInt(a, x, y);
	}

}
