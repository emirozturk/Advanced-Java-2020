package com.emirozturk;

import java.time.LocalDate;

public class Siparis {
    //Dışarıdan erişilemeyen alanlar
    private LocalDate tarih;
    private int adet;
    private Musteri musteri;
    private Urun urun;

    //Yapıcı
    public Siparis(LocalDate tarih,int urunId,String urunAdi,int musteriId,String musteriAdi,String musteriSoyadi,int adet){
        musteri = new Musteri(musteriId,musteriAdi,musteriSoyadi);
        urun = new Urun(urunId,urunAdi);
        this.tarih = tarih;
        this.adet = adet;
    }
    //getter
    public LocalDate getTarih(){
        return tarih;
    }
    //getter- musteri sınıfının getter'larını çağırarak birleştirip döndürür.
    public String getMusteriAdSoyadi(){
        return musteri.getMusteriAdi()+"\t"+ musteri.getMusteriSoyadi();
    }

    //ToString metodunu override eden metot. Nesne id'si yerine alanların yazılması için
    @Override
    public String toString(){
        return tarih.toString() + "\t" + musteri.toString() + " " + urun.toString() + "\t" + adet;
    }
}
