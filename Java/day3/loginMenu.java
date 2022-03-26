import java.util.Objects;
import java.util.Scanner;

public class loginMenu {
    static Scanner sc = new Scanner(System.in);
    static UserDB[] db = new UserDB[100];

    static void signup() {   //회원가입하는 메소드
        boolean checkresult;
        do {System.out.println("회원가입을 해주세요.");
            System.out.println("아이디");
            String newid = sc.next();
            System.out.println("비밀번호");
            String newpwd = sc.next();
            System.out.println("비밀번호 재입력");
            String againpwd = sc.next();
            System.out.println("이름");
            String newname = sc.next();
            checkresult = checkIdPwd(newid, newpwd, againpwd);   //id, pwd 등 에러체크해주는 메소드
            if (checkresult) {   //정상적으로 회원가입 되었을 때 true
                System.out.println("회원가입에 성공했습니다. 이전 메뉴로 돌아갑니다.");
                registId(newid, newpwd, newname);}   //회원가입 되면 id, pwd, name을 DB에 저장
        } while (!checkresult);}   //정상적으로 회원가입 될 때까지 반복

    static boolean checkIdPwd(String id, String pwd, String cpwd) {
        if (!Objects.equals(pwd, cpwd)){
            System.out.println("비밀번호가 일치하지 않아서 회원가입에 실패했습니다.");
            return false;}
        else if (id==null || pwd==null || cpwd==null) {
            System.out.println("입력을 안하여 회원가입에 실패했습니다.");
            return false;}
        else if (checkId(id)){  //id 중복체크하여 중복되면 true, 중복아니면 false
            System.out.println("아이디가 중복되어 회원가입에 실패했습니다.");
            return false;}
        return true;}

    static boolean checkId(String id) {   //id 중복체크 메소드
        for (int i = 0; i < db.length; i++) {
            if (db[i].selectID() == id) {
                return true;}
        }
        return false;}

    static void registId(String id, String pwd, String name) {  //DB에 사용자 정보등록(회원가입성공)
        for (int i = 0; i < db.length; i++) {
            if (db[i].selectID()==null) {
                db[i] = new UserDB(id, pwd, name);}
        }
    }

    static void login() {
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
            if (state==0) {System.exit(state);}
            if (trycnt==4) {state=-1;}
        } while(state==1);
    }

    static int checkLogin(String id, String pwd) {
        for (int i = 0; i < db.length; i++) {
            if (db[i].selectID()==id && db[i].selectpwd() == pwd) {return 0;}}
        return 1;
    }




    public static void main(String[] args) {
        int menuSelect;
        do{
            System.out.println("nhn academy 에 오신 것을 환영합니다. 아래에서 메뉴를 선택하세요.");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("0. 종료");
            menuSelect = sc.nextInt();
            if (menuSelect==1) {
                signup();}
            if (menuSelect==2) {
                login();}
        }while(menuSelect==0);
    }
    static class UserDB{
        String id;
        String pw;
        String name;
        public UserDB(String id, String pw, String name) {
            this.id = id;
            this.pw = pw;
            this.name = name;}
        public String selectID(){
            return id;}
        public String selectpwd(){
            return pw;}
        public String selectname() {
            return name;}
    }
}

