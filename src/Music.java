import java.io.File;

import lejos.nxt.Button;
import lejos.nxt.Sound;

public class Music {
	
	static File sbeback = new File("t1__be_back.wav");
	static File saffirmative = new File("t2_affirmative.wav");
	static File sterminator = new File("t2_terminator.wav");
	static File shasta = new File("t2_hasta.wav");
	static File sfu = new File("t1_fu.wav");
	static File sterminated = new File("t3_terminated.wav");
	

	boolean bbeback = false;
	boolean baffirmative = false;
	boolean bterminator = false;
	boolean bhasta = false;
	boolean bfu = false;
	boolean bterminated = false;
	
	
	
	Control control;
	Boolean isPlaying;
	
	public Music(Control c)
	{
		this.control = c;
	}


	public static void play(int freq, int dur, int delay) {
		if (10 <= freq  && freq  <= 12000 &&
			10  <= dur   && dur   <= 10000 &&
			10  <= delay && delay <= 10000) {
			//Sound.playTone(freq, dur);
			
			try {
				Thread.sleep(delay);
			}
			catch (Exception e) {}
		}
	}
	
	public void playMusic(int i){
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
			bterminator = true;
			baffirmative = false;
			bhasta = false;
			bfu = false;
			bbeback = false;
			}
			break;
			
		case 3:
			if (!baffirmative) {
			Sound.playSample(saffirmative);
			bterminator = false;
			baffirmative = true;
			bhasta = false;
			bfu = false;
			bbeback = false;
			}
			break;

		case 4:
			if (!bhasta) {
			Sound.playSample(shasta);
			baffirmative = false;
			bterminator = false;
			bhasta = true;
			bfu = false;
			bbeback = false;
			}
			break;
			
		case 5:
			if (!bfu) {
			Sound.playSample(sfu);
			baffirmative = false;
			bterminator = false;
			bhasta = false;
			bfu = true;
			bbeback = false;
			}
			break;
			
		
		
		
	}
	}
}