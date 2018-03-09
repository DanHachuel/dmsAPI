/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author G0042204
 */
public class MapciLotadoException extends Exception {

    public MapciLotadoException() {
        super("Falha ao efetuar login na Central (sem acesso ao contexto mapci).");
    }

}
