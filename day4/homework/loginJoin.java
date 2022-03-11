package day4.homework;

import java.util.Objects;
import java.util.Scanner;

public class loginJoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SignUpInShell Si = new SignUpInShell();
        int menuSelect;
        do {
            System.out.println("nhn academy 에 오신 것을 환영합니다. 아래에서 메뉴를 선택하세요.");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("0. 종료");
            menuSelect = sc.nextInt();
            if (menuSelect == 1) {
                Si.join();
            }
            if (menuSelect == 2) {
                Si.login();
            }
        } while (menuSelect == 0);
    }
}

class SignUpInShell {
    Scanner sc = new Scanner(System.in);
    Account[] members = new Account[100];

    void join() {   //회원가입하는 메소드
        boolean checkresult;
        do {
            System.out.println("회원가입을 해주세요.");
            System.out.println("아이디");
            String newid = sc.next();
            System.out.println("비밀번호");
            String newpwd = sc.next();
            System.out.println("비밀번호 재입력");
            String againpwd = sc.next();
            System.out.println("이름");
            String newname = sc.next();
            System.out.println("사용자 타입 (고객:0, 관리자:1");
            int usertype = sc.nextInt();
            checkresult = checkIdPwd(newid, newpwd, againpwd);   //id, pwd 등 에러체크해주는 메소드
            if (checkresult) {   //정상적으로 회원가입 되었을 때 true
                System.out.println("회원가입에 성공했습니다. 이전 메뉴로 돌아갑니다.");
                registId(newid, newpwd, newname, usertype);
            }   //회원가입 되면 id, pwd, name, usertype DB에 저장
        } while (!checkresult);
    }   //정상적으로 회원가입 될 때까지 반복

    boolean checkIdPwd(String id, String pwd, String cpwd) {
        if (!Objects.equals(pwd, cpwd)) {
            System.out.println("비밀번호가 일치하지 않아서 회원가입에 실패했습니다.");
            return false;
        } else if (id == null || pwd == null || cpwd == null) {
            System.out.println("입력을 안하여 회원가입에 실패했습니다.");
            return false;
        } else if (checkId(id)) {  //id 중복체크하여 중복되면 true, 중복아니면 false
            System.out.println("아이디가 중복되어 회원가입에 실패했습니다.");
            return false;
        }
        return true;
    }

    boolean checkId(String id) {   //id 중복체크 메소드
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].selectID() == id) {
                return true;
            }
        }
        return false;
    }

    void registId(String id, String pwd, String name, int usertype) {  //DB에 사용자 정보등록(회원가입성공)
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].selectID() == null) {
                members[i] = new Account(id, pwd, name, usertype);
            }
        }
    }

    void login() {
        Scanner sc = new Scanner(System.in);
        int trycnt = 0;
        int state = 1; //1은 로그인 시도중, 0은 로그인 성공, -1은 계정잠김 (최초화면이동)
        do {
            ++trycnt;
            System.out.println("로그인 해주세요.");
            System.out.println("아이디");
            String interId = sc.next();
            System.out.println("비밀번호");
            String interPwd = sc.next();
            state = checkLogin(interId, interPwd);
            if (state == 0) {
                System.exit(state);
            }
            if (trycnt == 4) {
                System.out.println("해당 계정은 잠겼습니다.");
                state = -1;
            }
        } while (state == 1);
    }

    int checkLogin(String id, String pwd) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].selectID() == id && members[i].selectpwd() == pwd) {
                return 0;
            }
        }
        return 1;
    }
}


class Account {
    String id;
    String pw;
    String name;
    int usertype;   //관리자 1, 고객 0

    public Account(String id, String pw, String name, int usertype) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.usertype = usertype;
    }

    public String selectID() {
        return id;
    }

    public String selectpwd() {
        return pw;
    }

    public String selectname() {
        return name;
    }
}

class User extends Account {

    public User(String id, String pw, String name, int usertype) {
        super(id, pw, name, usertype);
    }
}

class Admin extends Account {

    public Admin(String id, String pw, String name, int usertype) {
        super(id, pw, name, usertype);
    }
}


