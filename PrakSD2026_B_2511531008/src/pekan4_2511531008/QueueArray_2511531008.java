package pekan4_2511531008;
import java.util.*;

public class QueueArray_2511531008 {
	int front_1008,rear_1008,size_1008;
	int capacity_1008;
	int array_1008[];
	public QueueArray_2511531008(int capacity_1008){
		this.capacity_1008 = capacity_1008;
		front_1008 = this.size_1008 = 0;
		rear_1008 = capacity_1008 - 1;
		array_1008 = new int[this.capacity_1008];
		
	}
	boolean isFull_2511531008 (QueueArray_2511531008 queue) {
		return (queue.size_1008 == queue.capacity_1008);
	}
	boolean isEmpty_2511531008(QueueArray_2511531008 queue) {
		return (queue.size_1008 == 0);
	}
	void enqueue_2511531008(int item_1008){
		if(isFull_2511531008(this)) return;
		this.rear_1008 = (this.rear_1008 + 1) % this.capacity_1008;
		this.array_1008[this.rear_1008] = item_1008;
		this.size_1008 = this.size_1008 + 1;
		System.out.println(item_1008 + " enqueued to queue");
	}
	int dequeue_2511531008(){
		if(isEmpty_2511531008(this)) {
			return Integer.MIN_VALUE;
		}
		int item_1008 = this.array_1008[this.front_1008];
		this.front_1008 = (this.front_1008 + 1) % this.capacity_1008;
		this.size_1008 = this.size_1008 - 1;
		return item_1008;
	}
	int front_2511531008() {
		if(isEmpty_2511531008(this))
			return Integer.MIN_VALUE;
		return this.array_1008[this.front_1008];
	}
	
	int rear_2511531008() {
		if(isEmpty_2511531008(this))
			return Integer.MIN_VALUE;
		return this.array_1008[this.rear_1008];
	}
	
	void display_2511531008(){
		int i_1008;
		if(front_1008 == rear_1008) {
			System.out.print("\n Antrian Kosong \n");
			return;
		}
		
		//kunjugi dari belakang secara acak
		for(i_1008 = front_1008 ;i_1008 < rear_1008; i_1008++) {
			System.out.printf(" %d <-- ", array_1008[i_1008]);
		}
		return;
	}
	

}
