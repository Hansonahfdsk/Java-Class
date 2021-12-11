package JavaClass;

public class morewithStrings {
	public void firsttwolast(String str) {
		if(str.substring(0, 1).equals(str.substring(str.length() - 1, str.length())))
			System.out.println("true");
		else {
			System.out.println("false");
		}
	}
	public void contains(String str1, String str2) {
		for (int i = 0; i < str2.length(); i++) {
			int yes = 0;
			for (int j  = 0; j < str1.length(); j++) {
				if (str2.charAt(i) == str1.charAt(j)) {
					yes = 1;
					break;
				}
			}
			if (yes == 1) {
				System.out.println(str2.charAt(i) + "yes");
			}
			else {
				System.out.println(str2.charAt(i) + "no");
			}
		}
	}
	public void words(String str) {
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		System.out.println(count);
	}
	public void firsttwolast(String str) {
		if(str.substring(0, 1).equals(str.substring(str.length() - 1, str.length())))
			System.out.println("true");
		else {
			System.out.println("false");
		}
	}
	public static void main(String[] args) {	
		morewithStrings runner = new morewithStrings();
	}
}
