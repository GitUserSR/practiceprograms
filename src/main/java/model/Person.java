package model;

/**
 * Created by srapolu on 5/15/17.
 */
public class Person {

    String name;
    int age;
    String address;
    String gender;
    String notSpecifiedInConstructor;

    public void print(){

    }

    public Person(){
        System.out.println("Person.Person");
    }
    public Person(String name, int age, String address, String gender) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
