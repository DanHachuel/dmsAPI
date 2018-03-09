/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.filter;

import dao.dms.impl.ManagerDMS;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilterConnectedSwitches implements Filter<ManagerDMS> {

    private final Boolean connected;

    public FilterConnectedSwitches(Boolean connected) {
        this.connected = connected;
    }

    @Override
    public List<ManagerDMS> filter(List<ManagerDMS> lst) {
        List<ManagerDMS> ret = new ArrayList<>();

        lst.forEach((t) -> {
            if (Objects.equals(t.getDetail().getConnected(), connected)) {
                ret.add(t);
            }
        });

        return ret;
    }

}
