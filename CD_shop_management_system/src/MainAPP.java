/*Main app to start the view and run the program*/

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.CD_List_management_view;

//import model.RW.Logger;
//import view.Login;

public class MainAPP extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage st) throws Exception {
        (new CD_List_management_view()).show(st);
        st.setResizable(false);
        st.getIcons().add(new Image("images/icon.png"));
        st.show();

    }
}
