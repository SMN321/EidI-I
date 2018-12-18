import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    String[] featureNames;

    double[][] values;

    String[] classifiedNames;
    int[] classifiedIds;

    int[] classification;
	
	//zum Testen:
	public static void main(String[] args) {
		Data data1 = new Data();
		Data data2 = new Data("iris.csv");
		
		System.out.println("Data1:");
		data1.view();
		System.out.println("\nData2:");
		data2.view();

	}

    public Data() {

        featureNames = new String[]{"sepal length", "sepal width", "petal length", "petal width"};

        values = new double[][]{{5.1, 3.5, 1.4, 0.2}, {4.9, 3.0, 1.4, 0.2}, {4.7, 3.2, 1.3, 0.2}, {4.6, 3.1, 1.5, 0.2}, {5.0, 3.6, 1.4, 0.2}, {5.4, 3.9, 1.7, 0.4}, {4.6, 3.4, 1.4, 0.3}, {5.0, 3.4, 1.5, 0.2}, {4.4, 2.9, 1.4, 0.2}, {4.9, 3.1, 1.5, 0.1}, {5.4, 3.7, 1.5, 0.2}, {4.8, 3.4, 1.6, 0.2}, {4.8, 3.0, 1.4, 0.1}, {4.3, 3.0, 1.1, 0.1}, {5.8, 4.0, 1.2, 0.2}, {5.7, 4.4, 1.5, 0.4}, {5.4, 3.9, 1.3, 0.4}, {5.1, 3.5, 1.4, 0.3}, {5.7, 3.8, 1.7, 0.3}, {5.1, 3.8, 1.5, 0.3}, {5.4, 3.4, 1.7, 0.2}, {5.1, 3.7, 1.5, 0.4}, {4.6, 3.6, 1.0, 0.2}, {5.1, 3.3, 1.7, 0.5}, {4.8, 3.4, 1.9, 0.2}, {5.0, 3.0, 1.6, 0.2}, {5.0, 3.4, 1.6, 0.4}, {5.2, 3.5, 1.5, 0.2}, {5.2, 3.4, 1.4, 0.2}, {4.7, 3.2, 1.6, 0.2}, {4.8, 3.1, 1.6, 0.2}, {5.4, 3.4, 1.5, 0.4}, {5.2, 4.1, 1.5, 0.1}, {5.5, 4.2, 1.4, 0.2}, {4.9, 3.1, 1.5, 0.1}, {5.0, 3.2, 1.2, 0.2}, {5.5, 3.5, 1.3, 0.2}, {4.9, 3.1, 1.5, 0.1}, {4.4, 3.0, 1.3, 0.2}, {5.1, 3.4, 1.5, 0.2}, {5.0, 3.5, 1.3, 0.3}, {4.5, 2.3, 1.3, 0.3}, {4.4, 3.2, 1.3, 0.2}, {5.0, 3.5, 1.6, 0.6}, {5.1, 3.8, 1.9, 0.4}, {4.8, 3.0, 1.4, 0.3}, {5.1, 3.8, 1.6, 0.2}, {4.6, 3.2, 1.4, 0.2}, {5.3, 3.7, 1.5, 0.2}, {5.0, 3.3, 1.4, 0.2}, {7.0, 3.2, 4.7, 1.4}, {6.4, 3.2, 4.5, 1.5}, {6.9, 3.1, 4.9, 1.5}, {5.5, 2.3, 4.0, 1.3}, {6.5, 2.8, 4.6, 1.5}, {5.7, 2.8, 4.5, 1.3}, {6.3, 3.3, 4.7, 1.6}, {4.9, 2.4, 3.3, 1.0}, {6.6, 2.9, 4.6, 1.3}, {5.2, 2.7, 3.9, 1.4}, {5.0, 2.0, 3.5, 1.0}, {5.9, 3.0, 4.2, 1.5}, {6.0, 2.2, 4.0, 1.0}, {6.1, 2.9, 4.7, 1.4}, {5.6, 2.9, 3.6, 1.3}, {6.7, 3.1, 4.4, 1.4}, {5.6, 3.0, 4.5, 1.5}, {5.8, 2.7, 4.1, 1.0}, {6.2, 2.2, 4.5, 1.5}, {5.6, 2.5, 3.9, 1.1}, {5.9, 3.2, 4.8, 1.8}, {6.1, 2.8, 4.0, 1.3}, {6.3, 2.5, 4.9, 1.5}, {6.1, 2.8, 4.7, 1.2}, {6.4, 2.9, 4.3, 1.3}, {6.6, 3.0, 4.4, 1.4}, {6.8, 2.8, 4.8, 1.4}, {6.7, 3.0, 5.0, 1.7}, {6.0, 2.9, 4.5, 1.5}, {5.7, 2.6, 3.5, 1.0}, {5.5, 2.4, 3.8, 1.1}, {5.5, 2.4, 3.7, 1.0}, {5.8, 2.7, 3.9, 1.2}, {6.0, 2.7, 5.1, 1.6}, {5.4, 3.0, 4.5, 1.5}, {6.0, 3.4, 4.5, 1.6}, {6.7, 3.1, 4.7, 1.5}, {6.3, 2.3, 4.4, 1.3}, {5.6, 3.0, 4.1, 1.3}, {5.5, 2.5, 4.0, 1.3}, {5.5, 2.6, 4.4, 1.2}, {6.1, 3.0, 4.6, 1.4}, {5.8, 2.6, 4.0, 1.2}, {5.0, 2.3, 3.3, 1.0}, {5.6, 2.7, 4.2, 1.3}, {5.7, 3.0, 4.2, 1.2}, {5.7, 2.9, 4.2, 1.3}, {6.2, 2.9, 4.3, 1.3}, {5.1, 2.5, 3.0, 1.1}, {5.7, 2.8, 4.1, 1.3}, {6.3, 3.3, 6.0, 2.5}, {5.8, 2.7, 5.1, 1.9}, {7.1, 3.0, 5.9, 2.1}, {6.3, 2.9, 5.6, 1.8}, {6.5, 3.0, 5.8, 2.2}, {7.6, 3.0, 6.6, 2.1}, {4.9, 2.5, 4.5, 1.7}, {7.3, 2.9, 6.3, 1.8}, {6.7, 2.5, 5.8, 1.8}, {7.2, 3.6, 6.1, 2.5}, {6.5, 3.2, 5.1, 2.0}, {6.4, 2.7, 5.3, 1.9}, {6.8, 3.0, 5.5, 2.1}, {5.7, 2.5, 5.0, 2.0}, {5.8, 2.8, 5.1, 2.4}, {6.4, 3.2, 5.3, 2.3}, {6.5, 3.0, 5.5, 1.8}, {7.7, 3.8, 6.7, 2.2}, {7.7, 2.6, 6.9, 2.3}, {6.0, 2.2, 5.0, 1.5}, {6.9, 3.2, 5.7, 2.3}, {5.6, 2.8, 4.9, 2.0}, {7.7, 2.8, 6.7, 2.0}, {6.3, 2.7, 4.9, 1.8}, {6.7, 3.3, 5.7, 2.1}, {7.2, 3.2, 6.0, 1.8}, {6.2, 2.8, 4.8, 1.8}, {6.1, 3.0, 4.9, 1.8}, {6.4, 2.8, 5.6, 2.1}, {7.2, 3.0, 5.8, 1.6}, {7.4, 2.8, 6.1, 1.9}, {7.9, 3.8, 6.4, 2.0}, {6.4, 2.8, 5.6, 2.2}, {6.3, 2.8, 5.1, 1.5}, {6.1, 2.6, 5.6, 1.4}, {7.7, 3.0, 6.1, 2.3}, {6.3, 3.4, 5.6, 2.4}, {6.4, 3.1, 5.5, 1.8}, {6.0, 3.0, 4.8, 1.8}, {6.9, 3.1, 5.4, 2.1}, {6.7, 3.1, 5.6, 2.4}, {6.9, 3.1, 5.1, 2.3}, {5.8, 2.7, 5.1, 1.9}, {6.8, 3.2, 5.9, 2.3}, {6.7, 3.3, 5.7, 2.5}, {6.7, 3.0, 5.2, 2.3}, {6.3, 2.5, 5.0, 1.9}, {6.5, 3.0, 5.2, 2.0}, {6.2, 3.4, 5.4, 2.3}, {5.9, 3.0, 5.1, 1.8}};

        classifiedNames = new String[]{"Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-setosa", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-versicolor", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica", "Iris-virginica"};

        classifiedIds = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};


        classification = new int[classifiedIds.length];
        for (int i = 0; i < classification.length; i++) {
            classification[i] = -1;
        }
    }

    public Data(String filename) {

        //TODO (BONUS)
		parseData(unpackData(readCSV(filename)));

        //TODO: classification initialisieren
		classification = new int[classifiedIds.length];
        for (int i = 0; i < classification.length; i++) {
            classification[i] = -1;
        }

    }    

    //object methods
    private void parseData(String[][] temp){
        //TODO (BONUS)
		//String[][] temp = unpackData(...);
		featureNames = new String[temp[0].length - 1];
		for (int i = 0; i < temp[0].length - 1; i++) {
			featureNames[i] = temp[0][i];
		}
		values = new double[temp.length - 1][];
		classifiedNames = new String[temp.length - 1];
		classifiedIds = new int[temp.length - 1];
		
		for (int i = 0; i < values.length; i++) {
			
			values[i] = new double[temp[i+1].length - 1];
			
			for (int j = 0; j < temp[i+1].length - 1; j++) {
				values[i][j] = Double.parseDouble(temp[i+1][j]);
			}
			
			classifiedNames[i] = temp[i + 1][temp[i+1].length - 1];
			
			int id;
			switch (temp[i + 1][temp[i+1].length - 1]) {
				case "Iris-setosa": 
					id = 0;
					break;
				case "Iris-versicolor": 
					id = 1;
					break;
				case "Iris-virginica": 
					id = 2;
					break;
				default:
					id = -1;
			}
			classifiedIds[i] = id;
		}
    }

    public void view() {
        for (String s : featureNames) { //prints the head
			System.out.print(s + "\t");
		}
		System.out.println("class"/* + "\tclassification\tclassifiedIds"*/);
		
		for (int i = 0; i < values.length; i++) {
			for (double val : values[i]) {
				System.out.print("\t" + val);
			}
			System.out.print("\t" + classifiedNames[i]);
			//System.out.print("\t\t" + classification[i]); //for debugging
			//System.out.print("\t" + classifiedIds[i]);
			System.out.println();
		}
    }

    public void analyse() {
        //TODO g)
		//Anzahl der verschiedenen Typen
		int specCount = 0;
		for (int i = 0; i < classifiedIds.length; i++) {
			if (specCount < classifiedIds[i]) {
				specCount = classifiedIds[i];
			}
		}
		specCount++;
		
		//Namen der Arten herausfinden
		String[] names = new String[specCount];
		for (int spec = 0; spec < specCount; spec++) {
			for (int i = 0; i < classifiedIds.length; i++) {
				if (classifiedIds[i] == spec) {
					names[spec] = classifiedNames[i];
					break;
				}
			}
		}
		
		//Anzahl der Cluster herausfinden
		int clusCount = 0;
		for (int i = 0; i < classification.length; i++) { //basically searches for the max-classification
			if (clusCount < classification[i]) {
				clusCount = classification[i];
			}
		}
		clusCount++;
		
		for (int clusId = 0; clusId < clusCount; clusId++) {
			
			int elementsCount = 0;
			int[] specCountArr = new int[specCount];
			for (int valInd = 0; valInd < classification.length; valInd++) {
				if (classification[valInd] == clusId) {
					elementsCount++; //weiters Element im Cluster
					specCountArr[classifiedIds[valInd]]++; //Weiters Element vom Typ (/von der Spezies) classifiedIds[valInd] im Cluster
				}
			}
			
			String col = "";
			switch(clusId) {
				case 0:
					col = "Red";
					break;
				case 1:
					col = "Green";
					break;
				case 2:
					col = "Blue";
					break;
				case 3:
					col = "color(0, 127, 127)";
					break;
				default:
					col = "White";
			}
			
			System.out.println("Cluster " + clusId + ":");
			System.out.println("\tColor: " + col);
			System.out.println("\t#individuals: " + elementsCount);
			for (int i = 0; i < specCountArr.length; i++) {
				double perc = ((double) specCountArr[i]) / elementsCount * 100;
				System.out.println("\t" + String.format("%.2f",perc) + " % are " + names[i]);
			}
			System.out.println();
		}
		
    }

    //static
    private static String[][] unpackData(String[] rawData) {
        //TODO (BONUS)
		String[][] unpacked = new String[rawData.length][];
		for (int i = 0; i < unpacked.length; i++) {
			rawData[i] = rawData[i].replaceAll("\"", ""); //entfernt "
			unpacked[i] = rawData[i].split(";"); //liefert String[], aufgespalten an allen ";"
		}
		
        return unpacked;
    }

    //Blackbox method
    private static String[] readCSV(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines.toArray(new String[0]);
    }
}
