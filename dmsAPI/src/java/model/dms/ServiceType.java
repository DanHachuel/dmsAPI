/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import model.dms.dto.LineServiceDTO;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import util.JsonEnumDeserializer;

/**
 * CWT 3WC DGT DDN NOAMA
 *
 * @author G0042204
 */
//@JsonSerialize(using = JsonEnumDeserializer.class)
public enum ServiceType {

   SERVICO,
   BLOQUEIO;

}
