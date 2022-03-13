package JavaClass;

public class Garage extends Car{
	private Car[] car;
	public Garage(Car[] n) {
		this.car = n;
	}
	public void addcar(int i, String name, int year, int mileage) {
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
		int avg = 0, n = 0;
		for (int i = 0; i < car.length; i++) {
			if (car[i].getMileage() == 0) {
				n++;
				continue;
			}
			avg += car[i].getMileage();
		}
		return avg / (car.length - n);
	}
	public void drive(int i, int n) {
		car[i].setMileage(car[i].getMileage() + n);
	}
}
