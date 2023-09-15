/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package programming.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rhian
 */
public class registerUsersTest {
    
    public registerUsersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    registerUsers correctUser = new registerUsers("kyl_1", "Ch&&sec@ke99!", "Kyle", "Naidoo");
    registerUsers incorrectUser = new registerUsers("kyle!!!!!!!", "password", "Kyle", "Naidoo");
    
/*-------------------------------------------------------------------------------------*/
   
    @Test
    
    /**
     * Test of checkUserName method, of class registerUsers.
     */
    public void testCheckUserName() {
        System.out.println(" ");           
        boolean expResult1 = true;
        boolean expResult2 = false;
        
        System.out.println("Check Username Success");
        
        boolean successResult = correctUser.checkUserName();
        assertEquals(expResult1, successResult);
        
        System.out.println("Check Username Failure");
        
        boolean failureResult = incorrectUser.checkUserName();
        assertEquals(expResult2, failureResult);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
/*-------------------------------------------------------------------------------------*/

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println(" ");    
        boolean expResult1 = true;
        boolean expResult2 = false;
        
        System.out.println("Check Password Success");
        
        boolean successResult = correctUser.checkPasswordComplexity();
        assertEquals(expResult1, successResult);
        
        System.out.println("Check Password Failure");
        
        boolean failureResult = incorrectUser.checkPasswordComplexity();
        assertEquals(expResult2, failureResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
/*-------------------------------------------------------------------------------------*/
    
    @Test
    public void testRegisterUser() 
    {          
        System.out.println(" ");
        boolean expResult1 = true;
        boolean expResult2 = false;
        
        System.out.println("Check Registration Success");
        
        boolean successResult = correctUser.checkPasswordComplexity();
        assertEquals(expResult1, successResult);
        
        System.out.println("Check Registration Failure");
        
        boolean failureResult = incorrectUser.checkPasswordComplexity();
        assertEquals(expResult2, failureResult);
        // TODO review the generated test code and remove the default call to fail.
    }
    
/*-------------------------------------------------------------------------------------*/
    
}
