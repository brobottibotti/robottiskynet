import lejos.util.Stopwatch;

public class Time {

	/**
	 * Muuttuja joka ilmoittaa lopetusajan.
	 */
	private int endtime;
	Control control;
	/**
	 * @see <a
	 *      href="http://www.lejos.org/nxt/nxj/api/lejos/util/Stopwatch.html">lejos.util.StopWatch</a>
	 */
	Stopwatch stopwatch = new Stopwatch();

	/**
	 * M‰‰ritt‰‰ hallintaolion viitteen
	 * 
	 * @param c
	 *            control olion viite
	 */
	public Time(Control c) {
		this.control = c;
	}

	/**
	 * Palauttaa ajan.
	 * 
	 * @return palauttaa ajan sekuntteina
	 * @see <a
	 *      href="http://www.lejos.org/nxt/nxj/api/lejos/util/Stopwatch.html">lejos.util.StopWatch</a>
	 */
	public int getTime() {
		return stopwatch.elapsed() / 1000;
	}

	/**
	 * Lopetus ajan haku metodi.
	 * 
	 * @return palauttaa lopetusajan.
	 * @see <a
	 *      href="http://www.lejos.org/nxt/nxj/api/lejos/util/Stopwatch.html">lejos.util.StopWatch</a>
	 */
	public int endTime() {
		endtime = this.getTime();
		return endtime;
	}

}
