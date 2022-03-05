import java.util.Random;
import java.util.PriorityQueue;

public class Solution {

// Java 默认的优先队列是最小堆 MinHeap
    public int findKthLargest(int[] arr, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i ++)
            pq.add(arr[i]);

        for(int i = k; i < arr.length; i ++)
            if(!pq.isEmpty() && arr[i] > pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }

        int res = pq.peek();

        return res;
    }



    //    public int findKthLargest(int[] arr, int k){
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i < k; i ++)
//            pq.enqueue(arr[i]);
//
//        for(int i = k; i < arr.length; i ++)
//            if(!pq.isEmpty() && arr[i] > pq.getFront()){
//                pq.dequeue();
//                pq.enqueue(arr[i]);
//            }
//
//        int res = pq.getFront();
//
//        return res;
//    }
}

