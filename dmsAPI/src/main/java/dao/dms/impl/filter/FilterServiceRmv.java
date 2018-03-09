/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.filter;

import java.util.ArrayList;
import java.util.List;
import model.dms.LineService;

public class FilterServiceRmv implements Filter<LineService> {

    private List<LineService> atual;

    public FilterServiceRmv() {

    }

    public FilterServiceRmv(List<LineService> atual) {
        this.atual = atual;
    }

    @Override
    public List<LineService> filter(List<LineService> lst) {
        List<LineService> ret = new ArrayList<>();
        lst.forEach((t) -> {
            if(atual.contains(t)){
                ret.add(t);
            }
        });
        return ret;
    }

}
