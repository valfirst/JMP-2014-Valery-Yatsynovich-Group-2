package com.epam.memory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javassist.CannotCompileException;
import javassist.ClassPool;

/**
 * Created by julia on 10/17/14.
 */
public class HeapSpace {

    /**
     * Design and implement code that will introduce:

     1. java.lang.OutOfMemoryError: Java heap space.
     Create big objects (byte[] load = new byte[1 * 1024])
     continuously and make them stay in memory.

     * -verbose:class -XX:PermSize=2m -XX:MaxPermSize=2m  -XX:MaxPermSize=1m -Xmx10m
     */

    public static void main(String[] args) throws IOException {
        List<Object> list = new ArrayList();
        loaderHeap(list);
    }


    public static void loaderHeap(List<Object> list1){
        while(true){
            byte[] load = new byte[1 * 1024];
            list1.add(load);
        }
    }
}
