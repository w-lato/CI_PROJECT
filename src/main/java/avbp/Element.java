package avbp;

public class Element {

    final Double  key;
    int ctr;

    // used to pass pointers to their parents
    Node leftSplit = null;

    public Element(Double val) {
        this.key = val;
        this.ctr = 1;
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


    public Double getKey() {
        return key;
    }

    public int getCtr() {
        return ctr;
    }
}
