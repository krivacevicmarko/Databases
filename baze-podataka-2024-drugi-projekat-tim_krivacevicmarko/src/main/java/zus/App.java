package zus;

import javafx.application.Application;
import javafx.stage.Stage;
import zus.model.jdbc.JDBCUtils;
import zus.view.mainviews.MainVIew;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        JDBCUtils.connect();
        stage = new MainVIew();
        stage.show();
    }
}
