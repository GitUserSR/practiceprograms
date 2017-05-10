package util.Iterator;

import model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by srapolu on 5/10/17.
 */

public class TestIterator {

    public static void main(String args[]){
        Student student1 = new Student();
        student1.setName("Swathi");
        Student student2 = new Student();
        student2.setName("Sridhar");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Iterator<Student> itr = students.iterator();
        while(itr.hasNext()){
            Student student = itr.next();
            student.setAddress("Test Address");
        }

        System.out.println(students.get(1).getAddress());

    }

}



