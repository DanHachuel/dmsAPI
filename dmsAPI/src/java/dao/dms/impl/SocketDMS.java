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
import java.util.logging.Level;
import java.util.logging.Logger;
import util.OSValidator;

/**
 *
 * @author G0042204
 */
public class SocketDMS implements Conector {

    public Socket pingSocket;
    public PrintWriter out;
    public BufferedReader in;
    public AbstractHost dslam;
    public LoginTelnetStrategy styLogin;
    private Boolean busy, connected;

    public SocketDMS(AbstractHost dslam) {
        this.dslam = dslam;
        this.busy = false;
        this.connected = false;
    }

    @Override
    public void conectar() throws Exception {
        try {
            this.connected = true;
            this.busy = true;
            this.dslam.conectar();
        } catch (Exception e) {
            this.connected = false;
            throw e;
        } finally {
            this.busy = false;
        }
    }

    public List<String> getRetorno() {
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
        try {
            pingSocket.close();
            out.close();
            in.close();

            pingSocket = null;
            out = null;
            in = null;

            this.connected = false;
        } catch (Exception e) {
            Logger.getLogger(SocketDMS.class.getName()).log(Level.WARNING, e.getMessage());
        }
    }

    public ComandoDMS consulta(ComandoDMS comando) throws Exception {

        try {
            if (!this.connected) {
                try {
                    this.conectar();
                } catch (Exception e) {
                    this.close();
                    throw e;
                }
            }

            int i = 0;
            while (busy) {
                i++;
                Thread.sleep(1000);
            }

            if (i > 0) {
                System.out.println("Sleeps:" + i);
            }

            this.busy = true;
            pingSocket.setSoTimeout(comando.getSleep());

            if (OSValidator.isWindows()) {
                out.println(comando.getSintax());
            } else {
                out.println(comando.getSintax() + "\n\r");
            }

            if (comando.getSintaxAux() != null) {
//                Thread.sleep(comando.getSleep());
                pingSocket.setSoTimeout(comando.getSleepAux());
                if (OSValidator.isWindows()) {
                    out.println(comando.getSintaxAux());
                } else {
                    out.println(comando.getSintaxAux() + "\n\r");
                }
                if (comando.getSintaxAux2() != null) {
//                    Thread.sleep(comando.getSleepAux());
                    pingSocket.setSoTimeout(comando.getSleep());
                    if (OSValidator.isWindows()) {
                        out.println(comando.getSintaxAux2());
                    } else {
                        out.println(comando.getSintaxAux2() + "\n\r");
                    }

                    if (comando.getSintaxAux3() != null) {
//                    Thread.sleep(comando.getSleepAux());
                        pingSocket.setSoTimeout(comando.getSleep());
                        if (OSValidator.isWindows()) {
                            out.println(comando.getSintaxAux3());
                        } else {
                            out.println(comando.getSintaxAux3() + "\n\r");
                        }
                    }
                }
            }
            comando.setRetorno(this.getRetorno());
            return comando;

        } catch (IOException e) {
            throw e;
        }
    }

    public Boolean isBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    public Boolean isConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

}
