package ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 18..
 */
public class prob10_7 {

    static int[] memo = new int[10];

    public static void main(String[] args) {
        Person[] p = new Person[6];
        p[0] = new Person(65, 100);
        p[1] = new Person(70, 10);
        p[2] = new Person(56, 90);
        p[3] = new Person(75, 90);
        p[4] = new Person(60, 95);
        p[5] = new Person(68, 30);

        for(int i = 0; i < 10; i++) {
            memo[i] = 0;
        }

        System.out.println(getMaxHeight(p));
    }

    public static int getMaxHeight(Person[] p) {
        Arrays.sort(p, new PersonComparator());

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < p.length-1; i++) {
            int height = 1;
            height += getHeight(p, i+1);

            if(max < height) {
                max = height;
            }
        }
        return max;
    }

    public static boolean isValid(Person p1, Person p2) {
        if(p1.height <= p2.height && p1.weight <= p2.height) {
            return true;
        }
        return false;
    }

    public static int getHeight(Person[] p, int index) {
        if (index >= p.length) {
            return 0;
        }

        if(memo[index] != 0) {
            return memo[index];
        }

        int max = Integer.MIN_VALUE;
        for(int i = index; i < p.length; i++) {
            int height = 1;
            if(isValid(p[index-1], p[i])) {
                height += getHeight(p, i + 1);
            }

            if(max < height) {
                max = height;
            }
        }
        memo[index] = max;
        return max;
    }
}

class Person {
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}

class PersonComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        if(p1.height <= p2.height && p1.weight <= p2.weight) {
            return -1;
        } else {
            return 1;
        }
    }
}
