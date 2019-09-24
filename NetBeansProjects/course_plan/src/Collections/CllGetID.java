/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import Models.MdlBranch;
import Models.MdlCity;
import Models.MdlClass;
import Models.MdlRank;
import Models.MdlStatus;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gurkay
 */
public class CllGetID {
    /**
     * Get ID info
     */
    public static Short getId(String selectID, String query) {
        Short ID = null;
        List<Object[]> result;
        String arrayHeader[] = {"ID"};
        DefaultTableModel table;
        switch (selectID) {
            case "rankID":
                MdlRank mdlRank = new MdlRank();

                result = mdlRank.selectRank(query);
                table = new DefaultTableModel(arrayHeader, 0);
                for (Object[] rank_id : result) {
                    table.addRow(rank_id);
                }

                ID = Short.valueOf(table.getValueAt(0, 0).toString());
                break;
            case "branchID":
                MdlBranch mdlBranch = new MdlBranch();
                result = mdlBranch.selectBranch(query);
                table = new DefaultTableModel(arrayHeader, 0);
                for (Object[] id : result) {
                    table.addRow(id);
                }

                ID = Short.valueOf(table.getValueAt(0, 0).toString());
                break;
            case "cityID":
                MdlCity mdlCity = new MdlCity();
                result = mdlCity.selectCity(query);
                table = new DefaultTableModel(arrayHeader, 0);
                for (Object[] id : result) {
                    table.addRow(id);
                }

                ID = Short.valueOf(table.getValueAt(0, 0).toString());
                break;
            case "statusID":
                MdlStatus mdlStatus = new MdlStatus();
                result = mdlStatus.selectStatus(query);
                table = new DefaultTableModel(arrayHeader, 0);
                for (Object[] id : result) {
                    table.addRow(id);
                }

                ID = Short.valueOf(table.getValueAt(0, 0).toString());
                break;
            case "classID":
                MdlClass mdlClass = new MdlClass();
                result = mdlClass.selectClass(query);
                table = new DefaultTableModel(arrayHeader, 0);
                for (Object[] id : result) {
                    table.addRow(id);
                }

                ID = Short.valueOf(table.getValueAt(0, 0).toString());
                break;
            default:
                break;
        }

        return ID;
    }    
}
