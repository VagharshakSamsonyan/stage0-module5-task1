package com.epam.mjc.stage0;



/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String[] seasons = new String[4];
        seasons[0] = "winter";
        seasons[1] = "spring";
        seasons[2] = "summer";
        seasons[3] = "autumn";
        return seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int [] arr = new int[length];

        for (int i = 1; i <= length; i++) {
            arr[i - 1] = i;
        }
        return arr;

    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                res = i;
                count++;
                break;
            }
        }
        if(count ==0){res=-1;
        }
        return res;
    }


    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] newArray = new String[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            newArray[j] = arr[i];
            j++;
        }
        return newArray;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int newArrLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                newArrLength++;
            }
        }
        int j = 0;
        int [] newArr = new int[newArrLength];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                newArr[j] = arr[i];
                j++;
            }
        }
        return  newArr;

    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        int check = 0;

        do {
            check = 0;
            for(int i = 1; i < arr.length; i++) {
                if( arr[i].length < arr[i - 1].length ) {
                    int swap[] = arr[i].clone();
                    arr[i] =  arr[i - 1].clone();
                    arr[i - 1] = swap.clone();
                }
            }
            for(int i = 1; i < arr.length; i++) {
                if( arr[i].length < arr[i - 1].length ) {
                    check++;
                }
            }
        } while (check > 0);
        for(int a = 0; a < arr.length; a++ ) {
            do {
                check = 0;
                for(int b = 1; b < arr[a].length; b++) {
                    if( arr[a][b] < arr[a][b - 1] ) {
                        int swap = arr[a][b];
                        arr[a][b] = arr[a][b - 1];
                        arr[a][b - 1] = swap;
                    }
                }
                for(int b = 1; b < arr[a].length; b++) {
                    if( arr[a][b] < arr[a][b - 1] ) {
                        check++;
                    }
                }
            } while(check > 0);
        }
        return arr;
    }
}