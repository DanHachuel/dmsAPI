/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import br.net.gvt.efika.customer.EfikaCustomer;
import model.manobra.analitcs.MotivoManobraEnum;

/**
 *
 * @author G0042204
 */
public class AnaliticoIn {

    private String executor;

    private EfikaCustomer cust;

    private MotivoManobraEnum motivo;

    public AnaliticoIn() {
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public EfikaCustomer getCust() {
        return cust;
    }

    public void setCust(EfikaCustomer cust) {
        this.cust = cust;
    }

    public MotivoManobraEnum getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivoManobraEnum motivo) {
        this.motivo = motivo;
    }

}
