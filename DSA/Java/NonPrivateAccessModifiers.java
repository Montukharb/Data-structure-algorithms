
abstract class Govt {

    final int a = 10;
    static int b = 11;

    public abstract void govtfun();

};

public class NonPrivateAccessModifiers extends Govt {

    @Override
    public void govtfun() {
        int c = a + Govt.b;
        System.out.println("govt working = " + c);

    }

    static void Greeting() {
        System.out.println("Happy new year late");
    }

    public static void main(String[] args) {
        NonPrivateAccessModifiers obj = new NonPrivateAccessModifiers();
        obj.govtfun();
        System.out.println("Working...");
        Sample.disp();
        Greeting();

        NonPrivateAccessModifiers.Greeting();
    }
}
//static example

class Sample {

    static void disp() {
        System.out.println("Hello i am static function");
    }

}
