package Base;

import javafx.scene.layout.Pane;

public abstract class Page{
	private PageCtrl ctrl;
	private Pane pane;
	private int width,height;
	
	public Page(PageCtrl ctrl,int width,int height) {
		this.ctrl = ctrl;
		this.width = width;
		this.height = height;
	}
	
	public abstract void setup();
	
	public PageCtrl getCtrl() {
		return ctrl;
	}
	
	public void setPane(Pane pane) {
		this.pane = pane;
	}
	
	public Pane getPane() {
		return pane;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
