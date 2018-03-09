/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author G0042204
 */
public class Regex {

    public static String capture(String string, String pattern) throws Exception {
        return capture(string, pattern, 1);
    }

    public static String capture(String string, String pattern, Integer group) throws Exception {
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(string);
        if (m.find()) {
            return m.group(group);

        }
        throw new Exception("Regex - Group não encontrado.");
    }
}
