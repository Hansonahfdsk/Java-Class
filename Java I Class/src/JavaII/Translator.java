package JavaII;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {
    private Map<String, String> dictionary;
    private Scanner s;
    private void doTranslate() throws IOException {
        this.dictionary = new HashMap<>();
        this.s = new Scanner(System.in);
        wordReader();
        while (true) {
            System.out.println("Input English word: ");
            String translate = s.nextLine();
            System.out.println(dictionary.getOrDefault(translate.toLowerCase(), "Not Found"));
        }
    }
    private void wordReader() throws IOException {
        FileReader input = new FileReader("EnglishToArabicDictionary.txt");
        BufferedReader read = new BufferedReader(input);
        read.readLine();
        String english, arabic;
        while((english = read.readLine()) != null) {
            arabic = read.readLine();
            dictionary.put(english, arabic);
        }
    }
	public static void main(String[] args) throws IOException {
		new Translator().doTranslate();
	}
}
