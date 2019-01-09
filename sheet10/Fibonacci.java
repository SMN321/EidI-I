public class Fibonacci {

    private static long time = -1;
	private static int countTail;
	private static int countHead;
	
    public static void main(String[] args) {
        int[] ns = new int[]{10, 20, 30, 40};
		for (int n : ns) {
			System.out.println("\n\nn = " + n);
			tic();
			System.out.println("\niterativ: " + fibIt(n));
			System.out.println("Zeit: " + ((double) toc() / 1000) + " Sekunden");
			tic();
			System.out.println("\nhead: " + fibHr(n));
			System.out.println("Zeit: " + ((double) toc() / 1000) + " Sekunden");
			System.out.println("Aufrufe: " + countHead);
			
			tic();
			System.out.println("\ntail: " + fibTr(n));
			System.out.println("Zeit: " + ((double) toc() / 1000) + " Sekunden");
			System.out.println("Aufrufe: " + countTail);
		}
		//Die iterative Berechnung und die Berechnung ueber die Tail-Rekursion brachen beide gleich wenig Zeit (Laufzeit O(n)),
		//die Berechnung ueber die Head-Rekursion benötigt deutlich mehr Zeit (O(n^2)).
    }

    private static int fibIt(int n) {

        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
        }

        return b;
    }

	private static int fibHr(int n) {
		return fibHr(n, true);
	}
	
    private static int fibHr(int n, boolean firstCall) {
		
		if (firstCall) {
			countHead = 0;
		}
		countHead++;
		
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibHr(n - 1, false) + fibHr(n - 2, false);
        }
    }

    private static int fibTr(int n) {

        return fibTr(0, 1, n, true);

    }

    private static int fibTr(int a, int b, int n, boolean firstCall) {
		
		if (firstCall) {
			countTail = 0;
		}
		countTail++;
		
        switch (n) {
            case 0:
                return a;
            case 1:
                return b;
            default:
                return fibTr(b, a + b, n - 1, false);
        }
    }

    //vvvvv Blackbox vvvvv
    public static void tic() {

        if (time != -1) {
            throw new IllegalStateException("Timer already running!");
        }

        time = System.currentTimeMillis();
    }

    public static long toc() {

        if (time == -1) {
            throw new IllegalStateException("Timer not running!");
        }

        long delta = System.currentTimeMillis() - time;
        time = -1;

        return delta;
    }
}