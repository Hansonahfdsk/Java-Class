package JavaClass;

public class importantarrayalg {
	
	public double average(int[] arr) {
		double avg = 0;
		for (int i : arr) {
			avg += i;
		}
		return avg/arr.length;
	}
	
	public char[] combine(char[] arr1, char[] arr2) {
		char[] arr3 = new char[arr1.length + arr2.length];
		for (int i = 0; i < arr1.length; i++) {
			arr3[i] = arr1[i];
		}
		for (int i = 0; i < arr2.length; i++) {
			arr3[i + arr1.length] = arr2[i];
		}
		return arr3;
	}
	
	public static void main(String[] args) {
		importantarrayalg tester = new importantarrayalg();
		tester.average(new int[] {1, 2, 3});
		tester.combine(new char[] {'h', 'e'}, new char[] {'l', 'l', 'o'});
	}
}
