package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums;

public enum Regiones {
    Pedernera,
    Valle_del_Conlara,
    Llanura_Sur,
    Llanura_Norte,
    Capital,
    Provincial;

    public String getRegiones(){
        return switch (this) {
            case Pedernera -> "Pedernera";
            case Valle_del_Conlara -> "Valle del Conlara";
            case Llanura_Sur -> "Llanura Sur";
            case Llanura_Norte -> "LlanuraNorte";
            case Capital -> "Capital";
            case Provincial -> "Provincial";
        };
    }

}
