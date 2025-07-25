package generics.comparision;

public class Student implements Comparable<Student>{
    int rollno;
    float marks;

    Student (int rollno, float marks){
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int)(this.marks - o.marks);
        // if diff == 0 , both are equal
        // if diff < 0, o marks are greater
        return diff;
    }
}
