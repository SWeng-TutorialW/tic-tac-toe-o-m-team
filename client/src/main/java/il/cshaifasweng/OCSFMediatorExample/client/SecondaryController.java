/**
 * Sample Skeleton for 'secondary.fxml' Controller Class
 */

package il.cshaifasweng.OCSFMediatorExample.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondaryController {

    @FXML // fx:id="connectButton"
    private Button connectButton; // Value injected by FXMLLoader

    @FXML // fx:id="ipText"
    private TextField ipText; // Value injected by FXMLLoader

    @FXML
    void switchToPrimary(ActionEvent event) {
        try {
            // Get IP and port from the text fields
            String ip = ipText.getText().trim();

            // Create client and connect
            SimpleClient client = SimpleClient.getClient(ip, 4001);
            client.openConnection();

            // Close the connect window
            Stage stage = (Stage) ipText.getScene().getWindow();
            stage.close();

            // Launch the main UI
            App.launchPrimaryUI();

        }
        catch (Exception e) {
            showError("Connection failed: " + e.getMessage());
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.showAndWait();
    }

}
