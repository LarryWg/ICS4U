import java.util.ArrayList;
import java.util.List;

public class BankAccount{
	private String accountName;
	private double balance;
	private List<String> latestTransaction;

	public BankAccount(String accountName, double balance){
		this.balance = balance;
		this.accountName = accountName;
		this.latestTransaction = new ArrayList<>();
	}

	public String getaccountName(){
		return accountName;
	}
			
	public double getBalance(){
		return balance;
	}

	public List<String> getLatestTransaction(){
		return latestTransaction;
	}
	
	public void deposit(double amount) throws InvalidDepositException{ 
		if (amount<=0){
			throw new InvalidDepositException("Enter a positive number.");
		}
		balance+=amount;
		latestTransaction.add(String.format("Deposited $%.2f", amount));
	
	}

	public void withdraw(double amount)throws InsufficientException{
		if (amount > balance){
			throw new InsufficientException();
		} 
		balance -= amount;
		latestTransaction.add(String.format("Withdrew $%.2f", amount));
	}
}