package day11.PRGGAME;

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
        sendToAll(session.id + "님 게임을 종료합니다.");

        clientOutMap.remove(session.id);
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
                    if (continueGame.equals("1")) {
                        int whoisWinner = sgs.startAttack();
                            if (whoisWinner==2 || whoisWinner==3) {
                                sendToAll(this.id + "님 게임을 종료합니다.");
                            break;}
                    }   // 1은 용사승리, 2는 몬스터 승리
                    else if (continueGame.equals("2")) {
                        break; }}
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
            int winner = 1;
            if (this.stageNum == 0) {
            sendToAll("용사(게이머) 상태\n" +
                    "아이디: " + soldier.getId() + "\n" +
                    "레벨: " + soldier.getLevel() + "\n" +
                    "체력: " + soldier.getHp() + "\n" +
                    "공격력: " + soldier.getPower() + "\n" +
                    "-- 계속 할려면 엔터를 입력해주세요. --");}
            else if (this.stageNum == 1) {
                winner = stageSlime(); }
            else if (this.stageNum == 2) {
                winner = stageOrk(); }
            else {winner = stageDragon();}
            stageNum ++;
            return winner;
        }

        int stageSlime() throws InterruptedException {
            int winner;
            int sDex;  //용사 데미지
            int mDex;  //슬라임 데미지
            sendToAll("슬라임 상태\n" +
                    "레벨: " + slime.getLevel() + "\n" +
                    "체력: " + slime.getHp() + "\n" +
                    "공격력: " + slime.getPower() + "\n");
            while (true) {
                sDex = soldier.attack();
                slime.getDex(sDex);
                if (slime.getHp()<=0) {
                    sendToAll("슬라임을 물리쳤다.\n" +
                            "-- 계속 할려면 엔터를 입력해주세요. --");
                    winner = 1;
                    return winner;}
                else {sendToAll("용사가 슬라임에게 " + sDex + "데미지로 공격.\n" +
                                "현재 슬라임 체력 : " + slime.getHp());}
                Thread.sleep(500);
                mDex = slime.attack();
                soldier.getDex(mDex);
                if (soldier.getHp()<=0) {
                    sendToAll("슬라임 승리. 게임종료.");
                    winner = 2;
                    return winner;}
                else {sendToAll("슬라임이 용사에게 "  + mDex + "데미지로 공격.\n" +
                                "현재 용사 체력 : " + soldier.getHp());}
                Thread.sleep(500);
            }
        }

        int stageOrk() throws InterruptedException {
            int winner;
            int sDex;  //용사 데미지
            int mDex;  //오크 데미지
            sendToAll("오크 상태\n" +
                    "레벨: " + ork.getLevel() + "\n" +
                    "체력: " + ork.getHp() + "\n" +
                    "공격력: " + ork.getPower() + "\n");
            while (true) {
                sDex = soldier.attack();
                ork.getDex(sDex);
                if (ork.getHp()<=0) {
                    soldier.levelUp();
                    sendToAll("오크을 물리쳤다.\n");
                    Thread.sleep(500);
                    sendToAll("용사 LevelUp!!!\n" +
                              "용사 상태\n" +
                              "레벨: " + soldier.getLevel() + "\n" +
                              "체력: " + soldier.getHp() + "\n" +
                              "공격력: " + soldier.getPower() + "\n" +
                              "-- 계속 할려면 엔터를 입력해주세요. --");
                    winner = 1;
                    return winner;}
                else {sendToAll("용사가 오크에게 " + sDex + "데미지로 공격.\n" +
                                "현재 오크 체력 : " + ork.getHp());}
                Thread.sleep(500);
                mDex = ork.attack();
                soldier.getDex(mDex);
                if (soldier.getHp()<=0) {
                    sendToAll("오크 승리. 게임종료.");
                    winner = 2;
                    return winner;}
                else {sendToAll("오크가 용사에게 " + mDex + "데미지로 공격.\n" +
                                "현재 용사 체력 : " + soldier.getHp());}
                Thread.sleep(500);
            }
        }

         int stageDragon() throws InterruptedException {
            int winner;
             int sDex;  //용사 데미지
             int mDex;  //드레곤 데미지
            sendToAll("드래곤 상태\n" +
                    "레벨: " + dragon.getLevel() + "\n" +
                    "체력: " + dragon.getHp() + "\n" +
                    "공격력: " + dragon.getPower() + "\n");
             while (true) {
                 sDex = soldier.attack();
                 dragon.getDex(sDex);
                 if (dragon.getHp()<=0) {
                     sendToAll("[외침] 용사 " + soldier.getId() + "가 드래곤을 물리쳤다!");
                     winner = 3;
                     return winner;}
                 else {sendToAll("용사가 드레곤에게 " + sDex + "데미지로 공격.\n" +
                                "현재 드레곤 채력 : " + dragon.getHp());}
                 Thread.sleep(500);
                 mDex = dragon.attack();
                 soldier.getDex(mDex);
                 if (soldier.getHp()<=0) {
                     sendToAll("드래곤 승리. 게임종료.");
                     winner = 2;
                     return winner;}
                 else {sendToAll("드레곤이 용사에게 " + mDex + "데지지로 공격.\n" +
                                "현재 용사 체력 : " + soldier.getHp());}
                 Thread.sleep(500);
             }
         }

    }
}
