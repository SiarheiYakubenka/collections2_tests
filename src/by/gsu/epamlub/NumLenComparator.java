package by.gsu.epamlub;

import java.util.Comparator;

public class NumLenComparator implements Comparator<NumLen> {

    @Override
    public int compare(NumLen o1, NumLen o2) {
        return o2.getNum() - o1.getNum();
    }
}
