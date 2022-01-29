package JavaClass;

import java.awt.Color;

public class wrestler {
	private String name;
	private double weight;
	private String c;
	private int wins;
	public wrestler(String name, double weight, String c, int wins) {
		this.name = name;
		this.weight = weight;
		this.c = c;
		this.wins = wins;
	}
	public String intimidate() {
		return ": *Intimidating Laughter* Hahahahahehahehaha";
	}
	public void fight(wrestler a) {
		if (a.weight > weight) 
			a.wins++;
		else if (a.weight < weight)
			wins++;
		else {
			int temp = a.name.compareTo(name);
			if (temp < 0)
				a.wins++;
			else
				wins++;
		}
	}
	public void lift(int time) {
		weight += time * 0.01;
	}
	public void tagteam(wrestler[] a, wrestler[] b) {
		double tota = weight, totb = b[0].weight;
		for (int i = 0; i < a.length; i++) {
			a[i].c = c;
			tota += a[i].weight;
		}
		for (int i = 1; i < b.length; i++) {
			b[i].c = b[0].c;
			totb += b[i].weight;
		}
		if (tota >= totb) {
			wins++;
			for (int i = 0; i < a.length; i++)
				a[i].wins++;
		}
		else {
			for (int i = 0; i < b.length; i++) {
				b[i].wins++;
			}
		}
	}
	public String toString() {
		return "Wrestler: " + name + ", Weight: " + weight + ", Color: " + c + ", Wins: " + wins;
	}
	public static void main(String args[]) {
		wrestler Tony = new wrestler("Tony", 80, "Green", 0);
		wrestler Bryan = new wrestler("Bryan", 72, "Navy Blue", 0);
		System.out.println(Tony);
		System.out.println(Bryan);
		System.out.println(Tony.name + Tony.intimidate());
	}
}
