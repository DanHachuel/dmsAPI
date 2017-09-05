/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.tratativa.Tratativa;
import dao.dms.impl.tratativa.TratativaLenDMS;
import exception.LinhaNaoPertenceCentralException;
import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaFacilidades;
import model.dms.Len;
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

    @Test
    public void test() {
        try {
            Tratativa<Len> trat = new TratativaLenDMS();
            List<ConsultaFacilidades> listarLens = instance.listarLensLivres(trat.parse("FLAB  15 0 03 36"));
            System.out.println("tamanho:" + listarLens.size());
        } catch (Exception e) {
            
        }
        instance.desconectar();

    }

}
