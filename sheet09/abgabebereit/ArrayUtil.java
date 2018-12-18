//Wilhelmstaetter, Simon

import java.util.Arrays;

public class ArrayUtil {

    public static void main(String[] args) {

        double[] arr1 = {1, 2, 3, 4, 5};
        double[] arr2 = {5, 4, 3, 2, 1};
        double[] arr3 = randomArray(1000);

        System.out.printf("arr1: %s%n", array2String(arr1));
        System.out.printf("arr2: %s%n", array2String(arr2));
        System.out.printf("arr3: %s%n", array2String(arr3));
        System.out.println();

        //a) sum
        System.out.printf("Sum: %.2f\t (should: %2.2f)%n", sum(arr1), Arrays.stream(arr1).sum());
        System.out.printf("Sum: %.2f\t (should: %2.2f)%n", sum(arr2), Arrays.stream(arr2).sum());
        System.out.printf("Sum: %.2f\t (should: %2.2f)%n", sum(arr3), Arrays.stream(arr3).sum());
        System.out.println();

        //b) avg
        System.out.printf("Average: %.2f\t (should: %2.2f)%n", avg(arr1), Arrays.stream(arr1).average().getAsDouble());
        System.out.printf("Average: %.2f\t (should: %2.2f)%n", avg(arr2), Arrays.stream(arr2).average().getAsDouble());
        System.out.printf("Average: %.2f\t (should: %2.2f)%n", avg(arr3), Arrays.stream(arr3).average().getAsDouble());
        System.out.println();

        //c) max
        System.out.printf("Max: %.2f\t (should: %2.2f)%n", max(arr1), Arrays.stream(arr1).max().getAsDouble());
        System.out.printf("Max: %.2f\t (should: %2.2f)%n", max(arr2), Arrays.stream(arr2).max().getAsDouble());
        System.out.printf("Max: %.2f\t (should: %2.2f)%n", max(arr3), Arrays.stream(arr3).max().getAsDouble());
        System.out.println();

        //d) min
        System.out.printf("Min: %.2f\t (should: %2.2f)%n", min(arr1), Arrays.stream(arr1).min().getAsDouble());
        System.out.printf("Min: %.2f\t (should: %2.2f)%n", min(arr2), Arrays.stream(arr2).min().getAsDouble());
        System.out.printf("Min: %.2f\t (should: %2.2f)%n", min(arr3), Arrays.stream(arr3).min().getAsDouble());
        System.out.println();

        //e) sort
        sort(arr1);
        sort(arr2);
        sort(arr3);
        System.out.printf("Sorted: %s%n", array2String(arr1));
        System.out.printf("Sorted: %s%n", array2String(arr2));
        System.out.printf("Sorted: %s%n", array2String(arr3));
        System.out.println();

        //g) isSorted
        double[] arrUnsorted = randomArray(1000);
        System.out.printf("isSorted arr1: %s%n", isSortedDesc(arr1));
        System.out.printf("isSorted arr2: %s%n", isSortedDesc(arr2));
        System.out.printf("isSorted arr3: %s%n", isSortedDesc(arr3));
        System.out.printf("isSorted arrUnsorted: %s%n", isSortedDesc(arrUnsorted));
    }

    //a)
    private static double sum(double[] arr) {
		
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
        double sum = 0; //wird implizit zum double gecastet
		for (double i : arr) {
			sum += i;
		}
		
        return sum;
    }

    //b)
    private static double avg(double[] arr) {

        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }
        
        return sum(arr)/arr.length; 
    }

    //c)
    private static double max(double[] arr) {

        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }

        double pivot = arr[0];
		for (double i : arr) {
			if (pivot < i) {
				pivot = i;
			}
		}
        return pivot;
    }

    //d)
    private static double min(double[] arr) {

        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }

        double pivot = arr[0];
		for (double i : arr) {
			if (pivot > i) {
				pivot = i;
			}
		}
        return pivot;
    }

    //e)
    private static void sort(double[] arr) {
		if (arr == null || arr.length == 0) {
            return;
        }
		
		double temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
    }
	
	/*
	*Da ein Array ein Objekt ist, wird beim Methodenauftruf eine Kopie der Referenz uebergeben. Die Veriable 'arr' in der Methode 
	*sort hat also die gleiche Referenz wie die Variable im Mathodenaufruf (z.B. 'arr1'). Über diese Referenz werden nun am Array, auf
	*den sowohl 'arr' als auch 'arr1' zeigen, veraenderungen vorgenommen. Ist die Methode fertig, "stirbt" die Referenz aus der
	*Methode ('arr'), die Referenz von 'arr1' zeigt jedoch immer noch auf den (veraenderten) Array. Somit wurde der Array manipuliert, 
	*ohne etwas an der Variablen 'arr1' zu veraendern (sondern ueber die kopierte Referenz). Deshalb muss auch nichts zuruechgegeben 
	*werden, da 'arr1' schon auf den veraenderten Array zeigt (bzw. eine Referenz auf ihn besitzt).
	*/

    //g)
    private static boolean isSortedDesc(double[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i+1]) {
				return false;
			}
		}
		
        return true; 
    }

    //h)
    private static double median(double[] arr) {

        if (arr == null || arr.length == 0 || !isSortedDesc(arr)) {
            return Double.NaN;
        }

        return arr[arr.length/2];
    }

    //vvvvv Blackbox vvvvv
    private static double[] randomArray(int n) {

        double[] arr = new double[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() - 0.5;
        }

        return arr;
    }

    private static String array2String(double[] arr) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(String.format("%.4f", arr[i]));
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return new String(sb);
    }
}