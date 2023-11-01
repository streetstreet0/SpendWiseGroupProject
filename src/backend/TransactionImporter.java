package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionImporter {
	private File transactionFile;
	
	public TransactionImporter(File transactionFile) {
		this.transactionFile = transactionFile;
	}

	public ArrayList<Transaction> getTransactions() throws FileNotFoundException {
		Scanner scanner = new Scanner(transactionFile);
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		
		while (scanner.hasNext()) {
			boolean purchase = scanner.nextBoolean();
			double amount = scanner.nextDouble();
			
			int day = scanner.nextInt();
			int month = scanner.nextInt();
			int year = scanner.nextInt();
			Date date = new Date(day, month, year);
			
			TransactionCategory category = TransactionCategory.toCategory(scanner.next().strip());
			String title = scanner.nextLine().strip();
			transactionList.add(new Transaction(title, date, amount, purchase, category));
		}
		
		scanner.close();
		return transactionList;
	}
	
	public void exportTransactionList(ArrayList<Transaction> transactions) throws FileNotFoundException {
		
	}
}
