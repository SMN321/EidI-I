import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorial {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = readIntFromConsole();

        //TODO: a)
		if(!(n>0)){
			System.out.println(1);
		}else{
			int f = n;
			
			while(n>2){
				n = n-1;
				f = f*n;
			}
			
			System.out.println(f);
		}
    }
	
	//Zu Aufgabe 3 b):
	/*Es fällt auf, dass die Ergebnisse ab 13! nicht mehr an Zehnerpotenzen wachsen und
	* teilweise kleiner sind als der davor berechnete Wert obwohl sie größer
	* sein sollten.
	* Der Wertebereich des Datentyps "int" geht bis ungefähr 2.000.000.000. 
	* Da die Werte im Zweierkomplement gespeichert werden, wird beim Overflow
	* einfach der Überschuss abgeschnitten und die letzten 8 Bit als Wert gespeichert
	* und als Zweierkomplement interpretiert. Der so entstandene Wert ist natürlich 
	* unbrauchbar und wird falls das MSB=1 sogar negativ (z.B. bei Eingabe "17").
	*/
	
	//Zu Aufgabe 3 c):
	/*Natürlich gibt es für den Datentyp "long" ein vergleichbares Problem, da
	* auch dessen darstellbarer Wertebereich endlich ist. Er ist zwar großer als
	* beim "int" aber trotzdem endlich. Somit kommt es auch dort zum Overflow.
	* Ein möglicher Eingabewert um das zu sehen wäre 1337!.
	*/
	
    /**
     * #BLACKBOX
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als int
     */
    public static int readIntFromConsole() {

        System.out.print("Please input a natural number or 0: ");
        try {
            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("[Error] Input is not a natural number or 0!");
                return readIntFromConsole();
            } else {
                return n;
            }
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not a number!");
            scanner.next();
        }

        return readIntFromConsole();
    }
}
