package basic;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneTest extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 200); //size한번에 넣고 싶을때
		
		ToolBar toolBar = new ToolBar(new Button("첫번째버튼"), new Button("두번째버튼"));
		
		TextArea txtArea = new TextArea();
		
		root.setTop(toolBar);; //Top영역에  ToolBar추가하기
		root.setCenter(txtArea); // Center영역에 TextArea 추가하기
		
		//위, 아래, 오른쪽, 왼쪽, 중앙에 컨트롤을 배치하는 레이아웃
		BorderPane bottom = new BorderPane();
		bottom.setPadding(new Insets(10));
		
		TextField txtField = new TextField();
		Button btn1 = new Button("확인");
		bottom.setCenter(txtField);
		bottom.setRight(btn1);
		
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
				
		primaryStage.setTitle("BorderPane 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
