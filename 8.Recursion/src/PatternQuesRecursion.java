public class PatternQuesRecursion {
    public static void main(String[] args) {

        //1. Triangle
        triangle(4, 1);

        //2. Reverse Triangle
        triangle2(4, 1);

    }

    static void triangle2(int r, int c){
        if (r == 0) return;
        if (r >= c) {
            triangle2(r, ++c);
            System.out.print("* ");
        }else{
            triangle2(--r, 1);
            System.out.println();
        }
    }

    static void triangle(int r, int c){
        if (r == 0) return;
        if (r >= c) {
            System.out.print("* ");
            triangle(r, ++c);
        }else{
            System.out.println();
            triangle(--r, 1);
        }
    }
}
