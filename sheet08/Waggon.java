//Wilhelmstaetter, Simon

public class Waggon{
	
	private int plaetzeGesamt;
	private int plaetzeFrei;
	private int plaetzeReserviert;
	private boolean klasse1; //da es nur zwei Zustaende gibt
	private boolean doppelstock;
	private statusToilette cST; //currentStatusToilette
	private Waggon nachfolger;
	private boolean lichtAn;
	
	private static enum statusToilette {FREI, BESETZT, DEFEKT} //0 == frei, 1 == besetzt, 2 == defekt
	
	public Waggon() {
		plaetzeGesamt = 100;
		plaetzeFrei = plaetzeGesamt;
		plaetzeReserviert = 0;
		klasse1 = false;
		doppelstock = false;
		cST = statusToilette.values()[(Math.random() < 0.7) ? 0 : 2]; //(Math.random() < 0.7) ist zu 70% true
	}
	
	public Waggon(int plaetzeGesamt, int plaetzeFrei, int plaetzeReserviert, boolean klasse1, boolean doppelstock, Waggon nachfolger) {
		this.plaetzeGesamt = plaetzeGesamt;
		this.plaetzeFrei = (plaetzeFrei < plaetzeGesamt - plaetzeReserviert) ? plaetzeFrei : (plaetzeGesamt - plaetzeReserviert >= 0) ? plaetzeGesamt - plaetzeReserviert : 0;
		this.plaetzeReserviert = plaetzeReserviert;
		this.klasse1 = klasse1;
		this.doppelstock = doppelstock;
		cST = statusToilette.values()[(Math.random() < 0.7) ? 0 : 2]; //(Math.random() < 0.7) ist zu 70% true
		this.nachfolger = nachfolger;
	}
	
	public void setNachfolger(Waggon nachfolger) {
		this.nachfolger = nachfolger;
	}
	
	public boolean hasNachfolger() {
		return nachfolger != null;
	}
	
	public void anhaengen(Waggon nachfolger) {
		if (this.nachfolger != null) {
			this.nachfolger.anhaengen(nachfolger);
		} else {
			this.nachfolger = nachfolger;
		}
	}
	
	public String toString() {
		String plStr = "Sitzplaetze: gesamt: " + plaetzeGesamt + " / frei: " + plaetzeFrei + " / reserviert: " + plaetzeReserviert + "\n"; 
		String klStr = (klasse1 ? "1. Klasse" : "2. Klasse") + "\n";
		String doStr = (doppelstock ? "doppelstock" : "einzelstock") + "\n";
		String lichtStr = "Licht: " + (lichtAn ? "An" : "Aus") + "\n";
		String toilStr = "Toilettenstatus: " + (cST == statusToilette.DEFEKT ? "defekt" : cST == statusToilette.BESETZT ? "besetzt" : "frei") + "\n";
		String nachStr = (nachfolger != null) ? nachfolger.toString() : "";
		return "\nWaggon: \n" + plStr + klStr + doStr + lichtStr + toilStr + nachStr;
	}
	
	public int freiePlaetze() {
		return plaetzeFrei + (nachfolger != null ? nachfolger.freiePlaetze() : 0);
	}
	
	public void lichtAn(boolean an) {
		lichtAn = !an ? false : (Math.random() < 0.5) ? true : false;
		if (nachfolger != null) {
			nachfolger.lichtAn(an);
		}
	}
	
	public void kontrolle() {
		cST = statusToilette.values()[(cST != statusToilette.DEFEKT) ? 1 : 2];
		if (nachfolger != null) {
			nachfolger.kontrolle();
		}
	}
	
	public void endhalt() {
		plaetzeFrei = plaetzeGesamt;
		plaetzeReserviert = 0;
		cST = statusToilette.values()[cST != statusToilette.DEFEKT ? 0 : (Math.random() < 0.5) ? 0 : 2];
		if (nachfolger != null) {
			nachfolger.endhalt();
		}
	}
	
}