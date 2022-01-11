package JavaClass;

public class farewelltostrings {
	public void piglatin(String s) {
		String pig = s.substring(1, s.length()) + s.charAt(0) + "ay";
		System.out.println(pig);
	}
	public void replace(String s, char a) {
		String sub = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != a) {
				sub += s.charAt(i);
			}
			else {
				sub += '$';
			}
		}
		System.out.println(sub);
	}
	public void longest(String[] s) {
		int maxI = 0;
		for (int i = 1; i < s.length; i++) {
			if (s[maxI].length() < s[i].length()) {
				maxI = i;
			}
		}
		System.out.println(s[maxI]);
	}
	public static void main(String[] args) {
		farewelltostrings tester = new farewelltostrings();
		tester.piglatin("pig");
		tester.replace("hello", 'l');
		tester.longest(new String[] {"hi", "hello", "bye"});
	}
}
