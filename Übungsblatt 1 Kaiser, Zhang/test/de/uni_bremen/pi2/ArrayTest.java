package de.uni_bremen.pi2;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayTest{

    <E>void printArray(Array<E> a){
        Iterator<E> it=a.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void ArrayTest(){
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
        //create a new Instance with the capacity 5, the beginning size is o
        Array<Integer>test=new Array<>(5);
        assertEquals(0,test.size());
        //set an element at index 5, the new size is 6
        test.set(5,7);
        assertEquals(6,test.size());
        //set an element at index 21, the new size is 22
        test.set(21,33);
        assertEquals(22,test.size());
        //set an element back to index 12, the new size is still 22
        test.set(12,55);
        assertEquals(22,test.size());
        //set an element back to index 3323, the new size is still 3324
        test.set(3323,223);
        assertEquals(3324,test.size());
    }

    @Test
    public void capacityTest(){
        //the initial capacity is 10, so the capacity is increased 20 20,40,80,160,320..
        Array<String>test=new Array<>(10);
        //set an element at 3, the capacity is still 10
        test.set(3,"one");
        assertEquals(10,test.capacity());
        //set an element at 14,the capacity is 20
        test.set(14,"two");
        assertEquals(20,test.capacity());
        //set an element at 44,the capacity is 80
        test.set(44,"three");
        assertEquals(80,test.capacity());
        //go back to set an element at 22, the capacity is still 80
        test.set(22,"four");
        assertEquals(80,test.capacity());
        //set an element at 80, the capacity is 160
        test.set(80,"five");
        assertEquals(160,test.capacity());

        //Boundary test : when capacity is 0,the next step is 1, after that the capacity increases to 2,4,8,16...
        Array<Integer>test1=new Array<>(0);
        test1.set(0,111);
        assertEquals(1,test1.capacity());
        test1.set(1,111);
        assertEquals(2,test1.capacity());
        test1.set(8,888);
        assertEquals(16,test1.capacity());
    }

    @Test
    public void setTest(){
        Array<String> test1=new Array<>(10);
        try {
            test1.set(-3,"kjf");
            fail();
        }
        catch (ArrayIndexOutOfBoundsException e){
            assertTrue(true);
        }
        catch (Exception e){
            fail();
        }

        for (int i=0;i<50;i++){
            test1.set(i,String.valueOf(i+1));
        }
        printArray(test1);
        //Boundary test : the initial capacity, set Integer(from 1 to 100) on the place with Index(from 0 to 99)
        Array<Integer>test=new Array<>(0);
        for (int i=0;i<100;i++){
            test.set(i,i+1);
        }
        printArray(test);
    }

    @Test
    public void getTest(){
        Array<String> test1=new Array<>(10);
        for (int i=0;i<50;i++){
            test1.set(i,String.valueOf(i+1));
        }
        for (int i=0;i<50;i++){
            assertEquals(String.valueOf(i+1),test1.get(i));
        }

        try {
            test1.get(-3);
            fail();
        }
        catch (ArrayIndexOutOfBoundsException e){
            assertTrue(true);
        }
        catch (Exception e){
            fail();
        }

        try {
            test1.get(55);
            fail();
        }
        catch (ArrayIndexOutOfBoundsException e){
            assertTrue(true);
        }
        catch (Exception e){
            fail();
        }

    }

    @Test
    public void testHasNext(){
        Array<Integer>test=new Array<>(0);
        Iterator it0=test.iterator();
        assertFalse(it0.hasNext());

        for (int i=0;i<100;i++){
            test.set(i,i+1);
        }
        Iterator it=test.iterator();
        for (int i=0;i<100;i++){
            assertTrue(it.hasNext());
            it.next();
        }
        assertFalse(it.hasNext());
    }

    @Test
    public void testNext(){
        Array<Integer>test=new Array<>(0);
        Iterator it0=test.iterator();
        try {
            it0.next();
            fail();
        }
        catch (NoSuchElementException e){
            assertTrue(true);
        }
        catch (Exception e){
            fail();
        }

        for (int i=0;i<100;i++){
            test.set(i,i+1);
        }
        Iterator it=test.iterator();
        Integer element=1;
        while (it.hasNext()){
            assertEquals(element,it.next());
            element++;
        }
        try {
            it.next();
            fail();
        }
        catch (NoSuchElementException e){
            assertTrue(true);
        }
        catch (Exception e){
            fail();
        }

    }

}
