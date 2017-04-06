import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;

public class Colorsensor implements Runnable {
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	Control control;
	private int blacklight = 15;
	private int whitelight = 45;
	private int lightvalue;

	public void setobjects(Control c) {
		this.control = c;
	}

	public Colorsensor(Control c) {
		this.control = c;
	}

	// P‰ivitt‰‰ light attribuuttiin valosensorin arvon

	private void updatecolor() {
		lightvalue = colorsensor.getLightValue();
	}

	// Palauttaa lightvalue attribuutin arvon

	public int getLight() {
		// return colorsensor.getLightValue();
		return lightvalue;
	}

	// asettaa blacklight arvon

	public void setBlackLight() {
		colorsensor.setFloodlight(true);
		blacklight = colorsensor.getLightValue();
	}

	// Palauttaa blacklight arvon

	public int getBlackLight() {
		return blacklight;
	}

	// Asetetaan whitelight arvon

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
		while (!control.getStop()) {
			updatecolor();
		}
	}

}
