package ch3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by imsungchoi on 2015. 12. 31..
 *
 * 2개의 타입을 저장하고, 각각을 선택해서 pop할 수 있는 Stack 구현 (LinkedList 사용가능)
 */
public class prob3_7 {
    public static void main(String[] args) {
        AnimalQueue queue = new AnimalQueue();
        for(int i = 0; i < 10; i++) {
            Animal animal = (i%2 == 0)? new Dog() : new Cat();
            queue.enqueue(animal);
        }

        while(true) {
            Animal cat = queue.dequeueCat();
            if(cat == null) {
                break;
            }

            System.out.println(cat.type);
        }

        while(queue.isEmpty() == false) {
            System.out.println(queue.dequeueAny().type);
        }

    }
}

class AnimalQueue {
    List<Animal> list = new LinkedList<>();

    public void enqueue(Animal animal) {
        list.add(animal);
    }

    public Animal dequeueAny() {
        if (list.isEmpty()) {
            return null;
        }

        return list.remove(list.size()-1);
    }

    public Animal dequeueDog() {
        if (list.isEmpty()) {
            return null;
        }

        for(int i = list.size()-1; i >= 0; i--) {
            if(list.get(i).type.equals("Dog")) {
                return list.remove(i);
            }
        }

        return null;
    }

    public Animal dequeueCat() {
        if (list.isEmpty()) {
            return null;
        }

        for(int i = list.size()-1; i >= 0; i--) {
            if(list.get(i).type.equals("Cat")) {
                return list.remove(i);
            }
        }

        return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

abstract class Animal {
    String type;
}

class Dog extends Animal {
    public Dog() {
        this.type = "Dog";
    }
}

class Cat extends Animal {
    public Cat() {
        this.type = "Cat";
    }
}