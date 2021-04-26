package de.uni_bremen.pi2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class ArrayTest{

    static <E>void printArray(Array<E> a){
        Iterator it=a.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }


public static void main(String[]args){
    //Test: constructor, methode size() and capacity()
    //Test: when capacity is negative, IllegalArgumentException will be thrown


    try {
        Array<Integer> test0=new Array<>(-5);
        fail();//no exception is thrown
    }
    catch (IllegalArgumentException e){
        assertTrue(true);//Excepted exception is thrown
    }
     catch (Exception e){
         fail();//did not get the excepted exception
     }


    //Boundary test : when capacity is 0
    Array<Integer> test1=new Array<>(0);
    System.out.println(test1.capacity());
    assertEquals(0,test1.capacity());
    System.out.println(test1.size());
    assertEquals(0,test1.size());
    test1.set(3,123);
    test1.set(5,456);
    test1.set(12,789);

    Array<String> test2 =new Array<>(10);
    System.out.println(test2.capacity());
    System.out.println(test2.size());
    //test methode set()
    assertEquals(10,test2.capacity());
    assertEquals(0,test2.size());

    test2.set(3,"abc");//0
    test2.set(5,"ajf");//1
    assertEquals(10,test2.capacity());
    assertEquals(2,test2.size());
    test2.set(12,"sue");//2
    assertEquals(20,test2.capacity());
    assertEquals(3,test2.size());
    test2.set(32,"kjl");//3
    assertEquals(40,test2.capacity());
    assertEquals(4,test2.size());
    test2.set(65,"ljd");//4
    assertEquals(80,test2.capacity());
    assertEquals(5,test2.size());
    System.out.println(test2.capacity());
    System.out.println(test2.size());
    //test when Index is negative
    try {
        test2.set(-3,"kjf");
        fail();
    }
    catch (ArrayIndexOutOfBoundsException e){
        assertTrue(true);
    }
    catch (Exception e){
        fail();
    }


    //System.out.println(test2.get(3));
    //System.out.println(test2.get(4));
    //System.out.println(test2.get(5));
    //System.out.println(test2.get(32));




}
}