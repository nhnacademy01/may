package day7.oop1;

import java.text.DecimalFormat;

public class DF {
    public static void main(String[] args) {
        double d = 123456.789d;
        System.out.printf("%f > #.##: %s%n", d, new DecimalFormat("#.##").format(d));
        System.out.printf("%f > 0.00: %s%n", d, new DecimalFormat("0.00").format(d));
        System.out.printf("%f > #######.####: %s%n", d, new DecimalFormat("#######.####").format(d));
        System.out.printf("%f > 0000000.0000: %s%n", d, new DecimalFormat("0000000.0000").format(d));
        System.out.printf("%f > #,###.####: %s%n", d, new DecimalFormat("#,###.####").format(d));
        System.out.printf("%f > 0,000.0000: %s%n", d, new DecimalFormat("0,000.0000").format(d));
        System.out.printf("%f > #.#: %s%n", d, new DecimalFormat("#.#").format(d)); // 반올림
        System.out.printf("%f > #: %s%n", d, new DecimalFormat("#").format(d));     // 반올림
    }
}
