/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author G0042204
 */
@Path("/dms")
public class DMSController extends RestJaxAbstract {

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Integer id) {
        Response r = null;
//        try {
//            dao = FactoryDAO.create();
//            LogManobra l = new LogManobra();
//            l.setId(id);
//
//            r = ok(dao.buscarPorId(l));
//        } catch (Exception e) {
//            r = serverError(e);
//        } finally {
//            dao.close();
//        }

        return r;
    }

    @POST
    @Path("/analitico")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response analitico(String in) {
        Response r = null;
//        try {
//            AnalisadorManobra f = new AnalisadorManobraFacade(in.getCust());
//            FinalizacaoManobra fim = f.analisar();
//
//            try {
//                LogManobra l = new LogManobra(in.getCust());
//                l.setCustomer(GsonUtil.serialize(in.getCust()));
//                l.setAnalises(GsonUtil.serialize(fim));
//                l.setExecutor(in.getExecutor());
//                l.setConclusao(fim.getConclusao().getConclusao());
//                l.setMotivo(fim.getConclusao().getMotivo());
//                l.setManobrar(fim.getManobrar());
//                l.setMotivoEntrada(in.getMotivo());
//                dao = FactoryDAO.create();
//                dao.cadastrar(l);
//                dao.close();
//            } catch (Exception ex) {
//                Logger.getLogger(DMSController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            r = ok(FinalizacaoManobraAdapter.adapter(fim));
//        } catch (Exception e) {
//            r = serverError(e);
//        }

        return r;
    }

}
