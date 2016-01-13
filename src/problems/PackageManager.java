package problems;

import java.util.*;

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
        for (Package p : packageManager.getDependencySet(package1)) {
            System.out.print(p.name + " ");
        }
        System.out.println();
    }

}

class Packages {
    Set<Package> packages;

    public Packages() {

    }

    public Packages(Set<Package> packages) {
        this.packages = packages;
    }

    public void dfsVigit(List<Package> packages, Package p) {
        p.isVisited = true;

        for(Package dependent : p.dependency) {
            if(dependent.isVisited == false) {
                dfsVigit(packages, dependent);
            }
        }
        packages.add(p);
    }

    public List<Package> getDependencySet (Package p) {
        for (Package pck : packages) {
            pck.isVisited = false;
        }

        List<Package> ret = new ArrayList<>();
        dfsVigit(ret, p);
        return ret;
    }
}

class Package {
    String name;
    boolean isVisited;
    Set<Package> dependency;

    public Package() {

    }

    public Package(String name) {
        this.name = name;
        this.dependency = new HashSet<>();
        this.isVisited = false;
    }
}