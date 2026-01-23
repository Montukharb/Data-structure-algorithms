public class Oops {
    static void main(String[] args) {
        System.out.println("Oops practice");
        Child obj = new Child();

    }
}

class Test {
//    public static Test instance = new Test("Test class argument");
    //constructors;

    protected Test(int age) {
        System.out.println("This is Protected constructor = " + age);
    }

    private Test(String name) {
        System.out.println("Private constructor = " + name);
    }

    Test() {
        this(23);

        System.out.println("Normal constructor parent");
    }

    Test(long number) {
        this();
        System.out.println("Contact number = " + number);
    }

    //method
    void disp(String str) {
        System.out.println("Normal printing function using = " + str);
    }
}

class Child extends Test {
    public Child() {
        super(8059202360L);
        System.out.println("Child class constructor");
//        Test ob = Test.instance;
//        Test ob2 = new Test();
//        ob2.disp("normal object");
//        ob.disp("with instance object");
    }
}


