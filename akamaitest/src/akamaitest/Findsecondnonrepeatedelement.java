package akamaitest;

import java.util.ArrayList;
import java.util.HashMap;

public class Findsecondnonrepeatedelement {

public static void main(String[] args) {
	String e = "Indasmycountry";
	String a = e.toLowerCase();
	char[] b = a.toCharArray();
	HashMap<Character,Integer> myhash = new HashMap<Character,Integer>();
	ArrayList<Character> j = new ArrayList<Character>();
	for (char c : b) {
	if(myhash.containsKey(c)) {
		myhash.put(c, (myhash.get(c)+1));
	} else {
		myhash.put(c, 1);
	}
}
	for (char c : b) {
		if (myhash.get(c) == 1) {
			j.add(c);
		} 
	}
	
	System.out.println("The answer is" + j.get(0));
	}
	
}