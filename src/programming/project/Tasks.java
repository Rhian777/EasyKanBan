/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming.project;

import java.util.Scanner;
import javax.swing.*; 

/**
 *
 * @author rhian
 */

/*
    The Tasks class is used to store all information on all tasks entered, and
    all information on the current task. This class is used for Part 2
    and for Part 3
*/

public class Tasks {
    
/*=============================== PART 2 VARIABLES ===================================*/
    
    String TaskName;            //Stores current task's name
    int TaskNumber;             //Stores current task's number
    String TaskDesc;            //Stores current task's description
    String DevDetails;          //Stores current task's developer
    int TaskTime;               //Stores current task's duration
    String TaskId;              //Stores current task's ID
    String TaskStatus;          //Stores current task's status
    int TotalTime = 0;          //Global running total used to calculate toal duration across variables
    
/*====================================================================================*/
    
/*=============================== PART 3 VARIABLES ===================================*/
    
    String[] Developers;        //Array used to store all task developers
    String[] AllTasks;          //Array used to store all task names
    String[] AllIds;            //Array used to store all task IDs
    int[] AllDurations;         //Array used to store all task durations
    String[] AllStatus;         //Array used to store all task statuses
    
/*-------------------------------------------------------------------------------------*/   
    
    /*
        Default constructor used in Part 2 to initialize all instance variables
    */
    
    Tasks()
    {
        TaskName = "";
        TaskNumber = 0;
        TaskDesc = "";
        DevDetails = "";
        TaskTime = 0;
        TaskId = "";
        TaskStatus = "";
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        Constructor used in Part 2 Test to initialize all instance variables to the given values
    */
    
    Tasks(String name, int num, String desc, String details, int time, String status)
    {
        TaskName = name;
        TaskNumber = num;
        TaskDesc = desc;
        DevDetails = details;
        TaskTime = time;
        TaskId = "";
        TaskStatus = status;
    }
    
/*============================= PART 3 CONSTRUCTOR ==================================*/
    
    /*
        Constructor used in Part 3 Test to initialize all instance arrays
    */
    
    Tasks(String[] devs, String[] tasks, String[] IDs, String[] stats, int[] times)
    {
        initializeArrays(tasks.length);
        
        for(int i = 0; i < tasks.length; i++)
        {
            Developers[i] = devs[i];
            AllTasks[i] = tasks[i];
            AllIds[i] = IDs[i];
            AllStatus[i] = stats[i];
            AllDurations[i] = times[i];
        }
        
        TaskName = "";
        TaskNumber = 0;
        TaskDesc = "";
        DevDetails = "";
        TaskTime = 0;
        TaskId = "";
        TaskStatus = "";
    }
    
/*=================================================================================*/
    
    /*
        TaskName setter
    */
    
    public void setTaskName(String name){
        TaskName = name;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        TaskNumber setter
    */
    
    public void setTaskNumber(int num)
    {
        TaskNumber = num;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        TaskDescription setter
    */
    
    public void setTaskDesc(String desc)
    {
        TaskDesc = desc;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        TaskDeveloper setter
    */
    
    public void setDevDetails(String details)
    {
        DevDetails = details;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        TaskDuration setter
    */
    
    public void setTaskTime(int time)
    {
        TaskTime = time;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        TaskID setter
    */
    
    public void setTaskID(String id)
    {
        TaskId = id;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        Calculates running total for duration across tasks
    */
    
    public void setTotalTime(int hours)
    {
        TotalTime = TotalTime + hours;
    }    
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        TaskStatus setter
    */
    
    public void setTaskStatus(String status)
    {
        TaskStatus = status;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        This is the "start" method used to start part 2 and 3 code, prompting user with their options for part 2 and 3 
        by using a JOption pane to represent their options. 
    
        This method will call the addTasks() method for part 2 and the showReport() for part 3
    */
    
    public void taskOptions()
    {
        JFrame f;
        boolean flag = true;
        
        f = new JFrame(); 
        
        f.setVisible(true);
        f.setState(JFrame.NORMAL);
        
        while(flag)
        {
            String userInput = JOptionPane.showInputDialog(f,"Welcome to EasyKanban \n You have the following options to choose from: \n 1) Add Task \n 2) Show Report \n 3) Quit"); 

            if(userInput.equals("1"))
            {
                System.out.println("Please enter the number of tasks you would like to enter: ");
                Scanner sc = new Scanner(System.in);
                String t = sc.nextLine();
                int tasks = Integer.parseInt(t);
                addTasks(tasks, f);
            }
            else if (userInput.equals("2"))
            {
                
            /*============================= PART 3 CODE ==================================*/
                
                showReport(f);
                
            /*============================================================================*/
                
            }
            else if (userInput.equals("3"))
            {
                flag = false;
                System.exit(0);
            }
        }
    }

/*-------------------------------------------------------------------------------------*/
    
    /*
        the addTasks() method is used for part 2 and 3. This method prompts the use to
        enter all task related information, then saves the input and does the necessary processing
        and data validation/error checking.
    
        For part 2, the inputs are assigned to the instance variables and used to display feedback.
    
        For part 3, all part 2 processing is completed and user's input is added to their 
        appropriate arrays
    */
    
    public void addTasks(int tasks, JFrame f)
    {          
     
    /*============================= PART 3 CODE ==================================*/
        
        initializeArrays(tasks);
        
    /*============================================================================*/
        
        Scanner sc = new Scanner(System.in);
        
        String name;
        String desc;
        String details;
        int time;
        String id;
        boolean descChecked;
        
        for(int i = 0; i<tasks; i++)        
        {
            descChecked = false;
            desc = "";
            details = "";
            time = 0;
            id = "";
                        
            System.out.println("Enter the task name: ");
            name = sc.nextLine();
            setTaskName(name);
            
        /*============================= PART 3 CODE ==================================*/
        
            AllTasks[i] = name;     
            
        /*============================================================================*/
            
            setTaskNumber(i);
            
            while (descChecked == false)
            {
                System.out.println("Enter the task description: ");
                desc = sc.nextLine();

                setTaskDesc(desc);
                descChecked = checkTaskDescription();

                if (!descChecked)
                {
                    System.out.println("Please enter a task description of less than 50 characters");
                }
                else
                {
                    System.out.println("Task successfully captured");
                }
            }
            
            System.out.println("Enter the first name of the developer: ");
            String first = sc.nextLine();
            
            System.out.println("Enter the last name of the developer: ");
            String last = sc.nextLine();
            
            details = first + " " + last;
            setDevDetails(details);
            
            /*============================= PART 3 CODE ==================================*/
            
            Developers[i] = details;
            
            /*============================================================================*/
            
            System.out.println("Enter the task duration: ");
            time =  Integer.parseInt(sc.nextLine());
            
            setTaskTime(time);
            
            /*============================= PART 3 CODE ==================================*/
            
            AllDurations[i] = time;        
            
            /*============================================================================*/
            
            setTotalTime(time);
            
            id = createTaskID();
            setTaskID(id);
            
            /*============================= PART 3 CODE ==================================*/
            
            AllIds[i] = id;         
            
            /*============================================================================*/
            
            String userInput = JOptionPane.showInputDialog(f,"Enter the task status: \n 1) To Do \n 2) Done \n 3) Doing"); 
            
            if (userInput.equals("1"))
            {
                setTaskStatus("To Do");
                
                /*============================= PART 3 CODE ==================================*/
                
                AllStatus[i] = "To Do";         
                
                /*============================================================================*/
            }
            else if (userInput.equals("2"))
            {
                setTaskStatus("Done");
                
                /*============================= PART 3 CODE ==================================*/
                
                AllStatus[i] = "Done";         
                
                /*============================================================================*/
            }
            else if (userInput.equals("3"))
            {
                setTaskStatus("Doing");
                
                /*============================= PART 3 CODE ==================================*/
                
                AllStatus[i] = "Doing";         
                
                /*============================================================================*/
            }
            
            String fullTask = printTaskDetails();
            
            JOptionPane.showMessageDialog(f,fullTask,"Task Captured",JOptionPane.INFORMATION_MESSAGE); 
            
        }
        
        int tasksTime = returnTotalHours();
        
        JOptionPane.showMessageDialog(f,"Total Task Duration: " + Integer.toString(tasksTime),"Total Task Duration",JOptionPane.INFORMATION_MESSAGE); 
        
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        This method does error checking/data validation on the task description
        given by the user.
    
        Checks whether description is 50 characters or less
    */
    
    public boolean checkTaskDescription()
    {
        if (TaskDesc.length() > 50)
        {
            return false;
        }
        
        return true;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        This method does error checking/data validation on the task ID
        given by the user.
    
        Uses first 2 letters of task name, last 3 letters of developer 
        and the task nuber to create the ID
    */
    
    public String createTaskID()
    {
        String name = TaskName.substring(0, 2);
        //int length = devDetails.length();
        int begin = DevDetails.indexOf(" ");
        String dev = DevDetails.substring(begin-3, begin);
        String num = Integer.toString(TaskNumber);
        
        String id = name.toUpperCase() + ":" + num + ":" + dev.toUpperCase();
        
        return id;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        Prints our the current task's details which is then used in a JOption pane
    */
    
    public String printTaskDetails()
    {
        String output = "Task Details:" + "\n " + "\n Task Status: " + TaskStatus + "\n Developer Details: " + DevDetails + "\n Task Number: " + Integer.toString(TaskNumber) + "\n Task Name: " + TaskName + "\n Task Description: " + TaskDesc + "\n Task ID: " + TaskId + "\n Duration: " + Integer.toString(TaskTime);
        
        return output;
    }
    
/*-------------------------------------------------------------------------------------*/
    
    /*
        TotalTime getter
    */
    
    public int returnTotalHours()
    {
        return TotalTime;
    }
    
/*======================================= START OF PART 3 FUNCTIONS ===========================================================*/
    
    /*
        Initializes all the instance arrays to the necessary size, given by the user in part 2
    */
    
    public void initializeArrays(int size)
    {
        AllTasks = new String[size];
        Developers = new String[size];
        AllIds = new String[size];
        AllDurations = new int[size];
        AllStatus = new String[size];
        
        for(int i = 0; i < size; i++)
        {
            AllTasks[i] = "";
            Developers[i] = "";
            AllIds[i] = "";
            AllDurations[i] = 0;
            AllStatus[i] = "";
        }
    }
    
/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        The showReport() method serves as the "start" method for part 3.
    
        It presents the user with the report options, using a JOption pane.
    
        The metyod will call the necessary methods based on the user's input
    */
    
    public void showReport(JFrame f)
    {
        String userInput = JOptionPane.showInputDialog(f,"Choose one of the following (Enter only the number): \n 1) Tasks with 'Done' status \n 2) Longest Duration Task \n 3) Search for Developer and Task Name by a Task Name \n 4) Search by Developer \n 5) Delete Task by Name \n 6) Display Full Report \n 7) Search for Developer and Status by a Task Name \n 8) Back"); 
        
        if (userInput.equals("1"))
        {
            doneTasks(f);
        }
        else if (userInput.equals("2"))
        {
            if(this.AllTasks == null)
            {
                JOptionPane.showMessageDialog(f,"Sorry, you haven't added any tasks yet","No Tasks Added",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String longest = longestTask();
            
            int i = longest.indexOf(",");

            String dev = longest.substring(0, i);
            String dur = longest.substring(i+2, longest.length());
            
            JOptionPane.showMessageDialog(f,"Developer: " + dev + "\nDuration: " + dur,"Task with Longest Duration",JOptionPane.INFORMATION_MESSAGE);           
            
        }
        else if (userInput.equals("3"))
        {
            if(this.AllTasks == null)
            {
                JOptionPane.showMessageDialog(f,"Sorry, you haven't added any tasks yet","No Tasks Added",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                String name = JOptionPane.showInputDialog(f,"Enter the name of the task you would like to search for: "); 

                String found = searchTasks(name);
                int i = found.indexOf(",");

                String dev = found.substring(0, i);
                String foundName = found.substring(i+1, found.length());

                if(found.charAt(found.length()-1) == '!')
                {
                    JOptionPane.showMessageDialog(f,found,"Details of Task: " + name,JOptionPane.ERROR_MESSAGE);  
                }
                else
                {      
                    JOptionPane.showMessageDialog(f,"Developer: " + dev + "\nTask Name: " + foundName,"Details of Task: " + name,JOptionPane.INFORMATION_MESSAGE); 
                }
            }
        }
        else if (userInput.equals("4"))
        {
            if(this.AllTasks == null)
            {
                JOptionPane.showMessageDialog(f,"Sorry, you haven't added any tasks yet","No Tasks Added",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                String dev = JOptionPane.showInputDialog(f,"Enter the name of the developer you would like to search for: "); 

                String results = searchDev(dev);

                if(results.charAt(results.length()-1) == '!')
                {
                    JOptionPane.showMessageDialog(f,results,"Details of Developer: " + dev,JOptionPane.ERROR_MESSAGE); 
                }
                else
                {
                    JOptionPane.showMessageDialog(f,results,"Details of Developer: " + dev,JOptionPane.INFORMATION_MESSAGE); 
                }
            }
        }
        else if (userInput.equals("5"))
        {
            if(this.AllTasks == null)
            {
                JOptionPane.showMessageDialog(f,"Sorry, you haven't added any tasks yet","No Tasks Added",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                String del = JOptionPane.showInputDialog(f,"Enter the name of the task you would like to delete: "); 

                String deleted = deleteTasks(del);

                if(deleted.charAt(deleted.length()-1) == '!')
                {
                    JOptionPane.showMessageDialog(f,deleted,"Deletion of Task: " + del,JOptionPane.ERROR_MESSAGE); 
                }
                else
                {
                    JOptionPane.showMessageDialog(f,deleted,"Deletion of Task: " + del,JOptionPane.INFORMATION_MESSAGE); 
                }
            }                      
        }
        else if (userInput.equals("6"))
        {
            fullReport(f);
        }
        else if (userInput.equals("7"))
        {
            if(this.AllTasks == null)
            {
                JOptionPane.showMessageDialog(f,"Sorry, you haven't added any tasks yet","No Tasks Added",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                String name = JOptionPane.showInputDialog(f,"Enter the name of the task you would like to search for: "); 

                String found = searchForDevStat(name);

                if(found.charAt(found.length()-1) == '!')
                {
                    JOptionPane.showMessageDialog(f,found,"Details of Task: " + name,JOptionPane.ERROR_MESSAGE);  
                }
                else
                {                               
                    int i = found.indexOf(",");

                    String dev = found.substring(0, i);
                    String stat = found.substring(i+1, found.length());

                    JOptionPane.showMessageDialog(f,"Developer: " + dev + "\nTask Name: " + name + "\nTask Status: " + stat,"Details of Task: " + name,JOptionPane.INFORMATION_MESSAGE); 
                }
            }
        }
        else if (userInput.equals("8"))
        {
            return;
        }
    }
    
/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        Searches through the Durations array for the task with the largest duration
    
        This method uses the associated index to return the task's developer and duration
    */
    
    public String longestTask()
    {      
        int index = 0;
        int longest = 0;
        
        String output = "";
                    
        for(int i = 0; i < AllTasks.length; i++)
        {
            if(longest<AllDurations[i])
            {
                longest = AllDurations[i];
                index = i;
            }
        }        
       
        output = output + Developers[index] + ", " + Integer.toString(AllDurations[index]);
        
        return output;
    }
    
/*---------------------------------------------------------------------------------------------------*/
    
    /*
        Searches through the Tasks array for the task with the given name
    
        This method uses the associated index to return the task's developer and name; however
        if no such name is found, the method returns an error message
    
    */
    
    public String searchTasks(String name)
    {
        name = name.toLowerCase();
        
        String output = "";
        
        int index = -1;

        for(int i = 0; i < AllTasks.length; i++)
        {
            String temp = AllTasks[i].toLowerCase();

            if(temp.equals(name))
            {
                index = i;
            }
        }      

        if(index == -1)
        {
            output = "Sorry, no such task exists!";            
        }
        else
        {
            output = Developers[index] + "," + AllTasks[index];
        }
                
        return output;
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        Searches through the Tasks array for the task with the given name
    
        This method uses the associated index to return the task's developer and status; however
        if no such name is found, the method returns an error message
    */
    
    public String searchForDevStat(String name)
    {
        name = name.toLowerCase();
        
        String output = "";
        
        int index = -1;

        for(int i = 0; i < AllTasks.length; i++)
        {
            String temp = AllTasks[i].toLowerCase();

            if(temp.equals(name))
            {
                index = i;
            }
        }      

        if(index == -1)
        {
            output = "Sorry, no such task exists!";            
        }
        else
        {
            output = Developers[index] + "," + AllStatus[index];
        }
                
        return output;
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        Searches through the Status array for the task with the "Done" status
    
        This method uses the associated index to print the task's developer, status and task name; however
        if no such name is found, the method prints an error message
    */
    
    public void doneTasks(JFrame f)
    {     
        if(this.AllTasks == null)
        {
            JOptionPane.showMessageDialog(f,"Sorry, you haven't added any tasks yet","No Tasks Added",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int counter = 0;        
        
        String output = "";
        
        for(int j = 0; j < AllStatus.length; j++)
        {
            if(AllStatus[j].equals("Done"))
            {
                output = output + Integer.toString(j+1) + ") Task Name: " + AllTasks[j];
                output = output + "\n Developer: " + Developers[j];
                output = output + "\n Duration: " + AllDurations[j];
                output = output + "\n";
                
                counter++;
            }
        }                  
        
        if(counter == 0)
        {
            JOptionPane.showMessageDialog(f,"Sorry, there are no tasks with the 'Done' status","Details of 'Done' Tasks",JOptionPane.ERROR_MESSAGE); 
            return;
        }
        
        JOptionPane.showMessageDialog(f,output,"Details of 'Done' Tasks",JOptionPane.INFORMATION_MESSAGE); 
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        Searches through the Tasks array for the task with the given name
    
        This method uses the associated index to remove the given task from 
        all arrays; however if no such name is found, the method prints 
        an error message.
    
        After the found task is removes, all proceding tasks are moved 1 
        up in all arrays.     
    */
    
    public String deleteTasks(String name)
    {
        String holder = name;
        
        name = name.toLowerCase();
        
        String output = "";
        
        int index = -1;

        for(int i = 0; i < AllTasks.length; i++)
        {
            String temp = AllTasks[i].toLowerCase();

            if(temp.equals(name))
            {
                index = i;

                Developers[i] = "";
                AllTasks[i] = "";
                AllIds[i] = "";
                AllDurations[i] = 0;
                AllStatus[i] = "";

            }
        }                  

        if(index == -1)
        {
            output = "Sorry, no such task exists. Cannot be deleted!";       
        }
        else
        {
            for(int k = index; k < AllTasks.length - 1; k++)
            {
                Developers[k] = Developers[k+1];
                AllTasks[k] = AllTasks[k+1];
                AllIds[k] = AllIds[k+1];
                AllDurations[k] = AllDurations[k+1];
                AllStatus[k] = AllStatus[k+1];
            }  

            output = "Entry '" + holder + "' successfully deleted"; 
        }
        
        return output;
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        Searches through the Developers array for the developer with the given name
    
        This method uses the associated index to return the all tasks associated with
        the given developer; however if no such name is found, the method prints an error message
    */
    
    public String searchDev(String name)
    {
        String output = "";
        
        name = name.toLowerCase();

        int index = -1;


        for(int i = 0; i < Developers.length; i++)
        {
            String temp = Developers[i].toLowerCase();

            if(temp.equals(name))
            {
                index = i;
                output = output + AllTasks[i] + ",";
            }
        }

        if(index == -1)
        {
            output = "Sorry, no such developer exists!"; 
        }
        else
        {
            output = output.substring(0, output.length()-1);
        }
        
        return output;
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        This method iterates through all arrays to print out al the saved
        tasks and its associated details
    */
    
    public void fullReport(JFrame f)
    {
        //String output = "";
        
        if(this.AllTasks == null)
        {
            JOptionPane.showMessageDialog(f,"Sorry, you haven't added any tasks yet!","No Tasks Added",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String output = "All Tasks:";
        
        output = output + "\n ";
        
        for(int i = 0; i < AllTasks.length; i++)
        {
            if(AllTasks[i].equals(""))
            {
                break;
            }
            
            output = output + "\n" + Integer.toString(i+1) + ") Task Name: " + AllTasks[i];
            output = output + "\n Task Developer: " + Developers[i];
            output = output + "\n Task Duration: " + Integer.toString(AllDurations[i]);
            output = output + "\n Task Status: " + AllStatus[i];
            output = output + "\n Task ID: " + AllIds[i] + "\n";                       
        }
        
        JOptionPane.showMessageDialog(f,output,"Full Task Report",JOptionPane.INFORMATION_MESSAGE); 
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    /*
        This method prints all the info in the Developers array.
        
        This method is used to check whether the Developers array
        is correctly populated.
    */

    public String printDevArrays()
    {
        String output = "";
        
        for(int i = 0; i < Developers.length; i++)
        {
            if(i == Developers.length-1)
            {
                output = output + Developers[i];
            }
            else
            {
                output = output + Developers[i] + ", ";
            }
        }
        
        return output; 
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        This method prints all the info in the IDs array.
        
        This method is used to check whether the IDs array
        is correctly populated.
    */
    
    public String printIDArrays()
    {
        String output = "";
        
        for(int i = 0; i < AllIds.length; i++)
        {
            if(i == AllIds.length-1)
            {
                output = output + AllIds[i];
            }
            else
            {
                output = output + AllIds[i] + ", ";
            }
        }
        
        return output;
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        This method prints all the info in the TaskNames array.
        
        This method is used to check whether the TaskNames array
        is correctly populated.
    */
    
    public String printTaskArrays()
    {
        String output = "";
        
        for(int i = 0; i < AllTasks.length; i++)
        {
            if(i == AllTasks.length-1)
            {
                output = output + AllTasks[i];
            }
            else
            {
                output = output + AllTasks[i] + ", ";
            }
        }
        
        return output;
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        This method prints all the info in the Status array.
        
        This method is used to check whether the Status array
        is correctly populated.
    */
    
    public String printStatusArrays()
    {
        String output = "";
        
        for(int i = 0; i < AllStatus.length; i++)
        {
            if(i == AllStatus.length-1)
            {
                output = output + AllStatus[i];
            }
            else
            {
                output = output + AllStatus[i] + ", ";
            }
        }
        
        return output;
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    /*
        This method prints all the info in the Durations array.
        
        This method is used to check whether the Durations array
        is correctly populated.
    */
    
    public String printDurationArrays()
    {
        String output = "";
        
        for(int i = 0; i < AllDurations.length; i++)
        {
            if(i == AllDurations.length-1)
            {
                output = output + Integer.toString(AllDurations[i]);
            }
            else
            {
                output = output + Integer.toString(AllDurations[i]) + ", ";
            }
        }
        
        return output;
    }
    
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
/*======================================= END OF PART 3 FUNCTIONS ===========================================================*/
    
}
