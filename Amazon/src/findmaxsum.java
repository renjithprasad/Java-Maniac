import java.util.ArrayDeque;
import java.util.Deque;

public class findmaxsum {

	 public static int[] windowMax(int[] nums, int window) {  
	   int w = (nums.length < window) ? nums.length : window;  
	   
	   Deque<Integer> que = new ArrayDeque<Integer>();  
	   
	   int i=0;  
	   while (i<w) {  
	     while (!que.isEmpty() && nums[que.getLast()] <= nums[i]) {  
	       que.removeLast();  
	     }  
	     que.addLast(i++);  
	   }  
	   
	   int[] max = new int[nums.length - w + 1];  
	   max[i-w] = nums[que.getFirst()];  
	   while (i<nums.length) {  
	     while (!que.isEmpty() && nums[que.getLast()] <= nums[i]) {  
	       que.removeLast();  
	     }  
	     que.addLast(i);  
	     if (!que.isEmpty() && i-w >= que.getFirst()) {  
	       que.removeFirst();  
	     }  
	     ++i;  
	     max[i-w] = nums[que.getFirst()];  
	   }  
	   
	   return max;  
	 }  
	 
	 public static void main(String args[]) {
	     int[] a = {3,10,5,4,6,7,3,7,8,8,9};
	     int[] b =null;
	     b = windowMax(a,3);
	     for (int i=0;i<b.length;i++){
	         System.out.println(b[i]);
	     }
	 }
	 }

