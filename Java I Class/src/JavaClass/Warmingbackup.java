package JavaClass;

public class Warmingbackup {
	public void eachword(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	public void 1ton(int n) {
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
	}
	public void avg(int[] arr) {
		int avg = 0;
		for (int i = 0; i < arr.length; i++) {
			avg += arr[i];
		}
		avg /= arr.length;
	}
	public void doublevalue(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= 2;
		}
	}
	public void trim(int[] arr) {
		int greatest = arr[0], least = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= greatest) {
				greatest = arr[i];
			}
			if (arr[i] <= least) {
				least = arr[i];
			}
		}
		int arr2[] = new int[arr.length - 2], c = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr2[c] != greatest || arr2[c] != least) {
				arr2[c] = arr[i];
				c++;
			}
		}
	}
	public void fibseq(int n) {
		int a = 0, b = 1, c = 0;
		System.out.println("1, 1");
		for (int i = 0; i < n - 2; i++) {
			c = 1 + 2;
			System.out.println(c);
			a = b;
			b = c;
		}
	}
	public void divis(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] % arr[i - 1] == 0) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}