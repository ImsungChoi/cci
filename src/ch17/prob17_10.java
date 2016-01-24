package ch17;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_10 {
    public static void main(String[] args) {
        HashMap<String, Integer> tags = new HashMap<>();
        tags.put("family", 1);
        tags.put("person", 2);
        tags.put("firstName", 3);
        tags.put("lastName", 4);
        tags.put("state", 5);

        String xml = "<family lastName=\"McDowell\" state=\"CA\"> <person firstName=\"Gayle\">Some Message</person></family>";
        System.out.println(getXMLEncoding(tags, xml));
    }

    public static String getXMLEncoding(HashMap<String, Integer> tags, String xml) {
        StringBuilder sb = new StringBuilder();

        char[] chars = xml.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (char c : chars) {
            if(c == '<') {
                if(temp.length() > 0) {
                    sb.append(" " + temp.toString());
                }
            } else if (c == '/') {
                temp.append(c);
            } else if (c == '=') {
                sb.append(" " + tags.get(temp.toString()));
                temp = new StringBuilder();
            } else if (c == '>') {
                sb.append(" " + 0);
                temp = new StringBuilder();
            } else if (c == '"') {
                if (temp.length() > 0) {
                    sb.append(" " + temp.toString());
                }
                temp = new StringBuilder();
            } else if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z') {
                temp.append(c);
            } else if (c == ' ') {
                if (temp.length() > 0) {
                    String s = temp.toString();

                    if (tags.containsKey(s)) {
                        sb.append(" " + tags.get(s));
                    } else {
                        sb.append(" " + s);
                    }
                    temp = new StringBuilder();
                }
            }
        }
        return sb.toString();
    }
}
