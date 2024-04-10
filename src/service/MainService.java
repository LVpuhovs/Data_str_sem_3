package service;

import DataStr.MyHeap;
import model.Patient;

public class MainService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
MyHeap<Integer> heapOfIntegers = new MyHeap<Integer>();
		
		try {
			heapOfIntegers.enqueue(6);
			heapOfIntegers.enqueue(8);
			heapOfIntegers.enqueue(10);
			heapOfIntegers.enqueue(2);
			heapOfIntegers.enqueue(7);
			heapOfIntegers.enqueue(99);
			
			
			heapOfIntegers.print();
			System.out.println("-------------------");
			heapOfIntegers.print2();
			System.out.println("-------------------");
			
			System.out.println(heapOfIntegers.dequeue());//99
			System.out.println("-------------------");
			heapOfIntegers.print2();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//TODO izveido klasi Patient
		
		//izveidot Patient tipa kaudzi
		//pārbaudīt kaudzes fukcijas
		MyHeap<Patient> allPatients = new MyHeap<Patient>();
		
		try {
			//Janim lauzst pirksts
			allPatients.enqueue(new Patient("Janis", "Berzins", "123456-56789", 2));
			//Baibai sap vēders
			allPatients.enqueue(new Patient("Baiba", "Kalnina", "113456-56789", 4));
			
			//Liga cietusi autokatastrofā
			allPatients.enqueue(new Patient("Liga", "Jauka", "013456-56789", 8));
			
			System.out.println(allPatients.dequeue());//Ligai
			
			
			allPatients.print2();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
