package _03_RemovingStuffFromArrayLists;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import _03_RemovingStuffFromArrayLists.ArrayListRemove.Stuff;

class ArrayListRemoveTest {

    @Test
    void testRemove1() {
        ArrayListRemove yard = new ArrayListRemove();
        ArrayList<Stuff> stuffIFoundInTheYard = new ArrayList<Stuff>();
        stuffIFoundInTheYard.add(yard.new Worm());
        stuffIFoundInTheYard.add(yard.new Dirt());
        stuffIFoundInTheYard.add(yard.new Dirt());
        stuffIFoundInTheYard.add(yard.new Dirt());
        stuffIFoundInTheYard.add(yard.new Worm());
        stuffIFoundInTheYard.add(yard.new Dirt());
        
        // There should only be 2 worms left in the yard
        assertEquals(2, ArrayListRemove.cleanOutTheYard(stuffIFoundInTheYard).size());
    }

    @Test
    void testRemove2() {
        ArrayList<Character> truth = new ArrayList<Character>();
        truth.add('c');
        truth.add('a');
        truth.add('#');
        truth.add('l');
        truth.add('#');
        truth.add('i');
        truth.add('f');
        truth.add('o');
        truth.add('#');
        truth.add('r');
        truth.add('n');
        truth.add('#');
        truth.add('i');
        truth.add('#');
        truth.add('a');
        truth.add('#');
        truth.add(' ');
        truth.add('i');
        truth.add('#');
        truth.add('s');
        truth.add('#');
        truth.add(' ');
        truth.add('w');
        truth.add('#');
        truth.add('a');
        truth.add('r');
        truth.add('#');
        truth.add('m');
        truth.add('e');
        truth.add('r');
        truth.add('#');
        char[] expectedAnswer = "california is warmer".toCharArray();
        ArrayList<Character> actualAnswer = ArrayListRemove.removeHashTags(truth);
        
        assertTrue(actualAnswer.size() == expectedAnswer.length);
        
        for( int i = 0; i < expectedAnswer.length; i++ ) {
            assertEquals((int)expectedAnswer[i], (int)actualAnswer.get(i));
        }
    }
}
