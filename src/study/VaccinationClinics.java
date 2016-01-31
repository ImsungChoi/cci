package study;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by imsungchoi on 2016. 1. 29..
 */
public class VaccinationClinics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int clinic = sc.nextInt();

        int[] population = new int[city];
        for(int i = 0; i < city; i++) {
            population[i] = sc.nextInt();
        }

        Arrays.sort(population);
        System.out.println(getMaxImmunizedPeople(population, clinic));
    }

    public static int getMaxImmunizedPeople(int[] p, int c) {
        double[] n = new double[p.length];
        for(int i = 0; i < p.length; i++) {
            n[i] = p[i];
        }

        int last = n.length-1;
        int start = 0;
        int[] clinics = new int[n.length];
        for(int i = 0; i <= last; i++) {
            clinics[i] = 0;
        }

        // clinics 수와 city 수가 일치하는 경우
        if(c == 0) {
            return p[last];
        }

        // 시작 지점 찾기
        for(int i = 0; i <= last; i++) {
            if (n[last] / n[i] < c) {
                start = i;
                break;
            }

            clinics[i] = 1;
            c--;
        }

        // 인구 대비 비율 계산
        double pSum = 0.0;
        double startVal = p[start];
        for(int i = start; i <= last; i++) {
            n[i] = n[i] / startVal;
            pSum += n[i];
        }

        // 비율 대로 클리닉 분배
        double d = c / pSum;
        for(int i = start; i <= last; i++) {
            n[i] *= d;
            clinics[i] = getClinics(n[i]);
            c -= clinics[i];
        }

        // 남은 클리닉이 있을 경우 재분배
        while (c > 0) {
            int index = 0;
            double max = 0;

            for(int i = start; i <= last; i++) {
                if(n[i]-clinics[i] > max) {
                    max = n[i]-clinics[i];
                    index = i;
                }
            }

            clinics[index]++;
            c--;
        }

        // Max population 계산
        int maxPopulation = 0;
        for(int i = start; i <= last; i++) {
            int population = getPopulation(p[i], clinics[i]);
            if(maxPopulation < population) {
                maxPopulation = population;
            }
        }

        return maxPopulation;
    }

    public static int getPopulation(int p, int c) {
        return (int) Math.ceil((double) p / (double) c);
    }

    public static int getClinics(double val) {
        int floored = (int) Math.floor(val);
        if(floored == 0) {
            return 1;
        }

        return floored;
    }
}
