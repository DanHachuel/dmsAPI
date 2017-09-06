/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.enums.SwitchesEnum;
import java.util.List;
import model.dms.ConfiguracaoDMS;
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

    public Boolean isSameSwitch(SwitchesEnum sw);

    public SwitchesEnum getCentral();

    public DetailDTO getDetail();

    public FacilidadesMapci consultarEstadoDaPorta(Len len) throws Exception;

    public List<FacilidadesMapci> listarLens(Len len) throws Exception;

    public List<FacilidadesMapci> listarLensLivres(Len len) throws Exception;

    public void deletarLinha(ConfiguracaoDMS linha) throws Exception;

    public void adicionarServico(ConfiguracaoDMS linha, List<LineService> services) throws Exception;

    public void removerServico(ConfiguracaoDMS linha, List<LineService> services) throws Exception;

    public void disconnect();

    public void connect();

    public void alteraSenha(String oldPass, String newPass) throws Exception;

}
