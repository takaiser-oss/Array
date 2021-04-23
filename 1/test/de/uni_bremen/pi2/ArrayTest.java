package de.uni_bremen.pi2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest{
public static void main(String[]args){
    Array<String> test =new Array<>(10);
    System.out.println(test.capacity());
    System.out.println(test.size());
    test.set(3,"abc");


}
}