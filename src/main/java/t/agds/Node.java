package t.agds;

public class Node<T extends Comparable<T>> {

    // indicates number of occurences of this value
    public Element<T> FST_EL;
    public Element<T> SCD_EL;

    // lesser nodes
    public Node<T> left;

    // equal node
    public Node<T> middle;

    // greater nodes
    public Node<T> right;

    public Node(T val) {
        this.FST_EL = new Element<T>(val);
    }

    public Node(Element<T> e) {
        this.FST_EL = e;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          UTILS

    // if has no children then is a leaf
    public boolean isLeaf() {
        return !(left != null || middle != null || right != null );
    }


    public boolean hasBothKeys() {
        return (FST_EL != null) && (SCD_EL != null);
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          GETTERS AND SETTERS

    public void setBiggerVal(Double bigger ) {
        this.SCD_EL = new Element(bigger);
    }


    public void setSmallerVal(Double smaller ) {
        // copy values from first val
        this.FST_EL = this.SCD_EL;
        // set bigger
        this.SCD_EL = new Element( smaller );

    }




}
