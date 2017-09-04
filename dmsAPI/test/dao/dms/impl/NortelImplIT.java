/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.enums.SwitchesEnum;
import exception.LinhaNaoPertenceCentralException;
import java.util.List;
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

    private NortelImpl instance = new NortelImpl(SwitchesEnum.CEFLA_JBS01);

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
            String instancia = "8560971414";

            ConfiguracaoDMS result = instance.consultarPorDn(instancia);
            System.out.println("Resultado: " + GsonUtil.serialize(result));
            assertTrue("qdn", result != null);
            assertTrue("qlen", instance.consultarPorLen(result.getLen()) != null);
        } catch (Exception e) {
            fail(e.getMessage());
        } finally {
            instance.desconectar();
        }
    }

    @Test
    public void testLinhaNaoPertenceCentralException() {
        System.out.println("consultar");
        try {
            String instancia = "4130222839";
            ConfiguracaoDMS result = instance.consultarPorDn(instancia);
            System.out.println("Retono: " + GsonUtil.serialize(result));
        } catch (Exception e) {
            assertTrue(e instanceof LinhaNaoPertenceCentralException);
        } finally {
            instance.desconectar();
        }
    }

    @Test
    public void testEnter() {
        ComandoDMS result = instance.enter();
        System.out.println("result:" + result.getBlob());
        instance.desconectar();

    }

    /**
     * Test of consultarPorDn method, of class NortelImpl.
     */
    @Test
    public void testConsultarPorDn() throws Exception {
        System.out.println("consultarPorDn");
        String dn = "";
        NortelImpl instance = null;
        ConfiguracaoDMS expResult = null;
        ConfiguracaoDMS result = instance.consultarPorDn(dn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorLen method, of class NortelImpl.
     */
    @Test
    public void testConsultarPorLen() throws Exception {
        System.out.println("consultarPorLen");
        String len = "";
        NortelImpl instance = null;
        ConfiguracaoDMS expResult = null;
        ConfiguracaoDMS result = instance.consultarPorLen(len);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarLinha method, of class NortelImpl.
     */
    @Test
    public void testCriarLinha() throws Exception {
        System.out.println("criarLinha");
        ConfiguracaoDMS linha = null;
        NortelImpl instance = null;
        ConfiguracaoDMS expResult = null;
        ConfiguracaoDMS result = instance.criarLinha(linha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarLinha method, of class NortelImpl.
     */
    @Test
    public void testDeletarLinha() throws Exception {
        System.out.println("deletarLinha");
        NortelImpl instance = new NortelImpl(SwitchesEnum.PERCE_LNS01);
        ConfiguracaoDMS linha = instance.consultarPorDn("8130206712");
        System.out.println(GsonUtil.serialize(linha));
        instance.deletarLinha(linha);
//        System.out.println(GsonUtil.serialize(instance.consultarPorDn("8130206712")));
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarServico method, of class NortelImpl.
     */
    @Test
    public void testAdicionarServico() throws Exception {
        System.out.println("adicionarServico");
        ConfiguracaoDMS linha = null;
        List<LineService> services = null;
        NortelImpl instance = null;
        instance.adicionarServico(linha, services);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerServico method, of class NortelImpl.
     */
    @Test
    public void testRemoverServico() throws Exception {
        System.out.println("removerServico");
        ConfiguracaoDMS linha = null;
        List<LineService> services = null;
        NortelImpl instance = null;
        instance.removerServico(linha, services);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conectar method, of class NortelImpl.
     */
    @Test
    public void testConectar() throws Exception {
        System.out.println("conectar");
        NortelImpl instance = null;
        instance.conectar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of desconectar method, of class NortelImpl.
     */
    @Test
    public void testDesconectar() {
        System.out.println("desconectar");
        NortelImpl instance = null;
        instance.desconectar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class NortelImpl.
     */
    @Test
    public void testEquals_Object() {
        System.out.println("equals");
        Object obj = null;
        NortelImpl instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class NortelImpl.
     */
    @Test
    public void testEquals_NortelImpl() {
        System.out.println("equals");
        NortelImpl dev = null;
        NortelImpl instance = null;
        boolean expResult = false;
        boolean result = instance.equals(dev);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
