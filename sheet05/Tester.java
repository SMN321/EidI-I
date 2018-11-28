public class Tester{
	
	public static void main (String[] args) {

		//char x = "x"; //error, da mit "" Strings definiert werden
		
		//char cipher = 57; //funktioniert, da keine Information verloren geht (in diesem Bereich, bei z.B. -1 schon)

		//int some = (int)(2 * Math.E) / 360.0; //funktioniert nicht, da rechts double steht

		//byte b = (byte) -228 + 99; //b hat den Wert 127 (nicht -129), da es zum Underflow kommt
		
		//char c = 'a';
 		//if(c < 'c'){		
		//	System.out.println(--c); //funktioniert, bleibt auch bei char und wechselt nicht zu int, gibt ' aus
		//}
		
		//float flaot = 3.08e+11; //funktioniert nicht, da rechts Seite double ist
		
		//long a = 5.0/0; //compiliert nicht, da rechte Seite float, throws exception /0
		
		//double d = (int)(0.5 + 0.5d + /* 5e-1 */ + (0.5d + 0.500f) / +0) - 0; //funktioniert, bis zum cast ist alles double, wobei dort /0 = infinity ergibt. durch casting ergibt sich dann höchster int-Wert (~2 Mrd.)
		
		
		//for (byte b = 0; b < 130; b++) { //compiliert aber liefert Stack-overflow, da b einen Overflow erfährt
		//System.out.println("Lorem ipsum!");
		//}
		
		//for (int i = 0, j = 2, c = 'a' ; i+j-c < 'o' ; i *= c, j = j---c+i); //durch ; am Ende ergobt sich leere Anweisung, würde aber ewig laufen, da j bis zum Overflow läuft
		
		//for (String s = "a" ; s < "c" ; s++); //compiliert nicht, da Strings nicht mit Relationsoperatoren verglichen werden können, ebenso nicht mit Postinkrement erhöht
		
		//int i;
		//do{
		//	int i=0;;;i++;
		//}while(i == 0 == !(!false || !true))  //compiliert nicht da ; nach while fehlt und i schon intialisiert ist

		System.out.println();
		
	}
	
}