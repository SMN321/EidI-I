//Wilhelmstaetter, Simon

class Crypto{

    public static void main(String[] args) {
        System.out.println("[TEST] charShift");

        System.out.println(charShift('a', 3)); //'d'
        System.out.println(charShift('z', 3)); //'c'
        System.out.println(charShift('Z', 2)); //'B'

        System.out.println("\n[TEST] caesar");

        System.out.println(caesar("AB CDE", 3)); //DE FGH
        System.out.println(caesar("AB XyZ", 3)); //DE ABC
        System.out.println(caesar("Hallo", 5)); //Mfggt

        System.out.println("\n[TEST] brutus");
        brutus(caesar("Hallo", 5));

        System.out.println("\n[TEST] vignere");
        System.out.println(vigenere("Wikipedia", "Vigenere")); //RQQM CIUM V
        System.out.println(vigenere("EidI ist toll!", "Selber")); //WMOJ MJLX ZMP
    }

    private static char charShift(char in, int shift) {
        
		if (in >= 'a' && in <= 'z' ) {
			in = (char) ((in - 'a' + shift) % 26 + 'a');
		} else if (in >= 'A' && in <= 'Z' ) {
			in = (char) ((in - 'A' + shift) % 26 + 'A');
		}
		
        return in;
    }

    private static String caesar(String in, int shift) {
		
		String out = "";
		for (int i = 0; i < in.length(); i++) {
			out += charShift(in.charAt(i), shift);	
		}
		
        return out;
    }

    private static void brutus(String in) {
        
		for (int shiftIndex = 0; shiftIndex < 26; shiftIndex++) {
			System.out.println("Es wurde der Shift " + shiftIndex + " entschlüsselt:");
			System.out.println(caesar(in, shiftIndex) + "\n");
		}
		
    }

    private static String vigenere(String in, String password) {
        
		in = in.toUpperCase();
		password = password.toUpperCase();
		String inOnlyCharacters = "";
		
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) >= 'A' && in.charAt(i) <= 'Z') {
				inOnlyCharacters += in.charAt(i);
			}
		}
		
		String out = "";
		for (int i = 0; i < inOnlyCharacters.length(); i++) {
			int shift = password.charAt(i % password.length()) - 'A';
			out += charShift(inOnlyCharacters.charAt(i), shift);
			
			if ((i+1) % 4 == 0) {
				out += ' ';
			}
		}
		
        return out;
    }
}


