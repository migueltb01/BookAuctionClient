package main;

import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {
    private ObservableList<Book> ongoingBids = FXCollections.observableArrayList();
    @FXML
    private TableView<Book> tableViewOngoing;
    @FXML
    private TableColumn<Book, String> tableColumnOngoingName;
    @FXML
    private TableColumn<Book, String> tableColumnOngoingStatus;
    @FXML
    private TableColumn<Book, Integer> tableColumnOngoingValue;

    @FXML
    private TableView<Book> tableViewFollowing;
    @FXML
    private TableColumn<Book, String> tableColumnFollowingName;
    @FXML
    private TableColumn<Book, String> tableColumnFollowingStatus;
    @FXML
    private TableColumn<Book, Integer> tableColumnFollowingValue;

    @FXML
    Button buttonBid;
    @FXML
    TextField textFieldBid;


    @FXML
    private void initialize() {


        tableColumnOngoingName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableColumnOngoingStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        tableColumnOngoingValue.setCellValueFactory(cellData -> cellData.getValue().valueProperty().asObject());


        tableColumnFollowingName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableColumnFollowingStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        tableColumnFollowingValue.setCellValueFactory(cellData -> cellData.getValue().valueProperty().asObject());

        ongoingBids.add(new Book("Le Petit Prince","Not started yet", 30));

        tableViewOngoing.setItems(ongoingBids);
        tableViewFollowing.setItems(ongoingBids);

        buttonBid.setDisable(true);
        textFieldBid.setDisable(true);

        tableViewOngoing.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            textFieldBid.setText("");
            textFieldBid.setDisable(false);
            buttonBid.setDisable(true);
        });

        textFieldBid.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d+") && Integer.valueOf(newValue) > tableViewOngoing.getItems().get(tableViewOngoing.getSelectionModel().getSelectedIndex()).getValue()){
                buttonBid.setDisable(false);
            }
            else {
                buttonBid.setDisable(true);
            }
        });

        buttonBid.setOnAction(event -> {
        //@TODO: Implement button action to communicate the bid
        });
    }
}
