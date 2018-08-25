import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class login extends Application{
	public static void main(String args[]){
		launch(args);
	} 
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Login to MYSQL");
		
		GridPane grid = new GridPane();
		//grid.setMinSize(400,300);
		grid.setPadding(new Insets(40,10,10,30));
		grid.setVgap(18);
		grid.setHgap(10);
		
		Label nameLabel = new Label("Username: ");
		grid.add(nameLabel,0,0);
		TextField tx = new TextField();
		grid.add(tx, 1, 0);
		
		Label passLabel = new Label("Password: ");
		grid.add(passLabel, 0, 1);
		TextField tx1 = new TextField();
		tx1.setPromptText("Password");
		grid.add(tx1, 1, 1);
		
		Button loginButton = new Button("Login");
		loginButton.setOnAction(e -> 
		{
			String name = new String(tx.getText());
			String pass = new String(tx1.getText());
			
			MysqlCon ms = new MysqlCon(name,pass);
			ms.connect();
		});
		grid.add(loginButton,3,3);
		
		Scene scene = new Scene(grid,400,250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}