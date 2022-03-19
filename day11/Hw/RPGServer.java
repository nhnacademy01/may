package day11.Hw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;


public class RPGServer {

    private final ConcurrentHashMap<String, DataOutputStream> clientOutMap = new ConcurrentHashMap();

    public static void main(String[] args) throws IOException {
        RPGServer server = new RPGServer();
        server.start();
    }

    private void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println(getTime() + " Start server " + serverSocket.getLocalSocketAddress());
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    RPGServer.AttackSession client = new RPGServer.AttackSession(socket);
                    client.start();   //공격 시작
                } catch (IOException e) {
                    // TODO 클라이언트 접속 실패
                }
            }
        }
    }

    private String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }



    // 싸우는 과정 메소드 만들기



    private void sendToAll(String message) {
        for (DataOutputStream out : clientOutMap.values()) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                // TODO: 해당 클라이언트로 송출 스트림이 실패함(네트워크 끈김)
            }
        }
    }


    class AttackSession {
        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;
        private String id;

        AttackSession(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());      // 누구랑 싸우는지?
            this.out = new DataOutputStream(socket.getOutputStream());   // 누가 이겼는지?
        }

        @Override
        public void run() {
            initialize();
            connect();
        }

        private void connect() {
            try {
                while (isConnect()) {
                    sendToAll(in.readUTF());
                }
            } catch (IOException cause) {
                // TODO: 채팅 중 연결이 끊기는 경우
            } finally {
                disconnect();
            }
        }

        private void initialize() {
            try {
                this.id = in.readUTF();
                joinChat(this);
            } catch (IOException cause) {
                // TODO: 최초 통신(아이디 받기)이 실패하는 경우
            }
        }


    }
}
