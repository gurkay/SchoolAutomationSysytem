/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gurkay
 */
public class MdlCityTest {

    /**
     * Test of selectCity method, of class MdlCity.
     */
    @Test
    public void testSelectCity() {
        System.out.println("selectCity");
        String query = "";
        MdlCity instance = new MdlCity();
        List expResult = null;
        List result = instance.selectCity(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
