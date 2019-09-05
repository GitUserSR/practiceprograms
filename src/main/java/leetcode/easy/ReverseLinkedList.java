package leetcode.easy;

public class ReverseLinkedList {

	public static void main(String args[]) {
		ListNode1 root = new ListNode1(1);
		ListNode1 node1 = root;
		ListNode1 node2 = new ListNode1(2);
		node1.next = node2;
		ListNode1 node3 = new ListNode1(3);
		node2.next = node3;
		ListNode1 node4 = new ListNode1(4);
		node3.next = node4;
		ListNode1 node5 = new ListNode1(5);
		node4.next = node5;
		
		//reverse(root);
		recuriveReverse(null, root, null);

	}
	
	static void reverse(ListNode1 root) {
		//1,2,3,4,5
		//5,4,3,2,1
		
		
		ListNode1 current = root;
		ListNode1 next = null;
		ListNode1 prev = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		System.out.println("test");
	}
	
	static void recuriveReverse(ListNode1 prev, ListNode1 current, ListNode1 next) {
		if(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			recuriveReverse(prev, current, next);
		}
		System.out.println("test");
	}
}

//Definition for singly-linked list.
class ListNode1 {
	int val;
	ListNode1 next;

	ListNode1(int x) {
		val = x;
	}
}