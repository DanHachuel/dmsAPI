/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.login;

import dao.dms.impl.ConsultaDslam;
import exception.SwitchLotadaException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author G0042204
 */
public class LoginCustomDMS implements LoginTelnetStrategy {

    private ConsultaDslam cs;

    @Override
    public void conectar(ConsultaDslam cs) throws Exception {

        this.cs = cs;
        this.cs.pingSocket = new Socket(this.cs.dslam.getIpDslam(), 23);
        this.cs.out = new PrintWriter(this.cs.pingSocket.getOutputStream(), true);
        this.cs.in = new BufferedReader(new InputStreamReader(this.cs.pingSocket.getInputStream()));
        this.cs.out.println(this.cs.dslam.getCredencial().getLogin());
        this.cs.out.println(this.cs.dslam.getCredencial().getPass());
        this.tratativaCentralLotada();
    }

    protected void tratativaCentralLotada() throws SwitchLotadaException, IOException {
        for (String s : this.cs.getRetorno()) {
            if (s.toUpperCase().contains("SUICIDE")) {
                throw new SwitchLotadaException();
            }
        }
    }

}
