
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdur-Rafay
 */
public class ClassDisplayGUI extends javax.swing.JFrame {

    /**
     * Creates new form ClassDisplayGUI
     */
    
    private ClassDisplay Classes = new ClassDisplay();
    
    public ClassDisplayGUI(String TeacherName, String CourseName) throws FileNotFoundException {
        
        initComponents();
        Classes.TeacherName = TeacherName;
        Classes.CourseName = CourseName;
        SetClasses();
    }
    
    public void SetClasses() throws FileNotFoundException{
        
        ArrayList<String> List;
        List = Classes.getClasses();
        if(List.size() == 2){
            Class1Button.setLabel(List.get(0));
            Class2Button.setLabel(List.get(1));
        }
        else if(List.size() == 1){
            Class1Button.setLabel(List.get(0));
            Class2Button.setLabel("No Class Available");
        }
        else{
            Class1Button.setLabel("No class Available");
            Class2Button.setLabel("No Class Available");
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

        Class1Button = new java.awt.Button();
        Class2Button = new java.awt.Button();
        BackButton = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Class1Button.setLabel("button1");
        Class1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Class1ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Class1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 170, 118, 46));

        Class2Button.setLabel("button2");
        Class2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Class2ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Class2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 170, 118, 46));

        BackButton.setLabel("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 350, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Class1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Class1ButtonActionPerformed
        
        AcessClassesGUI AccessClasses;
        try {
            AccessClasses = new AcessClassesGUI(Class1Button.getLabel(),Classes.TeacherName,Classes.CourseName);
            AccessClasses.setVisible(true);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClassDisplayGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_Class1ButtonActionPerformed

    private void Class2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Class2ButtonActionPerformed
        
         AcessClassesGUI AccessClasses;
        try {
            AccessClasses = new AcessClassesGUI(Class2Button.getLabel(), Classes.TeacherName, Classes.CourseName);
            AccessClasses.setVisible(true);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClassDisplayGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }//GEN-LAST:event_Class2ButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        
        CAVGUI CAVHome = new CAVGUI(Classes.TeacherName, Classes.CourseName);
        CAVHome.setVisible(true);
        this.setVisible(false);
        
        
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
            java.util.logging.Logger.getLogger(ClassDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                //new ClassDisplayGUI().setVisible(true);
            //}
        //});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button BackButton;
    private java.awt.Button Class1Button;
    private java.awt.Button Class2Button;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
