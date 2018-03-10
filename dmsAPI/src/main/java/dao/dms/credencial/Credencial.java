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
public class Credencial {

    private String login;
    private String pass;

    public Credencial(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public Credencial() {
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

}
