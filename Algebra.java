// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    System.out.println(plus(2,3));   // 2 + 3 = 5
	    System.out.println(minus(7,2));  // 7 - 2 = 5
   		System.out.println(minus(2,7));  // 2 - 7 = -5
 		System.out.println(times(3,4));  // 3 * 4 = 12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 = 10
   		System.out.println(pow(5,3));      // 5^3 = 125
   		System.out.println(pow(3,5));      // 3^5 = 243
   		System.out.println(div(12,3));   // 12 / 3 = 4   
   		System.out.println(div(5,5));    // 5 / 5  = 1
   		System.out.println(div(25,7));   // 25 / 7 = 3
   		System.out.println(mod(25,7));   // 25 % 7 = 4
   		System.out.println(mod(120,6));  // 120 % 6  = 0  
   		System.out.println(sqrt(36)); // 6
		System.out.println(sqrt(263169)); // 513
   		System.out.println(sqrt(76123));	// 275
	}  

	// Returns x + y
	public static int plus(int x, int y) {
		if (y < 0) {
			for (int i = 0; i < -y; i++) {
				x--;
			}	
		}else{
			for (int i = 0; i < y; i++) {
				x++;
			}
		}
		return x;
	}

	// Returns x1 - x2
	public static int minus(int x, int y) {
		if (y < 0) {
			for (int i = 0; i < -y; i++) {
                x++;
            }
		} else {
			for (int i = 0; i < y; i++) {
                x--;
            }
		}
		return x;
	}

	// Returns x * y
	public static int times(int x, int y) {
		int x1 = 0;
		if (x < 0 && y < 0){
			x = -x;
            y = -y;
		}
		for (int i1 = 0; i1 < y; i1++) {
			x1 = x1 + x;
		}
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int x1 = 1;
		if (x < 0 && mod(n,2)!=0) {
			x = -x;
			for (int i = 0; i < n; i++) {
				x1 = times(x1, x);
			}
			return -x1;
		}
		for (int i = 0; i < n; i++) {
            x1 = times(x1, x);
        }
		return x1;
	}
	// Returns the integer part of x / y 
	public static int div(int x, int y) {
		int x1 = 0;
		if (x < 0 && y < 0) {
			x = -x;
            y = -y;
        }else if ( x < 0) {
			x = -x;
			for (int i = 0; plus(i,y) <= x; i = plus(i,y)) {
				x1++;
			}
			return -x1;
		}else if ( y < 0){
			y = -y;
            for (int i = 0; plus(i,y) <= x; i = plus(i,y)) {
                x1++;
            }
            return -x1;
		}
		for (int i = 0; plus(i,y) <= x; i = plus(i,y)) {
            x1++;
        }
		return x1;
	}

	// Returns x1 % x2
	public static int mod(int x, int y) {
		int a = div(x,y);
		int b = times(a,y);
		return minus(x,b);		
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if ( x == 0 || x == 1 ) {
			return x;
		}
		for (int i = 0; i < x; i++) {
		    if (times(i,i) == x) {
				return i;
			} else if (times(i,i) > x) {
                return i - 1;
				} 
		}
		return -1; // Should not get here, but for safety, return -1 in case of an error.
	}
}
		