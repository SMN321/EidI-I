import java.util.Arrays;
import java.util.Random;

public class KMeans {

    //Generator für Zufallszahlen
    private static Random random = new Random();

    //Referenz auf die GUI
    private static KMeansViewer viewer;

    public static void main(String[] args) {

        Data data = new Data();
        //Data data = new Data("iris.csv"); //Wenn Sie die Bonusaufgabe geloest haben sollten.

        //b)
        //data.view();

        //Intialisierung der GUI, Features 0 und 2 werden angezeigt
        viewer = new KMeansViewer(data, 0, 2);

        //Die GUI anzeigen
        viewer.show();

        //Fuehre kmeans aus
        //kmeans(data, new int[]{0, 2}, 3); //kmeans fuer Features 0,2
        //kmeans(data, new int[]{0, 1, 2, 3}, 3); //kmeans fuer alle Features
		//kmeans(data, new int[]{0, 1, 2, 3}, 2); //kmeans fuer alle Features, zu wenige Zentren
		kmeans(data, new int[]{0, 1, 2, 3}, 4); //kmeans fuer alle Features mit zu vielen Zentren
		
		data.view(); //funktioniert besser, nach dem kmeans() ausgefuehrt wurde
		
        //g)
		//data.view(); //for debugging
        data.analyse();
    }

    private static void kmeans(Data data, int[] activeFeatures, int nrCenters) {

        double[][] centers = new double[nrCenters][data.values[0].length];

        //Create starting centers at random
		//jedes center erhält fuer jedes activeFeatures einen Wert von einer zuraelling gewaehlten Pflanze (data.values[randomId][activeFeatures[featureId]])
        //Kodierung: Alle Zentren sind Arrays mit data.values[0].length (hier: 4) Double(s). Alle Zentren werden in eienem Array verwaltet (double[][] centers).
		for (int centerId = 0; centerId < centers.length; centerId++) {
            for (int featureId = 0; featureId < activeFeatures.length; featureId++) {

                int randomId = random.nextInt(data.values.length);
                centers[centerId][activeFeatures[featureId]] = data.values[randomId][activeFeatures[featureId]];
            }
        }

        viewer.touch(centers);

        boolean swapOccured = true;

        while (swapOccured) {

            int[] classification = new int[data.classification.length];

            for (int i = 0; i < classification.length; i++) {

                classification[i] = classify(data.values[i], centers, activeFeatures);

            }

            if (Arrays.equals(data.classification, classification)) {
                //TODO: Schleife beenden
				swapOccured = false;
				//break;
				//return;
            } else {
                data.classification = classification;
                recalcCenters(data, classification, centers, activeFeatures);
            }

            //Aktualisiere die GUI
            viewer.touch(centers);

            //Warte fuer 1000ms bis zur naechsten Berechnung
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static int classify(double[] value, double[][] centers, int[] activeFeatures) {
        double[] dist = new double[centers.length]; //safes the distance to all centers
		
		for (int distId = 0; distId < dist.length; distId++) {
			double distCount = 0;
			for (int featureId = 0; featureId < activeFeatures.length; featureId++) {
				distCount += Math.pow(centers[distId][activeFeatures[featureId]] - value[activeFeatures[featureId]], 2); //returns the squared distance between the two features
			}
			dist[distId] = distCount; //man haette sich distCount auch sparen koennen...
		}
		
		int distMinId = 0; //safes the Id of the closest center (the center with the smallest distence to the given point)
		for (int i = 1; i < dist.length; i++) {
			if (dist[distMinId] > dist[i]) {
				distMinId = i;
			}
		}
		
		return distMinId;
    }

    private static void recalcCenters(Data data, int[] classifications, double[][] centers, int[] activeFeatures) {
        //TODO: f)
		
		for (int clusId = 0; clusId < centers.length; clusId++) { //arbeitet die einzelnen Cluster nacheinander ab
			
			double[] sumFeat = new double[data.values[0].length]; //wird neues center für Cluster mit Nummer clusId
			int clusCount = 0;
			
			for (int classId = 0; classId < classifications.length; classId++) { //durchlaeuft alle Klassifikationen und schaut, welchem Cluster der Datenpunkt angehoert
				
				if (clusId == classifications[classId]) { //bei Zugehoerigkeit zum aktuell untersuchten Cluster
					
					clusCount++; //zaehlt die Elemente im Cluster
					
					for (int featId = 0; featId < activeFeatures.length; featId++) {
						sumFeat[activeFeatures[featId]] += data.values[classId][activeFeatures[featId]];
					}
					
				}
				
			}
			
			for (int featId = 0; featId < activeFeatures.length; featId++) {
				sumFeat[activeFeatures[featId]] /= clusCount;
			}
			
			centers[clusId] = sumFeat;
			
		}
		
    }
}







