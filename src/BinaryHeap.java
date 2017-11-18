/*
 * Luke Martin
 * 
 * CSC 130 SECTION 1
 * 
 * Class BinaryHeap
 * 
 * (+)BinaryHeap()
 * (+)BinaryHeap(int size)
 * 
 * Members
 * (-)int MAX_SIZE
 * (-)int currentSize
 * (-)int[] heap
 * 
 * Methods
 * (+)int getSize()
 * (+)void insert(int data)
 * (-)void percolate(int data)
 * (+)int deleteMin()
 * 
 */
public class BinaryHeap {
  
  private int MAX_SIZE = 5000;
  private int currentSize = 0;
  private int[] heap = new int[MAX_SIZE];
  
  public BinaryHeap(){

  }
  
  
  public BinaryHeap(int size){
	  this.heap = new int[size];
	  this.currentSize = 0;
  }
  
  int getSize() {
	  return currentSize;
  }
  
  public void insert(int data){
	  if(currentSize >= MAX_SIZE) {
		  System.out.println("Error: Array out of bounds.");
	  }
	  
	percolate(data);  
	  
  }
  
  private void percolate(int data){

	int hole = ++currentSize;
	  
	for(;hole > 1 && data < heap[hole/2]; hole/=2){//check if parent is smaller than child
		heap[hole] = heap[hole/2]; //swap with parent  
	}
	heap[hole] = data;
	  
  }
  
  public int deleteMin() {
	  
	  int min = heap[1];
	  
	  int temp = heap[currentSize];
	  
	  //shrink heap size and move the min past the end
	  heap[currentSize--] = min;
	  
	  heap[1] = temp;
	  
	  //initialize to start at the root
	  int hole = 1;
	  
	  //loop for all violation conditions at most until there are no more children
	  while(hole < currentSize/2 && temp > heap[hole*2] || temp > heap[(hole*2)+1]){
			
		  //check to see if order violation is left child or right child
		  if(heap[hole*2] < heap[(hole*2)+1]) {
			  temp = heap[hole*2];
			  heap[hole*2] = heap[hole]; //swap with child(demote)
			  hole = hole*2;
		  }else {
			  temp = heap[(hole*2)+1];
			  heap[(hole*2)+1] = heap[hole]; //swap with child(demote)
			  hole = (hole*2)+1; 
		  }
	  }
	  
	  return min;
  }
  
}
