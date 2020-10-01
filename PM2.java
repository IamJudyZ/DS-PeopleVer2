package edu.nyu.cs.ytz205;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Programming Assignment 2
 * driver class
 * @author Judy Zhang (ytz205)
 */
public class PM2 {

	//global variables
	public static HashMap<String, Person> allPeople = new HashMap<String, Person>();
	public static int peopleCount = 0;
	
	/**
	 * searches through all people 
	 * @param can be given as a Person object or a string
	 * @return the person if found, or null if not found
	 */
	public static Person findPerson(Person name) {
		if (allPeople.containsValue(name)) {
			return allPeople.get(name.getName());
		}		
		return null;
	}
	
	public static Person findPerson(String name) {
		if (allPeople.containsKey(name)) {
			return allPeople.get(name);
		}
		return null;
	}

	/**
	 * creates a new person, if the name is not taken and num of people < maxpeople
	 * @param name given as a String from user input
	 */
	public static void O(String name) {
		if (findPerson(name) != null) {
			System.out.println(name + " already exists.");
		}
		else {
			Person newPerson = new Person(name);
			allPeople.put(name, newPerson);
			peopleCount++;
		}
	}
	
	/**
	 * Set parent, if both people can be found
	 * @param name1 given as String from user input
	 * @param name2 given as String from user input
	 */
	public static void P(String name1, String name2) {
		Person one = findPerson(name1);
		Person two = findPerson(name2);
		if (one == null) {
			System.out.println("There is no person named " + name1);
		}
		else if (two == null) {
			System.out.println("There is no person named " + name2);
		}	
		else {	
			two.setParent(one);
		}
	}
	/**
	 * Marry two people, if both can be found
	 * @param name1 given as String from user input
	 * @param name2 given as String from user input
	 */
	public static void M(String name1, String name2) {
		Person one = findPerson(name1);
		Person two = findPerson(name2);
		if (one == null) {
			System.out.println("There is no person named " + name1);
		}
		else if (two == null) {
			System.out.println("There is no person named " + name2);
		}	
		else {	
			one.marry(two);
		}
	}
	
	/**
	 * Divorce
	 * @param name given as String from user input
	 */
	public static void D(String name) {
		Person human = findPerson(name);
		if (human == null) {
			System.out.println("There is no person named " + name);
		}
		else {
			human.divorce();
		}
	}
	
	/**
	 * Print the name of the spouse, if there is one
	 * @param name given as String from user input
	 */
	public static void S(String name) {
		Person human = findPerson(name);
		if (human == null) {
			System.out.println("There is no person named " + name);
		}
		if (human.getSpouse() != null) {
			human.printSpouse();
		}
		else {
			System.out.println(name + " is unmarried");
		}
	}
	
	/**
	 * Print the name of the children, if there is any
	 * @param name given as String from user input
	 */
	public static void C(String name) {
		Person human = findPerson(name);
		if (human == null) {
			System.out.println("There is no person named " + name);
		}
		if (human.getNumChildren() != 0) {
			human.printChildren();
		}
		else {
			System.out.println(name + " has no children");
		}
	}
	
	public static void V(String name) {
		Person human = findPerson(name);
		human.vaporize();
		allPeople.remove(name);
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		//flag
		boolean flag = true;
		
		//loop until user chooses to quit the program
		while (flag) {
			String origuser = scn.nextLine();
			String[] user = origuser.split(" ");
			
			if (user[0].equals("O")) {
					O(user[1]);
			}
			else if (user[0].equals("P")) {
				P(user[1], user[2]);
			}
			else if (user[0].equals("M")) {
				M(user[1], user[2]);
			}
			else if (user[0].equals("D")) {
				D(user[1]);
			}
			else if (user[0].equals("S")) {
				S(user[1]);
			}
			else if (user[0].equals("C")) {
				C(user[1]);
			}
			else if (user[0].equals("V")) {
				V(user[1]);
			}
			else if (user[0].equals("X")) {
				flag = false;
			}
			else {
				System.out.println("Error. Please Try again.");
			}
		}			
		scn.close();
	}
	
	
}
