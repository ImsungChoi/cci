package ch7;

/**
 * Created by imsungchoi on 2016. 1. 3..
 *
 * 더하기 연산자만을 활용하여 뺄셈, 곱하기, 나누기 구현
 */
public class prob7_4_ {
    public static void main(String[] args) {
        int x = 9;
        int y = 3;

        //System.out.println(subtract(9, 100000000));
        //System.out.println(multiply(-9, -3));
        System.out.println(divide(19, 5));
    }

    public static int subtract(int x, int y) {
        return x + negate(y);
    }

    public static int negate(int x) {
        int ret = 0;
        int d = (x > 0)? 1 : -1;

        while(x != 0) {
            ret += d;
            x += d;
        }
        return ret;
    }

    public static int abs(int x) {
        if (x > 0) {
            return x;
        } else {
            return negate(x);
        }
    }

    public static int multiply(int x, int y) {
        int ret = 0;
        int absX = abs(x);
        int absY = abs(y);

        while(absY-- > 0) {
            ret += absX;
        }

        if (isNegate(x, y)) {
            return negate(ret);
        } else {
            return ret;
        }
    }

    public static int divide(int x, int y) {
        if (y == 0) {
            return 0;
        }

        int ret = 0;
        int absX = abs(x);
        int absY = abs(y);

        while(absX > 0) {
            absX += negate(absY);
            ret++;
        }

        if (isNegate(x, y)) {
            return negate(ret);
        } else {
            return ret;
        }
    }

    public static boolean isNegate(int x, int y) {
        return (x > 0 && y < 0) || (x < 0 && y > 0);
    }
}
