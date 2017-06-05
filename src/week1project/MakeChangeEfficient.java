package week1project;
import java.util.Scanner;

public class MakeChangeEfficient {
	static int[] changeDenoms = new int[12];
	static String[] promptUser = {"Please enter item price: ", "Please enter the money tendered: ",
					"Invalid amount!!", "Insufficient coin!!", "Required: ", "Your change includes: "};
	static double inputArray[] = new double[2];
	
	public static void main(String[] args) {

		TakeInput();
	}
	
	/*********************************************************
	 * 	I would very much like to compress TakeInput more
	 * 	I think this whole method could be put into one array
	 * 	I just have to figure out how to do it.
	 *********************************************************/

	public static void TakeInput() {
		Scanner keyboard = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			System.out.print(promptUser[i]);
			inputArray[i] = keyboard.nextDouble(); // Ticket price and money given taken into array.
		}
		keyboard.close();	

		if ((inputArray[0] * 100 % 1) != 0 || (inputArray[1] * 100 % 1) != 0) {
			System.out.println(promptUser[2]);
		} else {
			if (inputArray[0] > inputArray[1]) {	// If this is true, more money is required, and the prompts inform as much.
				System.out.println(promptUser[3]);
				CalcChange(-inputArray[0], 0);	// Negative ticketPrice to invert as CalcChange takes 0 to compare.
				System.out.println(promptUser[4] + Concat()); // Still uses the CalcChange and Concat methods to inform the user.
			} else {
				CalcChange(inputArray[0], inputArray[1]);	// If all is well, this will happen.
				System.out.println(promptUser[5] + Concat());
			}
		}
	}
	
	public static void CalcChange(double ticketPrice, double moneyGiven) {
		double returnSum = (moneyGiven * 100) - (ticketPrice * 100); // (moneyGiven - ticketPrice) * 100, did not work for various denoms WHY!!!
		int[] noteGroup = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5, 1}; // * 100 removes decimal places, easier to work with.
		for (int i = 0; i < changeDenoms.length; i++) {
			if ((int)(returnSum / noteGroup[i]) % 1 == 0) { 	// Could be done with >=, really depends on the developer.
				changeDenoms[i] = (int)(returnSum / noteGroup[i]);	// Casing removes the decimal to add to the changeDenoms array
			} else {
				changeDenoms[i] = 0; // Assigns value to not used part of array, could leave as null, but it was easier for debug.
			}
			returnSum = returnSum - (changeDenoms[i] * noteGroup[i]); // Keep changing the return sum after the multiples have been removed.
		}
	}
	
	public static String Concat() {
		final String[] notesCoins = {" hundred(s), ", " fiftie(s), ", " twentie(s), ", // This could be made more efficient
				" ten(s), ", " five(s), ", " two(s), ", " one(s), ", " fifty c(s), ",  // I don't know how as yet.
				" quarter(s), ", " dime(s), ", " nickle(s(, ", " penny(s)."};
		String concat = "";
		
		for (int i = 0; i < changeDenoms.length; i++) {
			if (changeDenoms[i] != 0) { 	//Make sure that at least one of the values exists
				concat += changeDenoms[i] + notesCoins[i]; 	// 	Puts together the response for the user.
			}
		}
		return concat; 
	}
}