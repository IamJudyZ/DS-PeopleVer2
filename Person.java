package edu.nyu.cs.ytz205;


/**
 * 
 * Programming Assignment 2
 * Person class
 * @author Judy Zhang (ytz205)
 * MyList1 class implemented from code shared in class
 */

public class Person {

	// Constant 
	// no need to check this anymore, but make sure read the thing again
	//private static final int maxChildren = 20;
	
	// Fields
	
    private String name;
    private Person parent1; // Biological parents
    private Person parent2;
    private int numChildren = 0;
    private MyList1<Person> children;
    
    private Person spouse;	//added data field to Person
	    

	// Constructor
	public Person(String n) {
		name = n;
		numChildren = 0;
	    children = new MyList1<Person>();
	}

	// Getters
     public String getName() { return name; }
     public Person getParent1() { return parent1;}
     public Person getParent2() { return parent2;}
     public MyList1<Person> getChildren() { return children;}
     public int getNumChildren() { return numChildren;}
     
     public Person getSpouse() { return spouse;}		//getter for Spouse
     

	// Setters

     public boolean setParent(Person newparent) {
    	 boolean succeed = false;
         if (newparent == null) {
        	 System.out.println("Parent is null");
         }
         else if (newparent == this) {
        	 System.out.println("A person cannot be their own parent");

         }
	     else if (parent2 != null) {
	    	 System.out.println(name + " already has two parents");
	     } 
	     else if (newparent.getParent1() == this || newparent.getParent2() == this) {
	    	 System.out.println("A child cannot be their parent's parent");
	     }
	     else  {
	    	 MyList1<Person> newnode = new MyList1<Person>();
	    	 newnode.setValue(this);
	    	 newnode.setNext(newparent.children);
	    	 newparent.children = newnode;
	    	 
	         newparent.numChildren++;
	         if (this.parent1 == null) {
	        	 this.parent1 = newparent;
	         }
	         else  {
	        	 this.parent2 = newparent;
	         }
	         succeed = true;
	     }
         return succeed;
     } // end SetParent

     
     /**
      * method for marrying two people
      * @param q Person to be added as spouse of .this
      * @return boolean whether the marriage was successful or not
      */
     public boolean marry(Person q) {
    	 boolean succeed = false;
    	 if (q == null) {
    		 System.out.println("Person is null");
    	 }
    	 else if (this.spouse != null) {
    		 System.out.println(this.name + " is already married");
    	 }
    	 else if (q.spouse != null) {
    		 System.out.println(q.name + " is already married");
    	 }
    	 else if (this.parent1 == q || this.parent2 == q) {
    		 System.out.println(q.name + " is a parent of " + this.name);
    	 }
    	 else if (q.parent1 == this || q.parent2 == this) {
    		 System.out.println(this.name + " is a parent of " + q.name);
    	 }
    	 else {
    		 this.spouse = q;
    		 q.spouse = this;
    		 succeed = true;
    	 }
    	 return succeed;
     }
     
     /**
      * divorce the Person; spouse does not to be given, it is retrieved from 
      * the data field
      * @return boolean whether the action was successful or not
      */
     public boolean divorce() {
    	 boolean succeed = false;
    	 if (this.spouse != null) {
    		 Person currentSpouse = this.getSpouse();
    		 this.spouse = null;
    		 currentSpouse.spouse = null;
    		 succeed = true;
    	 }
    	 return succeed;
     }
     
     public void vaporize() {
    	 if (this.parent1 != null) {
    		 MyList1<Person> temp = parent1.getChildren();
    		 while (temp.getNext() != null) {
    			 if (temp.getNext().getValue() == this) {
    				 temp.setNext(temp.getNext().getNext());
    				 this.parent1.numChildren--;
    			 }
    			 else {
    				 temp = temp.getNext();
    			 }
    		 }
    	 }
    	 if (this.parent2 != null) {
    		 MyList1<Person> temp = parent2.getChildren();
    		 while (temp.getNext() != null) {
    			 if (temp.getNext().getValue() == this) {
    				 temp.setNext(temp.getNext().getNext());
    				 this.parent2.numChildren--;
    			 }
    			 else {
    				 temp = temp.getNext();
    			 }
    		 }
    	 }
    	 if (this.numChildren != 0) {
    		 MyList1<Person> child = this.getChildren();
    		 while (child.getNext() != null) {
    			 if (child.getValue().getParent1() == this) {
    				 child.getValue().parent1 = child.getValue().parent2;
    				 child.getValue().parent2 = null;
    				 child = child.getNext();
    			 }
    			 if (child.getValue().getParent2() == this) {
    				 child.getValue().parent2 = null;
    				 child = child.getNext();
    			 }
    		 }
      	 }
    	 if (this.getSpouse() != null) {
    		 this.divorce();
    	 }
     }
     
     
     //printers
     
     public void printSpouse() {
    	 System.out.println(this.spouse.name);
     }
     
     public void printChildren() {
    	 if (numChildren != 0) {
    		 MyList1<Person> temp = this.getChildren();
        	 for (int i = 0; i < this.numChildren; i++) {
            	 System.out.println(temp.getValue().toString());
            	 temp = temp.getNext();
        	 }
    	 }
     }
     
     public String toString() {
    	 return this.name;
     }
}
