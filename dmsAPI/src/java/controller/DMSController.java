/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.in.ConsultaDMSIn;
import controller.in.CriarLinhaIn;
import controller.in.DeletarLinhaIn;
import controller.in.EditCustGrpIn;
import controller.in.EditNcosIn;
import controller.in.EditServIn;
import controller.in.ListarLensLivresIn;
import controller.in.ManobrarLinhaIn;
import controller.in.ResetarPortaIn;
import dao.FactoryDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.dms.ConfiguracaoDMS;
import model.dms.ConfiguracoesShelf;
import model.dms.LineService;
import model.dms.Ncos;
import model.dms.adapter.ConfiguracaoDMSAdapter;
import model.dms.dto.ConfiguracaoDMSDTO;
import model.dms.dto.LineServiceDTO;
import model.dms.dto.NcosDTO;
import model.dms.service.FactoryService;
import model.dms.service.ServiceContextDMS;
import model.dms.service.ServiceContextDMSImpl;
import model.dms.service.ServiceDMS;

/**
 *
 * @author G0042204
 */
@Path("/dms")
public class DMSController extends RestJaxAbstract {

    @POST
    @Path("/consultar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultar(ConsultaDMSIn in) throws Exception {
        Response r = null;
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracaoDMS consultar = serv.consultar(in.getDms());
            in.setDataLogOut(Calendar.getInstance());
            ConfiguracaoDMSDTO leR = ConfiguracaoDMSAdapter.adapt(consultar);
            r = ok(leR);
            in.setSaida(consultar);
        } catch (Exception e) {
            r = serverError(e);
            in.setSaida(e);
        } finally {

            FactoryDAO.create().cadastrar(in.log());
        }
        return r;
    }

    @POST
    @Path("/consultarConfiguracoesShelf")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarConfiguracoesShelf(ListarLensLivresIn in) throws Exception {
        Response r = null;
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracoesShelf lst = serv.consultarConfiguracoesShelf(in.getDms());
            in.setDataLogOut(Calendar.getInstance());
            r = ok(lst);
            in.setSaida(lst);
        } catch (Exception e) {
            r = serverError(e);
            in.setSaida(e);
        } finally {
            FactoryDAO.create().cadastrar(in.log());
        }
        return r;
    }

    @POST
    @Path("/criarLinha")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarLinha(CriarLinhaIn in) throws Exception {
        Response r = null;
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracaoDMS linha = serv.criarLinha(in);
            in.setDataLogOut(Calendar.getInstance());
            r = ok(ConfiguracaoDMSAdapter.adapt(linha));
            in.setSaida(linha);
        } catch (Exception e) {
            r = serverError(e);
            in.setSaida(e);
        } finally {
            FactoryDAO.create().cadastrar(in.log());
        }
        return r;
    }

    @POST
    @Path("/deletarLinha")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarLinha(DeletarLinhaIn in) throws Exception {
        Response r = null;
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracaoDMS linha = serv.deletarLinha(in);
            in.setDataLogOut(Calendar.getInstance());
            r = ok(ConfiguracaoDMSAdapter.adapt(linha));
            in.setSaida(linha);
        } catch (Exception e) {
            r = serverError(e);
            in.setSaida(e);
        } finally {
            FactoryDAO.create().cadastrar(in.log());
        }
        return r;
    }

    @POST
    @Path("/editarServicos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editarServicos(EditServIn in) throws Exception {
        Response r = null;
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracaoDMS linha = serv.editarServicos(in);
            in.setDataLogOut(Calendar.getInstance());
            r = ok(ConfiguracaoDMSAdapter.adapt(linha));
            in.setSaida(linha);
        } catch (Exception e) {
            r = serverError(e);
            in.setSaida(e);
        } finally {
            FactoryDAO.create().cadastrar(in.log());
        }
        return r;
    }

    @POST
    @Path("/manobrarLinha")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response manobrarLinha(ManobrarLinhaIn in) throws Exception {
        Response r = null;
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracaoDMS linha = serv.manobrarLinha(in);
            in.setDataLogOut(Calendar.getInstance());
            r = ok(ConfiguracaoDMSAdapter.adapt(linha));
            in.setSaida(linha);
        } catch (Exception e) {
            r = serverError(e);
            in.setSaida(e);
        } finally {
            FactoryDAO.create().cadastrar(in.log());
        }
        return r;
    }

    @POST
    @Path("/resetarPorta")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response resetarPorta(ResetarPortaIn in) throws Exception {
        Response r = null;
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracaoDMS consultar = serv.resetarPorta(in.getDms());
            in.setDataLogOut(Calendar.getInstance());
            r = ok(ConfiguracaoDMSAdapter.adapt(consultar));
            in.setSaida(consultar);
        } catch (Exception e) {
            r = serverError(e);
            in.setSaida(e);
        } finally {
            FactoryDAO.create().cadastrar(in.log());
        }
        return r;
    }

    @POST
    @Path("/editarCustGrp")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response manobrarLinha(EditCustGrpIn in) throws Exception {
        Response r = null;
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracaoDMS linha = serv.editarCustGrp(in);
            in.setDataLogOut(Calendar.getInstance());
            r = ok(ConfiguracaoDMSAdapter.adapt(linha));
            in.setSaida(linha);
        } catch (Exception e) {
            r = serverError(e);
            in.setSaida(e);
        } finally {
            FactoryDAO.create().cadastrar(in.log());
        }
        return r;
    }

    @POST
    @Path("/editarNcos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response manobrarLinha(EditNcosIn in) throws Exception {
        Response r = null;
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracaoDMS linha = serv.editarNcos(in);
            in.setDataLogOut(Calendar.getInstance());
            r = ok(ConfiguracaoDMSAdapter.adapt(linha));
            in.setSaida(linha);
        } catch (Exception e) {
            r = serverError(e);
            in.setSaida(e);
        } finally {
            FactoryDAO.create().cadastrar(in.log());
        }
        return r;
    }

    @GET
    @Path("/singleton")
    @Produces(MediaType.APPLICATION_JSON)
    public Response singleton() throws Exception {
        Response r = null;
        ServiceContextDMS serv = new ServiceContextDMSImpl();
        r = ok(serv.contextDetail());
        return r;
    }

    @GET
    @Path("/singleton/connection/{state}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response singletonConnections(@PathParam("state") Boolean state) throws Exception {
        Response r = null;
        ServiceContextDMS serv = new ServiceContextDMSImpl();
        if (state) {
            serv.connectSwitches();
        } else {
            serv.disconnectSwitches();
        }
        r = ok(serv.contextDetail());
        return r;
    }

    @GET
    @Path("/servicos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response servicos() throws Exception {
        Response r = null;
        List<LineServiceDTO> dtos = new ArrayList<>();
        for (LineService v : LineService.values()) {
            dtos.add(v.dto());
        }
        r = ok(dtos);
        return r;
    }

    @GET
    @Path("/ncos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ncos() throws Exception {
        Response r = null;
        List<NcosDTO> dtos = new ArrayList<>();
        for (Ncos v : Ncos.values()) {
            dtos.add(v.dto());
        }
        r = ok(dtos);
        return r;
    }
}
