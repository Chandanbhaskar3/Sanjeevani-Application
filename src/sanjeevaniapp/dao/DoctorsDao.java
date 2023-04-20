 package sanjeevaniapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.DoctorPojo;

public class DoctorsDao {

    public static void updateName(String currName, String newName) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Update doctors set doctor_name=? where doctor_name=?");
        ps.setString(1, newName);
        ps.setString(2, currName);
        ps.executeUpdate();
    }

    public static boolean addDoctor(DoctorPojo doc) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into doctors values(?,?,?,?,?,?,?)");
        ps.setString(1, doc.getDoctorId());
        ps.setString(2, doc.getDoctorName());
        ps.setString(3, doc.getEmailId());
        ps.setString(4, doc.getContactNo());
        ps.setString(5, doc.getQualification());
        ps.setString(6, doc.getGender());
        ps.setString(7, doc.getSpecialist());
        return ps.executeUpdate() == 1;
    }

    public static String getNewDocId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(doctor_id) from doctors");
        rs.next();
        int docId = 101;
        String id = rs.getString(1);
        if (id != null) {
            String num = id.substring(3);
            docId = Integer.parseInt(num) + 1;
        }
        return "DOC" + docId;

    }
    // for delete doctors
    // to get doc id list in combobox

    public static List<String> getAllDoctorId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select doctor_id from doctors ");
        List<String> doctorList = new ArrayList<>();
        while (rs.next()) {
            doctorList.add(rs.getString(1));
        }
        return doctorList;
    }
    public static boolean deleteDoctorById(String docId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select doctor_name from doctors where doctor_id = ?");
         ps.setString(1,docId);
         ResultSet rs = ps.executeQuery();
         rs.next();
         String docName = rs.getString(1);
         UserDao.deleteUserByName(docName);
         ps = conn.prepareStatement("delete from doctors where doctor_id = ?");
         ps.setString(1, docId);
         return ps.executeUpdate() == 1; 
    }

    public static List<DoctorPojo> getAllDoctorDetails() throws SQLException {
       Connection conn = DBConnection.getConnection();
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery("select * from doctors order by doctor_id");
       List<DoctorPojo> docList = new ArrayList();
       while(rs.next()){
           DoctorPojo doc = new DoctorPojo();
           doc.setDoctorId(rs.getString(1));
           doc.setDoctorName(rs.getString(2));
           doc.setEmailId(rs.getString(3));
           doc.setContactNo(rs.getString( 4));
           doc.setQualification(rs.getString(5));
           doc.setGender(rs.getString(6));
           doc.setSpecialist(rs.getString(7));
           docList.add(doc);
        }
       return docList;
    }
 
    // to delete employee
    public static void deleteDoctorByName(String empName) throws  SQLException{
        Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("delete from doctors where doctor_id = ?");
         ps.setString(1, empName);
         ps.executeUpdate();
    }
    public static String getDoctorNameById(String docId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select doctor_name from doctors where doctor_id = ?");
        ps.setString(1,docId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getString(1);    
    }
}
