/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import java.util.List;
import model.dms.dto.DetailDTO;
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
public class ServiceContextDMSIT {

    public ServiceContextDMSIT() {
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
     * Test of contextDetail method, of class ServiceContextDMS.
     */
    @Test
    public void testContextDetail() {
        System.out.println("contextDetail");
        try {
            ServiceContextDMS instance = new ServiceContextDMSImpl();
            List<DetailDTO> result = instance.contextDetail();
            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
