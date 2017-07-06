import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class Transition {
	private Button toContBt;
	private VBox transitVb = new VBox();
	
	Transition(Node n, String btText){
		toContBt = new Button(btText);
		transitVb.setAlignment(Pos.CENTER);
		transitVb.getChildren().addAll(n, toContBt);
	}
	
	public VBox getVb(){
		return transitVb;
	}
	
	public Button getBt(){
		return toContBt;
	}
	
}
