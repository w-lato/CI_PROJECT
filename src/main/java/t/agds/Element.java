package t.agds;

import agds.Row;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Element<T extends Comparable<T>> {

    final T key;
    int ctr;

    // used to pass pointers to their parents
    Node leftSplit = null;

    // WEIGHT CALC FOR AGDS
    public Double X = 0.0;

    // EDGES TO ROWS OF DATA
    public HashSet<Integer> E;

    // LEFT AND RIGHT NEIGBOURS
    public Element<T> left;
    public Element<T> right;


    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          CONSTRUCTORS

    public Element(T val) {
        this.key = val;
        this.ctr = 1;
    }

    public Element(T val, int ctr) {
        this.key = val;
        this.ctr = ctr;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          UTILS

    public void inc() {
        this.ctr++;
    }

    public void dec() {
        this.ctr--;
    }

    // check if there are no more values
    public boolean ctrIsZero() {
        return ctr == 0;
    }


    public void clearLeftSplit() {
        this.leftSplit = null;
    }


    public void addEdges(ArrayList<Row> rows, int colID)
    {
        if( this.E == null ) E = new HashSet<Integer>();
        for(Row it :  rows )
        {
            // KEY EQUAL TO VAL OF ROW
            if( key.compareTo( (T)it.data.get(colID) ) == 0)
            {
                // ADD EDGE IF NOT EXIST
                if( !E.contains(it.id) )
                {
                    E.add( it.id );
                }
            }
        }
    }

    public void removeDeletedEdges(ArrayList<Row> rows)
    {
        HashSet<Integer> auxSet = new HashSet<>();
        for( Row it: rows )
        {
            auxSet.add( it.id );
        }

        for (Iterator<Integer> it = E.iterator(); it.hasNext();)
        {
            Integer edge = it.next();
            // CHECK IF STILL EXISTS - IF NOT REMOVE
            if( !auxSet.contains( edge ) )
            {
                it.remove();
            }
        }

        // CLEAN UP
        auxSet.clear();
        auxSet = null;
    }




    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          GETTERS AND SETTERS


    public void setLeftSplit(Node leftSplit) {
        this.leftSplit = leftSplit;
    }

    public Node getLeftSplit() {
        return leftSplit;
    }


    public T getKey() {
        return key;
    }

    public int getCtr() {
        return ctr;
    }
}
