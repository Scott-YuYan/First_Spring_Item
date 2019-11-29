package hello;

import java.util.Arrays;
import java.util.Random;

public class TypeStructureTest {

    public static void main(String[] args) {
        int[] array = getRandomList(9);
        int[] searchArray = new int[]{1, 2, 3, 4, 12, 16, 17, 25,27};
        System.out.println("冒泡排序：" + Arrays.toString(popSort(array)));
        System.out.println("快速排序：" + Arrays.toString(quickSort(array, 0, array.length - 1)));
        System.out.println("插入排序：" + Arrays.toString(insertSort(array)));
        System.out.println("选择排序：" + Arrays.toString(selectSort(array)));
        System.out.println(binarySearchWithOutRecursive(searchArray,12));
        System.out.println(binarySearchWithRecursive(searchArray,12,0,array.length-1));
    }

    public static int[] getRandomList(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public static int[] selectSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int index = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            swap(array, i, index);
        }
        return array;
    }

    public static int[] insertSort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int temp = array[i];
            for (int j = i - 1; j >= 0 && array[j] < temp; j--) {
                array[j + 1] = array[j];
                array[j] = temp;
            }
        }
        return array;
    }

    public static int[] quickSort(int[] array, int left, int right) {
        if (left > right || left < 0) {
            return null;
        }

        int i = left;
        int j = right;
        //将最左边的数定义为基准轴
        int basisAxis = array[i];
        //当两个指针不相遇的时候进行检索
        while (i != j) {

            //先从右往左检索比基准轴小的数
            while (array[j] >= basisAxis && i < j) {
                j--;
            }
            //从左往右找一个的大于基准轴的数
            while (array[i] <= basisAxis && i < j) {
                i++;
            }
            swap(array, i, j);
        }
        //两指针相遇，则交换基准数与相遇位置处的元素交换数值
        swap(array, left, i);
        //基准数字归为后，排左边的数
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
        return array;
    }

    public static int[] popSort(int[] array) {
        int arraySize = array.length;
        if (arraySize == 0) {
            return null;
        }
        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if (array[j] > array[i]) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    public static void swap(int[] array, int index1, int index2) {
        if (index1 < 0 || index2 < 0) {
            throw new RuntimeException("数组下标不能为负数");
        }

        if (array == null) {
            throw new RuntimeException("链表为空");
        }
        int i = array[index1];
        int j = array[index2];
        array[index2] = i;
        array[index1] = j;
    }

    public static int binarySearchWithOutRecursive(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int middle = (low + high) / 2;
            if (array[middle] == target){
                return middle;
            }
            if (array[middle] < target) {
                low = middle + 1;
            }
            if (array[middle] > target) {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static int binarySearchWithRecursive(int[] array , int target , int low ,int high){
        if (low > high || high < 0){
            return -1;
        }
        int middle = (low + high) / 2;
        if (array[middle] == target){
            return middle;
        }
        if (array[middle] < target){
            return binarySearchWithRecursive(array,target,middle +1,high);
        }
        if (array[middle] > target){
            return binarySearchWithRecursive(array,target,low,middle -1);
        }
        return -1;
    }
}

