package JavaClass;
public class SA4 {
	
	
	public void distance (double x1, double y1, double x2, double y2) {
		System.out.println(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
	}
	public void quadratic (double a, double b, double c) {
		double zero1, zero2;
		zero1 = (-1 * b + Math.sqrt((b * b - 4 * a * c)))/ 2 * a;
		zero2 = (-1 * b - Math.sqrt((b * b - 4 * a * c)))/ 2 * a;
		System.out.println(zero1 + " " + zero2);
	}
	public void charAverage (double d, double e) {
		double avg;
		avg = (d + e) / 2;
		System.out.println((char) avg);
	}
	public static void main(String[] args) {
		
		SA4 tester = new SA4();
		tester.distance(1, -2.5, 3.1, 4);
		tester.quadratic(1, 0, -4);
		tester.charAverage('m', 'A');
	}
}