/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.login;

import dao.dms.impl.SocketDMS;
import exception.FalhaAoConectarCentralException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author G0042204
 */
public class LoginWindowsCustomDMS implements LoginTelnetStrategy {

    private SocketDMS cs;

    @Override
    public void conectar(SocketDMS cs) throws Exception {
        try {
            this.cs = cs;
            this.cs.pingSocket = new Socket();
            this.cs.pingSocket.connect(new InetSocketAddress(this.cs.dslam.getIpDslam(), 23), 10000);
            this.cs.pingSocket.setKeepAlive(true);
            this.cs.out = new PrintWriter(this.cs.pingSocket.getOutputStream(), true);
            this.cs.in = new BufferedReader(new InputStreamReader(this.cs.pingSocket.getInputStream()));
            this.cs.out.println(this.cs.dslam.getCredencial().getLogin());
            this.cs.out.println(this.cs.dslam.getCredencial().getPass());
        } catch (IOException e) {
            throw new FalhaAoConectarCentralException();
        }
    }

}
