/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.enums;

import exception.SwitchNaoEncontradaException;

/**
 *
 * @author G0042204
 */
public enum SwitchesEnum {

    ACRBO_CES01("10.161.40.97"),
    ALMCO_AJS01("10.180.77.117"),
    BAALH_GVS01("10.171.0.98"),
    BAFSA_GVS01("10.171.0.98"),
    BASDR_VGS01("10.171.0.98"),
    BASDR_VGS02("10.171.0.98"),
    CEFLA_JBS01("10.185.0.98"),
    DFBSA_CBS01("10.161.0.98"),
    DFBSA_SIS01("10.164.0.101"),
    ESVTA_ASS01("10.227.0.98"),
    ESLNS_ASS01("10.227.0.98"),
    GOGNA_DOS01("10.161.88.100"),
    GOGNA_DOS03("10.160.129.117"),
    GOANS_EPS02("10.160.129.117"),
    GORVD_PVS01("10.160.129.117"),
    MGBHE_HMS01("10.131.32.97"),
    MGBHE_HMS02("10.131.32.97"),
    MGBHE_PBS01("10.131.32.97"),
    MGGVS_TMS01("10.131.32.97"),
    MGIIG_ALS01("10.131.32.97"),
    MGJFA_DVS01("10.131.32.97"),
    //    MSCPE_CMS01("10.161.64.98"),
    RSNHO_MAS03("10.151.48.100"),
    MSCPE_CMS02("10.161.0.98"),
    MSDOS_RBS01("10.161.0.98"),
    MTCBA_MCS01("10.161.48.98"),
    MTCBA_MCS02("10.161.0.98"),
    MTROI_MRS01("10.160.129.117"),
    PBCGE_CCS01("10.181.0.98"),
    PBJPA_EPS01("10.181.0.98"),
    PERCE_LNS01("10.181.0.98"),
    PRCSC_BRS01("10.141.56.97"),
    PRCSC_BRS02("10.141.56.197"),
    PRCSC_BRS03("10.141.245.97"),
    PRCTA_LPS01("10.141.0.99"),
    PRCTA_PVS01("10.141.245.97"),
    PRCTA_PVS02("10.141.245.97"),
    PRFOZ_RBS02("10.141.245.97"),
    PRFOZ_RBS01("10.141.64.98"),
    PRGRP_FVS01("10.141.176.97"),
    PRLDA_MBS01("10.141.40.97"),
    PRLDA_MBS02("10.141.0.99"),
    PRMGA_JVS01("10.141.32.98"),
    PRPGO_VMS01("10.141.48.97"),
    PRPGO_VMS02("10.141.48.197"),
    PRPNG_RAS01("10.141.184.97"),
    RJRJO_PVS04("10.220.64.16"),
    RJRJO_SAS01("10.220.69.117"),
    RNNTL_BVS01("10.180.77.117"),
    ROPVO_APS01("10.161.32.97"),
    RSCAN_AUS01("10.151.64.98"),
    RSCAN_AUS03("10.151.64.100"),
    //    RSCSL_MHS01("10.151.56.97"),
    RSCSL_MHS02("10.151.0.99"),
    RSGTI_ABS01("10.151.80.97"),
    RSNHO_MAS01("10.151.48.97"),
    RSNHO_MAS02("10.151.0.99"),
    RSPAE_CGS01("10.151.0.99"),
    RSPAE_CGS02("10.151.0.99"),
    RSPAS_JCS01("10.151.144.98"),
    //    RSPLT_QNS01("10.151.32.98"),
    RSPLT_QNS02("10.151.0.99"),
    //    RSSMA_NAS01("10.151.40.97"),
    //    RSSMA_NAS02("10.151.40.100"),
    SCBNU_XVS01("10.141.80.98"),
    SCBNU_XVS03("10.150.129.117"),
    SCCUA_JCS01("10.141.160.97"),
    SCCUA_JCS02("10.150.129.117"),
    //    SCFNS_POS01("10.141.72.98"),
    SCFNS_POS02("10.151.0.99"),
    //    SCJVE_ADS01("10.141.88.98"),
    //    SCJVE_ADS03("10.141.88.114"),
    SPPAA_SJS01("10.210.68.16"),
    SCJVE_ADS04("10.150.129.117"),
    SCSOO_LLS01("10.241.32.98"),
    SEAJU_AMS01("10.180.77.117"),
    SPCAS_DAS01("10.210.68.16"),
    SPGRS_TPS01("10.210.76.16"),
    SPGRS_TPS02("10.210.76.16"),
    SPJAI_FAS01("10.211.32.97"),
    SPSBO_JBS01("10.210.72.16"),
    SPSNE_DCS01("10.210.76.16"),
    SPSOC_DSS01("10.211.32.97"),
    SPSPO_JUS01("10.210.80.16"),
    SPSTS_CRS01("10.211.32.97"),
    SPOCO_FBS01("10.210.76.16");

    private final String ip;

    private SwitchesEnum(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public Boolean isSameIP(SwitchesEnum s) {
        return this.getIp().equalsIgnoreCase(s.getIp());
    }

    public static SwitchesEnum findByName(String name) throws SwitchNaoEncontradaException {
        try {
            return SwitchesEnum.valueOf(name);
        } catch (Exception e) {
            throw new SwitchNaoEncontradaException();
        }
    }

}
