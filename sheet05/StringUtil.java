public class StringUtil {

    public static void main(String[] args) {

        System.out.println("[TEST] toUpperCase");
        System.out.println(toUpperCase("abc--ED")); //erwartet: ABC--ED

        System.out.println("[TEST] toLowerCase");
        System.out.println(toLowerCase("abc--ED")); //erwartet: abc--ed

        System.out.println("[TEST] substring");
        System.out.println(substring("ABC", 1, 2)); //erwartet: "B"
        System.out.println(substring("ABC", 2, 1)); //erwartet: ""
        System.out.println(substring("ABC", -1, 42)); //erwartet: "ABC"
        System.out.println(substring("Klausur", 0, 10)); //erwartet: "Klausur"
        System.out.println(substring("Klausur", 2, 0)); //erwartet: ""
        System.out.println(substring("Klausur", -1, 5)); //erwartet: "Klaus"
        System.out.println(substring("Klausur", 0, 5)); //erwartet: "Klaus"

        System.out.println("[TEST] contains");
        System.out.println(contains("abc", "loremipsum")); //erwartet: -1
        System.out.println(contains("abc", "abcabc")); //erwartet: 0
        System.out.println(contains("abc", "cccabc")); //erwartet: 3
        System.out.println(contains("erben", "sterben")); //erwartet: 2
    }

    /**
     * Musterloesung zu Aufgabe 4.4
     *
     * @param in
     * @return in, all lower case letters are now upper case
     */
    public static String toUpperCase(String in){
        String out = "";

        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 'a' + 'A');
            }

            out += c;
        }

        return out;
    }

    public static String toLowerCase(String str){
        
        //TODO: 3a)
        String out = "";

        for (int i = 0; i < str.length(); i++) {
            char c =str.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
            }

            out += c;
        }

        return out;
    }

    public static String substring(String str, int start, int end) {
        
        //TODO: 3b)
		String out = "";
		if (start < 0) {
			start = 0;
		}
		if (end > str.length() ) {
			end = str.length();
		}
		
		for (int index = start; index < end; index++) {
			out += str.charAt(index);
		}
		
		return out;
    }

    public static int contains(String needle, String haystack) {

        //TODO 3c)
		/*schaut nach, wo der erste Buchstabe von needle gleich einem Buchstaben aus 
		*haystack ist, extrahiert dann mit "substring()" den folgenden Sub-String mit
		*gleicher Länge wie needle und vergleicht beide.
		*/
		for (int index = 0; index < haystack.length()-needle.length()+1; index++) {
			
			if (haystack.charAt(index) == needle.charAt(0) ) {
				
				if (needle.equals( substring(haystack, index, index+needle.length() ) )){
					
					return index;
					
				}	
				
			}
			
		}
		
		return -1;  
    }

}
