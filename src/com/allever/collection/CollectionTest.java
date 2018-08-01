package com.allever.collection;

import java.util.*;

/**
 * Created by allever on 18-7-23.
 */
public class CollectionTest {
    public static void main(String[] args){

        Collection acollection;
        Iterator aiterator;

        LinkedList<String> linkedListName = new LinkedList<>();
        linkedListName.add("Allever");
        linkedListName.add("Winchen");
        linkedListName.add("Devallever");

        Iterator linkedIterator = linkedListName.iterator();
        linkedIterator.next();
        linkedIterator.next();
        linkedIterator.remove();
        for (String name: linkedListName){
            System.out.println("name = " + name);
        }

        Set<String> setName = new HashSet<>();
        setName.add("Devallever");
        setName.add("Allever");
        setName.add("Winchen");
        Iterator<String> iteratorSet = setName.iterator();

        while (iteratorSet.hasNext()){
            System.out.println("name = " + iteratorSet.next());
        }
        System.out.println();

        //TreeSet
//        TreeSet treeSet;
        SortedSet<String> treeSet = new TreeSet<>();
        treeSet.add("Devallever");
        treeSet.add("Allever");
        treeSet.add("Winchen");
        Iterator<String> iteratorTreeSet = treeSet.iterator();
        while (iteratorTreeSet.hasNext()){
            System.out.println("name = " + iteratorTreeSet.next());
        }
        System.out.println();

        iteratorTreeSet = treeSet.iterator();
        for (String name : treeSet){
            System.out.println("name = " + name);
        }

    }
}
