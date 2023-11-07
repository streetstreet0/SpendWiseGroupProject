package backend;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transaction {
	private String transactionTitle;
	private Date date;
	private double amount;
	private boolean purchase;
	private TransactionCategory category;
	private TransactionVisual visual;

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
		if (visual != null) {
			this.visual.setCategory(category.toString());
		}
	}
	
	@Override
	public String toString() {
		String transactionString = date.toString();
		transactionString += ", " + transactionTitle;
		transactionString += ", $" + amount;
		if (purchase) {
			transactionString += ", Expense";
		}
		else {
			transactionString += ", Income";
		}
		transactionString += ", " + category.toString();
		
		return transactionString;
	}
	
	/**
	 * Create a TransactionVisual for the tableview.
	 * 
	 * Note that this TransactionVisual does not update with the transaction, so whenever we change the category
	 * we will need to generate a new transaction visual and replace the old one.
	 * @return A TransactionVisual that represents the transaction for the tableview.
	 */
	public TransactionVisual generateTransactionVisual() {
		StringProperty transactionTitle = new SimpleStringProperty(this, "transactionTitle", this.transactionTitle);
		StringProperty date = new SimpleStringProperty(this, "date", this.date.toString());
		StringProperty amount = new SimpleStringProperty(this, "amount", "$" + this.amount);
		StringProperty purchase;
		if (this.purchase) {
			purchase = new SimpleStringProperty(this, "purchase", "Expense");
		}
		else {
			purchase = new SimpleStringProperty(this, "purchase", "Income");
		}
		StringProperty category = new SimpleStringProperty(this, "category", this.category.toString());
		visual = new TransactionVisual(transactionTitle, date, amount, purchase, category);
		return visual;
	}

}
