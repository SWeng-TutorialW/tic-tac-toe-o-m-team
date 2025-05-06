package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import il.cshaifasweng.OCSFMediatorExample.client.playEvent;

/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PrimaryController {

	@FXML // fx:id="button1"
	private Button button1; // Value injected by FXMLLoader

	@FXML // fx:id="button2"
	private Button button2; // Value injected by FXMLLoader

	@FXML // fx:id="button3"
	private Button button3; // Value injected by FXMLLoader

	@FXML // fx:id="button4"
	private Button button4; // Value injected by FXMLLoader

	@FXML // fx:id="button5"
	private Button button5; // Value injected by FXMLLoader

	@FXML // fx:id="button6"
	private Button button6; // Value injected by FXMLLoader

	@FXML // fx:id="button7"
	private Button button7; // Value injected by FXMLLoader

	@FXML // fx:id="button8"
	private Button button8; // Value injected by FXMLLoader

	@FXML // fx:id="button9"
	private Button button9; // Value injected by FXMLLoader

	@FXML // fx:id="midleft"
	private Text midleft; // Value injected by FXMLLoader

	@FXML // fx:id="midmid"
	private Text midmid; // Value injected by FXMLLoader

	@FXML // fx:id="midright"
	private Text midright; // Value injected by FXMLLoader

	@FXML // fx:id="restartButton"
	private Button restartButton; // Value injected by FXMLLoader

	@FXML // fx:id="topleft"
	private Text topleft; // Value injected by FXMLLoader

	@FXML // fx:id="topmid"
	private Text topmid; // Value injected by FXMLLoader

	@FXML // fx:id="topright"
	private Text topright; // Value injected by FXMLLoader

	@FXML // fx:id="underLeft"
	private Text underLeft; // Value injected by FXMLLoader

	@FXML // fx:id="undermid"
	private Text undermid; // Value injected by FXMLLoader

	@FXML // fx:id="underright"
	private Text underright; // Value injected by FXMLLoader

	@FXML // fx:id="winnerText"
	private Text winnerText; // Value injected by FXMLLoader


	@FXML
	void button1_topLeft(ActionEvent event) {
		int yourTurn = SimpleClient.getYourturn();
		char sign = SimpleClient.getClientSign();
		if (yourTurn == 1 && topleft.getText().equals("")) {
			try {
				SimpleClient.getClient().sendToServer("topLeft" + sign);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	void button2_topmid(ActionEvent event) {
		int yourTurn = SimpleClient.getYourturn();
		char sign = SimpleClient.getClientSign();
		if (yourTurn == 1 && topmid.getText().equals("")) {
			try {
				SimpleClient.getClient().sendToServer("topMid" + sign);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@FXML
	void button3_topright(ActionEvent event) {
		int yourTurn = SimpleClient.getYourturn();
		char sign = SimpleClient.getClientSign();
		if (yourTurn == 1 && topright.getText().equals("")) {
			try {
				SimpleClient.getClient().sendToServer("topRight" + sign);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@FXML
	void button4_midLeft(ActionEvent event) {
		int yourTurn = SimpleClient.getYourturn();
		char sign = SimpleClient.getClientSign();
		if (yourTurn == 1 && midleft.getText().equals("")) {
			try {
				SimpleClient.getClient().sendToServer("midLeft" + sign);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@FXML
	void button5_midMid(ActionEvent event) {
		int yourTurn = SimpleClient.getYourturn();
		char sign = SimpleClient.getClientSign();
		if (yourTurn == 1 && midmid.getText().equals("")) {
			try {
				SimpleClient.getClient().sendToServer("midMid" + sign);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	void button6_midRight(ActionEvent event) {
		int yourTurn = SimpleClient.getYourturn();
		char sign = SimpleClient.getClientSign();
		if (yourTurn == 1 && midright.getText().equals("")) {
			try {
				SimpleClient.getClient().sendToServer("midRight" + sign);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	void button7_underLeft(ActionEvent event) {
		int yourTurn = SimpleClient.getYourturn();
		char sign = SimpleClient.getClientSign();
		if (yourTurn == 1 && underLeft.getText().equals("")) {
			try {
				SimpleClient.getClient().sendToServer("underLeft" + sign);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	void button8_underMid(ActionEvent event) {
		int yourTurn = SimpleClient.getYourturn();
		char sign = SimpleClient.getClientSign();
		if (yourTurn == 1 && undermid.getText().equals("")) {
			try {
				SimpleClient.getClient().sendToServer("underMid" + sign);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	void button9_underRight(ActionEvent event) {
		int yourTurn = SimpleClient.getYourturn();
		char sign = SimpleClient.getClientSign();
		if (yourTurn == 1 && underright.getText().equals("")) {
			try {
				SimpleClient.getClient().sendToServer("underRight" + sign);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	void restartGame(ActionEvent event) {
		try {
			SimpleClient.getClient().sendToServer("restart the game");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Subscribe
	public void updateMatrix(playEvent event) {
		int row = event.getRows();
		int col = event.getCols();
		char sign = event.getSign();

		Platform.runLater(() -> {
			switch (row) {
				case 0:
					switch (col) {
						case 0:
							topleft.setText(String.valueOf(sign));
							break;
						case 1:
							topmid.setText(String.valueOf(sign));
							break;
						case 2:
							topright.setText(String.valueOf(sign));
							break;
					}
					break;

				case 1:
					switch (col) {
						case 0:
							midleft.setText(String.valueOf(sign));
							break;
						case 1:
							midmid.setText(String.valueOf(sign));
							break;
						case 2:
							midright.setText(String.valueOf(sign));
							break;
					}
					break;

				case 2:
					switch (col) {
						case 0:
							underLeft.setText(String.valueOf(sign));
							break;
						case 1:
							undermid.setText(String.valueOf(sign));
							break;
						case 2:
							underright.setText(String.valueOf(sign));
							break;
					}
					break;
			}
		});
	}

	@Subscribe
	public void restartGame(restartGame event) {
		Platform.runLater(() -> {
			winnerText.setText("lets play X/O");
			topleft.setText("");
			topmid.setText("");
			topright.setText("");
			midleft.setText("");
			midmid.setText("");
			midright.setText("");
			underLeft.setText("");
			undermid.setText("");
			underright.setText("");
		});
	}

	@Subscribe
	public void winner(winner event) {
		int winner = event.getWinner();
		if (winner == 3) {
			Platform.runLater(() -> {
				winnerText.setText("Draw!!!");
			});
		}
		else{
			Platform.runLater(() -> {
				winnerText.setText("player " + String.valueOf(winner) + " won!");
			});
		}
	}


	@FXML
	void initialize(){
		EventBus.getDefault().register(this);
		try {
			SimpleClient.getClient().sendToServer("add client");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		topleft.setText("");
		topmid.setText("");
		topright.setText("");
		midleft.setText("");
		midmid.setText("");
		midright.setText("");
		underLeft.setText("");
		undermid.setText("");
		underright.setText("");
	}


}

