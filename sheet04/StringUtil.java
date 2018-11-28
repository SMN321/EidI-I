import java.util.InputMismatchException;
import java.util.Scanner;

public class StringUtil {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String in = readStringFromConsole();
        System.out.println("Input: " + in);
		
		String out = new String(""); //wird zur Ausgabe aufgebaut, da "in" unveränderlich ist
		
		int length = in.length();
		for(int index=0; index<length; index++){
			
			int AsciiWert = in.charAt(index); //Variablen immer klein!!! (edited: 15.11.2018)
			
			if(AsciiWert<=122 && AsciiWert>=97){//wenn das Zeichen ein kleiner Buchstabe ist 
				AsciiWert -= 32; //verändert den Wert zum entsprechenden Wert des großen Buchstaben
			}
			out = out + (char)AsciiWert;
		}
		
		System.out.println("\nMit nur Grossbuchstaben: " + out);
		
    }

    /**
     * #BLACKBOX
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als String
     */
    public static String readStringFromConsole() {

        System.out.print("Please input a String: ");
        try {
            return scanner.nextLine();
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not valid!");
            scanner.next();
        }

        return readStringFromConsole();
    }
}
