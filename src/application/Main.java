package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Label labell;
	Button button1;
	int i;
	float num = 0;
	int op = 0;
	int MUL = 1;
	int SUB = 2;
	int ADD = 3;
	int DIV = 4;
	int SQRT = 5;
	int LN = 6;
	
	Button[] btns = new Button[18];
	
	
	String[] btnText = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "c", "=", "+", "sqrt", "ln"};
	
	@Override
	public void start(Stage stage) {
		try {
			
			stage.setTitle("Calculator");
			labell = new Label();
			VBox root = new VBox();
			
			Scene scene = new Scene(root, 400, 800);
			stage.setScene(scene);
			
			
			for(i = 0; i < 18; i++){
				btns[i] = new Button(btnText[i]);
				final Button btn;
				btn = btns[i];
				btn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if(btn.getText().contentEquals("/")){
							op = DIV;
							if(num == 0) {
								num = Float.parseFloat(labell.getText());
							}else {
								num /= Float.parseFloat(labell.getText());
							}
							labell.setText("");
						}else if(btn.getText().contentEquals("*")) {
							op = MUL;
							if(num == 0 && Float.parseFloat(labell.getText()) != 0)
								num = 1;
							num *= Float.parseFloat(labell.getText());
							labell.setText("");
						}else if(btn.getText().contentEquals("-")) {
							if(op == 0) {
								num += Float.parseFloat(labell.getText());
								labell.setText("");
								System.out.println(num);
							}else{
								System.out.println("tolgo "+Float.parseFloat(labell.getText()));
								num -= Float.parseFloat(labell.getText());
								labell.setText("");
							}
							op = SUB;
						}else if(btn.getText().contentEquals("c")) {
							labell.setText("");
							op = 0;
							num = 0;
						}else if(btn.getText().contentEquals("=")) {
							if(op == ADD) {
								num += Float.parseFloat(labell.getText());
								labell.setText(""+num);
							}else if(op == SUB) {
								num -= Float.parseFloat(labell.getText());
								labell.setText(""+num);
							}else if(op == MUL) {
								num *= Float.parseFloat(labell.getText());
								labell.setText(""+num);
							}else if(op == DIV) {
								if(Float.parseFloat(labell.getText()) != 0) {
									num /= Float.parseFloat(labell.getText());
									labell.setText(""+num);
								}else {
									labell.setText("ERROR");
								}
							}else if(op == SQRT){
								if(num >= 0) {
									num = (float) Math.sqrt(num);
									labell.setText(""+num);
								}else {
									labell.setText("ERROR");
								}
							}else if(op == LN){
								if(num > 0) {
									num = (float) Math.log(num);
									labell.setText(""+num);
								}else {
									labell.setText("ERROR");
								}
							}
							//num = 0;
							op = 0;
						}else if(btn.getText().contentEquals("+")) {
							num += Float.parseFloat(labell.getText());
							labell.setText("");
							op = ADD;
						}else if(btn.getText().contentEquals("sqrt")){
							num = Float.parseFloat(labell.getText());
							op = SQRT;
							labell.setText("");
						}else if(btn.getText().contentEquals("ln")){
							num = Float.parseFloat(labell.getText());
							op = LN;
							labell.setText("");
						}else {
							labell.setText(labell.getText()+""+btn.getText());
						}
						
					}
				});
			}
			
			HBox screen = new HBox();
			HBox line1 = new HBox();
			HBox line2 = new HBox();
			HBox line3 = new HBox();
			HBox line4 = new HBox();
			HBox line5 = new HBox();

			line1.getChildren().add(btns[0]);
			line1.getChildren().add(btns[1]);
			line1.getChildren().add(btns[2]);
			line1.getChildren().add(btns[3]);
			
			line2.getChildren().add(btns[4]);
			line2.getChildren().add(btns[5]);
			line2.getChildren().add(btns[6]);
			line2.getChildren().add(btns[7]);
			
			line3.getChildren().add(btns[8]);
			line3.getChildren().add(btns[9]);
			line3.getChildren().add(btns[10]);
			line3.getChildren().add(btns[11]);
			
			line4.getChildren().add(btns[12]);
			line4.getChildren().add(btns[13]);
			line4.getChildren().add(btns[14]);
			line4.getChildren().add(btns[15]);
			
			line5.getChildren().add(btns[16]);
			line5.getChildren().add(btns[17]);
			
			screen.getChildren().add(labell);
			
			
			root.getChildren().addAll(screen, line1, line2, line3, line4, line5);
			stage.show();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
