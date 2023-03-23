import java.util.Scanner;
import java.util.List;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("╔═══════════════════════╗");
		System.out.println("║        Welcome!       ║");
		System.out.println("╚═══════════════════════╝");
		System.out.print("Enter the account name: ");
		String accountName = in.nextLine();
		double balance;
		while (true) {
			try {
				System.out.print("Enter your balance: ");
				balance = in.nextDouble();
				break;
			} catch (Exception e) {
				System.out.println("Invalid input.");
				in.nextLine();
			}
		}

		BankAccount account = new BankAccount(accountName, balance);

		while (true) {
			System.out.println("\n\n┏        Options         ┓");
			System.out.println("╔════════════════════════╗");
			System.out.println("║ 1. Deposit             ║");
			System.out.println("║ 2. Withdraw            ║");
			System.out.println("║ 3. Account details     ║");
			System.out.println("║ 4. Transaction History ║");
			System.out.println("║ 5. Quit                ║");
			System.out.println("╚════════════════════════╝");

			int choice;
			while (true) {
				try {
					System.out.print("Your choice: ");
					choice = in.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Invalid options");
					in.nextInt();
				}
			}

			if (choice == 1) {
				double amount;
				while (true) {
					try {
						System.out.print("Enter the amount to deposit: ");
						amount = in.nextDouble();

						if (amount <= 0) {
							throw new InvalidDepositException("Invalid amount");
						}
						account.deposit(amount);
						System.out.printf("Succesful! \nCurrent Balance: $%.2f", account.getBalance());
						break;
					} catch (InvalidDepositException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println("Invalid input.");
						in.nextLine();
					}
				}
			} else if (choice == 2) {
				double amount;
				while (true) {
					try {
						System.out.print("How much would you like to withdraw: ");
						amount = in.nextDouble();
						break;
					} catch (Exception e) {
						System.out.println("Invalid input.");
						in.nextLine();
					}
				}
				try {
					account.withdraw(amount);
					System.out.printf("Succesful! \nCurrent Balance: $%.2f", account.getBalance());
				} catch (InsufficientException e) {
					System.out.printf("Insufficient funds. You have $%.2f", account.getBalance());
				}
			} else if (choice == 3) {
				System.out.println("Account Name: " + account.getaccountName());
				System.out.printf("Balance: $%.2f %n", account.getBalance());
				if (account.getLatestTransaction().isEmpty()){
					System.out.println("Latest Transactions: None");
				}else{
					System.out.println("Latest Transaction: "+ account.getLatestTransaction().get(account.getLatestTransaction().size()-1));
				}
			} else if (choice == 4) {
				List<String> latestTransaction = account.getLatestTransaction();
				if (latestTransaction.isEmpty()) {
					System.out.println("No transactions");
				} else {
					System.out.println("Latest Transactions:");
					for (String transaction : latestTransaction) {
						System.out.println(transaction);
					}
				}

			} else if (choice == 5) {
				System.out.println("Have a good day!");
				break;
			} else {
				System.out.println("Invalid choice. Please enter a number between 1 and 5");
			}
		}
		in.close();
	}
}
