/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import controller.in.CriarLinhaIn;
import controller.in.DeletarLinhaIn;
import controller.in.EditServIn;
import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.tratativa.TratativaLenDMS;
import java.util.ArrayList;
import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.ConfiguracoesShelf;
import model.dms.ConsultaDMS;
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
            in.setDn("8560971414");
            in.setCentral(SwitchesEnum.CEFLA_JBS01.name());

            
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
        dms.setCentral("ESVTA_ASS01");
        dms.setDn("2760005674");
        in.setDms(dms);
        List<LineService> services = new ArrayList<>();
        services.add(LineService.CONV_TRES);
        services.add(LineService.LIG_SIMULT);
        services.add(LineService.DIGITAL);
        services.add(LineService.IDENT_CHAM);
        in.setServices(services);
        ConfiguracaoDMS result = instance.editarServicos(in);
        System.out.println(GsonUtil.serialize(services));
        // TODO review the generated test code and remove the default call to fail.
    }

}
