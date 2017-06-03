package week1project;

import java.util.Scanner;

public class MakeChange {
	
	static int hundredD, fiftyD, twentyD, tenD, fiveD, twoD, oneD, fiftyC, quarter, dime, nickle, penny;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter item price: ");
		double ticketPrice = keyboard.nextDouble();
		System.out.print("Please enter the money given: ");
		double moneyGiven = keyboard.nextDouble();
		
		if ((ticketPrice * 100 % 1) != 0 || (moneyGiven * 100 % 1) != 0) {
			System.out.println("Invalid amount!!");
		} else {
			System.out.print("Amount: $" + ticketPrice + ", ");
			System.out.println("Tendered: $" + moneyGiven);
			keyboard.close();
			
			
			if (ticketPrice > moneyGiven) {
				System.out.println("Insufficient coin!!");
			} else {
				CalcChange(ticketPrice, moneyGiven);
				
				System.out.println("Result: " + Concat());
				System.out.println("" + hundredD + fiftyD + twentyD + tenD + fiveD + twoD + oneD + fiftyC + quarter + dime + nickle + penny);
			}
		}
	}
	
	public static void CalcChange(double ticketPrice, double moneyGiven) {
		double returnSum = (moneyGiven * 100.0) - (ticketPrice * 100.0);
		if (returnSum >= 10000) {
			hundredD = (int)returnSum / 10000;	
		}
		returnSum = returnSum - (hundredD * 10000);
		
		if (returnSum >= 5000) {
			fiftyD = (int)returnSum / 5000;	
		}
		returnSum = returnSum - (fiftyD * 5000);
		
		if (returnSum >= 2000) {
			twentyD = (int)returnSum / 2000;
		}
		returnSum = returnSum - (twentyD * 2000);
		
		if (returnSum >= 1000) {
			tenD = (int)returnSum / 1000;
		}
		returnSum = returnSum - (tenD * 1000);
		
		if (returnSum >= 500) {
			fiveD = (int)returnSum / 500;
		}
		returnSum = returnSum - (fiveD * 500);
		
		if (returnSum >= 200) {
			twoD = (int)returnSum / 200;
		}
		returnSum = returnSum - (twoD * 200);
		
		if (returnSum >= 100) {
			oneD = (int)returnSum / 100;
		}
		returnSum = returnSum - (oneD * 100);
		
		if (returnSum >= 50) {
			fiftyC = (int)returnSum / 50;
		}
		returnSum = returnSum - (fiftyC * 50);
		
		if (returnSum >= 25) {
			quarter = (int)returnSum / 25;
		}
		returnSum = returnSum - (quarter * 25);
		
		if (returnSum >= 10) {
			dime = (int)returnSum / 10;
		}
		returnSum = returnSum - (dime * 10);
		
		if (returnSum >= 5) {
			nickle = (int)returnSum / 5;
		}
		returnSum = returnSum - (nickle * 5);
		
		if (returnSum >= 1) {
			penny = (int)returnSum / 1;
		}
		returnSum = returnSum - (penny * 1);
		
		
	}
	
	public static String Concat() {
		
	
		String concat = "";
		if (hundredD != 0) {
			concat += hundredD + " hundreds, ";
		}
		
		if (fiftyD != 0) {
			concat += fiftyD + " fifties, ";
		}
		
		if (twentyD != 0) {
			concat += twentyD + " twenties, ";
		}
		
		if (tenD != 0) {
			concat += tenD + " tens, ";
		}
		
		if (fiveD != 0) {
			concat += fiveD + " fives, ";
		}
		
		if (twoD != 0) {
			concat += twoD + " twos, ";
		}
		
		if (oneD != 0) {
			concat += oneD + " ones, ";
		}
		
		if (fiftyC != 0) {
			concat += fiftyC + " fifty cent pieces, ";
		}
		
		if (quarter != 0) {
			concat += quarter + " quarters, ";
		}
		
		if (dime != 0) {
			concat += dime + " dimes, ";
		}
		
		if (nickle != 0) {
			concat += nickle + " nickles, ";
		}
		
		if (penny != 0) {
			concat += penny + " pennies.";
		}
		return concat;
	}
}












