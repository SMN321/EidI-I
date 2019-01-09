
import java.math.BigInteger;

public class Recursion01 {

    public static void main(String[] args) {
        System.out.println("Test factorial: 0! = 1");
        System.out.println("iterativ: " + facIt(0));
        System.out.println("head: " + facHr(0));
        System.out.println("tail: " + facTr(0));

        System.out.println("\nTest factorial: 5! = 120");
        System.out.println("iterativ: " + facIt(5));
        System.out.println("head: " + facHr(5));
        System.out.println("tail: " + facTr(5));

        System.out.println("\nTest factorial: 10! = 3628800");
        System.out.println("iterativ: " + facIt(10));
        System.out.println("head: " + facHr(10));
        System.out.println("tail: " + facTr(10));

        System.out.println("\nTest binom(4,2) = 6");
        System.out.println("iterativ: " + binomIt(4, 2));
        System.out.println("head: " + binomHr(4, 2));
        System.out.println("tail: " + binomTr(4, 2));

        System.out.println("\nTest binom(11,5) = 462");
        System.out.println("iterativ: " + binomIt(11, 5));
        System.out.println("head: " + binomHr(11, 5));
        System.out.println("tail: " + binomTr(11, 5));
		
		System.out.println("\nTest binom(11,0) = 1");
        System.out.println("iterativ: " + binomIt(11, 0));
        System.out.println("head: " + binomHr(11, 0));
        System.out.println("tail: " + binomTr(11, 0));

        System.out.println("\nTest binom(49,6) = 13983816");
		//System.out.println("iterativ: " + binomIt(49, 6)); //wirft ArithmeticException: / by zero, da es zum Overflow bei facIt(43) kommt 
        System.out.println("head: " + binomHr(49, 6));
        System.out.println("tail: " + binomTr(49, 6));

        System.out.println("\nTest binom(49,43) = 13983816");
		//System.out.println("iterativ: " + binomIt(49, 43)); //wirft ArithmeticException: / by zero, da es zum Overflow bei facIt(43) kommt
        System.out.println("head: " + binomHr(49, 43));
        System.out.println("tail: " + binomTr(49, 43));
		
		System.out.println("\nTest factorial: 42! = 1405006117752879898543142606244511569936384000000000");
		System.out.println("tail: " + bigFacTr(new BigInteger("42")));
		//die Nullen am Ende kommen von den Multiplikationen?
		//Frage zu schwammig formuliert
    }

    private static int facIt(int n) {
        int fac = 1;

        for (int i = 1; i <= n; i++) {
            fac *= i;
        }

        return fac;
    }

    private static int facHr(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n*facHr(n-1);
		}
    }


    private static int facTr(int n) {
        return facTr(n, 1);
    }
	
	private static int facTr(int n, int m) {
		if (n == 0) {
			return m;
		} else {
			return facTr(n-1, n*m);
		}
	}
	
	private static BigInteger bigFacTr(BigInteger n) {
		return bigFacTr(n, new BigInteger("1"));
	}
	
	private static BigInteger bigFacTr(BigInteger n, BigInteger m) {
		if (n.equals(new BigInteger("0"))) {
			return m;
		} else {
			return bigFacTr(n.add(new BigInteger("-1")), m.multiply(n));
		}
	}
	
	/*
	* c)
	* Bei Head-Rekursion wird mit dem Ergebnis des rekursiven Aufrufes weitergerechnet, bei Tailrekursion kommt der Aufruf am Ende
	* und wird direkt zurueckgegeben.
	* Merksatz: Head: oben/am Anfang, danach kommt noch was; Tail: unten/am Ende, danach kommt nichts mehr
	*/
	
    private static int binomIt(int n, int k) {
        if (n >= k && k >= 0) {
            return facIt(n) / (facIt(k) * facIt(n - k));
        }

        return -1;
    }

    private static int binomHr(int n, int k) {
		if (k < 0 || n < k) {
			return -1;
		}
		
        if (k == 0 || k == n) {
			return 1;
		} else {
			return binomHr(n-1, k-1) + binomHr(n-1, k);
		}
    }

    private static int binomTr(int n, int k) {
        if (k < 0 || n < k) {
			return -1;
		}
		
		if (k == 0 || k == n) {
			return 1;
		} else {
			return binomTr(n, k, 1);
		}
		
    }
	
	private static int binomTr(int n, int k, double acc) {
		if (k == 0) {
			return (int) Math.round(acc);
		} else {
			return binomTr(n-1, k-1, acc * n / k);
		}
		
	}
	
}