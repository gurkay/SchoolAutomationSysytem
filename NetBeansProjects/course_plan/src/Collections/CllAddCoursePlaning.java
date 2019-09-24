/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import Models.MdlPersonal;
import Views.IntFrmAddCoursePlaning;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gurkay
 */
public class CllAddCoursePlaning {

    CllNavigationButton cllNavigationButton = new CllNavigationButton();
    
    /**
     * Checked take personal
     * @param chkStatus
     */
    public void chkRdBtnCoursesStatusTake(int chkStatus) {
        try {
            MdlPersonal mdlPersonal = new MdlPersonal();
            String query;
            List<Object[]> result;
            String arrayHeaderCoursePlanning[] = {"Pbik", "TC", "Rütbe", "Ad", "Soyad"};
            DefaultTableModel tableCoursePlanning;
            switch (chkStatus) {
                case 0:
                    query = "SELECT p.pbik, p.tc, rnk.rank_name, p.first_name, p.last_name "
                            + " FROM personal p INNER JOIN rank rnk ON rnk.rank_id  = p.rank_id"
                            + " INNER JOIN course_planing_personal cpp ON cpp.personal_pbik  = p.pbik"
                            + " WHERE 0 < ("
                            + " SELECT count(p.pbik)"
                            + " FROM personal p"
                            + " INNER JOIN course_planing_personal cpp ON cpp.personal_pbik  = p.pbik"
                            + " INNER JOIN course_planing cp ON cp.courses_id  = " 
                            + Integer.parseInt(IntFrmAddCoursePlaning.txtCoursesID.getText()) 
                            + ")";
                    result = mdlPersonal.selectPersonal("takeCoursePersonal", query);

                    tableCoursePlanning = new DefaultTableModel(arrayHeaderCoursePlanning, 0);
                    result.forEach((forEachTable) -> {
                        tableCoursePlanning.addRow(forEachTable);
                    });

                    IntFrmAddCoursePlaning.tblPersonal.setModel(tableCoursePlanning);
                    IntFrmAddCoursePlaning.scrPnlPersonal.setViewportView(IntFrmAddCoursePlaning.tblPersonal);
                    break;

                case 1:
                    if (IntFrmAddCoursePlaning.cmbRank.getSelectedItem().toString() != "Select") {
                        query = "SELECT p.pbik, p.tc, rnk.rank_name, p.first_name, p.last_name "
                            + " FROM personal p "
                            + " INNER JOIN rank rnk ON rnk.rank_id  = p.rank_id"
                            + " WHERE p.city_id = " 
                            + IntFrmAddCoursePlaning.cmbCity.getSelectedIndex()
                            + " AND p.branch_id = "
                            + IntFrmAddCoursePlaning.cmbBranch.getSelectedIndex()
                            + " AND p.class_id = "
                            + IntFrmAddCoursePlaning.cmbClass.getSelectedIndex() 
                            + " AND p.status_id = "
                            + IntFrmAddCoursePlaning.cmbStatus.getSelectedIndex()
                            + " AND p.rank_id = "
                            + IntFrmAddCoursePlaning.cmbRank.getSelectedIndex()                               
                            + " AND p.pbik NOT IN ("
                            + " SELECT cpp.personal_pbik"
                            + " FROM public.course_planing_personal cpp"
                            + " INNER JOIN course_planing cp ON cp.courses_id  = " 
                            + Integer.parseInt(IntFrmAddCoursePlaning.txtCoursesID.getText()) 
                            + ")";  
                    } else 
                    if (IntFrmAddCoursePlaning.cmbStatus.getSelectedItem().toString() != "Select") {
                        query = "SELECT p.pbik, p.tc, rnk.rank_name, p.first_name, p.last_name "
                            + " FROM personal p "
                            + " INNER JOIN rank rnk ON rnk.rank_id  = p.rank_id"
                            + " WHERE p.city_id = " 
                            + IntFrmAddCoursePlaning.cmbCity.getSelectedIndex()
                            + " AND p.branch_id = "
                            + IntFrmAddCoursePlaning.cmbBranch.getSelectedIndex()
                            + " AND p.class_id = "
                            + IntFrmAddCoursePlaning.cmbClass.getSelectedIndex() 
                            + " AND p.status_id = "
                            + IntFrmAddCoursePlaning.cmbStatus.getSelectedIndex()      
                            + " AND p.pbik NOT IN ("
                            + " SELECT cpp.personal_pbik"
                            + " FROM public.course_planing_personal cpp"
                            + " INNER JOIN course_planing cp ON cp.courses_id  = " 
                            + Integer.parseInt(IntFrmAddCoursePlaning.txtCoursesID.getText()) 
                            + ")";  
                    } else if (IntFrmAddCoursePlaning.cmbClass.getSelectedItem().toString() != "Select") {
                        query = "SELECT p.pbik, p.tc, rnk.rank_name, p.first_name, p.last_name "
                            + " FROM personal p "
                            + " INNER JOIN rank rnk ON rnk.rank_id  = p.rank_id"
                            + " WHERE p.city_id = " 
                            + IntFrmAddCoursePlaning.cmbCity.getSelectedIndex()
                            + " AND p.branch_id = "
                            + IntFrmAddCoursePlaning.cmbBranch.getSelectedIndex()
                            + " AND p.class_id = "
                            + IntFrmAddCoursePlaning.cmbClass.getSelectedIndex()                                
                            + " AND p.pbik NOT IN ("
                            + " SELECT cpp.personal_pbik"
                            + " FROM public.course_planing_personal cpp"
                            + " INNER JOIN course_planing cp ON cp.courses_id  = " 
                            + Integer.parseInt(IntFrmAddCoursePlaning.txtCoursesID.getText()) 
                            + ")";
                    } else if (IntFrmAddCoursePlaning.cmbBranch.getSelectedItem().toString() != "Select") {
                        query = "SELECT p.pbik, p.tc, rnk.rank_name, p.first_name, p.last_name "
                            + " FROM personal p "
                            + " INNER JOIN rank rnk ON rnk.rank_id  = p.rank_id"
                            + " WHERE p.city_id = " 
                            + IntFrmAddCoursePlaning.cmbCity.getSelectedIndex()
                            + " AND p.branch_id = "
                            + IntFrmAddCoursePlaning.cmbBranch.getSelectedIndex()    
                            + " AND p.pbik NOT IN ("
                            + " SELECT cpp.personal_pbik"
                            + " FROM public.course_planing_personal cpp"
                            + " INNER JOIN course_planing cp ON cp.courses_id  = " 
                            + Integer.parseInt(IntFrmAddCoursePlaning.txtCoursesID.getText()) 
                            + ")";
                    } else if(IntFrmAddCoursePlaning.cmbCity.getSelectedItem().toString() != "Select") {
                        query = "SELECT p.pbik, p.tc, rnk.rank_name, p.first_name, p.last_name "
                            + " FROM personal p "
                            + " INNER JOIN rank rnk ON rnk.rank_id  = p.rank_id"
                            + " WHERE p.city_id = " 
                            + IntFrmAddCoursePlaning.cmbCity.getSelectedIndex()
                            + " AND p.pbik NOT IN ("
                            + " SELECT cpp.personal_pbik"
                            + " FROM public.course_planing_personal cpp"
                            + " INNER JOIN course_planing cp ON cp.courses_id  = " 
                            + Integer.parseInt(IntFrmAddCoursePlaning.txtCoursesID.getText()) 
                            + ")";
                    } else {
/*                        IntFrmAddCoursePlaning.cmbCity.setSelectedItem("Select");
                        IntFrmAddCoursePlaning.cmbBranch.setSelectedItem("Select");
                        IntFrmAddCoursePlaning.cmbClass.setSelectedItem("Select");
                        IntFrmAddCoursePlaning.cmbStatus.setSelectedItem("Select");
                        IntFrmAddCoursePlaning.cmbRank.setSelectedItem("Select");    */                    
                        query = "SELECT p.pbik, p.tc, rnk.rank_name, p.first_name, p.last_name "
                            + " FROM personal p "
                            + " INNER JOIN rank rnk ON rnk.rank_id  = p.rank_id"
                            + " WHERE p.pbik NOT IN ("
                            + " SELECT cpp.personal_pbik"
                            + " FROM public.course_planing_personal cpp"
                            + " INNER JOIN course_planing cp ON cp.courses_id  = " 
                            + Integer.parseInt(IntFrmAddCoursePlaning.txtCoursesID.getText()) 
                            + ")";

                    }
                  
                    result = mdlPersonal.selectPersonal("takeCoursePersonal", query);

                    tableCoursePlanning = new DefaultTableModel(arrayHeaderCoursePlanning, 0);
                    result.forEach((forEachTable) -> {
                        tableCoursePlanning.addRow(forEachTable);
                    });

                    IntFrmAddCoursePlaning.tblPersonal.setModel(tableCoursePlanning);
                    IntFrmAddCoursePlaning.scrPnlPersonal.setViewportView(IntFrmAddCoursePlaning.tblPersonal);
                    break;

                default:
                    cllNavigationButton.refreshButton("refreshButtonIntFrmAddCoursePlaning");
                    break;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }
    
}
