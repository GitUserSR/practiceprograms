package leetcode.easy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		int[] input = {1,2,6,3,4,5,6};
		int val = 6;
		LinkedList linkedList = new LinkedList(Arrays.asList(input));
		
		ListNode head = new ListNode(6);
		ListNode node2 = new ListNode(2); head.next = node2;
		ListNode node3 = new ListNode(6); node2.next = node3;
		ListNode node4 = new ListNode(1); node3.next = node4;
		ListNode node5 = new ListNode(6); node4.next = node5;
		ListNode node6 = new ListNode(5); node5.next = node6;
		removeElements(head, 6);
	}
	
	public static ListNode addElements(int[] input) {
		 for(int i=0; i<input.length; i++) {
			 ListNode node = new ListNode(input[i]);
		 }
		 this.next = next;
	 }
    public static ListNode removeElements(ListNode head, int val) {
		if(head != null && head.val == val) {
			head = head.next;
		}
		ListNode previous = head;
		ListNode current = head.next;
		while(current != null) {
			if(current.val == val) {
				previous.next = current.next;
			}
			current = current.next;
		}
		return head;
    }
    
    public void removeElements(LinkedList head, int val) {
    	Iterator iterartor = head.iterator();
		while(iterartor.hasNext()) {
			Object item = iterartor.next();
			if(item.equals(val)) {
				head.remove(item);
			}
		}
    }
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
	 
}
