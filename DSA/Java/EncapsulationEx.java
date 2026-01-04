// import java.util.Scanner;
// import java.util.*;

class Essenstial {

    private String secrectkey = "lk(7HJf$@dsf7785)";
    private String username = "John Don";

    //make two method get and set with public access modifers
    public String getData() {
        return "Mr." + username;
    }

    ;

    public void setData(String secrectkey, String userName) {
        this.secrectkey = secrectkey;
        this.username = userName;
    }

};

public class EncapsulationEx {

    public static void main(String[] args) {

        System.out.println("Working..");
        Essenstial obj = new Essenstial();

        System.out.println("Secrect key = " + obj.getData());
        obj.setData("(jho##%4589&><?)", "Vishal Sharma");
        System.out.println("Secrect key = " + obj.getData());
    }
}
