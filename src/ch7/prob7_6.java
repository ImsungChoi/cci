package ch7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 3..
 */
public class prob7_6 {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
//        for (int i = 100; i < 140; i = i + 20) {
//            for (int j = 40;  j < 60; j = j + 5) {
//                points.add(new Point(i, j));
//            }
//        }

        points.add(new Point(1,3));
        points.add(new Point(66, 32));
        points.add(new Point(12, 55));
        points.add(new Point(323, 33));
        points.add(new Point(2, 6));
        points.add(new Point(3, 9));

        Line3 line = getLineWithMaximumPoints(points);
        System.out.println(line.getSlope());
        System.out.println(line.getYIntersect());
    }

    public static Line3 getLineWithMaximumPoints(List<Point> points) {
        HashMap<Double, List<Line3>> map = new HashMap<>();

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Line3 line = new Line3(points.get(i), points.get(j));
                System.out.println(line.getSlope());
                if (!map.containsKey(line.getSlope())) {
                    List<Line3> list = new ArrayList<>();
                    list.add(line);
                    map.put(line.getSlope(), list);
                } else {
                    map.get(line.getSlope()).add(line);
                }
            }
        }

        Line3 maxLine = null;
        int max = -1;
        for (double key : map.keySet()) {
            List<Line3> list = map.get(key);
            if (list.size() < max) {
                continue;
            }

            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).isEqual(list.get(j))) {
                        count++;
                    }
                }

                if (count > max) {
                    maxLine = list.get(i);
                    max = count;
                }
            }
        }

        return maxLine;
    }
}

class Line3 {
    Point start;
    Point end;
    double epsilon = 0.0000001;

    public Line3(Point p1, Point p2) {
        if (p1.isLowerThan(p2)) {
            start = p1;
            end = p2;
        } else {
            start = p2;
            end = p1;
        }
    }

    public double getSlope(){
        if(end.x == start.x) {
            return 0.0;
        }
        double slope = (end.y - start.y) / (end.x - start.x);
        int temp = (int) (slope / epsilon);
        return temp * epsilon;
    }

    public double getYIntersect() {
        return end.y - getSlope() * end.x;
    }

    public boolean isEqual(Line3 line) {
        boolean isSameSlope = isSame(getSlope(), line.getSlope());
        boolean isSameYIntersect = isSame(getYIntersect(), line.getYIntersect());

        return isSameSlope && isSameYIntersect;
    }

    public boolean isSame(double d1, double d2) {
        return Math.abs(d1 - d2) < epsilon;
    }
}
