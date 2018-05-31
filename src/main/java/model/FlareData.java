package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FlareData {

    private final SimpleIntegerProperty ID;
    private final SimpleStringProperty X;

    private final SimpleStringProperty LargestSpotSize;
    private final SimpleStringProperty SpotDistribution;

    private final SimpleIntegerProperty Activity;
    private final SimpleIntegerProperty Evolution;
    private final SimpleIntegerProperty Prev24Hour;
    private final SimpleIntegerProperty HistComplex;
    private final SimpleIntegerProperty BecomeHist;
    private final SimpleIntegerProperty Area;
    private final SimpleIntegerProperty C_class;
    private final SimpleIntegerProperty M_class;
    private final SimpleIntegerProperty X_class;

    private final SimpleStringProperty class_label;

    public FlareData(Integer ID, String x, String largestSpotSize, String spotDistribution, Integer activity, Integer evolution, Integer prev24Hour, Integer histComplex, Integer becomeHist, Integer area, Integer c_class, Integer m_class, Integer x_class, String class_label) {

        this.ID = new SimpleIntegerProperty( ID );
        X = new SimpleStringProperty( x );

        LargestSpotSize = new SimpleStringProperty( largestSpotSize );
        SpotDistribution = new SimpleStringProperty( spotDistribution );

        Activity = new SimpleIntegerProperty(activity);
        Evolution = new SimpleIntegerProperty(evolution);
        Prev24Hour = new SimpleIntegerProperty(prev24Hour);
        HistComplex = new SimpleIntegerProperty(histComplex);
        BecomeHist = new SimpleIntegerProperty(becomeHist);
        Area = new SimpleIntegerProperty(area);
        C_class = new SimpleIntegerProperty(c_class);
        M_class = new SimpleIntegerProperty(m_class);
        X_class = new SimpleIntegerProperty(x_class);

        this.class_label = new SimpleStringProperty(  class_label );
    }


    public FlareData(Integer ID, String x, Integer largestSpotSize, Integer spotDistribution, Integer activity, Integer evolution, Integer prev24Hour, Integer histComplex, Integer becomeHist, Integer area, Integer c_class, Integer m_class, Integer x_class, Integer class_label) {

        this.ID = new SimpleIntegerProperty( ID );
        X = new SimpleStringProperty( x );

        LargestSpotSize = new SimpleStringProperty( String.valueOf( (char)(largestSpotSize.intValue())  ));
        SpotDistribution = new SimpleStringProperty( String.valueOf( (char)(spotDistribution.intValue())  ));

        Activity = new SimpleIntegerProperty(activity);
        Evolution = new SimpleIntegerProperty(evolution);
        Prev24Hour = new SimpleIntegerProperty(prev24Hour);
        HistComplex = new SimpleIntegerProperty(histComplex);
        BecomeHist = new SimpleIntegerProperty(becomeHist);
        Area = new SimpleIntegerProperty(area);
        C_class = new SimpleIntegerProperty(c_class);
        M_class = new SimpleIntegerProperty(m_class);
        X_class = new SimpleIntegerProperty(x_class);

        this.class_label = new SimpleStringProperty(String.valueOf( (char)(class_label.intValue()) ));
    }



    public int getID() {
        return ID.get();
    }

    public SimpleIntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getX() {
        return X.get();
    }

    public SimpleStringProperty xProperty() {
        return X;
    }

    public void setX(String x) {
        this.X.set(x);
    }

    public String getLargestSpotSize() {
        return LargestSpotSize.get();
    }

    public SimpleStringProperty largestSpotSizeProperty() {
        return LargestSpotSize;
    }

    public void setLargestSpotSize(String largestSpotSize) {
        this.LargestSpotSize.set(largestSpotSize);
    }

    public String getSpotDistribution() {
        return SpotDistribution.get();
    }

    public SimpleStringProperty spotDistributionProperty() {
        return SpotDistribution;
    }

    public void setSpotDistribution(String spotDistribution) {
        this.SpotDistribution.set(spotDistribution);
    }

    public int getActivity() {
        return Activity.get();
    }

    public SimpleIntegerProperty activityProperty() {
        return Activity;
    }

    public void setActivity(int activity) {
        this.Activity.set(activity);
    }

    public int getEvolution() {
        return Evolution.get();
    }

    public SimpleIntegerProperty evolutionProperty() {
        return Evolution;
    }

    public void setEvolution(int evolution) {
        this.Evolution.set(evolution);
    }

    public int getPrev24Hour() {
        return Prev24Hour.get();
    }

    public SimpleIntegerProperty prev24HourProperty() {
        return Prev24Hour;
    }

    public void setPrev24Hour(int prev24Hour) {
        this.Prev24Hour.set(prev24Hour);
    }

    public int getHistComplex() {
        return HistComplex.get();
    }

    public SimpleIntegerProperty histComplexProperty() {
        return HistComplex;
    }

    public void setHistComplex(int histComplex) {
        this.HistComplex.set(histComplex);
    }

    public int getBecomeHist() {
        return BecomeHist.get();
    }

    public SimpleIntegerProperty becomeHistProperty() {
        return BecomeHist;
    }

    public void setBecomeHist(int becomeHist) {
        this.BecomeHist.set(becomeHist);
    }

    public int getArea() {
        return Area.get();
    }

    public SimpleIntegerProperty areaProperty() {
        return Area;
    }

    public void setArea(int area) {
        this.Area.set(area);
    }

    public int getC_class() {
        return C_class.get();
    }

    public SimpleIntegerProperty c_classProperty() {
        return C_class;
    }

    public void setC_class(int c_class) {
        this.C_class.set(c_class);
    }

    public int getM_class() {
        return M_class.get();
    }

    public SimpleIntegerProperty m_classProperty() {
        return M_class;
    }

    public void setM_class(int m_class) {
        this.M_class.set(m_class);
    }

    public int getX_class() {
        return X_class.get();
    }

    public SimpleIntegerProperty x_classProperty() {
        return X_class;
    }

    public void setX_class(int x_class) {
        this.X_class.set(x_class);
    }

    public String getClass_label() {
        return class_label.get();
    }

    public SimpleStringProperty class_labelProperty() {
        return class_label;
    }

    public void setClass_label(String class_label) {
        this.class_label.set(class_label);
    }
}
