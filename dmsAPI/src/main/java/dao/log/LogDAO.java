/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.log;

import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.mongo.dao.MongoEndpointEnum;
import model.entity.LogEntity;

/**
 *
 * @author G0042204
 */
public class LogDAO extends AbstractMongoDAO<LogEntity> {

    public LogDAO() {
        super(MongoEndpointEnum.MONGO.getIp(), "dmsAPI", LogEntity.class);
    }

}
