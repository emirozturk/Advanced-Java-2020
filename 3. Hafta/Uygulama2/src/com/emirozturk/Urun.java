package com.emirozturk;

public class Urun{
    //Dışarıdan erişilemeyen alanlar
    private int urunId;
    private String urunAdi;

    //Yapici
    public Urun(int urunId,String urunAdi){
        this.urunId = urunId;
        this.urunAdi = urunAdi;
    }

    //ToString metodunu override eden metot. Nesne id'si yerine alanların yazılması için
    @Override
    public String toString() {
        return "Urun{" +
                "urunId=" + urunId +
                ", urunAdi='" + urunAdi + '\'' +
                '}';
    }
}
