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
import model.dms.ServiceType;
import model.dms.adapter.ConfiguracaoDMSAdapter;
import model.dms.dto.ConfiguracaoDMSDTO;
import model.dms.dto.LineServiceDTO;
import model.dms.dto.NcosDTO;
import model.dms.service.FactoryService;
import model.dms.service.ServiceContextDMS;
import model.dms.service.ServiceContextDMSImpl;
import model.dms.service.ServiceDMS;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
@Path("/contextDMS")
public class ContextDMSController extends RestJaxAbstract {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response singleton() throws Exception {
        Response r = null;
        ServiceContextDMS serv = new ServiceContextDMSImpl();
        r = ok(serv.contextDetail());
        return r;
    }

    @GET
    @Path("/connection/{state}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response singletonConnections(@PathParam("state") Boolean state) throws Exception {
        ServiceContextDMS serv = new ServiceContextDMSImpl();
        if (state) {
            serv.connectSwitches();
        } else {
            serv.disconnectSwitches();
        }
        return ok(serv.contextDetail());
    }

    @GET
    @Path("/connectSwitch/{ip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response connectSwitch(@PathParam("ip") String ip) throws Exception {
        ServiceContextDMS serv = new ServiceContextDMSImpl();
        return ok(serv.connectSwitch(ip));
    }

    @GET
    @Path("/disconnectSwitch/{ip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response disconnectSwitch(@PathParam("ip") String ip) throws Exception {
        ServiceContextDMS serv = new ServiceContextDMSImpl();
        return ok(serv.disconnectSwitch(ip));
    }

}
