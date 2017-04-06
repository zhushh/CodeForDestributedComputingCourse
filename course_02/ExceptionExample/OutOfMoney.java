import java.lang.Exception;

class OutOfMoney extends Exception {
	public OutOfMoney() {
		super("You account have not enough money!")
	}

	public OutOfMoney(String msg) {
		super(msg);
	}
}
