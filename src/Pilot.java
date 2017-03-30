import java.io.File;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Sound;

public class Pilot {
	

	Control control;
	public void setobjects(Control c) {
		this.control = c;
	}
	public Pilot(Control c)
	{
		this.control = c;
	}

	// "pilotti" switch case, jolla ohjataan ohjelman kulkua
	public void Run(int type) {

		switch (type) {
		case 1:
			Valikko();
			break;

		case 2:
			Calibrate();
			break;

		case 3:
			Drive();
			break;

		case 4:
			Configure();
			break;

		case 5:
			Final();
			break;
		}
	}

	// case Main menu, jossa on sensorien kalibrointi, ohjelman sammutus ja
	// robotin ajoon siirtymis vaihtoehdot.
	public void Valikko() {
		
		
		control.Printstring("kalibrointi >", 0, 0);
		control.Printstring("konfigurointi <", 0, 1);
		control.Printstring("enter aja", 0, 2);
		if (Button.RIGHT.isPressed()) {
			LCD.clear();
			
			
			control.setPilot(2);
		} else if (Button.LEFT.isPressed()) {
			
			LCD.clear();
			control.setPilot(5);
		} else if (Button.ENTER.isPressed()) {
			LCD.clear();
			control.time.stopwatch.reset();
			control.setPilot(3);
		}
	}

	// case värisensorin kalibrointi. Tämän casen aikana haetaan käytettävän
	// viivan maksimi musta arvo, jotta ohjelma tietää koska se kääntyy.
	public void Calibrate() {
		control.playMusic(2);
		control.Printstring("black >", 0, 0);
		control.Printstring("white <", 0, 1);
		control.Printstring("esc menu", 0, 2);
		
		// ultrasensorin arvot
		int ultrasensoridata = control.sense();
		control.Printint(ultrasensoridata, 0, 5);
		if (Button.RIGHT.isPressed()) {
			control.setBlackLight();
			control.Printint(control.getBlackLight(), 0, 3);
		} else if (Button.LEFT.isPressed()) {
			control.setWhiteLight();
			control.Printint(control.getWhiteLight(), 0, 4);
		} else if (Button.ESCAPE.isPressed()) {
			LCD.clear();
			control.setPilot(1);
		}
	}

	// tiedonsiirto pilotti
	public void Configure() {
		while (!control.getStop()) {

		}
	}

	// case Ajo-tila. Tässä casessa robotti pyrkii seuraamaan mustaa viivaa.
	public void Drive() {
		control.playMusic(3);
		control.Printstring("Aika: ", 0, 0);
		control.Printint(control.getTime(), 7, 0);
		control.Printint(control.getLight(), 0, 4);
		int ultrasensoridata = control.sense();
		control.Printint(ultrasensoridata, 0, 5);

		if (control.getLight() <= control.treshold() - 10) {
			// control.turnRight();
			
			control.steerRun(2);
		} else if (control.getLight() >= control.treshold() + 10) {
			// control.turnLeft();
			
			control.steerRun(1);
		} else if (control.getLight() < control.treshold() + 10
				&& control.getLight() > control.treshold() - 10) {
			// control.forward();
			control.steerRun(3);
		}
		if (Button.ESCAPE.isPressed()) {
			// control.fullstop();
			control.steerRun(4);
			LCD.clear();
			control.setPilot(5);
		}

	}

	// loppu tila pilotti
	public void Final() {
		control.playMusic(4);
		control.Printstring("Aikasi: ", 0, 0);
		control.Printint(control.endTime(), 10, 0);
		control.Printstring("Paina esc lopettaaksesi", 0, 1);
		


	}
}
