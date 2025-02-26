
import java.util.*;

class node {
    int val;
    node next;

    public node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class test {
    // Printing
    public static void print(node head) {
        node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                System.out.print(temp.val + " --> X");
                break;
            }
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Finding the mid Node
    public static node midNode(node head) {
        node fast = head;
        node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // reversing the node
    public static node reverse(node head) {
        node prev = null;
        node curr = head;
        node Next = curr;
        while (curr != null) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }

    // converting array of elements in Linked List
    public static node makeListNode(int[] arr) {
        node head = new node(arr[0]);
        node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    // Getting size of the Linked List
    public static int getSize(node head) {
        node temp = head;
        if (temp == null)
            return 0;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // getting tail node of a linked list
    public static node getTail(node head) {
        node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    // setting a linked list with input array
    public static node setLindedList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Linked List");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Now enter each values of the linked list in space or in a new line");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        node head = new node(arr[0]);
        node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    // Checking the palindrome

    public static int isPalindrome(node head) {
        if (head == null || head.next == null)
            return 1;
        node reverseHead = reverse(midNode(head));
        node t1 = reverseHead;
        node t2 = head;
        while (t1 != null) {
            if (t1.val != t2.val)
                return 0;
            t1 = t1.next;
            t2 = t2.next;
        }
        return 1;
    }

    public static void main(String[] args) {
        node head = setLindedList();
        print(head);
        System.out.println("the size of the linked list is "+getSize(head));
        System.out.println("the tail node val is " + getTail(head).val);
        if (isPalindrome(head) == 1) {
            System.out.println("this is palindrome");
        } else {
            System.out.println("this is not palindrome");
        }
    }
}
