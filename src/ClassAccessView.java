
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
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
public class ClassAccessView {
    
    public String TeacherName;
    public String CourseName;
    
    public void CreateClass(String ClassNumber,SinglyLinkList Students) throws FileNotFoundException{
        
        CourseName = CourseName.replace(" ", "");
        Scanner inFile = new Scanner(new FileReader(CourseName + "By" + TeacherName + "(CAV)" +  ".txt"));
        PrintWriter outFile = new PrintWriter("temp.txt");
        String line;
        
        while(inFile.hasNextLine()){
            
            line = inFile.nextLine();
            outFile.println(line);
            
        }
        
        outFile.println(ClassNumber);
        
        inFile.close();
        outFile.close();
        
        File FiletoDel = new File(CourseName + "By" + TeacherName + "(CAV)" +  ".txt");
        FiletoDel.delete();
        
        File FileToRename = new File("temp.txt");
        File file = new File(CourseName + "By" + TeacherName + "(CAV)" +  ".txt");
        FileToRename.renameTo(file);
        
        PrintWriter ClassFile = new PrintWriter(ClassNumber + ".txt");
        
        Node current = Students.head;
        
        while(current != null){
            ClassFile.println(current.Name);
            ClassFile.println(current.ID);
            ClassFile.println(current.overallPercent);  
            current = current.next;
        }
        
        ClassFile.close();
        
    }
    
    public boolean DeleteClass(String ClassNumber) throws FileNotFoundException{
        
        
        
        File ClassFile = new File(ClassNumber + ".txt");
        boolean DelCheck = ClassFile.delete();
        
        
        if(DelCheck){
            
            CourseName = CourseName.replace(" ", "");
            Scanner inFile = new Scanner(new FileReader(CourseName + "By" + TeacherName + "(CAV)" +  ".txt"));
            PrintWriter outFile = new PrintWriter("temp.txt");
            String line;
        
            while(inFile.hasNextLine()){
            
                line = inFile.nextLine();
                if(!line.equals(ClassNumber))
                    outFile.println(line);
            
            }
        
            inFile.close();
            outFile.close();
            
            File FiletoDel = new File(CourseName + "By" + TeacherName + "(CAV)" +  ".txt");
            FiletoDel.delete();
        
            File FileToRename = new File("temp.txt");
            File file = new File(CourseName + "By" + TeacherName + "(CAV)" +  ".txt");
            FileToRename.renameTo(file);
    
        }
        
        return DelCheck;
                
    }
    
   
    
    
}
