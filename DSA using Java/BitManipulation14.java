import java.util.Arrays;
import java.util.Scanner;
//import java.util.Collections;

public class BitManipulation14 {

    public static void main(String[] args) {

        BitManipulation14 obj = new BitManipulation14();
        obj.Bin_Operator();
        int nu = 5;
        int nulsb = 1;
        obj.Bin_odd_even(nu, nulsb);
        int num = 64;
        int res = obj.GetithBit(num, 3);
        System.out.println("ith bit of " + num + " = " + res);
        obj.SetithBit(10, 2);
        obj.clearBit(num, 1);
        System.out.println((1 << 2));
        //clear all bits in ith bit;
        obj.clearAllBits(10, 3);
        System.out.println("Entered number " + num + " is power of 2 = " + obj.CheckNumPower(num));
        obj.countSetBits(10);
        int base = 5;
        int pow = 3;
        System.out.println("Binary exponention base " + base + " power of " + pow + " = " + obj.BinaryExponention(base, pow));
        System.out.println("using bits = " + obj.binaryexpo_bits(base, pow));
        //binary modulo exponention call;

        System.out.println("Modulo exponention = " + obj.BinaryModExpo(base + 18, pow, 30));
        System.out.println(obj.countVovel());
        System.out.println("string anagram = " + obj.anagram_String());
        obj.bit_mani_Ques();
    }

    //Binary operators
    void Bin_Operator() {
        System.err.println("Binary AND");
        int a = 5, b = 1;
        System.out.println("a & b = " + (a & b));
        System.err.println("Binary OR");
        System.out.println("a | b = " + (a | b));
        System.err.println("Binary XOR");
        System.out.println("a ^ b = " + (a ^ b));//only one operand one then res = 1;
        System.err.println("Binary One's complement");
        System.out.println("~b = " + (~b)); //-(n+1);
        System.err.println("Binary LEFT shift");
        System.out.println("a << b = " + (a << b)); // a * 2^b;
        System.err.println("Binary RIGHT shift");
        System.out.println("a >> b = " + (a >> b));// a / 2^b;
    }

    //binary odd and even using bit
    void Bin_odd_even(int num, int LSB_bitmast) {

        if ((num & LSB_bitmast) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("even");
        }
    }

    //check switch statuc ON/OFF
    int GetithBit(int num, int ith) {
        int bitmask = (1 << ith);
        // int dec = num & bitmask;
        // return dec >> ith; // if return binary bit shift to right ith bit other wise check if else;
        // return dec;  //return decimal
        SetithBit(5, 1);
        if ((num & bitmask) == 0) {
            return 0;
        } else { //THIS CASE CHECK DECIMAL VALUE NOT JUST 1 IT IS CHECK ALL 0 TO 9 AND COMBINATON OF THESE DIGITS;
            return 1;
        }
    }

    //switch ON;
    int SetithBit(int num, int ithbit) {

        int bitmask = 1 << ithbit;
        int dec = num | bitmask;
        if (dec != 0) {
            System.out.println("Set ith bit " + num + " = " + 1 + " And decimal number = " + dec);
        }
        return 0;
    }

    Integer clearBit(int num, int ithbit) {
        int bitmask = ~(1 << ithbit);
        // System.err.println("1 = "+ ~(1));
        // System.err.println("0 = "+ ~(-2));
        clearRangeBits(10, 1, 1);
        int res = num & bitmask;
        if (res != 0) {
            System.out.println("Bit set = " + 1);
        } else {

            System.out.println("can't set bit");
            return 0;
        }

        return 0;
    }

    void clearRangeBits(int num, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitmask = a | b;
        int res = num & bitmask;
        System.out.println("range based output = " + res);

    }

    void clearAllBits(int num, int ithbit) {
        int bitmask = ((~0) << ithbit);

        int result = (num & bitmask);
        System.out.println("Clear rage of bits answer = " + result);
    }

    //chek a given number is power of 2 or not;
    boolean CheckNumPower(int num) {
        int bitmask = num - 1;
        int result = num & bitmask;
        if (result == 0) {
            return true;
        } else {
            return false;
        }
    }

    //count set bits in number;
    void countSetBits(int num) {
        int orig = num;
        int count = 0;
        while (num > 0) {
            if ((num & 1) != 0) {
                count++;
            }
            num = num >> 1;
        }
        System.out.println("Entered number " + orig + " bits = " + count);
    }

    //binary exponention using recurrsion; O(n)
    int BinaryExponention(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        int result = BinaryExponention(num, pow - 1);

        return num * result;

    }

    //binary exponention using bits;
    int binaryexpo_bits(int num, int pow) {
        int ans = 1;
        while (pow > 0) {
            if ((pow & 1) != 0) {
                ans = ans * num; //calcuation using default 1 and square of number
            }
            num = num * num; //square of number
            pow = pow >> 1; //bits shifting right side for example num = 4 in binary written 100 then shift >>  1 then 010 then >>1 001 >> 000 conditoin false loop execute only 2 time third time exit
        }
        return ans;
    }

    //Modulo Exponention
    int BinaryModExpo(int num, int pow, int mod) {
        int ans = 1;
        num = num % mod;
        while (pow > 0) {
            if ((pow & 1) != 0) {
                ans = ((ans * num) % mod);
            }
            num = (num * num) % mod;
            pow = pow >> 1;
        }
        return ans;
    }

    //count how many times vowels occurred in a string;
    int countVovel() {
//        String sc = new Scanner(System.in).next(); //working no error
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text");
        String text = sc.next();
        char ch;
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;

    }

    /*anagram string
    if two strings contain the same characters but in a different order, they can be said to be anagrams. Consider race and care. In this case, race's characters can be formed into a study, or care's characters can be formed into race. Below is a java program to check if two strings are anagrams or not.
    * */
    boolean anagram_String() {
        String str = "Cdare";
        String str2 = "raDre";


        str = str.toUpperCase();
        str2 = str2.toUpperCase();

//        StringBuilder st = new StringBuilder("default string");
//        char charbuilder[] = new char[st.length()];
//        for (int i = 0; i<st.length();i++)
//        {
//            charbuilder[i] = st.charAt(i);
//        }
//        System.out.println(charbuilder);

        char str_ar[] = str.toCharArray();
        char str_ar2[] = str2.toCharArray();

        Arrays.sort(str_ar);
        Arrays.sort(str_ar2);

        int length1 = str_ar.length;
        int length2 = str_ar2.length;
        if (length2 == length1) {
            for (int i = 0; i < str_ar2.length; i++) {
                if (str_ar[i] == str_ar2[i]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    //bit manipulation questions
    void bit_mani_Ques() {
        int x = 5;
        System.out.println("x ^ x = " + (x ^ x));

        //swaping two number without using third variable;
        int a = 2;
        int b = 8;
        a = a + b;  // a = 10;
        b = a - b;  // b = 2;
        a = a - b;  // a = 8;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("using NOT Operator add 1 in b = " + (-(~b)));

        //uppercase to lower case using bit manipulation
        //ascii value A to Z = 65 to 90, a to z = 97 to 122;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' ') + "-");  //blank space ascii value = 32;
        }


    }
}
