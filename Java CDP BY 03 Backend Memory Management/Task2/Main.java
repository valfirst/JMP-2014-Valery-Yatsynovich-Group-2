public class Main {

    /*
    Please add to your application code which includes passing by reference.
    Please don't add returning the reference from method.
    Make creation of the new object in method where you pass
    value by reference (the new object is for value).
    Please analyse the code structure, change the code by
    returning the value of scalar type and object type.
    Please give 256 M for tenured area of heap,
    I want to have the following heap structure:
    4-Eden,1-S0,1-S1, give 1M to thread stack.

    jva
     */
    private static int n = 10;

    public static void main(String[] args) {
         Dog dog1 = new Dog();
         dog1.setName("Barsik");
         Dog dog2 = new Dog("Murzik");
         method1(dog1, dog2);
         method3(dog2, "Murka");
    }

    /**
     *  passing by reference.
     * no return statement
     * creating of the new Obj in method
     */

    public static void method1(Dog dog1, Dog dog2){
        Dog temp = dog1;
        dog1 = dog2; // dog1 is "Murzik" now
        dog2 = temp; // dog2 is "Barsik" now
    }

    /**
     * passed by value
     * primitive value will be changed
     * @param m
     * @return scalar type
     */
    public static int method2(int m){
        return m*m;
    }

    /**
     * Object is returned after being changed
     * @param dog
     * @param name
     * @return reference
     */
    public static Dog method3(Dog dog, String name){
        dog.setName(name);
        dog = new Dog("NeverWillBe");
        return dog;
    }

}
