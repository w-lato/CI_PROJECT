import avbp.Node;
import avbp.Tree;
import org.junit.Assert;
import org.junit.Test;



public class TreeTests {

    static Tree t;



    @Test
    public void checkAddingToTree() {

        t = new Tree();

        t.insert( 5.0 );

        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().FST_EL.getKey(),0.0);
        t.insert(4.0);
        Assert.assertEquals( "Cannot insert node to tree", 4.0, t.getRoot().FST_EL.getKey() ,0.0);
        Assert.assertEquals( "Cannot insert node to tree", 5.0 ,t.getRoot().SCD_EL.getKey(),0.0);

        t.insert(1.0);
        // ROOT = 4
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().SCD_EL);
        // LEFT = 1
        Assert.assertEquals("Cannot insert node to tree",1.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().left.isLeaf());
        // RIGHT = 5
        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().right.isLeaf());


        t.insert(9.0);
        // ROOT = 4
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().SCD_EL);
        // LEFT = 1
        Assert.assertEquals("Cannot insert node to tree",1.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().left.isLeaf());
        // RIGHT = 5,9
        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",9.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().right.isLeaf());


        t.insert(6.0);
        // ROOT = 4,6
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());
        // LEFT = 1
        Assert.assertEquals("Cannot insert node to tree",1.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().left.isLeaf());
        // MIDDLE = 5
        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().middle.isLeaf());
        // RIGHT = 9
        Assert.assertEquals("Cannot insert node to tree",9.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().right.isLeaf());



        t.insert(3.0);
        // ROOT = 4,6
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());
        // LEFT = 1,3
        Assert.assertEquals("Cannot insert node to tree",1.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3.0, t.getRoot().left.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().left.isLeaf());
        // MIDDLE = 5
        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().middle.isLeaf());
        // RIGHT = 9
        Assert.assertEquals("Cannot insert node to tree",9.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().right.isLeaf());


        t.insert(6.0);
        // ROOT = 4,6++
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());
        // LEFT = 1,3
        Assert.assertEquals("Cannot insert node to tree",1.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3.0, t.getRoot().left.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().left.isLeaf());
        // MIDDLE = 5
        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().middle.isLeaf());
        // RIGHT = 9
        Assert.assertEquals("Cannot insert node to tree",9.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().right.isLeaf());


        t.insert(5.0);
        // ROOT = 4,6
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());
        // LEFT = 1,3
        Assert.assertEquals("Cannot insert node to tree",1.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3.0, t.getRoot().left.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().left.isLeaf());
        // MIDDLE = 5++
        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().middle.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().middle.isLeaf());
        // RIGHT = 9
        Assert.assertEquals("Cannot insert node to tree",9.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().right.isLeaf());


        t.insert(8.0);
        // ROOT = 4,6
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());
        // LEFT = 1,3
        Assert.assertEquals("Cannot insert node to tree",1.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3.0, t.getRoot().left.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().left.isLeaf());
        // MIDDLE = 5
        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().middle.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().middle.isLeaf());
        // RIGHT = 8,9
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",9.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().right.isLeaf());


        t.insert(3.0);
        // ROOT = 4,6
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());
        // LEFT = 1,3++
        Assert.assertEquals("Cannot insert node to tree",1.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3.0, t.getRoot().left.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().left.SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().left.isLeaf());
        // MIDDLE = 5
        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().middle.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().middle.isLeaf());
        // RIGHT = 8,9
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",9.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().right.isLeaf());


        t.insert(1.0);
        // ROOT = 4,6
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());
        // LEFT = 1++,3
        Assert.assertEquals("Cannot insert node to tree",1.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().left.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",3.0, t.getRoot().left.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().left.SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().left.isLeaf());
        // MIDDLE = 5
        Assert.assertEquals("Cannot insert node to tree",5.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, t.getRoot().middle.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().middle.isLeaf());
        // RIGHT = 8,9
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",9.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, t.getRoot().right.isLeaf());



        // RECONSTRUCTION

        t.insert(2.0);

        // ROOT = 4
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        Node n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT = 6
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());


        // RIGHT LEFT = 5
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT RIGHT = 8,9
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",8.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",9.0, n.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());



        t.insert(5.0);

        // ROOT = 4
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT = 6
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());


        // RIGHT LEFT = 5++
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT RIGHT = 8,9
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",8.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",9.0, n.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());



        t.insert(7.0);

        // ROOT = 4
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT = 6,8
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());


        // RIGHT LEFT = 5
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT MIDDLE = 5
        n = t.getRoot().right.middle;
        Assert.assertEquals("Cannot insert node to tree",7.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT RIGHT = 9
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",9.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());






        t.insert(9.0);

        // ROOT = 4
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT = 6,8
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());


        // RIGHT LEFT = 5
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT MIDDLE = 5
        n = t.getRoot().right.middle;
        Assert.assertEquals("Cannot insert node to tree",7.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT RIGHT = 9++
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",9.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());




        t.insert(10.0);

        // ROOT = 4
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT = 6,8
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());


        // RIGHT LEFT = 5
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT MIDDLE = 5
        n = t.getRoot().right.middle;
        Assert.assertEquals("Cannot insert node to tree",7.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT RIGHT = 9++
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",9.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",10.0, n.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());




        // RECONSTRUCT


        t.insert(11.0);

        // ROOT = 4,8
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // MIDDLE = 6
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().middle.isLeaf());


        // MIDDLE LEFT = 5
        n = t.getRoot().middle.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // MIDDLE RIGHT = 7
        n = t.getRoot().middle.right;
        Assert.assertEquals("Cannot insert node to tree",7.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT = 10
        Assert.assertEquals("Cannot insert node to tree",10.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().right.isLeaf());


        // RIGHT LEFT = 9
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",9.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT RIGHT = 11
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",11.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());




        t.insert(12.0);

        // ROOT = 4,8
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // MIDDLE = 6
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().middle.isLeaf());


        // MIDDLE LEFT = 5
        n = t.getRoot().middle.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // MIDDLE RIGHT = 7
        n = t.getRoot().middle.right;
        Assert.assertEquals("Cannot insert node to tree",7.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT = 10
        Assert.assertEquals("Cannot insert node to tree",10.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().right.isLeaf());


        // RIGHT LEFT = 9
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",9.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT RIGHT = 11
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",11.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",12.0, n.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());




        t.insert(13.0);

        // ROOT = 4,8
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // MIDDLE = 6
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().middle.isLeaf());


        // MIDDLE LEFT = 5
        n = t.getRoot().middle.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // MIDDLE RIGHT = 7
        n = t.getRoot().middle.right;
        Assert.assertEquals("Cannot insert node to tree",7.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT = 10,12
        Assert.assertEquals("Cannot insert node to tree",10.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",12.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().right.isLeaf());


        // RIGHT LEFT = 9
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",9.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT MIDLLE = 11
        n = t.getRoot().right.middle;
        Assert.assertEquals("Cannot insert node to tree",11.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT RIGHT = 13
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",13.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());




        t.insert(14.0);

        // ROOT = 4,8
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // MIDDLE = 6
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().middle.isLeaf());


        // MIDDLE LEFT = 5
        n = t.getRoot().middle.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",3, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // MIDDLE RIGHT = 7
        n = t.getRoot().middle.right;
        Assert.assertEquals("Cannot insert node to tree",7.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT = 10,12
        Assert.assertEquals("Cannot insert node to tree",10.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",12.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().right.isLeaf());


        // RIGHT LEFT = 9
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",9.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT MIDLLE = 11
        n = t.getRoot().right.middle;
        Assert.assertEquals("Cannot insert node to tree",11.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT RIGHT = 13,14
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",13.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",14.0, n.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",1, n.SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());



        // RECONSTRUCT CHANGE HEIGHT



        t.insert(15.0);

        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, t.getRoot().FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 4
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 2
        n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",2.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, n.isLeaf());

        // LEFT RIGHT = 6
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",6.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, n.isLeaf());

        // LEFT LEFT LEFT = 1
        n = t.getRoot().left.left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // LEFT LEFT RIGHT = 3
        n = t.getRoot().left.left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());



        // RIGHT BRANCH

        // RIGHT = 12
        Assert.assertEquals("Cannot insert node to tree",12.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().right.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().right.isLeaf());

        // RIGHT LEFT = 10
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",10.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, n.isLeaf());

        // RIGHT LEFT LEFT = 9
        n = t.getRoot().right.left.left;
        Assert.assertEquals("Cannot insert node to tree",9.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",2, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT LEFT LEFT = 11
        n = t.getRoot().right.left.right;
        Assert.assertEquals("Cannot insert node to tree",11.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT RIGHT = 14
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",14.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, n.isLeaf());

        // RIGHT RIGHT LEFT = 13
        n = t.getRoot().right.right.left;
        Assert.assertEquals("Cannot insert node to tree",13.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT RIGHT RIGHT = 15
        n = t.getRoot().right.right.right;
        Assert.assertEquals("Cannot insert node to tree",15.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        Assert.assertEquals("WRONG HEIGHT", 4, t.getHEeight() );
        t.printTree();
    }


    @Test
    public void checkRemovingFromTree() {
        t = new Tree();
        t.insert(1.0);
        t.insert(2.0);
        t.insert(3.0);
        t.insert(4.0);
        t.insert(5.0);
        t.insert(6.0);
        t.insert(7.0);
        t.insert(8.0);
        t.insert(9.0);
        t.insert(10.0);

        for (int i = 1; i < 11; i++)
        {
            Assert.assertEquals(i + " not found !", true, t.remove( Double.valueOf( i ) ));
        }

        t.insert(99.0);
        t.insert(99.0);

        Assert.assertEquals( "11.0 found !", false, t.remove(11.0 ) );
        Assert.assertEquals( "23.0 found !", false, t.remove(23.0 ) );
        Assert.assertEquals( "0.0 found !", false, t.remove(0.0 ) );
        Assert.assertEquals( "-1.0 found !", false, t.remove(-1.0 ) );

        t.remove(99.0);
        t.remove(99.0);

        for (int i = 1; i < 16; i++) {
            t.insert( Double.valueOf(i) );
        }
        t.remove(15.0);





        // ROOT = 4,8
        Assert.assertEquals("Cannot insert node to tree",4.0, t.getRoot().FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",8.0, t.getRoot().SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT = 2
        Assert.assertEquals("Cannot insert node to tree",2.0, t.getRoot().left.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().left.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().isLeaf());

        // LEFT LEFT = 1
        Node n = t.getRoot().left.left;
        Assert.assertEquals("Cannot insert node to tree",1.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // LEFT RIGHT = 3
        n = t.getRoot().left.right;
        Assert.assertEquals("Cannot insert node to tree",3.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // MIDDLE = 6
        Assert.assertEquals("Cannot insert node to tree",6.0, t.getRoot().middle.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",null, t.getRoot().middle.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().middle.isLeaf());


        // MIDDLE LEFT = 5
        n = t.getRoot().middle.left;
        Assert.assertEquals("Cannot insert node to tree",5.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // MIDDLE RIGHT = 7
        n = t.getRoot().middle.right;
        Assert.assertEquals("Cannot insert node to tree",7.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT = 10,12
        Assert.assertEquals("Cannot insert node to tree",10.0, t.getRoot().right.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",12.0, t.getRoot().right.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",false, t.getRoot().right.isLeaf());


        // RIGHT LEFT = 9
        n = t.getRoot().right.left;
        Assert.assertEquals("Cannot insert node to tree",9.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());

        // RIGHT MIDLLE = 11
        n = t.getRoot().right.middle;
        Assert.assertEquals("Cannot insert node to tree",11.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",null, n.SCD_EL);
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());


        // RIGHT RIGHT = 13,14
        n = t.getRoot().right.right;
        Assert.assertEquals("Cannot insert node to tree",13.0, n.FST_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",14.0, n.SCD_EL.getKey(),0.0);
        Assert.assertEquals("Cannot insert node to tree",1, n.FST_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",1, n.SCD_EL.getCtr());
        Assert.assertEquals("Cannot insert node to tree",true, n.isLeaf());



        t.printTree();
    }

}
