package edu.nyu.cs.ytz205;

/**
 * linked list class from code shared in class
 * @author judy
 */
class MyList1<T>  {
	   private T value;
	   private MyList1<T>  next;
	  
	   public T setValue(T v) {
	       value = v; return value; }
	   
	   public MyList1<T> setNext(MyList1<T> n) {
	        next = n;  return next; }

	   public T getValue() {
	       return value; }

	   public MyList1<T> getNext() {
	       return next; }

	   public MyList1<T> locate(T x) { // Locate node containing X
	       MyList1<T> n = next;
	       while (n != null) {
	          if (n.value == x)
	            return n;
	          n = n.next;
	          }
	       return null;
	     }

	   public MyList1<T> locateBefore(T x) { // Locate node before X
	       MyList1<T> n = this;
	       while (n.next != null) {
	          if (n.next.value == x)
	            return n;
	          n = n.next;
	          }
	       return null;
	     }

	// A is a node within the owner. This method adds X after the node A.
	//
	   public void addAfter(MyList1<T> a, T x) { 
	       MyList1<T> n = new MyList1<T>();
	       n.value = x;
	       n.next = a.next;
	       a.next = n;
	     }


	// Deletes the node after node A;

	   public void deleteAfter(MyList1<T> a) {
	        a.next = a.next.next; }
	      

	   public MyList1<T> first() { // First node (after header)
	        return next; }

	   public MyList1<T> last() {  // Last node.
	        MyList1<T> n = this;
	        while (n.next != null) n = n.next;
	        return n;
	     }

	   public void addFirst(T x) {   // Add X to the head of the list
	        addAfter(this,x); }  

	   public void addLast(T x) {    // Add X to the tail of the list.
	        addAfter(last(),x); }
	        
	   public void deleteFirst(T x) {   // Delete the first occurrence of X
	        deleteAfter(locateBefore(x)); }

	   public String toString() {
	          MyList1<T> a = next;
	          String s = "[";
	          while (a != null) {
	             s = s + a.value.toString() + " ";
	             a = a.next;
	           }
	         return s+ "]";
	         }


}
