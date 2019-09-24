/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gurkay
 */
public class MdlCity extends MdlConnectionDB {

    public List<Object[]> selectCity(String query) {

        int columnCount;

        List<Object[]> city = new ArrayList<>();

        try {
            Connection connection = openConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] header = {"city_id", "city_name", "city_code"};

                header[0] = rs.getInt("city_id");
                header[1] = rs.getString("city_name");
                header[2] = rs.getString("city_code");

                city.add(header);
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.getStackTrace();
        }
        return city;
    }

}
