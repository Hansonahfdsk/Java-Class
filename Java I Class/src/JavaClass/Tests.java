package JavaClass;

public class Tests {
	public String name;
	public int score;
	public int percentile;
	public String toString() {
		return "Name: " + name + "Score: " + score + " " + percentile;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int newScore) {
		score = newScore;
	}
}
