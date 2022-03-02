package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _00_ArrayListDemo {
    public static void main(String[] args) {

        /*
         * Declaring and Initializing an ArrayList of Strings
         */
        ArrayList<String> names = new ArrayList<String>();

        names.add("Jan");
        names.add("Sara");
        names.add("Fred");
        names.add("Marc");

        /*
         * Iterating through list with a standard for-loop
         */
        System.out.println("Here's the ArrayList of Strings:");
        
        for(int i = 0; i < names.size(); i++){
            String s = names.get(i);
            System.out.println("String at element " + i + " " + s);
        }
        
        System.out.print("\n");
        
        /*
         * Iterating through list with a for-each loop
         */
        System.out.println("Here's the ArrayList using a for-each loop:");
        
        for(String s : names){
            System.out.println(s);
        }
        
        System.out.print("\n");
        
        /*
         * Declaring and Initializing an ArrayList of Integers
         */
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(7);
        numbers.add(-24);
        numbers.add(1);
        numbers.add(1040);
        numbers.add(-2327);
        
        /*
         * Iterating through list with standard for-loop
         */
        System.out.println("Here's the ArrayList of Integers:");
        
        for(int i = 0; i < numbers.size(); i++){
            Integer j = numbers.get(i);
            System.out.print(j + " ");
        }
        
        System.out.print("\n\n");
        
        /*
         * Adding a value into the middle of the list
         */
        System.out.println("Here's adding into the middle of the ArrayList:");
        
        // Add element into index 2
        numbers.add(2, 22222);
        
        for(Integer j : numbers){
            System.out.print(j + " ");
        }
        
        System.out.print("\n\n");
        
        /*
         * Removing from the middle of the list
         */
        System.out.println("Here's removing from the middle of the ArrayList:");
        
        // Remove element at index 2
        numbers.remove(2);
        
        for(Integer j : numbers){
            System.out.print(j + " ");
        }
    }
}
