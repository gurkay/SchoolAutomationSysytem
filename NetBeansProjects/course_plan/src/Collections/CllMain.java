/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import Controllers.CtrApplication;

/**
 *
 * @author gurkay
 */
public class CllMain {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        CllGlobal cllGlobal = new CllGlobal();
        
        CtrApplication ctrApplication = new CtrApplication();
        ctrApplication.startApplication();
        
    }
}
