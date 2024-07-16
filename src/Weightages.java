/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aaali
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.io.FileWriter;

public class Weightages {
    
    String TeacherName ;
    String CourseName ; 
    String FileName  ;
    
    public Weightages(String TeacherName, String CourseName){
        
        this.TeacherName = TeacherName.replace(" ", "");
        this.CourseName = CourseName.replace(" ", "");
        this.FileName = "Weightages" + this.TeacherName + this.CourseName + ".txt";
        
        
    }
    
    public void createFileW() throws IOException{
       
        File W = new File("C:\\Weightages\\WeightagesAsmaLarikDataStructures.txt");
        if ( W.createNewFile()){
             String path = W.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        File We = new File("C:\\Weightages\\WeightagesAsmaLarikDigitalLogicDesign.txt");
        if ( We.createNewFile()){
             String path = We.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        File Wei = new File("C:\\Weightages\\WeightagesShahidQureshiNumericalAnalysis.txt");
        if ( Wei.createNewFile()){
             String path = Wei.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        File Weig = new File("C:\\Weightages\\WeightagesShahidQureshiLinearAlgebra.txt");
        if ( Weig.createNewFile()){
             String path = Weig.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
       
        
    }
    
    public WeightageRecord[] printInAscendingOrder() throws FileNotFoundException{
        ArrayList<WeightageRecord> list1 = new ArrayList<WeightageRecord>();
        File f2 = new File(FileName);
        
        Scanner sc = new Scanner(f2);
        do{
            WeightageRecord w = new WeightageRecord();
            
            String data1 = sc.nextLine();
            String data2 = sc.nextLine();
            w.Item = data1;
            w.Percent = data2;
            list1.add(w);
            
            
        }while(sc.hasNextLine());
        
        sc.close();
        WeightageRecord [] ar = new WeightageRecord[list1.size()];
        for ( int j = 0; j < list1.size(); j++){
             ar[j]= new WeightageRecord();
            
        }
       
        ar = list1.toArray(ar);
        heapsort(ar);
        
        return ar;
        
    }
   
    public void appendDataSame(String item, String percent) throws IOException{
   
    File f2 = new File(FileName);
    item = item.replaceAll(" ", "");

    FileWriter fileWritter1 = new FileWriter(f2.getName(),true);
    BufferedWriter bw1 = new BufferedWriter(fileWritter1);
    
    bw1.write(item);
    bw1.newLine();
   
    bw1.close();
    File f3 = new File(FileName);
         

    FileWriter fileWritter2 = new FileWriter(f3.getName(),true);
    BufferedWriter bw2 = new BufferedWriter(fileWritter2);
    bw2.write(percent);
    bw2.newLine();
   
    bw2.close();

    }
    public void appendDataNewCopy(String item, String percent) throws FileNotFoundException{
        
        item = item.replaceAll(" ", "");
        Scanner inFile = new Scanner(new FileReader(FileName));
        PrintWriter outFile = new PrintWriter("temp.txt");
      
       String line;
       
       while(inFile.hasNextLine()){
           
        line = inFile.nextLine();

        
        outFile.println(line);
       
       }
       outFile.println(item);
       outFile.println(percent);
       
       
       inFile.close();
       outFile.close();
       
       File FiletoDel = new File(FileName);
       FiletoDel.delete();
        
       File FileToRename = new File("temp.txt");
       File file = new File(FileName);
       FileToRename.renameTo(file);
       
    }

        

    public void editRecord(String item, String newWeightage) throws FileNotFoundException{
       
       item = item.replaceAll(" ", "");
       Scanner inFile = new Scanner(new FileReader(FileName));
       PrintWriter outFile = new PrintWriter("temp.txt");
       String line;
       
       while(inFile.hasNextLine()){
           
        line = inFile.nextLine();

        if(line.toUpperCase().equals(item.toUpperCase())){
            
            outFile.println(line);
            outFile.println(newWeightage);
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
    
    public void heapsort(WeightageRecord arr [])
	{
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			WeightageRecord temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
                
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	public void heapify(WeightageRecord arr[], int n, int i)
	{
		
                int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && Double.parseDouble(arr[l].Percent) > Double.parseDouble(arr[largest].Percent))
			largest = l;

		// If right child is larger than largest so far
		if (r < n && Double.parseDouble(arr[r].Percent) > Double.parseDouble(arr[largest].Percent))
			largest = r;

		// If largest is not root
		if (largest != i) {
			WeightageRecord swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}
    
    

    public static void main (String [] args) throws IOException{
        
       //editRecord("mid","9.0");
       //printAll();
       //appendDataNewCopy();
      

    }
}
