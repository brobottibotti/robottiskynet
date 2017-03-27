import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

public class Colorsensor implements Runnable {
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	Control control;
	int blacklight;
	int whitelight;
	boolean mittaus;
	int lightvalue;

	public void setobjects(Control c) {
		this.control = c;
	}

	// P‰ivitt‰‰ light attribuuttiin valosensorin arvon

	public void updatecolor() {
		lightvalue = colorsensor.getLightValue();
	}

	// Palauttaa lightvalue attribuutin arvon

	public int getLight() {
		return lightvalue;
	}

	// Kalibroinnin aikainen blacklight arvon asetus

	public void setBlackLight() {
		colorsensor.setFloodlight(true);
		blacklight = colorsensor.getLightValue() + 10;
	}

	// Palauttaa blacklight arvon

	public int getBlackLight() {
		return blacklight;
	}

	// Mahdollinen valkoisen arvon maksimiarvo

	public void setWhiteLight() {
		colorsensor.setFloodlight(true);
		whitelight = colorsensor.getLightValue();
	}

	// Palauttaa WhiteLight arvon

	public int getWhiteLight() {
		return whitelight;
	}

	// Colorsensor s‰ie jolla p‰ivitet‰‰n Lightvalue attribuuttia kutsumalla
	// metodia.

	public void run() {

		// vaihda stoppi controllin kautta jossain vaiheessa
		while (!control.getStop()) {
			updatecolor();
		}
	}

}
