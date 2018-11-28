
public class DoubleEffects2{
	public static void main(String[] args){
		
		double d = 100.0;
	
		while( (d-1)!=d  ){
			d = d*d;
		}
		
		System.out.println(d);
		System.out.println(d-1);
		
	}
	
	//Begruendung der Existenz:
	/* Wird einem double ein so großer Wert zugewiesen, dass es den Werteberich der 
	* Mantisse übersteigt, werden die letzten Bits abgeschnitten und nur die ersten
	* Bits verwendet. Somit kommt es im niedrigen Zahlenbereich zu Genauigkeitsverlust
	* und somit dazu, dass d-1==d, weil d>>1.
	*/
}