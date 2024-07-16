
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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
public class Courses {
    
    public String Teacher;
    
    public Courses(){
        this.Teacher = "";
    }
    
    public ArrayList<String> CourseList() throws FileNotFoundException{
        
        ArrayList<String> List = new ArrayList<String>();
        Scanner inFile = new Scanner(new FileReader(this.Teacher + ".txt"));
        String line;
        
        while(inFile.hasNextLine()){
            line = inFile.nextLine();
            line = line.trim();
            List.add(line);
        }
        
        return List;
        
    }
    
}
