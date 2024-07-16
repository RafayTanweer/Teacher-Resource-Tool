
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdur-Rafay
 */
public class Login {
    
    public String Username;
    public String Password;
    
    public Login(){
        
        this.Username = "";
        this.Password = "";
        
    }
    
    public boolean Verify() throws FileNotFoundException{
        
        String line;
        String tempUsername, tempPassword;
        int index;
        boolean check = false;
        Scanner inFile = new Scanner(new FileReader("Accounts.txt"));
        
        while(inFile.hasNextLine()){
            
            line = inFile.nextLine();
            line = line.trim();
            index = line.indexOf(',');
            
            tempUsername = line.substring(0, index);
            tempPassword = line.substring(index + 1);
            
            if(tempUsername.equals(this.Username) && tempPassword.equals(this.Password)){
                check = true;
                break;
            }
            
        }
        
        inFile.close();
        
        return check;
        
        
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        
        //Login Acc = new Login();
        //Acc.Username = "RafayTanweer";
        //Acc.Password = "19734";
        
        //System.out.println(Acc.Verify());
        
    }
    
    
    
}
