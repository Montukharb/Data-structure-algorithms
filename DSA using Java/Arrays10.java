public class Arrays10{
    public static void main(String[] args) {
        System.out.println("Arrays sorting");
        Arrays10 obj = new Arrays10();
       int res =  obj.Linear_search(new int[]{10,20,30,40,5,8,46,96,6}, 6);
       if(res != -1)
       {
        System.out.println("Key found at index = " + res);
       }
       else
       {
        System.out.println("Not found");
       }

    }
    int Linear_search(int arr[],int key)
    {
        System.out.println("Linear Search find the key");
        for(int i = 0;i<arr.length;i++){
            if(key==arr[i])
            return i+1;  
        }
      return -1;
    };
}