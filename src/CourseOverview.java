
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aaali
 */
public class CourseOverview {
    
    static String TeacherName ;
    static String CourseName ; 
    static String FileName  ;
    
    
    public CourseOverview(String TeacherName, String CourseName){
        this.TeacherName = TeacherName.replace(" ", "");
        this.CourseName = CourseName.replace(" ", "");
        this.FileName = "CourseOverview" + this.TeacherName + this.CourseName + ".txt";
        
        
    }
    
     public void createFileO() throws IOException{
        File O = new File("C:\\CourseOverview\\CourseOverviewAsmaLarikDataStructures.txt");
        if ( O.createNewFile()){
             String path = O.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
       File Ov = new File("C:\\CourseOverview\\CourseOverviewAsmaLarikDigitalLogicDesign.txt");
        if ( Ov.createNewFile()){
             String path = Ov.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        File Ove = new File("C:\\CourseOverview\\CourseOverviewShahidQureshiNumericalAnalysis.txt");
        if ( Ove.createNewFile()){
             String path = Ove.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        File Over = new File("C:\\CourseOverview\\CourseOverviewShahidQureshiLinearAlgebra.txt");
        if ( Over.createNewFile()){
             String path = Over.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        
    }
     
    public void appendDataSame(String WeekNumber, String topic) throws IOException{
         
    File f2 = new File(FileName);
         

    FileWriter fileWritter1 = new FileWriter(f2.getName(),true);
    BufferedWriter bw1 = new BufferedWriter(fileWritter1);
   
    bw1.write("Week" + WeekNumber);
    bw1.newLine();
   
    bw1.close();
    File f3 = new File(FileName);
         

    FileWriter fileWritter2 = new FileWriter(f3.getName(),true);
    BufferedWriter bw2 = new BufferedWriter(fileWritter2);
    bw2.write(topic);
    bw2.newLine();
   
    bw2.close();
       
    }
    
     public void appendDataNewCopy(String WeekNumber, String topic) throws FileNotFoundException{
 
        Scanner inFile = new Scanner(new FileReader(FileName));
        PrintWriter outFile = new PrintWriter("temp.txt");
        
       
       String line;
       
       while(inFile.hasNextLine()){
           
        line = inFile.nextLine();

        
        outFile.println(line);
       
       }
       outFile.println("Week" + WeekNumber);
       outFile.println(topic);
       
       inFile.close();
       outFile.close();
       
       File FiletoDel = new File(FileName);
       FiletoDel.delete();
        
       File FileToRename = new File("temp.txt");
       File file = new File(FileName);
       FileToRename.renameTo(file);
        
        
    
    }

      public void editRecord(String WeekNumber, String newTopic) throws FileNotFoundException{
              
       Scanner inFile = new Scanner(new FileReader(FileName));
       PrintWriter outFile = new PrintWriter("temp.txt");
       String line;
       String Week = "Week" + WeekNumber;
       
       while(inFile.hasNextLine()){
           
        line = inFile.nextLine();

        if(line.toUpperCase().equals(Week.toUpperCase())){
            
            outFile.println(line);
            outFile.println(newTopic);
            inFile.nextLine();
            
        }
        else
            outFile.println(line);
       
       }
       
       inFile.close();
       outFile.close();
       
       File FiletoDel = new File(FileName);
       FiletoDel.delete();
        
       File FileToRename = new File("temp.txt");
       File file = new File(FileName);
       FileToRename.renameTo(file);
        
        
    }
      
    public OverviewRecord[] GetAllRecords() throws FileNotFoundException{
        
        ArrayList<OverviewRecord> list1 = new ArrayList<OverviewRecord>();
        File f2 = new File(FileName);
        
        Scanner sc = new Scanner(f2);
        do{
            OverviewRecord O = new OverviewRecord();
            
            String data1 = sc.nextLine();
            String data2 = sc.nextLine();
            O.Week = data1;
            O.Topic = data2;
            list1.add(O);
            
            
        }while(sc.hasNextLine());
        
        sc.close();
        
        OverviewRecord [] ar = new OverviewRecord[list1.size()];
        for ( int j = 0; j < list1.size(); j++){
             ar[j]= new OverviewRecord();
            
        }
       
        ar = list1.toArray(ar);
        
        return ar;
        
        
    }  
      
    
      public static void main (String [] args) throws IOException{
       
        /*appendData();
        printAll();
        editRecord("Week11", "Holiday");*/
    }
      
    
}
