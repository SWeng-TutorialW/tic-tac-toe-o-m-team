package il.cshaifasweng.OCSFMediatorExample.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondaryController {

    @FXML // fx:id="connectButton"
    private Button connectButton;

    @FXML // fx:id="ipText"
    private TextField ipText;

    @FXML
    private TextField port;

    @FXML
    void switchToPrimary(ActionEvent event) {
        try {
            // Get IP and port from the text fields
            String ip = ipText.getText().trim();
            String porttext = port.getText().trim();

            int portNumber;
            try {
                portNumber = Integer.parseInt(porttext);
                if (portNumber < 1 || portNumber > 65535) {
                    showError("Port must be between 1 and 65535.");
                    return;
                }
            } catch (NumberFormatException e) {
                showError("Invalid port number. Please enter a valid integer.");
                return;
            }

            // Create client and connect
            SimpleClient client = SimpleClient.getClient(ip, portNumber);
            client.openConnection();

            // Close the connect window
            Stage stage = (Stage) ipText.getScene().getWindow();
            stage.close();

            // Launch the main UI
            App.launchPrimaryUI();

        } catch (Exception e) {
            showError("Connection failed: " + e.getMessage());
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.showAndWait();
    }

}
