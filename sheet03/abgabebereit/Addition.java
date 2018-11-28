import java.util.InputMismatchException;
import java.util.Scanner;

public class Addition {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
		
		//Deklaration der Variable "eingabe1" (Festlegung des Datentyps (hier: int) und Reservierung des Speicherbereiches(hier: 32bit))
		//mit anschließender Initialisierung (erste Wertzuweisung)
		int eingabe1 = readIntFromConsole();
        
		System.out.println("Ihre Eingabe: " + eingabe1);
		System.out.println("Die Variable \"eingabe1\" besitzt den Wert " + eingabe1 + "\n");
		
		int eingabe2 = readIntFromConsole();
		System.out.println("Die Variable \"eingabe2\" besitzt den Wert " + eingabe2 + "\n");
		
		int summe = eingabe2 + eingabe1;
		System.out.println("Die Summe der beiden Eingaben lautet " + summe);
		
		//heir jetzt nochmal Aufgabe c) explizit.
		System.out.println("eingabe1 = " + eingabe1);
		System.out.println("eingabe2 = " + eingabe1);
		System.out.println("summe = " + summe);		
    }

    /**
     * #BLACKBOX
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als int
     */
    public static int readIntFromConsole() {

        System.out.print("Please insert a whole number: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not a whole number!");
            scanner.next();
        }

        return readIntFromConsole();
    }
}
