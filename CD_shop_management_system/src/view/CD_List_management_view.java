/**
 * Scene class, main class that will interact with FXML file of interface
 * */

package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class CD_List_management_view {

    public void show(Stage primStage) throws IOException {
        /********************** VIEW INTERFACE *********************/

        Parent root = FXMLLoader.load(getClass().getResource("management_interface.fxml"));
        primStage.setTitle("CD Management using FXML V1.0");
        primStage.setScene(new Scene(root));
        /********************** End of INTERFACE *********************/

    }

}
