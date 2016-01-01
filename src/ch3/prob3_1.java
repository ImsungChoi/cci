package ch3;

import sun.reflect.annotation.ExceptionProxy;

/**
 * Created by imsungchoi on 2015. 12. 31..
 *
 * 하나의 배열로 3개의 스택을 구현
 */
public class prob3_1 {
    public static void main(String[] args) {
        StackArray stack = new StackArray();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 33; j++) {
                try {
                    stack.push(i, j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 33; j++) {
                try {
                    System.out.println(stack.pop(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class StackArray{
    private int[] array;
    private int size = 100;
    private int[] pointer = {-1, -1, -1};

    public StackArray() {
        this.array = new int[this.size];
    }

    public StackArray(int size) {
        this.size = size;
        this.array = new int[this.size];
    }

    public void push(int stackNum, int item) throws Exception {
        if (isFull(stackNum)) {
            throw new Exception("Stack ["+ stackNum + "] is full");
        }

        if (pointer[stackNum] == -1) {
            pointer[stackNum] = stackNum * (size / 3);
        } else {
            pointer[stackNum]++;
        }

        array[pointer[stackNum]] = item;
    }

    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw new Exception("Stack [" + stackNum + "] is empty");
        }

        int ret = array[pointer[stackNum]];
        pointer[stackNum]--;
        return ret;
    }

    public boolean isFull(int stackNum) {
        return (pointer[stackNum] >= (size / 3) * (stackNum + 1) - 1);
    }

    public boolean isEmpty(int stackNum) {
        return (pointer[stackNum] < stackNum * (size / 3));
    }
}