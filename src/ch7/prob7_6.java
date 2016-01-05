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
        Line3 maxLine = null;
        int max = 0;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Line3 line = new Line3(points.get(i), points.get(j));
                List<Line3> list;
                if (!map.containsKey(line.getSlope())) {
                    list = new ArrayList<>();
                    list.add(line);
                    map.put(line.getSlope(), list);
                } else {
                    list = map.get(line.getSlope());
                    list.add(line);
                }

                int count = checkSameLines(list, line);
                if (max < count) {
                    maxLine = line;
                    max = count;
                }
            }
        }

        return maxLine;
    }

    public static int checkSameLines(List<Line3> list, Line3 line) {
        int count = 0;
        for (Line3 l : list) {
            if (line.isEqual(l)) {
                count++;
            }
        }
        return count;
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
