package generics;


import model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by srapolu on 5/15/17.
 */
public class Generics {

    public static void main(String[] args) {
        ArrayList<Student> studentsList = new ArrayList<Student>();
        //studentsList.add(new Student())

    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        System.out.println("dest.size() = " + dest.size());
    }

    /**
     * printCollectionPreVersion5Release - pre-generics
     */
    void printCollectionPreVersion5Release(Collection c) {
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println("Generics.printCollection" + iterator.next());
        }
    }

    /**
     * Naive attempt. This method is much less useful than the pre-generics version. Whereas as old code
     * could be called with any kind of collection parameter, the new code only takes Collection<Object>,
     * which is not a supertype of all kinds of Collections.
     */
    void printCollectionWithGenerics(Collection<Object> c) {
        for (Object object : c) {
            System.out.println("object = " + object);
        }
    }

    void printCollectionWithGenericsWildcardType(Collection<?> c){
        for(Object object : c){
            System.out.println("object = " + object);
        }
    }

}
