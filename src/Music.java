import java.io.File;

import lejos.nxt.Button;
import lejos.nxt.Sound;

public class Music {
	
	static File sbeback = new File("t1__be_back.wav");
	static File saffirmative = new File("t2_affirmative.wav");
	static File sterminator = new File("t2_terminator.wav");
	static File sterminated = new File("t3_terminated.wav");
	static File sfu = new File("t1_fu.wav");
	

	boolean bbeback = false;
	boolean baffirmative = false;
	boolean bterminator = false;
	boolean bterminated = false;
	boolean bfu = false;
	
	
	
	Control control;
	Boolean isPlaying;
	
	public Music(Control c)
	{
		this.control = c;
	}
	
	private final static int C2 = 65;
	private final static int D2 = 73;
	private final static int D1 = 37;
	private final static int A1 = 55;
	private final static int D1s = 39;
	private final static int D2s = 78;
	private final static int A1s = 58;
	private final static int C4 = 262;
	private final static int D4 = 294;
	private final static int E4 = 330;
	private final static int F4 = 349;
	private final static int G4 = 392;
	private final static int A4 = 440;
	private final static int As4 = 466;
	private final static int B4 = 494;

	private final static int C5 = 523;
	private final static int Cs5 = 554;
	private final static int D5 = 587;
	private final static int Ds5 = 622;
	private final static int E5 = 659;
	private final static int F5 = 698;
	private final static int Fs5 = 740;
	private final static int G5 = 784;
	private final static int A5 = 880;

	private final static int C6 = 1047;
	private final static int Eb3 = 156; 
	private final static int G3 = 196; 
	private final static int Bb3 = 233; 
	private final static int A3 = 220; 
	private final static int Ab3 = 207;
	private final static int G2 =  98;
	
	private final static int Eb2 = 78; 
	private final static int Bb2 = 117; 
	private final static int A2 = 110; 
	private final static int Ab2 = 103;
	private final static int G1 =  49;
	public void setobjects(Control c) {
		this.control = c;
	}

	
	//Soon to be arska
	public void arska(){
	play(659, 100, 150);
	play(659, 100, 300);
	play(659, 100, 300);
	play(523, 100, 100);
	play(659, 100, 300);
	play(784, 100, 550);
	play(392, 100, 575);

	play(Eb3, 100, 200);
	play(Eb3, 100, 350);
	play(Eb3, 100, 340);
	play(Eb3, 100, 260);
	play(Eb3, 100, 320);
	play(Eb3, 100, 300);
	Sound.setVolume(88);
	play(Eb3, 100, 200);
	play(Eb3, 100, 350);
	play(Eb3, 100, 340);
	play(Eb3, 100, 260);
	play(Eb3, 100, 320);
	play(Eb3, 100, 300);
	Sound.setVolume(100);
	play(Eb3, 100, 200);
	play(Eb3, 100, 350);
	play(Eb3, 100, 340);
	play(Eb3, 100, 260);
	play(Eb3, 100, 320);
	play(Eb3, 100, 300);
	}
	

	
	//maali
	public void endMusic(){
	play(E5, 200, 250);
	play(E5, 200, 250);
	play(E5, 200, 250);
	play(E5, 300, 350);
	play(E5, 300, 350);
	play(E5, 300, 350);
	
	play(E5, 250, 350);
	play(E5, 200, 250);
	play(E5, 400, 350);
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
			bterminated = false;
			bfu = false;
			}
			break;

		case 2:
			if (!bterminator) {
			Sound.playSample(sterminator);
			bterminator = true;
			baffirmative = false;
			bterminated = false;
			bfu = false;
			bbeback = false;
			}
			break;
		case 3:
			if (!baffirmative) {
			Sound.playSample(saffirmative);
			bterminator = false;
			baffirmative = true;
			bterminated = false;
			bfu = false;
			bbeback = false;
			}
			break;

		case 4:
			if (!bterminated) {
			Sound.playSample(sterminated);
			baffirmative = false;
			bterminator = false;
			bterminated = true;
			bfu = false;
			bbeback = false;
			}
			break;
			
		case 5:
			if (!bfu) {
			Sound.playSample(sfu);
			baffirmative = false;
			bterminator = false;
			bterminated = false;
			bfu = true;
			bbeback = false;
			}
			break;

		
		
	}
	}
}