/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Controllers.AccountController;
import Controllers.AccountRoleController;
import Controllers.ContactController;
import Controllers.FamilyInfoController;

/**
 *
 * @author gurkay
 */
public class DatabaseModel extends ConnectionDb {

    public void accountRecord(AccountController accountController, AccountRoleController accountRoleController, FamilyInfoController familyInfoController,
            ContactController contactController) {
        try {
            Connection conn = openConnection();

            String queryAccount = "INSERT INTO account(user_name, password, create_on, last_login, tc, first_name, last_name, age, gender, year) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstAccount = conn.prepareStatement(queryAccount, Statement.RETURN_GENERATED_KEYS);
            pstAccount.setString(1, accountController.getUserName());
            pstAccount.setString(2, accountController.getPassword());
            pstAccount.setDate(3, accountController.getCreatedOn());
            pstAccount.setDate(4, accountController.getLastLogin());
            pstAccount.setString(5, accountController.getTc());
            pstAccount.setString(6, accountController.getFirstName());
            pstAccount.setString(7, accountController.getLastName());
            pstAccount.setShort(8, accountController.getAge());
            pstAccount.setString(9, accountController.getGender());
            pstAccount.setString(10, accountController.getYear());
            pstAccount.executeUpdate();
            pstAccount.close();

            String queryFamilyInfo = "INSERT INTO family_info(account_id, mother_name, mother_job, father_name, father_job) VALUES((SELECT MAX(account_id) FROM account), ?, ?, ?, ?)";
            PreparedStatement pstFamilyInfo = conn.prepareStatement(queryFamilyInfo, Statement.RETURN_GENERATED_KEYS);
            pstFamilyInfo.setString(1, familyInfoController.getMotherName());
            pstFamilyInfo.setString(2, familyInfoController.getMotherJob());
            pstFamilyInfo.setString(3, familyInfoController.getFatherName());
            pstFamilyInfo.setString(4, familyInfoController.getFatherJob());
            pstFamilyInfo.executeUpdate();
            pstFamilyInfo.close();

            String queryContact = "INSERT INTO contact(account_id, phone_number, mail, address) VALUES((SELECT MAX(account_id) FROM account), ?, ?, ?)";
            PreparedStatement pstContact = conn.prepareStatement(queryContact, Statement.RETURN_GENERATED_KEYS);
            pstContact.setString(1, contactController.getPhoneNumber());
            pstContact.setString(2, contactController.getMail());
            pstContact.setString(3, contactController.getAddress());
            pstContact.executeUpdate();
            pstContact.close();

            String queryAccountRole = "INSERT INTO account_role(account_id, role_id, grant_date) VALUES((SELECT MAX(account_id) FROM account), ?, ?)";
            PreparedStatement pstAccountRole = conn.prepareStatement(queryAccountRole);
            pstAccountRole.setInt(1, accountRoleController.getRoleID());
            pstAccountRole.setDate(2, accountRoleController.getGrantDate());
            pstAccountRole.executeUpdate();
            pstAccountRole.close();

            closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Object[]> accountShowAllRecord() {
        int columnCount;

        List<Object[]> accounts = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            String query = "SELECT a.account_id, a.tc, a.user_name, a.first_name, a.last_name, rl.role_name FROM account a, account_role ar, role rl WHERE a.account_id = ar.account_id AND ar.role_id = rl.role_id";

            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Object[] header = {"accountID", "tc", "user_name", "first_name", "last_name", "role_name"};

                header[0] = rs.getInt("account_id");
                header[1] = rs.getInt("tc");
                header[2] = rs.getString("user_name");
                header[3] = rs.getString("first_name");
                header[4] = rs.getString("last_name");
                header[5] = rs.getString("role_name");
                accounts.add(header);
            }
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return accounts;
    }

    public List<Object[]> accountInstructorShowAllRecord() {
        int columnCount;

        List<Object[]> accounts = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            String query = "SELECT a.account_id, a.tc, a.user_name, a.first_name, a.last_name, rl.role_name "
                    + "FROM account a "
                    + "JOIN account_role ar ON a.account_id = ar.account_id "
                    + "JOIN role rl ON ar.role_id = rl.role_id "
                    + "WHERE ar.role_id = 4";

            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] header = {"accountID", "tc", "user_name", "first_name", "last_name", "role_name"};

                header[0] = rs.getInt("account_id");
                header[1] = rs.getInt("tc");
                header[2] = rs.getString("user_name");
                header[3] = rs.getString("first_name");
                header[4] = rs.getString("last_name");
                header[5] = rs.getString("role_name");
                accounts.add(header);
            }
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return accounts;
    }

    public AccountController accountFind(int tc) {
        AccountController accountController = new AccountController();
        FamilyInfoController familyInfoController = new FamilyInfoController();
        ContactController contactController = new ContactController();
        try {
            Connection conn = openConnection();
            String query = "SELECT * FROM account a, account_role ar, role r, family_info f, contact c "
                    + "WHERE a.account_id = ar.account_id "
                    + "AND ar.role_id = r.role_id " + "AND a.account_id = f.account_id "
                    + "AND a.account_id = c.account_id " + "AND a.tc = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, tc);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                accountController.setAccountId(rs.getInt("account_id"));
                accountController.setUserName(rs.getString("user_name"));
                accountController.setPassword(rs.getString("password"));
                accountController.setTc(rs.getString("tc"));

                accountController.setFirstName(rs.getString("first_name"));
                accountController.setLastName(rs.getString("last_name"));
                accountController.setAge(rs.getShort("age"));
                accountController.setGender(rs.getString("gender"));

                familyInfoController.setMotherName(rs.getString("mother_name"));
                familyInfoController.setMotherJob(rs.getString("mother_job"));
                familyInfoController.setFatherName(rs.getString("father_name"));
                familyInfoController.setFatherJob(rs.getString("father_job"));
                accountController.setFamilyInfoController(familyInfoController);

                contactController.setPhoneNumber(rs.getString("phone_number"));
                contactController.setMail(rs.getString("mail"));
                contactController.setAddress(rs.getString("address"));
                accountController.setContactController(contactController);
            }

            pst.close();
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return accountController;
    }
    
    public AccountController accountIDFind(int accountID) {
        AccountController accountController = new AccountController();
        FamilyInfoController familyInfoController = new FamilyInfoController();
        ContactController contactController = new ContactController();
        try {
            Connection conn = openConnection();
            String query = "SELECT * FROM account a, account_role ar, role r, family_info f, contact c "
                    + "WHERE a.account_id = ar.account_id "
                    + "AND ar.role_id = r.role_id " + "AND a.account_id = f.account_id "
                    + "AND a.account_id = c.account_id " + "AND a.account_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, accountID);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                accountController.setAccountId(rs.getInt("account_id"));
                accountController.setUserName(rs.getString("user_name"));
                accountController.setPassword(rs.getString("password"));
                accountController.setTc(rs.getString("tc"));

                accountController.setFirstName(rs.getString("first_name"));
                accountController.setLastName(rs.getString("last_name"));
                accountController.setAge(rs.getShort("age"));
                accountController.setGender(rs.getString("gender"));

                familyInfoController.setMotherName(rs.getString("mother_name"));
                familyInfoController.setMotherJob(rs.getString("mother_job"));
                familyInfoController.setFatherName(rs.getString("father_name"));
                familyInfoController.setFatherJob(rs.getString("father_job"));
                accountController.setFamilyInfoController(familyInfoController);

                contactController.setPhoneNumber(rs.getString("phone_number"));
                contactController.setMail(rs.getString("mail"));
                contactController.setAddress(rs.getString("address"));
                accountController.setContactController(contactController);
            }

            pst.close();
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return accountController;
    }

    public AccountController accountLoginFind(int account_id, String password) {
        AccountController accountController = new AccountController();
        AccountRoleController accountRoleController = new AccountRoleController();
        try {
            Connection conn = openConnection();
            String query = "SELECT * FROM account a, account_role ar, role r "
                    + "WHERE a.account_id = ar.account_id "
                    + "AND ar.role_id = r.role_id "
                    + "AND a.account_id = ? AND a.password = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, account_id);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                accountController.setAccount_id(rs.getInt("account_id"));
                accountController.setUserName(rs.getString("user_name"));
                accountController.setPassword(rs.getString("password"));
                accountController.setTc(rs.getString("tc"));

                accountRoleController.setRoleID(rs.getInt("role_id"));
                accountController.setAccountRoleController(accountRoleController);
            }

            pst.close();
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return accountController;
    }

    public void accountDelete(int tc) {

        try {
            Connection conn = openConnection();
            String query = "DELETE FROM account a WHERE a.tc = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, tc);
            pst.executeUpdate();
            pst.close();
            closeConnection();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
