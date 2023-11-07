package backend;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.Test;

class UserDataImporterTest {

	
	@Test
    public void testValidUser() throws IOException {
        // Create a temporary file for testing
        File tempFile = File.createTempFile("LoginTestFile", ".txt");
        
        // Write correct username & password to temp file
        try (PrintWriter out = new PrintWriter(tempFile)) {
            out.println("Sam123");
            out.println("password123");
        }

        UserDataImporter importer = new UserDataImporter(tempFile);
        
        // Test with the correct username and password
        assertTrue("Expected valid user to return true", importer.validUser("Sam123", "password123"));

        // Test with the correct username but wrong password
        assertFalse("Expected wrong password to return false", importer.validUser("Sam123", "wrongpassword"));

        // Test with the wrong username
        assertFalse("Expected wrong username to return false", importer.validUser("WrongUsername", "password123"));

        // Delete the temporary file
        tempFile.delete();
    }
}
