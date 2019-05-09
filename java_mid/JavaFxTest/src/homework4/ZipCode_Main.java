package homework4;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ZipCode_Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = FXMLLoader.load(getClass().getResource("ZipcodeTest.fxml"));
		
		Scene scene =  new Scene(pane);
		primaryStage.setTitle("우편번호 검색");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
