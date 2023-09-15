/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package programming.project;

import javax.swing.JFrame;
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
public class TasksTest {
    
    public TasksTest() {
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
    
/*=================================== PART 2 TEST VARIABLES =========================================================================*/
        
    String [][] TestTasks = {
        {"Add Login Feature", "Create Login to authenticate users", "Robyn Harrison", "8", "To Do"},
        {"Create Task Feature", "Create Add Task feature to add task users", "Mike Smith", "10", "Doing"}
    };
    
    String [] TestIDs = {"AD:0:BYN", "CR:1:IKE"};
    
    int[] TestHours = {10,12,55,11,1};

/*===================================================================================================================================*/
    
/*=================================== PART 3 TEST VARIABLES =========================================================================*/
    
    String[] Devs = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"}; //Stores all developers of Test Data
    String[] Names = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};   //Stores all task names of Test Data
    String[] Stats = {"To Do", "Doing", "Done", "To Do"};                                       //Stores all status of Test Data
    String[] Id = {"CR:0:ITH", "CR:1:SON", "CR:2:SON", "AD:3:ZER"};                             //Stores all IDs of Test Data
    int[] Time = {5, 8, 2, 11};                                                                 //Stores all durations of Test Data
    
/*===================================================================================================================================*/

    /**
     * Test of checkTaskDescription method, of class Tasks.
     */
        
    @Test
    public void testCheckTaskDescription() {
        System.out.println("Check Task Description: ");
        System.out.println(" ");
        
        boolean expResult1 = true;
        boolean expResult2 = false;
        
        String correct = "Add new feature";
        String incorrect = "Add new feature with improved efficiency and user-firendly options";
        
        Tasks correctDesc = new Tasks();
        correctDesc.setTaskDesc(correct);
        
        Tasks incorrectDesc = new Tasks();
        incorrectDesc.setTaskDesc(incorrect);
        
        System.out.println("Check Description Success");
        
        boolean successResult = correctDesc.checkTaskDescription();
        assertEquals(expResult1, successResult);
        
        System.out.println(" ");
        System.out.println("Check Description Failure");
        
        boolean failureResult = incorrectDesc.checkTaskDescription();
        assertEquals(expResult2, failureResult);
    }
    
/*------------------------------------------------------------------------------------------------*/

    /**
     * Test of createTaskID method, of class Tasks.
     */
    @Test
    public void testCreateTaskID() {
        System.out.println("Test Task IDs: ");
        System.out.println(" ");
        
        Tasks test = new Tasks();
        
        for(int i=0; i<2; i++)
        {
            System.out.println("Test Task " + Integer.toString(i+1));
            System.out.println(" ");
        
            test.setTaskName(TestTasks[i][0]);
            test.setTaskNumber(i);
            test.setDevDetails(TestTasks[i][2]);
                        
            String expResult = TestIDs[i];
            String result = test.createTaskID();
            assertEquals(expResult, result);
        }       
    }
    
/*------------------------------------------------------------------------------------------------*/

    /**
     * Test of returnTotalHours method, of class Tasks.
     */      
    @Test
    public void testReturnTotalHours() {
        System.out.println("Test Task 1 and Task 2");
        System.out.println(" ");
        
        Tasks test1 = new Tasks();
        
        int expResult1 = 18;
        
        for (int i=0; i<2; i++)
        {
            test1.setTotalTime(Integer.parseInt(TestTasks[i][3]));
        }
        
        int result1 = test1.returnTotalHours();
        assertEquals(expResult1, result1);   
        
        System.out.println("Test Additional Data");
        System.out.println(" "); 
        
        Tasks test2 = new Tasks();
        
        int expResult2 = 89;
        
        for (int i=0; i<5; i++)
        {
            test2.setTotalTime(TestHours[i]);
        }
        
        int result2 = test2.returnTotalHours();
        assertEquals(expResult2, result2);
        
    }
 /*------------------------------------------------------------------------------------------------*/
    
 /*============================= PART 3 TESTS ========================================*/
    
    /**
     * Test of printDurationArrays method, of class Tasks.
     */      
    @Test
    public void testPrintDurationArrays()
    {
        System.out.println("Test Population of Duration Array: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "5, 8, 2, 11";
        
        String result = test.printDurationArrays();
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }

/*------------------------------------------------------------------------------------------------*/
    
    /**
     * Test of printStatusArrays method, of class Tasks.
     */      
    @Test
    public void testPrintStatusArrays()
    {
        System.out.println("Test Population of Status Array: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "To Do, Doing, Done, To Do";
        
        String result = test.printStatusArrays();
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
/*------------------------------------------------------------------------------------------------*/
    
    /**
     * Test of printTaskArrays method, of class Tasks.
     */      
    @Test
    public void testPrintTaskArrays()
    {
        System.out.println("Test Population of Task Name Array: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "Create Login, Create Add Features, Create Reports, Add Arrays";
        
        String result = test.printTaskArrays();
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
/*------------------------------------------------------------------------------------------------*/
    
    /**
     * Test of printIDArrays method, of class Tasks.
     */      
    @Test
    public void testPrintIDArrays()
    {
        System.out.println("Test Population of Status Array: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "CR:0:ITH, CR:1:SON, CR:2:SON, AD:3:ZER";
        
        String result = test.printIDArrays();
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
/*------------------------------------------------------------------------------------------------*/
    
    /**
     * Test of printDevArrays method, of class Tasks.
     */      
    @Test
    public void testPrintDevArrays()
    {
        System.out.println("Test Population of Status Array: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "Mike Smith, Edward Harrison, Samantha Paulson, Glenda Oberholzer";
        
        String result = test.printDevArrays();
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
/*------------------------------------------------------------------------------------------------*/
    
    /**
     * Test of longestTask method, of class Tasks.
     */      
    @Test
    public void testLongestTask()
    {
        System.out.println("Test to Find Longest Task: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "Glenda Oberholzer, 11";
        
        String result = test.longestTask();
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
/*------------------------------------------------------------------------------------------------*/
    
    /**
     * Test of searchTask method, of class Tasks.
     */      
    @Test
    public void testSearchTasks()
    {
        System.out.println("Test to Find Task by Given Name: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "Mike Smith,Create Login";
        
        String testInput = "Create Login";
        
        String result = test.searchTasks(testInput);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
/*------------------------------------------------------------------------------------------------*/
    
    /**
     * Test of searchDev method, of class Tasks.
     */      
    @Test
    public void testSearchDev()
    {
        System.out.println("Test to Find Task by Given Developer: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "Create Reports";
        
        String testInput = "Samantha Paulson";
        
        String result = test.searchDev(testInput);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
/*------------------------------------------------------------------------------------------------*/
    
    /**
     * Test of deleteTasks method, of class Tasks.
     */      
    @Test
    public void testDeleteTasks()
    {
        System.out.println("Test to Delete Task by Given Developer: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "Entry 'Create Reports' successfully deleted";
        
        String testInput = "Create Reports";
        
        String result = test.deleteTasks(testInput);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");        
        
    }
    
/*------------------------------------------------------------------------------------------------*/
    
    /**
     * Test of searchForDevStat method, of class Tasks.
     */      
    @Test
    public void testSearchForDevStat()
    {
        System.out.println("Test to Find Developer and Status by Given Name: ");
        System.out.println(" ");
        
        Tasks test = new Tasks(Devs, Names, Id, Stats, Time);
        
        String expResult = "Mike Smith,To Do";
        
        String testInput = "Create Login";
        
        String result = test.searchForDevStat(testInput);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
/*------------------------------------------------------------------------------------------------*/
    
}
