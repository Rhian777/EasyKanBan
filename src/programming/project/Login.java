package programming.project;

import java.util.Scanner;

/**
 *
 * @author rhian
 */

public class Login 
{
    String userName;
    String password;
    String loginUser;
    String loginPass;
    String firstName;
    String lastName;
    
/*-------------------------------------------------------------------------------------------------*/
    
    Login(registerUsers u)
    {
        userName = u.getUsername();
        password = u.getPassword();
        loginUser = "";
        loginPass = "";        
        firstName = u.getFirst();
        lastName = u.getLast();
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
    Login(registerUsers u, String loginU, String loginP)
    {
        userName = u.getUsername();
        password = u.getPassword();
        loginUser = loginU;
        loginPass = loginP;        
        firstName = u.getFirst();
        lastName = u.getLast();
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
    Login(String user, String pass, String logUser, String logPass, String fName, String lName)
    {
        userName = user;
        password = pass;
        loginUser = logUser;
        loginPass = logPass;
        firstName = fName;
        lastName = lName;
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
    public String getLoginUser()
    {
        return loginUser;
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
    public String getLoginPass()
    {
        return loginPass;
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
    public void setLoginUser(String user)
    {
        loginUser = user;
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
    public void setLoginPass(String pass)
    {
        loginPass = pass;
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
    public boolean loginUser()
    {
        String user = getLoginUser();
        String pass = getLoginPass();
        
        if (user.equals(userName) && pass.equals(password))
        {
            return true;
        }
        
        return false;        
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
    public String returnLoginStatus()
    {
        if(loginUser())
        {
            return ("Welcome " + firstName + " " + lastName + " it is great to see you again.");
            
        }
        else
        {
            return ("Username or password incorrect please try again");
        }
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
    public void beginLogin()
    {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        
        while(!flag)
        {
            System.out.println(" ");
            System.out.println("Login: ");
            
            System.out.println("Enter your username: ");
            String user1 = input.nextLine();
            setLoginUser(user1);
            
            System.out.println("Enter your password");
            String pass1 = input.nextLine();
            setLoginPass(pass1);
            
            flag = loginUser();
            System.out.println(returnLoginStatus());
            
            if(flag)
            {
                break;
            }
        }
        
    }
    
/*-------------------------------------------------------------------------------------------------*/
    
}
            
    
    






