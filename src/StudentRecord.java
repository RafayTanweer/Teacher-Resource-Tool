/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdur-Rafay
 */
public class StudentRecord {
    
    String studentName;
    String erpId;
    String currentOverallPercentage;
        
    public StudentRecord(){
            this.studentName = "";
            this.erpId = "";
            this.currentOverallPercentage = "";
    }
        
    public StudentRecord(String studentName, String erpID, String currentOverallPercentage){
            this.studentName = studentName;
            this.erpId = erpID;
            this.currentOverallPercentage = currentOverallPercentage;
    }
    
}
