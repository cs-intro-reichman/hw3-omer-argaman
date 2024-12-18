// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		System.out.println();
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
		System.out.println();
		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	//private static double endBalance(double loan, double rate, int n, double payment) {	
	
	//	return 0;
	//	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		double payment = loan / n;
		double loan1 = loan;

		while (loan1 > epsilon) {
			loan1 = loan;

			for (int i = 0; i < n; i++) {
				loan1 = (loan1 - payment) * (1 + rate / 100);
				//System.out.println(loan1);
        	}
			if (loan1 > epsilon) { 
				iterationCounter++;
				payment += epsilon;
			} else {
				break; 
			}
		}
		return payment;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;
		double low = 0;
		double high = loan;
		double payment = (low + high)/2;
		double loan1 = loan;
		while ((high - low) > epsilon) {
			loan1 = loan;
			for (int i = 0; i < n; i++) {
				loan1 = (loan1 - payment) * (1 + rate / 100);
        	}
			iterationCounter++;
			if (loan1 < 0) {
                high = payment;
            } else {
                low = payment;
            }
			payment = (low + high)/2;


		}
		return payment;
		}
}
