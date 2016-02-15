package study;

/**
 * Created by 1002427 on 2016. 2. 15..
 */
public class MinStack {

    public static void main(String[] args) {
        MinimumStack s = new MinimumStack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(5);
        s.push(1);

        for(int i = 0; i < 5; i++) {
            System.out.println("Min : " + s.getMin());
            System.out.println("Pop : " + s.pop());
        }
    }
}

class MinimumStack {
    int size;
    int current;
    int[] values;
    int[] minValues;

    MinimumStack() {
        current = -1;
        size = 100;
        values = new int[size];
        minValues = new int[size];
    }

    void push(int val) {
        if(current >= size-1) {
            return;
        }
        current++;
        values[current] = val;
        minValues[current] = val;

        if(current != 0) {
            if(val < minValues[current-1]) {
                minValues[current] = val;
            } else {
                minValues[current] = minValues[current-1];
            }
        }

    }

    int pop() {
        if(current < 0) {
            return -1;
        }
        int ret = values[current];
        current--;
        return ret;
    }

    int getMin() {
        if(current < 0) {
            return -1;
        }
        return minValues[current];
    }
}
