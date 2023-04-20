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
import java.util.ArrayList;
import java.util.List;
import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.AppointmentPojo;
import sanjeevaniapp.pojo.PatientPojo;

 
public class AppointmentDao {
    public static boolean addAppointment(AppointmentPojo appt)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into appointments values(?,?,?,?,?,?,?)");
        ps.setString(1,appt.getPatientId());
        ps.setString(2, appt.getPatientName());
        ps.setString(3, appt.getStatus());
        ps.setString(4, appt.getOpd());
        ps.setString(5, appt.getAppointmentDate());
        ps.setString(6, appt.getDoctorName());
        ps.setString(7, appt.getMobileNo());
        return ps.executeUpdate() == 1;
    }
    
    public static List< AppointmentPojo> getAllAppointmentsByDoctorName(String doctorName) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from appointments where doctor_name = ? and status = 'REQUEST' order by patient_id");
        ps.setString(1,doctorName);
        ResultSet rs = ps.executeQuery();
        List<AppointmentPojo> aptList = new ArrayList();
        while (rs.next()) {
            AppointmentPojo  apt = new  AppointmentPojo();
            apt.setPatientId(rs.getString("patient_id"));
            apt.setPatientName(rs.getString("patient_name"));
            apt.setAppointmentDate(rs.getString("date_time"));
            apt.setOpd(rs.getString("opd"));
            apt.setStatus(rs.getString("status"));
            aptList.add(apt);
            
        }
        return  aptList;
    }
    
    public static boolean updateStatusAndTime(AppointmentPojo apt) throws SQLException{
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("update appointments set status = ?,date_time = ? where patient_id = ?");
     ps.setString(1,apt.getStatus());
     ps.setString(2, apt.getAppointmentDate());
     ps.setString(3, apt.getPatientId());
     
     return ps.executeUpdate() == 1;
      
        
 }
    
    // also delete from appointments when we delete from patient
    public static boolean deletePatientFromAppointment(String patId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from appointments where patient_id = ?");
        ps.setString(1, patId);
        return ps.executeUpdate() == 1;
    }
    public static boolean updateStatus(AppointmentPojo apt) throws SQLException{
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("update appointments set status = ? where patient_id = ?");
     ps.setString(1,apt.getStatus());
     ps.setString(2, apt.getPatientId());
      return ps.executeUpdate() == 1;
    } 
    
     public static List< AppointmentPojo> getConfirmedAppointmentsByDoctorName(String doctorName) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from appointments where doctor_name = ? and status = 'CONFIRM' order by patient_id");
        ps.setString(1,doctorName);
        ResultSet rs = ps.executeQuery();
        List<AppointmentPojo> aptList = new ArrayList();
        while (rs.next()) {
            AppointmentPojo  apt = new  AppointmentPojo();
            apt.setPatientId(rs.getString("patient_id"));
            apt.setPatientName(rs.getString("patient_name"));
            apt.setAppointmentDate(rs.getString("date_time"));
            apt.setOpd(rs.getString("opd"));
            apt.setStatus(rs.getString("status"));
            aptList.add(apt);
            
        }
        return  aptList;
    }
} 