/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.InstructionOfCourseController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author gurkay
 */
public class AddCourseStudentModel extends ConnectionDb{
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
}
