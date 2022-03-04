import java.util.Arrays;
import java.util.Random;

public class Quick_sort {
    private Quick_sort(){}
    public static<E extends Comparable<E>> void sort(E[] arr){
        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }
    private static<E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd){
        if(l >= r)
            return;
        int p = partition(arr, l, r, rnd);
        sort(arr, l, p-1, rnd);
        sort(arr, p+1, r, rnd);
    }

    private static<E extends Comparable<E>> int partition(E[] arr, int l , int r, Random rnd){
        //生成[l,r]之间的随机索引
        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr,l,p);

        // arr[l+1 ... j] < arr[l] ,  arr[j+1 ... i] > arr[l]
        int j = l;
        for(int i = j+1; i <= r; i++){
            if(arr[i].compareTo(arr[l]) < 0){
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static<E extends Comparable<E>> void sort2(E[] arr){
        sort2(arr, 0, arr.length - 1);
    }
    private static<E extends Comparable<E>> void sort2(E[] arr, int l, int r){
        if(l >= r)
            return;
        int p = partition2(arr, l, r);
        sort2(arr, l, p-1);
        sort2(arr, p+1, r);
    }

    private static<E extends Comparable<E>> int partition2(E[] arr, int l , int r){
        //每次取数组中间的那个元素
        swap(arr, l,(l+r) / 2);
        // arr[l+1 ... j] < arr[l] ,  arr[j+1 ... i] > arr[l]
        int j = l;
        for(int i = l+1; i <= r; i++){
            if(arr[i].compareTo(arr[l]) < 0){
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static<E extends Comparable<E>> void sort2ways(E[] arr){
        Random rnd = new Random();
        sort2ways(arr, 0, arr.length - 1, rnd);
    }
    private static<E extends Comparable<E>> void sort2ways(E[] arr, int l, int r, Random rnd){
        if(l >= r)
            return;
        int p = partition2ways(arr, l, r, rnd);
        sort2ways(arr, l, p-1, rnd);
        sort2ways(arr, p+1, r, rnd);
    }

    private static<E extends Comparable<E>> int partition2ways(E[] arr, int l , int r, Random rnd){

        //生成[l,r]之间的随机索引
        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr,l,p);
        int i = l + 1;
        int j = r;
        while (true){
            while (i <= j && arr[i].compareTo(arr[l]) < 0)
                i++;
            while (j >= i && arr[j].compareTo(arr[l]) > 0)
                j--;
            if(i >= j)
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }

    public static<E extends Comparable<E>> void sort3ways(E[] arr){
        Random rnd = new Random();
        sort3ways(arr, 0, arr.length - 1, rnd);
    }
    private static<E extends Comparable<E>> void sort3ways(E[] arr, int l, int r, Random rnd){
        if(l >= r)
            return;
        //生成[l,r]之间的随机索引
        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr, l, p);

        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while(i < gt){
            if(arr[i].compareTo(arr[l]) < 0){
                lt ++;
                swap(arr, lt, i);
                i ++;
            }
            else if(arr[i] == arr[l])
                i ++;
            else {
                gt --;
                swap(arr, gt, i);
            }
        }
        swap(arr, l, lt);
        sort3ways(arr, l, lt - 1, rnd);
        sort3ways(arr, gt, r, rnd);
    }

    private static<E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        Integer [] dataSize = {10000};
        for(Integer n: dataSize) {
            Integer[] arr = ArrayGeneratetor.generateRandomArray(n, n);
//            int[] arr2 = Arrays.copyOf(arr, arr.length);
            Integer [] arr3 = Arrays.copyOf(arr,arr.length);
            Integer [] arr4 = Arrays.copyOf(arr,arr.length);
            System.out.println("This is the RandomArray: ");
            SortingHelper.sortTest("Quick_sort", arr);
//            SortingHelper.sortTest("Quick_sort2",arr2);
            SortingHelper.sortTest("Quick_sort2ways", arr3);
            SortingHelper.sortTest("Quick_sort3ways", arr4);


            arr = ArrayGeneratetor.generateOrderedArray(n);
//            arr2 = Arrays.copyOf(arr,arr.length);
            arr3 = Arrays.copyOf(arr,arr.length);
            arr4 = Arrays.copyOf(arr,arr.length);
            System.out.println("This is the OrderedArray: ");
            SortingHelper.sortTest("Quick_sort", arr);
//            SortingHelper.sortTest("Quick_sort2",arr2);
            SortingHelper.sortTest("Quick_sort2ways", arr3);
            SortingHelper.sortTest("Quick_sort3ways", arr4);


//            arr = ArrayGeneratetor.generateSpecialArray(n);
////            arr2 = Arrays.copyOf(arr, arr.length);
//            arr3 = Arrays.copyOf(arr,arr.length);
//            arr4 = Arrays.copyOf(arr,arr.length);
//            System.out.println("This is the SpecialArray: ");
//            SortingHelper.sortTest("Quick_sort", arr);
////            SortingHelper.sortTest("Quick_sort2",arr2);
//            SortingHelper.sortTest("Quick_sort2ways", arr3);
//            SortingHelper.sortTest("Quick_sort3ways", arr4);


            arr = ArrayGeneratetor.generateRandomArray(n,3);
//            arr2 = Arrays.copyOf(arr, arr.length);
            arr3 = Arrays.copyOf(arr,arr.length);
            arr4 = Arrays.copyOf(arr,arr.length);
            System.out.println("This is the same value array: ");
            SortingHelper.sortTest("Quick_sort", arr);
            //            SortingHelper.sortTest("Quick_sort2",arr2);
            SortingHelper.sortTest("Quick_sort2ways", arr3);
            SortingHelper.sortTest("Quick_sort3ways", arr4);

        }
    }


}

