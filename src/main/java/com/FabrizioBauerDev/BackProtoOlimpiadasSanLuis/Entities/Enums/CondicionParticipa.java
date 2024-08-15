package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums;

public enum CondicionParticipa {
    DNF, // No terminó la prueba
    DNS, // No inició la prueba
    DQ, // Descalificado
    OK, // Valor para finalizó correctamente (debe ser invisible al usuario)
    FP; // Fuera de prueba

    public String getCondicionParticipa(){
        return switch (this) {
            case DNF -> "DNF";
            case DNS -> "DNS";
            case DQ -> "DQ";
            case OK -> "OK";
            case FP -> "FP";
        };
    }
}
