import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Pilot {

	private int menunumber;
	/**
	 * Muuttuja, jolla pienennetään viivanseurannan harmaata aluetta.
	 */
	private int errorMargin = 3;
	private boolean rightdown = true;
	private boolean leftdown = true;
	private int Dodges = 0;
	private int obstacles = 1;
	Control control;

	/**
	 * Määrittää hallintaolion viitteen
	 * 
	 * @param c
	 *            control olion viite
	 */
	public Pilot(Control c) {
		this.control = c;
	}

	/**
	 * "pilotti" switch case, joka ohjaa ohjelman kulkua
	 * 
	 * @param type
	 *            integer muuttuja joka vaihtaa casea.
	 */
	public void Run(int type) {

		switch (type) {
		case 0:
			Menu();
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

	/**
	 * Valikko pilotti, jonka avulla ohjelmasta voidaan kutsua eri pilotteja.
	 */
	private void Menu() {
		control.playMusic(3);
		control.Printstring("0 menu", 0, 0);
		control.Printstring("1 kalibrointi", 0, 1);
		control.Printstring("2 aja", 0, 2);
		control.Printint(menunumber, 0, 6);

		control.Printint(control.getSpeed(), 0, 5);
		Button.readButtons();
		if (Button.readButtons() == Button.ID_RIGHT) {
			if (rightdown && menunumber >= 0 && menunumber < 2) {
				menunumber++;
			}
			rightdown = false;

		} else if (Button.readButtons() == Button.ID_LEFT) {
			if (leftdown && menunumber > 0 && menunumber <= 2) {
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

	/**
	 * Kalibrointi pilotti, jossa asetetaan käytettävän blacklight ja whitelight
	 * arvot.
	 */
	private void Calibrate() {

		control.Printstring("black >", 0, 0);
		control.Printstring("white <", 0, 1);
		control.Printstring("esc menu", 0, 2);
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

	/**
	 * Ajo pilotti, jossa hallitaan robotin viivanseurantaa käyttämällä saatuja
	 * väriarvoja ja esteen havaitessa pilotti tarkistaa esteen numeron ja joko
	 * suorittaa väistöliikkeen tai vaihtaa pilotin Final:iin
	 */
	private void Drive() {

		control.Printstring("Aika: ", 0, 0);
		control.Printint(control.getTime(), 10, 0);
		control.Printstring("Valo: ", 0, 1);
		control.Printint(control.getLight(), 10, 1);
		control.Printstring("ultra: ", 0, 2);
		control.Printint(control.sense(), 10, 2);
		control.Printstring("musta", 0, 5);
		control.Printint(control.getBlackLight(), 10, 5);
		control.Printstring("valkonen", 0, 6);
		control.Printint(control.getWhiteLight(), 10, 6);

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
			if (Dodges < obstacles) {
				control.setPilot(3);
			} else {
				LCD.clear();
				control.Printint(control.endTime(), 10, 0);
				control.fullstop();
				control.setPilot(5);
			}
		}
	}

	/**
	 * Väistö pilotti, joka soittaa määritetyn äänitiedoston, vaihtaa
	 * ensimmäinen dodge muuttujan arvon ja kutsuu väistö metodia.
	 */
	private void Dodge() {
		control.playMusic(1);
		Dodges++;
		control.dodgeManeuver();
	}

	/**
	 * Viivan etsintä pilotti, joka soittaa määritetyn äänitiedoston, liikuttaa
	 * robottia eteenpäin ja viivan havaitessaan kääntää robottia oikealle,
	 * jotta lähestymiskulma olisi loivempi.
	 */
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

	/**
	 * Viimeinen pilotti, joka soittaa määritetyn äänitiedoston, ja jää
	 * näyttämään ohjelman kuluttamaa aikaa kunnes ohjelma sammutetaan.
	 */
	private void Final() {
		control.playMusic(4);
		control.Printstring("Aikasi: ", 0, 0);
		control.Printstring("esc lopettaa", 0, 2);
		if (Button.ESCAPE.isDown()) {
			control.shutdown();
		}
	}
}
