import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Hey this is Tic Tae Toe.");
        System.out.println("There are two players x and o, just enter the coordinate to put your x or o.");
        System.out.println("_____________________________________________________________________________________________________");
        char [][] board  = new char[3][3];
        for(int row = 0; row< board.length;row++){
            for(int col = 0; col< board[row].length; col++){
                board[row][col] =' ';
            }
        }
        char player = 'x';
        boolean gameover = false;
        Scanner scanner = new Scanner(System.in);
        while(!gameover){
            printboard(board);
            System.out.println("Player " + player + " enter:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            if(board[row][col] == ' '){
                board[row][col] = player;
                gameover = havewon(board,player);
                if(gameover){
                    System.out.println("Player " + player + " has won:");
                }
                else{
                   player = (player== 'x')? 'o': 'x';
                }
            }
            else{
                System.out.println("Invalid Move. Try again");
            }
        }
        printboard(board);
    }
    public static boolean havewon(char[][] board, char player){
        for(int row = 0; row< board.length;row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        for(int col= 0; col< board[0].length;col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player ){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player ){
            return true;
        }
       return false;

    }
    public static void printboard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
