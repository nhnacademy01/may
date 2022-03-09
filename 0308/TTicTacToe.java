import java.util.Random;
import java.util.Scanner;

public class TTicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        int gameresult = 0;
        while(true) {
            board = userturn(board);
            if (checkgame(board, 'O')){
                System.out.println("사용자가 승리하였습니다.");
                break;
            };
            board = compturn(board);
            if (checkgame(board, 'X')){
                System.out.println("컴퓨터가 승리하였습니다.");
                break;
            };
        }
    }
    static char[][] userturn(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        char u = 'O';
        System.out.println("사용자 턴(x y):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[] usert = {row, col};
        board = tictacgame(usert, board, u);
        return board;
    }
    static char[][] compturn(char[][] board) {
        Random random = new Random();
        char c = 'X';
        System.out.println("컴퓨터 턴");
        int row = random.nextInt(3) ;
        int col = random.nextInt(3) ;
        int[] compt = {row, col};
        board = tictacgame(compt, board, c);
        return board;
    }
    static char[][] tictacgame(int[] where, char[][] board, char who){
        board[where[0]][where[1]] = who;
        board[where[0]][where[1]] = who;
        printboard(board);
        return board;
    }
    static boolean checkgame(char[][] board, char who){
        for (int i = 0; i < 3; i++) {
            if (
                    (board[i][0] == who && board[i][1] == who && board[i][2] == who)||
                    (board[0][i] == who && board[1][i] == who && board[2][i] == who)||
                    (board[0][0] == who && board[1][1] == who && board[2][2] == who)||
                    (board[2][0] == who && board[1][1] == who && board[0][2] == who)
            ){return true;}
        }
        return false;
    }
    static void printboard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");}}
    }
}
