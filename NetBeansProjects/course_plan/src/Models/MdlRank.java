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
public class MdlRank extends MdlConnectionDB {
    public List<Object[]> selectRank(String query) {

        int columnCount;

        List<Object[]> rank = new ArrayList<Object[]>();

        try {
            Connection conn = openConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] header = {"rank_id", "rank_name", "status_id"};

                header[0] = rs.getInt("rank_id");
                header[1] = rs.getString("rank_name");
                header[2] = rs.getString("status_id");

                rank.add(header);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        }
        return rank;
    }    
}
