package day11.PRGGAME;

import java.util.Scanner;

public class UserGameStory {
    private String id;
    private int stageNumber = 0;

    public UserGameStory(String id) {
        this.id = id;
    }

    public String stage() {
        String selectContinue = null;
        switch (this.stageNumber) {
            case 0: selectContinue = stageMain();
                break;
            case 1: selectContinue = stageOne();
                break;
            case 2: selectContinue = stageTwo();
                break;
            case 3: selectContinue = stageFinal();
                break;
        }
        stageNumber ++;
        return selectContinue;
    }

    private String stageMain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("                 ___====-_  _-====___\n" +
                "           _--^^^#####//      \\\\#####^^^--_\n" +
                "        _-^##########// (    ) \\\\##########^-_\n" +
                "       -############//  |\\^^/|  \\\\############-\n" +
                "     _/############//   (@::@)   \\\\############\\_\n" +
                "    /#############((     \\\\//     ))#############\\\n" +
                "   -###############\\\\    (oo)    //###############-\n" +
                "  -#################\\\\  / VV \\  //#################-\n" +
                " -###################\\\\/      \\//###################-\n" +
                "_#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" +
                "|/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" +
                "`  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" +
                "   `   `  `      `   / | |  | | \\   '      '  '   '\n" +
                "                    (  | |  | |  )\n" +
                "                   __\\ | |  | | /__\n" +
                "                  (vvv(VVV)(VVV)vvv)");
        System.out.println("-- 계속 할려면 엔터를 입력해주세요. --");
        scanner.nextLine();

        System.out.println("용사 " + this.id + "님 던전에 있는 드래곤을 물리쳐주세요!!!\n" +
                "1. 던전으로 들어간다.\n" +
                "2. 도망간다. (게임 종료)");
        String result = scanner.nextLine();

        return result;
    }

    private String stageOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("야생의 슬라임이 나타났다.\n" +
                "1. 공격\n" +
                "2. 도망간다. (게임 종료)");
        String result = scanner.nextLine();
        return result;
    }


    private String stageTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("야생의 오크가 나타났다.\n" +
                "1. 공격\n" +
                "2. 도망간다. (게임 종료)");
        String result = scanner.nextLine();
        return result;
    }

    private String stageFinal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*보스* 드래곤이 나타났다.\n" +
                "1. 공격\n" +
                "2. 도망간다. (게임 종료)");
        String result = scanner.nextLine();
        return result;
    }
}
