/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author gurkay
 */
public class InstructionOfCourseController extends CoursesController{
    private int instructionOfCourseId;
    private String courseCode;
    private int accountId;
    private int coursesId;

    public int getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(int coursesId) {
        this.coursesId = coursesId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public int getInstructionOfCourseId() {
        return instructionOfCourseId;
    }

    public void setInstructionOfCourseId(int instructionOfCourseId) {
        this.instructionOfCourseId = instructionOfCourseId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
