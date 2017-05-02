package Pages;

import Base.Page;
import Base.PageCtrl;
import Restaurants.Restaurant;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ResPage extends Page{
	Restaurant r;
	
	public ResPage(PageCtrl ctrl, int width, int height, Restaurant r) {
		super(ctrl, width, height);
		this.r = r;
		setup();
	}
	
	
	@Override
	public void setup() {
		GridPane gridPane = new GridPane();
		gridPane.setGridLinesVisible(true);
		
		StackPane pane1 = new StackPane();
		StackPane pane2 = new StackPane();
		
		pane1.setMinHeight(getHeight()/2);
		pane1.setMinWidth(getWidth());
		pane2.setMinHeight(getHeight()/2);
		pane2.setMinWidth(getWidth());
		
		VBox vBox = new VBox();
		Text text = new Text(r.getName().replace("_"," "));
		text.setFont(new Font("Arial",50));
		vBox.getChildren().add(text);
		pane1.getChildren().add(vBox);
		
		gridPane.add(pane1,0,0);
		gridPane.add(pane2,0,1);
		
		setPane(gridPane);
	}
}
