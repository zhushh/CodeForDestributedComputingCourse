class AccountException {
	public static void main(String[] args) {
		Account obj = new Account();
		double amount = 800;
		for (int count = 0; count < 3; count++) {
			try {
				obj.transfer(amount);
				System.out.println("Transfer amount: " + amount + ", and then balance: "+obj.getBalance());
			} catch (OutOfMoney exc) {
				exc.printStackTrace();
			} finally {
				System.out.println("finally statements will always be excuted!");
			}

			amount = amount - 300;
		}
	}
}
