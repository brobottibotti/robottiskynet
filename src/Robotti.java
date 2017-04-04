import java.io.File;

import lejos.nxt.Button;
import lejos.nxt.remote.NXTCommand;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

import lejos.nxt.LCD;
import lejos.nxt.comm.USB;
import lejos.nxt.comm.USBConnection;

public class Robotti {

	public static void main(String[] args) {
		Control control = new Control();
		Thread timer = new Thread(control.time);
		Thread color = new Thread(control.colorsensor);
		control.Receive();
		Thread ultra = new Thread(control.ultrasensor);
        
		timer.start();
		color.start();
		ultra.start();
		// p‰‰looppi
		while (!control.getStop()) {
			control.Pilot();
		}

	}

}
