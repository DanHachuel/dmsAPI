/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

import model.dms.Len;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class TratativaLenDMSIT {

    public TratativaLenDMSIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class TratativaLenDMS.
     */
    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
        String len = "FLAB 15 0 01 00";
        TratativaLenDMS instance = new TratativaLenDMS();
        Len result = instance.parse(len);
        assertTrue(result.toString().equalsIgnoreCase(len));
        System.out.println(result);
    }

    @Test
    public void testParse1() throws Exception {
        System.out.println("parse");
        String len = "A1E0 02 1 04 83";
        TratativaLenDMS instance = new TratativaLenDMS();
        Len result = instance.parse(len);
        assertTrue(result.toString().equalsIgnoreCase(len));
        System.out.println(result);
    }

}
