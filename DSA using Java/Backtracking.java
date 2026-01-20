public class Backtracking {
    static void main(String[] args) {
        System.out.println("Backtracking");
        Backtracking obj = new Backtracking();
        //method call's
        int[] arr = new int[5];
        obj.arrayBacktrack(arr, arr.length - 1);

        //string subsets call;
        obj.subsetsString("abc", 0, "");

        //nQueen call;
        int n = 4;
        char[][] arr_char = new char[n][n];
        int start_row = 0;
        obj.nQueensInsertion(arr_char, start_row);
        System.out.println("Total possible solution " + count);

        //grid way method call;
        int n1 = 3, m1 = 3;
        System.out.println("Total grid ways = " + obj.gridWays(0, 0, n1, m1));

        //sudoku method call;
        int[][] sudoku = {    //9 * 9 matrix box
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {4, 9, 0, 1, 5, 7, 0, 0, 2},
                {0, 0, 3, 0, 0, 4, 1, 9, 0},

                {1, 8, 5, 0, 6, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 0, 0, 6, 0},
                {9, 6, 0, 4, 0, 5, 3, 0, 0},

                {0, 3, 0, 0, 7, 2, 0, 0, 4},
                {0, 4, 9, 0, 3, 0, 0, 5, 7},
                {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        if (obj.sudokoSolver(sudoku, 0, 0)) {
            System.out.println("Solution exits");
            obj.displaySudoku(sudoku);
        } else {
            System.out.println("Solution doesn't exits");
        }

    }

    void arrayBacktrack(int[] arr, int size) {
        if (size == 0) {
            System.out.print(size + " = " + arr[size] + ",\n");
            arr[size] = arr[size] - 2;
            System.out.println("After Backtracking");
            System.out.print(size + " = " + arr[size] + ",");
            return;
        }
        arr[size] = size + 1;
        System.out.print(size + " = " + arr[size] + ","); //before backtracking till end stack build completely.
        arrayBacktrack(arr, size - 1);
        //after return statement execute backtrack starting
        arr[size] = (arr[size] - 2);
        System.out.print(size + " = " + arr[size] + ",");
    }

    //find subsets of a given string;
    void subsetsString(String str, int index, String sub) {

        if (index == str.length()) {
            System.out.println(sub + " ");
            return;
        }
        subsetsString(str, index + 1, sub + str.charAt(index));
        subsetsString(str, index + 1, sub);

    }

    //N Queens problem;
    void nQueensInsertion(char[][] arr, int n) {
        if (arr.length == 2 || arr.length == 3) {
            System.out.println("Board size must be 1 And greater than 3 \n There are no solution when board size 2*2 or 3*3");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'X';
            }
        }
        nQueenBacktracking(arr, n);
    }

    boolean isSafeQueen(char[][] arr, int row, int col) {
        //vertically top;
        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }

        //diagonal left up;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        //diagonal right up;
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static int count = 0;

    void nQueenBacktracking(char[][] arr, int row) {
        if (row == arr.length) {
            count++;
            displayQueens(arr);
            System.out.println("-------nqueens------");
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (isSafeQueen(arr, row, j)) {
                arr[row][j] = 'Q';
                nQueenBacktracking(arr, row + 1);
                arr[row][j] = 'X'; //backtracking step
            }
        }
    }

    void displayQueens(char[][] arr) {
        for (char[] chars : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }

    }

    //Grid ways (0,0) to (n-1,m-1) destination;

    int gridWays(int st_i, int st_y, int n, int m) {

        //time complexity O(2^n+m) means expo time;
        if (st_i == n - 1 || st_y == m - 1) {
            return 1; //base case final destination to final destination self ways only 1;
        } else if (st_i == n || st_y == m) {
            return 0; //out of grid range 0 way;
        }

        int W1 = gridWays(st_i + 1, st_y, n, m);
        int W2 = gridWays(st_i, st_y + 1, n, m);

        return W1 + W2;
    }

    //    ---------------------------sudoko problem --------------------!

    boolean isSafeSudoko(int[][] sudoko, int row, int col, int digit) {
        //check row duplicate;
        for (int i = 0; i < 9; i++) {
            if (sudoko[row][i] == digit) {
                return false;
            }
        }

        //check column duplicate;

        for (int j = 0; j < 9; j++) {
            if (sudoko[j][col] == digit) {
                return false;
            }
        }

        //3 * 3n Box duplicate check

        int box_row = (row / 3) * 3;
        int box_col = (col / 3) * 3;

        for (int i = box_row; i < box_row + 3; i++) {
            for (int j = box_col; j < box_col + 3; j++) {
                if (sudoko[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean sudokoSolver(int[][] sudoko, int row, int col) {
        if (row == 9) {
            return true; //base case;
        }

        int nextrow = row;
        int nextcol = col + 1;
        if (col + 1 == 9) {
            nextrow = row + 1;
            nextcol = 0;
        }

        if (sudoko[row][col] != 0) { //process only zero cells
            return sudokoSolver(sudoko, nextrow, nextcol);  //call next level
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafeSudoko(sudoko, row, col, digit)) {
                sudoko[row][col] = digit;

                if (sudokoSolver(sudoko, nextrow, nextcol)) {
                    return true; //solution possible
                }
                sudoko[row][col] = 0; //not exits any solution backtracking;
            }
        }
        return false;
    }

    void displaySudoku(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();

        }
    }
}