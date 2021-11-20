package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Implementation of the Data Structure linked list, will be traversing 
 * one way. 
 * 
 * @author Nazar Taxitiemuer (nazartax) 
 * @param <E> Type of object that the list will store. 
 */

public class SinglyLinkedList<E> implements LList<E> {

    /**
     * Represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     * 
     * @author Nazar Taxitiemuer nazartax
     * @param <D> Type of object that will be in the node
     */
    public static class Node<D> {

        private D data;

        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }

    private Node<E> head;

    private int size;

    /**
     * Creates a new LinkedList object
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;

    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(int index, E obj) {

        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }


        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current = head;


        if (isEmpty()) {
            head = new Node<E>(obj);
        }


        else {
            if (index == 0) {
                Node<E> newNode = new Node<E>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<E> nextNext = current.next;
                        Node<E> newNode = new Node<E>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);

                    }
                    current = current.next();
                    currentIndex++; 
                }
            }
        }
        size++;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(E obj) {
    
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = head;

    
        if (isEmpty()) {
            head = new Node<E>(obj);
        }

 
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    @Override
    public boolean remove(E obj) {
        Node<E> current = head;

    
        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }


        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else {
                    current.setNext(null); 
                }
                size--;
                return true;
            }
            current = current.next;
        }

    
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    @Override
    public boolean remove(int index) {
      
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            Node<E> current = head;
            int currentIndex = 0;

       

            if (currentIndex == index) { 
                head = head.next;
                size--;
                return true;
            }

            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

          
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    @Override
    public E get(int index) {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }


        if (data == null) {
        
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    @Override
    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    @Override
    public void clear() {
        head = null;
        size = 0; 
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    @Override
    public int lastIndexOf(E obj) {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<E> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<E> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<E> other = ((SinglyLinkedList<E>)obj);
            if (other.size() == this.size()) {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }
    
    /**
     * Returns a sorted SinglyLinkedList of States by their state name, 
     * alphabetically. 
     * @return a sorted list of States
     */
    public SinglyLinkedList<State> sortStates() {  
        
        State[] allStates = new State[size]; 
        
        Node<E> current = head;
        int count = 0;
        while (current != null) {
            allStates[count] = (State)current.getData();
            current = current.next;
            count++;
        }
        
        for (int i = 0; i < size - 1; i++) {
            
            int minIndex = i;
            
            for (int j = i + 1; j < size; j++) { 
                String currName = allStates[j].getName();
                String minName = allStates[minIndex].getName(); 
                if (currName.compareTo(minName) < 0) {
                    minIndex = j;
                }
            }

            State temp = allStates[minIndex]; 
            allStates[minIndex] = allStates[i]; 
            allStates[i] = temp; 
        }
        
        SinglyLinkedList<State> newStates = new SinglyLinkedList<State>(); 
        
        for (int i = 0; i < size; i++) { 
            newStates.add(allStates[i]);
        }
        
        return newStates; 

    }
    
    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<E> iterator() {
        return new SLListIterator<E>();
    }
    
    /**
     * reverse iterator
     * @return new iterator object
     */
    
    /**
     * The iterator class for SinglyLinkedList. 
     * @author Nazar Taxitiemuer (nazartax)
     * @version 11/19/2021
     * @param <A>
     *          Generic type A for lists
     */
    private class SLListIterator<A> implements Iterator<E> {
        
        private Node<E> next;
        /**
         * Creates a new SLListIterator
         */
        public SLListIterator() {
            next = head;
        }

        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return next != null; 
        }

        /**
         *Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            
            if (size == 0) { 
                throw new NoSuchElementException(); 
            }
            
            E value = next.getData(); 
            
            if (!hasNext()) { 
                throw new NoSuchElementException(); 
            }
            
            next = next.next(); 
            
            return value;  
        }
    }
}
