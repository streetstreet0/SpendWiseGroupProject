package backend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

class TransactionTest {

	@ParameterizedTest
	@MethodSource("generateTransactions")
	void testSetCategory(Transaction transaction, TransactionVisual visual, TransactionCategory category) {
		
		transaction.setCategory(category);
		assertEquals(category,transaction.getCategory());
		if (visual != null) {
			assertTrue(category.toString().equals(visual.getCategory().getValue()));
		}
	}
	
	@Parameterized.Parameters
	public static Collection generateTransactions() {
		Date date = new Date(1,1,1);
		TransactionCategory a=  TransactionCategory.NEED;
		TransactionCategory b=  TransactionCategory.NONE;
		TransactionCategory c=  TransactionCategory.LUXURY;
		TransactionCategory d=  TransactionCategory.WANT;
		Transaction t1= new Transaction(null, date, 0, true, a);
		Transaction t2= new Transaction(null, date, 0, true, b);
		Transaction t3= new Transaction(null, date, 0, true, c);
		Transaction t4= new Transaction(null, date, 0, true, d);
		return Arrays.asList(new Object[][] {
			{
				t1, null, d},{
				t1, t1.generateTransactionVisual(), d},{
				t2,null,c},{
				t2,t2.generateTransactionVisual(),c},{
				t3,null,b},{
				t3,t3.generateTransactionVisual(),b},{
				t4,null,a},{
				t4,t4.generateTransactionVisual(),a
			}
		});
	}
	

}
