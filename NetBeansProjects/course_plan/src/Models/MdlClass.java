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
public class MdlClass extends MdlConnectionDB{
    
    public List<Object[]> selectClass(String query) {

        int columnCount;

        List<Object[]> classSolder = new ArrayList<>();

        try {
            Connection connection = openConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] header = {"class_id", "class_name"};

                header[0] = rs.getInt("class_id");
                header[1] = rs.getString("class_name");

                classSolder.add(header);
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.getStackTrace();
        }
        return classSolder;
    }    
}
