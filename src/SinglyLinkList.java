
import com.sun.javafx.font.FontConstants;


public class SinglyLinkList {
          
    //Represent the head and tail of the singly linked list    
    public Node head = null;    
    public Node tail = null;    
        
    //addNode() will add a new node to the list    
    
    public void addNode(String Name, String ID, double overallPercent) {    
        //Create a new node    
        Node newNode = new Node(Name,ID,overallPercent);    
            
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;    
            //newNode will become new tail of the list    
            tail = newNode;    
        }    
    }    
        
    //display() will display all the nodes present in the list    
    
    public void display() {    
        //Node current will point to head    
        Node current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.println("Name: " + current.Name + " , ID: " + current.ID + " , Overall Percent: " + current.overallPercent);    
            current = current.next;    
        }    
        System.out.println();    
    }    
  
  //addAtStart() will add a new node to the beginning of the list  
    public void addAtStart(String Name, String ID, double overallPercent) {
        
        Node newNode = new Node(Name,ID,overallPercent);
        
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }
    
  //addAtEnd() will add a new node to the end of the list  
    public void addAtEnd(String Name, String ID, double overallPercent) {
        
        Node newNode = new Node(Name,ID,overallPercent);
        
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }
   
  //countNodes() will count the nodes present in the list    
    public int countNodes() { 
        
        int count = 0;
        Node current = head;
        if(current == null)
            return 0;
        else{
            while(current != null){
                count++;
                current = current.next;
            }
            return count;
        }
        
    }
  
    //searchNode() will search for a given node in the list  
    public void searchNode(String Name) { 
        
        Node current = head;
        boolean isFound = false;
        int index = 0;
        if(current == null)
            System.out.println("The list is empty");
        else{
            while(current != null){
                if(current.Name.equals(Name)){
                    System.out.println("The Node was found at " + current + "The index is " + index);
                    isFound = true;
                    break;
                }
                index++;
                current = current.next;
                    
            }
        }
        if(isFound == false)
            System.out.println("The Node was not found");
        
    
    }
    
  //deleteFromStart() will delete a node from the beginning of the list  
    public void deleteFromStart() {  
        
        Node current = head;
        head = head.next;
        current = null;
        System.gc();
          
    }
  
    //deleteFromEnd() will delete a node from end of the list  
    public void deleteFromEnd() { 
        
        Node current = head;
        while(current.next.Name != tail.Name)
            current = current.next;
        Node p = current;
        p.next = null;
        tail = p;
        
        
    }
    
    public SinglyLinkList joinLists(SinglyLinkList p, SinglyLinkList q){
        
        SinglyLinkList j = new SinglyLinkList();
        
        Node currentp = p.head;
        Node currentq = q.head;
        
        while(currentp != null){
            j.addAtEnd(currentp.Name, currentp.ID, currentp.overallPercent);
            currentp = currentp.next;
        }
        while(currentq != null){
            j.addAtEnd(currentq.Name, currentq.ID, currentq.overallPercent);
            currentq = currentq.next;          
        }
        
       return j;
    }
    
   //public int delete_key(){
       //Node cur = head.next;
       //Node dup = cur.next;
       //int a = cur.data;
       //head.next = dup;
       //return a;
               
   //}
   
    //public static void main(String[] args) {
        //SinglyLinkList l1 = new SinglyLinkList();
        //l1.addAtEnd(0);
        //l1.addAtEnd(1);
        //l1.addAtEnd(2);
        //l1.addAtEnd(3);
        //l1.display();
        //System.out.println(l1.delete_key());
        //l1.display();
    //}
    
       
}// end of class
