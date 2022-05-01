package app;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankUserTest {

	BankUser user = new BankUser();
	
	@Test
    public void firstTest() {
    	
    	//checks for empty or null references.
       assertNotNull( user);
              
    }
    
    @Test
    public void firstnameTest() {
    	BankUser.firstname = " ";
    	
    	assertTrue(BankUser.firstname != null);
    	
    }
    
    @Test
    public void passwordTest() {
    	BankUser.password= "" ;
    	
    	assertTrue(BankUser.password != null);
    }
    
    @BeforeEach
    public void beforeEach() {
    	
    	
    }
    
    @AfterEach
    public void afterEach() {
    	
    }
    
    @AfterAll
    public static  void afterAll() {
    	
    }
    
    @BeforeAll
    public static void beforeAll() {
    	
    }
}


