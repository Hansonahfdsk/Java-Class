package JavaClass;

public class Car {
	private String name;
	private int year;
	private int mileage;
	public Car(String name, int year, int mileage) {
		this.name = name;
		this.year = year;
		this.mileage = mileage;
	}
	public void drive(int distance) {
		mileage += distance;
	}
	public int worth() {
		return 10000 - mileage - 2022 + year;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int n) {
		mileage = n;
	}
}
