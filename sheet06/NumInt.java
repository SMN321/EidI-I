//Wilhelmstaetter, Simon

class NumInt{

    public static void main(String[] args) {
    
        System.out.println("f(0)\t= " + f(0));
        System.out.println("f(0.5)\t= " + f(0.5));
        System.out.println("f(1)\t= " + f(1));

        System.out.println("\nGood approximation: \t" + 0.7468);

        System.out.println("");

        System.out.println("Monte-Carlo (1000): \t" + monteCarlo(1000));
        System.out.println("Monte-Carlo (10000): \t" + monteCarlo(10000));
        System.out.println("Monte-Carlo (100000): \t" + monteCarlo(100000));
        System.out.println("Monte-Carlo (1000000): \t" + monteCarlo(1000000));

        System.out.println("");

        System.out.println("Rectangular approximation (1000): \t" + rectApprox(1000));
        System.out.println("Rectangular approximation (10000): \t" + rectApprox(10000));
        System.out.println("Rectangular approximation (100000): \t" + rectApprox(100000));
        System.out.println("Rectangular approximation (1000000): \t" + rectApprox(1000000));

        System.out.println("");

        System.out.println("Trapezoidal approximation (1000): \t" + trapezApprox(1000));
        System.out.println("Trapezoidal approximation (10000): \t" + trapezApprox(10000));
        System.out.println("Trapezoidal approximation (100000): \t" + trapezApprox(100000));
        System.out.println("Trapezoidal approximation (1000000): \t" + trapezApprox(1000000));

    }

    public static double monteCarlo(int n){
        double treffer = 0; //double, da sonst treffer/n == 0, immer
		double x;
		double y;
		
		for (int i = 0; i < n; i++) {
			x = Math.random();
			y = Math.random();
			
			if (y <= f(x)) {
				treffer++;
			}
		}
		
        return treffer/n;
    }

    public static double rectApprox(int n){
        double nDouble = n;
		double delta = 1/nDouble;
		double integral = 0;
		for (int i = 0; i < n; i++) {
			integral += delta * f(i/nDouble);
		}
		
        return integral;
    }

    public static double trapezApprox(int n){
        double nDouble = n; //um Ganzzahlarithmetik zu verhindern
		double integral = 0;
		for (int i = 0; i < n; i++) {
			integral += 0.5*(f(i/nDouble) + f((i+1)/nDouble))/nDouble;
		}
        return integral;
    }

    public static double f(double x){
        return Math.exp(-(x*x));
    }
}