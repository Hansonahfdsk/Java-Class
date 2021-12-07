package JavaClass;

public class FinalArrayProblems {
	public int[] q1(int[] arr1) {
		double sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum += i * arr1[i];
		}
		return sum;
	}
	public int[] q2(char[] inp) {
		String str;
		for (int i = 0; i < inp.length; i++) {
			if (inp[i] >= 97 && inp[i] <= 122) {
				str += inp[i];
			}
		}
		return str;
	}
	public int[] q3(int[] arr, int a) {
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (a == arr[i] + arr[i + 1]) {
				sum = 1;
			}
		}
		if (sum == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public int[] common(char[] inp) {
		int[] let = new int[26];
		for (int i = 0; i < inp.length; i++) {
			let[inp[i] - 97]++;
		}
		int max = 0;
		for (int i = 0; i < 26; i++) {
			if (inp[i] > max) {
				max = i;
			}
		}
		return (char)(max + 97);
	}
}
