/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.filter;

import java.util.ArrayList;
import java.util.List;
import model.dms.LineService;
import model.dms.ServiceLevel;

public class FilterServiceSimpleRmv implements Filter<LineService> {

    public FilterServiceSimpleRmv() {
    }

    @Override
    public List<LineService> filter(List<LineService> lst) {
        List<LineService> ret = new ArrayList<>();
        lst.forEach((t) -> {
            if (t.getNivel() != ServiceLevel.COMPLEX && !t.getKey().equalsIgnoreCase("DGT")) {
                ret.add(t);
            }
        });
        return ret;
    }

}
