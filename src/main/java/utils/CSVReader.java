package utils;

import agds.Row;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static ArrayList<Row> readDiabetesRetinopathyData()
    {
        String path = "/home/vm/Downloads/diabetic_retinopathy.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


        ArrayList< Row > rows = new ArrayList<Row>();
        int ctr = 0;
        try
        {
            br = new BufferedReader(new FileReader( path ));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] str_data = line.split(cvsSplitBy);
                ArrayList<Double> data = new ArrayList<>();
                for( String it : str_data )
                {
                    data.add( Double.valueOf( it ) );
                }
                rows.add( new Row(ctr, data) );
                System.out.print( ctr + " : ");
                for(Double it : data)
                {
                    System.out.print(it + " ");
                }
                System.out.println();
                ctr++;
            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return rows;
    }

    private static ArrayList<ArrayList<Double>> readDoubleData(String path)
    {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


        ArrayList<ArrayList<Double>> rows = new ArrayList<>();
        try
        {
            br = new BufferedReader(new FileReader( path ));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] str_data = line.split(cvsSplitBy);
                ArrayList<Double> data = new ArrayList<>();
                for( String it : str_data )
                {
                    data.add( Double.valueOf( it ) );
                }
                rows.add( data );

                for(Double it : data)
                {
                    System.out.print(it + " ");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return rows;
    }


    public static void main(String[] args) {

        CSVReader.readDiabetesRetinopathyData();

    }
}
