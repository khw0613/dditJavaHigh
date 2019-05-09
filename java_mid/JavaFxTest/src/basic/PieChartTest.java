package basic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		PieChart pieChart = new PieChart();
		
		// 차트에 나타낼 데이터 구성하기
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				
				new PieChart.Data("포도", 10000),
				new PieChart.Data("사과", 18000),
				new PieChart.Data("배", 25000),
				new PieChart.Data("복숭아", 15000),
				new PieChart.Data("바나나", 5000),
				new PieChart.Data("귤", 12000)
				);
		
		pieChart.setTitle("과열 가격");
		pieChart.setLabelLineLength(50);
		pieChart.setLegendSide(Side.RIGHT);
		pieChart.setData(pieChartData);
		
		
		Scene scene = new Scene(pieChart, 500, 500);
		
		primaryStage.setTitle("PieChart");
		primaryStage.setTitle("PieChart");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	
	
	public static void main(String[] args) {
		launch(args);
	}
}