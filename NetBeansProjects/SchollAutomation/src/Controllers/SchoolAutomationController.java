/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.JFrameLoginView;

/**
 *
 * @author gurkay
 */
public class SchoolAutomationController {
    public void startAplication() {
        JFrameLoginView jFrameLoginView = new JFrameLoginView();
	jFrameLoginView.setVisible(true);
    }    
}
