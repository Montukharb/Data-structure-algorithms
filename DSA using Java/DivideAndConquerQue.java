public class DivideAndConquerQue {

    static void main(String[] args) {
        System.out.println("hello word");
        DivideAndConquerQue obj = new DivideAndConquerQue();

        //sortStringArray call here;
        String[] arr = {"sun", "earth", "mars", "Mercury"};
        int st_idx = 0;
        int en_idx = arr.length - 1;
        obj.sortstringArray(arr, st_idx, en_idx);

        //display function call here;
        obj.displayarr(arr, "String Sorting using divide and Conquer method = ");
        int[] arr_int = {2,2,1,1,1,2,2};
        int en_idx2 = arr_int.length - 1;
        obj.majoryElement(arr_int,st_idx,en_idx2);
    }

    void sortstringArray(String[] arr, int st_idx, int en_idx) {
        if (st_idx >= en_idx) {
            return;  //base case ;
        }
        //divide and conquer method;
        int mid = st_idx + (en_idx - st_idx) / 2;
        //left side;
        sortstringArray(arr, st_idx, mid);

        //right side array;
        sortstringArray(arr, mid + 1, en_idx);
        partition(arr, mid, st_idx, en_idx);

    }

    void partition(String[] arr, int mid, int st_idx, int en_idx) {
        //create temp array;
        String[] temp = new String[en_idx - st_idx + 1];
        int i = st_idx;
        int j = mid + 1;
        int k = 0;

        while ((i <= mid) && (j <= en_idx)) {
            int result = arr[i].compareToIgnoreCase(arr[j]);
            if (result < 0) {
                temp[k] = arr[i]; //less than second half first element;
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //leftover elements shifting to right position;
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
        }

        //right side elements shifting to right position;

        while (j <= en_idx) {
            temp[k] = arr[j];
            j++;
        }

        //shifting temp array to original array;
        for (i = st_idx, k = 0; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    void displayarr(String[] arr, String text) {
        System.out.println(text);
        for (var i : arr) {
            System.out.print(i + " ");
        }
    }

    void majoryElement(int[] arr,int st_idx,int en_idx)
    {
        if(st_idx>=en_idx)
        {
            return;
        }

      int mid = st_idx + (en_idx - st_idx) / 2;
        System.out.println(mid);
      majoryElement(arr,st_idx,mid);
      majoryElement(arr,mid+1,en_idx);

    }

}
