public class SortingHelper {
    private SortingHelper(){}

    public static<E extends Comparable<E>> boolean isSorted(E[] arr){
        for(int i = 1; i < arr.length; i++)
            if(arr[i-1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    public static<E extends Comparable<E>> void sortTest(String sortname, E[] arr){
        long startTime = System.nanoTime();
        if (sortname.equals("Quick_sort"))
            Quick_sort.sort(arr);
        else if(sortname.equals("Quick_sort2"))
            Quick_sort.sort2(arr);
        else if(sortname.equals("Quick_sort2ways"))
            Quick_sort.sort2ways(arr);
        else if(sortname.equals("Quick_sort3ways"))
            Quick_sort.sort3ways(arr);
        else if(sortname.equals("MergeSort"))
            Merge_sort.sort(arr);
        else if(sortname.equals("HeapSort"))
            HeapSort.sort(arr);
        else if(sortname.equals("HeapSort2"))
            HeapSort.sort2(arr);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + "failed");
        System.out.println(String.format("%s, n = %d : %f s", sortname, arr.length, time));

    }
}
