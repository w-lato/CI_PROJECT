package t.agds;

import agds.Row;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tree <T extends Comparable<T>> {

    Node<T> root;


    //////////////////////////////////////////////////////////////////////////////
    //
    //
    //                          BASIC OPERATIONS

    public void insert(T val) {

        // init set root
        if (root == null)
        {
            //System.out.println("***");
            root = new Node<T>(val);
            return;
        }

        Element<T> e = insertToNode( val, this.root );

        // CREATE NEW ROOT
        if( e != null)
        {
          //  System.out.println("ROOT E: " + e.key + " " + root.SCD_EL.key);
            Node<T> newRoot;
            newRoot = new Node<T>( e );
            newRoot.left = e.getLeftSplit();
            newRoot.right = root;
            e.clearLeftSplit();
            //System.out.println("X1 ");
            root = newRoot;
        }

    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                      REMOVE OBJECT


    public boolean remove(T val)
    {
        // THERE IS NO ELEMENTS IN TREE
        if( root == null) return false;

        // NO SUCH VALUE IN TREE
        if( !contains(root, val) ) return false;

        // VALUE EXIST AND SOMETHING HAS BEEN DECREASED

        // SOME KEY HAS TO BE DELETED
        if( needsDeleting(root) )
        {
            // CREATE SORTED LIST FORM EXISTING NODES
            ArrayList<Element<T>> l = getSortedList();
            // CREATE NEW TREE USING ONLY KEYS WHICH HAVE COUNTER > 0
            this.root = null;
            for (int i = 0; i < l.size(); i++)
            {
                if( !l.get(i).ctrIsZero() )
                {
                    for (int j = 0; j < l.get(i).getCtr(); j++)
                    {
                        insert( l.get(i).key );
                    }
                }
            }
        }

        return true;
    }


    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          INSERT METHODS



    private Element<T> insertToNode(T val, Node<T> node)
    {
        // value is already in node so increment
        if( incKeyInNode( val, node ) ) return null;

        // TODO it inserts value as second (greater) eleem even if it is smaller
        // when in leaf and only one value
        boolean isLeaf = node.isLeaf();
        if( isLeaf && node.SCD_EL == null )
        {

            if( val.compareTo(node.FST_EL.key) < 0)
//            if( val. < node.FST_EL.key )
            {
                node.SCD_EL = node.FST_EL;
                node.FST_EL = new Element(val);
                return null;
            }

            node.SCD_EL = new Element(val);
            return null;
        }

        // IS LEAF AND HAS NO PLACE FOR ANOTHER KEY
        if( isLeaf && node.hasBothKeys() )
        {


            //SPLIT AND PASS
            Element<T> e = theMiddleKeyFrom(node, new Element<T>( val));
            Node<T> leftSplit = new Node<T>( node.FST_EL );
            node.FST_EL = node.SCD_EL;
            node.SCD_EL = null;
            e.setLeftSplit( leftSplit );

            if( node == this.root )
            {
                // todo
//                Node newRoot = new Node( e.key );
                Node newRoot = new Node<T>( e );
                newRoot.left = e.getLeftSplit();
                newRoot.right = root;
                root = newRoot;
                return null;
            }

            return e;
        }



        //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&77      " + val);



        // value is lesser than first key
//        if( val < node.FST_EL.key )
        if( val.compareTo(node.FST_EL.key) < 0 )
        {
            if( node.left == null ) {
                node.left = new Node<T>(val);
                return null;
            } else {
                return reconstruct(node, insertToNode( val, node.left ), 0);
            }
        }


        // check if greater than SEC or FST key
        if( node.SCD_EL != null )
        {
//            if( val > node.SCD_EL.key )
            if( val.compareTo(node.SCD_EL.key) > 0 )
            {
                if( node.right == null )
                {
                    node.right = new Node<T>(val);
                    return null;
                }
                else {
                    return reconstruct(node, insertToNode( val, node.right ), 2);
                }
            }
        }
//        else if( val > node.FST_EL.key ) {
        else if( val.compareTo( node.FST_EL.key ) > 0) {
            if( node.right == null )
            {
                node.right = new Node<T>(val);
                return null;
            }
            else {
                return reconstruct(node, insertToNode( val, node.right ), 2);
            }
        }


        // situation when val is bigger than fst and smaller than sec - go to middle
        if( node.middle == null )
        {
            node.middle = new Node<T>(val);
            return null;
        }
        else {
            return reconstruct(node, insertToNode( val, node.middle ), 1);
        }

    }

    // return true if ctr of frist or sec key was incremented
    private boolean incKeyInNode(T val, Node<T> node )
    {

        // value is alredy in root
        if( val.compareTo(node.FST_EL.key) == 0 ) {
            node.FST_EL.inc();
            return true;
        }
        if ( node.SCD_EL != null ) {
            if( val.compareTo(node.SCD_EL.key) == 0 ) {
                node.SCD_EL.inc();
                return true;
            }
        }

        return false;
    }

    private Element<T> theMiddleKeyFrom(Node<T> node, Element<T> k) {

        Element toReturn;
//        if( k.key < node.FST_EL.key )
        if( k.key.compareTo(node.FST_EL.key ) < 0)
        {
            toReturn = node.FST_EL;
            node.FST_EL = k;
            return toReturn;
        }
//        if( k.key > node.SCD_EL.key )
        if( k.key.compareTo(node.SCD_EL.key ) > 0)
        {
            toReturn = node.SCD_EL;
            node.SCD_EL = k;
            return toReturn;
        }
        return k;

    }

    private Element<T> reconstruct(Node<T> n, Element<T> e, int fromWhere) {

        if( e == null ) return null;

        // FROM LEFT
        if( fromWhere == 0 )
        {
            // ONLY ONE EL IN NODE
            if( n.SCD_EL == null )
            {
                n.middle = n.left;
                n.left = e.getLeftSplit();
                n.SCD_EL = n.FST_EL;
                n.FST_EL = e;
                e.clearLeftSplit();
                return null;
            }

            // TWO ELEMS
            Element<T> mid = theMiddleKeyFrom(n, e);

            // SETUP LEFT NODE TODO check if inc is passed corretly
//            Node nNode = new Node( n.FST_EL.key );
            Node<T> nNode = new Node<T>( n.FST_EL );
            nNode.left = e.getLeftSplit();
            nNode.right = n.left;
            e.clearLeftSplit();

            //SETUP RIGHT NODE
            n.left = n.middle;
            n.middle = null;
            n.FST_EL = n.SCD_EL;
            n.SCD_EL = null;

            mid.setLeftSplit( nNode );
            return mid;
        }

        // MIDDLE
        if( fromWhere == 1 )
        {
            // TWO ELEMS
            Element<T> mid = theMiddleKeyFrom(n, e);

            // SETUP LEFT NODE todo sam as above
//            Node nNode = new Node( n.FST_EL.key );
            Node<T> nNode = new Node<T>( n.FST_EL );
            nNode.left = n.left;
            nNode.right = e.getLeftSplit();
            e.clearLeftSplit();

            //SETUP RIGHT NODE
            n.left = n.middle;
            n.middle = null;
            n.FST_EL = n.SCD_EL;
            n.SCD_EL = null;

            mid.setLeftSplit( nNode );
            return mid;
        }

        // FROM RIGHT
        // ONLY ONE EL IN NODE
        if( n.SCD_EL == null )
        {
            n.middle = e.getLeftSplit();
            n.SCD_EL = e;
            e.clearLeftSplit();
            return null;
        }

        // TWO ELEMS
        Element<T> mid = theMiddleKeyFrom(n, e);

        // SETUP LEFT NODE todo same
//        Node nNode = new Node( n.FST_EL.key );
        Node<T> nNode = new Node<T>( n.FST_EL );
        nNode.left = n.left;
        nNode.right = n.middle;

        //SETUP RIGHT NODE
        n.left = e.getLeftSplit();
        n.middle = null;
        n.FST_EL = n.SCD_EL;
        n.SCD_EL = null;

        mid.setLeftSplit( nNode );
        return mid;

    }

    private boolean isLesserThanFstKey(T val, Node<T> node)
    {
//        return val < node.FST_EL.key;
        return val.compareTo( node.FST_EL.key) < 0;
    }

    private boolean isGreaterThanSecKey(T val, Node<T> node)
    {
//        return val > node.SCD_EL.key;
        return val.compareTo( node.SCD_EL.key) > 0;
    }




    public void update() {

    }


    public Element<T> getMin()
    {
        return getMin(root);
    }

    private Element<T> getMin(Node<T> n)
    {
        if( n.left != null ) return getMin( n.left );
        return n.FST_EL;
    }

    public Element<T> getMax()
    {
        return getMax(root);
    }

    private Element<T> getMax(Node<T> n)
    {
        if( n.right != null ) return getMax( n.right );
        if( n.SCD_EL != null ) return n.SCD_EL;
        return  n.FST_EL;
    }

    public Element<T> getSum()
    {
        ArrayList<Element<T>> l = this.getSortedList();

        Double sum = 0.0;
        int count_el = 0;

        for(Element<T> it : l)
        {
            sum += (Double)it.key;
            count_el += it.getCtr();
        }
        return new Element(sum, count_el);
    }


    public Element<T> getAvg()
    {
        ArrayList<Element<T>> l = this.getSortedList();

        Double sum = 0.0;
        int count_el = 0;

        for(Element<T> it : l)
        {
            sum += (Double)it.key;
            count_el += it.getCtr();
        }
        return new Element(sum / count_el, count_el / l.size());
    }

    public int size()
    {
        return getSortedList().size();
    }


    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          PRINT METHODS


    public void printTree() {

        printNode( this.root );

    }

    private void printNode(Node<T> node) {

        if( node == null )
        {
            System.out.println("TREE IS EMPTY");
            return;
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@22");

        // GO LEFT
        if( node.left != null ) printNode( node.left );

        // PRINT FIRST
        System.out.println( node.FST_EL.key + "  ctr: " + node.FST_EL.ctr );

        // GO MIDDLE
        if( node.middle != null ) printNode( node.middle );

        // PRINT SEC
        if( node.SCD_EL != null ) System.out.println( node.SCD_EL.key + "  ctr: " + node.SCD_EL.ctr );

        // GO RIGHT
        if( node.right != null ) printNode( node.right );

    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          AUX METHODS


    private int height(Node<T> node, int H) {

        System.out.print( node.FST_EL.key + " scd:" ); if( node.SCD_EL != null) System.out.print(node.SCD_EL.key);
        System.out.println();
        if (node == null && node == root) return 0;

        H++;

        if( node.isLeaf() ) return H;

        //if( node.right != null ) {

            if( node.middle != null )
            {
                return Math.max( height(node.left, H), Math.max(height(node.middle, H), height(node.right,H) ) );
            }

        //}
        return Math.max(height(node.left, H), height(node.right,H));
    }


    public boolean contains(Node<T> n, T val) {
        // FOUND IN FIRST
        if( n.FST_EL.key.compareTo( val ) == 0)
        {
            n.FST_EL.dec();
            return true;
        }

        //FOUND IN SECOND
        if ( n.SCD_EL != null )
        {
            if( n.SCD_EL.key.compareTo( val ) == 0)
            {
                return true;
            }
        }

        // GO LEFT
//        if( val < n.FST_EL.key && n.left != null )
        if( (val.compareTo( n.FST_EL.key) < 0) && n.left != null )
        {
            return contains( n.left, val );
        }

        // GO RIGHT
        if( n.SCD_EL != null )
        {
//            if( val > n.SCD_EL.key && n.right != null )
            if( (val.compareTo(n.SCD_EL.key) > 0) && n.right != null )
            {
                return contains( n.right, val );
            }
            // GO MIDDLE
            else if( n.middle != null )
            {
                return contains(n.middle, val);
            }
        }

        // NO SEC VALUE BUT GREATER THAN FIRST
//        if( val > n.FST_EL.key && n.right != null )
        if( (val.compareTo( n.FST_EL.key ) > 0) && n.right != null )
        {
            return contains( n.right, val );
        }

        // NO SUCH VALUE IN THIS BRANCH TREE
        return false;
    }

    public boolean needsDeleting(Node<T> n) {
        // FOUND IN FIRST
        if( n.FST_EL.ctrIsZero()) return true;

        //FOUND IN SECOND
        if ( n.SCD_EL != null )
        {
            if( n.SCD_EL.ctrIsZero()) return true;
        }

        boolean L = false;
        boolean M = false;
        boolean R = false;


        // GO LEFT
        if( n.left != null )
        {
            L = needsDeleting( n.left);
        }
        if( n.middle != null )
        {
            M = needsDeleting( n.middle);
        }
        if( n.right != null )
        {
            R = needsDeleting( n.right);
        }
        return  L || M || R;

    }

    public ArrayList<Element<T>> getSortedList()
    {
        ArrayList<Element<T>> l = new ArrayList<Element<T>>();
        gatherAllElements(root, l);
        return  l;
    }

    private void gatherAllElements(Node<T> n, ArrayList<Element<T>> l )
    {
        // GO LEFT
        if( n.left != null ) gatherAllElements( n.left, l );

        // GET FIRST
        l.add( n.FST_EL );

        // GO MIDDLE
        if( n.middle != null ) gatherAllElements( n.middle, l );

        // PRINT SEC
        if( n.SCD_EL != null ) l.add( n.SCD_EL);

        // GO RIGHT
        if( n.right != null ) gatherAllElements( n.right, l);
    }


    public void addEdgesToNodes(ArrayList<Row> rows, int colID)
    {
        addEdgesToNodes(root, rows, colID);
    }

    private void addEdgesToNodes(Node<T> n, ArrayList<Row> rows, int colID )
    {
        // GO LEFT
        if( n.left != null ) addEdgesToNodes( n.left, rows, colID );

        // GET FIRST
        n.FST_EL.addEdges( rows, colID);

        // GO MIDDLE
        if( n.middle != null ) addEdgesToNodes( n.middle, rows, colID );

        // PRINT SEC
        if( n.SCD_EL != null ) n.SCD_EL.addEdges( rows, colID);

        // GO RIGHT
        if( n.right != null ) addEdgesToNodes( n.right, rows, colID );
    }

    public void resetALlX() {
        this.resetAllX( root );
    }

    private void resetAllX(Node n) {
        // GO LEFT
        if( n.left != null ) resetAllX( n.left );

        // GET FIRST
        n.FST_EL.X = 0.0;

        // GO MIDDLE
        if( n.middle != null ) resetAllX( n.middle );

        // PRINT SEC
        if( n.SCD_EL != null ) n.SCD_EL.X = 0.0;

        // GO RIGHT
        if( n.right != null ) resetAllX( n.right );
    }

    public Element<T> getElem(Node<T> n, T val)
    {
        // FOUND IN FIRST
        if( n.FST_EL.key.compareTo( val ) == 0)
        {
            return n.FST_EL;
        }

        //FOUND IN SECOND
        if ( n.SCD_EL != null )
        {
            if( n.SCD_EL.key.compareTo( val ) == 0)
            {
                return n.SCD_EL;
            }
        }

        // GO LEFT
        if( (val.compareTo( n.FST_EL.key) < 0) && n.left != null )
        {
            return getElem( n.left, val );
        }

        // GO RIGHT
        if( n.SCD_EL != null )
        {
            if( (val.compareTo(n.SCD_EL.key) > 0) && n.right != null )
            {
                return getElem( n.right, val );
            }
            // GO MIDDLE
            else if( n.middle != null )
            {
                return getElem(n.middle, val);
            }
        }

        // NO SEC VALUE BUT GREATER THAN FIRST
        if( (val.compareTo( n.FST_EL.key ) > 0) && n.right != null )
        {
            return getElem( n.right, val );
        }

        // NO SUCH VALUE IN THIS BRANCH TREE
        return null;


    }


    public void setNeighbors()
    {

        ArrayList<Element<T>> l = getSortedList();

        //ONLY ONE ELEM
        if( l.size() <= 1) return;

        l.get( 0 ).left = null;
        l.get( 0 ).right = l.get( 1 );
        for (int i = 1; i < l.size() - 1; i++)
        {

            l.get( i ).left  = l.get( i - 1 );
            l.get( i ).right = l.get( i + 1 );
        }
        l.get( l.size() - 1 ).left = l.get( l.size() - 2 );
        l.get( l.size() - 1 ).right = null;
    }


    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                      GETTERS AND SETTERS

    public Element<T> getElem(T val)
    {
     return getElem(root, val);
    }

    public int getHEeight() {
        return this.height( root, 0 );
    }

    public Node<T> getRoot() {
        return root;
    }

    public static void main(String[] args) {

        Tree tree = new Tree<Double>();


        System.out.println( tree.root );

        System.out.println( tree.root );
//        tree.insert( 1.0 );
//        tree.insert( 2.0 );
//        tree.insert( 4.0 );
//        tree.insert( 4.0 );
//        tree.insert( 2.0 );
//        tree.insert( 0.0 );


        tree.insert( 5.0 );
        tree.insert( 4.0 );
        tree.insert( 1.0 );
        tree.insert( 9.0 );
        tree.insert( 6.0 );
        tree.insert( 3.0 );
        tree.insert( 6.0 );
        tree.insert( 5.0 ); // till here OK
        tree.insert( 8.0 ); // OK
        tree.insert( 3.0 ); // OK
        tree.insert( 1.0 ); // OK
        tree.insert( 2.0 ); // OK
        tree.insert( 5.0 );
        tree.insert( 7.0 );
        tree.insert( 9.0 );



//        tree.insert( 4.0 );
//        tree.insert( 4.0 );
//        tree.insert( 1.0 );
//        tree.insert( 8.0 );

//        tree.printTree();
//        System.out.println( tree.height( tree.root, 0 ) );
//        System.out.println("========================================");
//        System.out.println(tree.remove( 1.0 ));
//        System.out.println(tree.remove( 2.0 ));
//        System.out.println(tree.remove( 3.0 ));
//        System.out.println(tree.remove( 4.0 ));
//        System.out.println(tree.remove( 5.0 ));
//        System.out.println(tree.remove( 6.0 ));
//        System.out.println(tree.remove( 7.0 ));
//        System.out.println(tree.remove( 8.0 ));
//        System.out.println(tree.remove( 9.0 ));
//        System.out.println(tree.remove( 10.0 ));
//        System.out.println(tree.remove( 120.0 ));
//        System.out.println(tree.remove( -0.0 ));
//        System.out.println(tree.remove( -1.0 ));
//        System.out.println(tree.remove( 2.0 ));
//        System.out.println(tree.remove( 4.0 ));

        for (int i = 0; i < 2000000; i++) {
            tree.insert( Double.valueOf( i ) );
        }

        long start = System.nanoTime();

        System.out.println(tree.contains(tree.root, 2000001.0 ));

        System.out.println( System.nanoTime() - start );


        Set<Double> s = new HashSet<Double>();

        for (int i = 0; i < 2000000; i++) {
            s.add( Double.valueOf( i ) );
        }


        long s1 = System.nanoTime();

        s.contains( 2000001.0 );

        System.out.println( System.nanoTime() - s1 );
//        System.out.println("all inserted ");
//        for (int i = 0; i < 20000; i++) {
//            tree.remove( Double.valueOf( i ) );
//        }
//        System.out.println("all deleted");
    }



}
