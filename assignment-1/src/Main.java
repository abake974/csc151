import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double balance = 0.00;
		boolean isRunning = true;
		
		System.out.println("Welcome to TradeOne Wallet");
		
		while(isRunning) {
			System.out.println("\nOptions:");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.print("Select an Option: ");
			
			if(!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Invalid Input. Enter a number between 1 and 4.");
				continue;
			}
			int userInput = scanner.nextInt();
			
			// Depositing
			if(userInput == 1) {
				System.out.print("Enter deposit amount: $");
				if(!scanner.hasNextDouble()) {
					scanner.next();
					System.out.println("Invalid deposit amount. Cancelled");
					continue;
				}
				double deposit = scanner.nextDouble();
				if(deposit <= 0) {
					System.out.println("Deposits must be positive.");
					continue;
				}
				balance += deposit;
				System.out.println("Deposited $" + String.format("%.2f", deposit));
			}
			
			// Withdrawal
			else if(userInput == 2) {
				System.out.print("Enter withdrawal amount: $");
				if(!scanner.hasNextDouble()) {
					scanner.next();
					System.out.println("Invalid withdrawal amount. Withdrawal cancelled.");
					continue;
				}
				double withdraw = scanner.nextDouble();
				if(withdraw <= 0) {
					System.out.println("Withdrawals must be positive.");
					continue;
				}
				if(withdraw > balance) {
					System.out.println("Insufficient Funds.");
					continue;
				}
				balance -= withdraw;
				System.out.println("Withdrew $" + String.format("%.2f", withdraw));
			}
			
			// Check Balance
			else if(userInput == 3) {
				System.out.println("Current balance: $" + String.format("%.2f", balance));
			}
			
			// Exit
			else if(userInput == 4) {
				System.out.println("Goodbye.");
				isRunning = false;
			}
			
			//Invalid number
			else {
				System.out.println("Invalid Choice. Please select 1, 2, 3, or 4.");
			}
		}
		scanner.close();
	}
}