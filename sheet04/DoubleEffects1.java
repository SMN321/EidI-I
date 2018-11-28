
public class DoubleEffects1{
	
	public static void main(String[] args){
		double d = 10.0;
		double dVorher = 10.0;
		for(double i=0.1; d>0; d=d-i){
			System.out.println(dVorher - d);
			dVorher = d;
		}
	}
	
	/*Die Ausgabe ist bedingt durch die Näherung der Darstellung der 0.1
	*beim Datentyp double, wodurch eben nicht exakt 0.1 sondern ein Näherungswert
	*abgezogen  wird. Das führt dazu, dass die Differenz nicht exakt 0.1 ist
	*sondern davon abweicht.
	*/
}