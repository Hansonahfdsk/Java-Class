package JavaClass;

public class Physics extends Tests{
	public Physics(String name, int score, int percentile, String topic) {
		this.name = name;
		this.score = score;
		this.percentile = percentile;
	}
	public void addScore(int add) {
		super.setScore(super.getScore() + add);
	}
}
