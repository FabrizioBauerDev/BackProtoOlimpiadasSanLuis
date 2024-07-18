package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums;

public enum TipoPrueba {
    SaltoEnAlto("Salto en alto"),
    Lanzamientos("Lanzamientos"),
    SaltosHorizontales("Saltos horizontales"),
    PistaConAndarivel("Pista con andarivel"),
    PistaSinAndarivel("Pista sin andarivel");

    private final String displayName;

    TipoPrueba(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
