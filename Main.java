package com.epam.memory.myclassloader;

import java.util.ArrayList;

/**
 * Created by Julia on 10/18/14.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<ClassLoader> list = new ArrayList();

        CustomClassLoader loader = new CustomClassLoader(
                IntegerPrinter.class.getClassLoader());
        CustomClassLoaderTwo loaderTwo = new CustomClassLoaderTwo(
                IntegerPrinter.class.getClassLoader());
        CustomClassLoaderThree loaderThree = new CustomClassLoaderThree(
                IntegerPrinter.class.getClassLoader());

        for(int i=0; i < 100; i++){
            list.add(loader);
            list.add(loaderTwo);
            list.add(loaderThree);
        }

    }

}
