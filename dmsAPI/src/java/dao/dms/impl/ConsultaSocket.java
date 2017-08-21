/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import dao.dms.impl.login.LoginTelnetStrategy;

/**
 *
 * @author G0042204
 */
public class ConsultaSocket implements Conector {

    public Socket pingSocket;
    public PrintWriter out;
    public BufferedReader in;
    public AbstractTelnetHost dslam;
    public LoginTelnetStrategy styLogin;
    private Boolean busy;

    public ConsultaSocket(AbstractTelnetHost dslam) {
        this.dslam = dslam;
        this.busy = false;
    }

    @Override
    public void conectar() throws Exception {
        this.dslam.conectar();
    }

    public List<String> getRetorno() throws IOException {
        List<String> list = new ArrayList<>();
        try {
            String line;
            while ((line = in.readLine()) != null) {
                list.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            return list;
        } finally {
            this.busy = false;
        }
        return list;
    }

    @Override
    public void close() throws IOException {
        if (out != null) {
            out.close();
            in.close();
            pingSocket.close();
        }
    }

    public ComandoDMS consulta(ComandoDMS comando) throws Exception {

        try {
            if (pingSocket == null) {
                this.conectar();
            }

            int i = 0;
            while (busy) {
                i++;
                Thread.sleep(1000);
            }

            System.out.println("Sleeps:" + i);

            this.busy = true;
            pingSocket.setSoTimeout(comando.getSleep());
            out.println(comando.getSintax());
            if (comando.getSintaxAux() != null) {
                Thread.sleep(comando.getSleep());
                pingSocket.setSoTimeout(comando.getSleepAux());
                out.println(comando.getSintaxAux());
                if (comando.getSintaxAux2() != null) {
                    Thread.sleep(comando.getSleepAux());
                    pingSocket.setSoTimeout(comando.getSleep());
                    out.println(comando.getSintaxAux2());
                }
            }

            comando.setRetorno(this.getRetorno());
            return comando;

        } catch (IOException e) {
            throw e;
        }
    }

}
