package ch3;

/**
 * Created by imsungchoi on 2015. 12. 31..
 */
public class prob3_4_ {
    public static void main(String[] args) {
        topOfHanoi();
    }

    public static void topOfHanoi() {
        Tower[] towers = new Tower[3];

        for(int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for(int i = 10; i > 0; i--) {
            towers[0].add(i);
        }

        towers[0].move(10, towers[2], towers[1]);
    }
}

class Tower {
    Stack<Integer> stack;
    int index;

    public Tower(int index) {
        stack = new Stack<>();
        this.index = index;
    }

    public void add(int item) {
        if(stack.isEmpty() == false && stack.peek() < item) {
            return;
        }

        stack.push(item);
    }

    public void moveTopTo(Tower destination) {
        int item = stack.pop();
        destination.add(item);
        System.out.println(item + " is moved to Tower [" + destination.index + "]");
    }

    public void move(int num, Tower destination, Tower temp) {
        if (num <= 0) {
            return;
        }

        move(num-1, temp, destination);
        moveTopTo(destination);
        temp.move(num-1, destination, this);
    }
}