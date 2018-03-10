/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.log.LogDAO;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static LogDAO createLogDAO() {
        return new LogDAO();
    }

}
