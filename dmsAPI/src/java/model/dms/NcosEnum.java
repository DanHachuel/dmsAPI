/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import model.dms.dto.NcosDTO;

/**
 *
 * @author G0042204
 */
public enum NcosEnum {

    NCOS_1(1, "Liberado TOTAL"),
    NCOS_2(2, "Não realiza ligações DDD 025 e DDI 0025"),
    NCOS_3(3, "Não realiza ligações 0300, 0500 e 0900"),
    NCOS_4(4, "Não realiza ligações DDD 025, DDI 0025, 0300, 0500 e 0900"),
    NCOS_15(15, "Ligue Fácil (realiza ligações de longa distância sem CSP)"),
    NCOS_16(16, "Transforma CSP todas as regiões; CSP a cobrar códigos de áreas 4, 5 e 6 e CSP todos os paises em 025 e 9025"),
    NCOS_17(17, "Realiza ligações somente para 0800 e 000x (prefixo Webline local)"),
    NCOS_18(18, "Transforma CSP para códigos de áreas 4, 5 e 6 ; CSP a cobrar códigos de áreas 4, 5 e 6 em 025 e 9025"),
    NCOS_19(19, "Transforma CSP DDD todas as regiões e CSP todos os paises em CSP 23. Nos casos de chamadas a cobrar é considerado o CSP originalmente discado pelo cliente"),
    NCOS_20(20, "Liberado Chamadas locais ( início do número de 2 a 6 ) e 078 - TRANSMIT"),
    NCOS_21(21, "Bloqueio para celular (início do número 7, 8 e 91 a 99)"),
    NCOS_22(22, "Bloqueio do DDD 025, DDI 0025 e para celular (início do número 7, 8 e 91 a 99)"),
    NCOS_23(23, "Bloqueio para celular (início do número 7, 8 e 91 a 99), 0300, 0500 e 0900"),
    NCOS_24(24, "Bloqueio do DDD 025; DDI 0025 e para celular (início do número 7, 8 e 91 a 99), 0300, 0500 e 0900"),
    NCOS_25(25, "Liberado somente 11x, 190 e 193; 080005xxxxx; caso assinante tente ligar é transferido para 08006001325"),
    NCOS_29(29, "Sempre Local"),
    NCOS_30(30, "Igual NCOS 19 xxx_POS mais acesso internacional 100% liberado"),
    NCOS_31(31, "Igual NCOS 16 xxx_POS mais acesso internacional 100% liberado"),
    NCOS_32(32, "Igual NCOS 1 xxx_POS mais acesso internacional 100% liberado"),
    NCOS_33(33, "Igual NCOS 1 PBXRAMAL mais acesso internacional 100% liberado CLISERV 1018"),
    NCOS_34(34, "Igual NCOS 16 PBXRAMAL mais acesso internacional 100% liberado CLISERV 1016"),
    NCOS_35(35, "Projeto VCPLUS - acesso celular diferenciado para clientes xxx_POS igual NCOS 1"),
    NCOS_36(36, "Projeto VCPLUS - acesso celular diferenciado para clientes xxx_POS com TIC (igual NCOS 16)"),
    NCOS_37(37, "Projeto VCPLUS - acesso celular diferenciado para clientes xxx_POS com PIC (igual NCOS 15)"),
    NCOS_38(38, "Vox3G Light"),
    NCOS_39(39, "Vox3G Light VC1 LIGHT"),
    NCOS_40(40, "Vox3G Light TIC"),
    NCOS_41(41, "Bloqueio para celular (início do número 7, 8 e 91 a 99) - Corporativos PBXRAMAL com TIC - CLISERV 1041"),
    NCOS_42(42, "Vox3G Light VC1 LIGHT TIC"),
    NCOS_43(43, "Projeto VCPLUS - acesso celular diferenciado para clientes igual NCOS 1 acesso internacional 100% liberado"),
    NCOS_44(44, "Reservado Produto Retail VC1 Light"),
    NCOS_45(45, "Reservado Produto Retail VC1 Light PIC"),
    NCOS_46(46, "Reservado Produto Retail VC1 Light PIC Sempre local"),
    NCOS_48(48, "VC1 Light aplicado às rotas de PABX internos (CLISERV 1048 p/ PBXRAMAL)"),
    NCOS_49(49, "Projeto VCPLUS - TIC (igual NCOS 16) e acesso internacional 100% liberado"),
    NCOS_115(115, "Ligue Simples");

    private Integer ncos;

    private String desc;

    private NcosEnum(Integer ncos, String desc) {
        this.ncos = ncos;
        this.desc = desc;
    }

    public static NcosEnum findByInt(Integer i) {
        for (NcosEnum n : NcosEnum.values()) {
            if (n.getNcos().compareTo(i) == 0) {
                return n;
            }
        }
        return null;
    }

    public Integer getNcos() {
        return ncos;
    }

    public void setNcos(Integer ncos) {
        this.ncos = ncos;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public NcosDTO dto(){
        return new NcosDTO(ncos, desc, name());
    }

}
