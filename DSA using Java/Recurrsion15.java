public class Recurrsion15 {
    public static void main(String[] args) {
        System.out.println("Recurrsion");
        Recurrsion15 obj = new Recurrsion15();
        obj.decrese_num(10);
        System.out.println("Increasing order");
        obj.increasing_num(10, 1);
    }

    //decreasing number n to 1
    int decrese_num(int n) {
        if (n == 0) {
            return 1;
        }
        System.out.println(n);
        return decrese_num(n - 1);
    }

    //increasing number 1 to n
    void increasing_num(int n, int si) {
        if (si > n) {
            return;
        }
        System.out.println(si);
         increasing_num(n, si + 1);
//        System.out.println(si);

    }
}

