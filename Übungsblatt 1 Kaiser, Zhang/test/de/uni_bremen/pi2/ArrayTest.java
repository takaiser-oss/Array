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

    //test1.set(3,123);
    //test1.set(5,456);
    //test1.set(12,789);

    test2.set(3,"abc");//0
    test2.set(5,"ajf");//1
    test2.set(12,"sue");//2
    test2.set(32,"kjl");//3
    test2.set(65,"ljd");//4
    System.out.println(test2.capacity());
    System.out.println(test2.size());
    //System.out.println(test2.get(3));
    //System.out.println(test2.get(4));
    //System.out.println(test2.get(5));
    //System.out.println(test2.get(32));

    printArray(test2);



}
}