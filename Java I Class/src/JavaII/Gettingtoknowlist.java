package JavaII;

import java.util.ArrayList;

import JavaClass.arrays;

public class Gettingtoknowlist {
	public ArrayList<Integer> removeSecond(ArrayList<Integer> list) {
		for (int i = 1; i < list.size(); i += 2) {
			list.remove(i);
		}
		return list;
	}
	public ArrayList<String> reverseOrder(ArrayList<String> list){
		ArrayList<String> rev = new ArrayList<String> ();
		for (int i = list.size() - 1; i >= 0; i--) {
			rev.add(list.get(i));
		}
		return rev;
	}
	public ArrayList<Double> doubleValue(ArrayList<Double> list){
		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i) * 2);
		}
		return list;
	}
	public ArrayList<Character> pattern(int n){
		ArrayList<Character> list = new ArrayList<Character> ();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				list.add((char)(i + 97));
			}
			else {
				list.set(n - i, (char)(i + 97));
			}
		}
		return list;
	}
}
