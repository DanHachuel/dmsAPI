/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.AbstractDMS;
import dao.dms.impl.tratativa.Tratativa;
import dao.dms.impl.tratativa.TratativaQdnDMS;
import dao.dms.impl.tratativa.TratativaQlenDMS;
import exception.LoginSwitchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dms.ConfiguracaoDMS;
import model.dms.LineService;

/**
 *
 * @author G0042204
 */
public class NortelImpl extends AbstractDMS implements ConsultaDMS {

    public NortelImpl(String ipDslam) {
        super(ipDslam);
    }

    @Override
    public ConfiguracaoDMS consultarPorInstancia(String instancia) throws Exception {
        ConfiguracaoDMS c = new ConfiguracaoDMS();
        ComandoDMS cmd = command().consulta(qdn(instancia));
        Tratativa<ConfiguracaoDMS> t = new TratativaQdnDMS();
        return t.parse(cmd.getBlob());
    }

    @Override
    public ConfiguracaoDMS consultarPorLen(String len) throws Exception {
        ConfiguracaoDMS c = new ConfiguracaoDMS();
        ComandoDMS cmd = command().consulta(qlen(len));
        Tratativa<ConfiguracaoDMS> t = new TratativaQlenDMS();
        return t.parse(cmd.getBlob());
    }

    /**
     *
     * @param instancia
     * @return
     */
    protected ComandoDMS qdn(String instancia) {
        return new ComandoDMS("qdn " + instancia);
    }

    protected ComandoDMS qlen(String facilidade) {
        return new ComandoDMS("qlen " + facilidade);
    }

    protected ComandoDMS logout() {
        return new ComandoDMS("logout");
    }

    protected ComandoDMS delete(String facilidade) {
        return new ComandoDMS("OUT $ " + facilidade + " BLDN Y");
    }

    protected ComandoDMS servord() {
        return new ComandoDMS("servord");
    }

    public ComandoDMS ativarServico(String dn, LineService serv) {
        return new ComandoDMS("ADO $ " + dn + " " + serv.getKey() + " $ Y");
    }

    public ComandoDMS desativarServico(String dn, LineService serv) {
        return new ComandoDMS("DEO $ " + dn + " " + serv.getKey() + " $ Y");
    }

    public ComandoDMS manobrar(String facilidadeAtual, String facilidadeNova) throws Exception {
        if (facilidadeNova.isEmpty() || facilidadeAtual.isEmpty()) {
            throw new Exception("Facilidades não preenchidas.");
        }
        return new ComandoDMS("CLN $ " + facilidadeAtual + " " + facilidadeNova + " Y");
    }

    @Override
    public void conectar() throws Exception {
        super.conectar();
        ComandoDMS cmd = command().consulta(servord());
        if (!isLogged(cmd.getBlob())) {
            throw new LoginSwitchException();
        }
    }

    protected boolean isLogged(String param) {
        return param.contains(">SO:");
    }

    @Override
    public void desconectar() {
        try {
            command().consulta(logout());
            super.desconectar(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(NortelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
