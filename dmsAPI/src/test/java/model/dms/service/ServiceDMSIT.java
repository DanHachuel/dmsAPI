/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaDMS;
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
public class ServiceDMSIT {
    
    public ServiceDMSIT() {
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
     * Test of consultar method, of class ServiceDMS.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        ConsultaDMS in = null;
        ServiceDMS instance = new ServiceDMSImpl();
        ConfiguracaoDMS expResult = null;
        ConfiguracaoDMS result = instance.consultar(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
