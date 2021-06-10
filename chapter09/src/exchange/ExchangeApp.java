package exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;


// 9.9 Übung laden
public class ExchangeApp extends Application {
    
    private List<Label> labels;
    private List<ExchangeRate> rates;
    private TextField input;
    private ExchangeRate currentFrom;
    private ChoiceBox<String> rateSelection;

    public double convert(ExchangeRate from, ExchangeRate to, double value) {
        // Berechnen Sie value ausgehend von der 
        // Währung "from" in der Ziel-Währung "to"
        return value / from.getRate() * to.getRate();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        labels = new ArrayList<>();
        rates = new ArrayList<>();
        rates.add(new ExchangeRate(1.0000, "€")); // EU Euro, 1,00
        rates.add(new ExchangeRate(1.1295, "$")); // US Dollar, 1,22
        rates.add(new ExchangeRate(0.9035, "£")); // GB Pfund, 0,86
        rates.add(new ExchangeRate(121.4855, "¥")); // JP Yen, 133,27
        rates.add(new ExchangeRate(1.0638, "CHF")); // CH Franken, 1,09
        rates.add(new ExchangeRate(7.9385, "CNY")); // CHN Yuan, 7,78
        
        VBox mainPane = new VBox();
        HBox inputPane = new HBox();
        
        TextField value = new TextField();
        input = value;
        
        UnaryOperator<Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) { 
                return change;
            }
            return null;
        };

        value.setTextFormatter(
            new TextFormatter<Double>(new DoubleStringConverter(), 0.0, integerFilter));
        
        // Rates-Array muss in der ChoiceBox angezeigt werden (die Currency zur Auswahl), was wäre möglich?
        ChoiceBox<String> box = new ChoiceBox<>(); // Zur Auswahl der Währung
        rateSelection = box;
        
        ArrayList<String> currency = new ArrayList<>();
        for (ExchangeRate e : rates) {
            currency.add(e.getCurrency());
        }
        ObservableList<String> boxList = FXCollections.observableArrayList(currency);
        box.setItems(boxList);
        
        // Alternative:
//        ObservableList<String> list = FXCollections.observableArrayList(new ArrayList<String>());
//        
//        for(ExchangeRate er: rates) {
//            list.add(er.getCurrency());
//        }
//        box.setItems(list);
        
        SingleSelectionModel<String> selectionModel = box.getSelectionModel();
        selectionModel.select(0);
        
        inputPane.getChildren().add(value);
        inputPane.getChildren().add(box);
        
        mainPane.getChildren().add(inputPane);
        
        for(int i = 0; i < rates.size(); i ++) {
            Label label = new Label("xyz");
            labels.add(label);
            mainPane.getChildren().add(label);
        }
        
        rateSelection.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                update();
            }
        });
        input.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                update();
            }
        });
        
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Exchange calculator");
        primaryStage.show();
    }

    /**
     * Aktualisiert alle Felder in exchangeLabels 
     * basierend auf der ExchangeRate currentFrom 
     * und jedem Element in der Liste rates.
     */
    public void update() {
        // Was wäre der letzte Schritt um die Labels entsprechend zu füllen?
        // - convert Methode (für alle Währungen) aufrufen
        // ExchangeRate from, ExchangeRate to, double value
        // -> das from ist der ausgewählte
        // -> to sind alle aus rates
        
        String text = input.getText();
        
        double valueOf;
        try {
            valueOf = Double.valueOf(text);
        } catch(NumberFormatException exc) {
            exc.printStackTrace();
            valueOf = 0;
        }
        
        String selectedFrom = rateSelection.getSelectionModel().getSelectedItem();
        ExchangeRate from = null;
        for(int i = 0; i < rates.size(); i ++) {
            ExchangeRate currentRate = rates.get(i);
            if(currentRate.getCurrency().equals(selectedFrom)) {
                from = currentRate;
                break;
            }
        }
        
        for(int i = 0; i < rates.size(); i ++) {
            ExchangeRate to = rates.get(i);
            double convert = convert(from, to, valueOf);
            labels.get(i).setText(convert + " " + to.getCurrency());
        }
    }

}