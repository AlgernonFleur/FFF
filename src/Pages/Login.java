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
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(25, 25, 25, 25));
		
		Text sceneTitle = new Text("Welcome");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		pane.add(sceneTitle, 0, 0, 2, 1);
		
		Label userName = new Label("User Name:");
		pane.add(userName, 0, 1);
		
		TextField userTextField = new TextField();
		pane.add(userTextField, 1, 1);
		
		Label pw = new Label("Password:");
		pane.add(pw, 0, 2);
		
		PasswordField pwBox = new PasswordField();
		pane.add(pwBox, 1, 2);
		
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		pane.add(hbBtn, 1, 4);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//getCtrl().activate("test.FirstPage");
				System.out.println("HELLO");
			}
		});
		
		setPane(pane);
	}
}
