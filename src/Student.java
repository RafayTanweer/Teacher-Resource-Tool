
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
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
public class Student{
    
    public String classNumber;
    
    public static class Node{
        StudentRecord key; //key of the node
        Node left; //reference for the left child node
        Node right; //reference for the right child node

        Node(StudentRecord key){
            this.key = key;
            this.left = null;
            this.right = null;
  }

      
    }
    public Node root;
    /* Functions to insert data */
    
    public Student(){
        root = null;
    }
    
    public Student(String classNumber) throws FileNotFoundException{
        root = null;
        this.classNumber = classNumber;
        ConstructTree();
    
    }
   
    public void insertByName(StudentRecord stu) {
        root = insertByName(root, stu);

    }
 /* Function to insert data recursively */
    private Node insertByName(Node node,  StudentRecord stu) {

        if (node == null) {
            node = new Node(stu);
        } else {
            if (stu.studentName.charAt(0) <= node.key.studentName.charAt(0)) {
                node.left = insertByName(node.left, stu);
            } else {
                node.right = insertByName(node.right, stu);
            }
        }
        return node;
    }
    public void insertByERP(StudentRecord stu) {
        root = insertByERP(root, stu);

    }
 /* Function to insert data recursively */
    private Node insertByERP(Node node,  StudentRecord stu) {

        if (node == null) {
            node = new Node(stu);
        } else {
            if (Integer.parseInt(stu.erpId) <= Integer.parseInt(node.key.erpId)) {
                node.left = insertByERP(node.left, stu);
            } else {
                node.right = insertByERP(node.right, stu);
            }
        }
        return node;
    }
    
    private Node search(Node rootNode , String v) {
        Node location = null;
        long val  =  Long.parseLong(v);
        while ((rootNode != null) ) {
            long rval = Long.parseLong(rootNode.key.erpId);
            if (val < rval) {
                rootNode = rootNode.left;
            } else if (val > rval) {
                rootNode = rootNode.right;
            } else {
                location = rootNode;
                
                break;
            }
            location = search(rootNode, v);
        }
        return location;
    }

    /* Function for inorder traversal */
    public ArrayList<StudentRecord> inorder() {
        ArrayList<StudentRecord> AllStudents = new ArrayList<StudentRecord>();
        return inorder(root, AllStudents);
    }

    private ArrayList<StudentRecord> inorder(Node r, ArrayList<StudentRecord> AllStudents) {
        if (r != null) {
            inorder(r.left, AllStudents);
            AllStudents.add(new StudentRecord(r.key.studentName,r.key.erpId,r.key.currentOverallPercentage));
            inorder(r.right, AllStudents);
        }
        
        return AllStudents;
    }
    
    public Node searchByERP(String ERPID) throws FileNotFoundException{
        
        File f2 = new File(classNumber + ".txt");
        Student BSTSearch = new Student();
        Scanner sc = new Scanner(f2);
        do{
            StudentRecord st = new StudentRecord();
            
            String data1 = sc.nextLine();
            String data2 = sc.nextLine();
            String data3 = sc.nextLine();
            st.studentName = data1;
            st.erpId = data2;
            st.currentOverallPercentage = data3;
            
            BSTSearch.insertByERP(st);
            
            
        }while(sc.hasNextLine());
        sc.close();
        
        Node n = search(BSTSearch.root, ERPID);
        return n;
        
    }
    public void ConstructTree() throws FileNotFoundException{
        
        File f2 = new File(classNumber + ".txt");
        Scanner sc = new Scanner(f2);
        do{
            StudentRecord st = new StudentRecord();
            
            String data1 = sc.nextLine();
            String data2 = sc.nextLine();
            String data3 = sc.nextLine();
            st.studentName = data1;
            st.erpId = data2;
            st.currentOverallPercentage = data3;
            
            insertByName(st);
            
            
        }while(sc.hasNextLine());
        sc.close();
        
    }
    
    public ArrayList<StudentRecord> GetAlphabeticOrder(){
        return inorder();
    }
    
    public void editRecord(String sERP, String newPercentage) throws FileNotFoundException{
       
       Scanner inFile = new Scanner(new FileReader(classNumber + ".txt"));
       PrintWriter outFile = new PrintWriter("temp.txt");
       
       String line;
       line = inFile.nextLine();
       outFile.println(line);
       
       while(inFile.hasNextLine()){
           
        
        line = inFile.nextLine();

        if(line.toUpperCase().equals(sERP.toUpperCase())){
            
            outFile.println(line);
            outFile.println(newPercentage);
            inFile.nextLine();
            
        }
        else
            outFile.println(line);
       
       }
       
       inFile.close();
       outFile.close();
       
       File FiletoDel = new File(classNumber + ".txt");
       FiletoDel.delete();
        
       File FileToRename = new File("temp.txt");
       File file = new File(classNumber + ".txt");
       FileToRename.renameTo(file);
       
       this.root = null;
       ConstructTree();;
        
        
    }
    
    public PriorityQueue<StudentRecord> GetStrong() throws FileNotFoundException{
         Comparator<StudentRecord> customComparator = new Comparator<StudentRecord>() {
            
            public int compare(StudentRecord S1, StudentRecord S2) {
                return (int)Double.parseDouble(S2.currentOverallPercentage) - (int)Double.parseDouble(S1.currentOverallPercentage);
            }

            

            
        };
        // Create a Priority Queue with a custom Comparator
        PriorityQueue<StudentRecord> SQueue = new PriorityQueue<>(customComparator);
        
 
        // Add items to a Priority Queue
        File f2 = new File(this.classNumber + ".txt");
       
        Scanner sc = new Scanner(f2);
        do{
            StudentRecord s = new StudentRecord();
            
            String data1 = sc.nextLine();
            String data2 = sc.nextLine();
            String data3 = sc.nextLine();
            s.studentName = data1;
            s.erpId = data2;
            s.currentOverallPercentage = data3;
            SQueue.add(s);
            
            
        }while(sc.hasNextLine());
        sc.close();
        
        return SQueue;
    }
    
    public PriorityQueue<StudentRecord> GetWeak() throws FileNotFoundException{
         Comparator<StudentRecord> customComparator = new Comparator<StudentRecord>() {
            
            public int compare(StudentRecord S1, StudentRecord S2) {
                return (int)Double.parseDouble(S1.currentOverallPercentage) - (int)Double.parseDouble(S2.currentOverallPercentage);
            }

            

            
        };
        // Create a Priority Queue with a custom Comparator
        PriorityQueue<StudentRecord> SQueue = new PriorityQueue<>(customComparator);
        
 
        // Add items to a Priority Queue
        File f2 = new File(this.classNumber + ".txt");
        
        Scanner sc = new Scanner(f2);
        do{
            StudentRecord s = new StudentRecord();
            
            String data1 = sc.nextLine();
            String data2 = sc.nextLine();
            String data3 = sc.nextLine();
            s.studentName = data1;
            s.erpId = data2;
            s.currentOverallPercentage = data3;
            SQueue.add(s);
            
            
        }while(sc.hasNextLine());
        sc.close();
        
        return SQueue;
}
    public static void main (String [] args) throws IOException{
        //printInAlphabeticalOrder();
        //printStrong();
        //printWeak();
        //searchByERP();
        //editRecord("18585", "14.0");
        //editRecord("18623", "13.0");

    }
    
}
