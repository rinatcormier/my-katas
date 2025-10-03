package n21_merge_two_sorted_lists;

import java.util.ArrayDeque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        var valuesStack1 = new ArrayDeque<Integer>();
        while (node1 != null) {
            valuesStack1.push(node1.val);
            node1 = node1.next;
        }
        var valuesStack2 = new ArrayDeque<Integer>();
        while (node2 != null) {
            valuesStack2.push(node2.val);
            node2 = node2.next;
        }
        var mergedValues = new ArrayDeque<Integer>();
        while (!valuesStack1.isEmpty() || !valuesStack2.isEmpty()) {
            var value1 = valuesStack1.isEmpty() ? Integer.MIN_VALUE : valuesStack1.peek();
            var value2 = valuesStack2.isEmpty() ? Integer.MIN_VALUE : valuesStack2.peek();
            if (value1 > value2) {
                mergedValues.push(valuesStack1.pop());
            } else {
                mergedValues.push(valuesStack2.pop());
            }
        }
        if (mergedValues.isEmpty()) {
            return null;
        }
        var head = new ListNode();
        while (!mergedValues.isEmpty()) {
            head.val = mergedValues.pollLast();
            if (!mergedValues.isEmpty()) {
                head = new ListNode(0, head);
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}