package JavaII;

public class LinkedList<A> {
	
	public class Node{
		A info;
		Node next;
		public Node(A i, Node n) {
			info = i;
			next = n;
		}
	}
	
	private Node head = null;
	
	public A get(int i) {
			
			try { 
				Node curr = head;
			
				for (int j = 0; j < i; j++) {
					curr = curr.next;
				}
				return curr.info;
			}
			catch(NullPointerException e) {
				throw new IndexOutOfBoundsException();
			}
		}
	
	public void addNoIndex(A info) {
		Node newNode = new Node(info, null);
		if (head == null) {
			head = newNode;
		}
		else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
	}
	
	public void addIndex(A info, int i){

        Node curr = head;
        Node newNode = new Node(info, curr);
        if (i == 0){
            head = newNode;
        }
        else{
            for(int j = 0; j < i - 1; j++){
                curr = curr.next;
            }
            newNode = new Node(info, curr.next);
            curr.next = newNode;
        }
    }
	
	public A remove(int i) {
		try {
			A storedInfo;
			if (i == 0) {
				storedInfo = head.info;
				head = head.next;
			}
			else {
				Node curr = head;
				for (int j = 1; j < i; i++) {
					curr = curr.next;
				}
				storedInfo = curr.next.info;
				curr.next = curr.next.next;
			}
			return storedInfo;
		}
		catch(NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int getSize(){
        Node curr = head;
        int size = 0;
        while (curr != null){
            curr = curr.next;
            size++;
        }
        return size;
    }
	
	public String toString(){
        String output = "";
        Node curr = head;
        while (curr != null){
            output += curr.info.toString();
            curr = curr.next;
        }
        return output;
    }
}
