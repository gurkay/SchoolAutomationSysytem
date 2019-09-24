/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gurkay
 */
public class MdlBranch extends MdlConnectionDB{
    
    public List<Object[]> selectBranch(String query) {

        int columnCount;

        List<Object[]> branch = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] header = {"branch_id", "branch_name"};

                header[0] = rs.getInt("branch_id");
                header[1] = rs.getString("branch_name");

                branch.add(header);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        }
        return branch;
    }
}
