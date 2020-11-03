package com.emirozturk;

public class Musteri {
    //Dışarıdan erişilemeyen alanlar
    private int musteriId;
    private String musteriAdi;
    private String musteriSoyadi;

    //Yapıcı
    public Musteri(int musteriId, String musteriAdi, String musteriSoyadi) {
        this.musteriId = musteriId;
        this.musteriAdi = musteriAdi;
        this.musteriSoyadi = musteriSoyadi;
    }

    //Müşteri adını döndüren getter
    public String getMusteriAdi() {
        return musteriAdi;
    }

    //Müşteri soyadını döndüren getter
    public String getMusteriSoyadi() {
        return musteriSoyadi;
    }

    //ToString metodunu override eden metot. Nesne id'si yerine alanların yazılması için
    @Override
    public String toString() {
        return musteriId + " " + musteriAdi + " " + musteriSoyadi;
    }
}
