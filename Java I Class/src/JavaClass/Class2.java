/*
 * 1. 6
 * 2. 4
 * 3. 9
 * 4. 1.4
 * 5. 55
 * 6. 1.0
 * 7. 98
 * 8. 6
 * 9. 53
 * 10. 3
 * 
 * 1. Illegal -- name shouldn't contain space
 * 2. Legal
 * 3. Illegal -- name shouldn't contain special characters except for _
 * 4. Legal
 * 5. Illegal -- already name of type of variable
 * 6. Legal
 * 7. Illegal -- name shouldn't start with number
 * 8. Legal
 * 
 * 1. Legal
 * 2. Illegal -- should be True or False
 * 3. Legal
 * 4. Legal
 * 5. Legal
 * 6. Illegal -- shouldn't contain special character in integer
 * 7. Illegal -- should be integer
 * 8. Legal
 * 9. Legal
 * 
 * 
 */

/*
public class Example {
	int x;
	public void setX(int y) {
		int x = y;
		}
	public void doubleNum() {
		System.out.println(2*y);
		}
	}
*/

package JavaClass;
	public class Class2{

		public static void numtochar(int number) {
			System.out.println((char)(number));
		}
		public static void lastdigit(int num) {
			System.out.println(num % 10);
		}
		public static void average(int a, int b) {
			System.out.println((double)(a+b)/2);
		}
		public static void main(String[] args) {
			Class2 runner = new Class2();
			runner.numtochar(97);
			runner.lastdigit(105);
			runner.average(5, 10);
		}
	
}