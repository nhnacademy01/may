public class Computer {
    public static void main(String[] args) {
        Cd bugsCd = new Cd("bugs");
        Cd cloudDvd = new Cd("cloud");

        Computer computer = new Computer();
        computer.play(bugsCd);
        computer.play(cloudDvd);
    }
    DvdDrive dvdDrive =  new DvdDrive();  //dvdDrive는 cdDrive를 합성.
    void play(Cd cd) {
        dvdDrive.play(cd);  //위임해준다.  이미 객체화된 dvddrive에게 위임.
    }
    void play(Dvd dvd) {
        dvdDrive.play(dvd);
    }
}

class Cd {
    String name;
    public Cd(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

}
class Dvd {
    String name;
    public Dvd(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

}

class CdDrive {
    void play(Cd cd) {
        System.out.println("CD" + cd.getName() + "을 플레이합니다.");
    }
}
class DvdDrive extends CdDrive {
    void play(Dvd dvd) {
        System.out.println("DVD" + dvd.getName() + "을 플레이합니다.");
    }
}




//컴퓨터는 dvd를 가지고 있다 (합성관계)
//dvd드라이브는 cd드라이브를 상속관계
//play(cd)를 dvddrive에서 위임하여 사용한다. (100%하는 것이 위임, 100%아니면 위임 X)