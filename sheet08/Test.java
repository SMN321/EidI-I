//wilhelmstaetter, Simon

public class Test{
	
	public static void main(String[] args) {
		Train train1 =  new Train(); //hat schon geforderte Attribute
		train1.setNachfolger(new Waggon(50, 24, 3, true, true, null));
		train1.anhaengen(new Waggon(100, 12, 64, false, true, null));
		train1.anhaengen(new Waggon(100, 32, 11, false, true, null));
		train1.anhaengen(new Waggon(50, 17, 3, true, true, null));
		
		System.out.println("train1:\n" + train1);
		
		System.out.println("Freie Plaetze in train1: " + train1.freiePlaetze());
		
		train1.lichtAn(true);
		System.out.println("\ntrain1 nach \"lichtAn(true)\":\n" + train1);
		
		train1.endhalt();
		System.out.println("\ntrain1 nach\"endhalt()\":\n" + train1);
		
	}
}