import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import backend.Date;
import backend.Transaction;
import backend.TransactionCategory;
import backend.TransactionImporter;

class TransactionImporterTest {



	@Test
	void getTransactionsTest() throws FileNotFoundException {
		
			ArrayList<Transaction> transactionsForTest = new ArrayList<>();
			var test1 = new Transaction("Food", new Date(1, 11, 2023), 399.99, true, TransactionCategory.NONE );
			var test2 = new Transaction("test1_right", new Date(15, 7, 2020), 139, true, TransactionCategory.NEED );
			var test3 = new Transaction("test2_wrongDate", new Date(35, 15, -1980), 200, false, TransactionCategory.LUXURY );
			transactionsForTest.add(test1);
			transactionsForTest.add(test2);
			transactionsForTest.add(test3);
			

		//int count = 3;
		//Transaction t = new Transaction();
		TransactionImporter importer = new TransactionImporter(new File("transactions"));
		ArrayList<Transaction> tran = new ArrayList<>();
		System.out.println("dddddd");
		tran = importer.getTransactions();
		System.out.println("dddddd");
		
	
		System.out.println(transactionsForTest.get(0).getDate().equals(tran.get(0).getDate()));
		System.out.println(transactionsForTest.get(0).getDate());
		System.out.println(tran.get(0).getDate());
		assertTrue(transactionsForTest.toString().equals(tran.toString()));
		
	}


}
