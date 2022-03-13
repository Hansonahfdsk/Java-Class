package JavaClass;

public class Mathc extends Tests{
	public Mathc(String name, int score, int percentile, String topic) {
		this.name = name;
		this.score = score;
		this.percentile = percentile;
	}
	public void addScore(int add) {
		super.setScore(super.getScore() + add);
	}
}
