//Wilhelmstaetter, Simon

public class PuzzleUtil {
   
   public static void main(String[] args) {
        
		int[] arr1 = new int[]{25, 42, 69, 17};

        System.out.println("arr1: ");
        view(arr1);

        System.out.println("\narr1 shiftRight: ");
        shiftRight(arr1);
        view(arr1);

        System.out.println("\narr1 shiftLeft: ");
        shiftLeft(arr1);
        view(arr1);

        System.out.println("\narr1 shiftLeft: ");
        shiftLeft(arr1);
        view(arr1);

        System.out.println("\narr1 shiftRight: ");
        shiftRight(arr1);
        view(arr1);

        int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("\narr2t: ");
        view(arr2);

        System.out.println("\narr2 shiftColsUp(1,3): ");
        shiftCols(arr2, 1, 3, false);
        view(arr2);

        System.out.println("\narr2 shiftColsDown(1,3): ");
        shiftCols(arr2, 1, 3, true);
        view(arr2);		
		
        System.out.println("\narr2 shiftRowsRight(1,3): ");
        shiftRows(arr2, 1, 3, false);
        view(arr2);

        System.out.println("\narr2 shiftRowsLeft(1,3): ");
        shiftRows(arr2, 1, 3, true);
        view(arr2);

        System.out.println("\narr2 extractArray(2,4,2,4): ");
        view(extractArray(arr2, 2, 4, 2, 4));

        System.out.println("\narr2 rotateClockwise: ");
        rotateClockwise(arr2);
        view(arr2);

        System.out.println("\narr2 replaceInArray with zeros: ");
        replaceInArray(arr2, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 1, 1);
        view(arr2);

        System.out.println("\narr2 partialRotateClockwise(0,2,0,2): ");
        partialRotateClockwise(arr2, 0, 2, 0, 2);
        view(arr2);
		
		System.out.println("\nTest von rotateClockwise für Matrix mit gerader Seitenlaenge:");
		int[][] arr5 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
		view(arr5);
		rotateClockwise(arr5);
        view(arr5);
    }

    //a)
    public static void shiftRight(int[] arr) {
		
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int temp = arr[arr.length - 1];
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
    }

    //b)
    public static void shiftLeft(int[] arr) {
        
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int temp = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length - 1] = temp;
    }

    //c)
    public static void shiftRows(int[][] array, int rowStart, int rowEnd, boolean shiftLeft) {
        
		for (int i = rowStart; i < rowEnd; i++) {
			if (shiftLeft) {
				shiftLeft(array[i]);
			} else {
				shiftRight(array[i]);
			}
		}
    }

    //d)
    public static void shiftCols(int[][] array, int colStart, int colEnd, boolean shiftDown) {
        
		for (int i = colStart; i < colEnd; i++) {
			if (shiftDown) {
				shiftDown(array, i);
			} else {	
				shiftUp(array, i);
			}
		}
    }
	
	private static void shiftDown(int[][] matrix, int col) {
		
		if (col >= matrix[0].length) {
			return;
		}
		
		int temp = matrix[matrix.length - 1][col];
		for (int i = matrix.length - 1; i > 0; i--) {
			matrix[i][col] = matrix[i - 1][col];
		}
		matrix[0][col] = temp;
	}
	
	private static void shiftUp(int[][] matrix, int col) {
		
		if (col >= matrix[0].length) {
			return;
		}
		
		int temp = matrix[0][col];
		for (int i = 0; i < matrix.length - 1; i++) {
			matrix[i][col] = matrix[i + 1][col];
		}
		matrix[matrix.length - 1][col] = temp;
	}

    //e)
    public static int[][] extractArray(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart >= array.length || colStart >= array[0].length || rowStart >= rowEnd || colStart >= colEnd) {
			return null;
		}
		
		rowEnd = Math.min(array.length, rowEnd);
		colEnd = Math.min(array[0].length, colEnd);
		
		int[][] arrNew = new int[rowEnd - rowStart][colEnd - colStart];
		
		for (int i = 0; i < arrNew.length; i++) {
			for (int j = 0; j < arrNew[0].length; j++) {
				arrNew[i][j] = array[i + rowStart][j + colStart];
			}
		}
		
        return arrNew;
    }

    //f)
    public static void replaceInArray(int[][] array, int[][] delta, int rowStart, int colStart) {
        if (array == null || delta == null || rowStart >= array.length || colStart >= array[0].length) {
			return;
		}
		
		for (int i = 0; i < Math.min(delta.length, array.length - rowStart); i++) {
			for (int j = 0; j < Math.min(delta[0].length, array[0].length - colStart); j++) {
				array[i + rowStart][j + colStart] = delta[i][j];
			}
		}
    }

    //g)
	public static void rotateClockwise(int[][] array) {
		int n = array.length;
		int temp;
        for (int r = 1; r <= n/2; r++) {
			for (int a = -r; a < r - 1 + n%2; a++) { //- 1 + n%2 verhindert ArrayIndexOutOFBoundsException
				temp = array[n/2 + a][n/2 - r]; //oben links
				array[n/2 + a][n/2 - r] = array[n/2 + r - 1 + n%2][n/2 + a]; //unten links wird oben links
				array[n/2 + r - 1 + n%2][n/2 + a] = array[n/2 - a - 1 + n%2][n/2 + r - 1 + n%2]; //unten rechts wird unten links
				array[n/2 - a - 1 + n%2][n/2 + r - 1 + n%2] = array[n/2 - r][n/2 - a - 1 + n%2]; //oben rechts wird unten rechts
				array[n/2 - r][n/2 - a - 1 + n%2] = temp; //oben links wird oben rechts
			}
		}
    }
	
    //h)
    public static void partialRotateClockwise(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        int[][] replace = extractArray(array, rowStart, rowEnd, colStart, colEnd);
		rotateClockwise(replace);
		replaceInArray(array, replace, rowStart, colStart);
    }


    //vvvvv Blackbox vvvvv
    public static void view(int[] array) {

        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private static void view(int[][] array) {

        System.out.println("2d-Array:");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	//g) Zwischenstand
	// public static void rotateClockwise(int[][] array) { //works for uneven array.length
		// int n = array.length;
		// int temp;
        // for (int r = 1; r <= n/2; r++) {
			// for (int a = -r; a < r; a++) {
				// temp = array[n/2 + a][n/2 - r]; //oben links
				// array[n/2 + a][n/2 - r] = array[n/2 + r][n/2 + a]; //unten links wird oben links
				// array[n/2 + r][n/2 + a] = array[n/2 - a][n/2 + r]; //unten rechts wird unten links
				// array[n/2 - a][n/2 + r] = array[n/2 - r][n/2 - a]; //oben rechts wird unten rechts
				// array[n/2 - r][n/2 - a] = temp; //oben links wird oben rechts
			// }
		// }
    // }
}
