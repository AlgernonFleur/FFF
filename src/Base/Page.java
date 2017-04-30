package Base;

import javafx.scene.layout.Pane;

public abstract class Page{
	private PageCtrl ctrl;
	private Pane pane;
	
	public Page(PageCtrl ctrl) {
		this.ctrl = ctrl;
		setup();
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
}
