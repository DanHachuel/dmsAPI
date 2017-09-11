/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import controller.in.CriarLinhaIn;
import controller.in.DeletarLinhaIn;
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

    public ConfiguracoesShelf consultarConfiguracoesShelf(ConsultaDMS in) throws Exception;

}
