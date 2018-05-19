import by.gsu.epamlub.NumLen;
import by.gsu.epamlub.NumLenComparator;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<NumLen> list = new ArrayList<>();
        NavigableSet<NumLen> sortedSetNumLen = new TreeSet<NumLen>();
        Set<NumLen> setNumLen = new HashSet<>();


        int[] lens = new int[10_000_000];
/*

        //Равномерно распределенные с 100000 уникальных длин
        Random random = new Random();
        for (int i = 0; i < lens.length; i++ ) {
            lens[i] = 1 + random.nextInt(100000);
        }
        //Упорядочены по возрастанию
        for (int i = 0; i < lens.length; i++ ) {
            lens[i] = i + 1;
        }

        //Уполрядочены по убыванию
        for (int i = lens.length -1; i >= 0; i-- ) {
            lens[i] = i + 1;
        }

*/
        //Почти упорядоченный
        for (int i = 0; i < 9_000_000; i++ ) {
            lens[i] = i + 1;
        }
        Random random = new Random();
        for (int i = 9_000_000; i < lens.length; i++ ) {
            lens[i] = 9_000_001 + random.nextInt(1_000_000);
        }

/*
        //С уникальными num
        for (int i = 0, k = 1; i < lens.length; k++) {
            for (int j = 0; j < k && i < lens.length; j++) {
                lens[i++] = k;
            }
        }
        Integer[] lensInt = new Integer[10_000_000];
        for (int i = 0; i < lens.length; i++) {
            lensInt[i] = lens[i];
        }
        List<Integer> lst = Arrays.asList(lensInt);
        Collections.shuffle(lst);
        lensInt = lst.toArray(lensInt);

        for (int i = 0; i < lens.length; i++) {
            lens[i] = lensInt[i];
        }

*/



        //Лист
        //Заполнение
        for (int len : lens) {
            NumLen numLen = new NumLen(len);
            int index = Collections.binarySearch(list, numLen);
            if (index >= 0) {
                list.get(index).incNum();
            } else {
                list.add(-index - 1, numLen);
            }

        }

        long start = System.nanoTime();
        //Пересортировка
        Collections.sort(list, new NumLenComparator());


        long time = System.nanoTime() - start;
        System.out.println(list.size());
        System.out.println(time / 1000);



/*
        //TrySet
        long start = System.nanoTime();
        //Заполнение
        for (int len : lens) {
            NumLen numLen = new NumLen(len);
            sortedSetNumLen.add(numLen);

        }

        long time = System.nanoTime() - start;
        //Пересортировка
        List<NumLen> list1 = new ArrayList<>(sortedSetNumLen);
        Collections.sort(list1, new NumLenComparator());
        System.out.println(time / 1000);



        //HashSet
        long start = System.nanoTime();
        //Заполнение
        for (int len : lens) {
            NumLen numLen = new NumLen(len);
            setNumLen.add(numLen);

        }


        long time = System.nanoTime() - start;
        //Пересортировка
        List<NumLen> list1 = new ArrayList<>(setNumLen);
        Collections.sort(list1, new NumLenComparator());

        System.out.println(time / 1000);
*/

    }
}
