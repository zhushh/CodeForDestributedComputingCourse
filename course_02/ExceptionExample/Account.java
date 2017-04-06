import java.lang.Throwable;

class Account {
	private double balance = 1000;
	public void transfer(double amount) throws OutOfMoney {
		if (balance < amount) {
			throw new OutOfMoney("[Balance: " + balance + " < Amount: " + amount + "]");
		}

		balance = balance - amount;
	}

	public double getBalance() {
		return balance;
	}
}
