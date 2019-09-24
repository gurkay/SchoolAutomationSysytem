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
public class CtrPersonal {
    
    private int id;
    private int pbik;
    private String tc;
    private String first_name;
    private String last_name;
    private Short class_id;
    private Short rank_id;
    private Short branch_id;
    private String register;
    private Short register_date;
    private String task;
    private String continent;
    private short city_id;
    private short status_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPbik() {
        return pbik;
    }

    public void setPbik(int pbik) {
        this.pbik = pbik;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Short getClass_id() {
        return class_id;
    }

    public void setClass_id(Short class_id) {
        this.class_id = class_id;
    }

    public Short getRank_id() {
        return rank_id;
    }

    public void setRank_id(Short rank_id) {
        this.rank_id = rank_id;
    }

    public Short getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Short branch_id) {
        this.branch_id = branch_id;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public short getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Short register_date) {
        this.register_date = register_date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public short getCity_id() {
        return city_id;
    }

    public void setCity_id(short city_id) {
        this.city_id = city_id;
    }

    public short getStatus_id() {
        return status_id;
    }

    public void setStatus_id(short status_id) {
        this.status_id = status_id;
    }
    
}
