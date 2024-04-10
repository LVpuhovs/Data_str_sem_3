package DataStr;

public class MyHeap<Ttype> {
	private Ttype[] heap;
	private final int HEAP_DEFAULT_SIZE = 10;
	private int size = HEAP_DEFAULT_SIZE;
	private int counter = 0;
	
	public MyHeap() {
		heap = (Ttype[]) new Object[size];
	}
	public MyHeap(int inputSize) {
		heap = (Ttype[]) new Object[size];
		if (inputSize > 0) {
			size = inputSize;
		}
		heap = (Ttype[]) new Object[size];
	}
	
	public boolean isEmpty() {
		return (counter == 0);
		
	}
	public boolean isFull() {
		return (counter == size);
	}

	public int howManyElements() {
		return counter;
	}
	
	

	private void resize() {
		
	//2. ja bus ienakosais parametrs,  tad noteikti tas japarbauda
	//3. aptrekinat .at newSize
		int newSize = (counter <= 100)? size * 2 : (int) (size *1.5);
		
		/*
		if (counter <= 100) 
			int newSize = size * 2;
		else
			int newSize = (int) (size *1.5;
		
		*/
	//4. Izveidot listNew ar newSize izmeru
		
		Ttype[] heapNew = (Ttype[]) new Object[newSize];
		
	//5. veikt kopesanu no veca masiva uz jauno
		for (int i = 0; i < size; i++) {	
			heapNew[i] = heap[i];
		}
	//6. nomainam list newreferenci uz listNew
		heap = heapNew;
	//7. izsaukt garbage collector
		System.gc();
	//8. size nomainam uz newSize
		size = newSize;
	}
	
	public void enqueue(Ttype element) throws Exception {
		if(element == null) throw new Exception("Problems with element");
		if (isFull()) resize();
		
		heap[counter] = element;
		counter++;
		reheapUp(counter-1);
	}
	public Ttype dequeue() throws Exception {
		if(isEmpty()) throw new Exception("List is empty");
		
		Ttype prioElement = heap[0];
		heap[0] = heap[counter--];
		//TODO reheapDown();
		return prioElement;
	}
	
	public void print() throws Exception{
		if(isEmpty()) throw new Exception("List is empty");
		for(int i = 0 ; i < counter; i++) {
			System.out.print(heap + " ");
		}
		System.out.println();
	}
	public void makeEmpty() {
		counter = 0;
		size = HEAP_DEFAULT_SIZE;
		heap = (Ttype[]) new Object[size];
		System.gc();
	}
	
	private void reheapUp(int indexOfElement) {
		
		//kreisa berna index = vecaka index * 2 + 1
		//laba berna index = vecaka index * 2 + 2
		
		//(kreisa berna index - 1)/2 = vecaka index
		//(laba berna index - 2)/2 = vecaaka index
		
		int indexParent = (indexOfElement - 1)/2;
		
		if (indexParent >= 0) {
			Ttype element = heap[indexOfElement];
			Ttype parent = heap[indexParent];
			
			if (((Comparable)(element)).compareTo(parent) == 1) {
				//maina vietam
				swap(indexOfElement, indexParent);
				reheapUp(indexParent);
			}
		}
	}
	
	private void reheapDown(int indexOfElement) {
		//TODO
		//noskaidrot kreisaa berna index
		//noskaidrot laba berna index
		//noskaidrot cik bernu ir
		// ja ir abi berni,  tad salidzinat kurs lielaks
		// lielako salidzina  ar elementu un pec nepieciesamibas maina vietam
		// ja ir viens(kreisais) salidzina un maina vietam
		//ja nav bernu
		//konkreta bridi jaizsauc si pasa funkcija (rekursija)
		
		
	}
	
	private void swap(int index1, int index2) {
		Ttype temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
}
