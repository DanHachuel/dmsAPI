/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.credencial.Credencial;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.dms.impl.login.LoginTelnetStrategy;

/**
 *
 * @author G0041775
 */
public abstract class AbstractTelnetHost implements ManagerDMS {

    private final String ip;
    private Credencial credencial;
    private LoginTelnetStrategy loginStrategy;
    private ConsultaSocket cd;

    public AbstractTelnetHost(String ipDslam, Credencial credencial, LoginTelnetStrategy loginStrategy) {
        this.ip = ipDslam;
        this.credencial = credencial;
        this.loginStrategy = loginStrategy;
        this.cd = new ConsultaSocket(this);
    }

    public void conectar() throws Exception {
        this.loginStrategy.conectar(this.command());
    }

    public void desconectar() {
        try {
            this.cd.close();
        } catch (IOException ex) {
            Logger.getLogger(AbstractTelnetHost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getIpDslam() {
        return this.ip;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public LoginTelnetStrategy getLoginStrategy() {
        return loginStrategy;
    }

    public void setLoginStrategy(LoginTelnetStrategy loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    public ConsultaSocket command() {
        return cd;
    }

    public void setCd(ConsultaSocket cd) {
        this.cd = cd;
    }

}