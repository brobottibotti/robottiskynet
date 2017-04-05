import java.io.File;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.Sound;

public class Pilot {
	
	private int menunumber;
	private int errorMargin = 12;
	private boolean rightdown = true;
	private boolean leftdown = true;
	private boolean firstDodge = false;
	private int endtime;
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
		
		control.Printstring("0 menu", 0, 0);
		control.Printstring("1 kalibrointi", 0, 1);
		control.Printstring("2 aja", 0, 2);
		control.Printstring("3 final", 0, 3);
		control.Printint(menunumber, 0, 6);
		
		control.Printint(control.getSpeed(), 0, 5);
		Button.readButtons();
		if(Button.readButtons()==Button.ID_RIGHT){
			if (rightdown){
			menunumber++;
			}
			rightdown = false;
		
		}else if (Button.readButtons()==Button.ID_LEFT){
			if (leftdown){
				menunumber--;
				}
				leftdown = false;
		}else if (Button.readButtons()==Button.ID_ENTER) {
			LCD.clear();
			control.time.stopwatch.reset();
			control.setPilot(menunumber);
		}
		else {
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
		if (Button.RIGHT.isPressed()) {
			control.setBlackLight();
			control.Printint(control.getBlackLight(), 0, 3);
		} else if (Button.LEFT.isPressed()) {
			control.setWhiteLight();
			control.Printint(control.getWhiteLight(), 0, 4);
		} else if (Button.ESCAPE.isPressed()) {
			LCD.clear();
			control.playMusic(3);
			control.setPilot(0);
		}
	}

	// case Ajo-tila. Tässä casessa robotti pyrkii seuraamaan mustaa viivaa.
	private void Drive() {
		control.playMusic(2);
		control.Printstring("Aika: ", 0, 0);
		control.Printint(control.getTime(), 7, 0);
		control.Printint(control.getLight(), 0, 4);
		control.Printint(control.sense(), 0, 6);
		
		
		//Kommenttiåaksaa
		if (!control.getIsBlocked()) {

			if (control.getLight() <= control.getBlackLight() + errorMargin) {
				// control.turnRight();

				control.steerRun(2);
			} else if (control.getLight() >= control.getWhiteLight()
					- errorMargin) {
				// control.turnLeft();

				control.steerRun(1);
			} else {
				// control.forward();
				control.steerRun(3);
			}
			if (Button.ESCAPE.isPressed()) {
				// control.fullstop();
				control.steerRun(4);
				LCD.clear();
				control.setPilot(5);
			}
		} else {
			if (!firstDodge) {
				control.setPilot(3);
			} else {
				endtime = control.endTime();
				control.fullstop();
				control.setPilot(5);
			}
		}
	}
	
	public void Dodge(){
		control.playMusic(3);
		firstDodge = true;
		control.dodgeManeuver();
		
//		if (control.getLight() <= control.treshold()) {
//			// control.turnRight();
//			control.setPilot(7);
		//}	
		}

	
	
	public void Lineseeker(){
		control.forward();
		control.playMusic(5);
		control.Printint(control.getLight(), 0, 3);
		if (control.getLight() <= control.treshold()-10){
			control.fullstop();
			control.diffRotate(20);
			
			control.setPilot(2);
		} 

		
	}
	
	

	// loppu tila pilotti
	private void Final() {
		control.playMusic(4);
		control.Printstring("Aikasi: ", 0, 0);
		control.Printint(endtime, 10, 0);
		control.Printstring("esc lopettaa", 0, 2);
		if(Button.ESCAPE.isDown()){
			control.shutdown();
		}
		


	}
}
