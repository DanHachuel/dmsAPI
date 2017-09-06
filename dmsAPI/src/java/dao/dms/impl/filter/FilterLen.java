/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.filter;

import java.util.ArrayList;
import java.util.List;
import model.dms.ConsultaFacilidades;
import model.dms.Len;

public class FilterLen implements Filter<ConsultaFacilidades> {

    private Len len;

    public FilterLen(Len len) {
        this.len = len;
    }

    @Override
    public List<ConsultaFacilidades> filter(List<ConsultaFacilidades> lst) {
        List<ConsultaFacilidades> ret = new ArrayList<>();
        lst.stream().filter((c) -> (c.getLen().equals(this.len))).forEachOrdered((c) -> {
            ret.add(c);
        });
        return ret;
    }

}
