 
package sanjeevaniapp.gui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import sanjeevaniapp.dao.DoctorsDao;

 
import sanjeevaniapp.dao.EmpDao;
import sanjeevaniapp.dao.UserDao;
import sanjeevaniapp.pojo.DoctorPojo;
import sanjeevaniapp.pojo.UserPojo;
import sanjeevaniapp.utility.PasswordEncryption;
public class RegisterDoctorsFrame extends javax.swing.JFrame {

    private Map<String,String>unRegDocList;
    private String selEmpId,selEmpName;
    private String pwd1,pwd2;
    private String logId,contactNo,qualification,emailId,specialist;
    public RegisterDoctorsFrame() {
        initComponents();
        unRegDocList = new HashMap<>();
        loadDoctorDetails();
        genNewDocId();
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcEmployeeId = new javax.swing.JComboBox<>();
        txtDocName = new javax.swing.JTextField();
        txtLoginId = new javax.swing.JTextField();
        jcGender = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDocId = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtQualification = new javax.swing.JTextField();
        txtSpecialist = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        txtPwd1 = new javax.swing.JPasswordField();
        txtPwd2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel16.setText("Sanjeevani Application");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 470, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesSanjeevani/HomePageBG1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setText("Add Doctor Frame");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 340, 50));

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Doctor's Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 830, 410));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesSanjeevani/images (2).jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, 250, 280));

        btnRegister.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(849, 700, 240, 40));

        jButton2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 770, 110, 30));

        jButton3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 770, -1, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Employee ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, 60));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Doctor Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, 50));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("Login ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 80, 40));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 678, 90, 30));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Retype Password");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 730, 150, 30));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("Gender");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, 100, 30));

        jcEmployeeId.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jcEmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEmployeeIdActionPerformed(evt);
            }
        });
        jPanel1.add(jcEmployeeId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 200, 30));

        txtDocName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtDocName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtDocName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 570, 200, 30));

        txtLoginId.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel1.add(txtLoginId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, 200, 30));

        jcGender.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jcGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", "OTHERS", " " }));
        jPanel1.add(jcGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 780, 200, 30));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setText("Doctor Id");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, 110, 50));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setText("Contact No.");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 570, 100, 40));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setText("Qualification");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, 100, 30));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setText("Specialist");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 670, 100, 30));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setText("Email ID");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 720, 90, 40));

        txtDocId.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel1.add(txtDocId, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, 210, 30));

        txtContactNo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel1.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 570, 210, 30));

        txtQualification.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel1.add(txtQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 620, 210, 30));

        txtSpecialist.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel1.add(txtSpecialist, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 670, 210, 30));

        txtEmailId.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel1.add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 720, 210, 30));
        jPanel1.add(txtPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 670, 200, 30));
        jPanel1.add(txtPwd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 722, 200, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if(validateInputs() == false){
            JOptionPane.showMessageDialog(null,"Please input all the fields");
        return;
        }
        String passwordValid = matchPassword();
        if(passwordValid != null){
            JOptionPane.showMessageDialog(null,passwordValid);
            return ;
        }
      
      if(pwd1.equalsIgnoreCase(pwd2))
      {
          JOptionPane.showMessageDialog(null,"Password matched");
      }
      else
      {
          JOptionPane.showMessageDialog(null,"Password doesnt match");
      }
        if(isContactValid() == false){
            JOptionPane.showMessageDialog(null,"INvalid mobile no");
            return ;
        }
        try{
            DoctorPojo doc = new DoctorPojo();
            doc.setContactNo(txtContactNo.getText());
            doc.setDoctorId(txtDocId.getText());
            doc.setDoctorName(selEmpName);
            doc.setEmailId(emailId);
            doc.setGender(jcGender.getSelectedItem().toString());
            doc.setSpecialist(specialist);
            doc.setQualification(qualification);
            UserPojo user = new UserPojo();
            user.setLoginId(logId);
            String encPassword = new String (PasswordEncryption.getEncryptedPassword(pwd1));
            user.setPassword(encPassword);
            user.setUserName(selEmpName);
            user.setUserType("DOCTOR");
            boolean result1 = DoctorsDao.addDoctor(doc);
            boolean result2 = UserDao.addUser(user);
            if(result1 == true && result2 == true){
                JOptionPane.showMessageDialog(null, "Doctor successfully registered!!");
                clearAll();
                return;
            }
            JOptionPane.showMessageDialog(null, "Registration unsuccessfull!!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error in DB:"+ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ManageDoctorFrame fr = new ManageDoctorFrame();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         LoginFrame fr = new LoginFrame();
         fr.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtDocNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocNameActionPerformed

    private void jcEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEmployeeIdActionPerformed
         if(jcEmployeeId.getSelectedIndex() == -1)
             return;
         selEmpId = jcEmployeeId.getSelectedItem().toString();
         selEmpName = unRegDocList.get(selEmpId);
         txtDocName.setText(selEmpName);
    }//GEN-LAST:event_jcEmployeeIdActionPerformed

     
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterDoctorsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcEmployeeId;
    private javax.swing.JComboBox<String> jcGender;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtDocId;
    private javax.swing.JTextField txtDocName;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtLoginId;
    private javax.swing.JPasswordField txtPwd1;
    private javax.swing.JPasswordField txtPwd2;
    private javax.swing.JTextField txtQualification;
    private javax.swing.JTextField txtSpecialist;
    // End of variables declaration//GEN-END:variables

    private void genNewDocId() {
         try {
              String docId = DoctorsDao.getNewDocId();
              txtDocId.setText(docId);
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error in DB :RegisterDoctorsFrame"+e);
             e.printStackTrace();
        }
    }

    private void loadDoctorDetails() {
         try{
             unRegDocList = EmpDao.getUnRegisteredDoctors();
             Set <String> empIdSet = unRegDocList.keySet();
             for(String empId : empIdSet)
                 jcEmployeeId.addItem(empId);
         }
         catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in DB :RegisterDoctorsFrame"+ex); 
             ex.printStackTrace();
         } 
    }
    private boolean validateInputs(){
        logId = txtLoginId.getText().trim();
        char [] p1 = txtPwd1.getPassword();
        char [] p2 = txtPwd2.getPassword();
        contactNo = txtContactNo.getText().trim();
        qualification = txtQualification.getText().trim();
        emailId = txtEmailId.getText().trim();
        specialist = txtSpecialist.getText().trim();
        if(logId.isEmpty() || p1.length == 0 || p2.length == 0 || contactNo.isEmpty() || qualification.isEmpty() || specialist.isEmpty() || emailId.isEmpty())
            return false;
        pwd1 = String.valueOf(p1);
        pwd2 = String.valueOf(p2);
        System.out.println("pw1 "+pwd1);
        System.out.println("pw2 "+pwd2);
        return true;   
    }
    
    private String matchPassword(){
        pwd1 = pwd1.trim();
        pwd2 = pwd2.trim();
        if(pwd1.length() < 3 || pwd2.length() < 3)
            return "Password must be greater than 3 characters in length";
       else if(pwd1.equals(pwd2) == false)
            return "Password doesn't match";
        else
        return null;
    }
    private boolean isContactValid(){
        char [] mob = contactNo.toCharArray();
        for(char ch : mob){
            if(Character.isDigit(ch) == false)
                return false;
        }
        if(contactNo.length() == 10)
            return true;
        return false;
    }
    private void clearAll(){
        txtContactNo.setText("");
        txtEmailId.setText("");
        txtLoginId.setText("");
        txtPwd1.setText("");
        txtSpecialist.setText("");
        txtPwd2.setText("");
        txtDocId.setText("");
        txtDocName.setText("");
        txtQualification.setText("");
        unRegDocList.remove(selEmpId);
        jcEmployeeId.removeItem(selEmpId);
        if(unRegDocList.size() == 0){
            JOptionPane.showMessageDialog(null,"All doctors registered!!");
       
        
        }
        
    }
}
