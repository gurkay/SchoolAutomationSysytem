/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.AccountController;
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
public class InstructionOfCourseDbModel extends ConnectionDb {

    public void instructionOfCourseRecord(InstructionOfCourseController instructionOfCourseController) {
        try {
            Connection conn = openConnection();

            String query = "INSERT INTO instruction_of_course(courses_code, account_id, courses_id) VALUES(?, ?, ?)";
            PreparedStatement pstAccount = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstAccount.setString(1, instructionOfCourseController.getCourseCode());
            pstAccount.setInt(2, instructionOfCourseController.getAccountId());
            pstAccount.setInt(3, instructionOfCourseController.getCoursesId());

            pstAccount.executeUpdate();
            pstAccount.close();

            closeConnection();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public List<Object[]> instructorOfCoursesShowAllRecord() {

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

    public List<Object[]> instructorOfCoursesFindRecord(int accountID) {

        List<Object[]> instructorOfCourses = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            String query = "SELECT c.courses_name, c.courses_credit, c.courses_code "
                    + "FROM instruction_of_course ioc "
                    + "JOIN courses c ON c.courses_code = ioc.courses_code "
                    + "WHERE ioc.account_id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, accountID);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] header = {"courses_name", "courses_credit", "courses_code"};

                header[0] = rs.getString("courses_name");
                header[1] = rs.getShort("courses_credit");
                header[2] = rs.getString("courses_code");
                instructorOfCourses.add(header);
            }
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return instructorOfCourses;
    }
    
    public List<Object[]> instOfCoursesFindRecord(int accountID) {

        List<Object[]> instructorOfCourses = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            String query = "SELECT ioc.instruction_of_course_id, c.courses_name, c.courses_credit, c.courses_code "
                    + "FROM instruction_of_course ioc "
                    + "JOIN courses c ON c.courses_code = ioc.courses_code "
                    + "WHERE ioc.account_id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, accountID);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] header = {"instruction_of_course_id", "courses_name", "courses_credit", "courses_code"};

                header[0] = rs.getString("instruction_of_course_id");
                header[1] = rs.getString("courses_name");
                header[2] = rs.getShort("courses_credit");
                header[3] = rs.getString("courses_code");
                instructorOfCourses.add(header);
            }
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return instructorOfCourses;
    }

    public List<Object[]> instructorOfCoursesFindRecord(AccountController accountController) {

        List<Object[]> instructorOfCourses = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            String query = "SELECT ioc.account_id, ioc.courses_code, c.courses_name, c.courses_credit, a.first_name, a.last_name, ioc.instruction_of_course_id "
                    + "FROM instruction_of_course ioc "
                    + "JOIN account a ON a.account_id = ioc.account_id "
                    + "JOIN courses c ON ioc.courses_id = c.courses_id";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, accountController.getAccountId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] header = {"courses_name", "courses_credit", "courses_code"};

                header[0] = rs.getString("courses_name");
                header[1] = rs.getShort("courses_credit");
                header[2] = rs.getString("courses_code");
                instructorOfCourses.add(header);
            }
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return instructorOfCourses;
    }
    

    
    public void deleteRecord(int accountID) {

        try {
            Connection conn = openConnection();
            String query = "DELETE FROM instruction_of_course ioc WHERE ioc.account_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, accountID);
            pst.executeUpdate();
            pst.close();
            closeConnection();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public int isAccountIDRecord(int accountID) {
        InstructionOfCourseController instructionOfCourseController = new InstructionOfCourseController();

        try {
            Connection conn = openConnection();
            String query = "SELECT ioc.account_id FROM instruction_of_course ioc WHERE ioc.account_id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, accountID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                instructionOfCourseController.setAccountId(rs.getInt("account_id"));
            }

            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return instructionOfCourseController.getAccountId();
    }
}
