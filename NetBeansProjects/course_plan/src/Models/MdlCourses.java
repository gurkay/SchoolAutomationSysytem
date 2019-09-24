/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.CtrCourses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gurkay
 */
public class MdlCourses extends MdlConnectionDB{

    /**
     *
     * SELECT RECORD COURSES
     *
     * @param selectStatus query select
     * @param query record courses
     * @return
     */
    public List<Object[]> selectCourses(String selectStatus, String query) {

        int columnCount;

        List<Object[]> recordList = new ArrayList<>();

        try {
            Connection connection = openConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            switch (selectStatus) {
                case "recordCourses":
                    while (rs.next()) {
                        Object[] header = {"courses_id", "courses_name", "courses_code"};
                        header[0] = rs.getInt("courses_id");
                        header[1] = rs.getString("courses_name");
                        header[2] = rs.getString("courses_code");
                        recordList.add(header);
                    }
                    break;             
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.getStackTrace();
        }
        return recordList;
    }    
    /**
     *
     * RECORD COURSES
     *
     * @param ctrCourses
     */
    public void recordCourses(CtrCourses ctrCourses) {
        try {
            Connection connection = openConnection();

            String query = "INSERT INTO courses(courses_name, courses_code) VALUES(?, ?)";
            PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, ctrCourses.getCourses_name());
            pst.setString(2, ctrCourses.getCouses_code());
            pst.executeUpdate();
            pst.close();

            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * UPDATE COURSES
     *
     * @param ctrCourses update Courses
     */
    public void updateCourses(CtrCourses ctrCourses) {
        try {
            Connection connection = openConnection();

            String query = "UPDATE courses SET courses_name = ?, courses_code = ? WHERE courses_id = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, ctrCourses.getCourses_name());
            pst.setString(2, ctrCourses.getCouses_code());
            pst.setInt(3, ctrCourses.getCourses_id());
            pst.executeUpdate();
            pst.close();

            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }    
    /**
     *
     * DELETE COURSES
     *
     * @param courses_id delete Courses
     */
    public void deleteCourses(int courses_id) {
        try {
            Connection connection = openConnection();
            String query = "DELETE FROM courses c WHERE c.courses_id = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, courses_id);
            pst.executeUpdate();
            pst.close();
            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }      
}
