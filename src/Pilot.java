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
		while (!control.getStop()) {
			control.Printstring("kalibrointi >", 0, 0);
			control.Printstring("aja <", 0, 1);
			control.Printstring("esc sammuta", 0, 2);
			if (Button.RIGHT.isPressed()) {
				LCD.clear();
				Run(2);
			} else if (Button.LEFT.isPressed()) {
				LCD.clear();
				Run(3);
			}else if (Button.ESCAPE.isPressed()){
				control.shutdown();
			}
		}
	}

	// case värisensorin kalibrointi. Tämän casen aikana haetaan käytettävän
	// viivan maksimi musta arvo, jotta ohjelma tietää koska se kääntyy.
	public void Calibrate() {
		while (!control.getStop()) {
			control.Printstring("black >", 0, 0);
			control.Printstring("white <", 0, 1);
			control.Printstring("enter menu", 0, 2);
			
			// ultrasensorin arvot
			int ultrasensoridata = control.sense(); 
			control.Printint(ultrasensoridata, 0, 5);
			if (Button.RIGHT.isPressed()) {
				control.setBlackLight();
				control.Printint(control.getBlackLight(), 0, 3);
			} else if (Button.LEFT.isPressed()) {
				control.setWhiteLight();
				control.Printint(control.getWhiteLight(), 0, 4);
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
			control.Printint(control.getLight(), 0, 4);
			int ultrasensoridata = control.sense();
			control.Printint(ultrasensoridata, 0, 5);

			if (control.getLight() <= control.getBlackLight()+5) {
				control.turnRight();
			} else if (control.getLight() >= control.getWhiteLight()) {
				control.turnLeft();
			}else if (control.getLight() < control.getWhiteLight() && control.getLight() > control.getBlackLight()){
				control.forward();
			}
			if (Button.ESCAPE.isPressed()) {
				control.shutdown();
		}
		
		}
	}

}
