/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.filter;

import java.util.ArrayList;
import java.util.List;
import model.dms.EstadoDaPortaEnum;
import model.dms.FacilidadesMapci;

public class FilterLensLivres implements Filter<FacilidadesMapci> {

    @Override
    public List<FacilidadesMapci> filter(List<FacilidadesMapci> lst) {
        List<FacilidadesMapci> ret = new ArrayList<>();
        for (FacilidadesMapci c : lst) {
            if (c.getState() == EstadoDaPortaEnum.INB && c.getDn().equalsIgnoreCase("NODIRN")) {
                ret.add(c);
            }
        }
        return ret;
    }

}
