package util.String;

import model.Person;

import java.util.Date;

/**
 * Created by srapolu on 9/16/15.
 */
public class Test {
    public static void main(String args[]){
        String Str = new String("Accela Custom Portlet-P-14fd7702729-10005");

        System.out.print("Return Value :" );
        System.out.println(Str.startsWith("Accela Custom Portlet") );
        Object str = null;
        System.out.print((Date)str);


        Object personObject = new Person("name", 10, "address", "gender");
        Person person = (Person) personObject;

    }
}


