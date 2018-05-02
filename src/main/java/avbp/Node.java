package avbp;

public class Node {

    // indicates number of occurences of this value
    public Element FST_EL;
    public Element SCD_EL;

    // lesser nodes
    public Node left;

    // equal node
    public Node middle;

    // greater nodes
    public Node right;


    public Node(Double val) {
        this.FST_EL = new Element(val);
    }

    public Node(Element e) {
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
