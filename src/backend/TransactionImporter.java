package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * TransactionImporter deals with the importing and exporting of transaction data to/from a text file.
 */
public class TransactionImporter {
	private File transactionFile; // this is the file that the transactions are stored in
	
	public TransactionImporter(File transactionFile) {
		this.transactionFile = transactionFile;
	}
	
	/**
	 * Imports the transactions as an array list of transactions
	 * 
	 * @throws FileNotFoundException
	 * @return ArrayList of all of the transactions from the transactionFile
	 */
	public ArrayList<Transaction> getTransactions() throws FileNotFoundException {
		Scanner scanner = new Scanner(transactionFile);
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		
		while (scanner.hasNext()) {
			// transaction files are of the form: purchase amount day month year category title
			// the category is in all capital letters
			// year is in 
			
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
	
	/**
	 * Exports transactions to the text file.
	 * 
	 * Saves the transactions in the transactionFile. Note that this overwrites the original file.
	 * 
	 * @param transactions an array list of transactions to export
	 * @throws FileNotFoundException
	 */
	public void exportTransactionList(ArrayList<Transaction> transactions) throws FileNotFoundException {
		PrintStream print = new PrintStream(transactionFile);
		
		print.close();
	}
}
