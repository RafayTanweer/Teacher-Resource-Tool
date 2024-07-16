
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class FENumberGen {
    
    public static class HTObject {
        public int ID;
        public String Name;
        
        public HTObject(String Name, int ID){
            this.Name = Name;
            this.ID = ID;
        }
 
    }
    
    public static final int NumberOfFEExams = 10;
    public String ClassNumber;
    
    public FENumberGen(String ClassNumber){
        this.ClassNumber = ClassNumber;
    }
    
    public int hashCode1(int key) {
        int hash = key % NumberOfFEExams;
        return hash;
    }
    
    public void CreatingHashTableAndFENFile() throws FileNotFoundException{
        
        Scanner inFile = new Scanner(new FileReader(ClassNumber + ".txt"));
        String Name;
        String ID;
        ArrayList<HTObject> StudentRecord = new ArrayList<HTObject>();
        
        while(inFile.hasNextLine()){
            
            Name = inFile.nextLine();
            
            if(((int)Name.charAt(0) >= 65 && (int)Name.charAt(0) <=90) || ((int)Name.charAt(0) >= 97 && (int)Name.charAt(0) <=122)){
              ID = inFile.nextLine();
              StudentRecord.add(new HTObject(Name,Integer.parseInt(ID)));
            }
              
        }
        
        if(StudentRecord.size() <= 10){//Closed Hashing
            
            HTObject[] HashTable = new HTObject[NumberOfFEExams];
            
            for(int i = 0; i < HashTable.length; i++)
                HashTable[i] = null;
                
            for(int i = 0; i < StudentRecord.size(); i++)
                putClosedHashing(StudentRecord.get(i).ID, StudentRecord.get(i).Name, HashTable);
            
            CreateFENFile_CH(HashTable);
            
        }
        else{//Open Hashing or Seperate Chaining
            
            LinkedList<HTObject>[] HashTable = new LinkedList[NumberOfFEExams];
            
            for(int i = 0; i < HashTable.length; i++)
                HashTable[i] = null;
            
            for(int i = 0; i < StudentRecord.size(); i++)
                putOpenHashing(StudentRecord.get(i).ID, StudentRecord.get(i).Name, HashTable);
            
            CreateFENFile_OH(HashTable);
        }
        
        
    }
    
    public void putClosedHashing(Integer key, String value, HTObject[] HashTable) {
        
        int index = hashCode1(key);
        HTObject item = new HTObject(value, key);   
        if (HashTable[index]==null)
        	HashTable[index]= item;
        else
        {
        	while(HashTable[index]!=null){//Linear Probing
                    index++;
                    index = index % NumberOfFEExams;
                } 
        		  
        	HashTable[index]= item;
        }
        	
        	
    }
    
    public void putOpenHashing(Integer key, String value, LinkedList<HTObject>[] HashTable) {
        
        int index = hashCode1(key);
	LinkedList<HTObject> List = HashTable[index];
	 
	if(List == null) {
            
	    List = new LinkedList<HTObject>();
	 
	    HTObject item = new HTObject(value, key);
	 
	    List.add(item);
	 
	    HashTable[index] = List;
	}
	else {
	 
	    HTObject item = new HTObject(value, key);
	 
	    List.add(item);
            
	}
                
    }
    
    public void CreateFENFile_CH(HTObject[] HashTable) throws FileNotFoundException{
        
        PrintWriter outFile = new PrintWriter("FEN" + ClassNumber + ".txt");
            
        for(int i = 0; i < HashTable.length; i++){
                
            if(HashTable[i] != null){
                outFile.println(HashTable[i].Name);
                outFile.println(HashTable[i].ID);
                outFile.println(i);
            }
                
        }
            
        outFile.close();
        
    }
    
    public void CreateFENFile_OH(LinkedList<HTObject>[] HashTable) throws FileNotFoundException{
        
        PrintWriter outFile = new PrintWriter("FEN" + ClassNumber + ".txt");
        HTObject temp;
        
        for(int i = 0; i  < HashTable.length; i++){
            
            if(HashTable[i] != null){
                
                for(int j = 0; j < HashTable[i].size(); j++){
                    outFile.println(HashTable[i].get(j).Name);
                    outFile.println(HashTable[i].get(j).ID);
                    outFile.println(i);
                }
                    
            }
            
        }
        
        outFile.close();
    }
    
    public ArrayList<FENRecord> getFENs() throws FileNotFoundException{
        
        ArrayList<FENRecord> List = new ArrayList<FENRecord>();
         File f2 = new File("FEN" + ClassNumber +  ".txt");
       
        Scanner sc = new Scanner(f2);
        do{
            FENRecord Rec = new FENRecord();
            
            String data1 = sc.nextLine();
            String data2 = sc.nextLine();
            String data3 = sc.nextLine();
            Rec.Name = data1;
            Rec.ID = data2;
            Rec.FEN = data3;
            List.add(Rec);
            
            
        }while(sc.hasNextLine());
        sc.close();
        
        
        return List;
        
    }
    
    
    
    
    
    
    
    
    
}
