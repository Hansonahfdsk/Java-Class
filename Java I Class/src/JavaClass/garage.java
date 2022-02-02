package JavaClass;

public class garage {
	private car[] car;
	public garage(int n) {
		this.car[] = new car[n];
	}
	public int addcar(int i, String name, int year, int mileage) {
		car[i] = new Car(name, year, mileage);
	}
	public int totalWorth() {
		int sum = 0;
		for (int i = 0; i < car.length; i++) {
			sum += car[i].worth();
		}
		return sum;
	}
	public int averageMileage() {
		int avg = 0;
		for (int i = 0; i < car.length; i++) {
			avg += car[i].getMileage();
		}
		return avg / car.length;
	}
	public void drive(int i, int n) {
		car[i].mileage += n;
	}
}
