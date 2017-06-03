package week1project;
import java.util.Scanner;

public class MakeChangeEfficient {
	static int[] changeDenoms = new int[12];

	public static void main(String[] args) {
		TakeInput();
	}

	public static void TakeInput() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter item price: ");
		double ticketPrice = keyboard.nextDouble();
		System.out.print("Please enter the money tendered: ");
		double moneyGiven = keyboard.nextDouble();
		keyboard.close();
		
		if ((ticketPrice * 100 % 1) != 0 || (moneyGiven * 100 % 1) != 0) {
			System.out.println("Invalid amount!!");
		} else {
			if (ticketPrice > moneyGiven) {
				System.out.println("Insufficient coin!!");
				CalcChange(-ticketPrice, 0);			
				System.out.println("Required: " + Concat());
			} else {
				CalcChange(ticketPrice, moneyGiven);			
				System.out.println("Your change includes: " + Concat());
			}
		}
	}
	
	public static void CalcChange(double ticketPrice, double moneyGiven) {
		double returnSum = (moneyGiven * 100) - (ticketPrice * 100);
		int[] noteGroup = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5, 1};
		for (int i = 0; i < changeDenoms.length; i++) {
			if ((int)(returnSum / noteGroup[i]) % 1 == 0) {
				changeDenoms[i] = (int)(returnSum / noteGroup[i]);	
			} else {
				changeDenoms[i] = 0;
			}
			returnSum = returnSum - (changeDenoms[i] * noteGroup[i]); 
		}
	}
	
	public static String Concat() {
		String[] notesCoins = {" hundred(s), ", " fiftie(s), ", " twentie(s), ", 
				" ten(s), ", " five(s), ", " two(s), ", " one(s), ", " fifty c(s), ", 
				" quarter(s), ", " dime(s), ", " nickle(s(, ", " pennie(s)."};
		String concat = "";
		
		for (int i = 0; i < changeDenoms.length; i++) {
			if (changeDenoms[i] != 0) {
				concat += changeDenoms[i] + notesCoins[i];
			}
		}
		return concat;
	}
}