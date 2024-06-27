package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums;

public enum InstanciaSerie {
    Serie,
    Semifinal,
    Final;

    public String getInstanciaSerie(){
        return switch (this) {
            case Serie -> "Serie";
            case Semifinal -> "Semifinal";
            case Final -> "Final";
        };
    }
}
