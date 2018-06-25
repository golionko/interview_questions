package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QArrays {

    public static void main(String [ ] args){
        System.out.println(singleNumber(new int[]{1,1,4,4,5,7,7}));
    }


    //You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
    // transpose and reverse
    public void rotate1(int[][] matrix) {
        if(matrix.length==0 || matrix.length==1)
            return;

        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }

    }


    // * Inspired by Spiral Matrix
    // * Rotate the outest layer then the inner layer
    // * kind like of recursion everytime starts from (0,0) even if it's inner layer and that's
    // * why always i=0
    // */
    public void rotate(int[][] matrix) {
        int left=0,right=matrix.length-1,up=0,down=matrix.length-1;
        while(left<right&&up<down){
            for(int i=0;i<matrix.length-1-2*left;i++){
                int temp=matrix[up][left+i];
                matrix[up][left+i]=matrix[down-i][left];
                matrix[down-i][left]=matrix[down][right-i];
                matrix[down][right-i]=matrix[up+i][right];
                matrix[up+i][right]=temp;
            }
            left++;
            right--;
            up++;
            down--;

        }
    }

    //Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    //You must do this in-place without making a copy of the array.
    //Minimize the total number of operations.
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <=1)
            return;
        int last = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[++last] = nums[i];
                if(i != last)
                    nums[i]=0;
            }
        }
    }

    //Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    //
    //Note:
    //
    //Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    public static int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((x, y) -> x^y).getAsInt();
    }

    //

    //Given an array of integers, find if the array contains any duplicates.
    //
    //Your function should return true if any value appears at least twice in the array,
    // and it should return false if every element is distinct.
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinctNums = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            if(distinctNums.contains(nums[i])){
                return true;
            }
            distinctNums.add(nums[i]);
        }
        return false;
    }

    // Given an array, rotate the array to the right by k steps, where k is non-negative
    public static void testRotate() {
        int[] nums1 = new int[]{1,2,3,4,5,6,7}; // [5,6,7,1,2,3,4]
        int[] nums2 = new int[]{1,-100,3,99}; // [3,99,-1,-100]
        rotate(nums1,3);
        rotate(nums2,2);
        printArr(nums1);
        printArr(nums2);
    }

    public static void rotate(int[] nums, int k) {
        if (k<=0) return;
        int rotations = k % nums.length;
        for(int i =0 ; i < rotations ; i++){
            rotateOnce(nums);
        }
    }

    public static void rotateOnce(int[] nums) {
        int last = nums[nums.length-1];
        for(int i = nums.length-1 ; i > 0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = last;
    }

    // Say you have an array for which the ith element is the price of a given stock on day i.
    //
    // Design an algorithm to find the maximum profit. You may complete as many
    // transactions as you like (i.e., buy one and sell one share of the stock multiple times).
    public static void testMaxProfit() {
        int[] prices1 = new int[]{7,1,5,3,6,4}; // 7
        int[] prices2 = new int[]{1,2,3,4,5}; // 4
        int[] prices3 = new int[]{7,6,4,3,1}; // 0

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length ==0 ) return  0;
        int profit = 0;
        for(int i =0 ; i < prices.length ; i++){
            if(i<prices.length-1 && prices[i]<prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

    // Given a sorted array nums, remove the duplicates in-place such that each element appear
    // only once and return the new length.
    //
    // Do not allocate extra space for another array, you must do this by modifying the input array
    // in-place with O(1) extra memory.
    private static void testRemoveDuplicates(){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        System.out.println(len);
        printArr(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int len = 0;
        int currentNum = -1;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] > currentNum){
                currentNum = nums[i];
                nums[len] = nums[i];
                len ++;
            }
        }
        return len;
    }

    private static void printArr(int[] arr){
        System.out.print("[");
        for(int i = 0 ; i < arr.length ; i++){
            if(i!=0) System.out.print(",");
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }
}
