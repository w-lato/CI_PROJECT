package agds;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import t.agds.Element;
import t.agds.Node;
import t.agds.Tree;
import utils.CSVReader;
import utils.XLSParser;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class AGDS {

    //NUMBER OF PARAMS
    int N = 4; // test for iris data

    // EDGES from VALUES IN SPECIFIED SET TO Rs
   // HashMap<Double,ArrayList<Integer>>[] E;

    Tree<Double>[] A;
    ArrayList<Row> R;


    // MAX - MIN
    public Double[] param_range;


    public AGDS() {
    }

    public AGDS(ArrayList<Row> r) {
        this.createAGDS( r );
    }

    private void createAGDS( ArrayList<Row> data ) {

        R = data;

        this.N = R.get(0).data.size();
        A = new Tree[N];
        for (int i = 0; i < N; i++)
            A[i] = new Tree<Double>();


        // PUT DATA IN ATTRIBUTE'S TREE
        for( Row it : R )
        {
            for (int i = 0; i < N; i++)
            {
                A[i].insert( it.data.get( i ) );
            }
        }

        // FILL EDGES AND NEIGHBORS OF EVERY ELEM IN ATTR'S TREE
        for (int i = 0; i < N; i++) {
            System.out.println( i );
            A[i].addEdgesToNodes( R, i );
            A[i].setNeighbors();
        }

        // CALCULATE PARAM RANGES
        this.param_range = new Double[this.N];
        for (int i = 0; i < this.N; i++)
        {
            Double min = A[i].getMin().getKey();
            Double max = A[i].getMax().getKey();
            param_range[i] = max - min;
        }
    }

    public void loadDiabetesData()
    {
        this.R = CSVReader.readDiabetesRetinopathyData();
        this.N = R.get(0).data.size();

        A = new Tree[N];
        for (int i = 0; i < N; i++)
            A[i] = new Tree<Double>();


        // PUT DATA IN ATTRIBUTE'S TREE
        for( Row it : R )
        {
            for (int i = 0; i < N; i++)
            {
                A[i].insert( it.data.get( i ) );
            }
        }

        // FILL EDGES OF EVERY ELEM IN ATTR'S TREE
        for (int i = 0; i < N; i++) {
            A[i].addEdgesToNodes( R, i );
        }

    }

    public void loadIrisData()
    {

        String path = "/home/vm/Downloads/IrisDataTrain.xls";
        XLSParser parser = new XLSParser();

        parser.readIrisTrainingValues(path);
        parser.stringToIntClasses();


        R = new ArrayList<Row>();
        for (int i = 0; i < parser.rows.size(); i++)
        {
            ArrayList<Double> aux = new ArrayList<>();
            for (int j = 0; j < parser.rows.get(0).size(); j++)
            {
                aux.add( parser.rows.get(i).get(j) );
            }
            aux.add( Double.valueOf(parser.int_classes.get(i)) );

            R.add(new Row( i, aux ));
        }

        this.N = R.get(0).data.size();
        A = new Tree[N];
        for (int i = 0; i < N; i++)
            A[i] = new Tree<Double>();


        // PUT DATA IN ATTRIBUTE'S TREE
        for( Row it : R )
        {
            for (int i = 0; i < N; i++)
            {
                A[i].insert( it.data.get( i ) );
            }
        }

        // FILL EDGES AND NEIGHBORS OF EVERY ELEM IN ATTR'S TREE
        for (int i = 0; i < N; i++) {
            System.out.println( i );
            A[i].addEdgesToNodes( R, i );
            A[i].setNeighbors();
        }

        // CALCULATE PARAM RANGES
        this.param_range = new Double[this.N];
        for (int i = 0; i < this.N; i++)
        {
            Double min = A[i].getMin().getKey();
            Double max = A[i].getMax().getKey();
            param_range[i] = max - min;
            System.out.println(i + " : min " + min + " max " + max);
        }

    }

    public void printParams() {

        for (int i = 0; i < N; i++) {
            System.out.println();
            ArrayList<Element<Double>> l = A[i].getSortedList();

            for(Element<Double> it : l  )
            {
                System.out.printf("%2f : ", it.getKey());
                it.E.forEach( (R_ID)-> {
                    System.out.print(R_ID  + "  ");
                } );
                System.out.println();
            }
            System.out.println();
            System.out.println();

        }

    }

    public void printRs()
    {
        for( Row it : R )
        {
            System.out.printf("%4d : ",it.id );
            for (int i = 0; i < it.data.size(); i++) {
                System.out.print(it.data.get( i ) + "  ");
            }
            System.out.println();
        }
    }

    public void printSimilarRs() {

        ArrayList<Row> sorted = new ArrayList<Row>();
        for (int i = 0; i < R.size(); i++) {
            sorted.add( R.get(i) );
        }

        sorted.sort((Row r1, Row r2) -> {
            if (r1.X > r2.X)
                return 1;
            if (r1.X < r2.X)
                return -1;
            return 0;
        });

        System.out.printf(" SIM :  ID  : VAL\r\n");
        for (int i = sorted.size() - 1; i >= 0; i--)
        {
            System.out.printf("%4d : %4d : %f \r\n", sorted.size() - i, sorted.get(i).id, sorted.get(i).X);
//            System.out.println(sorted.size() - i  +" : " + " : " + sorted.get(i).id + " x: " + sorted.get(i).X);
        }

    }

    public void printStats()
    {
        //ITERATE OVER ATTRIBUTES TREE
        for (int i = 0; i < this.N; i++)
        {
            Element<Double> sum = A[i].getSum();
            Element<Double> avg = A[i].getAvg();
            Element<Double> min = A[i].getMin();
            Element<Double> max = A[i].getMax();

            System.out.println("PARAM " + i);
            System.out.println();
            System.out.println("SUM OF VALS     : " + sum.getKey());
            System.out.println("COUNT           : " + sum.getCtr());
            System.out.println("AVERGAE OF VALS : " + avg.getKey());
            System.out.println("NUM OF UNIQ VALS /  COUNT : " + avg.getCtr());
            System.out.println("MAX  : " + max.getKey());
            System.out.println("MIN  : " + min.getKey());
            System.out.println();
        }


    }


    public void printStatsOfClass(Double C_ID)
    {
        // GET ELEM WHICH IS CONNECTED TO ALL Rs FROM GIVEN CLASS
        Element<Double> e = A[ this.N - 1 ].getElem( C_ID );

        ArrayList<Row> l = new ArrayList<>();
        e.E.forEach((R_ID)-> {
            l.add( R.get( R_ID ) );
        });

        // CREATE A TREE FROM OBTAINED Rs
        AGDS agds = new AGDS( l );
        agds.printStats();

    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          ASSOCIATION METHODS



    // CALCULATE ASSOCIATIONS FROM GIVEN R ID
    public void associateFrom( int R_ID )
    {
        // ZERO Xs FROM EVERY ATTR TREE
        for (int i = 0; i < N; i++)
        {
            A[i].resetALlX();
        }
        for(Row it : R)
        {
            it.X = 0.0;
        }

        Row SRC = R.get( R_ID );
        // find all vals associated to given R and set X = 1 and calculated all lefts and rigts
        // and then add weights to connected Rs
        for (int i = 0; i < N; i++)
        {
            if( SRC.data.get( i ) != null ) iterateOverGroup( SRC.data.get( i ), i );
        }

    }


    private void iterateOverGroup( Double srcVal, int groupID )
    {
        // SET 1 TO START NODE AND ADD VALUES TO ALL Rs CONNECTED
        Element aux = A[ groupID ].getElem( srcVal );
        Element src = aux;
        src.X = 1.0;
        addWeightsToR( src );

        //if( groupID == N - 1 ) return;

        Double prevX = src.X;
        Double prevVal = (Double)src.getKey();

        // PROPAGATE NEIGHBOURS TO THE LEFT
        while( src.left != null )
        {
            src = src.left;
            src.X = prevX * ( 1.0 -  Math.abs(prevVal - (Double)src.getKey()) / param_range[groupID]  );
            addWeightsToR( src );
            prevX = src.X;
            prevVal = (Double)src.getKey();
        }

        // PROPAGATE NEIGHBOURS TO THE LEFT
        src = aux;
        prevX = src.X;
        prevVal = (Double)src.getKey();

        while( src.right != null )
        {
            src = src.right;
            src.X = prevX * ( 1.0 -  Math.abs(prevVal - (Double)src.getKey()) / param_range[groupID]  );
            addWeightsToR( src );
            prevX = src.X;
            prevVal = (Double)src.getKey();
        }


    }

    private void addWeightsToR(Element el)
    {
        el.E.forEach((R_ID)->
        {
            R.get( (int)R_ID ).X += el.X / this.N;
        });

    }

    public void putNewRow( Row r ) {

        this.R.add( r );
        for (int i = 0; i < r.data.size(); i++)
        {
            // OMIT MISSING VALUES
            if( r.data.get( i ) != null )
            {
                A[i].insert( r.data.get(i) );
            }
        }

        // FILL EDGES AND NEIGHBORS OF EVERY ELEM IN ATTR'S TREE
        for (int i = 0; i < N; i++)
        {
            if( r.data.get( i ) != null )
            {
                A[i].addEdgesToNodes( R, i );
                A[i].setNeighbors();
            }
        }

        // CALCULATE PARAM RANGES
        for (int i = 0; i < this.N; i++)
        {
            if( r.data.get( i ) != null )
            {
                Double min = A[i].getMin().getKey();
                Double max = A[i].getMax().getKey();
                param_range[i] = max - min;
            }
        }

    }

    public void predicValuesFor( Row r)
    {
        putNewRow( r );

        // LAST INSERTED ELEM
        associateFrom( R.size() - 1 );

        printSimilarRs();

        // TAKE MOST SIMILAR VALUES
        ArrayList<Row> sorted = new ArrayList<Row>();
        for (int i = 0; i < R.size(); i++) {
            sorted.add( R.get(i) );
        }

        sorted.sort((Row r1, Row r2) -> {
            if (r1.X > r2.X)
                return 1;
            if (r1.X < r2.X)
                return -1;
            return 0;
        });

        Double sim_sum = 0.0;
        Double sum = 0.0;
        int ctr = 0;
//        for (int i = R.size() - 2; i > R.size() - 15 ; i--) {
//            sim_sum += sorted.get( i ).X;
//            ctr++;
//        }
//
//        for (int i = R.size() - 2; i > R.size() - 15 ; i--) {
//            sum += sorted.get( i ).X / sim_sum * sorted.get( i ).data.get( 1 );
//        }
        for (int i = R.size() - 2; i > R.size() - 14 ; i--) {
            sum += sorted.get( i ).data.get( 1 );
            ctr++;
        }
        sum = sum / ctr;

        System.out.println("predicted value of 2.7 is: " + sum + "  so " + (100 - 2.7 / sum * 100.0) + "% miss");

    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //
    //
    //                          GETTERS AND SETTERS


    public static void main(String[] args)
    {
        AGDS agds = new AGDS();
        //        agds.loadDiabetesData();
        agds.loadIrisData();
        agds.printRs();
        agds.associateFrom( 0 );
        System.out.println(" done ");
        agds.printSimilarRs();
        //agds.printParams();

        for (int i = 0; i < agds.N; i++) {
            System.out.println( agds.param_range[i] );
        }

        agds.printStats();
        agds.printStatsOfClass( 0.0 );

        Row r = new Row(127,
                new ArrayList<Double>() {{ // 102
            add(5.8);
//            add(2.7);
            add(null);
            add(5.1);
//            add(1.9);
            add(1.9);
//            add(2.0);
            add(null);
        }}
        );
        agds.predicValuesFor( r );

    }
}

