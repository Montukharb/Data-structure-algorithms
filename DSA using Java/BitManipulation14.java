
public class BitManipulation14 {

    public static void main(String[] args) {

        BitManipulation14 obj = new BitManipulation14();
        obj.Bin_Operator();
        obj.Bin_odd_even(5, 1);
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

    //binary exponention using recurrsion;
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
}
