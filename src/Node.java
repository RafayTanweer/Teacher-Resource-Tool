/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdur-Rafay
 */
public class Node {
    
    String Name;
        String ID;
        double overallPercent;
        Node next;
            
        public Node(String Name, String ID, double overallPercent) {    
            this.Name = Name;
            this.ID = ID;
            this.overallPercent = overallPercent;
            this.next = null;    
        }    
    
    
}
