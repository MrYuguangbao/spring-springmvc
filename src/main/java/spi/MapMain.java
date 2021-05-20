package spi;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * @author admin
 * @date 2020/4/9 14:45
 */
public class MapMain {

    public static void main(String[] args) {
        List<String> collection = new LinkedList<>();
        for (int l = 0; l < 10; l++) {
            collection.add("key-"+l);
        }

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            collection.remove(next);
            System.out.println(next);
        }


    }


}
