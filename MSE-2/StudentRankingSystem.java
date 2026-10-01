import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + marks);
    }
}

// Comparator for ranking students
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.marks != s2.marks) 
            return s2.marks - s1.marks;           // Higher marks first
        
        return s1.rollNo - s2.rollNo;        // If marks are same, smaller roll number first
    }
}


class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name); // Sort by name in ascending order
    }
}

public class StudentRankingSystem {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(103, "Monika", 85));
        students.add(new Student(101, "Nilesh", 92));
        students.add(new Student(104, "Preetam", 85));
        students.add(new Student(102, "Parth", 92));
        students.add(new Student(105, "Himanshi", 78));
        students.add(new Student(106, "Kshitij", 92));

        // Sort using Comparator
        Collections.sort(students, new StudentComparator());

        System.out.println("Student Ranking:");
        System.out.println("RollNo Name Marks");

        for (Student student : students) {
            student.display();
        }
    }
}





