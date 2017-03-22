import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
import lejos.util.Stopwatch;
import lejos.util.Timer;
import lejos.util.TimerListener;


public class Varisensori implements Runnable{
	ColorSensor vari = new ColorSensor(SensorPort.S1);
	Stopwatch ajanotto = new Stopwatch();
	private boolean isRunning;
	String vasen = "kaanny vasemmalle";
	String oikea = "Kaanny oikealle";
	private int aika = 0;
	final int mustaValkoRaja = 20;
	final int eteen = 1;
	final int stop = 3;
	final int flt = 4;
	final int voima = 80;
	final int kaannosvoima = 30;

	public synchronized boolean getRunning(){
		return isRunning;
		
	}
	public synchronized void setRunning(boolean r){
		this.isRunning = r;
	}
	public Varisensori(){
		isRunning = true;
	}

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		vari.setFloodlight(true);
		LCD.drawString("VALO %", 0, 0);
		LCD.drawString("PAINA VASEMMALLE", 0, 2);
		LCD.drawString("aloittaaksesi",0,3);
		while(!Button.LEFT.isPressed()){
			LCD.drawInt(vari.getLightValue(), 3, 9, 0);
			ajanotto.reset();
			isRunning = true;
		}
			
		
		LCD.drawString("Paina escia", 0, 2);
		LCD.drawString("pysayttaaksesi", 0, 3);
		LCD.drawString("aika:", 0, 4);
		LCD.drawInt(ajanotto.elapsed(), 0, 5);
		//while loopin sisällä kaikki viivan seuraus toiminnot.
		while(!Button.ESCAPE.isPressed()){
			if(vari.getLightValue() > mustaValkoRaja){
				LCD.drawString(oikea, 0, 1);
				MotorPort.B.controlMotor(kaannosvoima, eteen);
				MotorPort.C.controlMotor(voima,eteen);
				
			}
			else{
				LCD.drawString(vasen, 0, 1);
				MotorPort.B.controlMotor(voima,eteen);
				MotorPort.C.controlMotor(kaannosvoima,eteen);

			}
			LCD.drawInt(vari.getLightValue(), 3, 9, 0);
			aika = ajanotto.elapsed();
			LCD.drawInt(aika/1000, 0, 5);
			if(Button.ESCAPE.isPressed()){
				this.isRunning = false;
			}
		}

	MotorPort.B.controlMotor(0,flt);
	MotorPort.C.controlMotor(0,flt);
	LCD.clear();
	LCD.drawString("aikasi oli: ", 0, 1);
	LCD.drawInt(aika/1000, 0, 2);
	LCD.drawString("Ohjelma loppui", 0, 0);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}




}
