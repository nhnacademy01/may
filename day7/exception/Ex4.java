package day7.exceotion;

public class Ex4 {
    static void someMethod(String[] strs) {
        int num = 0;
        try {
            num = Integer.parseInt(strs[1]);
        } catch (ArrayIndexOutOfBoundsException aie) {
            System.out.println("catch ArrayIndexOutOfBoundsException " + aie);
        } catch (NumberFormatException nfe) {
            System.out.println("catch NumberFormatException " + nfe);
        } catch (Exception e) { // !
            System.out.println("catch Exception " + e);
        }
        System.out.println("num = " + num);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"AA", "BB"};
        someMethod(strings);
    }
}
