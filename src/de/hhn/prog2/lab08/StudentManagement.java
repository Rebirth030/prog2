package de.hhn.prog2.lab08;

import java.util.Iterator;

public class StudentManagement {

    /**
     * Die main Methode erstellt ein StudentList objekt, fügt studenten hinzu und lässt diese wieder ausgeben. Als Test.
     * @param args
     */
    public static void main(String[] args) {
        StudentList studentList = new StudentList(6);
        studentList.addStudent(new Student("Hopa","popa",1));
        studentList.addStudent(new Student("Nopa","popa",2));
        studentList.addStudent(new Student("Gopa","popa",3));
        studentList.addStudent(new Student("Lopa","popa",4));
        studentList.addStudent(new Student("Topa","popa",5));
        Iterator<Student> it = studentList.
                getIterator();

        while (it.hasNext()) {
            Student student = it.next();
            System.out.println(student.getPrename() + " " + student.getLastname() + " " + student.getStudentNumber());
        }
    }
}
