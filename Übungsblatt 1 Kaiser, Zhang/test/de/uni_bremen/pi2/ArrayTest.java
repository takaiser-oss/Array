package de.uni_bremen.pi2;

import static org.junit.Assert.*;

import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class ArrayTest{

    static void printArray(Array a){
        Iterator it=a.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
public static void main(String[]args){
    Array<Integer> test1=new Array<>(0);
    System.out.println(test1.capacity());
    System.out.println(test1.size());

    Array<String> test2 =new Array<>(10);
    System.out.println(test2.capacity());
    System.out.println(test2.size());

    test1.set(3,123);
    test1.set(5,456);
    test1.set(12,789);

    test2.set(3,"abc");
    test2.set(5,"ajf");
    test2.set(12,"sue");
    test2.set(32,"kjl");
    test2.set(54,"ljd");
}
}