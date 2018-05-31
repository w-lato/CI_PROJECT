package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class VehiclesData {

    private final SimpleIntegerProperty ID;
    private final SimpleStringProperty X;

    private final SimpleIntegerProperty Compactness;
    private final SimpleIntegerProperty Circularity;
    private final SimpleIntegerProperty Distance_circularity;
    private final SimpleIntegerProperty Radius_ratio;
    private final SimpleIntegerProperty Praxis_aspec_ratio;
    private final SimpleIntegerProperty Max_length_aspect_ratio;
    private final SimpleIntegerProperty Scatter_ratio;
    private final SimpleIntegerProperty Elongatedness;
    private final SimpleIntegerProperty Praxis_rectangular;
    private final SimpleIntegerProperty Length_rectangular;
    private final SimpleIntegerProperty Major_variance;
    private final SimpleIntegerProperty Minor_variance;
    private final SimpleIntegerProperty Gyration_radius;
    private final SimpleIntegerProperty Major_skewness;
    private final SimpleIntegerProperty Minor_skewness;
    private final SimpleIntegerProperty Minor_kurtosis;
    private final SimpleIntegerProperty Major_kurtosis;
    private final SimpleIntegerProperty Hollows_ratio;

    // van | saab | bus
    private final SimpleStringProperty vehicle_class;

    public VehiclesData(Integer ID, String x, Integer compactness, Integer circularity, Integer distance_circularity, Integer radius_ratio, Integer praxis_aspec_ratio, Integer max_length_aspect_ratio, Integer scatter_ratio, Integer elongatedness, Integer praxis_rectangular, Integer length_rectangular, Integer major_variance, Integer minor_variance, Integer gyration_radius, Integer major_skewness, Integer minor_skewness, Integer minor_kurtosis, Integer major_kurtosis, Integer hollows_ratio, Integer vehicle_class) {
        this.ID = new SimpleIntegerProperty(ID);
        this.X = new SimpleStringProperty( x );

        this.Compactness = new SimpleIntegerProperty( compactness );
        this.Circularity = new SimpleIntegerProperty( circularity );
        this.Distance_circularity =  new SimpleIntegerProperty(  distance_circularity);
        this.Radius_ratio =  new SimpleIntegerProperty( radius_ratio);
        this.Praxis_aspec_ratio =  new SimpleIntegerProperty(  praxis_aspec_ratio);
        this.Max_length_aspect_ratio =  new SimpleIntegerProperty( max_length_aspect_ratio);
        this.Scatter_ratio =  new SimpleIntegerProperty( scatter_ratio);
        this.Elongatedness =  new SimpleIntegerProperty( elongatedness);
        this.Praxis_rectangular =  new SimpleIntegerProperty( praxis_rectangular);
        this.Length_rectangular = new SimpleIntegerProperty(  length_rectangular);
        this.Major_variance =  new SimpleIntegerProperty( major_variance);
        this.Minor_variance =  new SimpleIntegerProperty( minor_variance);
        this.Gyration_radius =  new SimpleIntegerProperty( gyration_radius);
        this.Major_skewness =  new SimpleIntegerProperty( major_skewness);
        this.Minor_skewness =  new SimpleIntegerProperty( minor_skewness);
        this.Minor_kurtosis =  new SimpleIntegerProperty( minor_kurtosis);
        this.Major_kurtosis =  new SimpleIntegerProperty( major_kurtosis);
        this.Hollows_ratio =  new SimpleIntegerProperty( hollows_ratio);

//        this.vehicle_class = new SimpleStringProperty( vehicle_class );
        switch ( vehicle_class ){
            case 0 : this.vehicle_class = new SimpleStringProperty( "saab" ); break;
            case 1 : this.vehicle_class = new SimpleStringProperty( "van" ); break;
            case 2 : this.vehicle_class = new SimpleStringProperty( "bus" ); break;
            default: this.vehicle_class = new SimpleStringProperty( "opel" ); break;
        }
    }

    public VehiclesData(Integer ID, String x, Integer compactness, Integer circularity, Integer distance_circularity, Integer radius_ratio, Integer praxis_aspec_ratio, Integer max_length_aspect_ratio, Integer scatter_ratio, Integer elongatedness, Integer praxis_rectangular, Integer length_rectangular, Integer major_variance, Integer minor_variance, Integer gyration_radius, Integer major_skewness, Integer minor_skewness, Integer minor_kurtosis, Integer major_kurtosis, Integer hollows_ratio, String vehicle_class) {
        this.ID = new SimpleIntegerProperty(ID);
        this.X = new SimpleStringProperty( x );

        this.Compactness = new SimpleIntegerProperty( compactness );
        this.Circularity = new SimpleIntegerProperty( circularity );
        this.Distance_circularity =  new SimpleIntegerProperty(  distance_circularity);
        this.Radius_ratio =  new SimpleIntegerProperty( radius_ratio);
        this.Praxis_aspec_ratio =  new SimpleIntegerProperty(  praxis_aspec_ratio);
        this.Max_length_aspect_ratio =  new SimpleIntegerProperty( max_length_aspect_ratio);
        this.Scatter_ratio =  new SimpleIntegerProperty( scatter_ratio);
        this.Elongatedness =  new SimpleIntegerProperty( elongatedness);
        this.Praxis_rectangular =  new SimpleIntegerProperty( praxis_rectangular);
        this.Length_rectangular = new SimpleIntegerProperty(  length_rectangular);
        this.Major_variance =  new SimpleIntegerProperty( major_variance);
        this.Minor_variance =  new SimpleIntegerProperty( minor_variance);
        this.Gyration_radius =  new SimpleIntegerProperty( gyration_radius);
        this.Major_skewness =  new SimpleIntegerProperty( major_skewness);
        this.Minor_skewness =  new SimpleIntegerProperty( minor_skewness);
        this.Minor_kurtosis =  new SimpleIntegerProperty( minor_kurtosis);
        this.Major_kurtosis =  new SimpleIntegerProperty( major_kurtosis);
        this.Hollows_ratio =  new SimpleIntegerProperty( hollows_ratio);

        this.vehicle_class = new SimpleStringProperty( vehicle_class );
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

    public int getCompactness() {
        return Compactness.get();
    }

    public SimpleIntegerProperty compactnessProperty() {
        return Compactness;
    }

    public void setCompactness(int compactness) {
        this.Compactness.set(compactness);
    }

    public int getCircularity() {
        return Circularity.get();
    }

    public SimpleIntegerProperty circularityProperty() {
        return Circularity;
    }

    public void setCircularity(int circularity) {
        this.Circularity.set(circularity);
    }

    public int getDistance_circularity() {
        return Distance_circularity.get();
    }

    public SimpleIntegerProperty distance_circularityProperty() {
        return Distance_circularity;
    }

    public void setDistance_circularity(int distance_circularity) {
        this.Distance_circularity.set(distance_circularity);
    }

    public int getRadius_ratio() {
        return Radius_ratio.get();
    }

    public SimpleIntegerProperty radius_ratioProperty() {
        return Radius_ratio;
    }

    public void setRadius_ratio(int radius_ratio) {
        this.Radius_ratio.set(radius_ratio);
    }

    public int getPraxis_aspec_ratio() {
        return Praxis_aspec_ratio.get();
    }

    public SimpleIntegerProperty praxis_aspec_ratioProperty() {
        return Praxis_aspec_ratio;
    }

    public void setPraxis_aspec_ratio(int praxis_aspec_ratio) {
        this.Praxis_aspec_ratio.set(praxis_aspec_ratio);
    }

    public int getMax_length_aspect_ratio() {
        return Max_length_aspect_ratio.get();
    }

    public SimpleIntegerProperty max_length_aspect_ratioProperty() {
        return Max_length_aspect_ratio;
    }

    public void setMax_length_aspect_ratio(int max_length_aspect_ratio) {
        this.Max_length_aspect_ratio.set(max_length_aspect_ratio);
    }

    public int getScatter_ratio() {
        return Scatter_ratio.get();
    }

    public SimpleIntegerProperty scatter_ratioProperty() {
        return Scatter_ratio;
    }

    public void setScatter_ratio(int scatter_ratio) {
        this.Scatter_ratio.set(scatter_ratio);
    }

    public int getElongatedness() {
        return Elongatedness.get();
    }

    public SimpleIntegerProperty elongatednessProperty() {
        return Elongatedness;
    }

    public void setElongatedness(int elongatedness) {
        this.Elongatedness.set(elongatedness);
    }

    public int getPraxis_rectangular() {
        return Praxis_rectangular.get();
    }

    public SimpleIntegerProperty praxis_rectangularProperty() {
        return Praxis_rectangular;
    }

    public void setPraxis_rectangular(int praxis_rectangular) {
        this.Praxis_rectangular.set(praxis_rectangular);
    }

    public int getLength_rectangular() {
        return Length_rectangular.get();
    }

    public SimpleIntegerProperty length_rectangularProperty() {
        return Length_rectangular;
    }

    public void setLength_rectangular(int length_rectangular) {
        this.Length_rectangular.set(length_rectangular);
    }

    public int getMajor_variance() {
        return Major_variance.get();
    }

    public SimpleIntegerProperty major_varianceProperty() {
        return Major_variance;
    }

    public void setMajor_variance(int major_variance) {
        this.Major_variance.set(major_variance);
    }

    public int getMinor_variance() {
        return Minor_variance.get();
    }

    public SimpleIntegerProperty minor_varianceProperty() {
        return Minor_variance;
    }

    public void setMinor_variance(int minor_variance) {
        this.Minor_variance.set(minor_variance);
    }

    public int getGyration_radius() {
        return Gyration_radius.get();
    }

    public SimpleIntegerProperty gyration_radiusProperty() {
        return Gyration_radius;
    }

    public void setGyration_radius(int gyration_radius) {
        this.Gyration_radius.set(gyration_radius);
    }

    public int getMajor_skewness() {
        return Major_skewness.get();
    }

    public SimpleIntegerProperty major_skewnessProperty() {
        return Major_skewness;
    }

    public void setMajor_skewness(int major_skewness) {
        this.Major_skewness.set(major_skewness);
    }

    public int getMinor_skewness() {
        return Minor_skewness.get();
    }

    public SimpleIntegerProperty minor_skewnessProperty() {
        return Minor_skewness;
    }

    public void setMinor_skewness(int minor_skewness) {
        this.Minor_skewness.set(minor_skewness);
    }

    public int getMinor_kurtosis() {
        return Minor_kurtosis.get();
    }

    public SimpleIntegerProperty minor_kurtosisProperty() {
        return Minor_kurtosis;
    }

    public void setMinor_kurtosis(int minor_kurtosis) {
        this.Minor_kurtosis.set(minor_kurtosis);
    }

    public int getMajor_kurtosis() {
        return Major_kurtosis.get();
    }

    public SimpleIntegerProperty major_kurtosisProperty() {
        return Major_kurtosis;
    }

    public void setMajor_kurtosis(int major_kurtosis) {
        this.Major_kurtosis.set(major_kurtosis);
    }

    public int getHollows_ratio() {
        return Hollows_ratio.get();
    }

    public SimpleIntegerProperty hollows_ratioProperty() {
        return Hollows_ratio;
    }

    public void setHollows_ratio(int hollows_ratio) {
        this.Hollows_ratio.set(hollows_ratio);
    }

    public String getVehicle_class() {
        return vehicle_class.get();
    }

    public SimpleStringProperty vehicle_classProperty() {
        return vehicle_class;
    }

    public void setVehicle_class(String vehicle_class) {
        this.vehicle_class.set(vehicle_class);
    }
}
