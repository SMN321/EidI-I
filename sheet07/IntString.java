

public class IntString{

	public static void main(String[] args) {
		System.out.println("\nAufgabe f");
		System.out.println(add("1", "2"));
		System.out.println(add("10", "20"));
		System.out.println(add("3", "100"));
		System.out.println(add("1", "a2"));
		
		System.out.println("\nAufgabe g");
		System.out.println(mul("13", "10"));
		System.out.println(mul("1", "2"));
		System.out.println(mul("1", "a2"));
		System.out.println(mul("10", "20"));
	}

	//Aufgabe b
	public static String intToIntString(int input) {
		String out = "";
		return out + input;
	}
	
	//Aufgabe c
	public static boolean isDigit(char input) {
		
		return input >= 48 && input <= 57;
	}
	
	//Aufgabe d
	public static int digitCharToInt(char input) {
		
		return isDigit(input) ? input-48 : 0;
	}
	
	//Aufgabe e
	public static boolean isIntString(String input) {
		boolean notNullAndNotEmpty = input != null && !input.equals("");
		
		if (!notNullAndNotEmpty) {
			return notNullAndNotEmpty;
		}
		
		for (int i = 0; i < input.length(); i++) {
			if ( !isDigit(input.charAt(i)) ) {
				return false;
			}
		}
		
		return true;
	}
	
	//Aufgabe f
	public static String add(String str1, String str2) {
		if (!isIntString(str1) || !isIntString(str2)) {
			return "NaN";
		}
		
		int out = 0;
		int uebertrag = 0;
		if (str1.length() >= str2.length()) {
			
			while (str1.length() > str2.length()) {
				str2 = "0" + str2;
			}
			
			int potenz = 1;
			for (int i = str2.length()-1; i >= 0; i--) {
				int zahl1 = str1.charAt(i) - 48;
				int zahl2 = str2.charAt(i) - 48;
				out += ((uebertrag + zahl1 + zahl2) % 10) * potenz;
				uebertrag = (uebertrag + zahl1 + zahl2) / 10;
				potenz *= 10;
			}
			
			out += uebertrag * potenz;
			
		} else {
			
			return add(str2, str1);
		}
		
		return intToIntString(out);
	}
	
	//Aufgabe g
	public static String mul(String str1, String str2) {
		if (!isIntString(str1) || !isIntString(str2)) {
			return "NaN";
		}
		
		String out = "0";
		int zahl2 = 0;
		
		int potenz = 1;
		for (int i = str2.length()-1; i >= 0; i--) {
			zahl2 += (str2.charAt(i)-48) * potenz;
			potenz *= 10;
		}
		
		for (int i = 0; i < zahl2; i++) {
			out = add(out, str1);
		}
		
		return out;
	}
	
	
	
}



