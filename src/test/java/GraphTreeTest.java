import agds.AGDS;
import agds.Row;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.Assert;
import org.junit.Test;
import t.agds.Node;
import t.agds.Tree;
import view.GraphTest;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Thread.sleep;

public class GraphTreeTest {



    @Test
    public void checkRemoveFromTree()
    {
        AGDS agds = new AGDS();
        agds.loadIrisData();

        for (int i = 6; i < 127; i++) {
            agds.removeR( i );
        }

        GraphTest g = new GraphTest();

        g.printAGDS( agds );

        g.deleteNode(agds ,5 );

        // CHECK NODES
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A0_5.4" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A1_3.9" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A2_1.7" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A3_0.4" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A4_0.0" ) , null  );

        // CHECK EDGES
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A0_5.4_R1" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A1_3.9_R1" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.7_R1" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A3_0.4_R1" ) , null  );


        agds.removeR(5);
        g.deleteNode(agds ,1 );

        // CHECK NODES
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A0_4.9" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A1_3.0" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A2_1.4" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A3_0.2" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A4_0.0" ) , null  );

        // CHECK EDGES
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A0_4.9_R5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A1_3.0_R5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.4_R5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A3_0.2_R5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A4_0.0_R5" ) , null  );

        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A1_3.0_3.1" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A0_5.1_5.4" ) , null  );

        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.3_1.4" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.4_1.5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A3_0.2_0.4" ) , null  );

    }

    @Test
    public void checkAddingNewNodes()
    {
        AGDS agds = new AGDS();
        agds.loadIrisData();

        for (int i = 6; i < 127; i++) {
            agds.removeR( i );
        }
        ArrayList<Row> list = new ArrayList<>();
        for (int i = 0; i < agds.getR().size(); i++)
        {
            list.add( agds.getR().get(i) );
        }

        agds.removeR( 1 );
        agds.removeR( 5 );


        GraphTest g = new GraphTest();
        g.printAGDS( agds );

        agds.putNewRow( list.get(1) );

        g.putNode( 1,agds.getR(), agds );

        Row r = new Row(-1,
                new ArrayList<Double>() {{ // 102
                    add(5.8);
                    add(null);
                    add(5.1);
                    add(1.9);
                    add(2.0);
                }}
        );

        Assert.assertNotEquals("ADDING DOES NOT WORK", g.graph.getNode( "R_1" ) , null  );
        Assert.assertEquals("ADDING DOES NOT WORK", g.graph.getNode( "R_1" ).getAttribute("ui.color") , 1.0, 0.0  );

        // CHECK NODES
        Assert.assertNotEquals("ADDING DOES NOT WORK", g.graph.getNode( "A0_4.9" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A1_3.0" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A2_1.4" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A3_0.2" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A4_0.0" ) , null  );

        System.out.println( g.graph.getNode( "A0_4.9" ).getAttributeKeyIterator());

        Iterator<String> it = g.graph.getNode( "A0_4.9" ).getAttributeKeyIterator();
        while(it.hasNext()) {

            System.out.println( it.next() );

        }
// DEFAULT VALUE OF UI.COLOR IS 0.0 SO IF THERE IS NO UI.COLOR ATTRIBUTE THEN IT WILL BE 0.0
//        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)GraphTest.graph.getNode( "A0_4.9" ).getAttribute("ui.color") , 0.0 , 0.0 );
//        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)GraphTest.graph.getNode( "A1_3.0" ).getAttribute("ui.color") , 0.0 , 0.0 );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)g.graph.getNode( "A2_1.4" ).getAttribute("ui.color") , 0.5 , 0.0 );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)g.graph.getNode( "A3_0.2" ).getAttribute("ui.color") , 0.5 , 0.0 );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)g.graph.getNode( "A4_0.0" ).getAttribute("ui.color") , 0.5 , 0.0 );

        // CHECK EDGES
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A0_4.9_R_1" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A1_3.0_R_1" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.4_R_1" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A3_0.2_R_1" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A4_0.0_R_1" ) , null  );


        agds.putNewRow( list.get(5) );
        g.putNode( 5,agds.getR(), agds );

        // CHECK NODES
        Assert.assertNotEquals("ADDING DOES NOT WORK", g.graph.getNode( "A0_5.4" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A1_3.9" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A2_1.7" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A3_0.4" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A4_0.0" ) , null  );
//        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)GraphTest.graph.getNode( "A0_5.4" ).getAttribute("ui.color") , 0.0 , 0.0 );
//        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)GraphTest.graph.getNode( "A1_3.9" ).getAttribute("ui.color") , 0.0 , 0.0 );
//        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)GraphTest.graph.getNode( "A2_1.7" ).getAttribute("ui.color") , 0.0 , 0.0 );
//        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)GraphTest.graph.getNode( "A3_0.4" ).getAttribute("ui.color") , 0.0 , 0.0 );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", (double)g.graph.getNode( "A4_0.0" ).getAttribute("ui.color") , 0.5 , 0.0 );

        // CHECK EDGES
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A0_5.4_R_5" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A1_3.9_R_5" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.7_R_5" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A3_0.4_R_5" ) , null  );

    }

    @Test
    public void checkUpdateNodes()
    {
        AGDS agds = new AGDS();
        agds.loadIrisData();

        for (int i = 6; i < 127; i++)
        {
            agds.removeR( i );
        }
        ArrayList<Row> list = new ArrayList<>();
        for (int i = 0; i < agds.getR().size(); i++)
        {
            list.add( agds.getR().get(i) );
        }

        GraphTest g = new GraphTest();
        g.printAGDS( agds );

        agds.removeR( 1 );
        agds.removeR( 5 );

        g.update( agds );

        // CHECK NODES
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A0_5.4" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A1_3.9" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A2_1.7" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A3_0.4" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A4_0.0" ) , null  );

        // CHECK EDGES
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A0_5.4_R1" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A1_3.9_R1" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.7_R1" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A3_0.4_R1" ) , null  );

        // CHECK NODES
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A0_4.9" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A1_3.0" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A2_1.4" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A3_0.2" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getNode( "A4_0.0" ) , null  );

        // CHECK EDGES
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A0_4.9_R5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A1_3.0_R5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.4_R5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A3_0.2_R5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A4_0.0_R5" ) , null  );

        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A1_3.0_3.1" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A0_5.1_5.4" ) , null  );

        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.3_1.4" ) , null  );
        Assert.assertNotEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A2_1.4_1.5" ) , null  );
        Assert.assertEquals("ATT DELETION DOES NOT WORK", g.graph.getEdge( "A3_0.2_0.4" ) , null  );

    }
}
