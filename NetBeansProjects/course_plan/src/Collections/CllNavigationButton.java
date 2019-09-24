/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import Controllers.CtrCourses;
import Controllers.CtrPersonal;
import Models.MdlCourses;
import Models.MdlPersonal;
import Views.*;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gurkay
 */
public class CllNavigationButton {

    /**
     *
     * @param newButton NEW operation
     */
    public void newButton(String newButton) {
        switch (newButton) {
            case "newButtonIntFrmAddPersonal":
                IntFrmAddPersonal.txtPersonalID.setText("");
                IntFrmAddPersonal.txtPbik.setText("");
                IntFrmAddPersonal.txtTC.setText("");
                IntFrmAddPersonal.txtFirstName.setText("");
                IntFrmAddPersonal.txtLastName.setText("");
                IntFrmAddPersonal.cmbClass.setSelectedItem("Select");
                IntFrmAddPersonal.cmbStatus.setSelectedItem("Select");
                IntFrmAddPersonal.cmbRank.setSelectedItem("Select");
                IntFrmAddPersonal.cmbBranch.setSelectedItem("Select");
                IntFrmAddPersonal.txtRegister.setText("");
                IntFrmAddPersonal.txtTask.setText("");
                IntFrmAddPersonal.txtContinent.setText("");
                IntFrmAddPersonal.cmbCity.setSelectedItem("Select");
                IntFrmAddPersonal.cmbRegisterDate.setSelectedItem("Select");
                break;
            case "newButtonIntFrmAddCourses":
                IntFrmAddCourses.txtCoursesID.setText("");
                IntFrmAddCourses.txtCoursesCode.setText("");
                IntFrmAddCourses.txtSearchCoursesName.setText("");
                IntFrmAddCourses.txtAreaCoursesName.setText("");
                break;
        }
    }

    /**
     *
     * @param saveButton SAVE operation
     */
    public void saveButton(String saveButton) {
        String query;
        List<Object[]> result;
        MdlPersonal mdlPersonal = new MdlPersonal();
        MdlCourses mdlCourses = new MdlCourses();
        switch (saveButton) {
            case "saveButtonIntFrmAddPersonal":
                
                query = "SELECT p.pbik, p.tc, r.rank_name, p.first_name, p.last_name "
                        + "FROM personal p "
                        + "JOIN rank r ON p.rank_id = r.rank_id "
                        + "WHERE p.pbik = " + Integer.parseInt(IntFrmAddPersonal.txtPbik.getText());
                result = mdlPersonal.selectPersonal("recordPersonal", query);
                if (result.isEmpty()) {

                    CtrPersonal ctrPersonal = new CtrPersonal();

                    ctrPersonal.setPbik(Integer.parseInt(IntFrmAddPersonal.txtPbik.getText()));
                    ctrPersonal.setTc(IntFrmAddPersonal.txtTC.getText());
                    ctrPersonal.setFirst_name(IntFrmAddPersonal.txtFirstName.getText());
                    ctrPersonal.setLast_name(IntFrmAddPersonal.txtLastName.getText());

                    if ("Select".equals(IntFrmAddPersonal.cmbClass.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin Sınıfını Seçiniz");
                    } else {
                        query = "SELECT c.class_id, c.class_name FROM class c WHERE c.class_name = '" + IntFrmAddPersonal.cmbClass.getSelectedItem().toString() + "'";
                        ctrPersonal.setClass_id(CllGetID.getId("classID", query));
                    }

                    if ("Select".equals(IntFrmAddPersonal.cmbStatus.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin statüsünü Seçiniz");
                    } else {
                        query = "SELECT s.status_id, s.status_name FROM status s WHERE s.status_name = '" + IntFrmAddPersonal.cmbStatus.getSelectedItem().toString() + "'";
                        ctrPersonal.setStatus_id(CllGetID.getId("statusID", query));
                    }

                    if ("Select".equals(IntFrmAddPersonal.cmbRank.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin Rütbesini Seçiniz");
                    } else {
                        query = "SELECT r.rank_id, r.rank_name, r.status_id FROM rank r WHERE r.rank_name = '" + IntFrmAddPersonal.cmbRank.getSelectedItem().toString() + "'";
                        ctrPersonal.setRank_id(CllGetID.getId("rankID", query));
                    }

                    if ("Select".equals(IntFrmAddPersonal.cmbBranch.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin Branşını Seçiniz");
                    } else {
                        query = "SELECT b.branch_id, b.branch_name FROM branch b WHERE b.branch_name = '" + IntFrmAddPersonal.cmbBranch.getSelectedItem().toString() + "'";
                        ctrPersonal.setBranch_id(CllGetID.getId("branchID", query));
                    }

                    ctrPersonal.setRegister(IntFrmAddPersonal.txtRegister.getText());
                    ctrPersonal.setTask(IntFrmAddPersonal.txtTask.getText());
                    ctrPersonal.setContinent(IntFrmAddPersonal.txtContinent.getText());

                    if ("Select".equals(IntFrmAddPersonal.cmbCity.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin Bulundurğu Şehri Seçiniz");
                    } else {
                        query = "SELECT c.city_id, c.city_name, c.city_code FROM city c WHERE c.city_name = '" + IntFrmAddPersonal.cmbCity.getSelectedItem().toString() + "'";
                        ctrPersonal.setCity_id(CllGetID.getId("cityID", query));
                    }
                    if ("Select".equals(IntFrmAddPersonal.cmbRegisterDate.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Sicil Yılı");
                    } else {
                        ctrPersonal.setRegister_date(Short.valueOf(IntFrmAddPersonal.cmbRegisterDate.getSelectedItem().toString()));
                    }

                    mdlPersonal.recordPersonal(ctrPersonal);
                    JOptionPane.showMessageDialog(null, "Saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Personel Pbik Numarası Önceden Kayıtlı");
                }
                break;
            case "saveButtonIntFrmAddCourses":
                
                if (IntFrmAddCourses.txtCoursesID.getText().equals("")) {
                    query = "SELECT c.courses_id, c.courses_name, c.courses_code "
                            + "FROM courses c "
                            + "WHERE c.courses_code = '" + IntFrmAddCourses.txtCoursesCode.getText() + "'";

                    result = mdlCourses.selectCourses("recordCourses", query);
                } else {
                    query = "SELECT c.courses_id, c.courses_name, c.courses_code "
                            + "FROM courses c "
                            + "WHERE c.courses_id = " + Integer.parseInt(IntFrmAddCourses.txtCoursesID.getText());

                    result = mdlCourses.selectCourses("recordCourses", query);
                }

                if (result.isEmpty()) {
                    CtrCourses ctrCourses = new CtrCourses();
                    ctrCourses.setCouses_code(IntFrmAddCourses.txtCoursesCode.getText());
                    ctrCourses.setCourses_name(IntFrmAddCourses.txtAreaCoursesName.getText());
                    mdlCourses.recordCourses(ctrCourses);
                    JOptionPane.showMessageDialog(null, "Saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Bu Kurs Zaten Kayıtlı");
                }
                break;
            case "saveButtonIntFrmAddCoursePlaning":

                if (IntFrmAddCourses.txtCoursesID.getText().equals("")) {
                    query = "SELECT c.courses_id, c.courses_name, c.courses_code "
                            + "FROM courses c "
                            + "WHERE c.courses_code = '" + IntFrmAddCourses.txtCoursesCode.getText() + "'";

                    result = mdlCourses.selectCourses("recordCourses", query);
                } else {
                    query = "SELECT c.courses_id, c.courses_name, c.courses_code "
                            + "FROM courses c "
                            + "WHERE c.courses_id = " + Integer.parseInt(IntFrmAddCourses.txtCoursesID.getText());

                    result = mdlCourses.selectCourses("recordCourses", query);
                }

                if (result.isEmpty()) {
                    CtrCourses ctrCourses = new CtrCourses();
                    ctrCourses.setCouses_code(IntFrmAddCourses.txtCoursesCode.getText());
                    ctrCourses.setCourses_name(IntFrmAddCourses.txtAreaCoursesName.getText());
                    mdlCourses.recordCourses(ctrCourses);
                    JOptionPane.showMessageDialog(null, "Saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Bu Kurs Zaten Kayıtlı");
                }
                break;                
        }
    }

    /**
     *
     * @param updateButton UPDATE operation
     */
    public void updateButton(String updateButton) {
        String query;
        List<Object[]> result;
        switch (updateButton) {
            case "updateButtonIntFrmAddPersonal":
                MdlPersonal mdlPersonal = new MdlPersonal();
                query = "SELECT p.pbik, p.tc, r.rank_name, p.first_name, p.last_name "
                        + "FROM personal p "
                        + "JOIN rank r ON p.rank_id = r.rank_id "
                        + "WHERE p.ID = " + Integer.parseInt(IntFrmAddPersonal.txtPersonalID.getText());

                result = mdlPersonal.selectPersonal("recordPersonal", query);
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Personel Kayıtlı değil");
                } else {
                    CtrPersonal ctrPersonal = new CtrPersonal();
                    ctrPersonal.setId(Integer.parseInt(IntFrmAddPersonal.txtPersonalID.getText()));
                    ctrPersonal.setPbik(Integer.parseInt(IntFrmAddPersonal.txtPbik.getText()));
                    ctrPersonal.setTc(IntFrmAddPersonal.txtTC.getText());
                    ctrPersonal.setFirst_name(IntFrmAddPersonal.txtFirstName.getText());
                    ctrPersonal.setLast_name(IntFrmAddPersonal.txtLastName.getText());

                    if ("Select".equals(IntFrmAddPersonal.cmbClass.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin Sınıfını Seçiniz");
                    } else {
                        query = "SELECT c.class_id, c.class_name FROM class c WHERE c.class_name = '" + IntFrmAddPersonal.cmbClass.getSelectedItem().toString() + "'";
                        ctrPersonal.setClass_id(CllGetID.getId("classID", query));
                    }

                    if ("Select".equals(IntFrmAddPersonal.cmbStatus.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin statüsünü Seçiniz");
                    } else {
                        query = "SELECT s.status_id, s.status_name FROM status s WHERE s.status_name = '" + IntFrmAddPersonal.cmbStatus.getSelectedItem().toString() + "'";
                        ctrPersonal.setStatus_id(CllGetID.getId("statusID", query));
                    }

                    if ("Select".equals(IntFrmAddPersonal.cmbRank.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin Rütbesini Seçiniz");
                    } else {
                        query = "SELECT r.rank_id, r.rank_name, r.status_id FROM rank r WHERE r.rank_name = '" + IntFrmAddPersonal.cmbRank.getSelectedItem().toString() + "'";
                        ctrPersonal.setRank_id(CllGetID.getId("rankID", query));
                    }

                    if ("Select".equals(IntFrmAddPersonal.cmbBranch.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin Branşını Seçiniz");
                    } else {
                        query = "SELECT b.branch_id, b.branch_name FROM branch b WHERE b.branch_name = '" + IntFrmAddPersonal.cmbBranch.getSelectedItem().toString() + "'";
                        ctrPersonal.setBranch_id(CllGetID.getId("branchID", query));
                    }

                    ctrPersonal.setRegister(IntFrmAddPersonal.txtRegister.getText());
                    ctrPersonal.setTask(IntFrmAddPersonal.txtTask.getText());
                    ctrPersonal.setContinent(IntFrmAddPersonal.txtContinent.getText());

                    if ("Select".equals(IntFrmAddPersonal.cmbCity.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Personelin Bulundurğu Şehri Seçiniz");
                    } else {
                        query = "SELECT c.city_id, c.city_name, c.city_code FROM city c WHERE c.city_name = '" + IntFrmAddPersonal.cmbCity.getSelectedItem().toString() + "'";
                        ctrPersonal.setCity_id(CllGetID.getId("cityID", query));
                    }
                    if ("Select".equals(IntFrmAddPersonal.cmbRegisterDate.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Sicil Yılı");
                    } else {
                        ctrPersonal.setRegister_date(Short.valueOf(IntFrmAddPersonal.cmbRegisterDate.getSelectedItem().toString()));
                    }

                    mdlPersonal.updatePersonal(ctrPersonal);
                    JOptionPane.showMessageDialog(null, "Update");
                }
                break;
            case "updateButtonIntFrmAddCourses":
                MdlCourses mdlCourses = new MdlCourses();
                query = "SELECT c.courses_id, c.courses_name, c.courses_code "
                        + "FROM courses c "
                        + "WHERE c.courses_id = " + Integer.parseInt(IntFrmAddCourses.txtCoursesID.getText());

                result = mdlCourses.selectCourses("recordCourses", query);
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Courses Kayıtlı değil");
                } else {
                    CtrCourses ctrCourses = new CtrCourses();
                    ctrCourses.setCourses_id(Integer.parseInt(IntFrmAddCourses.txtCoursesID.getText()));
                    ctrCourses.setCourses_name(IntFrmAddCourses.txtAreaCoursesName.getText());
                    ctrCourses.setCouses_code(IntFrmAddCourses.txtCoursesCode.getText());

                    mdlCourses.updateCourses(ctrCourses);
                    JOptionPane.showMessageDialog(null, "Update");
                }
                break;
        }
    }

    /**
     *
     * @param refreshButton REFRESH operation
     */
    public void refreshButton(String refreshButton) {
        String query;
        MdlPersonal mdlPersonal = new MdlPersonal();
        MdlCourses mdlCourses = new MdlCourses();
        List<Object[]> result;
        switch (refreshButton) {
            case "refreshButtonIntFrmAddPersonal":                
                try {
                    query = "SELECT p.pbik, p.tc, r.rank_name, p.first_name, p.last_name "
                            + "FROM personal p "
                            + "JOIN rank r ON p.rank_id = r.rank_id";
                    result = mdlPersonal.selectPersonal("recordPersonal", query);

                    String arrayHeader[] = {"Pbik", "TC", "Rütbe", "Ad", "Soyad"};
                    DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
                    result.forEach((personal) -> {
                        table.addRow(personal);
                    });

                    IntFrmAddPersonal.tblPersonal.setModel(table);
                    IntFrmAddPersonal.scrPnlPersonal.setViewportView(IntFrmAddPersonal.tblPersonal);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getStackTrace());
                }
                break;
            case "refreshButtonIntFrmAddCourses":
                try {
                    query = "SELECT c.courses_id, c.courses_name, c.courses_code FROM courses c ";

                    result = mdlCourses.selectCourses("recordCourses", query);

                    String arrayHeader[] = {"Kurs ID", "Kurs Adı", "Kurs Kodu"};
                    DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
                    result.forEach((forEachTable) -> {
                        table.addRow(forEachTable);
                    });

                    IntFrmAddCourses.tblCourses.setModel(table);
                    IntFrmAddCourses.scrPnlCourses.setViewportView(IntFrmAddCourses.tblCourses);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getStackTrace());
                }
                break;
            case "refreshButtonIntFrmAddCoursePlaning":
                try {
                    query = "SELECT c.courses_id, c.courses_name, c.courses_code FROM courses c ";

                    result = mdlCourses.selectCourses("recordCourses", query);

                    String arrayHeader[] = {"Kurs ID", "Kurs Adı", "Kurs Kodu"};
                    DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
                    result.forEach((forEachTable) -> {
                        table.addRow(forEachTable);
                    });

                    IntFrmAddCoursePlaning.tblCourses.setModel(table);
                    IntFrmAddCoursePlaning.scrPnlCourses.setViewportView(IntFrmAddCoursePlaning.tblCourses);
                    
                    query = "SELECT p.pbik, p.tc, r.rank_name, p.first_name, p.last_name "
                            + "FROM personal p "
                            + "JOIN rank r ON p.rank_id = r.rank_id";
                    result = mdlPersonal.selectPersonal("recordPersonal", query);

                    String arrayHeaderCoursePlanning[] = {"Pbik", "TC", "Rütbe", "Ad", "Soyad"};
                    DefaultTableModel tableCoursePlanning = new DefaultTableModel(arrayHeaderCoursePlanning, 0);
                    result.forEach((forEachTable) -> {
                        tableCoursePlanning.addRow(forEachTable);
                    });

                    IntFrmAddCoursePlaning.tblPersonal.setModel(tableCoursePlanning);
                    IntFrmAddCoursePlaning.scrPnlPersonal.setViewportView(IntFrmAddCoursePlaning.tblPersonal);                    

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getStackTrace());
                }
                break;                
        }
    }

    /**
     *
     * @param deleteButton DELETE operation
     */
    public void deleteButton(String deleteButton) {
        switch (deleteButton) {
            case "deleteButtonIntFrmAddPersonal":
                MdlPersonal mdlPersonal = new MdlPersonal();
                if (IntFrmAddPersonal.txtPersonalID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Lütfen Silinecek personel seçiniz");
                } else {

                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Rütbesi : " + IntFrmAddPersonal.cmbRank.getSelectedItem().toString() + "\n"
                            + "Adı : " + IntFrmAddPersonal.txtFirstName.getText() + "\n"
                            + "Soyadı : " + IntFrmAddPersonal.txtLastName.getText() + "\n"
                            + "Personel Silinecek !", "Delete", dialogButton);
                    if (dialogResult == 0) {
                        mdlPersonal.deletePersonal(Integer.parseInt(IntFrmAddPersonal.txtPersonalID.getText()));
                        JOptionPane.showMessageDialog(null, "Silindi.");
                    } else {
                        System.out.println("No Option");
                    }
                }
                break;
            case "deleteButtonIntFrmAddCourses":
                MdlCourses mdlCourses = new MdlCourses();
                if (IntFrmAddCourses.txtCoursesID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Lütfen Silinecek kurs seçiniz");
                } else {

                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Kurs Adı : " + IntFrmAddCourses.txtAreaCoursesName.getText() + "\n"
                            + "Kurs Silinecek !", "Delete", dialogButton);
                    if (dialogResult == 0) {
                        mdlCourses.deleteCourses(Integer.parseInt(IntFrmAddCourses.txtCoursesID.getText()));
                        JOptionPane.showMessageDialog(null, "Silindi.");
                    } else {
                        System.out.println("No Option");
                    }
                }
                break;
        }
    }

    /**
     *
     * @param searchButton SEARCH operation
     */
    public void searchButton(String searchButton) {
        String query;
        List<Object[]> result;
        switch (searchButton) {
            case "searchButtonIntFrmAddPersonal":
                MdlPersonal mdlPersonal = new MdlPersonal();
                try {
                    if (IntFrmAddPersonal.txtSearchPbik.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Pbik giriniz");
                    } else {
                        query = "SELECT p.pbik, p.tc, r.rank_name, p.first_name, p.last_name "
                                + "FROM personal p "
                                + "JOIN rank r ON p.rank_id = r.rank_id "
                                + "WHERE p.pbik = " + Integer.parseInt(IntFrmAddPersonal.txtSearchPbik.getText());

                        result = mdlPersonal.selectPersonal("recordPersonal", query);
                        if (result.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Pbik bulunamadı");
                        } else {
                            String arrayHeader[] = {"Pbik", "TC", "Rütbe", "Ad", "Soyad"};
                            DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
                            result.forEach((personal) -> {
                                table.addRow(personal);
                            });
                            IntFrmAddPersonal.tblPersonal.setModel(table);
                            IntFrmAddPersonal.scrPnlPersonal.setViewportView(IntFrmAddPersonal.tblPersonal);
                        }
                    }
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e.getStackTrace());
                }
                break;
            case "searchButtonIntFrmAddCourses":
                MdlCourses mdlCourses = new MdlCourses();
                try {
                    if (IntFrmAddCourses.txtSearchCoursesName.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Kurs adını giriniz");
                    } else {
                        query = "SELECT c.courses_id, c.courses_name, c.courses_code "
                                + "FROM courses c "
                                + "WHERE c.courses_name = '" + IntFrmAddCourses.txtSearchCoursesName.getText() + "'";

                        result = mdlCourses.selectCourses("recordPersonal", query);
                        if (result.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Kurs bulunamadı");
                        } else {
                            String arrayHeader[] = {"Kurs ID", "Kurs Adı", "Kurs Kodu"};
                            DefaultTableModel table = new DefaultTableModel(arrayHeader, 0);
                            result.forEach((forEachTable) -> {
                                table.addRow(forEachTable);
                            });

                            IntFrmAddCourses.tblCourses.setModel(table);
                            IntFrmAddCourses.scrPnlCourses.setViewportView(IntFrmAddCourses.tblCourses);
                        }
                    }
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e.getStackTrace());
                }
                break;
        }
    }
}
