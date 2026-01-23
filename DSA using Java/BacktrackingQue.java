import java.util.Scanner;

public class BacktrackingQue {
    static int[] colmove = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] rowmove = {2, 1, -1, -2, -2, -1, 1, 2};

    static void main(String[] args) {
        System.out.println("Backtracking Question");

        BacktrackingQue obj = new BacktrackingQue();
        int[][] mazeBoard = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        int n = mazeBoard.length;
        int[][] refactor_sol = new int[n][n];
        boolean sol = obj.rat_in_maze(mazeBoard, refactor_sol, 0, 0);
        if (sol) {
            System.out.println("solution exits");
            obj.display(refactor_sol);
        } else {
            System.out.println("solution doesn't exits");
        }

        //keypad combinations call;
        char[][] charArr = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'},};
        System.out.println("Enter any number");
        String user_inp = new Scanner(System.in).next();

        obj.keypad_Combination(charArr, user_inp);

        int n1 = 8;
        int[][] chessBoard = new int[n1][n1];
        obj.knightTourInitialize(chessBoard);


    }

    boolean isSafe(int[][] arr, int row, int col, int[][] sol) {
        int n = arr.length;
        return row >= 0 && col >= 0 && row < n && col < n && arr[row][col] == 1 && sol[row][col] == 0; //path exits
    }

    boolean rat_in_maze(int[][] arr, int[][] sol, int row, int col) {
        if (row == arr.length - 1 && col == arr.length - 1 && arr[row][col] == 1) {
            sol[row][col] = 1;

            return true;
        }

        if (isSafe(arr, row, col, sol)) {
            sol[row][col] = 1;

            if (isSafe(arr, row, col + 1, sol) && rat_in_maze(arr, sol, row, col + 1)) //right;
            {
                return true;
            } else if (isSafe(arr, row + 1, col, sol) && rat_in_maze(arr, sol, row + 1, col)) //down;
            {
                return true;
            } else if (isSafe(arr, row - 1, col, sol) && rat_in_maze(arr, sol, row - 1, col)) {
                return true;
            } else if (isSafe(arr, row, col - 1, sol) && rat_in_maze(arr, sol, row, col - 1)) {
                return true;
            }

        }
        sol[row][col] = 0;

        return false;
    }

    void display(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }


    void keypad_Combination(char[][] charArr, String data) {

        if (data.isEmpty()) {
            System.out.println(" ");
            return;
        }
        int pos = 0;
        keypadSolver(pos, charArr, data, new StringBuilder());
    }

    void keypadSolver(int pos, char[][] charArr, String data, StringBuilder strbuild) {

        if (pos == data.length()) {
            System.out.println(strbuild.toString()); //print pair if equal to input;
            return;
        }

        char[] templetter = charArr[Character.getNumericValue(data.charAt(pos))]; //choose zeroth index character

        for (char c : templetter) {
            keypadSolver(pos + 1, charArr, data, new StringBuilder(strbuild).append(c));
        }

    }

    void knightTourInitialize(int[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                chessBoard[i][j] = -1;
            }
        }
        int movecount = 1;
        int row = 0;//starting position;
        int col = 0;
        chessBoard[row][col] = 0;
        if (knightTourTravel(chessBoard, movecount, row, col)) {
            System.out.println("Knight travel complete");
            displayKnight(chessBoard);
        } else {
            System.out.println("Knight travel Not complete");
        }
    }

    boolean knightTourTravel(int[][] chessBoard, int movecount, int row, int col) {
        if (movecount == (chessBoard.length * chessBoard.length)) {
            return true;
        }
        for (int i = 0; i < 8; i++) {
            int nextrow = row + rowmove[i];
            int nextcol = col + colmove[i];
            if (isSafeKnight(chessBoard, nextrow, nextcol)) {
                chessBoard[nextrow][nextcol] = movecount;

                if (knightTourTravel(chessBoard, movecount + 1, nextrow, nextcol)) {
                    return true;
                }
                chessBoard[nextrow][nextcol] = -1;
            }
        }
        return false;
    }

    boolean isSafeKnight(int[][] chessBoard, int row, int col) {
        return (row >= 0 && col >= 0 && row < chessBoard.length && col < chessBoard.length && chessBoard[row][col] == -1);
    }

    void displayKnight(int[][] chessBoard) {
        for (int[] ints : chessBoard) {
            for (int j = 0; j < chessBoard.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
