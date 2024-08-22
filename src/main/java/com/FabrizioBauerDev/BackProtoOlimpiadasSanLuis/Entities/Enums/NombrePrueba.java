package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums;

public enum NombrePrueba {
    // Pista con andarivel
    _80_mts("80 mts"),
    _100_mts("100 mts"),
    _150_mts("150 mts"),
    _200_mts("200 mts"),
    _400_mts("400 mts"),
    _600_mts("600 mts"),
    _800_mts("800 mts"),
    _1200_mts("1200 mts"),
    _1500_mts("1500 mts"),
    _2400_mts("2400 mts"),
    // Pista con vallas
    _80_mts_cv("80 mts c/v"),
    _100_mts_cv("100 mts c/v"),
    _110_mts_cv("110 mts c/v"),
    _200_mts_cv("200 mts c/v"),
    _400_mts_cv("400 mts c/v"),
    // Saltos horizontales
    Largo("Largo"),
    Triple("Triple"),
    // Salto en alto
    Alto("Alto"),
    // Lanzamientos
    Bala_2Kg("Bala 2Kg"),
    Bala_3Kg("Bala 3Kg"),
    Bala_4Kg("Bala 4Kg"),
    Disco_750g("Disco 750g"),
    Disco_1kg("Disco 1kg"),
    Jabalina_400g("Jabalina 400g"),
    Jabalina_600g("Jabalina 600g"),
    Martillo_3kg("Martillo 3kg"),
    Martillo_4kg("Martillo 4kg"),
    // Cross Country
    _600_mts_CrossCountry("600 mts Cross Country"),
    _800_mts_CrossCountry("800 mts Cross Country"),
    _1000_mts_CrossCountry("1000 mts Cross Country"),
    _1200_mts_CrossCountry("1200 mts Cross Country");

    private final String displayName;

    NombrePrueba(String displayName) {
        this.displayName = displayName;
    }

    public static NombrePrueba getPrueba(String prueba) {
        switch(prueba){
            case "80mts": return NombrePrueba._80_mts;
            case "100mts": return NombrePrueba._100_mts;
            case "600crosscountry": return NombrePrueba._600_mts_CrossCountry;
            case "800crosscountry": return NombrePrueba._800_mts_CrossCountry;
            case "1000crosscountry": return NombrePrueba._1000_mts_CrossCountry;
            case "1200crosscountry": return NombrePrueba._1200_mts_CrossCountry;
            case "bala2kg": return NombrePrueba.Bala_2Kg;
            case "bala3kg": return NombrePrueba.Bala_3Kg;
            case "bala4kg": return NombrePrueba.Bala_4Kg;
            case "largo":return NombrePrueba.Largo;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return displayName;
    }
}
