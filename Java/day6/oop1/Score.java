package day7.oop1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Score {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/Users/minay/Desktop//아롱/NHN 아카데미/nhnacademy/아카데미 수업/score.csv"));
        //scanner 2개 생성 (한 라인씩 읽는 스캐너, useDelimiter사용해서 한 인자씩 읽는 스캐너)
        int i = 0;
        while (sc.hasNextLine()) {
            i++;
            String line = sc.nextLine();
            if (i == 1) {
                System.out.println(line + ",평균");
                continue;
            }
            // 구분자를 기준으로 하는 Scanner 생성
            Scanner rowSc = new Scanner(line).useDelimiter(",");
            int sum = 0;
            int avg ;
            int count = 0;
            while (rowSc.hasNextInt()) {
                sum += rowSc.nextInt();
                count++;
            }
            avg = sum / count;
            System.out.printf("%s,%d%n", line, avg);
        }
    }
}
