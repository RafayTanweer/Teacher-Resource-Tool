
import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdur-Rafay
 */
public class CourseDisplayGUI extends javax.swing.JFrame {

    /**
     * Creates new form CourseDisplayGUI
     */
    
    private Courses TaughtCourses = new Courses();
    
    public CourseDisplayGUI(Login Account) throws FileNotFoundException {
        TaughtCourses.Teacher = Account.Username;
        initComponents();
         SetCourses();
    }
    
    public void SetCourses() throws FileNotFoundException{
        
        ArrayList<String> List = new ArrayList<String>();
        List = TaughtCourses.CourseList();
       
        Course1.setLabel(List.get(0));
        Course2.setLabel(List.get(1));
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Course1 = new java.awt.Button();
        Course2 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Course1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Course1ActionPerformed(evt);
            }
        });
        getContentPane().add(Course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 119, 208, 66));

        Course2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Course2ActionPerformed(evt);
            }
        });
        getContentPane().add(Course2, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 331, 208, 66));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Course1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Course1ActionPerformed
        
        CODandCAVGUI CODCAV = new CODandCAVGUI(TaughtCourses.Teacher, Course1.getLabel());
        CODCAV.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Course1ActionPerformed

    private void Course2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Course2ActionPerformed
        
        CODandCAVGUI CODCAV = new CODandCAVGUI(TaughtCourses.Teacher, Course2.getLabel());
        CODCAV.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_Course2ActionPerformed

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
            java.util.logging.Logger.getLogger(CourseDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                //new CourseDisplayGUI().setVisible(true);
            //}
        //});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Course1;
    private java.awt.Button Course2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
