package dao.dms.credencial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author G0042204
 */
public enum Credencial {

    UM("G0042204", "d20m08"), DOIS("G0041775", "465852"), TRES("G0056638", "johnnyM5"), QUATRO("G0034481", "binholoco01");

    private final String login;
    private final String pass;

    private Credencial(String login, String pass) {
        this.login = login; 
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

}
