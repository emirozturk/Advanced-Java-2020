package com.emirozturk;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Siparisler {
    //Dışarıdan erişilemeyen alan
    List<Siparis> siparisListesi;
    //Yapıcı
    private Siparisler(List<Siparis> liste){
        siparisListesi = liste;
    }
    //Statik metot. Satir listesini alıp Siparisler sınıfından bir nesne döndürür
    public static Siparisler stringListesindenOlustur(List<String> satirlar) {
        var liste = new ArrayList<Siparis>();
        boolean baslikMi = true; //Verideki ilk satır başlık satırı olduğu için atlamak amacıyla kullanılır
        for (String satir : satirlar) { //Her satır için
            if (baslikMi) { //ilk satırsa
                baslikMi = false; //değeri bir sonraki kontrol için false yap
                continue; //alttaki satırları çalıştırmadan bir sonraki elemana geç
            }
            var parcalar = satir.split(","); //satırı , karakterine göre böl
            LocalDate tarih = LocalDate.parse(parcalar[0], DateTimeFormatter.ofPattern("dd.MM.yyyy")); //ilk parça tarih
            String urunAdi = parcalar[1]; //ikinci parça ürün adı
            int urunId = Integer.parseInt(parcalar[2]); //üçüncü parça ürün id
            int adet = Integer.parseInt(parcalar[3]); //dördüncü parça adet
            int musteriId = Integer.parseInt(parcalar[4]); //beşinci parça müşteri id
            String musteriAdi = parcalar[5]; //altıncı parça müşteri adı
            String musteriSoyadi = parcalar[6]; //yedinci parça müşteri soyadı
            Siparis yeniSiparis = new Siparis(tarih, urunId, urunAdi, musteriId, musteriAdi, musteriSoyadi, adet); //parçalar ile yapıcı çağırılması
            liste.add(yeniSiparis); //oluşturulan nesnenin listeye eklenmesi
        }
        Siparisler yeniSiparisler = new Siparisler(liste); //listeyi parametre alan siparisler yapıcısının çağırılarak bir örnek (instance) alınması
        return yeniSiparisler; //örneğin döndürülmesi
    }
    public List<Siparis> tariheGoreAra(LocalDate arananTarih){
        ArrayList<Siparis> sonucListesi = new ArrayList<>();
        for(var siparis:siparisListesi)
            if(siparis.getTarih().equals(arananTarih)) //siparis'in tarih alanının alınıp parametre verilen tarih ile karşılaştırılması
                sonucListesi.add(siparis); //Eğer eşitse sonuç listesine eklenir.
         return sonucListesi;
    }
    public List<Siparis> adaGoreAra(String arananAd){
        ArrayList<Siparis> sonucListesi = new ArrayList<>();
        for(var siparis:siparisListesi)
            if(siparis.getMusteriAdSoyadi().contains(arananAd)) //siparişin müşteri ad soyad alanını alınıp parametre verilen tarih ile karşılaştırılması
                sonucListesi.add(siparis); //Eğer içeriyorsa sonuç listesine eklenir.
            return sonucListesi;
    }
}
