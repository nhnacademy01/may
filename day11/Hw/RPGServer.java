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

    private void gameStart(AttackSession session) {
        clientOutMap.put(session.id, session.out);

        System.out.println(getTime() + " " + session.id + " is joined: " + session.socket.getInetAddress());
        loggingCurrentClientCount();
    }

    private void gameEnd(AttackSession session) {
        clientOutMap.remove(session.id);

        sendToAll(session.id + "님 게임을 종료합니다.");
        System.out.println(getTime() + " " + session.id + " is leaved: " + session.socket.getInetAddress());
        loggingCurrentClientCount();
    }

    private void loggingCurrentClientCount() {
        System.out.println(getTime() + " Currently " + clientOutMap.size() + " clients are connected.");
    }

    private void sendToAll(String message) {
        for (DataOutputStream out : clientOutMap.values()) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                // TODO: 해당 클라이언트로 송출 스트림이 실패함(네트워크 끈김)
            }
        }
    }


    class AttackSession extends Thread {
        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;
        private String id;

        AttackSession(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            initialize();
            connect();
        }

        private void initialize() {
            try {
                this.id = in.readUTF();
                gameStart(this);
            } catch (IOException cause) {
                // TODO: 최초 통신(아이디 받기)이 실패하는 경우
            }
        }

        private void connect() {
            SeverGameStory sgs = new SeverGameStory(this.id);
            try {
                while (isConnect()) {
                    String continueGame = in.readUTF();
                    if (continueGame == "1") {
                        int whoisWinner = sgs.startAttack();
                            if (whoisWinner==2 || whoisWinner==3) {
                            disconnect();}
                    }   // 1은 용사승리, 2는 몬스터 승리
                    else if (continueGame == "2") {
                        disconnect(); }}
            } catch (IOException cause) {
                // TODO: 채팅 중 연결이 끊기는 경우
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }

        private boolean isConnect() {
            return this.in != null;
        }

        private void disconnect() {
            gameEnd(this);
        }
    }

    class SeverGameStory {
        private int stageNum = 0;
        Soldier soldier;
        Slime slime;
        Ork ork;
        Dragon dragon;

        public SeverGameStory(String id) {
            soldier = new Soldier(id);
            slime = new Slime();
            ork = new Ork();
            dragon = new Dragon();
        }

        public int startAttack() throws InterruptedException {
            int winner;
            stageNum ++;
            sendToAll("용사(게이머) 상태\n" +
                    "아이디: " + soldier.getId() + "\n" +
                    "레벨: " + soldier.getLevel() + "\n" +
                    "체력: " + soldier.getHp() + "\n" +
                    "공격력: " + soldier.getPower() + "\n");
            if (this.stageNum == 1) {
                winner = stageSlime(); }
            else if (this.stageNum == 2) {
                winner = stageOrk(); }
            else {winner = stageDragon();}

            return winner;
        }

        int stageSlime() throws InterruptedException {
            int winner;
            sendToAll("슬라임 상태\n" +
                    "레벨: " + slime.getLevel() + "\n" +
                    "체력: " + slime.getHp() + "\n" +
                    "공격력: " + slime.getPower() + "\n");
            while (true) {
                slime.getDex(soldier.attack());
                if (slime.getHp()<=0) {
                    sendToAll("슬라임을 물리쳤다.\n" +
                            "-- 계속 할려면 엔터를 입력해주세요. --");
                    winner = 1;
                    return winner;}
                else {sendToAll("slime HP : " + slime.getHp());}
                Thread.sleep(500);
                soldier.getDex(slime.attack());
                if (soldier.getHp()<=0) {
                    sendToAll("슬라임 승리. 게임종료.");
                    winner = 2;
                    return winner;}
                else {sendToAll("soldier HP : " + soldier.getHp());}
                Thread.sleep(500);
            }
        }

        int stageOrk() throws InterruptedException {
            int winner;
            sendToAll("오크 상태\n" +
                    "레벨: " + ork.getLevel() + "\n" +
                    "체력: " + ork.getHp() + "\n" +
                    "공격력: " + ork.getPower() + "\n");
            while (true) {
                ork.getDex(soldier.attack());
                if (ork.getHp()<=0) {
                    sendToAll("오크을 물리쳤다.\n" +
                            "-- 계속 할려면 엔터를 입력해주세요. --");
                    winner = 1;
                    return winner;}
                else {sendToAll("ork HP : " + ork.getHp());}
                Thread.sleep(500);
                soldier.getDex(ork.attack());
                if (soldier.getHp()<=0) {
                    sendToAll("오크 승리. 게임종료.");
                    winner = 2;
                    return winner;}
                else {sendToAll("soldier HP : " + soldier.getHp());}
                Thread.sleep(500);
            }
        }

         int stageDragon() throws InterruptedException {
            int winner;
            sendToAll("드래곤 상태\n" +
                    "레벨: " + dragon.getLevel() + "\n" +
                    "체력: " + dragon.getHp() + "\n" +
                    "공격력: " + dragon.getPower() + "\n");
             while (true) {
                 dragon.getDex(soldier.attack());
                 if (dragon.getHp()<=0) {
                     sendToAll("[외침] 용사 " + soldier.getId() + "가 드래곤을 물리쳤다!");
                     winner = 3;
                     return winner;}
                 else {sendToAll("dragon HP : " + dragon.getHp());}
                 Thread.sleep(500);
                 soldier.getDex(dragon.attack());
                 if (soldier.getHp()<=0) {
                     sendToAll("드래곤 승리. 게임종료.");
                     winner = 2;
                     return winner;}
                 else {sendToAll("soldier HP : " + soldier.getHp());}
                 Thread.sleep(500);
             }
         }

    }
}
