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
public class LoginTest {
    
    public LoginTest() {
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
    
    Login correctLogin = new Login("kyl_1", "Ch&&sec@ke99!", "kyl_1", "Ch&&sec@ke99!", "Kyle", "Naidoo");
    Login incorrectLogin = new Login("kyl_1", "Ch&&sec@ke99!", "kyle", "Ch&&sec@", "Kyle", "Naidoo");

/*-------------------------------------------------------------------------------------*/
    
    @Test
    /**
     * Test of loginUsermethod, of class Login.
     */
    public void testLoginUser() {
        System.out.println(" ");
        boolean expResult1 = true;
        boolean expResult2 = false;
        
        System.out.println("Check Login Success");
        
        boolean successResult = correctLogin.loginUser();
        assertEquals(expResult1, successResult);
        
        System.out.println("Check Login Failure");
        
        boolean failureResult = incorrectLogin.loginUser();
        assertEquals(expResult2, failureResult);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
/*-------------------------------------------------------------------------------------*/

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() 
    {
        System.out.println(" ");
        System.out.println(" ");
        String expResult1 = "Welcome Kyle Naidoo it is great to see you again.";
        String expResult2 = "Username or password incorrect please try again";
        
        System.out.println("Check Return Status Success");
        
        String successResult = correctLogin.returnLoginStatus();
        assertEquals(expResult1, successResult);
        
        System.out.println("Check Return Status Failure");
        
        String failureResult = incorrectLogin.returnLoginStatus();
        assertEquals(expResult2, failureResult);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
/*-------------------------------------------------------------------------------------*/
    
}
