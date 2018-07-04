package basics.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparable and Comparator interface and their usage.
 *
 * Ref: http://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
 *
 * @author Harshit
 */
public class ComparableComparatorExample {

    public static void main(String[] args) {

        // Array or List anything can be used.
        Person[] persons = new Person[3];
        persons[0] = new Person("Harshit", 27);
        persons[1] = new Person("Naisu", 22);
        persons[2] = new Person("John", 25);

        Arrays.sort(persons);
        // Collections.sort(persons)    // incase persons is list.

        for (Person p : persons) {
            System.out.println(p.getName() + " : " + p.getAge());
        }

        System.out.println("---------------------------");

        // Comparator for comparing name.
        PersonNameComparator pComparator = new PersonNameComparator();
        Arrays.sort(persons, pComparator);  // Remember to add comparator as second parameter

        for (Person p : persons) {
            System.out.println(p.getName() + " : " + p.getAge());
        }
    }
}

/**
 * If we want to sort by only one property of a class then Comparable is a good
 * option. Remember to override compareTo() method for Comparable interface.
 *
 * @author Harshit
 */
class Person implements Comparable<Person> {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}

/**
 * Unlike Comparable, Comparator is external to the element type we are
 * comparing. It’s a separate class. We create multiple separate classes (that
 * implement Comparator) to compare by different members.
 *
 * @author Harshit
 */
class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
