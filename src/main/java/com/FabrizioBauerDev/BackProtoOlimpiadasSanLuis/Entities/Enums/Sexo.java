package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums;

public enum Sexo {
    Masculino,
    Femenino;

    public String getSexo(){
        return switch (this) {
            case Masculino -> "Masculino";
            case Femenino -> "Femenino";
        };
    }
}
