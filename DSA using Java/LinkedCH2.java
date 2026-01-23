public class LinkedCH2 {

    //call by value possible hai
    //call by reference not possible any way;


    static void main(String[] args) {
        System.out.println("hello");
        //static function, static variable

//        Testing obj = new Testing();
        Testing obj = Testing.reference;
        Testing.disp3();
        obj.disp();
        recu(5);
    }

    static void recu(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        recu(n - 1);
        System.out.print(n + " ");
    }


}

class Testing {

    public static Testing reference = new Testing();

    private Testing() {
        System.out.println("hey i am private constructor");
    }

    int z; //attribute

    static void disp3() {
        System.out.println("i am static function");
    }

    void disp() {
        System.out.println(z);
        disp2(); //non static method call here;
        disp3();

    }

    void disp2() {
        System.out.println("disp 2");
    }
}
