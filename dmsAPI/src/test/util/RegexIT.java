/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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
public class RegexIT {

    public RegexIT() {
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
     * Test of capture method, of class Regex.
     */
    @Test
    public void testCapture() {
        try {
            System.out.println("capture");
            String string = "-------------------------------------------------------------------------------DN:     0886762                                 TYPE: SINGLE PARTY LINESNPA: 413   SIG: DT    LNATTIDX: N/A             LINE EQUIPMENT NUMBER:     A3I4   02 1 00 59  LINE CLASS CODE:  IBN   IBN TYPE: STATIONCUSTGRP:        CTA_POS     SUBGRP: 0  NCOS: 115CARDCODE:  V5LOOP    GND: N  PADGRP: NPDGP  BNV: NL MNO: NPM NODE NUMBER     :    336PM TERMINAL NUMBER :    60OPTIONS:CWT 3WC DGT DDN NOAMA  -------------------------------------------------------------------------------";
            String pattern = "(?!LINE EQUIPMENT NUMBER:)(\\s){0,10}A3I4(\\s){0,10}02(\\s){0,5}1(\\s){0,5}00(\\s){0,5}59";
            Regex instance = new Regex();
            String expResult = "A3I4   02 1 00 59";
            String result = instance.capture(string, pattern);
            System.out.println("QDN: " + result);
            assertEquals(expResult, result.trim());
        } catch (Exception e) {
            fail(e.getMessage());

        }

    }

}
