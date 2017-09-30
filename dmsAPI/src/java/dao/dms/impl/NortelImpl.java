/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import controller.in.EditServIn;
import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.filter.Filter;
import dao.dms.impl.filter.FilterLensLivres;
import dao.dms.impl.filter.FilterServiceAdd;
import dao.dms.impl.filter.FilterServiceComplex;
import dao.dms.impl.filter.FilterServiceRmv;
import dao.dms.impl.filter.FilterServiceSimple;
import dao.dms.impl.filter.FilterServiceSimpleRmv;
import dao.dms.impl.tratativa.Tratativa;
import dao.dms.impl.tratativa.TratativaConsultaFacilidades;
import dao.dms.impl.tratativa.TratativaQdnDMS;
import dao.dms.impl.tratativa.TratativaQlenDMS;
import exception.FalhaAoConsultarEstadoException;
import exception.FalhaAoConsultarLensException;
import exception.FalhaAoExecutarComandoDeAlteracaoException;
import exception.LoginSwitchException;
import exception.MapciLotadoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dms.ConfiguracaoDMS;
import model.dms.EstadoDaPortaEnum;
import model.dms.FacilidadesMapci;
import model.dms.Len;
import model.dms.LineService;
import model.dms.LineStatus;
import model.dms.ServiceLevel;

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
        if (conf.getStatus() == LineStatus.CREATED) {
            conf.setEstado(consultarEstadoDaPorta(conf));
        }
        return conf;
    }

    @Override
    public ConfiguracaoDMS consultarPorLen(Len len) throws Exception {
        ComandoDMS cmd = command().consulta(qlen(len.getLen()));
        Tratativa<ConfiguracaoDMS> t = new TratativaQlenDMS();
        return t.parse(cmd.getBlob());
    }

    @Override
    public ConfiguracaoDMS criarLinha(ConfiguracaoDMS linha) throws Exception {
        if (!command().consulta(createLinha(linha)).getBlob().contains("JOURNAL")) {
            abort();
            throw new FalhaAoExecutarComandoDeAlteracaoException();
        }
        return consultarPorDn(linha.getDn());
    }

    @Override
    public void deletarLinha(ConfiguracaoDMS linha) throws Exception {
        Boolean deletaLinha = !command().consulta(delete(linha)).getBlob().contains("JOURNAL");
        if (deletaLinha) {
            abort();
            throw new FalhaAoExecutarComandoDeAlteracaoException();
        }
    }

    @Override
    public ConfiguracaoDMS manobrarLinha(ConfiguracaoDMS linha, Len lenDestino) throws Exception {

        if (!command().consulta(manobrar(linha.getLen().getLen(), lenDestino.getLen())).getBlob().contains("JOURNAL")) {
            abort();
            throw new FalhaAoExecutarComandoDeAlteracaoException();
        }
        alterarCustGroup(linha);

        return consultarPorDn(linha.getDn());
    }

    @Override
    public void alterarNcos(ConfiguracaoDMS linha) throws Exception {
        if (!command().consulta(cmdAlterarNcos(linha)).getBlob().contains("JOURNAL")) {
            abort();
            throw new FalhaAoExecutarComandoDeAlteracaoException();
        }
    }

    @Override
    public void alterarCustGroup(ConfiguracaoDMS linha) throws Exception {
        if (!command().consulta(cmdAlterarCustGroup(linha)).getBlob().contains("JOURNAL")) {
            abort();
            throw new FalhaAoExecutarComandoDeAlteracaoException();
        }
    }

    @Override
    public void adicionarServico(ConfiguracaoDMS linha, EditServIn in) throws Exception {

        List<LineService> complex = new FilterServiceAdd(linha.getServicos()).filter(new FilterServiceComplex().filter(in.getServices()));
        List<LineService> simple = new FilterServiceAdd(linha.getServicos()).filter(new FilterServiceSimple().filter(in.getServices()));

        EditServIn editComplex = new EditServIn();
        editComplex.setInstancia(in.getInstancia());
        editComplex.setServices(complex);
        editComplex.setDms(in.getDms());

        for (ComandoDMS comandoDMS : this.addServicesComplex(linha, editComplex)) {
            Boolean addComp = !command().consulta(comandoDMS).getBlob().contains("JOURNAL");
            if (addComp) {
                abort();
                throw new FalhaAoExecutarComandoDeAlteracaoException();
            }
        }

        if (!simple.isEmpty()) {
            Boolean addSrv = !command().consulta(addServicesSimple(linha, simple)).getBlob().contains("JOURNAL");
            if (addSrv) {
                abort();
                throw new FalhaAoExecutarComandoDeAlteracaoException();
            }
        }

    }

    public void resetarPorta(String instancia) throws Exception {
        System.out.println(command().consulta(resetPorta(instancia)).getBlob());
    }

    @Override
    public void removerServico(ConfiguracaoDMS linha, List<LineService> services) throws Exception {
        List<LineService> complex = new FilterServiceRmv(linha.getServicos()).filter(new FilterServiceComplex().filter(services));
        List<LineService> simple = new FilterServiceRmv(linha.getServicos()).filter(new FilterServiceSimpleRmv().filter(services));
        for (ComandoDMS comandoDMS : this.rmvServicesComplex(linha, complex)) {
            Boolean rmvComp = !command().consulta(comandoDMS).getBlob().contains("JOURNAL");
            if (rmvComp) {
                abort();
                throw new FalhaAoExecutarComandoDeAlteracaoException();
            }
        }
        linha.getServicos().removeAll(complex);

        if (!simple.isEmpty()) {
            Boolean rmvSrv = !command().consulta(rmvServicesSimple(linha, simple)).getBlob().contains("JOURNAL");
            if (rmvSrv) {
                abort();
                throw new FalhaAoExecutarComandoDeAlteracaoException();
            }
        }
        linha.getServicos().removeAll(simple);

    }

    @Override
    public void alteraSenha(String oldPass, String newPass) throws Exception {
        command().consulta(alterarSenha(oldPass, newPass));
    }

    @Override
    public void abort() throws Exception {
        command().consulta(aborte()).getBlob();
    }

    protected ComandoDMS addServicesSimple(ConfiguracaoDMS linha, List<LineService> services) {
        StringBuilder srvBuilder = new StringBuilder();
        services.forEach((t) -> {
            srvBuilder.append(" ").append(t.getKey());
        });
        String leServices = srvBuilder.toString();
        return new ComandoDMS("ADO $ " + linha.getDn() + leServices + " $ Y");
    }

    protected List<ComandoDMS> addServicesComplex(ConfiguracaoDMS linha, EditServIn in) {

        StringBuilder sacbBuilder = new StringBuilder();
        List<ComandoDMS> l = new ArrayList<>();
        in.getServices().forEach((t) -> {
            System.out.println("");
            if (t.getKey().equalsIgnoreCase("SUPPRESS PUBLIC")) {
                l.add(new ComandoDMS("ADO $ " + linha.getDn() + " SUPPRESS PUBLIC Y Y $ $ Y"));
            } else if (t.getKey().equalsIgnoreCase("CFD")) {
                l.add(new ComandoDMS("ADO $ " + linha.getDn() + " CFD N 11199 CFB N 11199 CBU CDU MWT STD Y Y ALL N $ Y"));
            } else if (t.getKey().equalsIgnoreCase("SUS")) {
                l.add(new ComandoDMS("SUS $ " + linha.getDn() + " " + linha.getLen().getLen() + " Y"));
            } else {
                if (sacbBuilder.length() == 0) {
                    sacbBuilder.append("ADO $ " + linha.getDn() + " SACB ACT ");
                }
                sacbBuilder.append(t.getKey()).append(" ");
            }
            System.out.println("");
        });
        if (sacbBuilder.length() != 0) {
            l.add(new ComandoDMS(sacbBuilder.toString(), in.getInstancia().substring(6, 10), "", "$ Y"));
        }

        return l;
    }

    protected ComandoDMS rmvServicesSimple(ConfiguracaoDMS linha, List<LineService> services) {
        StringBuilder srvBuilder = new StringBuilder();

        services.removeIf((t) -> {
            return t.getNivel() == ServiceLevel.COMPLEX;
        });
        services.forEach((t) -> {
            String leKey = t.getKey().contains(" ") ? t.getKey().split(" ")[0] : t.getKey();
            srvBuilder.append(" ").append(leKey);
        });
        String leServices = srvBuilder.toString();

        return new ComandoDMS("DEO $ " + linha.getDn() + leServices + " $ Y");
    }

    protected List<ComandoDMS> rmvServicesComplex(ConfiguracaoDMS linha, List<LineService> services) {

        List<ComandoDMS> l = new ArrayList<>();
        services.forEach((t) -> {
            if (t.getKey().equalsIgnoreCase("SUPPRESS PUBLIC")) {
                l.add(new ComandoDMS("DEO $ " + linha.getDn() + " SUPPRESS $ Y"));
            } else if (t.getKey().equalsIgnoreCase("CFD")) {
                l.add(new ComandoDMS("DEO $ " + linha.getDn() + " CFD CFB CBU CDU MWT $ Y"));
            } else if (t.getKey().equalsIgnoreCase("SUS")) {
                l.add(new ComandoDMS("RES $ " + linha.getDn() + " " + linha.getLen().getLen() + " Y"));
            } else {
                l.add(new ComandoDMS("DEO $ " + linha.getDn() + " SACB $ Y"));
            }
        });

        return l;
    }

    protected ComandoDMS alterarSenha(String oldPass, String newPass) {
        return new ComandoDMS("password", newPass, newPass, oldPass);
    }

    protected ComandoDMS cmdAlterarNcos(ConfiguracaoDMS conf) {
        return new ComandoDMS("CHG $ LINE " + conf.getDn() + " NCOS " + conf.getNcos().getNcos() + " Y");
    }

    protected ComandoDMS cmdAlterarCustGroup(ConfiguracaoDMS conf) {
        return new ComandoDMS("CHG $ LINE " + conf.getDn() + " CUST " + conf.getCustGrp() + " Y");
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

    protected ComandoDMS resetPorta(String dn) {
        return new ComandoDMS("post d " + dn + ";frls;rts;", 4000);
    }

    protected ComandoDMS estadoPorta(ConfiguracaoDMS linha) {
        return new ComandoDMS("post d " + linha.getDn() + " display");
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
        System.out.println("isLogged:" + param);
        return param.contains("SO");
    }

    protected boolean isMapci(String param) {
        return !param.contains("No storage for directory");
    }

    protected ComandoDMS enter() {
        return new ComandoDMS("");
    }

    @Override
    public void conectar() throws Exception {
        super.conectar();
        Thread.sleep(8000);
        if (!isLogged(command().consulta(servord()).getBlob())) {
            throw new LoginSwitchException();
        }
        if (!isMapci(command().consulta(mapciContext()).getBlob())) {
            throw new MapciLotadoException();
        }
    }

    @Override
    public void desconectar() {
        try {
            command().consulta(logout());
            super.desconectar(); //To change body of generated methods, choose Tools | Templates.

        } catch (Exception ex) {
            Logger.getLogger(NortelImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
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
    public EstadoDaPortaEnum consultarEstadoDaPorta(ConfiguracaoDMS linha) throws Exception {
        try {
            for (String string : command().consulta(estadoPorta(linha)).getRetorno()) {
                try {
                    Tratativa<FacilidadesMapci> trat = new TratativaConsultaFacilidades();
                    return trat.parse(string).getState();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            throw new FalhaAoConsultarEstadoException();
        }

        return null;
    }

    @Override
    public void keepAliveCommand() {
        try {
            command().consulta(enter());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
