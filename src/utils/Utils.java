package utils;

import java.util.*;

public class Utils {



    public static <E> E extraire (ArrayList <E> list){
        Random random = new Random();
        return list.remove(random.nextInt(list.size()));
    }

//    public static <E> ArrayList<E> extraire2 (ArrayList <E> list){
//        Random random = new Random();
//        return list.remove(random.nextInt(list.size()));
//    }

    public static  <E> ArrayList<E> melanger (ArrayList<E> list){
        ArrayList <E> newlist = new ArrayList<>();
        while (list.size() != 0) {
            newlist.add(extraire(list));
        }
        return newlist;
    }

    public static <E> boolean verifierMelange(ArrayList<E> list1,ArrayList<E> list2) {
        for (E e : list1) {
            if (Collections.frequency(list1, e) != Collections.frequency(list2, e)) {
                return false;
            }
        }
        return true;
    }

    public static <E> ArrayList<E> rassembler (ArrayList<E> list) {
        ArrayList <E> newlist = new ArrayList<>();
        while (list.size() != 0) {
            E e = list.get(0);
            for (int i = list.indexOf(e); i != -1; i = list.indexOf(e)) {
                newlist.add(list.remove(i));
            }
        }
        return newlist;
    }

}
