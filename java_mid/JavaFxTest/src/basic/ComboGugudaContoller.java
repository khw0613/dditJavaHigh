package basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class ComboGugudaContoller implements Initializable{
	
	@FXML
	private ComboBox<Integer> cmbDan;
	
	@FXML
	private Button btnDan;
	
	@FXML
	private TextArea txtResult;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<Integer> list = FXCollections.observableArrayList(
				1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		//콤보박스에 항목 추가
		cmbDan.setItems(list);
		
//		btnDan.setOnAction(e ->{
//			int dan = cmbDan.getValue();
//			String text = "";
//			for(int i = 1; i <= 9; i++) {
//			text += (dan + " * " + i + " = " + i*dan + "\n");
//			}
//			txtResult.setText(text);
//			System.out.println("클릭성공");
//		});
		
		
		
		
	}

	@FXML public void buttonClicked(ActionEvent event) {
		int dan = cmbDan.getValue();
		String text = "";
		for(int i = 1; i <= 9; i++) {
			text += (dan + " * " + i + " = " + i*dan + "\n");
		}
			txtResult.setText(text);
			System.out.println("클릭성공");
	}
}