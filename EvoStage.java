import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public interface EvoStage {
	final int w = 700;
	final int h = 400;
	static Random rnd = new Random();
	
	default Label createTopLabel(String name){
		Label top = new Label(name);
		top.setPrefSize(w, 10);
		return top;
	}
	
    default Pane createMidPane(ImageView player, ImageView object, EventHandler<KeyEvent> e){
    	Pane mid = new Pane();
    	Rectangle clip = new Rectangle(w, h);
    	mid.setClip(clip);
		mid.setPrefSize(w, h);
		mid.setMaxSize(w, h); 
		mid.setMinSize(w, h);
	    mid.getChildren().addAll(player, object); 
	    object.relocate(w, h);
	    player.setFocusTraversable(true);  
	    player.setOnKeyPressed(e);
	    return mid;
    }
	
	default HBox createHBottom(double h, double v, double t, double c){
		ImageView mimiHead = new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/mimi-head.gif", 40, 40));
		ImageView miniVice = new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/Digivice2.gif", 40 ,40));
		ImageView miniTag = new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/Tag2.gif", 40, 40));
		ImageView miniCrest = new ImageView(Toolkits.getImage("Image/bigcrest.png", 40, 40));
		HBox bottom = new HBox(7);
		mimiHead.setOpacity(h); miniVice.setOpacity(v); miniTag.setOpacity(t); miniCrest.setOpacity(c);
		bottom.setPrefSize(w, 40); 
		bottom.setMaxSize(w, 40); 
		bottom.setMinSize(w, 40);
		bottom.setAlignment(Pos.CENTER_RIGHT);
		bottom.getChildren().addAll(mimiHead, miniVice, miniTag, miniCrest, new Label(" "));
		return bottom;
	}
	
	Scene createScene();
	
}
