import java.util.Scanner;

public class Unicode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        System.out.println("input: "+ line);
        for(int i=0; i<line.length(); i++) {
            System.out.format("\\u"+"0x%04X%n", (int)line.charAt(i));
        }


    }
}
