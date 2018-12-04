//Wilhelmstaetter, Simon

class Karteikarte{

    private String vorderseite;
    private String rueckseite;

    //Konstruktor
    public Karteikarte(String vorderseite, String rueckseite){
        this.vorderseite = vorderseite;
        this.rueckseite = rueckseite;
    }

    public static void main(String[] args) {
        
        Karteikarte k1 = new Karteikarte("kompakte Menge",
                "Eine Menge heißt _kompakt_, wenn sie abgeschlossen und beschränkt ist\n Beispiel: [0,1]");

        Karteikarte k2 = new Karteikarte("kompakte Menge",
                "Eine Menge heißt _kompakt_, wenn sie abgeschlossen und beschränkt ist\n Beispiel: [0,1]");

        Karteikarte k3 = new Karteikarte("Eine Menge heißt _kompakt_, wenn sie abgeschlossen und beschränkt ist\n Beispiel: [0,1]", "kompakte Menge");

        Karteikarte k4 = new Karteikarte("Wilde Moehre",
                "Die Wilde Möhre ist ein Doldenblütler und ein Elternteil der Karotte.");

        System.out.println("\"k1.toString\" ergibt: " + k1); //ruft "String.valueOf(ki)" auf, was wiederrum (falls k1 != null) "k1.toString()" aufruft. Die "toString()" 
								//Methode wird (da nicht überschreiben) von der Klasse "Object" geerbt und gibt den Name der Klasse des Objekts 
								//(hier: Karteikarte) + @ + den Wert der Methode "hashCode()" (ebenfalls von "Obejct" geerbt) zurück. 
								//Somit ist der Output gleich getClass().getName() + '@' + Integer.toHexString(hashCode()).
		
		//".equals()" ergibt ohne sinvolle Überschreibung immer "false" zurück, da auf Gleichheit im Sinne von "==" (gleiches Objekt) vergleichen wird (was eben immer "false" ist).
        System.out.println("\"k1.equals(k2)\" ergibt: " + k1.equals(k2));
        System.out.println("\"k1.equals(k3)\" ergibt: " + k1.equals(k3));
        System.out.println("\"k1.equals(k4)\" ergibt: " + k1.equals(k4));
    }
	
	private boolean equals(Karteikarte k2) {
		return this.vorderseite.equals(k2.vorderseite) && this.rueckseite.equals(k2.rueckseite) || this.vorderseite.equals(k2.rueckseite) && this.rueckseite.equals(k2.vorderseite);
	}
}

