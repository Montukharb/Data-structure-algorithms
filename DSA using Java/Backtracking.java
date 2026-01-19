public class Backtracking {
    static void main(String[] args) {
        System.out.println("Backtracking");
        Backtracking obj = new Backtracking();
        //method call's
        int[] arr = new int[5];
        obj.arrayBacktrack(arr, arr.length - 1);

        //string subsets call;

        obj.subsetsString("abc",0,"");
    }
    void arrayBacktrack(int[] arr, int size) {
        if (size == 0) {
            System.out.print(size + " = " + arr[size] + ",\n");
            arr[size] = arr[size] - 2;
            System.out.println("After Backtracking");
            System.out.print(size + " = " + arr[size] + ",");
            return;
        }
        arr[size] = size + 1;
        System.out.print(size + " = " + arr[size] + ","); //before backtracking till end stack build completely.
        arrayBacktrack(arr, size - 1);
        //after return statement execute backtrack starting
        arr[size] = (arr[size] - 2);
        System.out.print(size + " = " + arr[size] + ",");
    }

    //find subsets of a given string;
    void subsetsString(String str,int index,String sub){
        if(index == str.length())
        {
            System.out.println(sub);
            return;
        }
        subsetsString(str,index+1,sub + str.charAt(index));
        subsetsString(str,index+1,sub);

    }

    //N Queens;

}
