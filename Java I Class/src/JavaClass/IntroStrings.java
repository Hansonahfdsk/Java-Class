package JavaClass;
public class IntroStrings {
	public void sechalf(String str) {
		System.out.println(str.substring(str.length() / 2, str.length()));
	}
	public void concatenate(String str1, String str2) {
		System.out.println(str1.substring(1, str1.length()) + str2.substring(1, str2.length()));
	}
	public void adverb(String str) {
		if (str.substring(str.length() - 1, str.length()) == "ly") {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	public void backwards(String str) {
		for (int i = str.length - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	}
	public void square(String str1) {
		String str2 = str1 + str1;
		for (int i = 0; i < str1.length(); i++) {
			System.out.println(str2.substring(i, i + str1.length()));
		}
	}
	public static void main(String[] args) {	
		IntroStrings runner = new IntroStrings();
	}
}
