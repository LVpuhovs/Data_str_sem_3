package DataStr;

public class MyHeap<Ttype> {
	private Ttype[] heap;
	private final int HEAP_DEFAULT_SIZE = 10;
	private int size = HEAP_DEFAULT_SIZE;
	private int counter = 0;
	
	public MyHeap()
	{
		heap = (Ttype[]) new Object[size];
	}
	
	public MyHeap(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		heap = (Ttype[]) new Object[size];
	}
	
	public boolean isEmpty() {
		return (counter==0);
	}
	
	public boolean isFull() {
		return (counter == size);
	}
	
	public int howManyElements() {
		return counter;
	}
	
	//1. funkcijas deklarācija
	private void resize()
	{
	//3. apreķināt newSize
		int newSize = (counter <= 100)? size * 2 : (int)(size * 1.5);
	//4. izveidot listNew ar newSize izmeru
		Ttype[] heapNew = (Ttype[]) new Object[newSize];
	//5. veikt kopēsanu no veca masīva uz jauno
		for(int i = 0; i < size; i++) {
			heapNew[i] = heap[i];
		}
		
	//6. nomainam list refernci uz listNew
		heap = heapNew;
	//7. izsaukt Garbage Collector
		System.gc();
	//8. size noaminām uz newSize
		size = newSize;
	}
	
	
	public void enqueue(Ttype element) throws Exception {
		if(element == null) throw new Exception("Problems with element");
		
		if(isFull()) resize();
		
		heap[counter] = element;
		counter++;
		reheapUp(counter-1);
		
	}
	
	public Ttype dequeue() throws Exception{
		if(isEmpty()) throw new Exception("Heap is empty and it is not possible to retrieve max element");

		
		Ttype prioElement = heap[0];
		heap[0] = heap[counter-1];
		counter--;
		reheapDown(0);
		return prioElement;
		
	}
	
	//print() - parastā
		public void print() throws Exception{
			if(isEmpty()) throw new Exception("Array is empty and it "
					+ "is not possible to print elements");
			
			for(int i = 0; i < counter;i++) {
				System.out.print(heap[i] + " ");
			}
			System.out.println();
		}
		
		//TODO print() - rekursīvo
		public void print2() throws Exception
		{
			if(isEmpty()) throw new Exception("Array is empty and it "
					+ "is not possible to print elements");
			
			printRecursiveHelp(0);
			System.out.println();
			
		}
		private void printRecursiveHelp(int indexOfElement) {
			
			Ttype element = heap[indexOfElement];
			
			System.out.print("P: " +element + " ");
			
			//1. noskaidrot kreisā bērna index
			int leftChIndex = indexOfElement * 2 + 1;
			//2. noskaidrot laba bērna index
			int rightChIndex = indexOfElement * 2 + 2;
			//eksistē kreisais bērns
			if(leftChIndex < counter){
				Ttype leftCh = heap[leftChIndex];
				System.out.println("LC: " + leftCh + " [" + element + "]");
				printRecursiveHelp(leftChIndex);
			}
			//eksistē labais bērns
			if(rightChIndex < counter){
				Ttype rightCh = heap[rightChIndex];
				System.out.println("RC: " + rightCh + " [" + element + "]");
				printRecursiveHelp(rightChIndex);
			}
			
		}
		
		
		

		public void makeEmpty() {
			counter = 0;
			size = HEAP_DEFAULT_SIZE;
			heap = (Ttype[])new Object[size];
			System.gc();	
		}
		
		
		private void reheapUp(int indexOfElement) {
			
			//kreisa berna index = vecaka index * 2 + 1
			//laba berna index = vecaka index * 2 + 2
			
			//(kreisa berna index - 1)/2 =  vecaka index <- izmantojam abos bērna gadījumos
			//(laba berna index -2)/2 = vecaka index
			
			int indexParent = (indexOfElement - 1)/2;
			if(indexParent >= 0) {
				Ttype element = heap[indexOfElement];
				Ttype parent = heap[indexParent];
				//ja elements ir lielāks par savu vecaku
				if( ((Comparable)(element)).compareTo(parent) == 1){
					//mainām vietām
					swap(indexOfElement, indexParent);
					reheapUp(indexParent);	
					
				}
				
				
				
			}
			

		}
		
	
		private void reheapDown(int indexOfElement) {
			//TODO
			//1. noskaidrot kreisā bērna index
			int leftChIndex = indexOfElement * 2 + 1;
			//2. noskaidrot laba bērna index
			int rightChIndex = indexOfElement * 2 + 2;
			
			
			
			//3. noskaidrot, cik bernu ir
			if(leftChIndex < counter && rightChIndex < counter)
			{
			//3. 1. ja ir abi bērni, tad tos salīdzināt un atrast lielāko
				Ttype element = heap[indexOfElement];
				Ttype rightCh = heap[rightChIndex];
				Ttype leftCh = heap[leftChIndex];
				//ja kreisais bērns ir lielāks par labo bērnu
				if(((Comparable)(leftCh)).compareTo(rightCh)==1)
				{
					//kreisais berns ir lielāks arī par savu vecaku (element)
					if(  ((Comparable)(leftCh)).compareTo(element) ==1  )
					{
						swap(indexOfElement, leftChIndex); 
						reheapDown(leftChIndex);
					}
				}
				//labais bērns būs lielāks vai vienāds ar kreiso bērnu
				else
				{
					//ja labais bērns ir arī lielāķs par savu vecāku (element)
					if(  ((Comparable)(rightCh)).compareTo(element)  == 1 )
					{
						swap(indexOfElement, rightChIndex);
						reheapDown(rightChIndex);
					}
					
				}
			//3.1.1 lielāko tālāk salīdzina ar elementu un pēc 
			//nepieciešamības maina vietām
			}
			else if(leftChIndex < counter && rightChIndex >= counter)
			{
				//3.2. ja ir tikai viens bērns(tikai kreisais)
				Ttype element = heap[indexOfElement];
				Ttype leftCh = heap[leftChIndex];
				//kreisais bērns ir lielāks par savu vecāku (element)
				
				if(  ((Comparable)(leftCh)).compareTo(element) ==1  )
				{
					swap(indexOfElement, leftChIndex);
					
				}
			
			//3.3.ja bērnu nav??? TODO var droši dzest so gadījumu, jo tajā nekas nav jādara
			else if(leftChIndex >= counter && rightChIndex >= counter)
			{
				
			}
			

		}
		

		
		}
	
	private void swap(int index1, int index2) {
		Ttype temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
}
