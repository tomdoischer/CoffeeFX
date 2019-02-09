package sample;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.text.DecimalFormat;

public class Controller {
    @FXML
    private Spinner<Integer> amount;
    @FXML
    private TextArea result;
    @FXML
    private ToggleGroup waterOrCoffee;
    @FXML
    private ToggleGroup strength;
    @FXML
    private RadioButton water;
    @FXML
    private RadioButton coffee;
    @FXML
    private RadioButton mild;
    @FXML
    private RadioButton standard;
    @FXML
    private RadioButton strong;
    private double mildRatioGForML = 0.10;
    private double standardRatioGForML = 0.12;
    private double strongRatioGForML = 0.14;

    private static DecimalFormat df2 = new DecimalFormat(".##");

    public void initialize() {

    }
    public void onCalculate(){
        if (waterOrCoffee.getSelectedToggle() == water){
            if (strength.getSelectedToggle() == mild){
                int inputAmount = amount.getValue();
                double resultCoffee =  inputAmount * mildRatioGForML;
                result.setText("To make " + inputAmount + " ml of mild coffee, use " + df2.format(resultCoffee) + " grams of coffee.");
            } else if (strength.getSelectedToggle() == standard) {
                int inputAmount = amount.getValue();
                double resultCoffee =  inputAmount * standardRatioGForML;
                result.setText("To make " + inputAmount + " ml of standard coffee, use " + df2.format(resultCoffee) + " grams of coffee.");
            } else if (strength.getSelectedToggle() == strong) {
                int inputAmount = amount.getValue();
                double resultCoffee =  inputAmount * strongRatioGForML;
                result.setText("To make " + inputAmount + " ml of strong coffee, use " + df2.format(resultCoffee) + " grams of coffee.");
            } else {
                result.setText("Please choose the desired strength of coffee.");
            }
        } else if (waterOrCoffee.getSelectedToggle() == coffee){
            if (strength.getSelectedToggle() == mild){
                int inputAmount = amount.getValue();
                double resultCoffee =  inputAmount / mildRatioGForML;
                result.setText("To use " + inputAmount + " grams for mild coffee, use " + df2.format(resultCoffee) + " milliliters of water.");
            } else if (strength.getSelectedToggle() == standard) {
                int inputAmount = amount.getValue();
                double resultCoffee =  inputAmount / standardRatioGForML;
                result.setText("To use " + inputAmount + " grams for standard coffee, use " + df2.format(resultCoffee) + " milliliters of water.");
            } else if (strength.getSelectedToggle() == strong) {
                int inputAmount = amount.getValue();
                double resultCoffee =  inputAmount / strongRatioGForML;
                result.setText("To use " + inputAmount + " grams for strong coffee, use " + df2.format(resultCoffee) + " milliliters of water.");
            } else {
                result.setText("Please choose the desired strength of coffee.");
            }
        }
        else {
            result.setText("Please choose whether you want to calculate the amount of water or coffee.");
        }
    }


}
