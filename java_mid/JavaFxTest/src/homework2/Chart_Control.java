package homework2;

import java.net.URL;
import java.util.ResourceBundle;

import basic.TableViewTest.Member;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Chart_Control implements Initializable{

	@FXML TextField txt_kor; //국어
	@FXML TextField txt_name; //이름
	@FXML TextField txt_math;//수학
	@FXML TextField txt_eng;//영어
	@FXML Button btn_add; //추가
	@FXML Button btn_can; //취소
	@FXML PieChart pie; //파이그래프
	@FXML Button btn_ext; //파이 버튼 닫기
	@FXML Button btn_c; // 바 버튼 닫기
	@FXML Button btn_save; // add창 저장 버튼
	@FXML BarChart<String, Number> bar_chart;//바 차트
	@FXML TableView<Member1> table_view; // 테이블 
	@FXML TableColumn<Member1, Number> col_name;//이름 컬럼
	@FXML TableColumn<Member1, Number> col_kor;//국어 컬럼
	@FXML TableColumn<Member1, Number> col_eng;//영어 컬럼
	@FXML TableColumn<Member1, Number> col_math;//수학 컬럼
	@FXML Button btn_grp; //바 그래프
	@FXML VBox main_vbox; //메인
	@FXML VBox vbox;
	@FXML BorderPane border;
	
	
	ObservableList<Member1> data;
	
	private Stage primaryStge;
	
	public void setPrimaryStge(Stage primaryStge) {
		this.primaryStge = primaryStge;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//컬럼들과 멤버클래스를 연결
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_kor.setCellValueFactory(new PropertyValueFactory<>("kor"));
		col_eng.setCellValueFactory(new PropertyValueFactory<>("eng"));
		col_math.setCellValueFactory(new PropertyValueFactory<>("math"));
		
		data = FXCollections.observableArrayList(new Member1("강현욱", 80, 90, 100),
				new Member1("홍길동", 70, 90, 80));
		
		//data 변수에 초기데이터 입력
		table_view.setItems(data);
		
			}
	
	
	

	public class Member1{
		private String name; //이름
		private int kor; //국어
		private int eng; //영어
		private int math; //수학
		
		
		public Member1(String name, int kor, int eng, int math) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMath() {
			return math;
		}
		public void setMath(int math) {
			this.math = math;
		}
		

	}




	@FXML public void add() {
		//stage객체 생성
		 Stage score_Add = new Stage(StageStyle.DECORATED);
		 
		 score_Add.initModality(Modality.APPLICATION_MODAL); 
		 
		 score_Add.initOwner(primaryStge);
		 
		 Parent parent = null;
		 try {
			 parent =FXMLLoader.load(getClass().getResource("add.fxml"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 txt_name = (TextField) parent.lookup("#txt_name");
		 txt_kor = (TextField) parent.lookup("#txt_kor");
		 txt_math = (TextField) parent.lookup("#txt_math");
		 txt_eng = (TextField) parent.lookup("#txt_eng");
		 btn_save = (Button) parent.lookup("#btn_save");
		 btn_can = (Button) parent.lookup("#btn_can");
		 
		 btn_save.setOnAction(event ->{
			 if (txt_name.getText().isEmpty() || txt_kor.getText().isEmpty() || txt_eng.getText().isEmpty()
						|| txt_math.getText().isEmpty()) {
					errMsg("작업 오류", "빈 항목이 있습니다.");
					return;
				}
			 data.add(new Member1(txt_name.getText(), Integer.parseInt(txt_kor.getText()),
					 Integer.parseInt(txt_eng.getText()), Integer.parseInt(txt_math.getText())));
			infoMsg("작업결과", txt_name.getText() + "님 정보를 추가했습니다.");
			 score_Add.close();
		 });
		 btn_can.setOnAction(event ->{
			 score_Add.close();
		 });
		 
		 Scene scene = new Scene(parent);
		 score_Add.setScene(scene);
		 score_Add.show();
	}



	//바 차트
	@FXML public void bar(ActionEvent event) {
		 try {
			BorderPane pane = FXMLLoader.load(getClass().getResource("barchart.fxml"));
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(primaryStge);
			
			BarChart<String, Number> bar_chart = (BarChart)pane.lookup("#bar_chart");
			XYChart.Series<String, Number> kor = new XYChart.Series<>();
			XYChart.Series<String, Number> eng = new XYChart.Series<>();
		    XYChart.Series<String, Number> math = new XYChart.Series<>();
		 


	      
	      kor.setName("국어");
	      eng.setName("영어");
	      math.setName("수학");
	      
	      for(int i= 0; i < data.size(); i++) {
	      kor.getData().add(new XYChart.Data<>(data.get(i).getName(), data.get(i).getKor()));
	      eng.getData().add(new XYChart.Data<>(data.get(i).getName(), data.get(i).getEng()));
	      math.getData().add(new XYChart.Data<>(data.get(i).getName(), data.get(i).getMath()));
	      }
	      bar_chart.getData().addAll(kor, eng, math);
		 btn_c  = (Button) pane.lookup("#btn_c");
		 btn_c.setOnAction(e ->{
			 stage.close();
		 });
		 Scene scene = new Scene(pane);
		 stage.setTitle("학생별 그래프");
		 stage.setScene(scene);
		 stage.show();
		 } catch (Exception e2) {
			 e2.printStackTrace();
		 }
	}

	//컬럼을 클릭 하면 나오는 파이
	@FXML public void pie() {
		try {
			BorderPane pane = FXMLLoader.load(getClass().getResource("pie.fxml"));
			
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(primaryStge);
			
			PieChart pieChart = (PieChart) pane.lookup("#pie");
			Button btn_ext = (Button)pane.lookup("#btn_ext");
			Member1 mem = data.get(table_view.getSelectionModel().getSelectedIndex());
			
			ObservableList<PieChart.Data> pieChartData = 
			FXCollections.observableArrayList(new PieChart.Data("국어", mem.getKor()),
							new PieChart.Data("영어", mem.getEng()), 
								new PieChart.Data("수학", mem.getMath()));
			pieChart.setData(pieChartData);
			
			btn_ext.setOnAction(e -> {
				stage.close();
				
			});
			Scene scene = new Scene(pane);
			stage.setTitle("파이 그래프");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void errMsg(String headerText, String msg) {
		Alert errAlert = new Alert(AlertType.ERROR);
		errAlert.setTitle("오류");
		errAlert.setHeaderText(headerText);
		errAlert.setContentText(msg);
		errAlert.showAndWait();
	}
	
	public void infoMsg(String headerText, String msg) {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("정보 확인");
		infoAlert.setHeaderText(headerText);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}
	
}
