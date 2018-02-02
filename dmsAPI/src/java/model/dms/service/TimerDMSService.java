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

    @Schedule(hour = "6")
    public void automaticTimeout() {
        this.setLastAutomaticTimeout(new Date());
        logger.info("TimerSessionBean -> Reconectar Centrais");
        ServiceContextDMS dms = FactoryService.createContext();
        dms.disconnectSwitches();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        dms.connectSwitches();
    }

    @Schedule(minute = "*/15")
    public void automaticTimeout2() {
        logger.info("TimerSessionBean -> conectar centrais [15 minutos]");
        this.setLastAutomaticTimeout(new Date());
        ServiceContextDMS dms = FactoryService.createContext();
        dms.connectSwitches();
    }

    @Schedule(dayOfWeek = "*", hour = "*", minute = "*", second = "0")
    public void automaticTimeout3() {
        logger.info("TimerSessionBean -> Keep Alive QDN [1 minuto]");
        this.setLastAutomaticTimeout(new Date());
        ServiceContextDMS dms = FactoryService.createContext();
        dms.keepAlive();
        System.out.println("saidotimeout");
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
