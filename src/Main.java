import java.util.Random;

public class Main {

    public static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>(testData.length);
            for(int num: testData)
                maxHeap.add(num);
        }
        long endTime = System.nanoTime();
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i ++){
            arr[i] = maxHeap.extractMax();

        }
        for (int i = 1; i < testData.length; i++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
	// write your code here
//        Array<Integer> arr = new Array<>(20);
//        for(int i = 0; i < 10; i++)
//            arr.addLast(i);
//        System.out.println(arr);

//        int n = 1000000;
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        Random random = new Random();
//        for(int i = 0; i < n; i++)
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i ++){
//            arr[i] = maxHeap.extractMax();
//            if(i % 50000 == 0)
//                System.out.println(maxHeap.findMax());
//            if(i == n - 2)
//                System.out.println(maxHeap.findMax());
//        }
//        for (int i = 1; i < n; i++)
//            if(arr[i-1] < arr[i])
//                throw new IllegalArgumentException("Error");
//
//        System.out.println("Test MaxHeap completed.");


        int n = 2000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0; i < n; i++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData,false);
        System.out.println("Without heapify: " + time1 + "s");
        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + "s");
        System.out.println(" ni shi zhu ");
    }
}
