package csc322assignment5;

public interface IBag<E extends Comparable<E>>   /* Abstract class for the bag containers. Items must be comparable */
{
    void add(E item);               /* Method to add an item */
    E remove();                     /* Method to remove an item */
    boolean contains(E item);       /* Method to check if something is in the bag */
    boolean empty();                /* Method to determine if the bag is empty */
}
