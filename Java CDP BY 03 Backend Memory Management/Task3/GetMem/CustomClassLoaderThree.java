package com.epam.memory.myclassloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Julia on 10/18/14.
 */
public class CustomClassLoaderThree extends ClassLoader {

    public CustomClassLoaderThree(ClassLoader parent) {
        super(parent);
    }

    private Class<?> getClass(String name)
            throws ClassNotFoundException {
        // We are getting a name that looks like
        // javablogging.package.ClassToLoad
        // and we have to convert it into the .class file name
        // like javablogging/package/ClassToLoad.class
        String file = name.replace('.', File.separatorChar)
                + ".class";
        byte[] b = null;
        try {
            // This loads the byte code data from the file
            b = loadClassData(file);
            // defineClass is inherited from the ClassLoader class
            // and converts the byte array into a Class
            Class<?> c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Class<?> loadClass(String name)
            throws ClassNotFoundException {
        System.out.println("loading class '" + name + "'");
        if (name.startsWith("javablogging.")) {
            return getClass(name);
        }
        return super.loadClass(name);
    }

    private byte[] loadClassData(String name) throws IOException {
        // Opening the file
        InputStream stream = getClass().getClassLoader()
                .getResourceAsStream(name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        // Reading the binary data
        in.readFully(buff);
        in.close();
        return buff;
    }

}
