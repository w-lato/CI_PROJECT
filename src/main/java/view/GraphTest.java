package view;

import agds.AGDS;
import agds.Row;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import sun.font.FontRunIterator;
import t.agds.Element;
import t.agds.Tree;
import utils.CSVReader;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;


/**
 *
 * setting different colors of graph nodes
 *
 * http://graphstream-project.org/doc/FAQ/The-graph-viewer/How-do-I-dynamically-change-color-and-size-in-the-viewer/
 *
 *
 */
public class GraphTest
{

    private boolean isDisplayOn = false;

    public  SingleGraph graph;

//    private static  final int VO  = 1000;
//    private   final int VO  = 300;
    private   final int VO  = 300;
    private   final int HO  = 200;
    private   final int NODE_SIZE  = 20;
    private   final int RVD  = 500;

    public  void printAGDS(AGDS agds) {

        this.isDisplayOn = true;

        String style = "node {" +
                "size-mode: dyn-size;" +
                "size: 10px;" +
                "fill-mode: dyn-plain;" +
                "fill-color: blue, red;" +
                "}";


        graph = new SingleGraph("AGDS");
        graph.addAttribute( "ui.stylesheet", style );


        // PRINT Rs IN SINGLE ROW
//        int NODE_SIZE = 20;
//        int HO = 200; // HORIZONTAL OFFSET
        int ctr = 0;
        for( Row it : agds.getR() )
        {
            String nodeID =  "R_" + String.valueOf(it.id);
            System.out.println(nodeID);
            graph.addNode(  nodeID );
//            graph.getNode( nodeID ).setAttribute("xyz",ctr * HO, (ctr % 2 == 0?0:-HO),0 );
            graph.getNode( nodeID ).setAttribute("x",ctr * HO);
            graph.getNode( nodeID ).setAttribute("y", (ctr % 2 == 0?0:-HO) );
            graph.getNode( nodeID ).addAttribute("ui.label", nodeID );
            graph.getNode( nodeID ).addAttribute("ui.color", it.X);
//            graph.getNode( nodeID ).addAttribute("ui.color",Math.log(it.X * 2.5) );
            graph.getNode( nodeID ).addAttribute("ui.size", Math.log(it.X * 3) * NODE_SIZE);

            ctr++;
        }

        // PRINT PARAMS
//        int RVD = 500;
//        int VO = 1000; // VERTICAL OFFSET
        ctr = 0;
        for (int i = 0; i < agds.getN(); i++)
        {
            ArrayList<Element<Double>> elems = agds.getA()[i].getSortedList();

            //ctr = 0;
            for(Element it : elems)
            {
                String nodeID =  "A" + String.valueOf(i) + "_" + String.valueOf(it.getKey());
                graph.addNode( nodeID );

                // class attribute
                if( i == agds.getN() - 1 )
                {
//                  graph.getNode( nodeID ).setAttribute("xyz",ctr / 2 * HO, -i * VO + RVD + (ctr % 2 == 0?0:-HO),0 );
                    graph.getNode( nodeID ).setAttribute("x",ctr / 2 * HO);
                    graph.getNode( nodeID ).setAttribute("y", -i * VO + RVD + (ctr % 2 == 0?0:-HO) );

                }
                // all other attrtibutes
                else {
//                  graph.getNode( nodeID ).setAttribute("xyz",ctr * HO,VO + i * VO + RVD + (ctr % 2 == 0?0:-HO),0 );
                    graph.getNode( nodeID ).setAttribute("x",ctr * HO );
                    graph.getNode( nodeID ).setAttribute("y",VO + i * VO + RVD + (ctr % 2 == 0?0:-HO) );
                }

                graph.getNode( nodeID ).addAttribute("ui.label", nodeID );
//                graph.getNode( nodeID ).addAttribute("ui.color", Math.log(it.X * 2.5) );
                graph.getNode( nodeID ).addAttribute("ui.color", it.X );
                graph.getNode( nodeID ).addAttribute("ui.size", Math.log(it.X * 3) * NODE_SIZE);
                ctr++;
            }

            //ADD EDGES BETWEEN PARAMS (LABELS ARE LIKE "PID_FROM_TO" , e.g. "P1_2.45_3.56"
            // FROM MIN TO MAX
            for(Element it : elems)
            {
                String curr_e = String.valueOf(it.getKey());

                if( it.right != null )  // NO EDGE TO THE RIGHT
                {
                    String right_e =   String.valueOf(it.right.getKey());
                    String edgeID =  "A" + String.valueOf(i) + "_" + curr_e + "_" + right_e;
                    graph.addEdge( edgeID, "A"+ i + "_" + curr_e, "A"+ i + "_" + right_e );
                }

                // ADD EDGE TO Rs  A1_VAL_R_IF
                String N_ID = "A" + String.valueOf(i)+ "_" +curr_e;
                it.E.forEach((R_ID)->
                {
                    String R_ID_STR = "R_" + String.valueOf(R_ID);
                    graph.addEdge( N_ID + "_" + R_ID_STR,N_ID, R_ID_STR );
                });
            }
        }






        graph.display( false );
//        graph.display( );

//        try {
//            sleep(1000);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }



//        graph.removeNode("A4_2.0");
//        graph.getNode("A4_1.0").addAttribute("ui.style", "fill-color: rgb(255,0,0);");
//        graph.getNode("A4_1.0").addAttribute("ui.size",50);
//        graph.getNode("R_70").addAttribute("ui.size",50);
    }



    /////////////////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                                  NODES DELETION



    private  void deleteGraphNode( String nodeId )
    {
        graph.removeNode( nodeId );
    }

    public  boolean deleteNode( AGDS agds, int rowID )
    {

        deleteRowNode( rowID, agds.getR() );

        Row r = null;
        for (int i = 0; i < agds.getR().size(); i++)
        {
              if( agds.getR().get(i).id == rowID)
              {
                  r = agds.getR().get(i);
                  System.out.println("%%%%%");
                  break;
              }
            System.out.println("&*&*&*");
        }
        if( r == null) return false;

        // delete attr nodes
        for (int i = 0; i < agds.getN(); i++)
        {
            if( r.data.get( i ) != null)
            {
                ArrayList<Element<Double>> el_ar = agds.getA()[i].getSortedList();
                System.out.println("attr nodes " + i + " " + el_ar.size());
                deleteAttributeNode(r.data.get(i), i, el_ar  );
            }
            System.out.println("#####");
        }
        return true;


    }


    private  boolean deleteRowNode( int rowID, ArrayList<Row> R )
    {
        String nodeID = "R_" + String.valueOf( rowID );

        // IR ROW AT THE END JUST DELETE IT
        if( rowID == R.get( R.size() - 1 ).id )
        {
            deleteGraphNode( nodeID );
            return true;
        }
        deleteGraphNode( nodeID );


        // FIND RIGHT NEIGHBOUR
        for (int i = 0; i < R.size(); i++)
        {
            // IF FOUND
            if( R.get( i ).id == rowID )
            {
                // PUSH ALL RIGHT
                for (int j = i + 1; j < R.size(); j++)
                {
                    Row row = R.get(j);
                    String row_id = "R_" + String.valueOf( row.id );

                    int y = graph.getNode( row_id ).getAttribute("y");
                    int x = graph.getNode( row_id ).getAttribute("x");

                    graph.getNode( row_id ).setAttribute("x", x - HO );
                    graph.getNode( row_id ).setAttribute("y", y == 0?-HO:0  );
                }
                return true;
            }
        }

        return false;
    }



    private  boolean deleteAttributeNode( Double val, int attTreeID, ArrayList<Element<Double>> atts)
    {
        String nodeID =  "A" + String.valueOf(attTreeID) + "_" + String.valueOf(val);
        Element<Double> cur;
        for (int i = 0; i < atts.size(); i++)
        {
            cur = atts.get( i );
            // NODE TO DELETE FOUND
            if( cur.getKey().compareTo( val ) == 0 )
            {
                // nothing to delete
                if( cur.getCtr() > 1 ) return true;

                // is max element then just delete
                if( i == atts.size() - 1)
                {
                    deleteGraphNode( nodeID );
                    return true;
                }

                // push right nodes to the left
                deleteGraphNode( nodeID );
                for (int j = i + 1; j < atts.size(); j++)
                {
                    Element<Double> el  = atts.get(j);
                    String att_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(el.getKey());

                    int y = graph.getNode( att_id ).getAttribute("y");
                    int x = graph.getNode( att_id ).getAttribute("x");

                    graph.getNode( att_id ).setAttribute("x", x - HO );
                    graph.getNode( att_id ).setAttribute("y", ((y-RVD) % VO != 0?y+HO:y-HO)  );
                }

                // min elem so delete
                if(i == 0) return true;

                // create new edge between neighbours
                String left_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(i - 1).getKey());
                String right_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(i + 1).getKey());
                String edgeID =  "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(i - 1).getKey()) + "_" + String.valueOf(atts.get(i + 1).getKey());
                graph.addEdge(edgeID, left_id, right_id);
                System.out.println("@@@@ " + edgeID);
                return true;
            }
        }

        return false;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                                  PUTTING NEW NODES




    public  void putNode( int rowID, ArrayList<Row> R, AGDS agds )
    {
        String nodeID = "R_" + String.valueOf( rowID );
        // FIND RIGHT NEIGHBOUR
        for (int i = 0; i < R.size(); i++)
        {
            // IF FOUND PUT AT THE END OF ROWS
            if( R.get( i ).id == rowID )
            {
                String left_id;
                if( i == R.size() - 1 ) {
                    left_id = "R_" + String.valueOf( R.get(R.size() - 2).id );
                }
                else {
                    left_id = "R_" + String.valueOf( R.get(R.size() - 1).id );
                }

                System.out.println(left_id);
                int ctr = graph.getNode( left_id ).getAttribute("y");
                int x = graph.getNode( left_id ).getAttribute("x");

                // PUT AT THE END OF Rs
                graph.addNode(  nodeID );
//                    graph.getNode( nodeID ).setAttribute("xyz",x + HO, (ctr < 0 ?0:-HO),0 );
                graph.getNode( nodeID ).setAttribute("x",x + HO );
                graph.getNode( nodeID ).setAttribute("y", ctr  == 0? ctr-HO:0  );
                graph.getNode( nodeID ).addAttribute("ui.label", nodeID );
//                    graph.getNode( nodeID ).addAttribute("ui.color", R.get(i).X);
                graph.getNode( nodeID ).addAttribute("ui.color", 1.0);
//                    graph.getNode( nodeID ).addAttribute("ui.size", Math.log(R.get(i).X * 3) * NODE_SIZE);
                graph.getNode( nodeID ).addAttribute("ui.size",  1 * NODE_SIZE);



                for (int j = 0; j < R.get(i).data.size(); j++) {
                    if( R.get(i).data.get(j) != null )
                    {
                        putNewAttNode(
                                R.get(i).data.get(j),
                                j,
                                agds.getA()[j].getSortedList()

                        );
                        // CREATE EDGE FROM R TO NEW ATT NODE
                        // ADD EDGE TO Rs  A1_VAL_R_IF
                        String N_ID = "A" + String.valueOf(j)+ "_" + String.valueOf(  R.get(i).data.get(j) );
                        String R_ID_STR = "R_" + String.valueOf(rowID);
                        graph.addEdge( N_ID + "_" + R_ID_STR,N_ID, R_ID_STR ).addAttribute("ui.style", "fill-color: rgb(255,0,0);");

                    }
                }




            }
        }
    }

    private  void putNewAttNode( Double val, int attTreeID, ArrayList<Element<Double>> atts )
    {
        String nodeID =  "A" + String.valueOf(attTreeID) + "_" + String.valueOf(val);
        Element<Double> cur;
        Element<Double> left;
        Element<Double> right;
        int x,y;

        for (int i = 0; i < atts.size(); i++)
        {
            cur = atts.get( i );
            // NODE TO PUT FOUND
            if( cur.getKey().compareTo( val ) == 0 )
            {
                // node is already present o graph
                if( cur.getCtr() > 1 ) {
                    // COLOR THIS NODE GREEN
                    System.out.println("===============================");
                    String node_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(cur.getKey());
                    System.out.println(  graph.getNode( node_id ).getAttribute("ui.color").toString()  );
                    System.out.println(  graph.getNode( node_id ).getAttribute("ui.size").toString()  );
                    graph.getNode( node_id).addAttribute("ui.color", 0.5);
                    graph.getNode( node_id).addAttribute("ui.size", 10.0);
                    return;
                }

                // MAX VALUE PUT IT AT THE END
                if( i == atts.size() - 1 )
                {
                    left =  atts.get( i - 1 );

                    // create new edge and node
                    String left_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(left.getKey());
                    String right_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(cur.getKey());

                    // edhe to the right neoughbour
                    String edgeID =  "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(i - 1).getKey()) + "_" + String.valueOf(atts.get(i).getKey());

                    y = graph.getNode( left_id ).getAttribute("y");
                    x = graph.getNode( left_id ).getAttribute("x");

                    graph.addNode( right_id );
                    graph.getNode( right_id ).setAttribute("x", x + HO);
                    graph.getNode( right_id ).setAttribute("y", ((y - RVD) % VO != 0 ? y + HO:y-HO) );
                    graph.getNode( right_id ).addAttribute("ui.label", right_id );

                    graph.addEdge(edgeID, left_id, right_id).addAttribute("ui.style", "fill-color: rgb(0,0,255);");;
//                    graph.getEdge(edgeID).addAttribute("ui.style", "fill-color: rgb(0,0,255);");;
                    graph.getEdge(edgeID).addAttribute("ui.style", "size: 3px; fill-color: blue;");



                    return;
                }
                // MIN VALUE (just put it on the right) do not push all
                if( i == 0 )
                {
                    left = cur;
                    right = atts.get(i + 1);

                    // create new edge and node
                    String left_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(left.getKey());
                    String right_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(right.getKey());
                    String edgeID =  "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(0).getKey()) + "_" + String.valueOf(atts.get(i + 1).getKey());


                    y = graph.getNode( right_id ).getAttribute("y");
                    x = graph.getNode( right_id ).getAttribute("x");

                    graph.addNode( left_id );
                    graph.getNode( left_id ).setAttribute("x", x - HO);
                    graph.getNode( left_id ).setAttribute("y", ((y - RVD) % VO != 0 ? y + HO:y-HO) );
                    graph.getNode( left_id ).setAttribute("ui.label", left_id );

                    graph.addEdge(edgeID, left_id, right_id);
                    return;
                }

                left = cur;
                right = atts.get(i + 1);

                // PUSH ALL NODES RIGHT

                String right_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(i - 1).getKey());
                y  =  y = graph.getNode( right_id ).getAttribute("y");
                int ctr = 1; // lower
                if( (y - RVD) % VO != 0 ) ctr = 0; // upper

                for (int j = i+1; j < atts.size(); j++, ctr++)
                {
                    String cur_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf( atts.get( j ).getKey());
                    x = graph.getNode( cur_id ).getAttribute("x");
                    graph.getNode( cur_id ).setAttribute("x",x + HO );
                    graph.getNode( cur_id ).setAttribute("y", ctr % 2 == 0 ? y :y + HO);
                }

                // create new edge and node
                String left_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(left.getKey());
                right_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(right.getKey());
                String edgeID =  "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(i).getKey()) + "_" + String.valueOf(atts.get(i + 1).getKey());

                y = graph.getNode( right_id ).getAttribute("y");
                x = graph.getNode( right_id ).getAttribute("x");


                System.out.println( left_id + " " + right_id + " " +edgeID + " " + attTreeID );


                // edge from new node to right neighbour
                graph.addNode( left_id );
                graph.getNode( left_id ).setAttribute("x", x - HO);
                graph.getNode( left_id ).setAttribute("y", ((y - RVD) % VO != 0 ? y + HO:y-HO) );
                graph.getNode( left_id ).setAttribute( "ui.label", left_id );
                graph.addEdge(edgeID, left_id, right_id);

                // edge from new node to left neighbour
                right_id = left_id;
                left_id =  "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(i-1).getKey());
                right_id = "A" + String.valueOf(attTreeID) + "_" + String.valueOf(cur.getKey());
                edgeID =  "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(i-1).getKey()) + "_" + String.valueOf(cur.getKey());

                System.out.println("&&&&&" +  left_id + " " + right_id + " " +edgeID + " " + attTreeID );
                graph.addEdge(edgeID, left_id, right_id);

                // delete old edge from left and right neighbour
                edgeID =  "A" + String.valueOf(attTreeID) + "_" + String.valueOf(atts.get(i-1).getKey()) + "_" + String.valueOf(atts.get(i+1).getKey());
                graph.removeEdge(edgeID);

                return;
            }
        }
    }


    public  void removeColorsAndSizes()
    {
        graph.getNodeSet().forEach(node ->{
            if(node.hasAttribute("ui.color")) node.removeAttribute("ui.color");
            if(node.hasAttribute("ui.size")) node.setAttribute("ui.size",0.0);
            if(node.hasAttribute("ui.style")) node.removeAttribute("ui.style");
        });
        graph.getEdgeSet().forEach(edge ->{
            if(edge.hasAttribute("ui.color")) edge.removeAttribute("ui.color");
//            if(edge.hasAttribute("ui.size")) edge.setAttribute("ui.size",0.0);
            if(edge.hasAttribute("ui.style")) edge.setAttribute("ui.style", "size: 1px; fill-color: black;");
        });

    }


    // if AGDS contains rows which are not present on graph then add those nodes
    // if AGDS does not contain rows which are present on grpah then delete them
    public  void update(AGDS agds)
    {
        // ADD NEW ROWS IF NOT PRESENT
        for (int i = 0; i < agds.getR().size(); i++)
        {
            Row cur = agds.getR().get(i);
            if( graph.getNode("R_" + String.valueOf(cur.id)) == null )
            {
                System.out.println("NULL");
                putNode( cur.id, agds.getR(), agds );
            }
        }
        // DELETE ROWS IF NOT PRESENT

        Set<String> r_set = new HashSet<String>();
        for (int i = 0; i < agds.getR().size(); i++)
        {
            r_set.add( "R_" + agds.getR().get(i).id );
        }

        List<Node> nodes =  graph.getNodeSet().stream().filter(node -> node.getId().startsWith("R_") ).collect(Collectors.toList());


        for (int i = 0; i < nodes.size(); i++)
        {
            if( !r_set.contains( nodes.get(i).getId() ) )
            {
                deleteGraphNode( nodes.get(i).getId() );
//                int id = Integer.valueOf(nodes.get(i).getId().substring(2));
//                ;Node( agds, id);
            }
        }

        // REMOVE ORPHAN NODES - WITH ONLY ONE EDGE
        Iterator<Node> it= graph.getNodeIterator();
        while( it.hasNext() )
        {
            Node cur = it.next();
            System.out.println( cur.getId() + " " + cur.getInDegree() + " " + cur.getOutDegree() );
            cur.getEdgeSet().forEach(
                    edge -> {
                        System.out.println("   " + edge.getId() );
                    }
            );

            if( cur.getEdgeSet().size() <= 1 || ((cur.getOutDegree() + cur.getInDegree()) == 2) )
            {
                it.remove();
            }
            else if( cur.getOutDegree()  == 2 ) {
                boolean containsR = false;
                Iterator<Edge> e_it = cur.getEdgeSet().iterator();
                while (e_it.hasNext())
                {
                    if( e_it.next().getId().contains("R") ) containsR = true;
                }
                if( !containsR ) it.remove();
            }
        }
    }

    public boolean isDisplayed()
    {
        return this.isDisplayOn;
    }




    public static void main(String[] args) {
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

        GraphTest gt = new GraphTest();
        gt.printAGDS( agds );

        agds.removeR( 1 );
        agds.removeR( 5 );

        gt.update( agds );

//
//        agds.putNewRow( list.get(1) );
//        GraphTest.putNode( 1,agds.getR(), agds );
//
//        agds.putNewRow( list.get(5) );
//
//        GraphTest.update(agds);
//
//        GraphTest.putNode( 5,agds.getR(), agds );
//
//        GraphTest.removeColorsAndSizes();
    }
}
