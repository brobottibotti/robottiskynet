import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.LCD;
import lejos.nxt.comm.USB;
import lejos.nxt.comm.USBConnection;

public class USBReceiver {
	//nopeus, jota k‰ytet‰‰n muissa luokissa
	int speed;
	Control control;
	
	
	public USBReceiver(Control c) {
		this.control = c;
	}
	
	public void receive() {
		//robotti odottaa yhteytt‰
		control.Printstring("waiting", 0, 0);
		USBConnection conn = USB.waitForConnection();
		//Avataan yhteydet
		DataOutputStream dOut = conn.openDataOutputStream();
		DataInputStream dIn = conn.openDataInputStream();
		//luetaan konnelta saatu tieto ja l‰hetet‰‰n se takaisin
		try {
			speed = dIn.readInt();
			dOut.writeInt(speed);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//Suljetaan yhteydet
		try {
			dOut.close();
			dIn.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		conn.close();
		LCD.clear();

	}
	//palauttaa speed
	public int getSpeed(){
		return speed;
	}
}