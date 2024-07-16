
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
public class ClassDisplay {
    
    public String TeacherName;
    public String CourseName;
    
    public ClassDisplay(){
        this.TeacherName = "";
        this.CourseName = "";
    }
    
    public ArrayList<String> getClasses() throws FileNotFoundException{
        
        this.CourseName = this.CourseName.replaceAll(" ", "");
        ArrayList<String> List = new ArrayList<String>();
        Scanner inFile = new Scanner(new FileReader(this.CourseName + "By" + this.TeacherName + "(CAV).txt"));
        String line;
        
        while(inFile.hasNextLine()){
            line = inFile.nextLine();
            line = line.trim();
            List.add(line);
        }
        
        return List;
        
        
        
    }
    
    
}
