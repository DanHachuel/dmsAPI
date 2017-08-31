/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.in.ConsultaDMSIn;
import java.util.Calendar;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.dms.ConfiguracaoDMS;
import model.dms.service.FactoryService;
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
        System.out.println("ConsultaDMSIn");
        try {
            ServiceDMS serv = FactoryService.create();
            ConfiguracaoDMS consultar = serv.consultar(in.getDms());
            in.setDataLogOut(Calendar.getInstance());
            r = ok(consultar);
        } catch (Exception e) {
            r = serverError(e);
        } finally {

        }

        return r;
    }

}
