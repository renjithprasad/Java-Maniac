
public class setImplementation {
	int loc;
	private int[] elements;
	
	public setImplementation(int size) {
		loc = -1;
		elements = new int[size];
	}
	
	public boolean add(int number){
		
		for(int i=0;i<=loc;i++){
			if(elements[i] != number){
			  continue;
			} else {
				return false;
			}
		}
		elements[++loc] = number;
		return true;
	}
	
	public void delete(int index){
		while(index<loc){
		elements[index] = elements[index+1];
		index++;
		} 
		loc--;
	}
	
	public int size(){
		return (loc+1);
	}
	
}
