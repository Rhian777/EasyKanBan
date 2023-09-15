package programming.project;

import java.util.Scanner;

/**
 *
 * @author rhian
 */
public class registerUsers 
{
    String userName;
    String password;
    String firstName;
    String lastName;
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    registerUsers(String user, String pass, String fname, String lname)
    {
        userName = user;
        password = pass;
        firstName = fname;
        lastName = lname;
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    registerUsers()
    {
        userName = "";
        password = "";
        firstName = "";
        lastName = "";
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public String getUsername()
    {
        return userName;
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public String getPassword()
    {
        return password;
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public void setUsername(String user)
    {
        userName = user;
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public void setPassword(String pass)
    {
        password = pass;
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public String getFirst()
    {
        return firstName;
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public void setFirst(String fName)
    {
        firstName = fName;
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public String getLast()
    {
        return lastName;
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public void setLast(String lName)
    {
        lastName = lName;
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public boolean checkUserName() 
    {
        String username = getUsername();
        
        if(username.length() <= 5 && username.contains("_")) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
        
    }
 
/* -----------------------------------------------------------------------------------------------------------------------------------*/

    public boolean checkPasswordComplexity() 
    {
        String pass = getPassword();
        
        if (pass.length() >= 8 && pass.matches(".*[A-Z].*") && pass.matches(".*[0-9].*") && pass.matches(".*[!@#$%^&*()_+].*")) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }   
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/

    public boolean registerUser() 
    {
        boolean validUsername = checkUserName();
        boolean validPassword = checkPasswordComplexity();
        
        if (validUsername == false) 
        {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is less than or equal to 5 characters in length.");
        }
        
        if (validPassword == false) 
        {
            System.out.println("Password is not correctly formatted, please ensure that your password is at least 8 characters long, contains a capital letter, a number, and a special character.");
        }
        
        if (validUsername && validPassword)
        {
            System.out.println("User Registered");
            return true;
        }
        
        return false;
        
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
    public void beginRegistration()
    {
        String pass = "";
        String username = "";
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your first name: ");
              
        String firstName = sc.nextLine();
        
        
        setFirst(firstName);

        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();        
        setLast(lastName);

        while (true)
        {
            System.out.println("Enter username: ");

            username = sc.nextLine();
            setUsername(username);
            
            //boolean validUsername = x.checkUserName(username);

            System.out.println("Enter password: ");
            pass = sc.nextLine();
            setPassword(pass);
            
            //boolean validPassword = x.checkPasswordComplexity(pass);

            boolean allValid = registerUser();
            if (allValid){
                break;
            }
        }
        
    }
    
/* -----------------------------------------------------------------------------------------------------------------------------------*/
    
}
