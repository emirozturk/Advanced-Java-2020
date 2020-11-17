package sample;

import com.emirozturk.Siparis;
import com.emirozturk.Siparisler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Siparisler siparisler;
    @FXML
    public TextField tbAranan;
    @FXML
    public ComboBox<String> cmbAlan;
    @FXML
    public ListView<Siparis> lbListe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbAlan.getItems().addAll("Tarihe göre","Ada göre");
        try {
            String yol = "/Users/emirozturk/Desktop/Uygulama5Sablon/veri.txt";
            var yolPath = Paths.get(yol);
            var satirlar = Files.readAllLines(yolPath);
            siparisler = Siparisler.stringListesindenOlustur(satirlar);
            Listele(siparisler.tumunuAl());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void tbArananKeyReleased(KeyEvent keyEvent) {
        ara();
    }

    public void cmbAlanOnAction(ActionEvent actionEvent) {
        ara();
    }

    private void ara() {
        if(tbAranan.getText().equals("")){ //tbAranan textbox'ının text'ini al boş mu kontrol et
            List<Siparis> sonuc = siparisler.tumunuAl(); //Siparisler sınıfındaki tüm siparis listesini elde et
            Listele(sonuc); //elde edilen Siparis Listesini Listview içerisinde göster
        }
        else{
            if(cmbAlan.getValue()!=null){
                if(cmbAlan.getValue().equals("Ada göre")){ //cmbAlan içerisinde "Ada göre" seçiliyse
                    List<Siparis> sonuc = siparisler.adaGoreAra(tbAranan.getText());
                    Listele(sonuc);
                }
                else if(cmbAlan.getValue().equals("Tarihe göre")){//cmbAlan içerisinde "Tarihe göre" seçiliyse
                    try{
                        LocalDate tarih = LocalDate.parse(tbAranan.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy")); //Textbox'a girilen string'i tarih formatına çevirme
                        List<Siparis> sonuc = siparisler.tariheGoreAra(tarih); //tarih parametresine göre dönen sonuçların eldesi
                        Listele(sonuc);
                    }catch(Exception e){
                        Listele(siparisler.tumunuAl());
                    }
                }
            }
        }
    }

    private void Listele(List<Siparis> sonuc) {
        lbListe.getItems().clear(); //Listbox'ı temizle
        lbListe.getItems().addAll(sonuc); //parametre olarak gelen listeyi listele
    }
}
