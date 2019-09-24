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
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gurkay
 */
public class CllGlobal {

    public static String[] cmbBoxCity;
    public static String[] cmbBoxClass;
    public static String[] cmbBoxBranch;
    public static String[][] cmbBoxStatus;
    public static String[] cmbBoxRank;
    public static String[] cmbBoxRegisterDate;

    CllGlobal() {

        getCmbBoxCity();
        getCmbBoxClass();
        getCmbBoxBranch();
        getCmbBoxStatus();
        getCmbBoxRank(1);
        getCmbBoxRegisterDate();

    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // GLOBAL cmbBoxCity GET CITY
    //
    ////////////////////////////////////////////////////////////////////////////
    public void getCmbBoxCity() {
        MdlCity mdlCity = new MdlCity();
        String query = "SELECT c.city_id, c.city_name, c.city_code FROM city c";

        List<Object[]> result = mdlCity.selectCity(query);

        String arrayHeader[] = {"City ID", "City Name", "City Code"};
        DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
        for (Object[] city : result) {
            table.addRow(city);
        }

        cmbBoxCity = new String[table.getRowCount()];

        for (int i = 0; i < table.getRowCount(); i++) {
            cmbBoxCity[i] = table.getValueAt(i, 1).toString();
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // GLOBAL cmbBoxCity GET CLASS
    //
    ////////////////////////////////////////////////////////////////////////////
    public void getCmbBoxClass() {
        MdlClass mdlClass = new MdlClass();
        String query = "SELECT c.class_id, c.class_name FROM class c";

        List<Object[]> result = mdlClass.selectClass(query);

        String arrayHeader[] = {"class ID", "class Name"};
        DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
        for (Object[] classSolder : result) {
            table.addRow(classSolder);
        }

        cmbBoxClass = new String[table.getRowCount()];

        for (int i = 0; i < table.getRowCount(); i++) {
            cmbBoxClass[i] = table.getValueAt(i, 1).toString();
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // GLOBAL cmbBoxCity GET BRANCH
    //
    ////////////////////////////////////////////////////////////////////////////
    public void getCmbBoxBranch() {
        MdlBranch mdlBranch = new MdlBranch();
        String query = "SELECT b.branch_id, b.branch_name FROM branch b";

        List<Object[]> result = mdlBranch.selectBranch(query);

        String arrayHeader[] = {"Branch ID", "Branch Name"};
        DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
        for (Object[] branch : result) {
            table.addRow(branch);
        }

        cmbBoxBranch = new String[table.getRowCount()];

        for (int i = 0; i < table.getRowCount(); i++) {
            cmbBoxBranch[i] = table.getValueAt(i, 1).toString();
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // GLOBAL cmbBoxStatus GET STATUS
    //
    ////////////////////////////////////////////////////////////////////////////
    public void getCmbBoxStatus() {
        MdlStatus mdlStatus = new MdlStatus();

        String query = "SELECT s.status_id, s.status_name FROM status s";

        List<Object[]> result = mdlStatus.selectStatus(query);

        String arrayHeader[] = {"Status ID", "Status Name"};
        DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
        for (Object[] status : result) {
            table.addRow(status);
        }

        cmbBoxStatus = new String[table.getRowCount()][2];

        for (int i = 0; i < table.getRowCount(); i++) {
            cmbBoxStatus[i][0] = table.getValueAt(i, 0).toString();
            cmbBoxStatus[i][1] = table.getValueAt(i, 1).toString();
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // GLOBAL cmbBoxRank GET RANK
    //
    ////////////////////////////////////////////////////////////////////////////
    public void getCmbBoxRank(int status) {

        MdlRank mdlRank = new MdlRank();

        String query = "SELECT r.rank_id, r.rank_name, r.status_id FROM rank r WHERE r.status_id = " + status;

        List<Object[]> result = mdlRank.selectRank(query);

        String arrayHeader[] = {"Rank ID", "Rank Name", "Status ID"};
        DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
        for (Object[] rank : result) {
            table.addRow(rank);
        }

        cmbBoxRank = new String[table.getRowCount()];

        for (int i = 0; i < table.getRowCount(); i++) {

            cmbBoxRank[i] = table.getValueAt(i, 1).toString();

        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //
    // GLOBAL cmbBoxRegisterDate GET REGISTER DATE
    //
    ////////////////////////////////////////////////////////////////////////////
    public void getCmbBoxRegisterDate() {

        cmbBoxRegisterDate = new String[80];
        
        int dateCount = 1970;
        for (int i = 0; i < 80; i++) {
            cmbBoxRegisterDate[i] = Integer.toString(dateCount);
            dateCount++;
        }
    }    

}
