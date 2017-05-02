package Base;

import Pages.Default;
import Pages.Login;
import Pages.MainMenu;
import Pages.ResPage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private final int width = 500;
	private final int height = 500;
	private final boolean resizeable = false;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Fine Food Finder");
		
		Scene scene = new Scene(new Pane(),width,height); //init with empty pane
		PageCtrl ctrl = new PageCtrl(scene);
		
		ctrl.addPage("Login",new Login(ctrl,width,height).getPane());
		ctrl.addPage("MainMenu",new MainMenu(ctrl,width,height).getPane());
		ctrl.addPage("Default",new Default(ctrl,width,height).getPane());
		ctrl.activate("MainMenu");
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(resizeable);
		primaryStage.show();
	}
}
