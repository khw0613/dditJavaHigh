package homework;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ibatis.member.vo.MemberVO;
import ibatis.service.MemberServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Member_Cotorll implements Initializable {
	MemberVO mv = new MemberVO();
	private MemberServiceImpl memService;
	
	@FXML
	TextField txt_id; // 회원 ID
	@FXML
	TextField txt_name;// 회원 이름
	@FXML
	TextField txt_tel;// 회원전화
	@FXML
	TextField txt_addr;// 회원주소
	@FXML
	Button btn_ins; // 추가
	@FXML
	Button btn_upd; // 수정
	@FXML
	Button btn_del;// 삭제
	@FXML
	Button btn_ok;// 확인
	@FXML
	Button btn_can;// 취소
	@FXML
	TableView<MemberVO> tab_view; // 테이블 뷰
	@FXML
	TableColumn<MemberVO, String> col_id; // 칼럼ID
	@FXML
	TableColumn<MemberVO, String> col_name;// 칼럼 이름
	@FXML
	TableColumn<MemberVO, String> col_tel;// 칼럼 번호
	@FXML
	TableColumn<MemberVO, String> col_addr;// 칼럼 주소

	ObservableList<MemberVO> data;
	boolean flag = true;
	public void btn_On() {
		
	}
	public void btn_Off() {
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		// 컬럼들과 멤버클래스를 연결
		col_id.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
		col_tel.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
		col_addr.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));

		List<MemberVO> memList = memService.getAllMemberList();

		// data변수에 초기데이터 입력
		data = FXCollections.observableArrayList(new MemberVO("asd", "kang", "010-3333-4444", "대전"),
				new MemberVO("asd2", "kang2", "010-3333-4444", "대전2"));

		tab_view.setItems(data);

		txt_id.setPromptText("회원ID 입력");
		txt_name.setPromptText("회원이름 입력");
		txt_tel.setPromptText("회원전화 입력");
		txt_addr.setPromptText("회원주소 입력");

		// ----------------------------------------------------------------
		
		//텍스트 필드 비활성화
		txt_id.setEditable(false);
		txt_name.setEditable(false);
		txt_tel.setEditable(false);
		txt_addr.setEditable(false);
		
		//버튼 비활성화 
		
		btn_ok.setDisable(true);
		btn_can.setDisable(true);
		
		// 추가버튼 이벤트
		btn_ins.setOnAction(e -> {
			
			txt_id.setEditable(true);
			txt_name.setEditable(true);
			txt_tel.setEditable(true);
			txt_addr.setEditable(true);
			
			btn_ins.setDisable(false);
			btn_upd.setDisable(true);
			btn_del.setDisable(true);
			btn_ok.setDisable(false);
			btn_can.setDisable(false);
		});

		// 수정버튼 이벤트
		btn_upd.setOnAction(e -> {
			
			txt_id.setEditable(true);
			txt_name.setEditable(true);
			txt_tel.setEditable(true);
			txt_addr.setEditable(true);
			
			btn_ins.setDisable(true);
			btn_upd.setDisable(false);
			btn_del.setDisable(true);
			btn_ok.setDisable(false);
			btn_can.setDisable(false);
			
		});

		// 삭제버튼 이벤트
		btn_del.setOnAction(e -> {
			if (tab_view.getSelectionModel().isEmpty()) {
				errMsg("작업 오류", "삭제할 자료를 선택한 후 삭제하세요.");
				return;
			}
			MemberVO dd = tab_view.getSelectionModel().getSelectedItem();

			txt_id.setText(dd.getMem_id());

			data.remove(tab_view.getSelectionModel().getSelectedItem());

			

			infoMsg("작업결과", dd.getMem_id() + "님 정보를 삭제했습니다.");

			txt_name.clear();
			txt_tel.clear();
			txt_addr.clear();

		});
		
		//확인버튼 이벤트 
		btn_ok.setOnAction(e -> {
			if(!btn_ins.isDisable()) {
				
				if (txt_id.getText().isEmpty() || txt_name.getText().isEmpty() || txt_tel.getText().isEmpty()
						|| txt_addr.getText().isEmpty()) {
					// System.out.println("빈 항목이 있습니다.");
					errMsg("작업 오류", "빈 항목이 있습니다.");
					return;
				}
				data.add(new MemberVO(txt_id.getText(),
						txt_name.getText(), 
						txt_tel.getText(), 
						txt_addr.getText()));
				infoMsg("작업결과", txt_id.getText() + "님 정보를 추가했습니다.");
				
				txt_id.clear();
				txt_name.clear();
				txt_tel.clear();
				txt_addr.clear();
				
				txt_id.setEditable(true);
				txt_name.setEditable(true);
				txt_tel.setEditable(true);
				txt_addr.setEditable(true);
				
				btn_ins.setDisable(false);
				btn_upd.setDisable(false);
				btn_del.setDisable(false);
				btn_ok.setDisable(true);
				btn_can.setDisable(true);

				
				
				
				
			}
			//================================================
			if(!btn_upd.isDisable()) {
				
				if(txt_id.getText().isEmpty() ||
						txt_name.getText().isEmpty() ||
						txt_tel.getText().isEmpty() ||
						txt_addr.getText().isEmpty()) {
					//System.out.println("빈 항목이 있습니다.");
					errMsg("작업 오류", "빈 항목이 있습니다.");
					return;
				}
				data.set(
						tab_view.getSelectionModel().getSelectedIndex(),
						new MemberVO(txt_id.getText(),
								txt_name.getText(), 
								txt_tel.getText(), 
								txt_addr.getText()));
				
				
				infoMsg("작업결과", txt_id.getText() + "님 정보를 수정했습니다.");
				
				
				txt_id.clear();
				txt_name.clear();
				txt_tel.clear();
				txt_addr.clear();
				
				txt_id.setEditable(true);
				txt_name.setEditable(true);
				txt_tel.setEditable(true);
				txt_addr.setEditable(true);
				
				btn_ins.setDisable(false);
				btn_upd.setDisable(false);
				btn_del.setDisable(false);
				btn_ok.setDisable(true);
				btn_can.setDisable(true);
			}
				
			
		});
		
		//취소버튼 이벤트
		btn_can.setOnAction(e -> {
			
			btn_ins.setDisable(false);
			btn_upd.setDisable(false);
			btn_del.setDisable(false);
			btn_ok.setDisable(true);
			btn_can.setDisable(true);
			
			
			
			txt_id.clear();
			txt_name.clear();
			txt_tel.clear();
			txt_addr.clear();
		});
			
		
		//클릭했을때 이벤트 처리 
		tab_view.setOnMouseClicked(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// TableView에서 선택한 줄의 데이터를 얻는다.
				MemberVO mem = tab_view.getSelectionModel().getSelectedItem();
				txt_id.setText(mem.getMem_id());
				txt_name.setText(mem.getMem_name());
				txt_tel.setText(mem.getMem_tel());
				txt_addr.setText(mem.getMem_addr());
			}
		});

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
