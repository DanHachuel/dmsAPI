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
public abstract class AbstractTelnetHost implements ConsultaDMS {

    private final String ipDslam;
    private Credencial credencial;
    public LoginTelnetStrategy loginStrategy;

    private ConsultaDslam cd;

    public AbstractTelnetHost(String ipDslam, Credencial credencial, LoginTelnetStrategy loginStrategy) {
        this.ipDslam = ipDslam;
        this.credencial = credencial;
        this.loginStrategy = loginStrategy;
        this.cd = new ConsultaDslam(this);
    }

    public void conectar() {
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
        return this.ipDslam;
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

    public ConsultaDslam command() {
        return cd;
    }

    public void setCd(ConsultaDslam cd) {
        this.cd = cd;
    }

}