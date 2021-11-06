package csc322assignment5;

import java.util.ArrayList;

public class UnsortedBag<E extends Comparable<E>> implements IBag<E>    /* See SortedBag.java for majority of notes. Only differences noted here */
{
    private final ArrayList<E> data = new ArrayList<>();
    
    @Override
    public void add(E item)             /* Difference: just add the item to the end of the ArrayList */
    {
        data.add(item);
    }
    
    @Override
    public E remove()
    {
        if (!empty())
        {
            E temp = data.get(data.size() - 1);
            data.remove(data.size() - 1);
            return temp;
        }
        else
            return null;
    }

    @Override
    public boolean empty()
    {
        return data.isEmpty();
    }
    
    @Override
    public boolean contains(E item)
    {
        for (int i = 0; i < data.size(); i++)        /* Difference: as the contains are not sorted, a binary search will not work. Have it iterate through */
            if (item.compareTo(data.get(i)) == 0)
                return true;
        return false;
    }
}