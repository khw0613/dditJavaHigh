package homework2;


	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

	public class Chart_Main extends Application {
		@Override
		public void start(Stage primaryStage) throws Exception {
			VBox root = FXMLLoader.load(getClass().getResource("appMain.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setTitle("appmain");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		
		
		public static void main(String[] args){
			launch(args);
		}


}
