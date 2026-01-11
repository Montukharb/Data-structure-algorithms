
public class Array2D_Questions13 {

    public static void main(String[] args) {

        Array2D_Questions13 obj = new Array2D_Questions13();
        int arr[][] = new int[][]{ //even n * n matrix;
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},};
        //diagonal sum;
        int arr2[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}}; //odd n * n matrix
        System.out.println("Total Diagonal sum = " + obj.DiagonalMatrix(arr2));

        //spiral matrix;    
        obj.Spiral_Matrxi(arr2);

    }

    int DiagonalMatrix(int arr[][]) {
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

    void Spiral_Matrxi(int arr[][]) {
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
                System.err.print(arr[end_row][j] + ",");
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

}
