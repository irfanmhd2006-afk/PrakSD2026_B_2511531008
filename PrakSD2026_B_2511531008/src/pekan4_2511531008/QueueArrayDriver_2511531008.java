package pekan4_2511531008;

public class QueueArrayDriver_2511531008 {

	public static void main(String[] args) {
		QueueArray_2511531008 queue = new QueueArray_2511531008(1000);
		queue.enqueue_2511531008(10);
		queue.enqueue_2511531008(20);
		queue.enqueue_2511531008(30);
		queue.enqueue_2511531008(40);
		System.out.println("Item di depan " + queue.front_2511531008());
		System.out.println("Item paling belakang "+ queue.rear_2511531008());
		System.out.println("tampilan queue");
		queue.display_2511531008();
		
		System.out.println();
		System.out.println(queue.dequeue_2511531008()+" dihapus dari queue");
		System.out.println("item di depan:" + queue.front_2511531008());
		System.out.println("item di belakang:" +queue.rear_2511531008());
		System.out.println("tampilan queue setelah satu data dihapus");
		queue.display_2511531008();
	}

}
