package homework3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class Product_Control implements Initializable {

	@FXML ComboBox<String> combo1_name;
	@FXML ComboBox<String> combo2_detail;
	@FXML TableView<Product_VO> tableview;
	@FXML TableColumn<Product_VO, String> t_id;
	@FXML TableColumn<Product_VO, String> t_name;
	@FXML TableColumn<Product_VO, String> t_lgu;
	@FXML TableColumn<Product_VO, String> t_cost;
	@FXML TableColumn<Product_VO, String> t_price;
	@FXML TableColumn<Product_VO, String> t_sale;
	@FXML TableColumn<Product_VO, String> t_outline;
	@FXML TableColumn<Product_VO, String> t_detail;
	@FXML TableColumn<Product_VO, String> t_buyer;
	Jdbc_Product jdbc = new Jdbc_Product();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combo1_name.getItems().addAll(jdbc.sel_Lprod_Nm());
		
	}

	@FXML public void combo1_click(ActionEvent event) {
		combo2_detail.getItems().clear();
		combo2_detail.getItems().addAll(jdbc.sel_Prod_Name(combo1_name.getValue()));
	}
	@FXML public void combo2_click(ActionEvent event) {
		t_id.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("prod_Id"));
		t_name.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("prod_Name"));
		t_lgu.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("prod_Lgu"));
		t_buyer.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("prod_Buyer"));
		t_cost.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("prod_Cost"));
		t_price.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("prod_Price"));
		t_sale.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("prod_Sale"));
		t_outline.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("prod_Outline"));
		t_detail.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("prod_Detail"));
		
		ObservableList<Product_VO> list = FXCollections.observableArrayList(jdbc.sel_prod_All(combo2_detail.getValue()));
		tableview.setItems(list);
	}

}
