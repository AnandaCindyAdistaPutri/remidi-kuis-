/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import mouse.db.DBHandler;
import mouse.model.Mahasiswa;


public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnSave;

    @FXML
    private DatePicker dpTanggalBeli;

    @FXML
    private ToggleGroup warna;

    @FXML
    private Label label;

    @FXML
    private RadioButton rdHitam;

    @FXML
    private RadioButton rdMerah;

    @FXML
    private TextField tfMouse;

    @FXML
    private TextField tfNama;
    
    @FXML
    private TextField tfHarga;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        System.out.println(tfNama.getText());
        System.out.println(tfHarga.getText());
        System.out.println(dpTanggalBeli.getValue().toString());
        String warna="";
        if (rdHitam.isSelected())
           warna=rdHitam.getText();
        if (rdMerah.isSelected())
           warna=rdMerah.getText();
        System.out.println(warna);
        System.out.println(tfMouse.getText());

        Mahasiswa mhs = new Mahasiswa(tfNama.getText(),tfHarga.getText(),dpTanggalBeli.getValue().toString(),
            warna,tfMouse.getText());
        DBHandler dh = new DBHandler("MYSQL");
        dh.addMahasiswa(mhs);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}