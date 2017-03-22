import lejos.nxt.Button;




public class Time implements Runnable{
	boolean stop=false;
	boolean tanssitaanko;
	Control control;

	
	public void setobjects(Control c)
	{
		this.control = c;
	}
	
	public void tanssiAjastin(){
		while(!stop){
			
			
			while(Button.RIGHT.isPressed()){
				control.danceLeft();
			}
			control.vaihdasuunta();
			
		}
	}
	@Override
	public void run() {
		tanssiAjastin();
		
		
		
	}

}
