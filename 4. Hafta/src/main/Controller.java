package main;

import com.emirozturk.Siparis;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.*;

public class Controller {
    @FXML
    public TextField tbAranan;
    @FXML
    public ComboBox<String> cmbAlan;
    @FXML
    public ListView<Siparis> lbListe;
}
