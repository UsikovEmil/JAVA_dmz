package DZ06;

import java.util.ArrayList;

public class mainHashSet {
    private ArrayList<Integer> set;

    public mainHashSet() {
        set = new ArrayList<>();
    }

    public void add(Integer o) {
        if (!set.contains(o)) {
            set.add(o);
        }
    }

    public Integer get(int index) {
        return set.get(index);
    }

    @Override
    public String toString() {
        return set.toString();
    }

    public static void main(String[] args) {
        mainHashSet mySet = new mainHashSet();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(2);

        System.out.println(mySet);
        System.out.println(mySet.get(1));
    }
}