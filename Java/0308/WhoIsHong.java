public class WhoIsHong {
    public static void main(String[] args) {
        String label = "name";
        switch (label) {
            case "name":
                System.out.println("홍길동");
                break;
            case "nickname":
                System.out.println("의적");
                break;
            case "organization":
                System.out.println("활빈당");
                break;
            default:
                System.out.println("출력할 수 없는 입력값이에요.");
        }
    }
}
