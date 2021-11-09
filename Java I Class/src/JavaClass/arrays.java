package JavaClass;

import java.util.Scanner;

public class arrays {
	
	public void display(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	public void oneToN(int n){
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	public void swap(int[] arr){
		int a;
		a = arr[0];
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = a;
		display(arr);
		System.out.println();
	}
	
	public void userarray(int n){
		int[] arr = new int[n];
		Scanner inputa = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			int a = inputa.nextInt();
			arr[i] = a;
		}
		display(arr);
		System.out.println();
	}
	
	public void reverse(int[] arr1){
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[arr1.length - 1 - i];
		}
		display(arr2);
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		arrays tester = new arrays();
//		tester.display(new int[] {1, 2, 3});
//		tester.oneToN(5);
//		tester.swap(new int[] {1, 2, 3, 4});
//		tester.userarray(5);
//		tester.reverse(new int[] {1, 2, 3, 4});
	}
}
