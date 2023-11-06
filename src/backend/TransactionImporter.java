package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
	 * Exports transactions to the sw file.
	 * 
	 * Saves the transactions in the transactionFile. Note that this overwrites the original file.
	 * 
	 * @param transactions an array list of transactions to export
	 * @throws FileNotFoundException
	 */

	public void exportTransactionList(ArrayList<Transaction> transactions) throws FileNotFoundException {
		PrintStream print = new PrintStream(transactionFile);
		for (Transaction transaction : transactions) {
			String exportLine = "" + transaction.isPurchase();
			exportLine += " " + transaction.getAmount();
			
			Date date = transaction.getDate();
			exportLine += " " + date.getDay();
			exportLine += " " + date.getMonth();
			exportLine += " " + date.getYear();
			
			exportLine += " " + transaction.getCategory().name();
			exportLine += " " + transaction.getTransactionTitle();
			
			print.println(exportLine);
		}
		
		print.close();
	}
	
	/**
	 * Saves an ArrayList of Transaction objects to a specified file with a ".sw" extension.
	 *
	 * @param transactions The ArrayList of Transaction objects to be saved.
	 * @throws FileNotFoundException If the specified file is not found.
	 */
	public static void saveToFile(ArrayList<Transaction> transactions) throws FileNotFoundException {
		if (transactions == null) return;
		
	    // Create a TextInputDialog to prompt the user for a file name
	    TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Save File");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Please enter a file name (without extension):");
	    
	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) {
	    	String fileName = result.get();
	        if (!fileName.toLowerCase().endsWith(".sw")) {
	            fileName += ".sw"; // Add the .sw extension if not provided
	        }
	        
	        FileChooser savedFile = new FileChooser();
	        savedFile.setInitialFileName(fileName);

	        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("SW Files (*.sw)", "*.sw");
	        savedFile.getExtensionFilters().add(extensionFilter);

	        Stage primaryStage = new Stage();
	        File file = savedFile.showSaveDialog(primaryStage);

	        if (file != null) {
	            String filePath = file.getAbsolutePath();

	            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
	                oos.writeObject(transactions);
	                System.out.println("ArrayList transactions serialized and saved to file.");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	/**
	 * Loads an ArrayList of Transaction objects from a specified file *.sw.
	 *
	 * @return An ArrayList of Transaction objects if successful, or null if an error occurs during loading.
	 */
	public static ArrayList<Transaction>  loadFromFile() throws FileNotFoundException {
		ArrayList<Transaction> list = null;
		
		// Create a FileChooser to allow the user to select a file
	    FileChooser fileChooser = new FileChooser();
	    FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("SW Files (*.sw)", "*.sw");
	    fileChooser.getExtensionFilters().add(extensionFilter);
	    
	    // Open a file dialog window and let the user choose a file
	    Stage primaryStage = new Stage(); 
	    File file = fileChooser.showOpenDialog(primaryStage);
	    
	    if (file != null) {
	    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
	    		// Attempt to read and deserialize the ArrayList<Transaction> from the selected file
	            list = (ArrayList<Transaction>) ois.readObject();
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found.");
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }		
		
        return list;
	}
	
	/**
	 * Load data from a specified bank within a specified date range.
	 *
	 * @param bankName The name of the bank to load data from.
	 * @param start The start date of the date range.
	 * @param end The end date of the date range.
	 * @return An ArrayList of Transaction objects within the specified date range, or null if no data is found.
	 */
	public ArrayList<Transaction> loadFromBank(BankList bankName, Date start, Date end) {
		ArrayList<Transaction> list = null;
		
		 // TODO: Implement loading data from the specified bank within the specified date range
		
		return list;
	}


}
