/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.CtrPersonal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gurkay
 */
public class MdlPersonal extends MdlConnectionDB {

    /**
     *
     * SELECT PERSONAL
     *
     * @param selectStatus query select
     * @param query record personal
     * @return
     */
    public List<Object[]> selectPersonal(String selectStatus, String query) {

        int columnCount;

        List<Object[]> personal = new ArrayList<>();

        try {
            Connection connection = openConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            switch (selectStatus) {
                case "recordPersonal":
                    while (rs.next()) {
                        Object[] header = {"pbik", "tc", "rank_name", "first_name", "last_name"};
                        header[0] = rs.getInt("pbik");
                        header[1] = rs.getString("tc");
                        header[2] = rs.getString("rank_name");
                        header[3] = rs.getString("first_name");
                        header[4] = rs.getString("last_name");
                        personal.add(header);
                    }
                    break;
                case "selectTablePersonal":
                    while (rs.next()) {
                        Object[] header = {"id", "pbik", "tc", "first_name", "last_name",
                            "class_name", "rank_name", "branch_name", "register", "register_date",
                            "task", "continent", "city_name", "status_name"};

                        header[0] = rs.getInt("id");
                        header[1] = rs.getInt("pbik");
                        header[2] = rs.getString("tc");
                        header[3] = rs.getString("first_name");
                        header[4] = rs.getString("last_name");
                        header[5] = rs.getString("class_name");
                        header[6] = rs.getString("rank_name");
                        header[7] = rs.getString("branch_name");
                        header[8] = rs.getString("register");
                        header[9] = rs.getShort("register_date");
                        header[10] = rs.getString("task");
                        header[11] = rs.getString("continent");
                        header[12] = rs.getString("city_name");
                        header[13] = rs.getString("status_name");
                        personal.add(header);
                    }
                    break;
                case "takeCoursePersonal":
                    while (rs.next()) {
                        Object[] header = {"pbik", "tc", "rank_name", "first_name", "last_name"};
                        header[0] = rs.getInt("pbik");
                        header[1] = rs.getString("tc");
                        header[2] = rs.getString("rank_name");
                        header[3] = rs.getString("first_name");
                        header[4] = rs.getString("last_name");
                        personal.add(header);
                    }
                    break;                    
                default:
                    while (rs.next()) {
                        Object[] header = {"id", "pbik", "tc", "first_name", "last_name",
                            "class_id", "rank_id", "branch_id", "register", "register_date",
                            "task", "continent", "city_id", "status_id"};

                        header[0] = rs.getInt("id");
                        header[1] = rs.getInt("pbik");
                        header[2] = rs.getString("tc");
                        header[3] = rs.getString("first_name");
                        header[4] = rs.getString("last_name");
                        header[5] = rs.getShort("class_id");
                        header[6] = rs.getShort("rank_id");
                        header[7] = rs.getShort("branch_id");
                        header[8] = rs.getString("register");
                        header[9] = rs.getShort("register_date");
                        header[10] = rs.getString("task");
                        header[11] = rs.getString("continent");
                        header[12] = rs.getShort("city_id");
                        header[13] = rs.getShort("status_id");
                        personal.add(header);
                    }                    
                    break;
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.getStackTrace();
        }
        return personal;
    }

    /**
     *
     * RECORD PERSONAL
     *
     * @param ctrPersonal
     */
    public void recordPersonal(CtrPersonal ctrPersonal) {
        try {
            Connection connection = openConnection();

            String query = "INSERT INTO personal(pbik, tc, first_name, last_name, class_id, rank_id, branch_id, register, task, continent, city_id, status_id, register_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, ctrPersonal.getPbik());
            pst.setString(2, ctrPersonal.getTc());
            pst.setString(3, ctrPersonal.getFirst_name());
            pst.setString(4, ctrPersonal.getLast_name());
            pst.setShort(5, ctrPersonal.getClass_id());
            pst.setShort(6, ctrPersonal.getRank_id());
            pst.setShort(7, ctrPersonal.getBranch_id());
            pst.setString(8, ctrPersonal.getRegister());
            pst.setString(9, ctrPersonal.getTask());
            pst.setString(10, ctrPersonal.getContinent());
            pst.setShort(11, ctrPersonal.getCity_id());
            pst.setShort(12, ctrPersonal.getStatus_id());
            pst.setShort(13, ctrPersonal.getRegister_date());
            pst.executeUpdate();
            pst.close();

            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * UPDATE PERSONAL
     *
     * @param ctrPersonal updatePersonal
     */
    public void updatePersonal(CtrPersonal ctrPersonal) {
        try {
            Connection connection = openConnection();

            String query = "UPDATE personal SET pbik = ?, tc = ?, first_name = ?, last_name = ?, class_id = ?, rank_id = ?, branch_id = ?, register = ?, task = ?, continent = ?, city_id = ?, status_id = ?, register_date = ? WHERE id = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, ctrPersonal.getPbik());
            pst.setString(2, ctrPersonal.getTc());
            pst.setString(3, ctrPersonal.getFirst_name());
            pst.setString(4, ctrPersonal.getLast_name());
            pst.setShort(5, ctrPersonal.getClass_id());
            pst.setShort(6, ctrPersonal.getRank_id());
            pst.setShort(7, ctrPersonal.getBranch_id());
            pst.setString(8, ctrPersonal.getRegister());
            pst.setString(9, ctrPersonal.getTask());
            pst.setString(10, ctrPersonal.getContinent());
            pst.setShort(11, ctrPersonal.getCity_id());
            pst.setShort(12, ctrPersonal.getStatus_id());
            pst.setShort(13, ctrPersonal.getRegister_date());
            pst.setInt(14, ctrPersonal.getId());
            pst.executeUpdate();
            pst.close();

            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }    
    /**
     *
     * DELETE PERSONAL
     *
     * @param ctrPersonal deletePersonal
     */
    public void deletePersonal(int id) {
        try {
            Connection connection = openConnection();
            String query = "DELETE FROM personal p WHERE p.id = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }  
}
