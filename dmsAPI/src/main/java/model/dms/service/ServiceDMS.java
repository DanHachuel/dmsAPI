/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import controller.in.CriarLinhaIn;
import controller.in.DeletarLinhaIn;
import controller.in.EditCustGrpIn;
import controller.in.EditNcosIn;
import controller.in.EditServIn;
import controller.in.ManobrarLinhaIn;
import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaDMS;
import model.dms.ConfiguracoesShelf;

/**
 *
 * @author G0042204
 */
public interface ServiceDMS {

    public ConfiguracaoDMS consultar(ConsultaDMS in) throws Exception;

    public ConfiguracaoDMS criarLinha(CriarLinhaIn in) throws Exception;

    public ConfiguracaoDMS deletarLinha(DeletarLinhaIn in) throws Exception;

    public ConfiguracaoDMS editarServicos(EditServIn in) throws Exception;

    public ConfiguracaoDMS editarCustGrp(EditCustGrpIn in) throws Exception;

    public ConfiguracaoDMS editarNcos(EditNcosIn in) throws Exception;

    public ConfiguracaoDMS manobrarLinha(ManobrarLinhaIn in) throws Exception;

    public ConfiguracoesShelf consultarConfiguracoesShelf(ConsultaDMS in) throws Exception;

    public ConfiguracaoDMS resetarPorta(ConsultaDMS in) throws Exception;

}
