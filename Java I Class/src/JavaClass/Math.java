package JavaClass;

public class Math extends Tests{
	public Math(String name, int score, int percentile) {
		this.name = name;
		this.score = score;
		this.percentile = percentile;
	}
	public void addScore(int add) {
		Tests.setScore(Tests.getScore() + add);
	}
}
