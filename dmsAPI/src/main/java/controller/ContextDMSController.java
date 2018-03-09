/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.in.SwitchActionIn;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.dms.service.ServiceContextDMS;
import model.dms.service.ServiceContextDMSImpl;

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

    @POST
    @Path("/connectSwitch")
    @Produces(MediaType.APPLICATION_JSON)
    public Response connectSwitch(SwitchActionIn ip) throws Exception {
        try {
            ServiceContextDMS serv = new ServiceContextDMSImpl();
            return ok(serv.connectSwitch(ip.getIp()));
        } catch (Exception e) {
            return serverError(e);
        }
    }

    @POST
    @Path("/disconnectSwitch")
    @Produces(MediaType.APPLICATION_JSON)
    public Response disconnectSwitch(SwitchActionIn ip) throws Exception {
        try {
            ServiceContextDMS serv = new ServiceContextDMSImpl();
            return ok(serv.disconnectSwitch(ip.getIp()));
        } catch (Exception e) {
            return serverError(e);
        }
    }

}
