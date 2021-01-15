/**
 * This class is directly dealing with fxml interface and its components
 */

package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.base.CD;
import model.base.Controller;

import java.net.URL;


public class ViewController {

    /**
     * ================= Controller.java Class components==================
     */
//    instance
    private final Controller controllerClass = new Controller();

    /**
     * =============== FXML functionality================
     */
    // ResourceBundle that was given to the FXMLLoader

    @FXML // fx:id="cd_name_tf_id"
    private TextField cd_name_tf_id; // Value injected by FXMLLoader

    @FXML // fx:id="cd_tracks_num_tf_id"
    private TextField cd_tracks_num_tf_id; // Value injected by FXMLLoader

    @FXML // fx:id="product_name_tf_id"
    private TextField product_name_tf_id; // Value injected by FXMLLoader

    @FXML // fx:id="genre_drop_down_id"
    private ComboBox<String> genre_drop_down_id; // Value injected by FXMLLoader

    @FXML // fx:id="check_box1_id"
    private CheckBox check_box1_id; // Value injected by FXMLLoader

    @FXML // fx:id="check_box2_id"
    private CheckBox check_box2_id; // Value injected by FXMLLoader

    @FXML // fx:id="add_cd_btn"
    private Button add_cd_btn; // Value injected by FXMLLoader

    @FXML // fx:id="deletecd_btn_id"
    private Button deletecd_btn_id; // Value injected by FXMLLoader

    @FXML // fx:id="info_after_updating_LB"
    private javafx.scene.text.Text info_after_updating_LB; // Value injected by FXMLLoader

    /**
     * Table part
     */

    @FXML // fx:id="table_view_id"
    private TableView<CD> table_view_id; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnId"
    private TableColumn<CD, String> tableColumnId; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnName"
    private TableColumn<CD, String> tableColumnName; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnSongNumber"
    private TableColumn<CD, String> tableColumnSongNumber; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumnCDGenre"
    private TableColumn<CD, String> tableColumnCDGenre; // Value injected by FXMLLoader

    /**
     * Table Part
     */

    @FXML
    void addCdBtn(ActionEvent event) throws InterruptedException {

        String cdName = cd_name_tf_id.getText();
        String nrOFTracks = cd_tracks_num_tf_id.getText();
        String producerName = product_name_tf_id.getText();
        String genre = genre_drop_down_id.getValue();

//        System.out.println(genre_drop_down_id.getValue());

        //Showing update message
        if (cd_name_tf_id.getText() == null || cd_tracks_num_tf_id.getText() == null || product_name_tf_id.getText() == null || !check_box1_id.isSelected() || !check_box2_id.isSelected() || genre_drop_down_id.getValue() == null) {
            displayMessages("Please make sure you have added all the necessary information before adding and check checkboxes", info_after_updating_LB, false);
        } else {

//            Adding items to the list

            CD temp_cd = new CD(cdName, nrOFTracks, genre, producerName);

            controllerClass.addCD(temp_cd);
//          Update table view
            updateTableList();

            displayMessages(cdName + " Successfully Added to the list", info_after_updating_LB, true);

        }

    }


    @FXML
    void check_box2(ActionEvent event) {

    }

    @FXML
    void checkbox1(ActionEvent event) {

    }

    @FXML
    void deleteCD_id(ActionEvent event) {
        // Getting the item id

        int deleted_item_id = table_view_id.getSelectionModel().getSelectedItem().getId();

        // Display confirmation message of deleting item
        displayMessages(controllerClass.getItem(deleted_item_id).getName() + " Successfully deleted! ", info_after_updating_LB, true);

        // removing item from the class Controller then updating the tableview
        controllerClass.removeCD(deleted_item_id);

        // Finally deleting
        table_view_id.getItems().remove(table_view_id.getSelectionModel().getSelectedItem());

        updateTableList();

    }

    @FXML
    void genre_dropdown(ActionEvent event) {

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cd_name_tf_id != null : "fx:id=\"cd_name_tf_id\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert cd_tracks_num_tf_id != null : "fx:id=\"cd_tracks_num_tf_id\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert product_name_tf_id != null : "fx:id=\"product_name_tf_id\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert genre_drop_down_id != null : "fx:id=\"genre_drop_down_id\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert check_box1_id != null : "fx:id=\"check_box1_id\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert check_box2_id != null : "fx:id=\"check_box2_id\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert add_cd_btn != null : "fx:id=\"add_cd_btn\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert deletecd_btn_id != null : "fx:id=\"deletecd_btn_id\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert info_after_updating_LB != null : "fx:id=\"info_after_updating_LB\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert table_view_id != null : "fx:id=\"table_view_id\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert tableColumnId != null : "fx:id=\"tableColumnId\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert tableColumnName != null : "fx:id=\"tableColumnName\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert tableColumnSongNumber != null : "fx:id=\"tableColumnSongNumber\" was not injected: check your FXML file 'management_interface.fxml'.";
        assert tableColumnCDGenre != null : "fx:id=\"tableColumnCDGenre\" was not injected: check your FXML file 'management_interface.fxml'.";


//        list population of dropdown panel
        ObservableList<String> list = FXCollections.observableArrayList("Electronic Dance", "Rock", "Jazz", "Dubstep", "Rhythm and Blues", "Techno", "Country", "Electro", "Indie Rock", "Pop Music");
        genre_drop_down_id.setItems(list);

    }

    /**
     * External functions
     */
    public void displayMessages(String textToBeShown, Text textField, boolean cleaning_flag) {

        textField.setText(textToBeShown);

        if (cleaning_flag) {
            //Resetting the fields to avoid double adding
            cd_name_tf_id.setText(null);
            cd_tracks_num_tf_id.setText(null);
            product_name_tf_id.setText(null);
            check_box2_id.setSelected(false);
            check_box1_id.setSelected(false);

//            Reset genre
            genre_drop_down_id.getSelectionModel().clearSelection();


        }
    }

    //    Update table
    public void updateTableList() {

        ObservableList<CD> list_obs_cd = FXCollections.observableArrayList();
//        Adding only yht items that are not null
        for (int i = 0; i < controllerClass.getCdList().length; i++) {
            if (controllerClass.getCdList()[i] != null) {
                System.out.println("Successfully completed action!!!");
                list_obs_cd.add(i, controllerClass.getCdList()[i]);
            }


        }


//        System.out.println(list_obs_cd.toString());

        //        Updating table
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnSongNumber.setCellValueFactory(new PropertyValueFactory<>("songNumbers"));
        tableColumnCDGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));

//        load data into table
        table_view_id.setItems(list_obs_cd);
    }

}
