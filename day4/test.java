public class test {
    public static void main(String[] args) {
        testdb[] db = new testdb[10];
//        for (int i = 0; i < db.length; i++) {
//            db[i].id="아영이";
//            db[i].pw="0819";
        db[0] = new testdb("may", "0819");
        System.out.println(db[0].selectID());
        System.out.println(db[0].selectpwd());
    }

    static class testdb{
        String id;
        String pw;
        public testdb(String id, String pw) {
            this.id = id;
            this.pw = pw;}
        public String selectID(){
            return id;}
        public String selectpwd(){
            return pw;}
    }
}

