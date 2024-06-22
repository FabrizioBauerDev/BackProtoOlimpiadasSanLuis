package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums;

public enum Categorias {
    U14,
    U16,
    U20;

    public String getCategoria(){
        if (this == Categorias.U14) {
            return "U14";
        } else if (this == Categorias.U16) {
            return "U16";
        } else if (this == Categorias.U20) {
            return "U20";
        }
        return null;
    }
}
