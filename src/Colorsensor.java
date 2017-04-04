import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;

public class Colorsensor implements Runnable {
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	Control control;
	int blacklight = 15;
	int whitelight = 45;
	boolean mittaus;
	int lightvalue;

	public void setobjects(Control c) {
		this.control = c;
	}
	public Colorsensor(Control c)
	{
		this.control = c;
	}

	// P‰ivitt‰‰ light attribuuttiin valosensorin arvon

	public void updatecolor() {
		lightvalue = colorsensor.getLightValue();
	}

	// Palauttaa lightvalue attribuutin arvon

	public int getLight() {
		//return colorsensor.getLightValue();
		return lightvalue;
	}

	// Kalibroinnin aikainen blacklight arvon asetus

	public void setBlackLight() {
		colorsensor.setFloodlight(true);
		blacklight = colorsensor.getLightValue();
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

	public int treshold() {
		return (whitelight + blacklight) / 2;
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
