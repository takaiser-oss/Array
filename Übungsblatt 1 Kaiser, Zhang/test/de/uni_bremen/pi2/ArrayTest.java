package de.uni_bremen.pi2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class ArrayTest{

    @Test
    public void constructorTest(){
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

        Array<Integer> test1=new Array<>(0);
        assertEquals(0,test1.capacity());
        assertEquals(0,test1.size());

        Array<String> test2 =new Array<>(10);
        assertEquals(10,test2.capacity());
        assertEquals(0,test2.size());

    }

    @Test
    public void sizeTest(){
        Array<Integer>test=new Array<>(5);
        test.set(5,7);
        test.set(21,33);
        test.set(12,55);
        test.set(13,234);
        test.set(32,223);
        assertEquals(20,test.size());
    }

    @Test
    public void capacityTest(){
        Array<String>test=new Array<>(10);
        test.set(3,"one");
        test.set(14,"two");
        test.set(44,"three");
        test.set(22,"four");
        test.set(66,"five");
        assertEquals(80,test.capacity());

        Array<Integer>test1=new Array<>(0);
        test1.set(1,111);
        test1.set(4,444);
        test1.set(8,888);
        assertEquals(16,test1.capacity());
    }

public static void main(String[]args){
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