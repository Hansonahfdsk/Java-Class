package JavaII;

import java.util.ArrayList;

public class listsandreferences {
	public String concatenate(ArrayList<Character> list) {
		String s = "";
		for(int i = 0; i < list.size(); i++) {
			s += list.get(i);
		}
		return s;
	}
	public ArrayList<Double> averages(ArrayList<Double> list){
		for(int i = 0; i < list.size(); i++) {
			double avg = 0;
			for(int j = 0; j < list.size(); j++) {
				avg += list.get(i);
			}
			avg = avg/list.size();
			list.set(i, avg);
		}
		return list;
	}
	public ArrayList<Integer> addInts(int[] arr){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i <= arr.length; i++) {
			for(int j = 0; j < i; j++) {
				list.add(arr[j]);
			}
		}
		return list;

	}
}
