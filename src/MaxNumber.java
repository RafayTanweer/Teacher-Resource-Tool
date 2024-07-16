
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FilterReader;
import java.io.PrintWriter;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aaali
 */
public class MaxNumber {
    
    static String TeacherName ;
    static String CourseName ; 
    static String FileName  ;

    
     public MaxNumber(String TeacherName, String CourseName){
         
        this.TeacherName = TeacherName.replace(" ", "");
        this.CourseName = CourseName.replace(" ", "");
        this.FileName = "MaxNumber" + this.TeacherName + this.CourseName + ".txt";
        
        
    }
     
     public void createFileM() throws IOException{
        File M = new File("C:\\MaxNumber\\MaxNumberAsmaLarikDataStructures.txt");
        if ( M.createNewFile()){
             String path = M.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        File Ma = new File("C:\\MaxNumber\\MaxNumberShahidQureshiNumericalAnalysis.txt");
        if ( Ma.createNewFile()){
             String path = Ma.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        File Max = new File("C:\\MaxNumber\\MaxNumberAsmaLarikDigitalLogicDesign.txt");
        if ( Max.createNewFile()){
             String path = Max.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        File MaxN = new File("C:\\MaxNumber\\MaxNumberShahidQureshiLinearAlgebra.txt");
        if ( MaxN.createNewFile()){
             String path = MaxN.getPath();
             System.out.println(path);
            
        }
        else  System.out.println("File already exists;");
        
        
       
        
    }
    
     
     public void appendDataSame(String item, String Number, String Policy) throws IOException{
            
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
   
    bw2.write(Number);
    bw2.newLine();
   
    bw2.close();
    File f4 = new File(FileName);
         

    FileWriter fileWritter3 = new FileWriter(f4.getName(),true);
    BufferedWriter bw3 = new BufferedWriter(fileWritter3);
    bw3.write(Policy);
    bw3.newLine();
   
    bw3.close();
    
    }
     
    public void editRecord(String sItem, String newCountOrPolicy) throws FileNotFoundException{
       
       sItem = sItem.replaceAll(" ", "");
       Scanner inFile = new Scanner(new FileReader(FileName));
       PrintWriter outFile = new PrintWriter("temp.txt");
       String line;
       
       while(inFile.hasNextLine()){
           
        line = inFile.nextLine();

        if(line.toUpperCase().equals(sItem.toUpperCase())){
            if(checkOnlyDigits(newCountOrPolicy)){
                
            outFile.println(line);
            outFile.println(newCountOrPolicy);
            inFile.nextLine();
            }
            else{
                outFile.println(line);
                line = inFile.nextLine();
                outFile.println(line);
                outFile.println(newCountOrPolicy);
                inFile.nextLine();
                
                
                
            }
            
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
      
    public boolean checkOnlyDigits(String st) 
    { 
        int n = st.length();
        
        for (int i = 0; i < n; i++) { 
  
            
            if (st.charAt(i) >= '0'
                && st.charAt(i) <= '9') { 
                return true; 
            } 
            else { 
                return false; 
            } 
        } 
        return false; 
    } 
      
      public MaxRecord[] printInAscendingOrder() throws FileNotFoundException{
          
        ArrayList<MaxRecord> list1 = new ArrayList<MaxRecord>();
        
        File f2 = new File(FileName);
        
        Scanner sc = new Scanner(f2);
        do{
            MaxRecord m = new MaxRecord();
            
            String data1 = sc.nextLine();
            String data2 = sc.nextLine();
            String data3 = sc.nextLine();
            m.item = data1;
            m.count = data2;
            m.policy = data3;
            list1.add(m);
            
            
        }while(sc.hasNextLine());
        sc.close();
        
        MaxRecord [] ar = new MaxRecord[list1.size()];
        for ( int j = 0; j < list1.size(); j++){
             ar[j]= new MaxRecord();
            
        }
        
       
        ar = list1.toArray(ar);
        mergesort(ar, 0, ar.length - 1);
        
        return ar;
        
        
        
    }
      
       public void appendDataNewCopy(String item, String Number, String Policy) throws FileNotFoundException{   
        
        item = item.replaceAll(" ", "");   
        Scanner inFile = new Scanner(new FileReader(FileName));
        PrintWriter outFile = new PrintWriter("temp.txt");
        
       
       String line;
       
       while(inFile.hasNextLine()){
           
        line = inFile.nextLine();

        
        outFile.println(line);
       
       }
       outFile.println(item);
       outFile.println(Number);
       outFile.println(Policy);
       
       
       inFile.close();
       outFile.close();
       
       File FiletoDel = new File(FileName);
       FiletoDel.delete();
        
       File FileToRename = new File("temp.txt");
       File file = new File(FileName);
       FileToRename.renameTo(file);
        
        
    
    }

   
     
     public void merge(MaxRecord arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		MaxRecord L[] = new MaxRecord[n1];
		MaxRecord R[] = new MaxRecord[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i){
                    L[i] = arr[l + i];
                    
                }
			
                
		for (int j = 0; j < n2; ++j){
                    R[j] = arr[m + 1 + j];
                    
                    
                }
			

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
                    
			if (Integer.parseInt(L[i].count) <= Integer.parseInt(R[j].count)) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
                    
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
                    
			arr[k] = R[j];
			j++;
			k++;
		}
                
	}

	// Main function that sorts arr[l..r] using
	// merge()
	public void mergesort(MaxRecord arr[], int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergesort(arr, l, m);
			mergesort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}
     public static void main (String [] args) throws IOException{
         //printInAscendingOrder();
         //appendDataNewCopy();
        
        

    }
    
}
