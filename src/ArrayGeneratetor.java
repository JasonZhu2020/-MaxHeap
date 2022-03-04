import java.util.Random;

public class ArrayGeneratetor {

    private ArrayGeneratetor(){}

    public static Integer[] generateOrderedArray(int n){
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }

    //生成一个长度为 n 的随机数组，每个数字的范围是 [0, bound].
    public static Integer[] generateRandomArray(int n, int bound){
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for(int i = 0; i < n; i++)
            arr[i] = rnd.nextInt(bound);
        return arr;
    }

    //生成一个特殊数组
    private static void generateSpecialArray(Integer[] arr, int l, int r, int value){
        // 递归到底的情况。如果 l > r，我们要处理的区间为空，直接返回
        if(l > r)
            return;
        // 1. 把最小值放到中间
        int mid = (l+r)/2;
        arr[mid] = value;
        // 2. 模拟 partition 过程，把中间元素和最左边元素交换位置
        swap(arr, l, mid);
        // 所以，处理的区间变成了 arr[l+1...r]，同时，最小值 + 1
        generateSpecialArray(arr, l+1, r, value+1);
        // 4. 都处理好以后，还要把中间的元素和最左边的元素交换回来。
        swap(arr, l, mid);
    }

    public static Integer[] generateSpecialArray(int n){
        Integer[] arr = new Integer[n];

        // 生成 arr[0...n-1] 的测试用例，其中最小值是 0
        generateSpecialArray(arr, 0, arr.length - 1, 0);
        return arr;
    }

    private static<E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
