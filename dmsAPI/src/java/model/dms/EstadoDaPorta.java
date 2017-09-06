/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

/**
 *
 * @author G0042204
 */
public class EstadoDaPorta {

    public static final EstadoDaPorta IDL = new EstadoDaPorta("IDL", "Ociosa", Boolean.TRUE);
    public static final EstadoDaPorta LMB = new EstadoDaPorta("LMB", "LMB", Boolean.FALSE);
    public static final EstadoDaPorta PLO = new EstadoDaPorta("PLO", "Curto", Boolean.FALSE);
    public static final EstadoDaPorta INB = new EstadoDaPorta("INB", "Livre", Boolean.TRUE);
    
    private String nome;

    private String desc;

    private Boolean valid;

    public EstadoDaPorta(String nome, String desc, Boolean valid) {
        this.nome = nome;
        this.desc = desc;
        this.valid = valid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

}
