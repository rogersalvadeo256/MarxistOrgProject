package application.main;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.scene.Initial;
import listeners.Close;
import application.main.Window;

public class Window  extends Stage{

    public static Stage mainStage;

    public Window() throws ClassNotFoundException {
        Window.mainStage = this;
        Window.mainStage.setResizable(true);

        Window.mainStage.setOnCloseRequest(e -> {
            new Close(Window.mainStage);
        });

        mainStage.setScene(new Initial());
        this.show();

    }
}
