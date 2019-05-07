/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.AddCourseStudentController;
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
public class AddCourseStudentModel extends ConnectionDb {

    public List<Object[]> coursesOfStudentList(int accountID) {

        List<Object[]> instructorOfCourses = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            String query = "SELECT ioc.courses_code, c.courses_name, c.courses_credit, a.first_name, a.last_name "
                    + "FROM add_course_student acs "
                    + "JOIN instruction_of_course ioc ON acs.instruction_of_course_id = ioc.instruction_of_course_id "
                    + "JOIN account a ON a.account_id = ioc.account_id "
                    + "JOIN courses c ON ioc.courses_id = c.courses_id "
                    + "WHERE acs.account_id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, accountID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] header = {"courses_code", "courses_name", "courses_credit", "first_name", "last_name"};

                header[0] = rs.getString("courses_code");
                header[1] = rs.getString("courses_name");
                header[2] = rs.getShort("courses_credit");
                header[3] = rs.getString("first_name");
                header[4] = rs.getString("last_name");
                instructorOfCourses.add(header);
            }
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return instructorOfCourses;
    }
    
    public List<Object[]> coursesOfStudentListSelected(int instOfCourseID) {

        List<Object[]> coursesOfStudentList = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            String query = "SELECT acs.add_course_student_id ,ac.account_id, ac.first_name, ac.last_name, ioc.courses_code, c.courses_name, c.courses_credit, acs.midterm, acs.final " +
                            "FROM add_course_student acs " +
                            "JOIN instruction_of_course ioc ON acs.instruction_of_course_id = ioc.instruction_of_course_id " +
                            "JOIN account ac ON ac.account_id = acs.account_id " +
                            "JOIN courses c ON ioc.courses_id = c.courses_id " +
                            "WHERE acs.instruction_of_course_id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, instOfCourseID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] header = {"add_course_student_id", "account_id", "first_name", "last_name", "courses_code", "courses_name", "courses_credit", "midterm", "final"};

                header[0] = rs.getInt("add_course_student_id");
                header[1] = rs.getInt("account_id");
                header[2] = rs.getString("first_name");
                header[3] = rs.getString("last_name");
                header[4] = rs.getString("courses_code");
                header[5] = rs.getString("courses_name");
                header[6] = rs.getShort("courses_credit");
                header[7] = rs.getFloat("midterm");
                header[8] = rs.getFloat("final");
                coursesOfStudentList.add(header);
            }
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return coursesOfStudentList;
    }

    public List<Object[]> instructorOfCoursesFindRecord() {

        List<Object[]> instructorOfCourses = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            String query = "SELECT ioc.account_id, ioc.courses_code, c.courses_name, c.courses_credit, a.first_name, a.last_name,ioc.instruction_of_course_id  "
                    + "FROM instruction_of_course ioc "
                    + "JOIN account a ON a.account_id = ioc.account_id "
                    + "JOIN courses c ON ioc.courses_id = c.courses_id";

            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] header = {"account_id", "courses_code", "courses_name", "courses_credit", "first_name", "last_name", "instruction_of_course_id"};

                header[0] = rs.getInt("account_id");
                header[1] = rs.getString("courses_code");
                header[2] = rs.getString("courses_name");
                header[3] = rs.getShort("courses_credit");
                header[4] = rs.getString("first_name");
                header[5] = rs.getString("last_name");
                header[6] = rs.getString("instruction_of_course_id");
                instructorOfCourses.add(header);
            }
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return instructorOfCourses;
    }

    public void addCourseStudentRecord(AddCourseStudentController addCourseStudentController) {
        try {
            Connection conn = openConnection();

            String query = "INSERT INTO add_course_student(account_id, instruction_of_course_id, credit) VALUES(?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, addCourseStudentController.getAccountId());
            pst.setInt(2, addCourseStudentController.getInstructionOfCourseId());
            pst.setShort(3, addCourseStudentController.getCredit());

            pst.executeUpdate();
            pst.close();

            closeConnection();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void addCourseStudentPointRecord(AddCourseStudentController addCourseStudentController) {
        try {
            Connection conn = openConnection();

            String query = "INSERT INTO add_course_student(account_id, instruction_of_course_id, credit, midterm, final) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstAccount = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstAccount.setInt(1, addCourseStudentController.getAccountId());
            pstAccount.setInt(2, addCourseStudentController.getAddCourseStudentId());
            pstAccount.setInt(3, addCourseStudentController.getCredit());
            pstAccount.setFloat(4, addCourseStudentController.getMidterm());
            pstAccount.setFloat(5, addCourseStudentController.getFinalExam());

            pstAccount.executeUpdate();
            pstAccount.close();

            closeConnection();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void updateCourseStudentPointRecord(AddCourseStudentController addCourseStudentController) {
        try {
            Connection conn = openConnection();

            String query = "UPDATE add_course_student SET midterm = ?, final = ? WHERE add_course_student_id = ?";
            PreparedStatement pstAccount = conn.prepareStatement(query);

            
            pstAccount.setFloat(1, addCourseStudentController.getMidterm());
            pstAccount.setFloat(2, addCourseStudentController.getFinalExam());
            pstAccount.setInt(3, addCourseStudentController.getAddCourseStudentId());

            pstAccount.executeUpdate();
            pstAccount.close();

            closeConnection();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    public void deleteRecord(int accountID) {

        try {
            Connection conn = openConnection();
            String query = "DELETE FROM add_course_student acs WHERE acs.account_id = ?";
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

    public int isInstructionOfCourseID(String courseCode, String instructorFirstName, String instructorLastName) {

        InstructionOfCourseDbModel instructionOfCourseDbModel = new InstructionOfCourseDbModel();
        InstructionOfCourseController instructionOfCourseController = new InstructionOfCourseController();

        try {
            Connection conn = openConnection();
            String query = "SELECT ioc.account_id, ioc.courses_code, c.courses_name, c.courses_credit, a.first_name, a.last_name, ioc.instruction_of_course_id  "
                    + "FROM instruction_of_course ioc "
                    + "JOIN account a ON a.account_id = ioc.account_id "
                    + "JOIN courses c ON ioc.courses_id = c.courses_id "
                    + "WHERE ioc.courses_code = ? AND a.first_name = ? AND a.last_name = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, courseCode);
            pst.setString(2, instructorFirstName);
            pst.setString(3, instructorLastName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                instructionOfCourseController.setInstructionOfCourseId(rs.getInt("instruction_of_course_id"));
            }

            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return instructionOfCourseController.getInstructionOfCourseId();
    }
}
