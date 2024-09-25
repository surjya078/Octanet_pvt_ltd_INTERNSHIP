package octanet_Intern_project_ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User { 
	private int userId;
	private int pin;
	private double balance;
	private TransactionHistory transactionHistory;

	public User(int userId, int pin) {
		super();
		this.userId = userId;
		this.pin = pin;
		this.balance = 100.0;
		this.transactionHistory = new TransactionHistory();
	}

	public int getUserId() {
		return userId;
	}

	public int getPin() {
		return pin;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
		transactionHistory.addTransaction(new Transaction(amount, "Deposit"));
	}

	public boolean withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			transactionHistory.addTransaction(new Transaction(amount, "Withdraw"));
			return true;
		} else {
			System.out.println("Insufficient Balance !!!");
			return false;
		}
	}

	public boolean transfer(User recipient, double amount) {
		if (withdraw(amount)) {
			recipient.deposit(amount);
			transactionHistory.addTransaction(new Transaction(amount, "Transfer to User ID: " + recipient.getUserId()));
			return true;
		} else {
			return false;
		}
	}

	public List<Transaction> getTransactionHistory() {
		return transactionHistory.getTransactions();
	}
}

class Transaction {
	private double amount;
	private String type;

	public Transaction(double amount, String type) {
		this.amount = amount;
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}
}

class TransactionHistory {
	private List<Transaction> transactions;

	public TransactionHistory() {
		transactions = new ArrayList<>();
	}

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}
}

class ATMSystem {
	private User currentUser;

	public boolean authenticateUser(int userId, int pin) {
		return userId == 987654 && pin == 2001; // User ID and PIN
	}

	public void startATM() {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;

		while (!quit) {
			System.out.println("ATM MACHINE Interface");
			System.out.println(" 1. Transaction History\n 2. Withdraw\n 3. Deposit\n 4. Transfer\n 5. Quit\n");
			System.out.print("Enter Your Choice : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				displayTransactionsHistory();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				deposit();
				break;
			case 4:
				transfer();
				break;
			case 5:
				quit = true;
				System.out.println("Existing ATM ....");
				System.out.println("Thank you for Using ATM...Have a Nice Day...");
				break;
			default:
				System.out.println("Invalid Choice !! Try Again !!!");
			}
		}
	}

	private void displayTransactionsHistory() {
		if (currentUser != null) {
			List<Transaction> transactions = currentUser.getTransactionHistory();
			System.out.println("\nTransactions History : ");
			for (Transaction transaction : transactions) {
				System.out.println("Type : " + transaction.getType() + ", Amount : " + transaction.getAmount() + " rs");
			}
		}
	}

	private void withdraw() {
		if (currentUser != null) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter withdrawal amount : ");
			double amount = sc.nextDouble();
			currentUser.withdraw(amount);
			System.out.println("Remaining Balance is : " + currentUser.getBalance() + " rs");
		}
	}

	private void deposit() {
		if (currentUser != null) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter deposit amount : ");
			double amount = sc.nextDouble();
			currentUser.deposit(amount);
			System.out.println("Deposit Successfull New Balance is : " + currentUser.getBalance() + " rs");

		}
	}

	private void transfer() {
		if (currentUser != null) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter recipient's User ID : ");
			int recipientUserId = sc.nextInt();

			User recipient = new User(recipientUserId, 0);

			if (recipient != null) {
				System.out.print("Enter transfer amount : ");
				double amount = sc.nextDouble();
				boolean success = currentUser.transfer(recipient, amount);

				if (success) {
					System.out.println("Transfer successful...");
				} else {
					System.out.println("Transfer failed !! Please check your balance...");
				}
			} else {
				System.out.println("Recipient not found !!! Try Again !!!! ");
			}
		}

	}

	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
}

public class ATMApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter User ID: ");
		int userId = sc.nextInt();
		System.out.print("Enter PIN: ");
		int pin = sc.nextInt();

		ATMSystem atmSystem = new ATMSystem();
		

		if (atmSystem.authenticateUser(userId, pin)) {
			System.out.println("Successfully Logged in...");
			User currentUser = new User(userId, pin);
			atmSystem.setCurrentUser(currentUser);
			atmSystem.startATM();
		} else {
			System.out.println("Authentication Failed... Try Again !!");
		}

	}
}
