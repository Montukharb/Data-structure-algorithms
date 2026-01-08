
public class Patterns09 {

    public static void main(String[] args) {
        {
            System.out.println("Solved pattern's problem");
            Patterns09 obj = new Patterns09();
            obj.Hollow_Rectangle(8, 8);
            obj.Inverted_Rotated(7);
            obj.Inverted_Half_Pyramid(5);
            obj.Floyd_Triangle(5);
            obj.Zero_one_Triangle(5);
            obj.Solid_Rhombus(8);
            obj.Hollow_Rhombus(8);
            obj.Butterfly_pattern(8);
            obj.Diamond_Patterns(8);

        }
    }

    void Hollow_Rectangle(int row, int col) {
        //outer loop for rows
        for (int i = 1; i <= row; i++) {
            //inner loop for columns
            for (int j = 1; j <= col; j++) {
                if (i == 1 || i == row || j == col || j == 1) //check condition first or last row or column first or last print only stars;  
                {
                    System.out.print("*");//print stars;
                } else {
                    System.out.print(" "); //print space;
                }
            }
            System.out.println(); //for next line
        }

    }

    void Inverted_Rotated(int row) {
        System.out.println("Inverted & Rotated star pattern");
        //outer loops
        for (int i = 1; i <= row; i++) {
            //print spaces
            for (int j = 1; j <= (row - i); j++) {
                System.out.print(" ");
            }
            //print stars;
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void Inverted_Half_Pyramid(int row) {
        System.out.println("Inverted Half Pyramid patter");
        //outer loop for rows;
        for (int i = 1; i <= row; i++) {
            //inner loops for columns
            for (int j = 1; j <= (row - i) + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    void Floyd_Triangle(int row) {
        int counter = 1;
        System.out.println("Floyd's Triangle");
        //outer loop for rows;
        for (int i = 1; i <= row; i++) {
            //inner loop for columns;
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    void Zero_one_Triangle(int row) {
        System.out.println("Zero and One 0 & 1 Triangle patters");
        //outer loop;
        for (int i = 1; i <= row; i++) {
            //inner loops for columns;
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");

                }
            }
            System.out.println();
        }
    }

    void Solid_Rhombus(int row) {
        System.out.println("Solid Rhombus Pattern");
        //outer loops;
        for (int i = 1; i <= row; i++) {
            //inner loops for spaces;
            for (int j = 1; j <= row - i; j++) {
                System.out.print("  ");
            }
            //inner loops for stars;
            for (int j = 1; j <= row; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void Hollow_Rhombus(int row) {
        System.out.println("Hollow Rhombus pattern");
        //outer loops for rows;
        for (int i = 1; i <= row; i++) {
            //inner loops for spaces;
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            //inner loops for stars;
            for (int j = 1; j <= row; j++) {
                if (i == 1 || i == row || j == 1 || j == row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    void Butterfly_pattern(int row) {
        System.out.println("Butterfly Patterns");
        //outer loops for upper part
        for (int i = 1; i <= row; i++) {
            //inner loop for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //inner loops for mid spaces;
            for (int j = 1; j <= 2 * (row - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // outer loop for image part
        for (int i = row; i >= 1; i--) {
            //inner loop for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //inner loops for mid spaces;
            for (int j = 1; j <= 2 * (row - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void Diamond_Patterns(int row) {
        System.out.println("Diamond Patterns");
        //outer loop upper part;
        for (int i = 1; i <= row; i++) {
            //spaces 
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //  lower pattern
        for (int i = row; i >= 1; i--) {
            //spaces 
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
