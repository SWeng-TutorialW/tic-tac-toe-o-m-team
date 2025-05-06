package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.SubscribedClient;

import java.io.IOException;
import java.util.ArrayList;

public class SimpleServer extends AbstractServer {
    private int clientCount = 0;
    private static ArrayList<SubscribedClient> SubscribersList = new ArrayList<>();

    private int[][] matrix = new int[3][3]; // Example 3x3 grid

    public int checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    return 0; // Still at least one empty cell, not a draw
                }
            }
        }
        return 1; // All cells filled → draw (assuming no winner)
    }


    public int checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            // Check row
            if (matrix[i][0] != 0 && matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                return matrix[i][0]; // Return winner (1 or 2)
            }
            // Check column
            if (matrix[0][i] != 0 && matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) {
                return matrix[0][i];
            }
        }

        // Check diagonals
        if (matrix[0][0] != 0 && matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) {
            return matrix[0][0];
        }
        if (matrix[0][2] != 0 && matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]) {
            return matrix[0][2];
        }

        // No winner
        return 0;
    }


    public SimpleServer(int port) {
        super(port);

    }

    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
        String msgString = msg.toString();
        if (msgString.startsWith("restart the game")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = 0;
                }
            }
            sendToAllClients("restart the game");
        } else if (msgString.startsWith("topLeft")) {
            char sign = msgString.charAt(msgString.length() - 1);

            // Notify all clients to update their UI
            sendToAllClients("topLeftClicked" + sign);

            if (matrix[0][0] == 0) {
                if (sign == 'X') {
                    matrix[0][0] = 1;
                } else if (sign == 'O') {
                    matrix[0][0] = 2;
                }
            }

            int winner = checkWinner();


            if (winner == 1) {
                sendToAllClients("client 1 won");
            }
            if (winner == 2) {
                sendToAllClients("client 2 won");
            }
            int draw = checkDraw();
            if (draw == 1) {
                sendToAllClients("draw");
            }
        } else if (msgString.startsWith("topMid")) {
            char sign = msgString.charAt(msgString.length() - 1);

            // Notify all clients to update their UI
            sendToAllClients("topMid" + sign);

            if (matrix[0][1] == 0) {
                if (sign == 'X') {
                    matrix[0][1] = 1;
                } else if (sign == 'O') {
                    matrix[0][1] = 2;
                }
            }

            int winner = checkWinner();

            if (winner == 1) {
                sendToAllClients("client 1 won");
            }
            if (winner == 2) {
                sendToAllClients("client 2 won");
            }
            int draw = checkDraw();
            if (draw == 1) {
                sendToAllClients("draw");
            }
        } else if (msgString.startsWith("topRight")) {
            char sign = msgString.charAt(msgString.length() - 1);

            // Notify all clients to update their UI
            sendToAllClients("topRight" + sign);

            if (matrix[0][2] == 0) {
                if (sign == 'X') {
                    matrix[0][2] = 1;
                } else if (sign == 'O') {
                    matrix[0][2] = 2;
                }
            }

            int winner = checkWinner();

            if (winner == 1) {
                sendToAllClients("client 1 won");
            }
            if (winner == 2) {
                sendToAllClients("client 2 won");
            }
            int draw = checkDraw();
            if (draw == 1) {
                sendToAllClients("draw");
            }

        } else if (msgString.startsWith("midLeft")) {
            char sign = msgString.charAt(msgString.length() - 1);

            // Notify all clients to update their UI
            sendToAllClients("midLeft" + sign);

            if (matrix[1][0] == 0) {
                if (sign == 'X') {
                    matrix[1][0] = 1;
                } else if (sign == 'O') {
                    matrix[1][0] = 2;
                }
            }

            int winner = checkWinner();

            if (winner == 1) {
                sendToAllClients("client 1 won");
            }
            if (winner == 2) {
                sendToAllClients("client 2 won");
            }
            int draw = checkDraw();
            if (draw == 1) {
                sendToAllClients("draw");
            }

        } else if (msgString.startsWith("midMid")) {
            char sign = msgString.charAt(msgString.length() - 1);

            // Notify all clients to update their UI
            sendToAllClients("midMid" + sign);

            if (matrix[1][1] == 0) {
                if (sign == 'X') {
                    matrix[1][1] = 1;
                } else if (sign == 'O') {
                    matrix[1][1] = 2;
                }
            }

            int winner = checkWinner();

            if (winner == 1) {
                sendToAllClients("client 1 won");
            }
            if (winner == 2) {
                sendToAllClients("client 2 won");
            }
            int draw = checkDraw();
            if (draw == 1) {
                sendToAllClients("draw");
            }

        } else if (msgString.startsWith("midRight")) {
            char sign = msgString.charAt(msgString.length() - 1);

            // Notify all clients to update their UI
            sendToAllClients("midRight" + sign);

            if (matrix[1][2] == 0) {
                if (sign == 'X') {
                    matrix[1][2] = 1;
                } else if (sign == 'O') {
                    matrix[1][2] = 2;
                }
            }

            int winner = checkWinner();

            if (winner == 1) {
                sendToAllClients("client 1 won");
            }
            if (winner == 2) {
                sendToAllClients("client 2 won");
            }
            int draw = checkDraw();
            if (draw == 1) {
                sendToAllClients("draw");
            }

        } else if (msgString.startsWith("underLeft")) {
            char sign = msgString.charAt(msgString.length() - 1);

            // Notify all clients to update their UI
            sendToAllClients("underLeft" + sign);

            if (matrix[2][0] == 0) {
                if (sign == 'X') {
                    matrix[2][0] = 1;
                } else if (sign == 'O') {
                    matrix[2][0] = 2;
                }
            }

            int winner = checkWinner();

            if (winner == 1) {
                sendToAllClients("client 1 won");
            }
            if (winner == 2) {
                sendToAllClients("client 2 won");
            }
            int draw = checkDraw();
            if (draw == 1) {
                sendToAllClients("draw");
            }

        } else if (msgString.startsWith("underMid")) {
            char sign = msgString.charAt(msgString.length() - 1);

            // Notify all clients to update their UI
            sendToAllClients("underMid" + sign);

            if (matrix[2][1] == 0) {
                if (sign == 'X') {
                    matrix[2][1] = 1;
                } else if (sign == 'O') {
                    matrix[2][1] = 2;
                }
            }

            int winner = checkWinner();

            if (winner == 1) {
                sendToAllClients("client 1 won");
            }
            if (winner == 2) {
                sendToAllClients("client 2 won");
            }
            int draw = checkDraw();
            if (draw == 1) {
                sendToAllClients("draw");
            }

        } else if (msgString.startsWith("underRight")) {
            char sign = msgString.charAt(msgString.length() - 1);

            // Notify all clients to update their UI
            sendToAllClients("underRight" + sign);

            if (matrix[2][2] == 0) {
                if (sign == 'X') {
                    matrix[2][2] = 1;
                } else if (sign == 'O') {
                    matrix[2][2] = 2;
                }
            }

            int winner = checkWinner();

            if (winner == 1) {
                sendToAllClients("client 1 won");
            }
            if (winner == 2) {
                sendToAllClients("client 2 won");
            }
            int draw = checkDraw();
            if (draw == 1) {
                sendToAllClients("draw");
            }

        } else if (msgString.startsWith("add client")) {
            clientCount++;
            int clientId = clientCount;

            System.out.println("Client connected. Assigned ID: " + clientId);

            SubscribedClient connection = new SubscribedClient(client);
            SubscribersList.add(connection);
            try {
                client.sendToClient("client added successfully");
                client.sendToClient("Your ID is: " + clientId);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (msgString.startsWith("remove client")) {
            if (!SubscribersList.isEmpty()) {
                for (SubscribedClient subscribedClient : SubscribersList) {
                    if (subscribedClient.getClient().equals(client)) {
                        SubscribersList.remove(subscribedClient);
                        break;
                    }
                }
            }
        }
    }

    public void sendToAllClients(String message) {
        try {
            for (SubscribedClient subscribedClient : SubscribersList) {
                subscribedClient.getClient().sendToClient(message);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
