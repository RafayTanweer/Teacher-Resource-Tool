/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdur-Rafay
 */
public class FENRecord {
    
    public String Name = "";
    public String ID = "";
    public String FEN = "";
    
    
    public FENRecord(){
        
    }
    
    public FENRecord(String Name, String ID, String FEN){
        this.Name = Name;
        this.ID = ID;
        this.FEN = FEN;
        
    }
    
}
