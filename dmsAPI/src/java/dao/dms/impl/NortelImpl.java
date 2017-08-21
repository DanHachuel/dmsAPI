/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.AbstractDMS;
import dao.dms.impl.tratativa.Tratativa;
import dao.dms.impl.tratativa.TratativaConfiguracaoDMS;
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
    public ConfiguracaoDMS consultar(String instancia) throws Exception {
        ConfiguracaoDMS c = new ConfiguracaoDMS();
        ComandoDMS cmd = command().consulta(qdn(instancia));

        Tratativa<ConfiguracaoDMS> t = new TratativaConfiguracaoDMS();
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
    public void conectar() {
        super.conectar();
        try {
            command().consulta(servord());
        } catch (Exception ex) {
            Logger.getLogger(NortelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
