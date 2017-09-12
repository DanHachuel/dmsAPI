/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.filter.Filter;
import dao.dms.impl.filter.FilterLen;
import dao.dms.impl.filter.FilterLensLivres;
import dao.dms.impl.tratativa.Tratativa;
import dao.dms.impl.tratativa.TratativaConsultaFacilidades;
import dao.dms.impl.tratativa.TratativaQdnDMS;
import dao.dms.impl.tratativa.TratativaQlenDMS;
import exception.FalhaAoConsultarEstadoException;
import exception.FalhaAoConsultarLensException;
import exception.FalhaAoExecutarComandoDeAlteracaoException;
import exception.LoginSwitchException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dms.ConfiguracaoDMS;
import model.dms.FacilidadesMapci;
import model.dms.Len;
import model.dms.LineService;
import model.dms.dto.LineServiceDTO;

/**
 *
 * @author G0042204
 */
public class NortelImpl extends AbstractDMS {

    public NortelImpl(SwitchesEnum central) {
        super(central);
    }

    @Override
    public ConfiguracaoDMS consultarPorDn(String dn) throws Exception {
        ComandoDMS cmd = command().consulta(qdn(dn));
        Tratativa<ConfiguracaoDMS> t = new TratativaQdnDMS();
        ConfiguracaoDMS conf = t.parse(cmd.getBlob());
        conf.setDn(dn);
        return conf;
    }

    @Override
    public ConfiguracaoDMS consultarPorLen(Len len) throws Exception {
        ComandoDMS cmd = command().consulta(qlen(len.toString()));
        Tratativa<ConfiguracaoDMS> t = new TratativaQlenDMS();
        return t.parse(cmd.getBlob());
    }

    @Override
    public ConfiguracaoDMS criarLinha(ConfiguracaoDMS linha) throws Exception {
        if (!command().consulta(createLinha(linha)).getBlob().contains("JOURNAL")) {
            throw new FalhaAoExecutarComandoDeAlteracaoException();
        }
        return consultarPorDn(linha.getDn());
    }

    @Override
    public void deletarLinha(ConfiguracaoDMS linha) throws Exception {
        Boolean deletaLinha = !command().consulta(delete(linha)).getBlob().contains("JOURNAL");
        if (deletaLinha) {
            throw new FalhaAoExecutarComandoDeAlteracaoException();
        }
    }

    @Override
    public void alterarNcos(ConfiguracaoDMS linha) throws Exception {
        command().consulta(cmdAlterarNcos(linha));
    }

    @Override
    public void alterarCustGroup(ConfiguracaoDMS linha) throws Exception {
        command().consulta(cmdAlterarCustGroup(linha));
    }

    @Override
    public void adicionarServico(ConfiguracaoDMS linha, List<LineServiceDTO> services) throws Exception {

        services.removeIf((t) -> {
            return linha.getServicos().contains(t); //To change body of generated lambdas, choose Tools | Templates.
        });

        if (!services.isEmpty()) {
            Boolean addSrv = !command().consulta(addServices(linha, services)).getBlob().contains("JOURNAL");
            if (addSrv) {
                throw new FalhaAoExecutarComandoDeAlteracaoException();
            }
        }

    }

    @Override
    public void removerServico(ConfiguracaoDMS linha, List<LineServiceDTO> services) throws Exception {
        services.removeIf((t) -> {
            return !linha.getServicos().contains(t);
        });
        if (!services.isEmpty()) {
            Boolean rmvSrv = !command().consulta(rmvServices(linha, services)).getBlob().contains("JOURNAL");
            if (rmvSrv) {
                throw new FalhaAoExecutarComandoDeAlteracaoException();
            }
        }
    }

    @Override
    public void alteraSenha(String oldPass, String newPass) throws Exception {
        command().consulta(alterarSenha(oldPass, newPass));
    }

    @Override
    public void abort() throws Exception {
        command().consulta(aborte()).getBlob();
    }

    protected ComandoDMS addServices(ConfiguracaoDMS linha, List<LineServiceDTO> services) {
        StringBuilder srvBuilder = new StringBuilder();
        services.forEach((t) -> {
            srvBuilder.append(" ").append(t.getKey());
        });
        String leServices = srvBuilder.toString();
        return new ComandoDMS("ADO $ " + linha.getDn() + leServices + " $ Y");
    }

    protected ComandoDMS rmvServices(ConfiguracaoDMS linha, List<LineServiceDTO> services) {
        StringBuilder srvBuilder = new StringBuilder();
        services.forEach((t) -> {
            String leKey = t.getKey().contains(" ") ? t.getKey().split(" ")[0] : t.getKey();
            srvBuilder.append(" ").append(leKey);
        });
        String leServices = srvBuilder.toString();

        return new ComandoDMS("DEO $ " + linha.getDn() + leServices + " $ Y");
    }

    protected ComandoDMS alterarSenha(String oldPass, String newPass) {
        return new ComandoDMS("password", newPass, newPass, oldPass);
    }

    protected ComandoDMS cmdAlterarNcos(ConfiguracaoDMS conf) {
        return new ComandoDMS("CHG $ LINE " + conf.getDn() + " NCOS 115 Y");
    }

    protected ComandoDMS cmdAlterarCustGroup(ConfiguracaoDMS conf) {
        return new ComandoDMS("CHG $ LINE " + conf.getDn() + " CUSTGRP " + conf.getCustGrp() + " Y");
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

    protected ComandoDMS servord() {
        return new ComandoDMS("servord");
    }

    protected ComandoDMS aborte() {
        return new ComandoDMS("abort");
    }

    protected ComandoDMS delete(ConfiguracaoDMS linha) {
        return new ComandoDMS("post d " + linha.getDn() + ";frls;bsy inb;", 1000, "OUT $ " + linha.getDn() + " " + linha.getLen() + " BLDN Y");
    }

    protected ComandoDMS createLinha(ConfiguracaoDMS linha) {
        return new ComandoDMS("NEW $ " + linha.getDn() + " ibn " + linha.getCustGrp() + " 0 115 " + linha.getLen().getLen() + " DGT $ Y");
    }

    protected ComandoDMS ativarServico(String dn, LineService serv) {
        return new ComandoDMS("ADO $ " + dn + " " + serv.getKey() + " $ Y");
    }

    protected ComandoDMS desativarServico(String dn, LineService serv) {
        return new ComandoDMS("DEO $ " + dn + " " + serv.getKey() + " $ Y");
    }

    protected ComandoDMS manobrar(String facilidadeAtual, String facilidadeNova) throws Exception {
        if (facilidadeNova.isEmpty() || facilidadeAtual.isEmpty()) {
            throw new Exception("Facilidades não preenchidas.");
        }
        return new ComandoDMS("CLN $ " + facilidadeAtual + " " + facilidadeNova + " Y");
    }

    protected ComandoDMS mapciContext() {
        return new ComandoDMS("mapci nodisp;mtc;lns;ltp");
    }

    protected ComandoDMS listarLens(Len len, Integer index) {
        return new ComandoDMS("post l " + len.lenParcial() + " " + index + " print");
    }

    protected boolean isLogged(String param) {
        return param.contains(">SO:");
    }

    protected ComandoDMS enter() {
        return new ComandoDMS("");
    }

    @Override
    public void conectar() throws Exception {
        super.conectar();
        ComandoDMS cmd = command().consulta(servord());
        if (!isLogged(cmd.getBlob())) {
            throw new LoginSwitchException();
        }
        command().consulta(mapciContext());
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

    @Override
    public boolean equals(Object obj) {
        return equals((NortelImpl) obj);
    }

    public boolean equals(NortelImpl dev) {
        return this.getCentral().isSameIP(dev.getCentral());
    }

    @Override
    public List<FacilidadesMapci> listarLens(Len len) throws Exception {
        List<FacilidadesMapci> fads = new ArrayList<>();

        List<String> retorno = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            retorno.addAll(command().consulta(listarLens(len, i)).getRetorno());
        }

        retorno.forEach((string) -> {
            try {
                Tratativa<FacilidadesMapci> trat = new TratativaConsultaFacilidades();
                fads.add(trat.parse(string));
            } catch (Exception e) {
//                System.out.println(e.getMessage());
            }
        });

        if (fads.isEmpty()) {
            throw new FalhaAoConsultarLensException();
        }

        return fads;
    }

    @Override
    public List<FacilidadesMapci> listarLensLivres(Len len) throws Exception {
        Filter<FacilidadesMapci> fil = new FilterLensLivres();
        return fil.filter(this.listarLens(len));
    }

    @Override
    public FacilidadesMapci consultarEstadoDaPorta(Len len) throws Exception {
        try {
            Filter<FacilidadesMapci> fil = new FilterLen(len);
            return fil.filter(this.listarLens(len)).get(0);
        } catch (Exception e) {
            throw new FalhaAoConsultarEstadoException();
        }
    }

}
