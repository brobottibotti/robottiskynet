import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Pilot {

	Control control;

	public void setobjects(Control c) {
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
		}
	}

	// case Main menu, jossa on sensorien kalibrointi, ohjelman sammutus ja
	// robotin ajoon siirtymis vaihtoehdot.
	public void Valikko() {
		while (!Button.ESCAPE.isPressed()) {
			LCD.drawString("kalibrointi >", 0, 0);
			LCD.drawString("aja <", 0, 1);
			LCD.drawString(" esc sammuta", 0, 2);
			if (Button.RIGHT.isPressed()) {
				LCD.clear();
				Run(2);
			} else if (Button.LEFT.isPressed()) {
				LCD.clear();
				Run(3);
			}
		}
	}

	// case värisensorin kalibrointi. Tämän casen aikana haetaan käytettävän
	// viivan maksimi musta arvo, jotta ohjelma tietää koska se kääntyy.
	public void Calibrate() {
		while (!Button.ESCAPE.isPressed()) {

			LCD.drawString("black >", 0, 0);
			LCD.drawString("white <", 0, 1);
			LCD.drawString(" enter menu", 0, 2);
			int ultrasensoridata = control.sense(); // ultrasensorin arvot
			control.printer.printint(ultrasensoridata, 0, 6);
			if (Button.RIGHT.isPressed()) {
				control.setBlackLight();
				// getit ja setit controlliin
				control.printer.printint(control.colorsensor.blacklight, 0, 3);
			} else if (Button.LEFT.isPressed()) {
				control.setWhiteLight();
				control.printer.printint(control.colorsensor.whitelight, 0, 4);
			} else if (Button.ENTER.isPressed()) {
				LCD.clear();
				Run(1);
			}
		}
	}

	// case Ajo-tila. Tässä casessa robotti pyrkii seuraamaan mustaa viivaa.
	public void Drive() {
		while (!control.getStop()) {
			// control.colorsensor.checkcolor();
			LCD.drawInt(control.colorsensor.lightvalue, 0, 5);

			if (control.colorsensor.getLight() <= control.colorsensor.blacklight) {
				control.turnRight();
			} else {
				control.turnLeft();
			}
		}
		if (Button.ESCAPE.isPressed()) {
			control.shutdown();
		}
	}

}
