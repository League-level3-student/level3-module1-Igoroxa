package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
ArrayList<String> words =  new ArrayList<String>();
        // 2. Add five Strings to your list
words.add("first");
words.add("second");
words.add("third");
words.add("fourth");
words.add("fifth");
        // 3. Print all the Strings using a standard for-loop
for (int i = 0; i < words.size(); i++) {
	String print = words.get(i);
	System.out.println(print);
	
}
        // 4. Print all the Strings using a for-each loop
for (String p : words) {
	System.out.println(p);
}
        // 5. Print only the even numbered elements in the list.
for (int i = 0; i < args.length; i++) {
	String letter= words.get(i);
	if (i % 2 == 0) {
		System.out.println(i);
	}
}
        // 6. Print all the Strings in reverse order.
for (int i = words.size(); i < 0; i--) {
	String print = words.get(i);
	System.out.println(print);
}
        // 7. Print only the Strings that have the letter 'e' in them.
        for (int i = 0; i < words.size(); i++) {
			String print = words.get(i);
			if(print.contains("e")) {
				System.out.println(print);
			}
			
		}
    }
}
