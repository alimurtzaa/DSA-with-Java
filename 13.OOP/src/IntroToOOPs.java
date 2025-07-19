public class IntroToOOPs {
    public static void main(String[] args) {

        Student s1 = new Student(12, "ali", 34);
        // this keyword is replaced with s1
        System.out.println(s1.rno);
        System.out.println(s1.name);
        System.out.println(s1.marks);

        Student s2 = new Student();
        // this keyword points to Student constructor
        System.out.println(s2.name);


    }
}

class Student{
    int rno;
    String name;
    float marks;

    Student(){
        //this is how you call constructor from another constructor
        // internally it is like = new Student(13, "default person", 100f);
        this (13, "default person", 100f);
    }

    Student(int rno, String name, float marks){
        // this keyword = which object you are referring to
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }
}