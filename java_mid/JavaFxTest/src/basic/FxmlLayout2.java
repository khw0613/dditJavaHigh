package basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlLayout2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// fxml파일을 읽어와 현재 Stage에 적용하기
		// Parent객체는 모든 컨테이너의 조상 객체
		
		//방법1
		Parent root = FXMLLoader.load(getClass().getResource("FXMLLayout2.fxml"));
		/*
		//방법2
		FXMLLayout loader =
				new FXMLLoader(getClass().getResource("FXMLLayout.fxml"));
		Parent root = loader.load();
		*/
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Stage와 Scene연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
