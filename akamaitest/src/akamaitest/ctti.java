package akamaitest;

public class ctti {

	public static String reverse (String a) {
		char[] c = a.toCharArray();
		char d;
		for (int i=0;i< (a.length())/2;i++){
			d = c[i];
			c[i] = c[((a.length()) - i - 1)];
			c[((a.length()) - i - 1)] = d;
		}
		return new String(c);
	}
	
	public static void main(String[] args) {
	String a = "indias";
	String b = reverse(a);
	System.out.print(b);
	}
}
