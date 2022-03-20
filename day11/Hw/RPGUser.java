package day11.Hw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class RPGUser {

    private final String id;

    public RPGUser(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        if (hasNotArgs(args)) {
            System.out.println("USAGE: java MyChatClient {id}");
            return;
        }
        String id = args[0];
        RPGUser client = new RPGUser(id);
        client.connect("127.0.0.1", 8888);
    }

    private static boolean hasNotArgs(String[] args) {
        return args.length == 0;
    }

    private void connect(String serverHost, int port) {
        try {
            Socket socket = new Socket(serverHost, port);
            System.out.println("Connected to server " + serverHost + ":" + port);
            Thread sender = new RPGUser.Sender(socket, id);  //메세지 보내는 스레드
            Thread receiver = new RPGUser.Receiver(socket);  //메세지 받는 스레드

            sender.start();
            receiver.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Sender extends Thread {
        private String id;
        private DataOutputStream out;
        private UserGameStory ugs;

        private Sender(Socket socket, String id) throws IOException {
            this.id = id;
            this.out = new DataOutputStream(socket.getOutputStream());
            this.ugs = new UserGameStory(id);
        }

        @Override
        public void run() {
            try {
                initialize();
                sendMessage();
            } catch (IOException e) {
                // TODO
            }
        }

        private void initialize() throws IOException {
            if (isSendable()) {
                //맨 처음에 서버에 아이디를 보낸다.
                this.out.writeUTF(id);
            }
        }

        private boolean isSendable() {
            return this.out != null;
        }

        private void sendMessage() throws IOException {
            Scanner sc = new Scanner(System.in);
            while (isSendable()) {
                String continueGame = ugs.stage();
                this.out.writeUTF(continueGame);
                sc.nextLine();
            }
        }
    }

    private static class Receiver extends Thread {
        private final DataInputStream in;

        private Receiver(Socket socket) throws IOException {
            this.in = new DataInputStream(socket.getInputStream());
        }

        @Override
        public void run() {
            while (isReceivable()) {
                receiveMessage();
            }
        }

        private boolean isReceivable() {
            return this.in != null;
        }

        private void receiveMessage() {
            try {
                System.out.println(in.readUTF()); //서버에서 주는 메세지 출력
            } catch (IOException e) {
                // TODO
            }
        }
    }
}
