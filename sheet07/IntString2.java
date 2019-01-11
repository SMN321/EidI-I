


public class IntString2{

	public static void main(String[] args) {
		
		System.out.println(add("200000000000000000000000000", "30000000000000000000000000000")); //works
		System.out.println(mul("2002354325000000000000000000000000", "225325345325253543252522"));
		
	}
	
	static String IntToIntString(int in) {
		return "" + in;
	}
	
	static boolean isIntString(String in) {
		if (in == null || in.equals("")) {
			return false;
		}
		
		for (int i = 0; i < in.length(); i++) {
			if (!(in.charAt(i) >= 48 && in.charAt(i) <= 57)) {
				return false;
			}
		}
		
		return true;
	}
	
	static String add(String in1, String in2) {
		if (!isIntString(in1) || !isIntString(in2)) {
			return "NaN";
		}
		
		if (in1.length() < in2.length()) {
			return add(in2, in1);
		}
		
		while(in1.length() > in2.length()) {
			in2 = "0" + in2;
		}
		
		String out = "";
		int carry = 0;
		for (int i = in1.length()-1; i >= 0; i--) {
			out = (in1.charAt(i) - 48 + in2.charAt(i) - 48 + carry) % 10 + out;
			carry = (in1.charAt(i) - 48 + in2.charAt(i) -48 + carry)/10;
		}
		
		if (carry != 0) {
			out = carry + out;
		}
		
		return out;
	}
	
	static String mul(String in1, String in2) {
		if (!isIntString(in1) || !isIntString(in2)) {
			return "NaN";
		}
		
		if (in1.length() < in2.length()) {
			return mul(in2, in1);
		}
		
		String out = "0";
		for (int i = in1.length()-1; i >= 0; i--) {
			for (int j = 0; j < (in1.charAt(i) - 48); j++) {
				out = add(in2, out);
			}	
			in2 = in2 + "0"; //Potenz erhöhen
		}
		
		return out;
	}
	
}
