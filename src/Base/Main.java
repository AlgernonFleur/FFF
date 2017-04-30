package Base;

import Pages.Default;
import Pages.Login;
import Pages.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Fine Food Finder");
		
		Scene scene = new Scene(new Pane(),500,500);
		PageCtrl ctrl = new PageCtrl(scene);
		
		ctrl.addPage("Login",new Login(ctrl).getPane());
		ctrl.addPage("MainMenu",new MainMenu(ctrl).getPane());
		ctrl.addPage("Default",new Default(ctrl).getPane());
		ctrl.activate("Login");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
