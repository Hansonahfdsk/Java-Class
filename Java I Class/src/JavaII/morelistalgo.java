package JavaII;

import java.util.ArrayList;
import java.util.Random;

public class morelistalgo {
	public static ArrayList<Integer> rand(int n, int x) {
		ArrayList<Integer> list = new ArrayList<Integer> ();
		for (int i = 0; i < n; i++) {
			int num = (int)(Math.random() * 2 * x) - x;
			list.add(num);
		}
		return list;
	}
	public static void posneg(ArrayList<Integer> list) {
		ArrayList<Integer> positive = new ArrayList<Integer> ();
		ArrayList<Integer> negative = new ArrayList<Integer> ();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < 0) {
				negative.add(list.get(i));
			}
			else {
				positive.add(list.get(i));
			}
		}
		System.out.println(positive);
		System.out.println(negative);
	}
	public static void rev(ArrayList<Integer> list) {
		System.out.println(list);
		for (int i = 0; i < list.size() / 2; i++) {
			int temp = list.get(i);
			list.set(i, list.get(list.size() - i - 1));
			list.set(list.size() - i - 1, temp);
		}
		System.out.println(list);
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer> ();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(-10);
		list.add(-20);
		System.out.println(rand(5, 6));
		posneg(list);
		rev(list);
	}
}
