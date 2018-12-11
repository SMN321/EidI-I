//Wilhelmstaetter, Simon

public class Train{
	
	private String baureihe;
	private boolean elektrisch;
	private int ps;
	private int maxSpeed;
	private Waggon nachfolger;
	
	public Train() {
		baureihe = "412";
		elektrisch = true;
		ps = 13500;
		maxSpeed = 250;
	}
	
	public Train(String baureihe, boolean elektrisch, int ps, int maxSpeed, Waggon nachfolger) {
		this.baureihe = baureihe;
		this.elektrisch = elektrisch;
		this.ps = ps;
		this.maxSpeed = maxSpeed;
		this.nachfolger = nachfolger;
	}
	
	public void setNachfolger(Waggon nachfolger) {
		this.nachfolger = nachfolger;
	}
	
	public void anhaengen(Waggon nachfolger) {
		if (this.nachfolger != null) {
			this.nachfolger.anhaengen(nachfolger);
		} else {
			this.nachfolger = nachfolger;
		}
	}
	
	public String toString(){
		String baurStr = "Baureihe: " + baureihe + "\n";
		String elekStr = elektrisch ? "elektrisch\n" : "Diesel\n";
		String psStr = "PS: " + ps + "\n";
		String maxSpStr = "Hoechstgeschwindigkeit: " + maxSpeed + "km/h\n";
		String nachfolgerStr = nachfolger != null ? nachfolger.toString() + "\n" : "";
		return "Zugfahrzeug:\n" + baurStr + elekStr + psStr + maxSpStr + nachfolgerStr;
	}
	
	public int freiePlaetze() {
		return nachfolger != null ? nachfolger.freiePlaetze() : 0;
	}
	
	public void lichtAn(boolean an) {
		if (nachfolger != null) {
			nachfolger.lichtAn(an);
		}
	}
	
	public void kontrolle() {
		if (nachfolger != null) {
			nachfolger.kontrolle();
		}
	}
	
	public void endhalt() {
		if (nachfolger != null) {
			nachfolger.endhalt();
		}
	}
}


