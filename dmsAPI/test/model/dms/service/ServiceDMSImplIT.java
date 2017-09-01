/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import dao.dms.enums.SwitchesEnum;
import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaDMS;
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
            ConsultaDMS in = new ConsultaDMS();
            in.setDn("8560971414");
            in.setCentral(SwitchesEnum.CEFLA_JBS01);
            
            ServiceDMSImpl instance = new ServiceDMSImpl();
            ConfiguracaoDMS result = instance.consultar(in);
            System.out.println("Result:" + GsonUtil.serialize(result));
            System.out.println("end");
            
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

}
