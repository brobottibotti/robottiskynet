public class Pilot {

	Control control;
	
	public void setobjects(Control c)
	{
		this.control=c;
	}
	
	public void Run(int type) {

		switch (type) {
		case 1:
			Test();
			break;
		
		case 2:
			Calibrate();
			break;
		}
	}
	
	

	public void Test() {
		control.Print("moro!");
	}
	
	public void Calibrate(){
		
	}

}
