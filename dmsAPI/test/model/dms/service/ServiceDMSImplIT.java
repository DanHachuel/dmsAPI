/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import controller.in.CriarLinhaIn;
import controller.in.DeletarLinhaIn;
import controller.in.EditCustGrpIn;
import controller.in.EditNcosIn;
import controller.in.EditServIn;
import controller.in.ManobrarLinhaIn;
import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.tratativa.TratativaLenDMS;
import java.util.ArrayList;
import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.ConfiguracoesShelf;
import model.dms.ConsultaDMS;
import model.dms.EstadoDaPortaEnum;
import model.dms.Len;
import model.dms.LineService;
import model.dms.LineStatus;
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

    private ServiceDMSImpl instance = new ServiceDMSImpl();

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
            in.setDn("8160098017");
            in.setCentral(SwitchesEnum.PERCE_LNS01.name());

            ConfiguracaoDMS result = instance.consultar(in);
            ConfiguracaoDMS result1 = instance.consultar(in);
            System.out.println("Result:" + GsonUtil.serialize(result));
            System.out.println("Result:" + GsonUtil.serialize(result1));
            System.out.println("end");
            assertTrue(result.getStatus() == LineStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of criarLinha method, of class ServiceDMSImpl.
     */
    @Test
    public void testCriarLinha() throws Exception {
        System.out.println("criarLinha");
        CriarLinhaIn in = new CriarLinhaIn();

        ConfiguracaoDMS expResult = null;
        ConfiguracaoDMS result = instance.criarLinha(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarLinha method, of class ServiceDMSImpl.
     */
    @Test
    public void testDeletarLinha() throws Exception {
        System.out.println("deletarLinha");
        DeletarLinhaIn in = new DeletarLinhaIn();
        ConsultaDMS dms = new ConsultaDMS();
        dms.setCentral("ESVTA_ASS01");
        dms.setDn("2760005674");
        in.setDms(dms);
        TratativaLenDMS trat = new TratativaLenDMS();
        Len len = trat.parse("VTAA  02 5 00 26");
        in.setLen(len);

//        ConfiguracaoDMS expResult = null;
        ConfiguracaoDMS result = instance.deletarLinha(in);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarConfiguracoesShelf method, of class ServiceDMSImpl.
     */
    @Test
    public void testConsultarConfiguracoesShelf() throws Exception {
        System.out.println("consultarConfiguracoesShelf");
        ConsultaDMS in = null;
        ConfiguracoesShelf expResult = null;
        ConfiguracoesShelf result = instance.consultarConfiguracoesShelf(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarServicos method, of class ServiceDMSImpl.
     */
    @Test
    public void testEditarServicos() throws Exception {
        System.out.println("editarServicos");
        EditServIn in = new EditServIn();
        ConsultaDMS dms = new ConsultaDMS();
        dms.setCentral("SPGRS_TPS01");
        dms.setDn("1149707585");
        in.setDms(dms);
        in.setInstancia("1149707585");
        List<LineService> services = new ArrayList<>();
        services.add(LineService.CONV_TRES);
        services.add(LineService.LIG_SIMULT);
        services.add(LineService.DIGITAL);
        services.add(LineService.IDENT_CHAM);
        services.add(LineService.SEC_ELETRONICA);
        services.add(LineService.BLOQ_PROG_0500);
        services.add(LineService.BLOQ_PROG_0900);
        in.setServices(services);
        ConfiguracaoDMS result = instance.editarServicos(in);
        System.out.println(GsonUtil.serialize(services));
    }

    /**
     * Test of manobrarLinha method, of class ServiceDMSImpl.
     */
    @Test
    public void testManobrarLinha() throws Exception {
        System.out.println("manobrarLinha");
        ManobrarLinhaIn in = null;
        ServiceDMSImpl instance = new ServiceDMSImpl();
        ConfiguracaoDMS expResult = null;
        ConfiguracaoDMS result = instance.manobrarLinha(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarCustGrp method, of class ServiceDMSImpl.
     */
    @Test
    public void testEditarCustGrp() throws Exception {
        System.out.println("editarCustGrp");
        EditCustGrpIn in = null;
        ServiceDMSImpl instance = new ServiceDMSImpl();
        ConfiguracaoDMS expResult = null;
        ConfiguracaoDMS result = instance.editarCustGrp(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarNcos method, of class ServiceDMSImpl.
     */
    @Test
    public void testEditarNcos() throws Exception {
        System.out.println("editarNcos");
        EditNcosIn in = null;
        ServiceDMSImpl instance = new ServiceDMSImpl();
        ConfiguracaoDMS expResult = null;
        ConfiguracaoDMS result = instance.editarNcos(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetarPorta method, of class ServiceDMSImpl.
     */
    @Test
    public void testResetarPorta() throws Exception {
        System.out.println("resetarPorta");

        System.out.println("consultar");
        try {
            ConsultaDMS in = new ConsultaDMS();
            in.setDn("8560971414");
            in.setCentral(SwitchesEnum.CEFLA_JBS01.name());

            ConfiguracaoDMS result = instance.resetarPorta(in);
            System.out.println("Result:" + GsonUtil.serialize(result));
            System.out.println("end");
            assertTrue(result.getEstado().getKey().equalsIgnoreCase(EstadoDaPortaEnum.IDL.name()));

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

}
