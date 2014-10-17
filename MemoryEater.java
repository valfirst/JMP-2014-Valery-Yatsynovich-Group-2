package MemoryManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Julia_Soldatenko
 * Date: 10/15/14
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class MemoryEater {
    public static void main(String[] args) {
        List v = new ArrayList();
        while (true) {
            v = new ArrayList();
            byte b[] = new byte[1048576];
            v.add(b);
            Runtime rt = Runtime.getRuntime();

            System.out.println("free memory: " + rt.freeMemory());
            /*try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }*/
        }
    }
}
