package JavaII;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionarySorterFiller {
	
	public String mode = "selection";	
	public String fileName = "wordsShuffledSmaller.txt";
	
	public void selectionSort(List<String> words) {
		for (int i = 0; i < words.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < words.size(); j++) {
				if (words.get(min).compareTo(words.get(j)) > 0){
					min = j;
				}
			}
			String temp = words.get(i);
			words.set(i, words.get(min));
			words.set(min, temp);
		}
	}
	
	public void insertionSort(List<String> words) {
		for (int i = 1; i < words.size(); i++) {
			int j = i;
			while (j > 0 && words.get(j).compareTo(words.get(j - 1)) < 0) {
				String temp = words.get(j);
				words.set(j, words.get(j - 1));
				words.set(j - 1, temp);
				j--;
			}
		}
	}

	public void mergeSort(List<String> words) {	// starter for your recursion
		mergeSort(words, 0, words.size()-1);
	}
	
	public void mergeSort(List<String> words, int start, int end) {
		
		// your code here

	}
	
	public void merge(List<String> words, int start, int mid, int end) {

		// your code here

	}
	
	public static void main(String[] args) throws IOException {
		new DictionarySorterFiller();
	}
	public DictionarySorterFiller() throws IOException{
		// generates the word list from the dictionary file
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		List<String> words = new ArrayList<String>();
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			words.add(line.trim());
		}
		in.close();
		long startTime = System.currentTimeMillis();
		if (mode.equals("selection"))
			selectionSort(words);
		else if (mode.equals("insertion"))
			insertionSort(words);
		else
			mergeSort(words);
		System.out.println("runtime: " + (System.currentTimeMillis() - startTime));
		
		BufferedWriter out = new BufferedWriter(new FileWriter("wordsSorted.txt"));
		for (String s : words)
			out.write(s + "\n");
		out.close();
	}
}
