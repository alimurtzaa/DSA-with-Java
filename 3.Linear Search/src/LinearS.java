public class LinearS {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(linearSearch(arr, 5));

        //1. searching a char in string
        String name = "murtza";
        char target = 'u';
        System.out.println(searchChar(name, target));
        System.out.println(searchChar2(name, target));

    }
    static int linearSearch(int[] arr, int item){
        if(arr.length == 0){
            return -1;
        }
        for(int i=0; i<arr.length; i++){
            if( arr[i]==item){
                return i;
            }
        }
        return -1;  
    }


    static boolean searchChar2(String str, char target){
        if (str.isEmpty()){
            return false;
        }
        for(char ch: str.toCharArray()){
            if (ch==target)
                return true;
        }
        return false;
    }




    static int searchChar(String str, char target){
        if (str.isEmpty()){
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i)){
                return i;
            }
        }
        return -1;
    }

}