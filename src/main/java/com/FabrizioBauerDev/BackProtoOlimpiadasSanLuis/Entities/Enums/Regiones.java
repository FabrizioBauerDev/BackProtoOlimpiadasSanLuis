package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums;

public enum Regiones {
    Pedernera("Pedernera"),
    Valle_del_Conlara("Valle del Conlara"),
    Llanura_Sur("Llanura Sur"),
    Llanura_Norte("Llanura Norte"),
    Capital("Capital"),
    Provincial("Provincial");

    private final String displayName;

    Regiones(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

