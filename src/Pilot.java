import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Pilot {

	private int menunumber;
	private int errorMargin = 3;
	private boolean rightdown = true;
	private boolean leftdown = true;
	private boolean firstDodge = false;
	
	Control control;

	public void setobjects(Control c) {
		this.control = c;
	}

	public Pilot(Control c) {
		this.control = c;
	}

	// "pilotti" switch case, jolla ohjataan ohjelman kulkua
	public void Run(int type) {

		switch (type) {
		case 0:
			Valikko();
			break;

		case 1:
			Calibrate();
			break;

		case 2:
			Drive();
			break;

		case 3:
			Dodge();
			break;

		case 4:
			Lineseeker();
			break;

		case 5:
			Final();
			break;
		}
	}

	// case Main menu, jossa on sensorien kalibrointi, ohjelman sammutus ja
	// robotin ajoon siirtymis vaihtoehdot.
	private void Valikko() {
		control.playMusic(3);
		control.Printstring("0 menu", 0, 0);
		control.Printstring("1 kalibrointi", 0, 1);
		control.Printstring("2 aja", 0, 2);
		control.Printstring("3 final", 0, 3);
		control.Printint(menunumber, 0, 6);

		control.Printint(control.getSpeed(), 0, 5);
		Button.readButtons();
		if (Button.readButtons() == Button.ID_RIGHT) {
			if (rightdown) {
				menunumber++;
			}
			rightdown = false;

		} else if (Button.readButtons() == Button.ID_LEFT) {
			if (leftdown) {
				menunumber--;
			}
			leftdown = false;
		} else if (Button.readButtons() == Button.ID_ENTER) {
			LCD.clear();
			control.time.stopwatch.reset();
			control.setPilot(menunumber);
		} else {
			rightdown = true;
			leftdown = true;
		}
	}

	// case värisensorin kalibrointi. Tämän casen aikana haetaan käytettävän
	// viivan maksimi musta arvo, jotta ohjelma tietää koska se kääntyy.
	private void Calibrate() {

		control.Printstring("black >", 0, 0);
		control.Printstring("white <", 0, 1);
		control.Printstring("esc menu", 0, 2);
		// ultrasensorin arvot
		if (Button.RIGHT.isDown()) {
			control.setBlackLight();
			control.Printint(control.getBlackLight(), 0, 3);
		} else if (Button.LEFT.isDown()) {
			control.setWhiteLight();
			control.Printint(control.getWhiteLight(), 0, 4);
		} else if (Button.ESCAPE.isDown()) {
			control.playMusic(2);
			LCD.clear();
			control.setPilot(0);
		}
	}

	// case Ajo-tila. Tässä casessa robotti pyrkii seuraamaan mustaa viivaa.
	private void Drive() {
		
		control.Printstring("Aika: ", 0, 0);
		control.Printint(control.getTime(), 10, 0);
		control.Printstring("Valo: ", 0, 1);
		control.Printint(control.getLight(), 10,1);
		control.Printstring("ultra: ", 0, 2);
		control.Printint(control.sense(), 10, 2);
		control.Printstring("musta", 0, 5);
		control.Printint(control.getBlackLight(), 10, 5);
		control.Printstring("valkonen", 0, 6);
		control.Printint(control.getWhiteLight(), 10, 6);
		

		// Kommenttiåaksaa
		if (!control.getIsBlocked()) {
			if (control.getLight() <= control.getBlackLight() + errorMargin) {
				control.turnRight();	
			} else if (control.getLight() >= control.getWhiteLight()
					- errorMargin) {
				control.turnLeft();
			} else {
				control.forward();
			}
			if (Button.ESCAPE.isDown()) {
				control.fullstop();
				LCD.clear();
				control.setPilot(5);
			}
		} else {
			if (!firstDodge) {
				control.setPilot(3);
			} else {
				LCD.clear();
				control.Printint(control.endTime(), 10, 0);
				control.fullstop();
				control.setPilot(5);
			}
		}
	}

	private void Dodge() {
		control.playMusic(1);
		firstDodge = true;
		control.dodgeManeuver();
	}

	private void Lineseeker() {
		control.playMusic(5);
		control.forward();
		control.Printint(control.getLight(), 0, 3);
		if (control.getLight() <= control.treshold() - 10) {
			control.fullstop();
			control.diffRotate(20);
			control.setPilot(2);
		}
	}

	// loppu tila pilotti
	private void Final() {
		control.playMusic(4);
		control.Printstring("Aikasi: ", 0, 0);
		control.Printstring("esc lopettaa", 0, 2);
		if (Button.ESCAPE.isDown()) {
			control.shutdown();
		}
	}
}
