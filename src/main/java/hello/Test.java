package hello;

import java.util.Arrays;
import java.util.Random;
import java.util.RandomAccess;

public class Test {
    public static void main(String[] args) {
//        String s = new String("kvill");
//        String s0= new String("kvill");
//        String s1= new String("kvill");
//        s1 = s1.intern();
//        String s2="kv" + "ill";
//        System.out.println(s == s.intern());
//        System.out.println(s==s0);
//        System.out.println(s==s1);
        long now = System.currentTimeMillis();


            new Thread(Test::testMethod).start();
            new Thread(Test::testMethod).start();
            new Thread(Test::testMethod).start();

        testMethod();
        long now1 = System.currentTimeMillis();
        System.out.println(now1-now);

    }


    public static int[] quickSort(int[] array, int left, int right) {
        if (left >right){
            return null;
        }
        int i = left;
        int j = right;
        int temp = array[left];
        while (i != j) {
            while (i < j && array[j] >= temp) {
                j--;
            }
            while (i < j && array[i] <= temp) {
                i++;
            }
            TypeStructureTest.swap(array, i, j);
        }
        TypeStructureTest.swap(array,left,i);
        quickSort(array,left,i-1);
        quickSort(array,i+1,right);
        return array;
    }

    public static int[] getRandomArray(int bound,int size){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    public static void testMethod(){
        int[] testArray = getRandomArray(100,1000000);
        quickSort(testArray,0,9);
    }

}
