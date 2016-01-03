package ch7;

/**
 * Created by imsungchoi on 2016. 1. 3..
 */
public class prob7_3 {
    public static void main(String[] args) {
        Line line1 = new Line(2, 5);
        Line line2 = new Line(3, 6);

        System.out.println(line1.isIntersect(line2.slope, line2.yIntersect));
    }
}

class Line {
    double slope;
    double yIntersect;
    double epsilon = 0.000000001;

    public Line(double slope, double yIntersect) {
        this.slope = slope;
        this.yIntersect = yIntersect;
    }

    public boolean isIntersect(double slope, double yIntersect) {
        return Math.abs(this.slope - slope) > epsilon ||
                Math.abs(this.yIntersect - yIntersect) < epsilon;
    }
}