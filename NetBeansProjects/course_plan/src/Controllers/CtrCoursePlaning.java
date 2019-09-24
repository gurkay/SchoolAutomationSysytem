/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.Date;

/**
 *
 * @author gurkay
 */
public class CtrCoursePlaning {
    private int course_planing_id;
    private Short courses_id;
    private Date begin_date;
    private Date end_date;

    public int getCourse_planing_id() {
        return course_planing_id;
    }

    public void setCourse_planing_id(int course_planing_id) {
        this.course_planing_id = course_planing_id;
    }

    public Short getCourses_id() {
        return courses_id;
    }

    public void setCourses_id(Short courses_id) {
        this.courses_id = courses_id;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

}
