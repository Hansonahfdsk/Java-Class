
package JavaClass;/*
public class SumIt_Lineslope {
	
  // instance variables
  private double one, two, sum;
  
  // use the two parameters to set the values of your two instance variables
  public voJavaClassid setNums(double num1, double num2) {
	  one = num1;
	  two = num2;
  }
  
  // sum the two numbers here
  public void sum() {
	  sum = one + two;
  }
  
  // print the sum here
  public void print() {
	  System.out.println(sum);
  }
  
  
  public static void main(String[] args) {
	  SumIt_Lineslope runner = new SumIt_Lineslope();
	  
	  // should print out 12
	  runner.setNums(5,  7);
	  runner.sum();
	  runner.print();
	  
	  // should print out 40
	  runner.setNums(13, 27);
	  runner.sum();
	  runner.print();
  }
  
}
*/

public class SumIt_Lineslope {
	
	// you'll probably want some instance variables... (4 coordinates and a slope)
	private double a1, b1, a2, b2, slope;


	// use the parameters to assign your instance variables
	public void set_coordinates (double x1, double y1, double x2, double y2) {
		a1 = x1;
		b1 = y1;
		a2 = x2;
		b2 = y2;
	}

	
	// calculate the slope using your instance variables
	public void calculate_slope () {
		slope = (b2 - b1)/(a2 - a1);
	}

	
	// print the slope you calculated in calculate_slope
	public void display_slope () {
		System.out.println(slope);
	}
	
	public static void main(String[] args) {
		
		SumIt_Lineslope runner = new SumIt_Lineslope();
		
		// this line should have a slope of 2
		runner.set_coordinates(3, 3, 7, 11);
		runner.calculate_slope();
		runner.display_slope();
		
		// this line should have a slope of -.75
		runner.set_coordinates(0, -2, -4, 1);
		runner.calculate_slope();
		runner.display_slope();

	}
}