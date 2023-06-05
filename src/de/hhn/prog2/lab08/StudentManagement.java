package de.hhn.prog2.lab08;

import java.util.Iterator;

public class StudentManagement {
    public static void main(String[] args) {
        StudentList studentList = new StudentList(6);
        for (int i = 0; i<5; i++){
            studentList.addStudent(new Student());
        }
        Iterator<Student> it = studentList.
                getIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
