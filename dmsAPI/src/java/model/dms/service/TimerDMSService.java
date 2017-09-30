/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import java.util.Date;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author G0042204
 */
@Singleton
public class TimerDMSService {

    @Resource
    TimerService timerService;

    private Date lastProgrammaticTimeout;
    private Date lastAutomaticTimeout;

    private Logger logger = Logger.getLogger(
            "TimerSessionBean");

    public void setTimer(long intervalDuration) {
        System.out.println("Setting a programmatic timeout for " + intervalDuration + " milliseconds from now.");
        Timer timer = timerService.createTimer(intervalDuration, "Created new programmatic timer");
    }

    @Timeout
    public void programmaticTimeout(Timer timer) {
        this.setLastProgrammaticTimeout(new Date());
        logger.info("Programmatic timeout occurred.");
    }

//    @Schedule(hour = "6")
//    public void automaticTimeout() {
//        this.setLastAutomaticTimeout(new Date());
//        logger.info("TimerSessionBean -> conectar centrais");
//        ServiceContextDMS dms = FactoryService.createContext();
//        dms.disconnectSwitches();
//        dms.connectSwitches();
//    }
    @Schedule(minute = "*/30")
    public void automaticTimeout2() {
        this.setLastAutomaticTimeout(new Date());
        ServiceContextDMS dms = FactoryService.createContext();
        dms.connectSwitches();
    }

    public String getLastProgrammaticTimeout() {
        if (lastProgrammaticTimeout != null) {
            return lastProgrammaticTimeout.toString();
        } else {
            return "never";
        }

    }

    public void setLastProgrammaticTimeout(Date lastTimeout) {
        this.lastProgrammaticTimeout = lastTimeout;
    }

    public String getLastAutomaticTimeout() {
        if (lastAutomaticTimeout != null) {
            return lastAutomaticTimeout.toString();
        } else {
            return "never";
        }
    }

    public void setLastAutomaticTimeout(Date lastAutomaticTimeout) {
        this.lastAutomaticTimeout = lastAutomaticTimeout;
    }
}
