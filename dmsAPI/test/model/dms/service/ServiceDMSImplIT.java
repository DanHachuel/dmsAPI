/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaDmsIn;
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
public class ServiceDMSImplIT {

    public ServiceDMSImplIT() {
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
     * Test of consultar method, of class ServiceDMSImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        try {
            ConsultaDmsIn in = new ConsultaDmsIn();
            in.setDn("4130886762");
            ServiceDMSImpl instance = new ServiceDMSImpl();
            ConfiguracaoDMS result = instance.consultar(in);
            System.out.println("Resultado: " + GsonUtil.serialize(result));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

}
