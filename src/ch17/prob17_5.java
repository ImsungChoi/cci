package ch17;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_5 {
    public static void main(String[] args) {
        int[] s = {0, 2, 3, 1};
        int[] u = {2, 2, 0, 0};

        getResult(s, u);
    }

    // R = 0, Y = 1, G = 2, B = 3
    public static void getResult(int[] s, int[] u) {
        int[] sm = {0, 0, 0, 0};
        int[] um = {0, 0, 0, 0};

        int hit = 0;
        int pHit = 0;

        for(int i = 0; i < 4; i++) {
            if(s[i] == u[i]) {
                hit++;
            } else {
                if(sm[u[i]] > 0) {
                    sm[u[i]]--;
                    pHit++;
                } else if (um[s[i]] > 0) {
                    um[s[i]]--;
                    pHit++;
                } else {
                    sm[s[i]]++;
                    um[u[i]]++;
                }
            }
        }

        System.out.println(hit + " " + pHit);
    }
}
