/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;

/**
 *
 * @author G0042204
 */
public final class GsonUtil {

    public static String serialize(Object ob) {
        try {
            return new Gson().toJson(ob, ob.getClass());
        } catch (Exception e) {
            return "Falha ao serializar";
        }
    }

}
