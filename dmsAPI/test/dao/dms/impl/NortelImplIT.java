/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import com.google.gson.Gson;
import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.tratativa.Tratativa;
import dao.dms.impl.tratativa.TratativaLenDMS;
import exception.LinhaNaoPertenceCentralException;
import java.util.ArrayList;
import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.FacilidadesMapci;
import model.dms.Len;
import model.dms.LineService;
import model.dms.dto.LineServiceDTO;
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

    private NortelImpl instance = new NortelImpl(SwitchesEnum.MGBHE_HMS01);

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
            List<FacilidadesMapci> listarLens = instance.listarLensLivres(trat.parse("FLAB  15 0 03 36"));
            System.out.println("tamanho:" + listarLens.size());
        } catch (Exception e) {

        }
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
     * Test of criarLinha method, of class NortelImpl.
     */
    @Test
    public void testCriarLinha() throws Exception {
        System.out.println("criarLinha");
        String json = "{\"dn\":\"5130382205\",\"len\":\"CBMV  01 4 01 17\",\"custGrp\":\"CBM_POS\",\"ncos\":1,\"status\":\"CREATED\",\"servicos\":[{\"desc\":\"Ligação Simultânea\",\"key\":\"CWT\"},{\"desc\":\"Digital (TOM / TONE)\",\"key\":\"DGT\"},{\"desc\":\"Identificador de Chamadas\",\"key\":\"DDN\"},{\"desc\":\"Identificador de Chamadas\",\"key\":\"NOAMA\"}]}";
        Gson leG = new Gson();
        ConfiguracaoDMS linha = leG.fromJson(json, ConfiguracaoDMS.class);
        instance = new NortelImpl(SwitchesEnum.RSNHO_MAS01);
        ConfiguracaoDMS expResult = linha;
        ConfiguracaoDMS result = instance.criarLinha(linha);
        assertEquals(expResult.getLen(), result.getLen());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deletarLinha method, of class NortelImpl.
     */
    @Test
    public void testDeletarLinha() throws Exception {
        System.out.println("deletarLinha");
        instance = new NortelImpl(SwitchesEnum.ESVTA_ASS01);
        ConfiguracaoDMS linha = instance.consultarPorDn("2760005674");
        System.out.println(GsonUtil.serialize(linha));
//        instance.deletarLinha(linha);
//        System.out.println(GsonUtil.serialize(instance.consultarPorDn("8130206712")));

        // TODO review the generated test code and remove the default call to fail.
    }

//    @Test
//    public void alteraPass() throws Exception {
//        System.out.println("alteraPass");
//        List<SwitchesEnum> l = new ArrayList<>();
//        for (SwitchesEnum sw : SwitchesEnum.values()) {
//            instance = new NortelImpl(sw);
//            instance.setCredencial(Credencial.QUATRO);
//            try {
//                instance.alteraSenha(Credencial.QUATRO.getPass(), "binholoco01");
//            } catch (Exception e) {
//                l.add(sw);
//            }
//
//        }
//        l.forEach((t) -> {
//            System.out.println("ndeu-> "+t.name()+" - "+t.getIp());
//        });
//        
//
//    }
    /**
     * Test of adicionarServico method, of class NortelImpl.
     */
    @Test
    public void testAdicionarServico() throws Exception {
        System.out.println("adicionarServico");
        instance = new NortelImpl(SwitchesEnum.ESVTA_ASS01);
        ConfiguracaoDMS linha = instance.consultarPorDn("2760005674");
        System.out.println(GsonUtil.serialize(linha));
        List<LineServiceDTO> services = new ArrayList<>();
        services.add(LineService.CONV_TRES.dto());
        services.add(LineService.LIG_SIMULT.dto());
        services.add(LineService.DIGITAL.dto());
        services.add(LineService.IDENT_CHAM.dto());
        instance.adicionarServico(linha, services);

        System.out.println(GsonUtil.serialize(instance.consultarPorDn("2760005674")));
        
        
    }

    /**
     * Test of removerServico method, of class NortelImpl.
     */
    @Test
    public void testRemoverServico() throws Exception {
        System.out.println("removerServico");
        instance = new NortelImpl(SwitchesEnum.ESVTA_ASS01);
        ConfiguracaoDMS linha = instance.consultarPorDn("2760005674");
        System.out.println(GsonUtil.serialize(linha));
        List<LineServiceDTO> services = new ArrayList<>();
        services.add(LineService.CONV_TRES.dto());
        services.add(LineService.LIG_SIMULT.dto());
        services.add(LineService.IDENT_CHAM.dto());
        instance.removerServico(linha, services);
        
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

    @Test
    public void testConsultarEstadoDaPorta() {
        System.out.println("consultar");
        try {
            String instancia = "8560971414";
            FacilidadesMapci result = instance.consultarEstadoDaPorta(instance.consultarPorDn(instancia).getLen());
            System.out.println("Resultado: " + GsonUtil.serialize(result));
            assertTrue("consulta", result != null);
            assertTrue("ok", result.getState().isValid());
        } catch (Exception e) {
            fail(e.getMessage());
        } finally {
            instance.desconectar();
        }
    }

    /**
     * Test of consultarPorLen method, of class NortelImpl.
     */
    @Test
    public void testConsultarPorLen() throws Exception {

        try {
            System.out.println("consultarPorLen");
            Tratativa<Len> trat = new TratativaLenDMS();
            Len len = trat.parse("BHEB 17 4 01 84");
            ConfiguracaoDMS result = instance.consultarPorLen(len);
            System.out.println("Resultado: " + GsonUtil.serialize(result));
            assertTrue("consulta", result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        } finally {
            instance.desconectar();
        }

    }

    /**
     * Test of alterarNcos method, of class NortelImpl.
     */
    @Test
    public void testAlterarNcos() throws Exception {
        System.out.println("alterarNcos");
        String instancia = "8560971414";
        instance.alterarNcos(instance.consultarPorDn(instancia));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarCustGroup method, of class NortelImpl.
     */
    @Test
    public void testAlterarCustGroup() throws Exception {
        System.out.println("alterarCustGroup");
        ConfiguracaoDMS linha = null;
        NortelImpl instance = null;
        instance.alterarCustGroup(linha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alteraSenha method, of class NortelImpl.
     */
    @Test
    public void testAlteraSenha() throws Exception {
        System.out.println("alteraSenha");
        String oldPass = "";
        String newPass = "";
        NortelImpl instance = null;
        instance.alteraSenha(oldPass, newPass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLens method, of class NortelImpl.
     */
    @Test
    public void testListarLens() throws Exception {
        System.out.println("listarLens");
        Len len = null;
        NortelImpl instance = null;
        List<FacilidadesMapci> expResult = null;
        List<FacilidadesMapci> result = instance.listarLens(len);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLensLivres method, of class NortelImpl.
     */
    @Test
    public void testListarLensLivres() throws Exception {
        System.out.println("listarLensLivres");
        Len len = null;
        NortelImpl instance = null;
        List<FacilidadesMapci> expResult = null;
        List<FacilidadesMapci> result = instance.listarLensLivres(len);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of abort method, of class NortelImpl.
     */
    @Test
    public void testAbort() throws Exception {
        System.out.println("abort");
        NortelImpl instance = null;
        instance.abort();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
