package homework4;

import java.beans.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import homework3.Product_VO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ZipCode_Controller implements Initializable{

	@FXML ComboBox<String> cmb;
	@FXML TextField t_field;
	@FXML Button btn_Search;
	@FXML TableColumn<ZipCode_VO, String> col_Zipcode;
	@FXML TableColumn<ZipCode_VO, String> col_City;
	@FXML TableColumn<ZipCode_VO, String> col_Gu;
	@FXML TableColumn<ZipCode_VO, String> col_Street;
	@FXML TableColumn<ZipCode_VO, String> col_Street_Num;
	jdbcZipCode zipcode = new jdbcZipCode();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<String> cbList = FXCollections.observableArrayList("동이름", "우편번호");
		cmb.setItems(cbList);
		cmb.setValue(cbList.get(0));
		
	}
	@FXML public void btn_Search_Click() {
		col_Zipcode.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
		col_City.setCellValueFactory(new PropertyValueFactory<>("city"));
		col_Gu.setCellValueFactory(new PropertyValueFactory<>("gu"));
		col_Street.setCellValueFactory(new PropertyValueFactory<>("street"));
		col_Street_Num.setCellValueFactory(new PropertyValueFactory<>("street_num"));
		
		ObservableList<Product_VO> list = FXCollections.observableArrayList(zipcode.sel_Zipcode(t_fiel))
		
	}
	
		
	}

