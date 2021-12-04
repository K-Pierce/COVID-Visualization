// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kian Pierce (kianp20)
package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kian Pierce (kianp20)

/**
 * Class for testing the methods within the SinglyLinkedList class
 * 
 * @author kianp (kianp20)
 * @author Nazar Taxitiemuer (nazartax)
 * @version 11.19.2021
 * 
 */
public class SinglyLinkedListTest extends TestCase {

    private SinglyLinkedList<String> list1;
    private SinglyLinkedList<String> emptyList;

    /**
     * Sets up and populates a SinglyLinkedList object for testing as well as an
     * empty SinglyLinkedList object for testing
     */
    public void setUp() {
        list1 = new SinglyLinkedList<String>();
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");

        emptyList = new SinglyLinkedList<String>();
    }


    /**
     * Ensures the size method properly returns the number of items in the list
     */
    public void testSize() {

        assertEquals(4, list1.size());
        list1.clear();
        assertEquals(0, list1.size());
        list1.add("str");
        assertEquals(1, list1.size());
        list1.add("str");
        assertEquals(2, list1.size());
        list1.add(2, "2");
        assertEquals(3, list1.size());

    }


    /**
     * Ensures the add(int, E) method properly adds the provided object at the
     * correct index and returns exceptions when applicable
     */
    public void testAdd2Param() {

        String fruitString = "{apple, pineapple, banana, mango, kiwi}";
        list1.add(1, "pineapple");
        assertEquals(fruitString, list1.toString());
        assertEquals(5, list1.size());

        fruitString = "{pear, apple, pineapple, banana, mango, kiwi}";
        list1.add(0, "pear");
        assertEquals(fruitString, list1.toString());
        assertEquals(6, list1.size());

        fruitString = "{pear, apple, pineapple, banana, mango, guava, kiwi}";
        list1.add(5, "guava");
        assertEquals(fruitString, list1.toString());
        assertEquals(7, list1.size());

        list1.clear();
        fruitString = "{apple}";
        list1.add(0, "apple");
        assertEquals(fruitString, list1.toString());
        assertEquals(1, list1.size());

        Exception exception = null;
        try {
            list1.add(10, "str");
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            list1.add(-1, "str");
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            list1.add(3, null);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

    }


    /**
     * Ensures the add(E) method properly adds the provided object at top of the
     * stack and returns exceptions when applicable
     */
    public void testAdd1Param() {

        Exception exception = null;
        try {
            list1.add(null);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

        emptyList.add("apple");
        assertEquals("{apple}", emptyList.toString());
        assertEquals(1, emptyList.size());

        String fruitString = "{apple, banana, mango, kiwi, pear}";
        list1.add("pear");
        assertEquals(fruitString, list1.toString());
        assertEquals(5, list1.size());

    }


    /**
     * Ensures the isEmpty method properly determines whether there are no
     * objects within the stack
     */
    public void testIsEmpty() {

        assertFalse(list1.isEmpty());
        assertTrue(emptyList.isEmpty());

        list1.clear();
        emptyList.add("apple");

        assertTrue(list1.isEmpty());
        assertFalse(emptyList.isEmpty());

    }


    /**
     * Ensures the remove(E) method properly removes the provided object from
     * the stack and adjusts the size field accordingly
     */
    public void testRemoveObj() {

        assertFalse(emptyList.remove("apple"));

        assertTrue(list1.remove("kiwi"));
        assertEquals(3, list1.size());

        assertFalse(list1.remove("pear"));

        list1.clear();
        list1.add("guava");
        assertTrue(list1.remove("guava"));
        assertEquals(0, list1.size());

    }


    /**
     * Ensures the remove(int) method properly removes the object at the
     * provided index and adjusts the size field accordingly
     */
    public void testRemoveInt() {

        Exception exception = null;
        try {
            list1.remove(-1);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptyList.remove(3);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            list1.remove(10);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        assertTrue(list1.remove(3));
        assertEquals("{apple, banana, mango}", list1.toString());
        assertEquals(3, list1.size());

        assertTrue(list1.remove(0));
        assertEquals("{banana, mango}", list1.toString());
        assertEquals(2, list1.size());

    }


    /**
     * Ensures the get(int) method properly returns the object at the provided
     * index and throws exceptions where applicable
     */
    public void testGet() {

        assertEquals("apple", list1.get(0));
        assertEquals("kiwi", list1.get(3));
        assertEquals("mango", list1.get(2));

        Exception exception = null;
        try {
            String i = list1.get(10);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            String i = emptyList.get(1);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

    }


    /**
     * Ensures the contains(E) method properly determines whether the stack
     * contains a provided object
     */
    public void testContains() {

        assertTrue(list1.contains("apple"));
        assertTrue(list1.contains("kiwi"));
        assertFalse(list1.contains("pear"));
        assertFalse(emptyList.contains("pear"));

    }


    /**
     * Ensures the clear() method properly removes all object from the stack and
     * sets the size field to 0
     */
    public void testClear() {

        assertEquals(4, list1.size());
        assertEquals("apple", list1.get(0));

        list1.clear();

        Exception exception = null;
        try {
            String i = list1.get(0);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        assertEquals(0, list1.size());

        emptyList.clear();
        assertEquals(0, emptyList.size());

    }


    /**
     * Ensures the lastIndexOf(E) returns the index of the last occurrence of
     * the
     * provided object in the stack
     */
    public void testLastIndexOf() {

        assertEquals(3, list1.lastIndexOf("kiwi"));
        assertEquals(0, list1.lastIndexOf("apple"));
        assertEquals(-1, list1.lastIndexOf("pear"));
        list1.add("apple");
        list1.add("pear");
        list1.add("kiwi");
        list1.add("apple");
        assertEquals(6, list1.lastIndexOf("kiwi"));
        assertEquals(7, list1.lastIndexOf("apple"));

    }


    /**
     * Ensures the toString() method properly returns the contents of the string
     * in a string object with proper formatting
     */
    public void testToString() {

        String fruitString = "{apple, banana, mango, kiwi}";
        assertEquals(fruitString, list1.toString());

        list1.add("pear");
        fruitString = "{apple, banana, mango, kiwi, pear}";
        assertEquals(fruitString, list1.toString());

        list1.remove("mango");
        fruitString = "{apple, banana, kiwi, pear}";
        assertEquals(fruitString, list1.toString());

        list1.add(1, "mango");
        fruitString = "{apple, mango, banana, kiwi, pear}";
        assertEquals(fruitString, list1.toString());

        list1.remove(2);
        fruitString = "{apple, mango, kiwi, pear}";
        assertEquals(fruitString, list1.toString());

        list1.clear();
        fruitString = "{}";
        assertEquals(fruitString, list1.toString());

        emptyList.add("1");
        emptyList.add("2");
        emptyList.add("3");
        emptyList.remove("3");
        emptyList.remove("1");
        assertEquals("{2}", emptyList.toString());

    }


    /**
     * Ensures the toArray() method properly returns an array of the contents of
     * the stack in proper order
     */
    public void testClearToArray() {
        Object[] fruitArray = { "apple", "banana", "mango", "kiwi" };
        Object[] halfArray = { "apple", "banana" };
        Object[] emptyArray = {};
        assertTrue(Arrays.equals(list1.toArray(), fruitArray));
        list1.clear();
        assertTrue(Arrays.equals(list1.toArray(), emptyArray));
        list1.add(0, "banana");
        list1.add(0, "apple");
        assertTrue(Arrays.equals(list1.toArray(), halfArray));
    }


    /**
     * Tests the iterator class within the list class
     */
    public void testIterator() {
        Iterator<String> runner = list1.iterator();
        Iterator<String> runner2 = emptyList.iterator();

        assertFalse(runner2.hasNext());
        assertTrue(runner.hasNext());

        assertEquals(runner.next(), "apple");

        Exception exception = new Exception();

        try {
            runner2.next();
        }
        catch (Exception e) {
            exception = e;
        }

        assertTrue(exception instanceof NoSuchElementException);

        runner.next();
        runner.next();
        runner.next();

        Exception exception2 = new Exception();
        try {
            runner.next();
        }
        catch (Exception e) {
            exception2 = e;
        }

        assertTrue(exception2 instanceof NoSuchElementException);
    }


    /**
     * Tests the equals method in
     */
    public void testEquals() {
        assertTrue(list1.equals(list1));
        assertFalse(list1.equals(null));
        assertFalse(list1.equals(emptyList));
        assertFalse(list1.equals(new Object()));
        SinglyLinkedList<String> clone = new SinglyLinkedList<String>();
        clone.add("apple");
        clone.add("banana");
        clone.add("mango");
        clone.add("kiwi");

        assertTrue(list1.equals(clone));
        clone.remove(0);
        clone.add("pizza");
        assertFalse(list1.equals(clone));
    }
}
