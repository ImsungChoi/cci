package ch7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 3..
 */
public class Sample {
    public static void main(String[] args) {
        List<Integer> list = sieveOfEratosthenes(1000);

        for(int i : list) {
            System.out.println(i);
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime2(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> sieveOfEratosthenes(int max) {
        List<Integer> list = new ArrayList<>();
        int numOfPrime = 0;

        for(int i = 2; i <= max; i++) {
            list.add(i);
        }

        while(numOfPrime < list.size()) {
            int prime = list.get(numOfPrime);
            numOfPrime++;
            crossOff(list, prime, numOfPrime);
        }

        return list;
    }

    public static List<Integer> crossOff(List<Integer> list, int prime, int numOfPrime) {
        for(int i = numOfPrime; i < list.size(); i++) {
            if (list.get(i) % prime == 0) {
                list.remove(i);
            }
        }
        return list;
    }
}
