
public class Recursion02 {

	private static int count;

    public static void main(String[] args) {

        System.out.println("Test Palindrome");
        System.out.println("OTTO: " + isPalindrome("OTTO"));
        System.out.println("REGINEWETTEWENIGER: " + isPalindrome("REGINEWETTEWENIGER"));
        System.out.println("EIDI1: " + isPalindrome("EIDI1"));


        System.out.println("\nTest Heron");
        double[] ds = new double[]{-2, -0.1, 0.5, 1, 1.25, 1.5, 1.75, 2, 3, 5, 25};
        for (double d : ds) {
			System.out.println("x0 = " + d + ":");
            heronTr(2, d);
            System.out.println("Anzahl der Schritte: " + count);
			count = 0;
        }
		//die Ergebnisse sind alle gleich
	}

    private static boolean isPalindrome(String s) {
		if (s.length() == 1) {
			return true;
		}
		
        if (s.charAt(s.length() - 1) != s.charAt(0)) {
			return false;
		} else if (s.length() == 2) {
			return true;
		} else {
			return isPalindrome(s.substring(1, s.length() - 1));
		}
    }

    private static void heronTr(double a, double x0) {
        double x1 = 0.5*(x0 + a / x0);
		
		if (Math.abs(x1 - x0) < Math.pow(10, -8)) {
			System.out.println(x1);
			return;
		} else {
			count++;
			heronTr(a, x1);
		}
		
    }
	
}