import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.LCD;
import lejos.nxt.comm.USB;
import lejos.nxt.comm.USBConnection;

public class USBReceiver {

	/**
	 * Robotin k‰ytt‰m‰ nopeus muuttuja.
	 */
	int speed;
	Control control;

	/**
	 * M‰‰ritt‰‰ hallintaolion viitteen
	 * 
	 * @param c
	 *            control olion viite
	 */
	public USBReceiver(Control c) {
		this.control = c;
	}

	/**
	 * Receive metodi jota kutsutaan ohjelman k‰ynnistyess‰. Metodi odottaa PC
	 * ohjelman yhteyspyyntˆ‰ jonka j‰lkeen robotti vastaanottaa l‰hetetyn
	 * nopeus arvon ja palauttaa saman arvon takaisin PC ohjelmalle.
	 * 
	 * @see <a
	 *      href="http://www.lejos.org/nxt/nxj/api/lejos/nxt/comm/USB.html">lejos.nxt.comm.USB</a>
	 */
	public void receive() {
		// robotti odottaa yhteytt‰
		control.Printstring("odottaa usb...", 0, 0);
		USBConnection conn = USB.waitForConnection();
		// Avataan yhteydet
		DataOutputStream dOut = conn.openDataOutputStream();
		DataInputStream dIn = conn.openDataInputStream();
		// luetaan konnelta saatu tieto ja l‰hetet‰‰n se takaisin
		try {
			speed = dIn.readInt();
			dOut.writeInt(speed);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		// Suljetaan yhteydet
		try {
			dOut.close();
			dIn.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		conn.close();
		LCD.clear();

	}

	/**
	 * Palauttaa nopeus arvon
	 * 
	 * @return Palauttaa nopeus arvon
	 */
	public int getSpeed() {
		return speed;
	}
}