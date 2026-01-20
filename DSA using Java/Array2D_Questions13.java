
public class Array2D_Questions13 {

     static void main(String[] args) {

        Array2D_Questions13 obj = new Array2D_Questions13();
        int[][] arr = new int[][]{ //even n * n matrix;
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},};
        //diagonal sum;
        int[][] arr2 = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}}; //odd n * n matrix
        System.out.println("Total Diagonal sum = " + obj.DiagonalMatrix(arr2));

        //spiral matrix;    
        obj.Spiral_Matrix(arr2);

        //search in sorted matrix;
        int[][] topdownsorted = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        int key = 27;
        obj.Search_in_sorted_matrix(topdownsorted, key);
        int a = 5; //1 0 1
        int b = 4;//1 0 0 
        //output =  1 which is 4 in decimal
        System.out.println(a & b);
        // int s = -2;
        System.out.println(~(2)); //not of 10 answer = -11; how
        //apply this fourmula nomarly count ~N = -(N+1); so N = 10 = -(10 + 1) which is ~N = -11; 
        System.out.println((~0) << 4); //left shift << 2;
        System.out.println("binary right shift = " + (5 >> 2)); //left shift << 2;

        //swapping without using third variable;
        int a1 = 10;
        int a2 = 20;
        a1 = a1 + a2;  //a1 = 10 + 20 = 30
        a2 = a1 - a2;  //a2 = 30 - 20 = 10
        a1 = a1 - a2;  //a3 = 30 - 10 = 20

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("minus =  "+-(~0));

    }

    int DiagonalMatrix(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // System.out.print(arr[i][i]+" ");
            sum += arr[i][i]; //primary diagonal sum

            if (i != arr.length - i - 1) //check odd condition not calculate twice same element;
            {
                sum += arr[i][arr.length - i - 1]; //secondary diagonal sum
            }
        }

        return sum;
    }

    void Spiral_Matrix(int[][] arr) {
        int start_row = 0;
        int start_col = 0;
        int end_row = arr.length - 1;
        int end_col = arr[0].length - 1;

        while ((start_row <= end_row) && (start_col <= end_col)) {

            //top row left to right;
            for (int j = start_col; j <= end_col; j++) {
                System.out.print(arr[start_row][j] + ",");
            }

            //right row top to down;
            for (int i = start_row + 1; i <= end_row; i++) {
                System.out.print(arr[i][end_col] + ",");
            }

            //bottom row right to left;
            for (int j = end_col - 1; j >= start_col; j--) {
                if (start_row == end_row) //odd case stop dual traversing;
                {
                    break;
                }
                System.out.print(arr[end_row][j] + ",");
            }

            //left row down to towards;
            for (int i = end_row - 1; i >= start_row + 1; i--) {
                if (start_col == end_col) {
                    break;
                }
                System.out.print(arr[i][start_col] + ",");
            }
            start_row++;
            start_col++;
            end_row--;
            end_col--;

        }
    }

    //Search in Sorted Matrix;
    //time complexity = O(n+m);
    boolean Search_in_sorted_matrix(int[][] arr, int key) {
        int row = 0;
        int col = arr[0].length - 1;

        while ((row < arr.length) && (col >= 0)) {
            if (arr[row][col] == key) {
                System.out.println("Key found in index = " + "(" + row + "," + col + ")");
                return true;
            } else if (key < arr[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Not found !");
        // synchronized void print()
        // {

        // }
        // try {
        // Thread.sleep(3000);  3 second wait;
        // } catch (Exception e) {
        // }
        return false;
    }
}
