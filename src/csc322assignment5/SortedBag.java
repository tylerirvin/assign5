package csc322assignment5;

import java.util.ArrayList;

public class SortedBag<E extends Comparable<E>> implements IBag<E>    /* Class of Bag in which items are sorted; possible as it extends the Comparable class */
{
    private final ArrayList<E> data = new ArrayList<>();       /* ArrayList of generic items */
    
    @Override
    public void add(E item)                                    /* Add item to the bag. Type is generic but must be of a Comparable nature */
    {
        int addIndex = findNew(item, 0, data.size() - 1);      /* Find the index of where to add the item */
        data.add(addIndex, item);                              /* Add item at the specified index. */
    }
    
    @Override
    public E remove()                                          /* Remove item from the bag and return to caller. Done slightly differently than laid out in the example. I didn't notice at first but this removes the last object in the bag rather than the first */
    {
        if (!empty())                                          /* If the bag isn't empty */
        {
            E temp = data.get(data.size() - 1);                /* Temporarily store the last item in the bag */
            data.remove(data.size() - 1);                      /* Remove the permenant copy of the last item in the bag */
            return temp;                                       /* Return the temporary copy of the now-deleted last item */
        }
        else                                                   /* If the bag is empty, return null */
            return null;
    }
    
    @Override
    public boolean empty()                                     /* Quick getter to determine if the bag/ArrayList contains anything */
    {
        return data.isEmpty();
    }
    
    @Override
    public boolean contains(E item)                            /* Method to determine if the bag contains an item */
    {
        return findItem(item, 0, data.size() - 1);             /* Recursive helper */
    }
    
    private boolean findItem(E item, int start, int end)       /* Recurive helper for contains(). Returns true if the item is found and false if not */
    {
        if (end < start)                                       /* If the search goes on long enough with no result available, the end of the range will flip to the other side of the start. In that case, the item isn't there so return false */
            return false;
        else
        {
            int mid = start + (end - start) / 2;               /* Find the midpoint of the search range. It's half the distance between the start and end of the range plus the initial start of the range. So if the range is 4-6, 6-4 = 2 (distance) -> 2/2 = 1 (half distance) -> 4+1=5 (half distance plus initial start) */
            if (item.compareTo(data.get(mid)) == 0)            /* If the item is found at the mid point, return true; it's been found */
                return true;
            else if (item.compareTo(data.get(mid)) < 1)        /* If the item would sort before the mid point, keep the start of the range the same but cut it in half (-1 as the midpoint is already known not to contain the item) */
                return findItem(item, start, mid - 1);
            else                                               /* Same as above except the item would be found in the second half of the range */
                return findItem(item, mid + 1, end);
        }
    }
    
    private int findNew(E item, int start, int end)            /* Recursive helper for adding items. Same as findItem except returns the index of where item would be sorted into */
    {
        if (end < start)
            return start;
        else
        {
            int mid = start + (end - start) / 2;
            if (item.compareTo(data.get(mid)) == 0)
                return mid;
            else if (item.compareTo(data.get(mid)) < 1)
                return findNew(item, start, mid - 1);
            else
                return findNew(item, mid + 1, end);
        }
    }
}