import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;

public class Colorsensor implements Runnable {
	ColorSensor colorsensor = new ColorSensor(SensorPort.S1);
	Control control;
	private int blacklight = 20;
	private int whitelight = 50;
	private int lightvalue;

	/**
	 * M‰‰ritt‰‰ hallintaolion viitteen
	 * 
	 * @param c
	 *            control olion viite
	 */
	public Colorsensor(Control c) {
		this.control = c;
	}

	/**
	 * P‰ivitt‰‰ light attribuuttiin valosensorin arvon
	 */
	private void updatecolor() {
		lightvalue = colorsensor.getLightValue();
	}

	/**
	 * @return Palauttaa lightvalue attribuutin arvon
	 */

	public int getLight() {
		return lightvalue;
	}

	/**
	 * asettaa blacklight arvon
	 */
	public void setBlackLight() {
		colorsensor.setFloodlight(true);
		blacklight = colorsensor.getLightValue();
	}

	/**
	 * palauttaa blacklight arvon
	 * 
	 * @return
	 */
	public int getBlackLight() {
		return blacklight;
	}

	/**
	 * Asettaa whitelight arvon
	 */
	public void setWhiteLight() {
		colorsensor.setFloodlight(true);
		whitelight = colorsensor.getLightValue();
	}

	/**
	 * palauttaa whitelight arvon
	 * 
	 * @return
	 */
	public int getWhiteLight() {
		return whitelight;
	}

	/**
	 * Laskee valoarvojen keskiarvon
	 * 
	 * @return Palauttaa keskiarvon
	 */
	public int treshold() {
		return (whitelight + blacklight) / 2;
	}

	/**
	 * Colorsensor s‰ie jolla p‰ivitet‰‰n Lightvalue attribuuttia kutsumalla
	 * metodia
	 * 
	 * @see <a
	 *      href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#run()">java.lang.Runnable#run()</a>
	 */
	public void run() {
		while (!control.getStop()) {
			updatecolor();
		}
	}

}
