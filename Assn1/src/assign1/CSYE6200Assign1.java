package assign1;

/**
 * A starter file for implementing CSYE 6200 Assignment 1 <br>
 * Note: the package is 'assign1' so your code should be in source folder:
 * src\assign1 Filename: CSYE6200Assign1.java <br>
 * 
 * NUID: 001716776 <br>
 * 
 * @author Renjith Prasad
 * @Lastedited- 01/27/2016 1.Added user case to handle default and history
 *              2.Case to handle 'without input case' when user presses - Enter
 *              3.Added comments. 4.Change in logic to include the case when
 *              user just types enter as first choice
 * 
 **/

public class CSYE6200Assign1 {

	/**
	 * Your program starts with this method call
	 */
	public static void main(String args[]) throws java.io.IOException {
		// Create an instance of the class, and call the constructor method
		CSYE6200Assign1 prog1 = new CSYE6200Assign1();
		prog1.run(); // call the run method
		// We're done. The program will exit.
	}

	/**
	 * Constructor
	 */
	public CSYE6200Assign1() {
		// After a 'new' call the constructor is executed first - for now,
		// nothing happens
	}

	/**
	 * Perform all of the user operations
	 */
	public void run() throws java.io.IOException {

		// Variable declaration - for supporting the functions and
		// "no input functionality"//
		char inChar = ' ';
		int counter = 1;
		char lastChar = '\n';
		char[] a = new char[] { '*', '*', '*', '*' };

		// User Input - Received through read-in system //
		System.out
				.println("Enter choice (1,2,3), or \'q\' to quit, then press <enter>.");

		// do-while loop to handle quit condition and includes the switch
		// cases//
		do {
			inChar = (char) System.in.read();

			// Handle case when user hits enter without any input.
			if ((lastChar == inChar) && (lastChar == '\n')) {
				lastChar = '*';
				if (counter == 1) {
					a[1] = lastChar;
				} else if (counter == 2) {
					a[2] = lastChar;
				} else if (counter == 3) {
					a[3] = lastChar;
				} else {
					a[0] = a[1];
					a[1] = a[2];
					a[2] = a[3];
					a[3] = '*';
				}
				counter += 1;
				System.out.println("Please enter some input\n");
			}
			lastChar = inChar;

			// Swapping the user input for maintaining history//
			if (inChar != '\n') {
				if (counter == 1) {
					a[1] = inChar;
				} else if (counter == 2) {
					a[2] = inChar;
				} else if (counter == 3) {
					a[3] = inChar;
				} else {
					a[0] = a[1];
					a[1] = a[2];
					a[2] = a[3];
					a[3] = inChar;
				}
				counter += 1;

				// Switch cases including the default condition//
				switch (inChar) {
				case '1':
					System.out.println("You selected option 1");
					int sum = 0;
					for (int i = 1; i < 10; i++) {
						sum += Math.pow(i, 2);
						System.out.println("Number:" + i + " NumberSq:"
								+ Math.pow(i, 2));
					}
					System.out.println("The sum of square values :" + sum);
					break;
				case '2':
					System.out.println("You selected option 2");
					int y = (int) inChar;
					System.out.println("The input value in integer is : " + y);
					break;
				case '3':
					System.out.println("You selected option 3");
					System.out.print("The history is : ");
					for (int i = 1; i < 4; i++) {
						System.out.print(a[i]);
					}
					break;
				default:
					System.out.println("Invalid selection: " + inChar);
					break;
				}
			}

			// Function to check if the password matches
			String pass = new StringBuilder().append(a[0]).append(a[1])
					.append(a[2]).append(inChar).toString();
			if (isPassCodeTyped(pass)) {
				System.out.println("Password Matched");
			}

		} while (inChar != 'q'); // Exit on quit
		System.out.println("Quiting...");
	}

	// Function which checks incoming character history for password match
	private boolean isPassCodeTyped(String passcheck) {
		if (passcheck.equals("rpra")) {
			return true;
		} else {
			return false;
		}
	}
}
