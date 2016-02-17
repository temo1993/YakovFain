package lesson18.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneSampleEvents extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		Label userIdLbl = new Label("User ID:");
		TextField userIdTxt = new TextField();
		Label userPwdLbl = new Label("Password:");
		PasswordField userPwdTxt = new PasswordField();
		Button signInBtn = new Button ("Sign In");
		Button cancelBtn = new Button ("Cancel");
		Hyperlink forgotPwd = new Hyperlink("Forgot password");

		GridPane root = new GridPane();
		root.setVgap(20);
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		// Using static methods for setting node constraints 
		GridPane.setConstraints(userIdLbl, 0, 0);
		GridPane.setConstraints(userIdTxt, 1, 0);
		GridPane.setConstraints(userPwdLbl, 0, 1);
		GridPane.setConstraints(userPwdTxt, 1, 1);
		GridPane.setConstraints(signInBtn, 0, 2);
		//Cancel button: span 1, right aligned
		GridPane.setConstraints(cancelBtn, 1,2, 1, 1, HPos.RIGHT, VPos.CENTER);
		GridPane.setConstraints(forgotPwd, 0, 3,2,1);

		root.getChildren().addAll(userIdLbl, userIdTxt, userPwdLbl, userPwdTxt,
				                 signInBtn, cancelBtn, forgotPwd);
			
	
		// event handlers
		//1. Anonymous class 
		signInBtn.setOnAction(new EventHandler<ActionEvent>(){
			       public void handle(ActionEvent evt){
			   		System.out.println("Anonymous class handler. Sign in clicked.");   
			       }
		});
		
		// lambda expression
		cancelBtn.setOnAction(evt -> 
			System.out.println("Lambda handler. Cancel clicked.")
		);
		
		// method reference
		forgotPwd.setOnAction(this::forgotPwdHandler);
		
		// Show the window
		Scene scene = new Scene(root,250,200);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	private void forgotPwdHandler(ActionEvent evt){
		System.out.println("Method reference handler. Forgot password clicked");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
