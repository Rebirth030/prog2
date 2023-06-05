package de.hhn.prog2.lab08;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class StudentList implements Iterator<Student> {

    private ArrayList<Student> students;
    private int index;
    private int maxStudents;

    public StudentList(int maxStudents) {
        students = new ArrayList<>();
        this.index = 0;
        this.maxStudents = maxStudents;

    }

    public void addStudent(Student student) {
        if (students.size() >=maxStudents) {
            System.out.println("Die Liste ist voll");
        } else {
            students.add(student);
        }
    }

    public Iterator<Student> getIterator() {
        return students.iterator();
    }

    @Override
    public boolean hasNext() {
        return  (index < students.size());
    }

    @Override
    public Student next() {
        Student student = students.get(index);
        index++;
        return student;
    }
}
