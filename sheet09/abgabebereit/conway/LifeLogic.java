public class LifeLogic {
	
	private static int count = 0; //for debugging
	
    public static void compute(boolean[][] field) {
        //TODO: Merry Christmas !
        //Hinweis: Erstellen Sie sich Hilfsmethoden zur Berechnung der Anzahl der umgebenden lebenden Zellen.
		if(count > 0) {
			System.out.println();
			print(field);
			count--;
		}
		boolean[][] fieldCopy = new boolean[field.length][field[0].length];
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[x].length; y++) {
				fieldCopy[x][y] = field[x][y];
			}
		}
		
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[x].length; y++) {
				int neighbourCount = neighbourCount(field, x, y);
				if (field[x][y]) {
					if (neighbourCount < 2 || neighbourCount > 3) {
						fieldCopy[x][y] = false;
					}
				} else {
					if (neighbourCount == 3) {
						fieldCopy[x][y] = true;
					}
				}
			}
		}
		
		//field = fieldCopy; //funktioniert nicht, da nur die lokale Variable filed auf fiedCopy zeigt und nicht die urspruenglich uebergebene 
							// Stichwort call-by-value
		
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[x].length; y++) {
				field[x][y] = fieldCopy[x][y];
			}
		}
		
		if(count > 0) {
			System.out.println();
			print(field);
			count--;
		}
    }
	
	private static int neighbourCount(boolean[][] field, int xPos, int yPos) {
		int neighbourCount = 0;
		for (int x = xPos - 1; x <= xPos + 1; x++) {
			
			int xtemp = x; //to prevent OutOfBoundsExceptions and still look at the right fields
			if (x == -1) {
				x = field.length - 1;
			}
			
			for (int y = yPos - 1; y <= yPos + 1; y++) {
				int ytemp = y;
				if (y == -1) {
					y = field[x % field.length].length - 1;
				}
				
				if (!(y == yPos && x == xPos)) {	
					if (field[x % field.length][y % field[x % field.length].length]) {
						neighbourCount++;
					}
				}
				y = ytemp;
			}
			x = xtemp;
		}
		return neighbourCount;
	}
	
	private static void print(boolean[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] ? 1 : 0);
			}
			System.out.println();
		}
	}
}
