public class FactorialWithMethods {

    public static void main(String[] args) {

        //Musterloesung zu Blatt 4, Aufgabe 3
        int n = 10;

        if (n > 0) {
            int m = n;
            int f = m;

            while (m > 2) {
                m--;
                f = f * m;
            }

            System.out.println(n + "! = " + f);
        }else if(n == 0){
            System.out.println("0! = 1");
        }else{
            System.out.println("[Fehler] Nicht wohldefiniert");
        }

        //Testen der Methode factorial (muss erst noch implementiert werden)
        int erg1 = factorial(5); //120
        System.out.println(erg1);
		
		//Test für Aufgabe a)
		System.out.println(factorial(0));

        //Man kann die Rückgabe auch direkt ausgeben
        System.out.println(factorial(10)); 

        //Testen der Methode binom (muss erst noch implementiert werden)
        System.out.println(binom(5, 2)); //=10
        System.out.println(binom(10, 5)); //=252
		System.out.println(binom(1, -1)); //-1
		System.out.println(binom(1, 2)); //-1
		System.out.println(binom(5, 3)); //10
    }

    //TODO: Methode factorial implementieren a)
	public static int factorial (int n) {
		if(n == 0 || n == 1){
			return 1;
		} else {
			return n*factorial(n-1);
		}
	}
    //TODO: Methode binom implementieren b) & c)
	public static int binom (int n, int k) {
		if ( k < 0 || n < k) {
			return -1;
		}
		return factorial(n)/( factorial(k) * factorial(n-k) );
	}
	
}
