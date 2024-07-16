
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdur-Rafay
 */
public class DesignerGUI extends javax.swing.JFrame {

    /**
     * Creates new form DesignerGUI
     */
    
    private String TeacherName;
    private String CourseName;
    private Weightages CourseWeightages;
    private MaxNumber CourseNumbers;
    private CourseOverview CourseOutline;
    private DefaultTableModel model;
    private String WhatToDisplay;
    
    public DesignerGUI(String TeacherName, String CourseName, String WhatToDisplay) throws FileNotFoundException {
        
        this.TeacherName = TeacherName;
        this.CourseName = CourseName;
        this.WhatToDisplay = WhatToDisplay;
        
        initComponents();
        this.setSize(885, 792);
        this.EditButton.setVisible(false);
        this.label1.setVisible(false);
        this.label2.setVisible(false);
        this.textField1.setVisible(false);
        this.textField2.setVisible(false);
        this.DoneEditingButton.setVisible(false);
        
        this.AppendButton.setVisible(false);
        this.label3.setVisible(false);
        this.label4.setVisible(false);
        this.label5.setVisible(false);
        this.textField3.setVisible(false);
        this.textField4.setVisible(false);
        this.textField5.setVisible(false);
        this.DoneAppendingButton.setVisible(false);
        
        this.model = (DefaultTableModel) DisplayTable.getModel();
        
        if(WhatToDisplay.equals("Weightages")){
            model.setColumnCount(2);
            String[] Labels = new String[2];
            Labels[0] = "Name Of Item";
            Labels[1] = "Weightages";
            model.setColumnIdentifiers(Labels);
            this.CourseWeightages = new Weightages(TeacherName, CourseName);
            DisplayingWeightagesInAscOrder();
            label1.setText("Field");
            label2.setText("New Weghtage");
            label3.setText("Field");
            label4.setText("Weightage");
            textField1.setText("e.g. Class Participation");
            textField2.setText("e.g. 5");
            textField3.setText("e.g. Class Participation");
            textField4.setText("e.g. 5");
        }
        else if(WhatToDisplay.equals("MaxNumbers")){
            
            model.setColumnCount(3);
            String[] Labels = new String[3];
            Labels[0] = "Name Of Item";
            Labels[1] = "Number";
            Labels[2] = "Grading Policy";
            model.setColumnIdentifiers(Labels);
            this.CourseNumbers = new MaxNumber(TeacherName, CourseName);
            DisplayingMaxNumbersInAscOrder();
            label1.setText("Field");
            label2.setText("New Number/Policy");
            label3.setText("Field");
            label4.setText("Number");
            label5.setText("Policy");
            textField1.setText("e.g. Class Participation");
            textField2.setText("e.g. 4/n-2 Policy");
            textField3.setText("e.g. Class Participation");
            textField4.setText("e.g. 4");
            textField5.setText("e.g. n-2 Policy");
            
        }
        else{
            
            model.setColumnCount(2);
            String[] Labels = new String[2];
            Labels[0] = "Week Number";
            Labels[1] = "Topic";
            model.setColumnIdentifiers(Labels);
            this.CourseOutline = new CourseOverview(TeacherName, CourseName);
            DisplayingCourseOverview();
            label1.setText("Week");
            label2.setText("New Topic");
            label3.setText("Week");
            label4.setText("Topic");
            textField1.setText("e.g. 1");
            textField2.setText("e.g. Any Course Related Topic");
            textField3.setText("e.g. 1");
            textField4.setText("e.g. Any Course Related Topic");
        }
        
    }
    
    public void DisplayingWeightagesInAscOrder() throws FileNotFoundException{
        
        model.setRowCount(0);
        WeightageRecord[] WeightagesArray;
        WeightagesArray = CourseWeightages.printInAscendingOrder();
        
        for(int i = 0; i < WeightagesArray.length; i++){
            
            Object[] RowArray = new Object[2];
            RowArray[0] = WeightagesArray[i].Item;
            RowArray[1] = WeightagesArray[i].Percent;
            model.addRow(RowArray);
            
        }
        
    }
    
    public void DisplayingMaxNumbersInAscOrder() throws FileNotFoundException{
        
        model.setRowCount(0);
        MaxRecord[] MaxRecordArray;
        MaxRecordArray = CourseNumbers.printInAscendingOrder();
        
        for(int i = 0; i < MaxRecordArray.length; i++){
            
            Object[] RowArray = new Object[3];
            RowArray[0] = MaxRecordArray[i].item;
            RowArray[1] = MaxRecordArray[i].count;
            RowArray[2] = MaxRecordArray[i].policy;
            model.addRow(RowArray);
            
        }
        
        
    }
    
    public void DisplayingCourseOverview() throws FileNotFoundException{
        
        model.setRowCount(0);
        OverviewRecord[] CourseOverviewArray;
        CourseOverviewArray = CourseOutline.GetAllRecords();
        
        for(int i = 0; i < CourseOverviewArray.length; i++){
            
            Object[] RowArray = new Object[2];
            RowArray[0] = CourseOverviewArray[i].Week;
            RowArray[1] = CourseOverviewArray[i].Topic;
            model.addRow(RowArray);
            
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayTable = new javax.swing.JTable();
        BackButton = new java.awt.Button();
        ChangeRecordsButton = new java.awt.Button();
        EditButton = new java.awt.Button();
        AppendButton = new java.awt.Button();
        label1 = new java.awt.Label();
        textField1 = new java.awt.TextField();
        label2 = new java.awt.Label();
        textField2 = new java.awt.TextField();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        textField3 = new java.awt.TextField();
        textField4 = new java.awt.TextField();
        DoneEditingButton = new java.awt.Button();
        DoneAppendingButton = new java.awt.Button();
        label5 = new java.awt.Label();
        textField5 = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        DisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(DisplayTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 40, 750, 154);

        BackButton.setLabel("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(60, 630, 43, 24);

        ChangeRecordsButton.setLabel("Change Records");
        ChangeRecordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeRecordsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ChangeRecordsButton);
        ChangeRecordsButton.setBounds(350, 250, 170, 40);

        EditButton.setLabel("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        getContentPane().add(EditButton);
        EditButton.setBounds(210, 360, 37, 24);

        AppendButton.setLabel("Append");
        AppendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AppendButton);
        AppendButton.setBounds(580, 350, 58, 24);

        label1.setText("label1");
        getContentPane().add(label1);
        label1.setBounds(65, 424, 60, 20);
        getContentPane().add(textField1);
        textField1.setBounds(200, 420, 150, 20);

        label2.setText("label2");
        getContentPane().add(label2);
        label2.setBounds(65, 466, 120, 20);
        getContentPane().add(textField2);
        textField2.setBounds(200, 470, 190, 20);

        label3.setText("label3");
        getContentPane().add(label3);
        label3.setBounds(420, 410, 110, 20);

        label4.setText("label4");
        getContentPane().add(label4);
        label4.setBounds(420, 460, 100, 20);
        getContentPane().add(textField3);
        textField3.setBounds(550, 410, 180, 20);
        getContentPane().add(textField4);
        textField4.setBounds(550, 460, 180, 20);

        DoneEditingButton.setLabel("Done");
        DoneEditingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneEditingButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DoneEditingButton);
        DoneEditingButton.setBounds(65, 504, 46, 24);

        DoneAppendingButton.setLabel("Done");
        DoneAppendingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneAppendingButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DoneAppendingButton);
        DoneAppendingButton.setBounds(420, 540, 46, 24);

        label5.setText("label5");
        getContentPane().add(label5);
        label5.setBounds(420, 500, 110, 20);
        getContentPane().add(textField5);
        textField5.setBounds(550, 500, 180, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 870, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
       
        CODGUI CourseDesigner = new CODGUI(TeacherName, CourseName);
        CourseDesigner.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ChangeRecordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeRecordsButtonActionPerformed
        
        this.EditButton.setVisible(true);
        this.AppendButton.setVisible(true);
        
    }//GEN-LAST:event_ChangeRecordsButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        
        this.label1.setVisible(true);
        this.label2.setVisible(true);
        this.textField1.setVisible(true);
        this.textField2.setVisible(true);
        this.DoneEditingButton.setVisible(true);
        
        
    }//GEN-LAST:event_EditButtonActionPerformed

    private void AppendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppendButtonActionPerformed
        
        if(this.WhatToDisplay.equals("Weightages") || this.WhatToDisplay.equals("CourseOverview")){
            
            this.label3.setVisible(true);
            this.label4.setVisible(true);
            this.textField3.setVisible(true);
            this.textField4.setVisible(true);
            this.DoneAppendingButton.setVisible(true);
            
        }
        else{
            
            this.label3.setVisible(true);
            this.label4.setVisible(true);
            this.label5.setVisible(true);
            this.textField3.setVisible(true);
            this.textField4.setVisible(true);
            this.textField5.setVisible(true);
            this.DoneAppendingButton.setVisible(true);
            
        }
        
        
        
    }//GEN-LAST:event_AppendButtonActionPerformed

    private void DoneEditingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneEditingButtonActionPerformed
        
        if(this.WhatToDisplay.equals("Weightages")){
            
            try {
                if(textField1.getText().equals("") || textField2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill the required fields");
                }
                else{
                    this.CourseWeightages.editRecord(textField1.getText(), textField2.getText());
                    DisplayingWeightagesInAscOrder();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DesignerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }
        else if(this.WhatToDisplay.equals("MaxNumbers")){
            
            try {
                if(textField1.getText().equals("") || textField2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill the required fields");
                }
                else{
                    this.CourseNumbers.editRecord(textField1.getText(), textField2.getText());
                    DisplayingMaxNumbersInAscOrder();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DesignerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else{
            
            try {
                if(textField1.getText().equals("") || textField2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill the required fields");
                }
                else{
                    this.CourseOutline.editRecord(textField1.getText(), textField2.getText());
                    DisplayingCourseOverview();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DesignerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        this.label1.setVisible(false);
        this.label2.setVisible(false);
        this.textField1.setVisible(false);
        this.textField2.setVisible(false);
        this.DoneEditingButton.setVisible(false);
        
    }//GEN-LAST:event_DoneEditingButtonActionPerformed

    private void DoneAppendingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneAppendingButtonActionPerformed
        
        if(this.WhatToDisplay.equals("Weightages")){
            
            try {
                if(textField3.getText().equals("") || textField4.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill the required fields");
                }
                else{
                    this.CourseWeightages.appendDataNewCopy(textField3.getText(), textField4.getText());
                    DisplayingWeightagesInAscOrder();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DesignerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }
        else if(this.WhatToDisplay.equals("MaxNumbers")){
            
            try {
                if(textField3.getText().equals("") || textField4.getText().equals("") || textField5.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill the required fields");
                }
                else{
                    this.CourseNumbers.appendDataNewCopy(textField3.getText(), textField4.getText(), textField5.getText());
                    DisplayingMaxNumbersInAscOrder();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DesignerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else{
            
            try {
                if(textField3.getText().equals("") || textField4.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill the required fields");
                }
                else{
                    this.CourseOutline.appendDataNewCopy(textField3.getText(), textField4.getText());
                    DisplayingCourseOverview();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DesignerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        this.label3.setVisible(false);
        this.label4.setVisible(false);
        this.label5.setVisible(false);
        this.textField3.setVisible(false);
        this.textField4.setVisible(false);
        this.textField5.setVisible(false);
        this.DoneAppendingButton.setVisible(false);
        
        
    }//GEN-LAST:event_DoneAppendingButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DesignerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesignerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesignerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesignerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                //new DesignerGUI().setVisible(true);
            //}
        //});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button AppendButton;
    private java.awt.Button BackButton;
    private java.awt.Button ChangeRecordsButton;
    private javax.swing.JTable DisplayTable;
    private java.awt.Button DoneAppendingButton;
    private java.awt.Button DoneEditingButton;
    private java.awt.Button EditButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    private java.awt.TextField textField5;
    // End of variables declaration//GEN-END:variables
}
