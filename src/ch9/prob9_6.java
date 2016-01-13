package ch9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_6 {
    public static void main(String[] args) {
        printAllParenthesis(5);
    }

    public static void printAllParenthesis(int num) {
        calc(new ArrayList<>(), num, num);
    }

    public static void calc(List<String> list, int in, int out) {
        if(in < 0 || out < 0) {
            return;
        }

        if(out < in) {
            return;
        }

        if(in == 0 && out == 0) {
            print(list);
        }

        list.add("(");
        calc(list, in - 1, out);
        list.remove(list.size() - 1);
        list.add(")");
        calc(list, in, out - 1);
        list.remove(list.size() - 1);
    }

    public static void print(List<String> list) {
        for(String s : list) {
            System.out.print(s);
        }
        System.out.println("");
    }
}
