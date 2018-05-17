package agds;

import java.util.ArrayList;

public class Row {

    public final int id;

    public Double X = 0.0;

    //DATA OF ROW
    public final ArrayList<Double> data;

    public Row(int id, ArrayList<Double> data)
    {
        this.id = id;
        this.data = new ArrayList<>();

        for(Double it : data )
        {
            this.data.add(it);
        }
    }
}
