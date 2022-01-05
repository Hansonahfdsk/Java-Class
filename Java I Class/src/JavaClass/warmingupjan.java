package JavaClass;

public class warmingupjan {
	public boolean alphabetical(String str) {
		for(int j = 1; j < str.length(); j++) {
			if (str.charAt(j) < str.charAt(j - 1)) {
				return false;
			}
		}
		return true;
	}
	public String students(String[] name, int[] score) {
		int maX = 0;
		for (int i = 1; i < name.length; i++) {
			if (score[i] > score[maX])
				maX = i;
		}
		return name[maX];
	}
	public void perfectsquares(int n) {
		int i = 0;
		while (n != 0) {
			if (Math.sqrt(i) == (int)Math.sqrt(i) && i % 2 == 1) {
				n--;
				System.out.println(i);
			}
			i++;
		}
	}
	public String every3(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i += 3) {
			if (i % 2 == 0) {
				str += s.substring(i, i + 3);
			}
		}
		if (s.length() % 6 < 3) {
			str += s.substring(str.length() - str.length() % 6);
		}
		return str;
	}
	
	public static void main(String[] args) {
		warmingupjan tester = new warmingupjan();
		
	}
}
