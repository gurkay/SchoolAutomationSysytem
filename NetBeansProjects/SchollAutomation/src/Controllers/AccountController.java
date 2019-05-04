/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.math.BigInteger;
import java.sql.Date;

/**
 *
 * @author gurkay
 */
public class AccountController {

    private int accountId;
    private String userName;
    private String password;
    private Date createdOn;
    private Date lastLogin;
    private String tc;
    private String firstName;
    private String lastName;
    private short age;
    private String gender;
    private String year;
    private ContactController contactController;
    private FamilyInfoController familyInfoController;
    private AccountRoleController accountRoleController;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public int getAccount_id() {
        return accountId;
    }

    public void setAccount_id(int accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ContactController getContactController() {
        return contactController;
    }

    public void setContactController(ContactController contactController) {
        this.contactController = contactController;
    }

    public FamilyInfoController getFamilyInfoController() {
        return familyInfoController;
    }

    public void setFamilyInfoController(FamilyInfoController familyInfoController) {
        this.familyInfoController = familyInfoController;
    }

    public AccountRoleController getAccountRoleController() {
        return accountRoleController;
    }

    public void setAccountRoleController(AccountRoleController accountRoleController) {
        this.accountRoleController = accountRoleController;
    }
}
