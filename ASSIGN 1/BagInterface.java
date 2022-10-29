/** An interface that describes the operations of a bag of objects. */
public interface BagInterface<T> {
    /**
     * Gets the current number of entries in this bag.
     * 
     * @returnThe integer number of entries currently in the bag.
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is empty.
     * 
     * @returnTrue if the bag is empty, or false if not.
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     * 
     * @paramnewEntryThe object to be added as a new entry.
     * @returnTrue if the addition is successful, or false if not.
     */
    public boolean add(T newEntry);

    /**
     * Removes one unspecified entry from this bag, if possible.
     * 
     * @returnEither the removed entry, if the removal.
     *               was successful, or null.
     */
    public T remove();

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * 
     * @paramanEntryThe entry to be removed.
     * @returnTrue if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry);

    /** Removes all entries from this bag. */
    public void clear();

    /**
     * Counts the number of times a given entry appears in this bag.
     * 
     * @paramanEntryThe entry to be counted.
     * @returnThe number of times anEntryappears in the bag.
     */
    public int getFrequencyOf(T anEntry);

    /**
     * Tests whether this bag contains a given entry.
     * 
     * @paramanEntryThe entry to find.
     * @returnTrue if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry);

    /**
     * Retrieves all entries that are in this bag.
     * 
     * @returnA newly allocated array of all the entries in the bag.
     *          Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray();

    /** Tests whether two bags are equal. */
    public boolean equals(Object other);
} // end BagInterface