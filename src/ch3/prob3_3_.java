package ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2015. 12. 31..
 *
 * SetOfStacks, popAt 구현
 */
public class prob3_3_ {
    public static void main(String[] agrs) throws Exception {
        SetOfStacks stacks = new SetOfStacks();
        //StackAt stacks = new StackAt();
        for(int i = 0; i < 100; i++) {
            stacks.push(i);
        }

        while(stacks.isEmpty() == false) {
            System.out.println(stacks.popAt(0));
        }
    }
}

class SetOfStacks {
    List<StackWithPopAt> list;
    int numOfStacks = 0;
    int currentSize = 0;
    int size = 5;

    public SetOfStacks() {
        list = new ArrayList<StackWithPopAt>();
    }

    public void push(int item) {
        if(isEmpty() || currentSize >= size) {
            list.add(new StackWithPopAt());
            currentSize = 0;
            numOfStacks++;
        }
        list.get(numOfStacks-1).push(item);
        currentSize++;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }

        int item = list.get(numOfStacks-1).pop();
        currentSize--;
        balanceStack();

        return item;
    }

    public int popAt(int index) throws Exception {
        return shiftTo(index);
    }

    public int shiftTo(int index) throws Exception {
        if (numOfStacks < index + 1) {
            throw new Exception();
        }

        int item = list.get(index).pop();

        for(int i = index; i < numOfStacks-1; i++) {
            int shifted = list.get(i+1).popAt(0);
            list.get(i).push(shifted);
        }
        currentSize--;
        balanceStack();

        return item;
    }

    public boolean isEmpty() {
        return (numOfStacks == 0 && currentSize == 0);
    }

    public void balanceStack() {
        if (currentSize == 0) {
            list.remove(numOfStacks-1);
            numOfStacks--;

            if(numOfStacks == 0) {
                numOfStacks = 0;
                currentSize = 0;
            } else {
                currentSize = size;
            }
        }
    }
}

class StackWithPopAt {
    List<Integer> list;
    int currentIndex;

    public StackWithPopAt() {
        list = new ArrayList<Integer>();
        currentIndex = -1;
    }

    public void push(int item) {
        list.add(item);
        currentIndex++;
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        }

        int item = list.remove(currentIndex);
        currentIndex--;
        return item;
    }

    public boolean isEmpty() {
        return (currentIndex == -1);
    }

    public int popAt(int index) {
        if (currentIndex < index) {
            return 0;
        }

        int item = list.remove(index);
        currentIndex--;
        return item;
    }
}


