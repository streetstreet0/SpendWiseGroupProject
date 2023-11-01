package backend;

public class Transaction {
	private String transactionTitle;
	private Date date;
	private double amount;
	private boolean purchase;
	private TransactionCategory category;

	public Transaction(String transactionTitle, Date date, double amount, boolean purchase, TransactionCategory category) {
		this.transactionTitle = transactionTitle;
		this.date = date;
		this.amount = amount;
		this.purchase = purchase;
		this.category = category;
	}

	public String getTransactionTitle() {
		return transactionTitle;
	}

	public Date getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public boolean isPurchase() {
		return purchase;
	}

	public TransactionCategory getCategory() {
		return category;
	}

	public void setCategory(TransactionCategory category) {
		this.category = category;
	}

}
