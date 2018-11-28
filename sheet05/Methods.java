public class Methods {
	
	/*Aufgabe 1:
	* Während eines Aufrufes einer Methode wird in der aufrufenden Methode darauf gewartet, bis die aufgerufene
	* Methode eine Rückgabe getätigt hat oder bei Rückgabetyp "void" die aufgerufene Methode fertig mit ihrer
	* eigenen Ausführung ist.
	*/
	
	/*Aufgabe 2:
	* Variablen werden übergeben, indem man ihren Namen in die Klammern hinter dem Methodennamen schreibt. Dabei ist
	* zu beachten, dass der übergebene Datentyp mit dem von der Mathode verlangten Datentyp übereinstimmt.
	* Nimmt eine Methode mehr als eine Variable so muss auch auf die Reihenfolge bei der Übergabe geachtet werden (muss gleich der 
	* Reihenfolge in der Methodendeklaration sein).
	*/
	
	/*Aufgabe 3:
	* Der Rückgabewert einer aufgerufenen Methode kann in der aufrufenden Methode wie bei einer normalen Initialisierung 
	* in einer Variablen gespeichhert werden. (Siehe "int n = methodWithParameterAndReturn(69);" Zeile 37.)
	*/

    public static void main(String[] args) {
	
        System.out.println("Hi! I am the main-method!");

        method();

        System.out.println("Aaaand welcome back to the main-method!");

        methodWithParameter(5);

        System.out.println("Back at main again!");

        methodWithParameter(42);

        System.out.println("m a i n!");

        int n = methodWithParameterAndReturn(69);

        System.out.println("That slick method with parameter and return just gave me the answer to everything!");

        System.out.println("So long, and thanks for all the fish!");

    }

    private static void method() {

        System.out.println("Hi! I am a method called \"method\"!");

    }

    private static void methodWithParameter(int n) {

        System.out.println("Hi there! I am a method with a parameter and you handed me " + n);

    }

    private static void methodWithParameter(double n) {

        System.out.println("Well hello! I am a method with a parameter and you handed me " + n);

    }

    private static int methodWithParameterAndReturn(int n) {

        System.out.println("You handed me "+n+" but I will return 42!");

        return 42;

    }



}
