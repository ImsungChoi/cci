package ch7;

/**
 * Created by imsungchoi on 2016. 1. 3..
 */
public class prob7_5 {
    public static void main(String[] args) {
        Square s1 = new Square(new Point(3, 5), new Point(3, 3), new Point(5, 5), new Point(5, 3));
        Square s2 = new Square(new Point(1, 3), new Point(1, 1), new Point(3, 3), new Point(3, 1));
        Line2 l = s1.cut(s2);
        System.out.println(l.start.x);
        System.out.println(l.start.y);
        System.out.println(l.end.x);
        System.out.println(l.end.y);

    }
}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isLowerThan(Point p) {
        if (x < p.x || x == p.x && y < p.y) {
            return true;
        } else {
            return false;
        }
    }
}

class Square {
    Line2 left;
    Line2 right;
    Line2 top;
    Line2 bottom;

    public Square(Point leftTop, Point leftBottom, Point rightTop, Point rightBottom) {
        this.left = new Line2(leftBottom, leftTop);
        this.right = new Line2(rightBottom, rightTop);
        this.top = new Line2(leftTop, rightTop);
        this.bottom = new Line2(leftBottom, rightBottom);
    }

    public Point getMiddle() {
        return new Point( (left.start.x + right.start.x) / 2, (top.start.y + bottom.start.y) / 2);
    }

    public Line2 cut(Square other) {
        Line2 midLine = new Line2(getMiddle(), other.getMiddle());
        Point s1 = null;
        Point s2 = null;

        if (left.start.isLowerThan(other.left.start)) {
            s1 = getIntesectPoint(midLine, left, bottom);
            s2 = getIntesectPoint(midLine, other.right, other.top);
        } else {
            s1 = getIntesectPoint(midLine, right, top);
            s2 = getIntesectPoint(midLine, other.left, other.bottom);
        }
        return new Line2(s1, s2);
    }

    public Point getIntesectPoint(Line2 base, Line2 leftOrRight, Line2 topOrBottom) {
        Point p = null;

        if (base.getSlope() > 1) {
            return base.intersectPoint(topOrBottom);
        } else {
            return base.intersectPoint(leftOrRight);
        }
    }

}

class Line2 {
    Point start;
    Point end;

    public Line2(Point p1, Point p2) {
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

        return (end.y - start.y) / (end.x - start.x);
    }

    public double getYIntersect() {
        return end.y - getSlope() * end.x;
    }

    public Point intersectPoint(Line2 other) {
        Point p;
        if (other.start.x == other.end.x) {
            p = new Point(other.start.x, getSlope() * other.start.x + getYIntersect());
        } else {
            p = new Point((other.start.y - getYIntersect()) / getSlope(), other.start.y);
        }
        return p;
    }
}