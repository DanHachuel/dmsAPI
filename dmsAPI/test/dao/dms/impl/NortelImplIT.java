/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import model.dms.ConfiguracaoDMS;
import model.dms.LineService;
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
public class NortelImplIT {

    public NortelImplIT() {
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
     * Test of consultar method, of class NortelImpl.
     */
    @Test
    public void testConsultar() {
        System.out.println("consultar");
        try {
//            String instancia = "6230957133";
//            String ip = "10.161.88.100";
            String instancia = "4130886762";
            String ip = "10.141.245.97";
            NortelImpl instance = new NortelImpl(ip);
            instance.conectar();

            ConfiguracaoDMS result = instance.consultar(instancia);
            result = instance.consultar(instancia);
            System.out.println("Resultado: " + GsonUtil.serialize(result));
            instance.desconectar();
            assertTrue(result != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testAtivarServico() {
        NortelImpl instance = new NortelImpl("10.141.245.97");
        System.out.println(instance.ativarServico("4130886762", LineService.DIGITAL).getSintax());
    }

}
