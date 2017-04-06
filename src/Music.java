import java.io.File;
import lejos.nxt.Sound;

public class Music {

	private File sbeback = new File("t1_be_back.wav");
	private File sterminator = new File("t2_terminator.wav");
	private File saffirmative = new File("t2_affirmative.wav");
	private File shasta = new File("t2_hasta.wav");
	private File sfu = new File("t1_fu.wav");

	private boolean bbeback = false;
	private boolean bterminator = false;
	private boolean baffirmative = false;
	private boolean bhasta = false;
	private boolean bfu = false;

	Control control;

	/**
	 * M‰‰ritt‰‰ hallintaolion viitteen
	 * 
	 * @param c
	 *            control olion viite
	 */
	public Music(Control c) {
		this.control = c;
	}

	/**
	 * Switch case musiikin vaihtamiselle
	 * 
	 * @param i
	 *            interget muuttuja joka m‰‰ritt‰‰ soitettavan ‰‰nen.
	 * @see <a
	 *      href="http://www.lejos.org/p_technologies/nxt/nxj/api/lejos/nxt/Sound.html">lejos.nxt.Sound</a>
	 */
	public void playMusic(int i) {
		switch (i) {
		case 1:
			if (!bbeback) {
				Sound.playSample(sbeback);
				bbeback = true;
				bterminator = false;
				baffirmative = false;
				bhasta = false;
				bfu = false;
			}
			break;

		case 2:
			if (!bterminator) {
				Sound.playSample(sterminator);
				bbeback = false;
				bterminator = true;
				baffirmative = false;
				bhasta = false;
				bfu = false;
			}
			break;

		case 3:
			if (!baffirmative) {
				Sound.playSample(saffirmative);
				bbeback = false;
				bterminator = false;
				baffirmative = true;
				bhasta = false;
				bfu = false;
			}
			break;

		case 4:
			if (!bhasta) {
				Sound.playSample(shasta);
				bbeback = false;
				bterminator = false;
				baffirmative = false;
				bhasta = true;
				bfu = false;
			}
			break;

		case 5:
			if (!bfu) {
				Sound.playSample(sfu);
				bbeback = false;
				bterminator = false;
				baffirmative = false;
				bhasta = false;
				bfu = true;
			}
			break;

		}
	}
}