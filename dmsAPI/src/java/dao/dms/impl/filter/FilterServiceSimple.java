/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.filter;

import java.util.ArrayList;
import java.util.List;
import model.dms.ServiceLevel;
import model.dms.dto.LineServiceDTO;

public class FilterServiceSimple implements Filter<LineServiceDTO> {

    public FilterServiceSimple() {
    }

    @Override
    public List<LineServiceDTO> filter(List<LineServiceDTO> lst) {
        List<LineServiceDTO> ret = new ArrayList<>();
        lst.forEach((t) -> {
            if (t.getNivel() == ServiceLevel.SIMPLE) {
                ret.add(t);
            }
        });
        return ret;
    }

}
