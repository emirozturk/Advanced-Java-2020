package com.emirozturk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Siparisler siparisler;
    public static void main(String[] args) throws IOException {
        List<String> satirlar = Files.readAllLines(Paths.get("/Users/emirozturk/Desktop/veri.txt"));
        siparisler = Siparisler.stringListesindenOlustur(satirlar); //Siparisler sınıfının statik metodunun çağırılması
        menu();
    }
    static void menu(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1.Tarihe göre");
            System.out.println("2.Müşteri Adına göre");
            System.out.println("3.Cikis");
            System.out.println("Secim:");
            int secim = scanner.nextInt();
            if(secim == 1){
                System.out.println("Tarih giriniz:");
                String tarihStringi = scanner.nextLine();
                LocalDate ekrandanAlinanTarih = LocalDate.parse(tarihStringi, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                List<Siparis> sonucListesi = siparisler.tariheGoreAra(ekrandanAlinanTarih); //Siparisler sınıfından bir nesnenin tarihe göre ara metodunun çağırılması
                for(var siparis:sonucListesi){
                    System.out.println(siparis);
                }
            }
            else if(secim ==2){
                System.out.println("Müşteri adını giriniz:");
                String musteriAdi = scanner.nextLine();
                List<Siparis> sonucListesi = siparisler.adaGoreAra(musteriAdi); //Siparisler sınıfından bir nesnenin ada göre ara metodunun çağırılması
                for(var siparis:sonucListesi){
                    System.out.println(siparis);
                }
            }
            else if(secim == 3)System.exit(0);
        }
    }
}
