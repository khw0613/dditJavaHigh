package basic;

import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableViewTest extends Application{

   @Override
   public void start(Stage primaryStage) throws Exception {
      //TableView에 나타낼 데이터 구성하기
      ObservableList<Member> data =FXCollections.observableArrayList(new Member("강현욱", "KANG HYUNWOOK", 29, "1111-1111", "대전"),
                                                      new Member("김도현", "KIMDOHYUN", 27, "2222-2222", "서울"),
                                                      new Member("김현지", "KIMHYUNJI", 32, "3333-3333", "부산"),
                                                      new Member("박경훈", "PARK KYUNGHUN", 31, "4444-4444", "광주")
            );
      BorderPane root =new BorderPane();
      
      //TableView에 데이터를 셋팅하기 => 방법1(TableView의 생성자 이용)
      TableView<Member> table = new TableView<>(data);
      
      TableColumn<Member, String> nameCol =new TableColumn<>("이름");
      
      TableColumn<Member, String> korNameCol = new TableColumn<>("한글이름");
      //해당컬럼에 나타날 데이터 연결하기
      //(출력할 객체의 멤버변수와 출력할 컬럼을 매칭시킨다)
      korNameCol.setCellValueFactory(new PropertyValueFactory<Member,String>("korName"));
      
      TableColumn<Member, String> engNameCol = new TableColumn<>("영어이름");
      engNameCol.setCellValueFactory(new PropertyValueFactory<Member,String>("engName"));
      
      nameCol.getColumns().addAll(korNameCol, engNameCol);
      
      TableColumn<Member, Integer> ageCol =new TableColumn<>("나이");
      ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
      
      TableColumn<Member, String> telCol =new TableColumn<>("전화번호");
      telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
      
      TableColumn<Member, String> addrCol =new TableColumn<>("주소");
      addrCol.setCellValueFactory(new PropertyValueFactory<>("addr"));
      
      //생성된 각 컬럼들을 TableView에 추가한다.
      table.getColumns().addAll(nameCol,ageCol,telCol,addrCol);
      
      //TableView에 데이터를 셋팅하기 => 방법2  :setItems()메서드 이용
      //table.setItem(data);
      //========================================================================================
      
      GridPane grid =new GridPane();
      Text txt1 =new Text("한글이름");
      Text txt2 =new Text("영어이름");
      Text txt3 =new Text("나      이");
      Text txt4 =new Text("전화번호");
      Text txt5 =new Text("주      소");
      
      TextField txtKorName = new TextField();
      TextField txtEngName = new TextField();
      TextField txtAge = new TextField();
      TextField txtTel = new TextField();
      TextField txtAddr = new TextField();
      
      grid.add(txt1, 1, 1);
      grid.add(txt2, 2, 1);
      grid.add(txt3, 3, 1);
      grid.add(txt4, 4, 1);
      grid.add(txt5, 5, 1);
      
      grid.add(txtKorName, 1, 2);
      grid.add(txtEngName, 2, 2);
      grid.add(txtAge, 3, 2);
      grid.add(txtTel, 4, 2);
      grid.add(txtAddr, 5, 2);
      
      grid.setVgap(5);
      grid.setHgap(10);
      grid.setPadding(new Insets(10,0,10,0));
      //========================================================================
      
      VBox vbox =new VBox(10);
      vbox.setPadding(new Insets(10)); 
      
      Button btnAdd =new Button("추가");
      btnAdd.setOnAction(new EventHandler<ActionEvent>() {
         
         @Override
         public void handle(ActionEvent event) {
            if(txtKorName.getText().isEmpty()   ||   txtEngName.getText().isEmpty()   ||   txtAge.getText().isEmpty()
                  ||   txtTel.getText().isEmpty()   ||   txtAddr.getText().isEmpty()) {
               errMsg("작업오류", "빈 항목이 있습니다.");
               return;
            }
            if(!Pattern.matches("^[0-9+$]", txtAge.getText())) {
               errMsg("데이터오류" , "나이는 정수형으로 입력하세요.");
               txtAge.requestFocus();       //해당객체에 Focus주기
               return;   
            }
            data.add(new Member(txtKorName.getText(), txtEngName.getText(), Integer.parseInt(txtAge.getText()), txtTel.getText(), txtAddr.getText()));
            infoMsg("작업결과" , txtKorName.getText()+"님 정보를 추가했습니다.");
            txtKorName.clear();
            txtEngName.clear();
            txtAge.clear();
            txtTel.clear();
            txtAddr.clear();
            
         }
      });
      
      vbox.getChildren().addAll(btnAdd);
      root.setCenter(table);
      root.setRight(vbox);
      root.setBottom(grid);
      root.setPadding(new Insets(10));
      
      Scene scene = new Scene(root);
      
      primaryStage.setTitle("TableView 연습");
      primaryStage.setScene(scene);
      primaryStage.show();
      
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
	   infoAlert.setTitle("정보확인");
	   infoAlert.setHeaderText(headerText);
	   infoAlert.setContentText(msg);
	   infoAlert.showAndWait();
   }
   
   public static void main(String[] args) {
      launch(args);
   }
}

class Member{
   private String korName;      //한글이름
   private String engName;      //영어이름
   private int age;         //나이
   private String tel;         //전화번호
   private String addr;      //주소
   
   public Member(String korName, String engName, int age, String tel, String addr) {
      super();
      this.korName = korName;
      this.engName = engName;
      this.age = age;
      this.tel = tel;
      this.addr = addr;
   }

   String getKorName() {
      return korName;
   }

   public void setKorName(String korName) {
      this.korName = korName;
   }

   String getEngName() {
      return engName;
   }

   public void setEngName(String engName) {
      this.engName = engName;
   }

   int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   String getAddr() {
      return addr;
   }

   public void setAddr(String addr) {
      this.addr = addr;
   }
   
   
   
   
}