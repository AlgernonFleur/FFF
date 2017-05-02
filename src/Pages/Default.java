package Pages;

import Base.Page;
import Base.PageCtrl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Default extends Page {
	public Default(PageCtrl ctrl, int width, int height) {
		super(ctrl, width, height);
		setup();
	}
	
	@Override
	public void setup() {
		BorderPane pane = new BorderPane();
		
		Text text = new Text("Alright!");
		text.setFont(Font.font("Tahoma", FontWeight.NORMAL,30));
		pane.setCenter(text);
		
		Button button = new Button("Logout");
		HBox box = new HBox();
		box.getChildren().add(button);
		box.setAlignment(Pos.CENTER);
		pane.setBottom(box);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				getCtrl().activate("Login");
			}
		});
		
		setPane(pane);
	}
}
