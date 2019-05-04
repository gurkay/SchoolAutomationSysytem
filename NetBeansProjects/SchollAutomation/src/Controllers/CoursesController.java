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
public class CoursesController {

    private int coursesId;
    private String coursesName;
    private String coursesCode;
    private short coursesCredit;

    public String getCoursesCode() {
        return coursesCode;
    }

    public void setCoursesCode(String coursesCode) {
        this.coursesCode = coursesCode;
    }

    public int getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(int coursesId) {
        this.coursesId = coursesId;
    }

    public String getCoursesName() {
        return coursesName;
    }

    public void setCoursesName(String coursesName) {
        this.coursesName = coursesName;
    }

    public short getCoursesCredit() {
        return coursesCredit;
    }

    public void setCoursesCredit(short coursesCredit) {
        this.coursesCredit = coursesCredit;
    }

}
