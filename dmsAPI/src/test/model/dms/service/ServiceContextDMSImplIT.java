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
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class ServiceContextDMSImplIT {

    public ServiceContextDMSImplIT() {
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
     * Test of contextDetail method, of class ServiceContextDMSImpl.
     */
    @Test
    public void testContextDetail() {
        System.out.println("contextDetail");
        ServiceContextDMSImpl instance = new ServiceContextDMSImpl();
        List<DetailDTO> expResult = null;
        List<DetailDTO> result = instance.contextDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connect method, of class ServiceContextDMSImpl.
     */
    @Test
    public void testConnect() {
        try {
            System.out.println("connect");
            ServiceContextDMSImpl instance = new ServiceContextDMSImpl();
            instance.connectSwitches();
            System.out.println(GsonUtil.serialize(instance.contextDetail()));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of disconnect method, of class ServiceContextDMSImpl.
     */
    @Test
    public void testDisconnect() {
        System.out.println("disconnect");
        ServiceContextDMSImpl instance = new ServiceContextDMSImpl();
        instance.disconnectSwitches();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
