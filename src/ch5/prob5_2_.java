package ch5;

/**
 * Created by imsungchoi on 2016. 1. 2..
 *
 * 1~0 사이의 double 값의 소수점 이하 부분을 출력
 */
public class prob5_2_ {
    public static void main(String[] args) {
        double value = 0.01;
        System.out.println(convertDoubleToString(value));
    }

    public static String convertDoubleToString(double num) {
        if (num >= 1 || num < 0) {
            return "Error";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while(num > 0) {
            if (sb.length() >= 32) {
                return "Error";
            }

            double temp = num * 2;
            if (temp >= 1) {
                sb.append(1);
                num = temp - 1;
            } else {
                sb.append(0);
                num = temp;
            }
        }

        return sb.toString();
    }
}
