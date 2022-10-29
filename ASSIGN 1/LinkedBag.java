
public final class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode; // Reference to first node
    private int numberOfEntries;

    /**
     * Create an empty linked bag.
     */
    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    /*
     * Get the number of entries currently in this bag.
     *
     * @return The number of entries currently in this bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize

    /**
     * Add a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) { // OutOfMemoryError possible
        // nulls not allowed!
        if (newEntry == null) {
            return false;
        }

        // OutOfMemoryError possible
        try {
            // Add to beginning of chain:
            Node newNode = new Node(newEntry);
            newNode.next = firstNode; // Make new node reference rest of chain
            // (firstNode is null if chain is empty)
            firstNode = newNode; // New node is at beginning of chain
            numberOfEntries++;

            return true;
        } catch (OutOfMemoryError oom) {
            // if out of memory, can't add the element
            return false;
        }
    } // end add

    /**
     * Retrieve all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

        Node currentNode = firstNode;
        for (int i = 0; i < result.length; ++i) {
            result[i] = currentNode.data;
            currentNode = currentNode.next;
        } // end for

        return result;
    } // end toArray

    /**
     * Count the number of times a given entry appears in this bag.
     * 
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;

        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                frequency++;
            } // end if

            currentNode = currentNode.next;
        } // end while

        return frequency;
    } // end getFrequencyOf

    /**
     * Test whether this bag contains a given entry.
     * 
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return true;
            }
            currentNode = currentNode.next;
        } // end while

        return false;
    } // end contains

    /**
     * Remove one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or
     *         null, if it was not.
     */
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = remove(firstNode);
        } // end if

        return result;
    } // end remove

    /**
     * Remove one occurrence of a given entry from this bag, if possible.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false otherwise.
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = findNode(anEntry);

        if (nodeN != null) {
            remove(nodeN);
            result = true;
        } // end if

        return result;
    } // end remove

    // ---------- private methods --------------------------------------- //

    /**
     * Locate a given entry within this bag.
     *
     * @param anEntry the value to look for
     * @return a Node containing anEntry, or null if there is no such Node in
     *         this Bag.
     */
    private Node findNode(T anEntry) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        } // end while

        return null;
    } // end findNode

    /**
     * Remove the given node's data from this bag.
     *
     * @param n the node containing the value to be removed
     * @return the value that had been in the given node
     */
    private T remove(Node n) {
        T result = n.data;

        n.data = firstNode.data;
        firstNode = firstNode.next;
        numberOfEntries--;

        return result;
    }

    /**
     * A class to hold the data in a linked structure.
     */
    private class Node {
        private T data; // Entry in bag
        private Node next; // Link to next node

        /**
         * Create an unlinked node holding the given data.
         *
         * @param dataPortion the data to save in the new Node.
         */
        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        /**
         * Create a linked node holding the given data.
         *
         * @param dataPortion the data to save in the new Node.
         * @param nextNode    the Node to follow the new one.
         */
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node

    public boolean isEmpty() {
        return numberOfEntries == 0;
    } // end isEmpty

    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }
} // end LinkedBag
