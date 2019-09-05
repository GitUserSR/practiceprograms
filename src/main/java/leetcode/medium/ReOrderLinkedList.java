package leetcode.medium;

public class ReOrderLinkedList {

	public static void main(String[] args) {
		//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
		//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
		//Given 1->2->3->4, reorder it to 1->4->2->3.

		int[] input = {1,2,3,4};
		new ReOrderLinkedList().createListNode(input);
	}
	
	void createListNode(int[] input) {
		ListNode listNode = null ;
		for(int i : input){
			if(listNode == null) {
				listNode = new ListNode(i);
			}else {
				listNode.next = new ListNode(i);
			} 
		}
		System.out.println(listNode);
	}
	
	void reOrderLinkedList() {
		
	}
	 //Definition for singly-linked list.
	 public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	 }
}
