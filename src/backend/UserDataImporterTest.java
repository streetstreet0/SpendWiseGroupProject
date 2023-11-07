package backend;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

class UserDataImporterTest {

	
	@ParameterizedTest
	@MethodSource("generateUserList")
    public void testValidUser(String username, String password, boolean result) throws IOException {
        // Create a temporary file for testing
        File tempFile = File.createTempFile("LoginTestFile", ".txt");
        
        // Write correct username & password to temp file
        try (PrintWriter out = new PrintWriter(tempFile)) {
            out.println("Sam123");
            out.println("password123");
        }

        UserDataImporter importer = new UserDataImporter(tempFile);
        assertEquals(result, importer.validUser(username, password));
        // Test with the correct username and password
//        assertTrue("Expected valid user to return true", importer.validUser("Sam123", "password123"));
//
//        // Test with the correct username but wrong password
//        assertFalse("Expected wrong password to return false", importer.validUser("Sam123", "wrongpassword"));
//
//        // Test with the wrong username
//        assertFalse("Expected wrong username to return false", importer.validUser("WrongUsername", "password123"));

        // Delete the temporary file
        tempFile.delete();
    }
	
	@Parameterized.Parameters
	public static Collection generateUserList() {
		return Arrays.asList(new Object[][] {
			{"Sam123", "password123", true},
			{" ", " ", false},
			{"WrongUsername", "password123", false},
			{"Sam123", "WrongPassword", false},
			{"null", "null", false},
//			{null, "asdaw", false},
			{"sdfsd", null, false},
//			{null, null, false}
			});
	}
}
