package avbp;

import java.util.ArrayList;

public class Tree {

    Node root;


    //////////////////////////////////////////////////////////////////////////////
    //
    //
    //                          BASIC OPERATIONS

    public void insert(Double val) {

        // init set root
        if (root == null)
        {
            //System.out.println("***");
            root = new Node(val);
            return;
        }

        Element e = insertToNode( val, this.root );

        // CREATE NEW ROOT
        if( e != null)
        {
          //  System.out.println("ROOT E: " + e.key + " " + root.SCD_EL.key);
            Node newRoot;
            newRoot = new Node( e );
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


    public boolean remove(Double val)
    {
        // THERE IS NO ELEMENTS IN TREE
        if( root == null) return false;

        // NO SUCH VALUE IN TREE
        if( !isPresent(root, val) ) return false;

        // VALUE EXIST AND SOMETHING HAS BEEN DECREASED

        // SOME KEY HAS TO BE DELETED
        if( needsDeleting(root) )
        {
            // CREATE SORTED LIST FORM EXISTING NODES
            ArrayList<Element> l = getSortedList();
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



    private Element insertToNode(Double val, Node node)
    {
        // value is already in node so increment
        if( incKeyInNode( val, node ) ) return null;

        // TODO it inserts value as second (greater) eleem even if it is smaller
        // when in leaf and only one value
        boolean isLeaf = node.isLeaf();
        if( isLeaf && node.SCD_EL == null )
        {

            if( val < node.FST_EL.key )
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
            Element e = theMiddleKeyFrom(node, new Element( val));
            Node leftSplit = new Node( node.FST_EL );
            node.FST_EL = node.SCD_EL;
            node.SCD_EL = null;
            e.setLeftSplit( leftSplit );

            if( node == this.root )
            {
                // todo
//                Node newRoot = new Node( e.key );
                Node newRoot = new Node( e );
                newRoot.left = e.getLeftSplit();
                newRoot.right = root;
                root = newRoot;
                return null;
            }

            return e;
        }



        //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&77      " + val);



        // value is lesser than first key
        if( val < node.FST_EL.key )
        {
            if( node.left == null ) {
                node.left = new Node(val);
                return null;
            } else {
                return reconstruct(node, insertToNode( val, node.left ), 0);
            }
        }


        // check if greater than SEC or FST key
        if( node.SCD_EL != null )
        {
            if( val > node.SCD_EL.key )
            {
                if( node.right == null )
                {
                    node.right = new Node(val);
                    return null;
                }
                else {
                    return reconstruct(node, insertToNode( val, node.right ), 2);
                }
            }
        }
        else if( val > node.FST_EL.key ) {
            if( node.right == null )
            {
                node.right = new Node(val);
                return null;
            }
            else {
                return reconstruct(node, insertToNode( val, node.right ), 2);
            }
        }


        // situation when val is bigger than fst and smaller than sec - go to middle
        if( node.middle == null )
        {
            node.middle = new Node(val);
            return null;
        }
        else {
            return reconstruct(node, insertToNode( val, node.middle ), 1);
        }

    }

    // return true if ctr of frist or sec key was incremented
    private boolean incKeyInNode(Double val, Node node )
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

    private Element theMiddleKeyFrom(Node node, Element k) {

        Element toReturn;
        if( k.key < node.FST_EL.key )
        {
            toReturn = node.FST_EL;
            node.FST_EL = k;
            return toReturn;
        }
        if( k.key > node.SCD_EL.key )
        {
            toReturn = node.SCD_EL;
            node.SCD_EL = k;
            return toReturn;
        }
        return k;

    }

    private Element reconstruct(Node n, Element e, int fromWhere) {

        if( e == null ) return null;

        // FROM LEFT
        if( fromWhere == 0 )
        {
            // ONLY ONE EL IN NODE
            if( n.SCD_EL == null ) {
                n.middle = n.left;
                n.left = e.getLeftSplit();
                n.SCD_EL = n.FST_EL;
                n.FST_EL = e;
                e.clearLeftSplit();
                return null;
            }

            // TWO ELEMS
            Element mid = theMiddleKeyFrom(n, e);

            // SETUP LEFT NODE TODO check if inc is passed corretly
//            Node nNode = new Node( n.FST_EL.key );
            Node nNode = new Node( n.FST_EL );
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
            Element mid = theMiddleKeyFrom(n, e);

            // SETUP LEFT NODE todo sam as above
//            Node nNode = new Node( n.FST_EL.key );
            Node nNode = new Node( n.FST_EL );
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
        if( n.SCD_EL == null ) {
            n.middle = e.getLeftSplit();
            n.SCD_EL = e;
            e.clearLeftSplit();
            return null;
        }

        // TWO ELEMS
        Element mid = theMiddleKeyFrom(n, e);

        // SETUP LEFT NODE todo same
//        Node nNode = new Node( n.FST_EL.key );
        Node nNode = new Node( n.FST_EL );
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

    private boolean isLesserThanFstKey(Double val, Node node)
    {
        return val < node.FST_EL.key;
    }

    private boolean isGreaterThanSecKey(Double val, Node node)
    {
        return val > node.SCD_EL.key;
    }




    public void update() {

    }


    public void getMin() {

    }


    public void getMax() {

    }



    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          PRINT METHODS


    public void printTree() {

        printNode( this.root );

    }

    private void printNode(Node node) {

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


    private int height(Node node, int H) {

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


    public boolean isPresent(Node n, Double val) {
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
        if( val < n.FST_EL.key && n.left != null )
        {
            return isPresent( n.left, val );
        }

        // GO RIGHT
        if( n.SCD_EL != null )
        {
            if( val > n.SCD_EL.key && n.right != null )
            {
                return isPresent( n.right, val );
            }
            // GO MIDDLE
            else if( n.middle != null )
            {
                return isPresent(n.middle, val);
            }
        }

        // NO SEC VALUE BUT GREATER THAN FIRST
        if( val > n.FST_EL.key && n.right != null )
        {
            return isPresent( n.right, val );
        }

        // NO SUCH VALUE IN THIS BRANCH TREE
        return false;
    }

    public boolean needsDeleting(Node n) {
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

    public ArrayList<Element> getSortedList()
    {
        ArrayList<Element> l = new ArrayList<Element>();
        gatherAllElements(root, l);
        return  l;
    }

    private void gatherAllElements(Node n, ArrayList<Element> l )
    {
        // GO LEFT
        if( n.left != null ) gatherAllElements( n.left, l );

        // GET FIRST
        l.add( n.FST_EL );

        // GO MIDDLE
        if( n.middle != null ) gatherAllElements( n.middle, l );

        // PRINT SEC
        if( n.SCD_EL != null ) l.add(n.SCD_EL);

        // GO RIGHT
        if( n.right != null ) gatherAllElements( n.right, l);
    }





    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                      GETTERS AND SETTERS

    public int getHEeight() {
        return this.height( root, 0 );
    }

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {

        Tree tree = new Tree();


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
        System.out.println("========================================");
        System.out.println(tree.remove( 1.0 ));
        System.out.println(tree.remove( 2.0 ));
        System.out.println(tree.remove( 3.0 ));
        System.out.println(tree.remove( 4.0 ));
        System.out.println(tree.remove( 5.0 ));
        System.out.println(tree.remove( 6.0 ));
        System.out.println(tree.remove( 7.0 ));
        System.out.println(tree.remove( 8.0 ));
        System.out.println(tree.remove( 9.0 ));
        System.out.println(tree.remove( 10.0 ));
        System.out.println(tree.remove( 120.0 ));
        System.out.println(tree.remove( -0.0 ));
        System.out.println(tree.remove( -1.0 ));
        System.out.println(tree.remove( 2.0 ));
        System.out.println(tree.remove( 4.0 ));

        for (int i = 0; i < 20000; i++) {
            tree.insert( Double.valueOf( i ) );
        }

        System.out.println("all inserted ");
        for (int i = 0; i < 20000; i++) {
            tree.remove( Double.valueOf( i ) );
        }
        System.out.println("all deleted");
    }



}
