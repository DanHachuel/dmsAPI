/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.log;

import dao.AbstractHibernateDAO;
import dao.InterfaceDAO;
import model.entity.LogEntity;

/**
 *
 * @author G0042204
 */
public class LogDAO extends AbstractHibernateDAO implements InterfaceDAO<LogEntity>{

    @Override
    public void cadastrar(LogEntity t) throws Exception {
        super.persist(t);
        this.close();
    }

    @Override
    public LogEntity buscarPorId(LogEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        super.close();
    }
    
}
