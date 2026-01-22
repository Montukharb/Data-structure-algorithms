import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Array_List {

    static void main(String[] args) {
        System.out.println("Array list");
        ArrayList<Integer> list = new ArrayList<>();
//        list.ensureCapacity(10);  //minimum capacity;
        list.add(20);
        list.add(201);
        list.add(202);
        list.add(203);
        list.add(30); //normally add element in next to next indexing;
        list.addFirst(100); //add element in first index using special addFirst function;
        list.addLast(822);  //add last element with special function;
        list.add(3, 689); //add element with specify index position;
        list.set(1, 1994); //set element at an index;
        int res = list.remove(5);
//        Collections.sort(list,Collections.reverseOrder());

        System.out.println(list);
        System.out.println("Deleted element = " + res);
        System.out.println("Array Size = " + list.size());
        System.out.println("Get an element = " + list.get(5));

        System.out.println("checking item 30 is available or not = " + list.contains(300));

        Solution obj = new Solution();

        int[] res_arr = obj.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.print("solution exits are these indexes = ");
        for (var a : res_arr) {
            System.out.print(a + " ");
        }
        res_arr = obj.twoSumBruteForce(new int[]{2, 7, 11, 15}, 13);
        System.out.print("\nBrute force solution exits are these indexes = ");
        for (var a : res_arr) {
            System.out.print(a + " ");
        }
        // var list_str = new ArrayList<>(); // this syntax also valid in java the var              keyword automatic guess which type of date you assign;
        // list_str.add("Montu kharb");
        // System.out.println(list_str.isEmpty());

        ArrayList<Integer> soRotated = new ArrayList<>();
        soRotated.add(11);
        soRotated.add(12);
        soRotated.add(15);   //breaking point index;
        soRotated.add(6);
        soRotated.add(7);
        soRotated.add(8);
        soRotated.add(9);
        soRotated.add(10);

        int[] resSorTwoFind = obj.sortedRotated_findTwoSum(soRotated, 19);
        System.out.print("\nSorted Rotated Find two sum solution = ");
        for (int j : resSorTwoFind) {
            System.out.print(j + ",");
        }
        ArrayList<Integer> operationList = new ArrayList<>();
        System.out.println();
        obj.reverseList(operationList);
        obj.findMaxList(operationList);
        obj.swappingList(operationList, 2, 5);
        System.out.println();
        obj.two2DMatrix();

        ArrayList<Integer> containerWater = new ArrayList<>();
        containerWater.add(1);
        containerWater.add(8);
        containerWater.add(6);
        containerWater.add(2);
        containerWater.add(5);
        containerWater.add(4);
        containerWater.add(8);
        containerWater.add(3);
        containerWater.add(7);
        System.out.println("maximum area of contain water = " + obj.maxAreaTrappedWater(containerWater));
    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left_pointer = 0;
        int right_pointer = nums.length - 1;
        Arrays.sort(nums);

        //using 2 pointer approach apply only sorted array or sorted list;
        while (left_pointer < right_pointer) {
            if ((nums[left_pointer] + nums[right_pointer]) == target) {
                return new int[]{left_pointer, right_pointer};
            } else if ((nums[left_pointer] + nums[right_pointer]) < target) {
                left_pointer++;
            } else {
                right_pointer--;
            }
        }
        return new int[]{-1, -1};
    }

    //apply brute force approach

    int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }
        }
        return new int[]{-1, -1};
    }

    int[] sortedRotated_findTwoSum(ArrayList<Integer> list, int target) {
        int breaking_point = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                breaking_point = i;
            }
        }

        int left_pointer = breaking_point + 1;
        int right_pointer = breaking_point;

        while (left_pointer != right_pointer) {
            if ((list.get(left_pointer)) + (list.get(right_pointer)) == target) {

                return new int[]{left_pointer, right_pointer};
            } else if ((list.get(left_pointer)) + (list.get(right_pointer)) < target) {

                left_pointer = (left_pointer + 1) % list.size();
            } else {
                right_pointer = (right_pointer + list.size() - 1) % list.size();
            }
        }
        return new int[]{-1, -1};
    }


    void reverseList(ArrayList<Integer> list) {
        // insertion some data;
        for (int i = 0; i < 8; i++) {
            list.add(i + 1);
        }

        //print reverse list;
        System.out.print("reverse list = ");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    void findMaxList(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println("\nmaximum arraylist item  = " + max);
    }

    void swappingList(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);

        System.out.println("After swapping list");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    void two2DMatrix() {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();


        mainList.add(list1);
        mainList.add(list2);

        for (int i = 1; i <= 5; i++) {
            list1.add(i * 2);
            list2.add(i * 3);
        }

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> index = mainList.get(i);
            for (int j = 0; j < index.size(); j++) {
                System.out.print(index.get(j) + " ");
            }
            System.out.println();
        }
    }

    int maxAreaTrappedWater(ArrayList<Integer> list) {
        int left_pointer = 0;
        int right_pointer = list.size() - 1;
        int height, width, totalWater, max = 0;

        while (left_pointer < right_pointer) {
            height = Math.min(list.get(left_pointer), list.get(right_pointer));

            width = right_pointer - left_pointer;
            totalWater = height * width;
            max = Math.max(totalWater, max);

            if (list.get(left_pointer) < list.get(right_pointer)) {
                left_pointer++;
            } else {
                right_pointer--;
            }

        }
        return max;
    }
}

