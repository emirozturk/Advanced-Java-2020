package com.emirozturk;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

//Prosedürel Uygulama - Syntax Örnekleri
class Main{
    static String[] kayitlar; //Dosyadan okunan kayıtların saklandığı string dizisi
    public static void main(String[] args) { //Uygulamanın başladığı main metodu
        //Dosya yolu string'i, Deneme için kendi dosya yolunuzu vermeniz gerekmektedir.
        String dosyaYolu = "/Users/emirozturk/Desktop/boun.txt";
        //String'i path nesnesine dönüştürmek için. Path nesnesine Files sınıfının readAllLines metodu ihtiyaç duymaktadır.
        Path p = Paths.get(dosyaYolu);
        try {
            //Metot List<string> döndürüyor. String[]'e dönüştürmek için toArray kullanılıyor.
            kayitlar = Files.readAllLines(p).toArray(new String[]{});
            menu();
        }
        catch(Exception ex){
            //Okuma sırasında karşılaşılacak herhangi bir hatanın mesajı uygulama kapanmadan önce ekrana gösterilir.
            System.out.println(ex.getMessage());
        }
    }

    private static void menu() {
        while(true){ //4. seçenek seçilmediği sürece sonsuz döngü
            System.out.println("Arama Türü:");
            System.out.println("1.Tarih Ara:");
            System.out.println("2.İl Ara:");
            System.out.println("3.Şiddet Ara:");
            System.out.println("4.Çıkış:");
            System.out.println("Seçiminizi Giriniz:");
            //Scanner s = new Scanner(System.in); ve s.nextInt();'de kullanılabilir.
            //Standart input stream için System.in kullanılır.
            int secim = new Scanner(System.in).nextInt(); //Ekrandan alınan seçim.
            switch (secim) { //secim değişkenine göre switch ifadesi
                case 1 -> tarihAra();
                case 2 -> ilAra();
                case 3 -> siddetAra();
                case 4 -> System.exit(0);
            }
        }
    }

    private static void siddetAra() {
        System.out.print("Şiddet giriniz:");
        var alinanSiddet = new Scanner(System.in).nextDouble(); //Ekrandan double bir değer okur.
        for(var kayit:kayitlar){ //kayitlar dizisindeki her kayit için
            var parcalar = kayit.split(" "); //kayit değişkeni boşluğa göre bölünür.
            var siddet = Double.parseDouble(parcalar[6]); //6. parça double'a dönüştürülür.
            if(alinanSiddet<=siddet) //Eğer ekrandan alınan değer kayıttakinden küçükse
                System.out.println(kayit);  //Ekrana yazdır.
        }
    }

    private static void ilAra() {
        System.out.print("İl giriniz:");
        var alinanIl = new Scanner(System.in).nextLine(); //Ekrandan bir satırlık string alır.
        // Locale kısmı CAMLICA gibi bir değerin camlica yerine camlıca olarak dönüştürülmesi için gereklidir.
        alinanIl = alinanIl.toLowerCase(Locale.forLanguageTag("tr")); //string küçük harfe dönüştürülür.
        for(var kayit:kayitlar){ //kayitlar dizisindeki her kayit için
            //Kaydın boşluğa göre bölünmesi ile elde edilen dizide 8. parçanın yukarıdaki gibi küçültülmesi işlemi
            var il = kayit.split(" ")[8].toLowerCase(Locale.forLanguageTag("tr"));
            //Eşitlik yerine contains kullanılır. Contains ile girilen string satır içerisinde bulunuyorsa (bire bir eşitliğe bakılmadan)
            //true döndürecektir.
            if(il.contains(alinanIl))
                System.out.println(kayit);
        }
    }

    private static void tarihAra() {
        System.out.print("Tarih giriniz:");
        //Ekrandan bir tarih stringi alınması işlemi. Tarihin gün.ay.yıl şeklinde girildiği varsayılmaktadır.
        var alinanTarihStringi = new Scanner(System.in).nextLine();
        //Ekrandan girilen tarihin LocalDate sınıfından bir nesneye dönüştürülmesi. İlk parametre olarak girilen string ve
        //ikinci parametre olarak DateTimeFormatter verilmektedir. dd.MM.yyyy kısmında mm harflerinin büyük olması gerekmektedir.
        //Format gün.ay.yıl şeklinde ve 2.2.4 uzunluğunda girileceğini ifade etmektedir.
        var alinanTarih = LocalDate.parse(alinanTarihStringi, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        for(var kayit:kayitlar){ //kayitlar dizisindeki her kayit için
            //Dosyadaki tarih ekrandan girilenin aksine yıl.ay.gün şeklinde olduğu için burada ofPattern içerisindeki format
            //farklılık göstermektedir. Aynı girilen iki tarih farklı string formatlarına girilebileceği için karşılaştırma
            //yapılmadan önce ikisinin de LocalDate sınıfına dönüştürülmesi işlemi gerçekleştirilmiştir.
            var tarih = LocalDate.parse(kayit.split(" ")[0],DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            //String'lerde olduğu gibi tarihlerde de equals kullanılabilmektedir.
            if(alinanTarih.equals(tarih))
                System.out.println(kayit);
        }
    }

}