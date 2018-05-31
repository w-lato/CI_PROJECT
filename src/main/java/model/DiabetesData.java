package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DiabetesData {

    private final SimpleIntegerProperty ID;
    private final SimpleStringProperty X;

    // or boolean
    private final SimpleStringProperty quality;
    private final SimpleStringProperty pre_screening;

    private final SimpleStringProperty MAdetect1;
    private final SimpleStringProperty MAdetect2;
    private final SimpleStringProperty MAdetect3;
    private final SimpleStringProperty MAdetect4;
    private final SimpleStringProperty MAdetect5;
    private final SimpleStringProperty MAdetect6;
    private final SimpleStringProperty MAdetect7;

    private final SimpleStringProperty MAdetect8;
    private final SimpleStringProperty MAdetect9;
    private final SimpleStringProperty MAdetect10;
    private final SimpleStringProperty MAdetect11;
    private final SimpleStringProperty MAdetect12;
    private final SimpleStringProperty MAdetect13;
    private final SimpleStringProperty MAdetect14;

    private final SimpleStringProperty distance_from_macula;
    private final SimpleStringProperty diameter_of_optic_disc;

    private final SimpleStringProperty amfm_verification;
    private final SimpleStringProperty class_label;




    public DiabetesData(Integer id, String X, String quiality, String pre_screening, String MAdetect1, String MAdetect2, String MAdetect3, String MAdetect4, String MAdetect5, String MAdetect6, String MAdetect7, String MAdetect8, String MAdetect9, String MAdetect10, String MAdetect11, String MAdetect12, String MAdetect13, String MAdetect14, String distance_from_macula, String diameter_of_optic_disc, String amfm_verification, String class_label) {
        this.ID = new SimpleIntegerProperty(id);
        this.X = new SimpleStringProperty(X);
        this.quality = new SimpleStringProperty(quiality);
        this.pre_screening = new SimpleStringProperty(pre_screening);
        this.MAdetect1 = new SimpleStringProperty(MAdetect1);
        this.MAdetect2 = new SimpleStringProperty(MAdetect2);
        this.MAdetect3 = new SimpleStringProperty(MAdetect3);
        this.MAdetect4 = new SimpleStringProperty(MAdetect4);
        this.MAdetect5 = new SimpleStringProperty(MAdetect5);
        this.MAdetect6 = new SimpleStringProperty(MAdetect6);
        this.MAdetect7 = new SimpleStringProperty(MAdetect7);
        this.MAdetect8 = new SimpleStringProperty(MAdetect8);
        this.MAdetect9 = new SimpleStringProperty(MAdetect9);
        this.MAdetect10 = new SimpleStringProperty(MAdetect10);
        this.MAdetect11 = new SimpleStringProperty(MAdetect11);
        this.MAdetect12 = new SimpleStringProperty(MAdetect12);
        this.MAdetect13 = new SimpleStringProperty(MAdetect13);
        this.MAdetect14 = new SimpleStringProperty(MAdetect14);
        this.distance_from_macula = new SimpleStringProperty(distance_from_macula);
        this.diameter_of_optic_disc = new SimpleStringProperty(diameter_of_optic_disc);
        this.amfm_verification = new SimpleStringProperty(amfm_verification);
        this.class_label = new SimpleStringProperty(class_label);
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

    public String getQuality() {
        return quality.get();
    }

    public SimpleStringProperty qualityProperty() {
        return quality;
    }

    public void setQuality(String quiality) {
        this.quality.set(quiality);
    }

    public String getPre_screening() {
        return pre_screening.get();
    }

    public SimpleStringProperty pre_screeningProperty() {
        return pre_screening;
    }

    public void setPre_screening(String pre_screening) {
        this.pre_screening.set(pre_screening);
    }

    public String getMAdetect1() {
        return MAdetect1.get();
    }

    public SimpleStringProperty MAdetect1Property() {
        return MAdetect1;
    }

    public void setMAdetect1(String MAdetect1) {
        this.MAdetect1.set(MAdetect1);
    }

    public String getMAdetect2() {
        return MAdetect2.get();
    }

    public SimpleStringProperty MAdetect2Property() {
        return MAdetect2;
    }

    public void setMAdetect2(String MAdetect2) {
        this.MAdetect2.set(MAdetect2);
    }

    public String getMAdetect3() {
        return MAdetect3.get();
    }

    public SimpleStringProperty MAdetect3Property() {
        return MAdetect3;
    }

    public void setMAdetect3(String MAdetect3) {
        this.MAdetect3.set(MAdetect3);
    }

    public String getMAdetect4() {
        return MAdetect4.get();
    }

    public SimpleStringProperty MAdetect4Property() {
        return MAdetect4;
    }

    public void setMAdetect4(String MAdetect4) {
        this.MAdetect4.set(MAdetect4);
    }

    public String getMAdetect5() {
        return MAdetect5.get();
    }

    public SimpleStringProperty MAdetect5Property() {
        return MAdetect5;
    }

    public void setMAdetect5(String MAdetect5) {
        this.MAdetect5.set(MAdetect5);
    }

    public String getMAdetect6() {
        return MAdetect6.get();
    }

    public SimpleStringProperty MAdetect6Property() {
        return MAdetect6;
    }

    public void setMAdetect6(String MAdetect6) {
        this.MAdetect6.set(MAdetect6);
    }

    public String getMAdetect7() {
        return MAdetect7.get();
    }

    public SimpleStringProperty MAdetect7Property() {
        return MAdetect7;
    }

    public void setMAdetect7(String MAdetect7) {
        this.MAdetect7.set(MAdetect7);
    }

    public String getMAdetect8() {
        return MAdetect8.get();
    }

    public SimpleStringProperty MAdetect8Property() {
        return MAdetect8;
    }

    public void setMAdetect8(String MAdetect8) {
        this.MAdetect8.set(MAdetect8);
    }

    public String getMAdetect9() {
        return MAdetect9.get();
    }

    public SimpleStringProperty MAdetect9Property() {
        return MAdetect9;
    }

    public void setMAdetect9(String MAdetect9) {
        this.MAdetect9.set(MAdetect9);
    }

    public String getMAdetect10() {
        return MAdetect10.get();
    }

    public SimpleStringProperty MAdetect10Property() {
        return MAdetect10;
    }

    public void setMAdetect10(String MAdetect10) {
        this.MAdetect10.set(MAdetect10);
    }

    public String getMAdetect11() {
        return MAdetect11.get();
    }

    public SimpleStringProperty MAdetect11Property() {
        return MAdetect11;
    }

    public void setMAdetect11(String MAdetect11) {
        this.MAdetect11.set(MAdetect11);
    }

    public String getMAdetect12() {
        return MAdetect12.get();
    }

    public SimpleStringProperty MAdetect12Property() {
        return MAdetect12;
    }

    public void setMAdetect12(String MAdetect12) {
        this.MAdetect12.set(MAdetect12);
    }

    public String getMAdetect13() {
        return MAdetect13.get();
    }

    public SimpleStringProperty MAdetect13Property() {
        return MAdetect13;
    }

    public void setMAdetect13(String MAdetect13) {
        this.MAdetect13.set(MAdetect13);
    }

    public String getMAdetect14() {
        return MAdetect14.get();
    }

    public SimpleStringProperty MAdetect14Property() {
        return MAdetect14;
    }

    public void setMAdetect14(String MAdetect14) {
        this.MAdetect14.set(MAdetect14);
    }

    public String getDistance_from_macula() {
        return distance_from_macula.get();
    }

    public SimpleStringProperty distance_from_maculaProperty() {
        return distance_from_macula;
    }

    public void setDistance_from_macula(String distance_from_macula) {
        this.distance_from_macula.set(distance_from_macula);
    }

    public String getDiameter_of_optic_disc() {
        return diameter_of_optic_disc.get();
    }

    public SimpleStringProperty diameter_of_optic_discProperty() {
        return diameter_of_optic_disc;
    }

    public void setDiameter_of_optic_disc(String diameter_of_optic_disc) {
        this.diameter_of_optic_disc.set(diameter_of_optic_disc);
    }

    public String getAmfm_verification() {
        return amfm_verification.get();
    }

    public SimpleStringProperty amfm_verificationProperty() {
        return amfm_verification;
    }

    public void setAmfm_verification(String amfm_verification) {
        this.amfm_verification.set(amfm_verification);
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

    public static void main(String[] args) {
        for (int i = 1; i < 15; i++) {
            System.out.println("TableColumn maCol" + i +" = new TableColumn(\"MADetect" + i + "\");");
            System.out.println("maCol" + i + ".setMinWidth(100);");
            System.out.println("maCol"+ i + ".setCellValueFactory(");
            System.out.println("        new PropertyValueFactory<DiabetesData, String>(\"MAdetect" + i +"\"));");
            System.out.println();
        }
    }
}
