import java.util.InputMismatchException;
import java.util.Scanner;

public class Loops {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = readIntFromConsole();

        //TODO: a)
		System.out.print("\na): ");
		for(int i=1; i<=n; i++){
			System.out.print(i + " ");
		}
		
        //TODO: b)
        //i)
		System.out.print("\n\nb) (1): ");
		for(int i=1; i<=n; i++){
			if(i%2 == 0){
				System.out.print(i + " ");
			}
		}
		
        //ii)
		System.out.print("\nb) (2): ");
		for(int i=2; i<=n; i=i+2){
			System.out.print(i + " ");
		}
		
        //iii) 
		//Aufgabe unklar formuliert
		System.out.print("\nb) (3): ");
		for(int i=1; i<=n/2; i++){
			System.out.print(2*i + " ");
		}
		
		System.out.println();
		
        //TODO: c)
		System.out.print("\n\nc): ");
        for(int i=n; -i<=n; i--){
			System.out.print(i + " ");
		}
    }

    /**
     * #BLACKBOX
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als int
     */
    public static int readIntFromConsole() {

        System.out.print("Please input a natural number: ");
        try {
            int n = scanner.nextInt();

            if (n < 1) {
                System.out.println("[Error] Input is not a natural number!");
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