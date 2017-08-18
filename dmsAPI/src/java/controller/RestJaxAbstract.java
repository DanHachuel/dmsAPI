/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.core.Response;

/**
 *
 * @author G0042204
 */
public class RestJaxAbstract {

    public Response ok(Object o) {
        return Response.status(200).entity(o).build();
    }

    public Response serverError(Object o) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(o).build();
    }

}
