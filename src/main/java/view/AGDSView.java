package view;

import agds.AGDS;
import agds.Row;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.DiabetesData;
import model.FlareData;
import model.VehiclesData;
import t.agds.Element;
import utils.CSVReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;

public class AGDSView extends Application {

    Scene scene;
    private AGDS agds;
    public GraphTest graph = new GraphTest();

    // DIABETES
    private TableView<DiabetesData> table = new TableView<DiabetesData>();
    private final ObservableList<DiabetesData> data = FXCollections.observableArrayList();


    // VEHICLES
    private TableView<VehiclesData> vehiclesTable = new TableView<VehiclesData>();
    private final ObservableList<VehiclesData> vehiclesData = FXCollections.observableArrayList();

    // FLARES
    private TableView<FlareData> flareTable = new TableView<FlareData>();
    private final ObservableList<FlareData> flareData = FXCollections.observableArrayList();

//    private final ObservableList<DiabetesData> data; = FXCollections.observableArrayList();




    private void initDiabetesData() {
        ArrayList<Row> list = CSVReader.readDiabetesRetinopathyData();

        agds = new AGDS(list);


        for (int i = 0; i < list.size(); i++)
        {
            data.add(
                    new DiabetesData(
                            Integer.valueOf(list.get(i).id),
                        String.valueOf(list.get(i).X),
                        String.valueOf(list.get(i).data.get(0)),
                        String.valueOf(list.get(i).data.get(1)),
                        String.valueOf(list.get(i).data.get(2)),
                        String.valueOf(list.get(i).data.get(3)),
                        String.valueOf(list.get(i).data.get(4)),
                        String.valueOf(list.get(i).data.get(5)),
                        String.valueOf(list.get(i).data.get(6)),
                        String.valueOf(list.get(i).data.get(7)),
                        String.valueOf(list.get(i).data.get(8)),
                        String.valueOf(list.get(i).data.get(9)),
                        String.valueOf(list.get(i).data.get(10)),
                        String.valueOf(list.get(i).data.get(11)),
                        String.valueOf(list.get(i).data.get(12)),
                        String.valueOf(list.get(i).data.get(13)),
                        String.valueOf(list.get(i).data.get(14)),
                        String.valueOf(list.get(i).data.get(15)),
                        String.valueOf(list.get(i).data.get(16)),
                        String.valueOf(list.get(i).data.get(17)),
                        String.valueOf(list.get(i).data.get(18)),
                        String.valueOf(list.get(i).data.get(18))
                    )
            );
        }
    }

    private void initVehiclesData() {
        ArrayList<Row> list = CSVReader.readVehiclesData();

        agds = new AGDS(list);

        for (int i = 0; i < list.size(); i++)
        {
            vehiclesData.add(
                    new VehiclesData(
                            Integer.valueOf(list.get(i).id),
                            String.valueOf(list.get(i).X),
                            list.get(i).data.get(0).intValue(),
                            list.get(i).data.get(1).intValue(),
                            list.get(i).data.get(2).intValue(),
                            list.get(i).data.get(3).intValue(),
                            list.get(i).data.get(4).intValue(),
                            list.get(i).data.get(5).intValue(),
                            list.get(i).data.get(6).intValue(),
                            list.get(i).data.get(7).intValue(),
                            list.get(i).data.get(8).intValue(),
                            list.get(i).data.get(9).intValue(),
                            list.get(i).data.get(10).intValue(),
                            list.get(i).data.get(11).intValue(),
                            list.get(i).data.get(12).intValue(),
                            list.get(i).data.get(13).intValue(),
                            list.get(i).data.get(14).intValue(),
                            list.get(i).data.get(15).intValue(),
                            list.get(i).data.get(16).intValue(),
                            list.get(i).data.get(17).intValue(),
                            list.get(i).data.get(18).intValue()
                    )
            );
        }
    }

    private void initFlaresData() {
        ArrayList<Row> list = CSVReader.readFlareData();

        agds = new AGDS(list);


        for (int i = 0; i < list.size(); i++)
        {
            flareData.add(
                    new FlareData(
                            Integer.valueOf(list.get(i).id),
                            String.valueOf(list.get(i).X),
                            list.get(i).data.get(0).intValue(),
                            list.get(i).data.get(1).intValue(),
                            list.get(i).data.get(2).intValue(),
                            list.get(i).data.get(3).intValue(),
                            list.get(i).data.get(4).intValue(),
                            list.get(i).data.get(5).intValue(),
                            list.get(i).data.get(6).intValue(),
                            list.get(i).data.get(7).intValue(),
                            list.get(i).data.get(8).intValue(),
                            list.get(i).data.get(9).intValue(),
                            list.get(i).data.get(10).intValue(),
                            list.get(i).data.get(11).intValue()
                    )
            );
        }
    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {



        scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(2220);
        stage.setHeight(1230);

        final Button diabetesButton = new Button("Load diabates data");
        final Button secDataButton = new Button("Load vehicles data");
        final Button thirdDataButton = new Button("Load flares data");


        VBox vBox = new VBox();
        vBox.setId("init_buttons");
        vBox.setSpacing(20);
        vBox.getChildren().addAll( diabetesButton, secDataButton, thirdDataButton );

        diabetesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                initDiabetesData();
                loadDiabetesData( stage );
                ((Group) scene.getRoot()).getChildren().remove( vBox );
                //((Group) scene.getRoot()).getChildren().removeIf( obj -> obj.getId().equals("init_buttons") );
            }
        });

        secDataButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                initVehiclesData();
                loadVehiclesData( stage );
                ((Group) scene.getRoot()).getChildren().remove( vBox );
            }
        });

        thirdDataButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                initFlaresData();
                loadFlareData(stage );
                ((Group) scene.getRoot()).getChildren().remove( vBox );
            }
        });


        ((Group) scene.getRoot()).getChildren().addAll(vBox);
        stage.setScene(scene);
        stage.show();

    }


    public static Color xToColor(String X) {
        if (X == null || Double.valueOf(X).compareTo(0.0) == 0) {
            return Color.WHITESMOKE;
        }

        Double x = Double.valueOf(X);
        if( x.compareTo(1.0) == 1) x = 1.0;
        if( x.compareTo(0.0) == -1) x = 0.0;

        if( Double.valueOf( X ).compareTo( 0.5 ) == -1 ) {
//            return Color.color( 0.0,0.0,2*  Double.valueOf(X) );
            return Color.rgb(0,0,1, x);
        }
        else{
            return Color.rgb(1,0,0, x);
//            return Color.color( 0.5 - Double.valueOf(X),0.0,0.0 );
        }
    }


    private void loadDiabetesData(Stage stage)
    {

//        final Label label = new Label("Diabetes set");
//        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn idCol = new TableColumn("Row ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("ID"));

        TableColumn xCol = new TableColumn("X");
        xCol.setMinWidth(100);
        xCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("X"));


        TableColumn qualityCol = new TableColumn("Quality");
        qualityCol.setMinWidth(100);
        qualityCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("quality"));

        TableColumn pre_scrCol = new TableColumn("Pre_screening");
        pre_scrCol.setMinWidth(100);
        pre_scrCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("pre_screening"));



        TableColumn maCol1 = new TableColumn("MADetect1");
        maCol1.setMinWidth(100);
        maCol1.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect1"));

        TableColumn maCol2 = new TableColumn("MADetect2");
        maCol2.setMinWidth(100);
        maCol2.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect2"));

        TableColumn maCol3 = new TableColumn("MADetect3");
        maCol3.setMinWidth(100);
        maCol3.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect3"));

        TableColumn maCol4 = new TableColumn("MADetect4");
        maCol4.setMinWidth(100);
        maCol4.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect4"));

        TableColumn maCol5 = new TableColumn("MADetect5");
        maCol5.setMinWidth(100);
        maCol5.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect5"));

        TableColumn maCol6 = new TableColumn("MADetect6");
        maCol6.setMinWidth(100);
        maCol6.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect6"));

        TableColumn maCol7 = new TableColumn("MADetect7");
        maCol7.setMinWidth(100);
        maCol7.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect7"));

        TableColumn maCol8 = new TableColumn("MADetect8");
        maCol8.setMinWidth(100);
        maCol8.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect8"));

        TableColumn maCol9 = new TableColumn("MADetect9");
        maCol9.setMinWidth(100);
        maCol9.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect9"));

        TableColumn maCol10 = new TableColumn("MADetect10");
        maCol10.setMinWidth(100);
        maCol10.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect10"));

        TableColumn maCol11 = new TableColumn("MADetect11");
        maCol11.setMinWidth(100);
        maCol11.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect11"));

        TableColumn maCol12 = new TableColumn("MADetect12");
        maCol12.setMinWidth(100);
        maCol12.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect12"));

        TableColumn maCol13 = new TableColumn("MADetect13");
        maCol13.setMinWidth(100);
        maCol13.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect13"));

        TableColumn maCol14 = new TableColumn("MADetect14");
        maCol14.setMinWidth(100);
        maCol14.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("MAdetect14"));


        TableColumn dist_from_mac = new TableColumn("Dist. from Macula");
        dist_from_mac.setMinWidth(100);
        dist_from_mac.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("distance_from_macula"));


        TableColumn diameter_of_optic_disc = new TableColumn("Diameter of optic disc");
        diameter_of_optic_disc.setMinWidth(100);
        diameter_of_optic_disc.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("diameter_of_optic_disc"));

        TableColumn am_fm = new TableColumn("AM FM");
        am_fm.setMinWidth(100);
        am_fm.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, String>("amfm_verification"));

        TableColumn class_lab = new TableColumn("Class");
        class_lab.setMinWidth(100);
        class_lab.setCellValueFactory(
                new PropertyValueFactory<Row, String>("class_label"));


        bottomPanel( scene );

        table.setMinHeight(1000);
        table.setItems(data);
        table.getColumns().addAll(
                idCol,
                xCol,
                qualityCol,
                pre_scrCol,
                maCol1,
                maCol2,
                maCol3,
                maCol4,
                maCol5,
                maCol6,
                maCol7,
                maCol8,
                maCol9,
                maCol10,
                maCol11,
                maCol12,
                maCol13,
                maCol14,
                dist_from_mac,
                diameter_of_optic_disc,
                am_fm,
                class_lab
        );


        stage.setScene(scene);
        stage.show();
    }


    private void loadFlareData(Stage stage)
    {

        flareTable.setEditable(true);

        TableColumn idCol = new TableColumn("Row ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("ID"));

        TableColumn xCol = new TableColumn("X");
        xCol.setMinWidth(100);
        xCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("X"));


        TableColumn largestSpotSizeCol = new TableColumn("Largest Spot Size");
        largestSpotSizeCol.setMinWidth(100);
        largestSpotSizeCol.setCellValueFactory(
                new PropertyValueFactory<Row, String>("LargestSpotSize"));

        TableColumn SpotDistributionCol = new TableColumn("Spot distribution");
        SpotDistributionCol.setMinWidth(100);
        SpotDistributionCol.setCellValueFactory(
                new PropertyValueFactory<Row, String>("SpotDistribution"));


        TableColumn activityCol = new TableColumn("Activity");
        activityCol.setMinWidth(100);
        activityCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Activity"));


        TableColumn evolutionCol = new TableColumn("Evolution");
        evolutionCol.setMinWidth(100);
        evolutionCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Evolution"));


        TableColumn prev24Col = new TableColumn("Prev 24 hours");
        prev24Col.setMinWidth(100);
        prev24Col.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Prev24Hour"));

        TableColumn histComplexCol = new TableColumn("Hist. complex");
        histComplexCol.setMinWidth(100);
        histComplexCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("HistComplex"));

        TableColumn becomeCol = new TableColumn("Become hist");
        becomeCol.setMinWidth(100);
        becomeCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("BecomeHist"));

        TableColumn areaCol = new TableColumn("Area");
        areaCol.setMinWidth(100);
        areaCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Area"));

        TableColumn cclassCol = new TableColumn("C-class");
        cclassCol.setMinWidth(100);
        cclassCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("C_class"));

        TableColumn mclassCol = new TableColumn("M-class");
        mclassCol.setMinWidth(100);
        mclassCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("M_class"));

        TableColumn xclassCol = new TableColumn("X-class");
        xclassCol.setMinWidth(100);
        xclassCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("X_class"));



        TableColumn classCol = new TableColumn("Class");
        classCol.setMinWidth(100);
        classCol.setCellValueFactory(
                new PropertyValueFactory<Row, String>("class_label"));

        bottomPanelForFlares( scene );

        flareTable.setMinHeight(1000);
        flareTable.setItems(flareData);
        flareTable.getColumns().addAll(
                idCol,
                xCol,
                largestSpotSizeCol,
                SpotDistributionCol,
                activityCol,
                evolutionCol,
                prev24Col,
                histComplexCol,
                becomeCol,
                areaCol,
                cclassCol,
                mclassCol,
                xclassCol,
                classCol
        );


        stage.setScene(scene);
        stage.show();
    }


    private void loadVehiclesData(Stage stage)
    {
        vehiclesTable.setEditable(true);

        TableColumn idCol = new TableColumn("Row ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("ID"));

        TableColumn xCol = new TableColumn("X");
        xCol.setMinWidth(100);
        xCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("X"));


        TableColumn compactnessCol = new TableColumn("Compactness");
        compactnessCol.setMinWidth(100);
        compactnessCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Compactness"));


        TableColumn circularityCol = new TableColumn("Circularity");
        circularityCol.setMinWidth(100);
        circularityCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Circularity"));

        TableColumn distCirCol = new TableColumn("Distance circularity");
        distCirCol.setMinWidth(100);
        distCirCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Distance_circularity"));

        TableColumn radiusRatioCol = new TableColumn("Radius ratio");
        radiusRatioCol.setMinWidth(100);
        radiusRatioCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Radius_ratio"));


        TableColumn praxisAspectRatio = new TableColumn("Praxis aspect ratio");
        praxisAspectRatio.setMinWidth(100);
        praxisAspectRatio.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Praxis_aspec_ratio"));


        TableColumn maxLengthCol = new TableColumn("Max length");
        maxLengthCol.setMinWidth(100);
        maxLengthCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Max_length_aspect_ratio"));


        TableColumn scatterRatioCol = new TableColumn("Scatter ratio");
        scatterRatioCol.setMinWidth(100);
        scatterRatioCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Scatter_ratio"));


        TableColumn ElongatednessCol = new TableColumn("Elongatedness");
        ElongatednessCol.setMinWidth(100);
        ElongatednessCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Elongatedness"));


        TableColumn praxisRectCol = new TableColumn("Praxis rectangular");
        praxisRectCol.setMinWidth(100);
        praxisRectCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Praxis_rectangular"));


        TableColumn lengthRectCol = new TableColumn("Length rect");
        lengthRectCol.setMinWidth(100);
        lengthRectCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Length_rectangular"));


        TableColumn majorVarianceCol = new TableColumn("Major variance");
        majorVarianceCol.setMinWidth(100);
        majorVarianceCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Major_variance"));

        TableColumn minorVarianceCol = new TableColumn("Minor variance");
        minorVarianceCol.setMinWidth(100);
        minorVarianceCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Minor_variance"));


        TableColumn gyrationRadiusCol = new TableColumn("Gyration Radius");
        gyrationRadiusCol.setMinWidth(100);
        gyrationRadiusCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Gyration_radius"));



        TableColumn majorSkewnessCol = new TableColumn("Major skewness");
        majorSkewnessCol.setMinWidth(100);
        majorSkewnessCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Major_skewness"));


        TableColumn minorSkewnessCol = new TableColumn("Minor skewness");
        minorSkewnessCol.setMinWidth(100);
        minorSkewnessCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Minor_skewness"));


        TableColumn minorKurtosisCol = new TableColumn("Minor kurtosis");
        minorKurtosisCol.setMinWidth(100);
        minorKurtosisCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Minor_kurtosis"));



        TableColumn majorKurtosisCol = new TableColumn("Major kurtosis");
        majorKurtosisCol.setMinWidth(100);
        majorKurtosisCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Major_kurtosis"));


        TableColumn hollowsCol = new TableColumn("Hollows kurtosis");
        hollowsCol.setMinWidth(100);
        hollowsCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Hollows_ratio"));




        TableColumn class_lab = new TableColumn("Class");
        class_lab.setMinWidth(100);
        class_lab.setCellValueFactory(
                new PropertyValueFactory<Row, String>("vehicle_class"));


        bottomPanelForVehicles( scene );


        vehiclesTable.setMinHeight(1000);
        vehiclesTable.setMinWidth(1600);
        vehiclesTable.setItems( vehiclesData );
        vehiclesTable.getColumns().addAll(
                idCol,
                xCol,
                compactnessCol,
                circularityCol,
                distCirCol,
                radiusRatioCol,
                praxisAspectRatio,
                maxLengthCol,
                scatterRatioCol,
                ElongatednessCol,
                praxisRectCol,
                lengthRectCol,
                majorVarianceCol,
minorVarianceCol,
                gyrationRadiusCol,
                majorSkewnessCol,
                minorSkewnessCol,
                majorKurtosisCol,
                minorKurtosisCol,
                hollowsCol,
                class_lab
        );


        stage.setScene(scene);
        stage.show();
    }


/*    private void loadVehiclesData(Stage stage)
    {
        vehiclesTable.setEditable(true);

        TableColumn idCol = new TableColumn("Row ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("ID"));

        TableColumn xCol = new TableColumn("X");
        xCol.setMinWidth(100);
        xCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("X"));


        TableColumn compactnessCol = new TableColumn("Compactness");
        compactnessCol.setMinWidth(100);
        compactnessCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Compactness"));


        TableColumn circularityCol = new TableColumn("Circularity");
        circularityCol.setMinWidth(100);
        circularityCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Circularity"));

        TableColumn distCirCol = new TableColumn("Distance circularity");
        distCirCol.setMinWidth(100);
        distCirCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Distance_circularity"));

        TableColumn radiusRatioCol = new TableColumn("Radius ratio");
        radiusRatioCol.setMinWidth(100);
        radiusRatioCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Radius_ratio"));


        TableColumn praxisAspectRatio = new TableColumn("Praxis aspect ratio");
        praxisAspectRatio.setMinWidth(100);
        praxisAspectRatio.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Praxis_aspec_ratio"));


        TableColumn maxLengthCol = new TableColumn("Max length");
        maxLengthCol.setMinWidth(100);
        maxLengthCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Max_length_aspect_ratio"));


        TableColumn scatterRatioCol = new TableColumn("Scatter ratio");
        scatterRatioCol.setMinWidth(100);
        scatterRatioCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Scatter_ratio"));


        TableColumn ElongatednessCol = new TableColumn("Elongatedness");
        ElongatednessCol.setMinWidth(100);
        ElongatednessCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Elongatedness"));


        TableColumn praxisRectCol = new TableColumn("Praxis rectangular");
        praxisRectCol.setMinWidth(100);
        praxisRectCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Praxis_rectangular"));


        TableColumn lengthRectCol = new TableColumn("Length rect");
        lengthRectCol.setMinWidth(100);
        lengthRectCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Length_rectangular"));


        TableColumn majorVarianceCol = new TableColumn("Major variance");
        majorVarianceCol.setMinWidth(100);
        majorVarianceCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Major_variance"));


        TableColumn gyrationRadiusCol = new TableColumn("Gyration Radius");
        gyrationRadiusCol.setMinWidth(100);
        gyrationRadiusCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Gyration_radius"));



        TableColumn majorSkewnessCol = new TableColumn("Major skewness");
        majorSkewnessCol.setMinWidth(100);
        majorSkewnessCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Major_skewness"));


        TableColumn minorSkewnessCol = new TableColumn("Minor skewness");
        minorSkewnessCol.setMinWidth(100);
        minorSkewnessCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Minor_skewness"));


        TableColumn minorKurtosisCol = new TableColumn("Minor kurtosis");
        minorKurtosisCol.setMinWidth(100);
        minorKurtosisCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Minor_kurtosis"));



        TableColumn majorKurtosisCol = new TableColumn("Major kurtosis");
        majorKurtosisCol.setMinWidth(100);
        majorKurtosisCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Major_kurtosis"));


        TableColumn hollowsCol = new TableColumn("Hollows kurtosis");
        hollowsCol.setMinWidth(100);
        hollowsCol.setCellValueFactory(
                new PropertyValueFactory<DiabetesData, Integer>("Hollows_ratio"));




        TableColumn class_lab = new TableColumn("Class");
        class_lab.setMinWidth(100);
        class_lab.setCellValueFactory(
                new PropertyValueFactory<Row, String>("vehicle_class"));


        bottomPanelForVehicles( scene );


        vehiclesTable.setMinHeight(1000);
        vehiclesTable.setMinWidth(1600);
        vehiclesTable.setItems( vehiclesData );
        vehiclesTable.getColumns().addAll(
                idCol,
                xCol,
                compactnessCol,
                circularityCol,
                distCirCol,
                radiusRatioCol,
                praxisAspectRatio,
                maxLengthCol,
                scatterRatioCol,
                ElongatednessCol,
                praxisRectCol,
                lengthRectCol,
                majorVarianceCol,
                gyrationRadiusCol,
                majorSkewnessCol,
                minorSkewnessCol,
                majorKurtosisCol,
                minorKurtosisCol,
                hollowsCol,
                class_lab
        );


        stage.setScene(scene);
        stage.show();
    }*/

    private void bottomPanel( Scene scene )
    {
        final Label label = new Label("Diabetic Retinopathy data set");
        label.setFont(new Font("Arial", 20));

        final TextField dataInput = new TextField();
        dataInput.setPromptText("Data input");
        dataInput.setMaxWidth(500);


//        table.setRowFactory(tv -> {
//            TableRow<DiabetesData> row = new TableRow<>();
//            StringBinding xBinding = Bindings.selectString(row.itemProperty(), "X");
//
//            row.setBackground( new Background( new BackgroundFill(null, null, null)));
//
//            row.backgroundProperty().bind(Bindings.createObjectBinding(()
//                    -> new Background(new BackgroundFill(xToColor(xBinding.get()), CornerRadii.EMPTY, Insets.EMPTY)), xBinding));
//            return row;
//        });

        final Button calcButton = new Button("Calc X");
        calcButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                int x;
                if( !table.getSelectionModel().isEmpty() )
                    x = Integer.valueOf(table.getSelectionModel().getSelectedItem().getID());
                else
                    x = 0;

                System.out.println("CALC X " + x);
                agds.associateFrom( x );
                data.forEach( row -> {
                    row.setX( agds.getR().stream().filter( r -> r.id == row.getID() ).collect(Collectors.toList()).get(0).X.toString() );
                });

                table.refresh();
            }
        });

        final Button graphButton = new Button("Print graph");
        graphButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "print graph" );

                if( !graph.isDisplayed() )
                {
                    graph.printAGDS( agds );
                }
            }
        });

        final Button deleteButton = new Button("Remove");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "Remove row" );

                // NOTHING TO DELETE
                if( table.getSelectionModel().isEmpty() ) {
                    System.out.println("nothing selected");
                    return;
                }

                int id = table.getSelectionModel().getSelectedItem().getID();

                // remove from graph
                if( graph.isDisplayed() )
                {
                    graph.deleteNode( agds, id);
                }

                agds.removeR( id );
                table.getItems().remove( table.getSelectionModel().getSelectedItem() );
                table.refresh();
            }
        });

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "add row" );


                if( dataInput.getText().length() == 0 ) {
                    System.out.println("nothing in data input");
                    return;
                }

                boolean hasNulls = false;
                String[] data = dataInput.getText().split(",");
                if( data.length != agds.getN() ) {
                    System.out.println(" NOT ENOUGH DATA");
                }

                ArrayList<Double> d_data = new ArrayList<Double>();
                for (int i = 0; i < data.length; i++)
                {
                    Double x;
                    if( data[i].equals("") || data[i].equals("null")) {
                        x = null;
                        hasNulls = true;
                    }
                    else {

                        try
                        {
                            x = Double.valueOf( data[i] );
                        }
                        catch (NumberFormatException ex)
                        {

                                System.out.println("Not a number");
                                return;
                        }
                    }
                    d_data.add( x );
                }

                int max = agds.getR().get(0).id;
                for (int i = 0; i < agds.getR().size(); i++) {
                    max = Integer.max( max, agds.getR().get(i).id );
                }
                max = max + 1;
                Row newRow = new Row(max, d_data);
                if( hasNulls )
                {
                    agds.predicValuesFor( newRow );
                }
                else  {
                    agds.putNewRow( newRow );
                }


                if( graph.isDisplayed() )
                {
                    graph.putNode( max, agds.getR(), agds );
                }

                putNewRow( agds.getR().get( agds.getR().size() - 1 ) );
                table.refresh();
            }
        });

// FILTERING DATA

        final TextField filterInput = new TextField();
//        filterInput.setPromptText("-,-,-,-,0:50,-,-,-,-,-,-,-,-,-,-,0:0,-,-,-,-");
        filterInput.setText("-,-,-,-,0:50,-,-,-,-,-,-,-,-,-,-,0:0,-,-,-,-");
        filterInput.setMaxWidth(500);

        final Button filterButton = new Button("Filter by");
        filterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "Filter row" );
                refillDiabeticTable();

                String[] arr = filterInput.getText().split(",");

                ArrayList<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();
                for (int i = 0; i < arr.length; i++)
                {
                    sets.add( new HashSet<Integer>() );
                }

                // get id meeting constraints
                for (int i = 0; i < agds.getN(); i++)
                {
                    if( !arr[i].equals("-") )
                    {
                        Double first = Double.valueOf( arr[i].split(":")[0] );
                        Double last  = Double.valueOf( arr[i].split(":")[1] );

                        // obtain ID of rows
                        ArrayList<Element<Double>> list = agds.getA()[i].getSortedList();
                        for (int j = 0; j < list.size(); j++) {
                            if( (list.get(j).getKey().compareTo( first ) >= 0)
                                    && ( list.get(j).getKey().compareTo( last ) <= 0 )  )
                            {
                                for(Integer IT : list.get(j).E)
                                    sets.get(i).add( IT );
                            }

                        }
                    }
                }

                HashSet<Integer> toShow = new HashSet<Integer>();

                // intersect ID from all sets
                for (int i = 0; i < agds.getN() - 1; i++)
                {
                    if( !sets.get(i).isEmpty() )
                    {
                        toShow = new HashSet<>( sets.get(i) );
                        for (int j = i + 1; j < agds.getN(); j++)
                        {
                            if ( !sets.get( j ).isEmpty() )
                            {
                                toShow.retainAll( sets.get( j ) );
                            }
                        }
                        break;
                    }
                }
//                System.out.println( "show :" + toShow.size());
//                toShow.forEach( row -> {
//                    System.out.println( row );
//                } );
//                System.out.println( "show :" + toShow.size());
                // delete all
                if( toShow.isEmpty() )
                {
                    table.getItems().clear();
                }
                else {
                    ListIterator<DiabetesData> it = table.getItems().listIterator();
                    while( it.hasNext() )
                    {
                        if( !toShow.contains( it.next().getID() ) )
                        {
                            it.remove();
                        }
                    }
                }
                table.refresh();
            }
        });


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table, calcButton, graphButton, deleteButton, addButton, dataInput);

        final HBox button_row = new HBox();
        button_row.setSpacing(10);
        button_row.getChildren().addAll( calcButton, graphButton, deleteButton, addButton );

        vbox.getChildren().addAll(label, table, button_row, dataInput, filterButton, filterInput);


        ((Group) scene.getRoot()).getChildren().addAll(vbox);

    }


    private void bottomPanelForVehicles( Scene scene )
    {
        final Label label = new Label("Vehicles data set");
        label.setFont(new Font("Arial", 20));

        final TextField dataInput = new TextField();
        dataInput.setPromptText("Data input");
        dataInput.setMaxWidth(500);


//        table.setRowFactory(tv -> {
//            TableRow<DiabetesData> row = new TableRow<>();
//            StringBinding xBinding = Bindings.selectString(row.itemProperty(), "X");
//
//            row.setBackground( new Background( new BackgroundFill(null, null, null)));
//
//            row.backgroundProperty().bind(Bindings.createObjectBinding(()
//                    -> new Background(new BackgroundFill(xToColor(xBinding.get()), CornerRadii.EMPTY, Insets.EMPTY)), xBinding));
//            return row;
//        });

        final Button calcButton = new Button("Calc X");
        calcButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                int x;
                if( !vehiclesTable.getSelectionModel().isEmpty() )
                    x = Integer.valueOf(vehiclesTable.getSelectionModel().getSelectedItem().getID());
                else
                    x = 0;

                System.out.println("CALC X " + x);
                agds.associateFrom( x );

                vehiclesData.forEach( row -> {
                    row.setX( agds.getR().stream().filter( r -> r.id == row.getID() ).collect(Collectors.toList()).get(0).X.toString() ) ;
                });

                vehiclesTable.refresh();
            }
        });

        final Button graphButton = new Button("Print graph");
        graphButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "print graph" );

                if( !graph.isDisplayed() )
                {
                    graph.printAGDS( agds );
                }
            }
        });

        final Button deleteButton = new Button("Remove");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "Remove row" );

                // NOTHING TO DELETE
                if( vehiclesTable.getSelectionModel().isEmpty() ) {
                    System.out.println("nothing selected");
                    return;
                }

                int id = vehiclesTable.getSelectionModel().getSelectedItem().getID();

                // remove from graph
                if( graph.isDisplayed() )
                {
                    graph.deleteNode( agds, id);
                }

                agds.removeR( id );
                vehiclesTable.getItems().remove( vehiclesTable.getSelectionModel().getSelectedItem() );
                vehiclesTable.refresh();
            }
        });

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "add row" );


                if( dataInput.getText().length() == 0 ) {
                    System.out.println("nothing in data input");
                    return;
                }

                boolean hasNulls = false;
                String[] data = dataInput.getText().split(",");
                if( data.length != agds.getN() ) {
                    System.out.println(" NOT ENOUGH DATA");
                }

                ArrayList<Double> d_data = new ArrayList<Double>();
                for (int i = 0; i < data.length; i++)
                {
                    Double x;
                    if( data[i].equals("") || data[i].equals("null")) {
                        x = null;
                        hasNulls = true;
                    }
                    else {
                        try
                        {
                            x = Double.valueOf( data[i] );
                        }
                        catch (NumberFormatException ex)
                        {
                            //System.out.println(i + " " + data[i]);
                            if( data[i].length() > 2 )
                            {
                                switch( data[i] )
                                {
                                    case "saab" : x = 0.0; break;
                                    case "van" : x = 1.0; break;
                                    case "bus" : x = 2.0; break;
                                    default: x = 3.0; break;
                                }
                            }
                            else
                            {
                                System.out.println("Not a number");
                                return;
                            }
                        }
                    }
                    d_data.add( x );
                }

                int max = agds.getR().get(0).id;
                for (int i = 0; i < agds.getR().size(); i++) {
                    max = Integer.max( max, agds.getR().get(i).id );
                }
                max = max + 1;
                Row newRow = new Row(max, d_data);
                if( hasNulls )
                {
                    agds.predicValuesFor( newRow );
                }
                else  {
                    agds.putNewRow( newRow );
                }


                if( graph.isDisplayed() )
                {
                    graph.putNode( max, agds.getR(), agds );
                }

                putNewVehicleRow( agds.getR().get( agds.getR().size() - 1 ) );
                vehiclesTable.refresh();
            }
        });


        // FILTERING DATA

        final TextField filterInput = new TextField();

        filterInput.setText("-,-,-,-,-,-,-,-,-,-,-,-,-,-,-,-,-,-,0:1");
        filterInput.setMaxWidth(500);

        final Button filterButton = new Button("Filter by");
        filterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "Filter row" );
                refillVehiclesTable();

                String[] arr = filterInput.getText().split(",");
                System.out.println( arr.length + " " + agds.getN() );

                ArrayList<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();
                for (int i = 0; i < arr.length; i++)
                {
                    sets.add( new HashSet<Integer>() );
                }

                // get id meeting constraints
                for (int i = 0; i < agds.getN(); i++)
                {
                    if( !arr[i].equals("-") )
                    {
                        Double first = Double.valueOf( arr[i].split(":")[0] );
                        Double last  = Double.valueOf( arr[i].split(":")[1] );

                        // obtain ID of rows
                        ArrayList<Element<Double>> list = agds.getA()[i].getSortedList();
                        for (int j = 0; j < list.size(); j++) {
                            System.out.println( list.get(j).getKey() + " "  +(list.get(j).getKey().compareTo( first ) >= 0) + " " + ( list.get(j).getKey().compareTo( last ) <= 0 ));
                            if( (list.get(j).getKey().compareTo( first ) >= 0)
                                    && ( list.get(j).getKey().compareTo( last ) <= 0 )  )
                            {
                                for(Integer IT : list.get(j).E)
                                    sets.get(i).add( IT );
                            }
                        }
                    }
                }

                HashSet<Integer> toShow = new HashSet<Integer>();

                // intersect ID from all sets
                for (int i = 0; i < agds.getN() - 1; i++)
                {
                    if( !sets.get(i).isEmpty() )
                    {
                        toShow = new HashSet<>( sets.get(i) );
                        for (int j = i + 1; j < agds.getN(); j++)
                        {
                            if ( !sets.get( j ).isEmpty() )
                            {
                                toShow.retainAll( sets.get( j ) );
                            }
                        }
                        break;
                    }
                }
                if( toShow.isEmpty() ) toShow = new HashSet<>( sets.get( agds.getN() - 1 ) );
//                System.out.println( "show :" + toShow.size());
//                toShow.forEach( row -> {
//                    System.out.println( row );
//                } );
                System.out.println( "show :" + toShow.size());
                // delete all
                if( toShow.isEmpty() )
                {
                    vehiclesTable.getItems().clear();
                }
                else {
                    ListIterator<VehiclesData> it = vehiclesTable.getItems().listIterator();
                    while( it.hasNext() )
                    {
                        if( !toShow.contains( it.next().getID() ) )
                        {
                            it.remove();
                        }
                    }
                }
                vehiclesTable.refresh();
            }
        });

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table, calcButton, graphButton, deleteButton, addButton, dataInput);

        final HBox button_row = new HBox();
        button_row.setSpacing(10);
        button_row.getChildren().addAll( calcButton, graphButton, deleteButton, addButton );

        vbox.getChildren().addAll(label, vehiclesTable, button_row, dataInput, filterButton, filterInput);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

    }


    private void bottomPanelForFlares( Scene scene )
    {
        final Label label = new Label("Flares data set");
        label.setFont(new Font("Arial", 20));

        final TextField dataInput = new TextField();
        dataInput.setPromptText("Data input");
        dataInput.setMaxWidth(500);


        final Button calcButton = new Button("Calc X");
        calcButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                int x;
                if( !flareTable.getSelectionModel().isEmpty() )
                    x = Integer.valueOf(flareTable.getSelectionModel().getSelectedItem().getID());
                else
                    x = 0;

                System.out.println("CALC X " + x);
                agds.associateFrom( x );

                flareData.forEach( row -> {
                    row.setX( agds.getR().stream().filter( r -> r.id == row.getID() ).collect(Collectors.toList()).get(0).X.toString() ) ;
                });

                flareTable.refresh();
            }
        });

        final Button graphButton = new Button("Print graph");
        graphButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "print graph" );

                if( !graph.isDisplayed() )
                {
                    graph.printAGDS( agds );
                }
            }
        });

        final Button deleteButton = new Button("Remove");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "Remove row" );

                // NOTHING TO DELETE
                if( flareTable.getSelectionModel().isEmpty() ) {
                    System.out.println("nothing selected");
                    return;
                }

                int id = flareTable.getSelectionModel().getSelectedItem().getID();

                // remove from graph
                if( graph.isDisplayed() )
                {
                    graph.deleteNode( agds, id);
                }

                agds.removeR( id );
                flareTable.getItems().remove( flareTable.getSelectionModel().getSelectedItem() );
                flareTable.refresh();
            }
        });

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "add row" );


                if( dataInput.getText().length() == 0 ) {
                    System.out.println("nothing in data input");
                    return;
                }

                boolean hasNulls = false;
                String[] data = dataInput.getText().split(",");
                if( data.length != agds.getN() ) {
                    System.out.println(" NOT ENOUGH DATA");
                }

                ArrayList<Double> d_data = new ArrayList<Double>();
                for (int i = 0; i < data.length; i++)
                {
                    Double x;
                    //System.out.println(i + " : " + data[i]);
                    if( data[i].equals("") || data[i].equals("null"))
                    {
                        x = null;
                        hasNulls = true;
                    }
                    else
                    {
                        try
                        {
                            x = Double.valueOf( data[i] );
                        }
                        catch (NumberFormatException ex)
                        {
                            System.out.println("Not a number");
                            if( data[i].length() == 1 )
                            {
                                x = (double)((int)data[i].charAt(0));
                            }
                            else
                            {
                                return;
                            }

                        }
                    }
                    d_data.add( x );
                }

                int max = agds.getR().get(0).id;
                for (int i = 0; i < agds.getR().size(); i++) {
                    max = Integer.max( max, agds.getR().get(i).id );
                }
                max = max + 1;
                Row newRow = new Row(max, d_data);
                if( hasNulls )
                {
                    agds.predicValuesFor( newRow );
                }
                else  {
                    agds.putNewRow( newRow );
                }


                if( graph.isDisplayed() )
                {
                    graph.putNode( max, agds.getR(), agds );
                }

                putNewFlareRow( agds.getR().get( agds.getR().size() - 1 ) );
                flareTable.refresh();
            }
        });


        // FILTERING DATA

        final TextField filterInput = new TextField();

        filterInput.setText("A:K,-,-,-,-,-,-,-,-,-,-,B:C");
        filterInput.setMaxWidth(500);

        final Button filterButton = new Button("Filter by");
        filterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println( "Filter row" );
                refillFlaresTable();

                String[] arr = filterInput.getText().split(",");
                System.out.println( arr.length + " " + agds.getN() );

                ArrayList<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();
                for (int i = 0; i < arr.length; i++)
                {
                    sets.add( new HashSet<Integer>() );
                }

                // get id meeting constraints
                for (int i = 0; i < agds.getN(); i++)
                {
                    if( !arr[i].equals("-") )
                    {
                        Double first;
                        Double last;

                        if( arr[i].split(":")[0].matches("[A-Z]") )
                        {
                            first = Double.valueOf( (int)arr[i].split(":")[0].charAt(0) );
                            last = Double.valueOf( (int)arr[i].split(":")[1].charAt(0) );
                        }
                        else {

                            first = Double.valueOf( arr[i].split(":")[0] );
                            last  = Double.valueOf( arr[i].split(":")[1] );
                        }


                        // obtain ID of rows
                        ArrayList<Element<Double>> list = agds.getA()[i].getSortedList();
                        for (int j = 0; j < list.size(); j++) {
                            System.out.println( list.get(j).getKey() + " "  +(list.get(j).getKey().compareTo( first ) >= 0) + " " + ( list.get(j).getKey().compareTo( last ) <= 0 ));
                            if( (list.get(j).getKey().compareTo( first ) >= 0)
                                    && ( list.get(j).getKey().compareTo( last ) <= 0 )  )
                            {
                                for(Integer IT : list.get(j).E)
                                    sets.get(i).add( IT );
                            }
                        }
                    }
                }

                HashSet<Integer> toShow = new HashSet<Integer>();

                // intersect ID from all sets
                for (int i = 0; i < agds.getN() - 1; i++)
                {
                    if( !sets.get(i).isEmpty() )
                    {
                        toShow = new HashSet<>( sets.get(i) );
                        for (int j = i + 1; j < agds.getN(); j++)
                        {
                            if ( !sets.get( j ).isEmpty() )
                            {
                                toShow.retainAll( sets.get( j ) );
                            }
                        }
                        break;
                    }
                }
                if( toShow.isEmpty() ) toShow = new HashSet<>( sets.get( agds.getN() - 1 ) );
//                System.out.println( "show :" + toShow.size());
//                toShow.forEach( row -> {
//                    System.out.println( row );
//                } );
                System.out.println( "show :" + toShow.size());
                // delete all
                if( toShow.isEmpty() )
                {
                    flareTable.getItems().clear();
                }
                else {
                    ListIterator<FlareData> it = flareTable.getItems().listIterator();
                    while( it.hasNext() )
                    {
                        if( !toShow.contains( it.next().getID() ) )
                        {
                            it.remove();
                        }
                    }
                }
                flareTable.refresh();
            }
        });

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table, calcButton, graphButton, deleteButton, addButton, dataInput);

        final HBox button_row = new HBox();
        button_row.setSpacing(10);
        button_row.getChildren().addAll( calcButton, graphButton, deleteButton, addButton );

        vbox.getChildren().addAll(label, flareTable, button_row, dataInput, filterButton, filterInput);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

    }

    private void putNewRow(Row r)
    {
        data.add(
                new DiabetesData(
                        Integer.valueOf(r.id),
                        String.valueOf(r.X),
                        String.valueOf(r.data.get(0)),
                        String.valueOf(r.data.get(1)),
                        String.valueOf(r.data.get(2)),
                        String.valueOf(r.data.get(3)),
                        String.valueOf(r.data.get(4)),
                        String.valueOf(r.data.get(5)),
                        String.valueOf(r.data.get(6)),
                        String.valueOf(r.data.get(7)),
                        String.valueOf(r.data.get(8)),
                        String.valueOf(r.data.get(9)),
                        String.valueOf(r.data.get(10)),
                        String.valueOf(r.data.get(11)),
                        String.valueOf(r.data.get(12)),
                        String.valueOf(r.data.get(13)),
                        String.valueOf(r.data.get(14)),
                        String.valueOf(r.data.get(15)),
                        String.valueOf(r.data.get(16)),
                        String.valueOf(r.data.get(17)),
                        String.valueOf(r.data.get(18)),
                        String.valueOf(r.data.get(18))
                )
        );
    }

    private void putNewVehicleRow(Row r)
    {
        vehiclesData.add(
                new VehiclesData(
                        Integer.valueOf(r.id),
                        String.valueOf(r.X),
                        r.data.get(0).intValue(),
                        r.data.get(1).intValue(),
                        r.data.get(2).intValue(),
                        r.data.get(3).intValue(),
                        r.data.get(4).intValue(),
                        r.data.get(5).intValue(),
                        r.data.get(6).intValue(),
                        r.data.get(7).intValue(),
                        r.data.get(8).intValue(),
                        r.data.get(9).intValue(),
                        r.data.get(10).intValue(),
                        r.data.get(11).intValue(),
                        r.data.get(12).intValue(),
                        r.data.get(13).intValue(),
                        r.data.get(14).intValue(),
                        r.data.get(15).intValue(),
                        r.data.get(16).intValue(),
                        r.data.get(17).intValue(),
                        r.data.get(18).intValue()
                )
        );
    }


    private void putNewFlareRow(Row r)
    {
        flareData.add(
                new FlareData(
                        Integer.valueOf(r.id),
                        String.valueOf(r.X),
                        r.data.get(0).intValue(),
                        r.data.get(1).intValue(),
                        r.data.get(2).intValue(),
                        r.data.get(3).intValue(),
                        r.data.get(4).intValue(),
                        r.data.get(5).intValue(),
                        r.data.get(6).intValue(),
                        r.data.get(7).intValue(),
                        r.data.get(8).intValue(),
                        r.data.get(9).intValue(),
                        r.data.get(10).intValue(),
                        r.data.get(11).intValue()
                )
        );
    }


    private void refillDiabeticTable()
    {
        table.getItems().clear();
        data.clear();
        System.out.println(table.getItems().size());
        System.out.println(data.size());
        for (int i = 0; i < agds.getR().size(); i++)
        {
            data.add(
                    new DiabetesData(
                            Integer.valueOf(agds.getR().get(i).id),
                            String.valueOf(agds.getR().get(i).X),
                            String.valueOf(agds.getR().get(i).data.get(0)),
                            String.valueOf(agds.getR().get(i).data.get(1)),
                            String.valueOf(agds.getR().get(i).data.get(2)),
                            String.valueOf(agds.getR().get(i).data.get(3)),
                            String.valueOf(agds.getR().get(i).data.get(4)),
                            String.valueOf(agds.getR().get(i).data.get(5)),
                            String.valueOf(agds.getR().get(i).data.get(6)),
                            String.valueOf(agds.getR().get(i).data.get(7)),
                            String.valueOf(agds.getR().get(i).data.get(8)),
                            String.valueOf(agds.getR().get(i).data.get(9)),
                            String.valueOf(agds.getR().get(i).data.get(10)),
                            String.valueOf(agds.getR().get(i).data.get(11)),
                            String.valueOf(agds.getR().get(i).data.get(12)),
                            String.valueOf(agds.getR().get(i).data.get(13)),
                            String.valueOf(agds.getR().get(i).data.get(14)),
                            String.valueOf(agds.getR().get(i).data.get(15)),
                            String.valueOf(agds.getR().get(i).data.get(16)),
                            String.valueOf(agds.getR().get(i).data.get(17)),
                            String.valueOf(agds.getR().get(i).data.get(18)),
                            String.valueOf(agds.getR().get(i).data.get(18))
                    )
            );
        }
        table.setItems( data );
    }



    private void refillVehiclesTable()
    {
        vehiclesTable.getItems().clear();
        vehiclesData.clear();

        for (int i = 0; i < agds.getR().size(); i++)
        {
            vehiclesData.add(
                    new VehiclesData(
                            Integer.valueOf(agds.getR().get(i).id),
                            String.valueOf(agds.getR().get(i).X),
                            agds.getR().get(i).data.get(0).intValue(),
                            agds.getR().get(i).data.get(1).intValue(),
                            agds.getR().get(i).data.get(2).intValue(),
                            agds.getR().get(i).data.get(3).intValue(),
                            agds.getR().get(i).data.get(4).intValue(),
                            agds.getR().get(i).data.get(5).intValue(),
                            agds.getR().get(i).data.get(6).intValue(),
                            agds.getR().get(i).data.get(7).intValue(),
                            agds.getR().get(i).data.get(8).intValue(),
                            agds.getR().get(i).data.get(9).intValue(),
                            agds.getR().get(i).data.get(10).intValue(),
                            agds.getR().get(i).data.get(11).intValue(),
                            agds.getR().get(i).data.get(12).intValue(),
                            agds.getR().get(i).data.get(13).intValue(),
                            agds.getR().get(i).data.get(14).intValue(),
                            agds.getR().get(i).data.get(15).intValue(),
                            agds.getR().get(i).data.get(16).intValue(),
                            agds.getR().get(i).data.get(17).intValue(),
                            agds.getR().get(i).data.get(18).intValue()
                    )
            );
        }

        vehiclesTable.setItems( vehiclesData );
    }



    private void refillFlaresTable()
    {
        flareTable.getItems().clear();
        flareData.clear();

        for (int i = 0; i < agds.getR().size(); i++)
        {
            flareData.add(
                    new FlareData(
                            Integer.valueOf(agds.getR().get(i).id),
                            String.valueOf(agds.getR().get(i).X),
                            agds.getR().get(i).data.get(0).intValue(),
                            agds.getR().get(i).data.get(1).intValue(),
                            agds.getR().get(i).data.get(2).intValue(),
                            agds.getR().get(i).data.get(3).intValue(),
                            agds.getR().get(i).data.get(4).intValue(),
                            agds.getR().get(i).data.get(5).intValue(),
                            agds.getR().get(i).data.get(6).intValue(),
                            agds.getR().get(i).data.get(7).intValue(),
                            agds.getR().get(i).data.get(8).intValue(),
                            agds.getR().get(i).data.get(9).intValue(),
                            agds.getR().get(i).data.get(10).intValue(),
                            agds.getR().get(i).data.get(11).intValue()
                    )
            );
        }

        flareTable.setItems( flareData );
    }

}