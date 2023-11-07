package backend;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

class TransactionImporterTester {

	@ParameterizedTest
	@MethodSource("generateTransactionTupleList")
	void testTransactionExport(ArrayList<Transaction> transactions, ArrayList<String> exportText) {
		File exportFile = new File("testExport");
		try {
			exportFile.createNewFile();
			TransactionImporter transactionExport = new TransactionImporter(exportFile);
			transactionExport.exportTransactionList(transactions);
			Scanner testScan = new Scanner(exportFile);
			for (int i=0; i<exportText.size(); i++) {
				System.out.println("Testing line " + i);
				boolean passed = exportText.equals(testScan.nextLine());
				if (passed) {
					System.out.println("Result = pass");
				}
				else {
					System.out.println("Result = fail");
				}
				assertTrue(passed);
				
			}
		} catch (IOException exception) {
			fail("could not access test file");
		}
	}
	
	@Parameterized.Parameters
	public static Collection generateTransactionTupleList() {
		ArrayList<Transaction> transactions = generateTransactionList();
		ArrayList<String> exportText = generateTransactionExportStringList();
		return Arrays.asList(new Object[][] {{transactions, exportText}});
	}
	
	@Parameterized.Parameters
	public static ArrayList<Transaction> generateTransactionList() {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(new Transaction(null, new Date(1,-1,-1), 400, true, TransactionCategory.NONE));
		transactions.add(new Transaction("", new Date(-3,20,100), 0, true, TransactionCategory.WANT));
		transactions.add(new Transaction(" ", new Date(1,12,2032), -3, false, TransactionCategory.LUXURY));
		transactions.add(new Transaction("_ ade", new Date(15,7,2012), 400, false, TransactionCategory.NEED));
		transactions.add(new Transaction("a e", new Date(76,4,776), 32, true, TransactionCategory.LUXURY));
		transactions.add(new Transaction("null", new Date(31,2,3), 4, true, TransactionCategory.NONE));
		transactions.add(new Transaction("1 1 1", new Date(1,1,1), -1, false, TransactionCategory.NEED));
		transactions.add(new Transaction(null, new Date(54,32,12), 1, false, TransactionCategory.NONE));
		transactions.add(new Transaction(null, new Date(54,32,12), 0.999999999999999, false, null));
		transactions.add(new Transaction(null, null, 0, false, null));
		transactions.add(null);
		transactions.add(new Transaction("a \n e", new Date(1,1,1), 0, false, TransactionCategory.NONE));
		return transactions;
	}
	
	@Parameterized.Parameters
	public static ArrayList<String> generateTransactionExportStringList() {
		ArrayList<String> transactions = new ArrayList<String>();
		transactions.add("true 400.0 1 -1 -1 NONE null");
		transactions.add("true 0.0 -3 20 100 WANT ");
		transactions.add("false -3.0 1 12 2032 LUXURY");
		transactions.add("false 400.0 15 7 2012 NEED _ ade");
		transactions.add("true 32.0 76 4 776 LUXURY a e");
		transactions.add("true 4.0 31 2 3 NONE null");
		transactions.add("false -1.0 1 1 1 NEED 1 1 1");
		transactions.add("false 1.0 54 32 12 NONE null");
		transactions.add("false 0.999999999999999 54 32 12  ");
		transactions.add("false 0    NONE ");
		transactions.add("");
		transactions.add("false 0 1 1 1 NONE a \n e");
		return transactions;
	}

}