
public class findsumwindow {

	public static int[] SumWindow(int[] a,int w){
		if(a==null || w<0 || a.length<0){
			return null;
		} 
		int count = 0;
		int[] b = new int[(a.length - w)+1];
		for(int i=0 ; i<a.length;i++){
			count ++;
			if(count >= w){
				int sum = 0;
				for(int j=i; j>= i-w+1 ;j--){
					sum += a[j];
				}
				b[i-w+1] = sum;
			}
		}
		return b;
	}
		 
		 public static void main(String args[]) {
		     int[] a = {3,10,5,4,6,7,3,7,8,8,9};
		     int[] b =null;
		     b = SumWindow(a,3);
		     for (int i=0;i<b.length;i++){
		         System.out.println(b[i]);
		     }
		 }
	}

