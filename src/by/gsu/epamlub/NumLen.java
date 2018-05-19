package by.gsu.epamlub;

public class NumLen implements Comparable<NumLen> {
    private final int len;
    private  int num;

    public NumLen(int len) {
        this.len = len;
        num = 1;
    }

    public int getLen() {
        return len;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public  void  incNum() {
        num++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final NumLen numLen = (NumLen) o;

        if (len != numLen.len) return false;
        numLen.num++;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + len;
        return result;
    }

    @Override
    public int compareTo(NumLen numLen) {
        int diff = len - numLen.len;

 /*       //Для TrySet
        if (diff == 0) {
            numLen.num++;
        }
  */
        return diff;


    }

    @Override
    public String toString() {
        return len + ";" + num;
    }
}
