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

import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.PatientPojo;

/**
 *
 * @author ck835
 */
public class PatientsDao {

    public static String getNewPatientId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(patient_id) from patients");
        rs.next();
        int patId = 101;
        String id = rs.getString(1);
        if (id != null) {
            String num = id.substring(3);
            patId = Integer.parseInt(num) + 1;
        }
        return "PAT" + patId;
    }

    public static boolean addPatient(PatientPojo pat) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into patients values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, pat.getPatientId());
        ps.setString(2, pat.getFirstName());
        ps.setString(3, pat.getLastName());
        ps.setInt(4, pat.getAge());
        ps.setString(5, pat.getGender());
        ps.setString(6, pat.getMarriedStatus());
        ps.setString(7, pat.getCity());
        ps.setString(8, pat.getMobileNo());
        ps.setDate(9, pat.getDate());
        ps.setInt(10, pat.getOtp());
        ps.setString(11, pat.getOpd());
        ps.setString(12, pat.getDoctorsId());
        ps.setString(13, pat.getAptStatus());
        ps.setString(14, pat.getAddress());
        return ps.executeUpdate() == 1;
    }

    public static List<PatientPojo> getAllPatientsDetails() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from patients order by patient_id");
        List<PatientPojo> patList = new ArrayList();
        while (rs.next()) {
            PatientPojo pat = new PatientPojo();
            pat.setPatientId(rs.getString("patient_id"));
            pat.setFirstName(rs.getString("first_name"));
            pat.setLastName(rs.getString("last_name"));
            pat.setAddress(rs.getString("address"));
            pat.setAptStatus(rs.getString("status"));
            pat.setMarriedStatus(rs.getString("m_status"));
            pat.setOpd(rs.getString("opd"));
            pat.setDate(rs.getDate("p_date"));
            pat.setMobileNo(rs.getString("mobile_no"));
            pat.setCity(rs.getString("city"));
            pat.setDoctorsId(rs.getString("doctor_id"));
            pat.setAge(rs.getInt("age"));
            pat.setGender(rs.getString("gender"));
            patList.add(pat);
        }
        return patList;
    }

    public static List<PatientPojo> getAllPatientsByDoctorId(String doctorId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from patients where doctor_id = ? and status = 'REQUEST' order by patient_id");
        ps.setString(1, doctorId);
        ResultSet rs = ps.executeQuery();
        List<PatientPojo> patList = new ArrayList();
        while (rs.next()) {
            PatientPojo pat = new PatientPojo();
            pat.setPatientId(rs.getString("patient_id"));
            pat.setFirstName(rs.getString("first_name") + " " + rs.getString("last_name"));
            pat.setOpd(rs.getString("opd"));
            pat.setDate(rs.getDate("p_date"));
            patList.add(pat);
        }
        return patList;
    }
    
    public static boolean updateStatus(String patientId) throws SQLException{
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("update patients set status = 'CONFIRM' where patient_id = ?");
     ps.setString(1,patientId);
     return ps.executeUpdate() == 1;
      
        
 }
    public static List<String> getAllPatientId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select patient_id from patients ");
        List<String> patIdList = new ArrayList<>();
        while(rs.next()){
            patIdList.add(rs.getString(1));
        }
        return patIdList;
        
    }
    
    public static PatientPojo patientDetails(String patId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from patients where patient_id = ?");
        ps.setString(1, patId);
        ResultSet rs = ps.executeQuery();
       rs.next();
            PatientPojo pt = new PatientPojo();
             
            pt.setFirstName(rs.getString(2));
            pt.setLastName(rs.getString(3));
            pt.setAge(rs.getInt(4));
            pt.setGender(rs.getString(5));
            pt.setMarriedStatus(rs.getString(6));
            pt.setCity(rs.getString(7));
            pt.setMobileNo(rs.getString(8));
            pt.setDate(rs.getDate(9));
            pt.setOpd(rs.getString(11));
            pt.setDoctorsId(rs.getString(12));
            pt.setAddress(rs.getString(14));
            
        return pt;
        
        
    }
    public static boolean updatePatient(PatientPojo emp) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update patients set first_name = ?,last_name = ?,address = ?,city = ?, opd = ?, mobile_no = ? where patient_id = ?");
        
        ps.setString(1, emp.getFirstName());
        ps.setString(2,emp.getLastName());
        ps.setString(3, emp.getAddress());
        ps.setString(4, emp.getCity());
        ps.setString(5, emp.getOpd());
        ps.setString(6, emp.getMobileNo());
        ps.setString(7, emp.getPatientId());
        return ps.executeUpdate() == 1;
    }
    
    public static boolean deletePatientById(String patId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from patients where patient_id = ?");
        ps.setString(1, patId);
        return ps.executeUpdate() == 1;
    }

}
