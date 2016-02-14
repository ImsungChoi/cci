package study;

/**
 * Created by 1002427 on 2016. 2. 12..
 */
public class BarRain {
    public static void main(String[] args) {
        int[] bars = {4, 2, 1, 3, 4, 2, 3, 1};
        System.out.println(calcRain(bars));
    }

    public static int calcRain(int[] bars) {
        int sum = 0;
        int point = 0;

        for(int i = 1; i < bars.length; i++) {
            if(i == bars.length-1 || (bars[i-1] < bars[i] && bars[i] > bars[i+1])) {
                int min = Math.min(bars[point], bars[i]);

                for(int j = i - 1; j > point; j--) {
                    int rain = min - bars[j];
                    if(rain > 0) {
                        sum += rain;
                    }
                }

                point = i;
            }
        }

        return sum;
    }
}
