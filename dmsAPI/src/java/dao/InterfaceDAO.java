/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author G0042204
 * @param <T>
 */
public interface InterfaceDAO<T> {

    public void cadastrar(T t) throws Exception;

    public T buscarPorId(T t) throws Exception;

    public void close();

}
