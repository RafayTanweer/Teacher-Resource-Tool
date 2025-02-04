
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PrintStudentsGUI extends javax.swing.JFrame {

    /**
     * Creates new form PrintStudentsGUI
     */
    
    private Student Students;
    private String TeacherName;
    private String Coursename;
    
    public PrintStudentsGUI(Student Students, String TeacherName, String Coursename) throws FileNotFoundException {
        this.Students = Students;
        this.TeacherName = TeacherName;
        this.Coursename = Coursename;
        initComponents();
        DisplayingAlphabetically();
        DisplayingTop3();
        DisplayingFocusedStudents();
    }
    
    public void DisplayingAlphabetically(){
        
        DefaultTableModel model = (DefaultTableModel) AlphabeticallyOrderedJtable.getModel();
        ArrayList<StudentRecord> AllStudents;
        AllStudents = Students.GetAlphabeticOrder();
        
        for(int i = 0; i < AllStudents.size(); i++){
            
            Object[] RowArray = new Object[3];
            RowArray[0] = AllStudents.get(i).studentName;
            RowArray[1] = AllStudents.get(i).erpId;
            RowArray[2] = AllStudents.get(i).currentOverallPercentage;
            model.addRow(RowArray);
            
        }
        
    }
    
    public void DisplayingTop3() throws FileNotFoundException{
        
        DefaultTableModel model = (DefaultTableModel) Top3Jtable.getModel();
        PriorityQueue<StudentRecord> Pqueue;
        Pqueue = Students.GetStrong();
        
        for(int i = 0; i < 3; i++){
            
            Object[] RowArray = new Object[3];
            RowArray[0] = Pqueue.peek().studentName;
            RowArray[1] = Pqueue.peek().erpId;
            RowArray[2] = Pqueue.peek().currentOverallPercentage;
            model.addRow(RowArray);
            Pqueue.poll();
            
        }
        
    }
    
    public void DisplayingFocusedStudents() throws FileNotFoundException{
        
        DefaultTableModel model = (DefaultTableModel) FocusedStudentsJtable.getModel();
        PriorityQueue<StudentRecord> Pqueue;
        Pqueue = Students.GetWeak();
        
        for(int i = 0; i < 3; i++){
            
            Object[] RowArray = new Object[3];
            RowArray[0] = Pqueue.peek().studentName;
            RowArray[1] = Pqueue.peek().erpId;
            RowArray[2] = Pqueue.peek().currentOverallPercentage;
            model.addRow(RowArray);
            Pqueue.poll();
            
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

        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        AlphabeticallyOrderedJtable = new javax.swing.JTable();
        label2 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        Top3Jtable = new javax.swing.JTable();
        label3 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        FocusedStudentsJtable = new javax.swing.JTable();
        BackButton = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        label1.setText("Students Displayed in Alphabetical Order");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 56, 349, -1));

        AlphabeticallyOrderedJtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ERP", "Current Overall Percentage"
            }
        ));
        jScrollPane1.setViewportView(AlphabeticallyOrderedJtable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 84, 504, 149));

        label2.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        label2.setText("Top 3 Students");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 309, 316, -1));

        Top3Jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ERP", "Current Overall Percentage"
            }
        ));
        jScrollPane2.setViewportView(Top3Jtable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 337, 504, 96));

        label3.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        label3.setText("Students that need to be focused on");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 509, 309, -1));

        FocusedStudentsJtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ERP", "Current Overall Percentage"
            }
        ));
        jScrollPane3.setViewportView(FocusedStudentsJtable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 537, 504, 96));

        BackButton.setLabel("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 683, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        
        try {
            AcessClassesGUI ACHome = new AcessClassesGUI(Students.classNumber, TeacherName, Coursename);
            ACHome.setVisible(true);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintStudentsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_BackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PrintStudentsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintStudentsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintStudentsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintStudentsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                //new PrintStudentsGUI().setVisible(true);
            //}
        //});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AlphabeticallyOrderedJtable;
    private java.awt.Button BackButton;
    private javax.swing.JTable FocusedStudentsJtable;
    private javax.swing.JTable Top3Jtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    // End of variables declaration//GEN-END:variables
}
