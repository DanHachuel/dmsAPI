/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import controller.in.EditServIn;
import dao.dms.enums.SwitchesEnum;
import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.EstadoDaPortaEnum;
import model.dms.FacilidadesMapci;
import model.dms.Len;
import model.dms.LineService;
import model.dms.dto.DetailDTO;

/**
 *
 * @author G0042204
 */
public interface ManagerDMS {

    public ConfiguracaoDMS consultarPorDn(String instancia) throws Exception;

    public ConfiguracaoDMS consultarPorLen(Len len) throws Exception;

    public ConfiguracaoDMS criarLinha(ConfiguracaoDMS linha) throws Exception;

    public ConfiguracaoDMS manobrarLinha(ConfiguracaoDMS linha, Len lenDestino) throws Exception;

    public void resetarPorta(String instancia) throws Exception;

    public Boolean isSameSwitch(SwitchesEnum sw);

    public SwitchesEnum getCentral();

    public DetailDTO getDetail();

    public EstadoDaPortaEnum consultarEstadoDaPorta(ConfiguracaoDMS linha) throws Exception;

    public List<FacilidadesMapci> listarLens(Len len) throws Exception;

    public List<FacilidadesMapci> listarLensLivres(Len len) throws Exception;

    public void deletarLinha(ConfiguracaoDMS linha) throws Exception;

    public void abort() throws Exception;

    public void alterarNcos(ConfiguracaoDMS linha) throws Exception;

    public void alterarCustGroup(ConfiguracaoDMS linha) throws Exception;

    public void adicionarServico(ConfiguracaoDMS linha, EditServIn in) throws Exception;

    public void removerServico(ConfiguracaoDMS linha, List<LineService> services) throws Exception;

    public void disconnect();

    public void connect() throws Exception;

    public void alteraSenha(String oldPass, String newPass) throws Exception;

    public void keepAliveCommand();

}
