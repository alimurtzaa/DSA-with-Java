import java.util.ArrayList;

public class ArrayRecursionQues {
    public static void main(String[] args) {

        //1. Is array sorted
        int[] arr = {0, 20, 30, 30 ,60};
        System.out.println(isSortedArr(arr, 0)); // You can also use a helper function if you don't want to pass index here

        //2. Linear search using recursion
        int[] arr2 = {0, 45, 30, 30 ,10};
        System.out.println(linearSearch(arr2, 3, 0));
        System.out.println(linearSearch2(arr2, 3, 0));

        //3. Linear search all duplicates using recursion
        int[] arr3 = {2, 4, 5, 4, 8, 2, 4, 3, 2};
        linearSearchAllDuplicates(arr3, 4, 0);
        System.out.println(list);

        System.out.println(linearSearchAllDuplicates2(arr3, new ArrayList<>(), 4, 0));

        System.out.println(linearSearchAllDuplicates3(arr3, 4, 0));

        //4. BS in RSA
        int[] arr4 = {4, 5, 6, 1, 2};
        System.out.println(searchInRSA(arr4, 1, 0, arr.length-1));

    }

    static int searchInRSA(int[] arr, int target, int s, int e){
        if (s > e) return -1;

        int m = s + (e-s)/2;
        if (arr[m] == target) return m;

        if (arr[s] <= arr[m]){
            if ( target >= arr[s] && target <= arr[m]){
                return searchInRSA(arr, target, s, m-1);
            }else{
                return searchInRSA(arr, target, m+1, e);
            }
        }

        if (target >= arr[m] && target <= arr[e]){
            return searchInRSA(arr, target, m+1, e);
        }
        return searchInRSA(arr, target, s, m-1);
    }

    //*concept
    static ArrayList<Integer> linearSearchAllDuplicates3(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();

        if (index == arr.length) return list;

        if (arr[index] == target) list.add(index);

        ArrayList<Integer> ansFromBelowFunctionCalls =  linearSearchAllDuplicates3(arr, target, ++index);
        list.addAll(ansFromBelowFunctionCalls);
        return list;
    }

    static ArrayList<Integer> linearSearchAllDuplicates2(int[] arr, ArrayList<Integer> list, int target, int index){
        if (index == arr.length) return list;

        if (arr[index] == target) list.add(index);
        return linearSearchAllDuplicates2(arr, list, target, ++index);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void linearSearchAllDuplicates(int[] arr, int target, int index){
        if (index == arr.length) return;

        if (arr[index] == target) list.add(index);
        linearSearchAllDuplicates(arr, target, ++index);
    }

    static boolean linearSearch2(int[] arr, int target, int index){
        if (index == arr.length) return false;
        return (arr[index] == target) || linearSearch2(arr, target, ++index);
    }
    static int linearSearch(int[] arr, int target, int index){
        if (index == arr.length) return -1;
        return (arr[index] == target) ? index : linearSearch(arr, target, ++index);
    }

    static boolean isSortedArr(int[] arr, int index){
        if (index >= arr.length-1) return true;
        return arr[index] <= arr[index+1] && isSortedArr(arr, index+1);
    }

}
