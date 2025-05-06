package il.cshaifasweng.OCSFMediatorExample.client;

import org.greenrobot.eventbus.EventBus;

import il.cshaifasweng.OCSFMediatorExample.client.ocsf.AbstractClient;
import il.cshaifasweng.OCSFMediatorExample.entities.Warning;

public class SimpleClient extends AbstractClient {
	private static int yourturn  =  -1 ;
	private static int clientId = -1;
	private static char clientSign ;
	private static SimpleClient client = null;

	private SimpleClient(String host, int port) {
		super(host, port);
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		String message = msg.toString();

		if (message.startsWith("Your ID is:")) {
			try {
				clientId = Integer.parseInt(message.substring(12).trim());
				if (clientId == 1){
					clientSign = 'O';
					yourturn =  0;
				}
				if (clientId == 2){
					clientSign = 'X';
					yourturn = 1;
				}
				System.out.println("Client received ID: " + clientId);
			} catch (NumberFormatException e) {
				System.err.println("Error parsing client ID.");
			}
		}
		else if (message.startsWith("restart the game")) {
			EventBus.getDefault().post(new restartGame());

			if (clientId == 1){
				clientSign = 'X';
				yourturn =  1;
			}
			if (clientId == 2){
				clientSign = 'O';
				yourturn = 0;
			}

		}
		else if (message.startsWith("client 1 won")) {
			EventBus.getDefault().post(new winner(1));
			yourturn = 0;
		}
		else if (message.startsWith("client 2 won")) {
			EventBus.getDefault().post(new winner(2));
			yourturn = 0;
		}
		else if (message.startsWith("draw")) {
			EventBus.getDefault().post(new winner(3));
			yourturn = 0;
		}
		else if (message.startsWith("topLeftClicked")) {
			char sign = message.charAt(message.length() - 1);

			EventBus.getDefault().post(new playEvent(0,0,sign));
			//switch turnes when the other just wrote
			if (yourturn == 1){
				yourturn = 0;
			}
			else {
				yourturn = 1;
			}
		} else if (message.startsWith("topMid")) {
			char sign = message.charAt(message.length() - 1);

			EventBus.getDefault().post(new playEvent(0,1,sign));
			//switch turnes when the other just wrote
			if (yourturn == 1){
				yourturn = 0;
			}
			else {
				yourturn = 1;
			}
		} else if (message.startsWith("topRight")) {
			char sign = message.charAt(message.length() - 1);

			EventBus.getDefault().post(new playEvent(0,2,sign));
			//switch turnes when the other just wrote
			if (yourturn == 1){
				yourturn = 0;
			}
			else {
				yourturn = 1;
			}
		} else if (message.startsWith("midLeft")) {
			char sign = message.charAt(message.length() - 1);

			EventBus.getDefault().post(new playEvent(1,0,sign));
			//switch turnes when the other just wrote
			if (yourturn == 1){
				yourturn = 0;
			}
			else {
				yourturn = 1;
			}
		} else if (message.startsWith("midMid")) {
			char sign = message.charAt(message.length() - 1);

			EventBus.getDefault().post(new playEvent(1,1,sign));
			//switch turnes when the other just wrote
			if (yourturn == 1){
				yourturn = 0;
			}
			else {
				yourturn = 1;
			}

		} else if (message.startsWith("midRight")) {
			char sign = message.charAt(message.length() - 1);

			EventBus.getDefault().post(new playEvent(1,2,sign));
			//switch turnes when the other just wrote
			if (yourturn == 1){
				yourturn = 0;
			}
			else {
				yourturn = 1;
			}
		} else if (message.startsWith("underLeft")) {
			char sign = message.charAt(message.length() - 1);

			EventBus.getDefault().post(new playEvent(2,0,sign));
			//switch turnes when the other just wrote
			if (yourturn == 1){
				yourturn = 0;
			}
			else {
				yourturn = 1;
			}
		} else if (message.startsWith("underMid")) {
			char sign = message.charAt(message.length() - 1);

			EventBus.getDefault().post(new playEvent(2,1,sign));
			//switch turnes when the other just wrote
			if (yourturn == 1){
				yourturn = 0;
			}
			else {
				yourturn = 1;
			}
		} else if (message.startsWith("underRight")) {
			char sign = message.charAt(message.length() - 1);

			EventBus.getDefault().post(new playEvent(2,2,sign));
			//switch turnes when the other just wrote
			if (yourturn == 1){
				yourturn = 0;
			}
			else {
				yourturn = 1;
			}

		}

	}
	
	public static SimpleClient getClient() {
		if (client == null) {
			client = new SimpleClient("localhost", 4001);
		}
		return client;
	}


	public static int getClientId() {
		return clientId;
	}

	public static char getClientSign() {
		return clientSign;
	}

	public static int getYourturn() {
		return yourturn;
	}


	@Override
	protected void connectionClosed() {
		System.out.println("Connection closed");
	}

	@Override
	protected void connectionException(Exception exception) {
		// Log the exception
		System.err.println("Connection error: " + exception.getMessage());
		exception.printStackTrace();
	}


}
