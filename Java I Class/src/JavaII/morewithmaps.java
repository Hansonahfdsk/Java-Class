package JavaII;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import JavaClass.ScannersConditions;

public class morewithmaps {
	private static Scanner input = new Scanner(System.in);
	public double stockValues(HashMap<String, Integer> stocks) {
		System.out.println("Input company name: ");
		String company = input.nextLine();
		if (company == "average") {
			double avg = 0;
			for (int i: stocks.values()) {
				avg += i;
			}
			avg /= stocks.size();
			return avg;
		}
		if (stocks.get(company) == null) {
			double max = 0;
			for (int i: stocks.values()) {
				if (i > max) {
					max = i;
				}
			}
			return max;
		}
		return stocks.get(company);
	}
	public static String[] chaintargets(HashMap<String, String> names) {
		System.out.println("Input starting name: ");
		String start = input.nextLine();
		String[] players = new String[names.size()];
		String curr = start;
		int i = 0;
		players[i] = start;
		for (i = 1; i < names.size(); i++) {
			curr = names.get(curr);
			if (curr == start) {
				break;
			}
			players[i] = curr;
		}
		return players;
	}
	public String morseCode() {
        String message;
        String translation = "";
        HashMap<String, String> morse = new HashMap<String,String>();
        morse.put("a", ".-");
        morse.put("b", "-...");
        morse.put("c", "-.-.");
        morse.put("d", "-..");
        morse.put("e", ".");
        morse.put("f", "..-.");
        morse.put("g", "--.");
        morse.put("h", "....");
        morse.put("i", "..");
        morse.put("j", ".---");
        morse.put("k", "-.-");
        morse.put("l", ".-..");
        morse.put("m", "--");
        morse.put("n", "-.");
        morse.put("o", "---");
        morse.put("p", ".--.");
        morse.put("q", "--.-");
        morse.put("r", ".-.");
        morse.put("s", "...");
        morse.put("t", "-");
        morse.put("u", "..-");
        morse.put("v", "...-");
        morse.put("w", ".--");
        morse.put("x", "-..-");
        morse.put("y", "-.--");
        morse.put("z", "--..");
        System.out.println("Type your message");
        message = input.nextLine();
        message = message.toLowerCase();
        for (int i = 0; i < message.length(); i++) {
            if (morse.containsKey(message.substring(i, i+1))) {
                translation += morse.get(message.substring(i, i+1));
            }
        }
        System.out.println(translation);
        return translation;
    }
	public static void main(String args[]) {
		HashMap<String, Integer> companies = new HashMap<String, Integer>(){{
			put("Apple", 1);
			put("Google", 2);
			put("Amazon", 3);
			put("Microsoft", 4);
			}
		};
		HashMap<String, String> targets = new HashMap<String, String>(){{
			put("Ryan", "Yumna");
			put("Yumna", "Cooper");
			put("Cooper", "Anika");
			put("Anika", "Ryan");
			}
		};
		System.out.println(Arrays.toString(chaintargets(targets)));
	}
}
