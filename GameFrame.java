import javafx.application.Application;
import javafx.stage.Stage;

public class GameFrame extends Application {
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub 
		stage = primaryStage;
        stage.setScene((new Training()).createScene());
        stage.setTitle("Digivolution");
        stage.show(); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
