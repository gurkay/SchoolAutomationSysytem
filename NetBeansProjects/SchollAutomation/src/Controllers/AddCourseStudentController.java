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
public class AddCourseStudentController {
    private int addCourseStudentId;
    private int accountId;
    private int instructionOfCourseId;
    private short credit;

    public int getAddCourseStudentId() {
        return addCourseStudentId;
    }

    public void setAddCourseStudentId(int addCourseStudentId) {
        this.addCourseStudentId = addCourseStudentId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getInstructionOfCourseId() {
        return instructionOfCourseId;
    }

    public void setInstructionOfCourseId(int instructionOfCourseId) {
        this.instructionOfCourseId = instructionOfCourseId;
    }

    public short getCredit() {
        return credit;
    }

    public void setCredit(short credit) {
        this.credit = credit;
    }      
}
