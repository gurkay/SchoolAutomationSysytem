/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.AddCourseStudentController;
import Controllers.CoursesController;
import Controllers.InstructionOfCourseController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gurkay
 */
public class CoursesDbModel extends ConnectionDb {

    public void coursesRecord(CoursesController coursesController) {
        try {
            Connection conn = openConnection();

            String query = "INSERT INTO courses(courses_name, courses_credit, courses_code) VALUES(?, ?, ?)";
            PreparedStatement pstAccount = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstAccount.setString(1, coursesController.getCoursesName());
            pstAccount.setInt(2, coursesController.getCoursesCredit());
            pstAccount.setString(3, coursesController.getCoursesCode());

            pstAccount.executeUpdate();
            pstAccount.close();

            closeConnection();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public List<Object[]> coursesShowAllRecord() {

        List<Object[]> courses = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            String query = "SELECT c.courses_id, c.courses_name, c.courses_credit, c.courses_code FROM courses c ";

            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] header = {"courses_id", "courses_name", "courses_credit", "courses_code"};

                header[0] = rs.getInt("courses_id");
                header[1] = rs.getString("courses_name");
                header[2] = rs.getShort("courses_credit");
                header[3] = rs.getString("courses_code");
                courses.add(header);
            }
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return courses;
    }

    public int coursesIDFind(String courses_code) {
        CoursesController coursesController = new CoursesController();

        try {
            Connection conn = openConnection();
            String query = "SELECT c.courses_id FROM courses c WHERE c.courses_code = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, courses_code);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                coursesController.setCoursesId(rs.getInt("courses_id"));
            }

            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return coursesController.getCoursesId();
    }

    public void updateCourseRecord(CoursesController coursesController) {
        try {
            Connection conn = openConnection();

            String query = "UPDATE courses SET courses_name = ?, courses_credit = ?, courses_code = ? WHERE courses_id = ?";
            PreparedStatement pstAccount = conn.prepareStatement(query);

            pstAccount.setString(1, coursesController.getCoursesName());
            pstAccount.setShort(2, coursesController.getCoursesCredit());
            pstAccount.setString(3, coursesController.getCoursesCode());
            pstAccount.setInt(4, coursesController.getCoursesId());

            pstAccount.executeUpdate();
            pstAccount.close();

            closeConnection();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
