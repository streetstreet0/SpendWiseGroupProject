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
 * UserDataImporter exists just to check if a user can successfully log in or not.
 */
public class UserDataImporter {
	private File transactionFile; // this is the file that the transactions are stored in
	
	public UserDataImporter(File transactionFile) {
		this.transactionFile = transactionFile;
	}

	/**
	 * Imports the transactions as an array list of transactions
	 * 
	 * @throws FileNotFoundException
	 * @return ArrayList of all of the transactions from the transactionFile
	 */
	public boolean validUser(String username, String password) throws FileNotFoundException {
		Scanner scanner = new Scanner(transactionFile);
		
		while (scanner.hasNext()) {
			// users files have the usernames on the odd lines, and just below them their relevant password
			// names and passwords are never saved as variables for security purposes
			if (username.equals(scanner.nextLine())) {
				if (password.equals(scanner.nextLine())) {
					scanner.close();
					return true;
				}
				else {
					scanner.close();
					return false;
				}
			}
			else {
				scanner.nextLine();
			}
		}
		// if no user was found
		scanner.close();
		return false;
	}
}
