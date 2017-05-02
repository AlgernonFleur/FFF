package Pages;

import Base.Page;
import Base.PageCtrl;
import Restaurants.Database;
import Restaurants.Restaurant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainMenu extends Page{
	
	public MainMenu(PageCtrl ctrl, int width, int height) {
		super(ctrl, width, height);
		setup();
	}
	
	@Override
	public void setup() {
		Database d = new Database();
		d.readInDatabase();
		
		BorderPane pane = new BorderPane();
		
		GridPane gridPane = new GridPane();
		gridPane.setGridLinesVisible(true);
		gridPane.setPadding(new Insets(5));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		int i = 0;
		for(Restaurant r: d.getRestaurants()){
			String name = r.getName().replace("_"," ");
			Button resButt = new Button(name);
			resButt.setMinWidth(200);
			resButt.setAlignment(Pos.CENTER_LEFT);
			resButt.setFont(Font.font("Arial",15));
			resButt.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					ResPage resPage = new ResPage(getCtrl(),getWidth(),getHeight(),r);
					getCtrl().addPage(name,resPage.getPane());
					getCtrl().activate(name);
				}
			});
			gridPane.add(resButt,0,i);
			
			Text resCode = new Text(Integer.toString(r.getPostcode()));
			resCode.setFont(Font.font("Arial",20));
			gridPane.add(resCode,1,i);
			
			i++;
		}
		ScrollPane scrollPane = new ScrollPane(gridPane);
		pane.setCenter(scrollPane);
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(5));
		Button accountButton = new Button("Account");
		Button logoutButton = new Button("Logout");
		logoutButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				getCtrl().activate("Login");
			}
		});
		accountButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				getCtrl().activate("Default");
			}
		});
		hBox.getChildren().add(accountButton);
		hBox.getChildren().add(logoutButton);
		hBox.setAlignment(Pos.CENTER_RIGHT);
		pane.setTop(hBox);
		
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(5));
		vBox.setSpacing(8);
		Text vText1 = new Text("Menu");
		vText1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		vBox.getChildren().add(vText1);
		String[] strings = {"menu1","menu2","menu3"};
		for(String s:strings){
			Text sText = new Text(s);
			sText.setFont(Font.font("Arial",15));
			vBox.getChildren().add(sText);
		}
		pane.setLeft(vBox);
		
		setPane(pane);
	}
}
