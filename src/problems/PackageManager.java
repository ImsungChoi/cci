package problems;

import java.util.*;

/**
 * Created by 1002427 on 2016. 1. 11..
 */
public class PackageManager {

    public static void main(String[] args) {
        Package package1 = new Package("package1");
        Package package2 = new Package("package2");
        Package package3 = new Package("package3");
        Package package4 = new Package("package4");
        Package package5 = new Package("package5");
        package1.dependency.add(package2);
        package1.dependency.add(package3);
        package2.dependency.add(package3);
        package2.dependency.add(package4);
        package3.dependency.add(package4);

        Set<Package> set = new HashSet<>();
        set.add(package1);
        set.add(package2);
        set.add(package3);
        set.add(package4);
        set.add(package5);

        Packages packageManager = new Packages(set);
        for (Package p : packageManager.getDependencySet(package2)) {
            System.out.print(p.name + " ");
        }
        System.out.println();
    }

}

class Packages {
    Set<Package> packages;
    //SortedSet<Package> topologicalSet;
    int time;

    public Packages() {

    }

    public Packages(Set<Package> packages) {
        this.packages = packages;
        //this.topologicalSet = new TreeSet<>();
        getTopoligicalSet();
    }

    public void getTopoligicalSet() {
        for(Package p : packages) {
            p.isVisited = false;
        }
        time = 0;
        for(Package p : packages) {
            if (p.isVisited == false) {
                dfsVigit(p);
            }
        }
    }

    public void dfsVigit(Package p) {
        p.isVisited = true;

        for(Package dependent : p.dependency) {
            if(dependent.isVisited == false) {
                dfsVigit(dependent);
            }
        }
        time++;
        p.order = time;
        //topologicalSet.add(p);
    }

    public Set<Package> getDependencySet (Package p) {
        for (Package pack : packages) {
            pack.isVisited = false;
        }
        SortedSet<Package> dependencySet = new TreeSet<>();
        Queue<Package> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()) {
            Package dequeued = queue.poll();
            dependencySet.add(dequeued);
            for(Package adj : dequeued.dependency) {
                if (adj.isVisited == false) {
                    adj.isVisited = true;
                    queue.add(adj);
                }
            }
        }
        return dependencySet;
    }
}

class Package implements Comparable<Package> {
    String name;
    int order;
    boolean isVisited;
    Set<Package> dependency;

    public Package() {

    }

    public Package(String name) {
        this.name = name;
        this.dependency = new HashSet<>();
        this.order = 0;
        this.isVisited = false;
    }

    public int compareTo(Package p) {
        return this.order - p.order;
    }
}