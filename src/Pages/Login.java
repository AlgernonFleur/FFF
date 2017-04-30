package Pages;

import Base.Page;
import Base.PageCtrl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Login extends Page {
	public Login(PageCtrl ctrl) {
		super(ctrl);
	}
	
	@Override
	public void setup() {
		//page grid setup
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(25, 25, 25, 25));
		
		//<editor-fold desc="---Page Objects---">
		//title
		Text title = new Text("Welcome");
		title.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
		pane.add(title, 0, 0, 2, 1);
		
		//username
		Label userName = new Label("User Name:");
		pane.add(userName, 0, 1);
		TextField userField = new TextField();
		pane.add(userField, 1, 1);
		
		//password
		Label pw = new Label("Password:");
		pane.add(pw, 0, 2);
		PasswordField pwField = new PasswordField();
		pane.add(pwField, 1, 2);
		
		//submit button
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		pane.add(hbBtn, 1, 4);
		//</editor-fold>
		
		EventHandler<KeyEvent> checkKey = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode().toString().equals("ENTER")) {
					String username = userField.getText();
					String password = pwField.getText();
					
					if(checkUser(username,password))
						getCtrl().activate("Default");
				}
			}
		};
		
		userField.setOnKeyPressed(checkKey);
		pwField.setOnKeyPressed(checkKey);
		
		EventHandler<ActionEvent> checkSubmit = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String username = userField.getText();
				String password = pwField.getText();
				
				if(checkUser(username,password))
					getCtrl().activate("Default");
			}
		};
		
		btn.setOnAction(checkSubmit);
		
		setPane(pane);
	}
	
	public boolean checkUser(String username,String password){
		if(username.equals("admin") && password.equals("null")) return true;
		else return false;
	}
}
