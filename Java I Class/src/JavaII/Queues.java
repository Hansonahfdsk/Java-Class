package JavaII;

import java.util.ArrayList;

public class Queues<T> {
	
	private class Bundle {
		T element;
		int priority;
		public Bundle(T e, int p) {
			element = e;
			priority = p;
		}
		
		public String toAtring() {
			return element + ": " + priority;
		}
		ArrayList<Bundle> queue = new ArrayList<Bundle>();
		public void put(T info, int p) {
			for (int i = 0; i < queue.size(); i++) {
				if (queue.get(i).priority < p) {
					queue.add(i, new Bundle(info, p));
					return;
				}
			}
			queue.add(new Bundle(info, p));
		}
		public int size() {
			return queue.size();
		}
		public T pop() {
			return queue.remove(0).element;
		}
		public String toString() {
			return queue.toString();
		}
	}
}
