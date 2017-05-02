package Base;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class PageCtrl {
	private HashMap<String,Pane> pageMap;
	private Scene scene;
	
	public PageCtrl(Scene scene) {
		pageMap = new HashMap<>();
		this.scene = scene;
	}
	
	public void addPage(String name, Pane page){
		pageMap.put(name,page);
	}
	
	public void removePage(String name){
		pageMap.remove(name);
	}
	
	public void activate(String name){
		scene.setRoot(pageMap.get(name));
	}
	
	public Pane getPage(String name){
		return pageMap.get(name);
	}
}
