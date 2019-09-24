/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gurkay
 */
public class MdlConnectionDBTest {
    
    public MdlConnectionDBTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of openConnection method, of class MdlConnectionDB.
     */
    @Test
    public void testOpenConnection() throws Exception {
        System.out.println("openConnection");
        MdlConnectionDB instance = new MdlConnectionDB();
        Connection expResult = null;
        Connection result = instance.openConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class MdlConnectionDB.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        MdlConnectionDB instance = new MdlConnectionDB();
        instance.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
