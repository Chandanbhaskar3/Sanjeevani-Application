/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.ReceptionistPojo;
import sanjeevaniapp.pojo.UserPojo;
import sun.font.FontUtilities;
import sun.security.rsa.RSACore;

/**
 *
 * @author ck835
 */
 public class ReceptionistDao {
    //(1). to update employee and (2). to update receptionist
    public static void updateName(String currName,String newName)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update receptionists set receptionist_name=? where receptionist_name=?");
     ps.setString(1, newName);
     ps.setString(2, currName);
     ps.executeUpdate();
}
   // to delete employee and also used to delete receptionist 
   public  static void deleteReceptionistByName(String empName) throws SQLException{
      Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("delete from  receptionists where receptionist_id = ?");
         ps.setString(1, empName);
         ps.executeUpdate();   
    }
   
   // all receptonist work
   public static String getNewRecId() throws SQLException {
       Connection conn = DBConnection.getConnection();
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery("select max(receptionist_id) from receptionists");
       rs.next();
       int recId = 101;
       String id = rs.getString(1);
       if(id != null){
           String num = id.substring(3);
           recId = Integer.parseInt(num) + 1;
       }
       return "REC"+recId;
   }
   public static boolean addReceptionist(ReceptionistPojo recep) throws SQLException{
       Connection conn = DBConnection.getConnection();
       PreparedStatement ps = conn.prepareStatement("insert into receptionists values(?,?,?)");
       ps.setString(1,recep.getReceId());
       ps.setString(2, recep.getReceName());
       ps.setString(3, recep.getGender());
       return ps.executeUpdate() == 1;
   }
   
   public static List<ReceptionistPojo> getAllReceptionistDetails() throws SQLException{
       Connection conn = DBConnection.getConnection();
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery("select * from receptionists order by receptionist_id");
       List<ReceptionistPojo> recList = new ArrayList<>();
       while(rs.next()){
           ReceptionistPojo recep = new ReceptionistPojo();
           recep.setReceId(rs.getString(1));
           recep.setReceName(rs.getString(2));
           recep.setGender(rs.getString(3));
           recList.add(recep);
       }
       return recList;           
   }  
   
   public static List<String> getAllRecId() throws SQLException{
       Connection conn = DBConnection.getConnection();
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery("select receptionist_id from receptionists"); 
       List <String> recId = new ArrayList<>();
       while(rs.next()){
           recId.add(rs.getString(1));
       }
      return recId;
   }
   

    public static boolean deleteReceptionistById(String RecId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select receptionist_name from receptionists where receptionist_id = ?");
        ps.setString(1, RecId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String recepName = rs.getString(1);
        UserDao.deleteUserByRecName(recepName);
        ps = conn.prepareStatement("delete from receptionists where receptionist_id = ?");
        ps.setString(1, RecId);
        return ps.executeUpdate() == 1;
    }
    // update receptionistframe
    public static List<ReceptionistPojo> getAllReceptionistDetail() throws SQLException{
       Connection conn = DBConnection.getConnection();
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery("select * from receptionists order by receptionist_id");
       List<ReceptionistPojo> recList = new ArrayList<>();
       while(rs.next()){
           ReceptionistPojo recep = new ReceptionistPojo();
           recep.setReceId(rs.getString(1));
           recep.setReceName(rs.getString(2));
           recep.setGender(rs.getString(3));
           
           
           recList.add(recep);
       }
       return recList;           
   }
    public static ReceptionistPojo getReceptionistDetails(String recepId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from receptionists where receptionist_id = ?");
        ps.setString(1, recepId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        ReceptionistPojo recep = new ReceptionistPojo();
        recep.setReceName(rs.getString("receptionist_name"));
        recep.setGender(rs.getString("gender"));
        return recep;
    } 
    // updating receptionist by updatereceptionist frame
    public static boolean updateReceptionist(UserPojo user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set login_id = ? , password = ? where user_name = ?");
        ps.setString(1,user.getLoginId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserName());
        return ps.executeUpdate() == 1;
    }
     
    
    
}
