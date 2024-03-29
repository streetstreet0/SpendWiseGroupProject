package backend;

import javafx.beans.property.StringProperty;

/**
 * This is the visual representation of a transaction for the tableview
 * 
 * Note that if the transaction is editted in any way (such as changing the
 * category), this will not notice. A new transactionVisual will need to be
 * created.
 */
public class TransactionVisual {
	private final StringProperty transactionTitle;
	private final StringProperty date;
	private final StringProperty amount;
	private final StringProperty purchase;
	private final StringProperty category;

	public TransactionVisual(StringProperty transactionTitle, StringProperty date, StringProperty amount,
			StringProperty purchase, StringProperty category) {
		this.transactionTitle = transactionTitle;
		this.date = date;
		this.amount = amount;
		this.purchase = purchase;
		this.category = category;
	}

	public StringProperty getTransactionTitle() {
		return transactionTitle;
	}

	public StringProperty getDate() {
		return date;
	}

	public StringProperty getAmount() {
		return amount;
	}

	public StringProperty getPurchase() {
		return purchase;
	}

	public StringProperty getCategory() {
		return category;
	}

	public void setCategory(String newCategory) {
		this.category.setValue(newCategory);
	}
	
}
