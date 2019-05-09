package homework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Member_Main extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
//		FXMLLoader loader = 
//				new FXMLLoader(getClass().getResource("member.fxml"));
//		
//		Parent root = loader.load();
//		
//		
		Parent root = FXMLLoader.load(getClass().getResource("member.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("MemberMVC");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	public static void main(String[] args){
		launch(args);
	}

}
