/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class OSValidatorIT {
    
    public OSValidatorIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isWindows method, of class OSValidator.
     */
    @Test
    public void testIsWindows() {
        System.out.println("isWindows");
        boolean expResult = true;
        boolean result = OSValidator.isWindows();
        assertEquals(expResult, result);
    }

    /**
     * Test of isMac method, of class OSValidator.
     */
    @Test
    public void testIsMac() {
        System.out.println("isMac");
        boolean expResult = false;
        boolean result = OSValidator.isMac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUnix method, of class OSValidator.
     */
    @Test
    public void testIsUnix() {
        System.out.println("isUnix");
        boolean expResult = false;
        boolean result = OSValidator.isUnix();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSolaris method, of class OSValidator.
     */
    @Test
    public void testIsSolaris() {
        System.out.println("isSolaris");
        boolean expResult = false;
        boolean result = OSValidator.isSolaris();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
