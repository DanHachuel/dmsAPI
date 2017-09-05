/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.filter;

import java.util.ArrayList;
import java.util.List;
import model.dms.ConsultaFacilidades;

public class FilterLensLivres implements Filter<ConsultaFacilidades> {

    @Override
    public List<ConsultaFacilidades> filter(List<ConsultaFacilidades> lst) {
        List<ConsultaFacilidades> ret = new ArrayList<>();
        for (ConsultaFacilidades c : lst) {
            if (c.getState().equalsIgnoreCase("INB") && c.getDn().equalsIgnoreCase("NODIRN")) {
                ret.add(c);
            }
        }
        return ret;
    }

}
