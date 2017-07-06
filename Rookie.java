import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class Rookie implements EvoStage {
	private Label top = createTopLabel("Rookie: Palmon");
	private ImageView palmon = new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/palmini.gif", 40, 60));
	private ImageView digivice = new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/digivice.gif", 60, 60));
	private AnimationTimer timer = new AnimationTimer(){
    	long prevTime = 0;
    	public void handle(long now){
    		if((now - prevTime) >= 500000000*1.5){
    			double xVal = 20*(rnd.nextInt(32) + 1);
    			double yVal = 20*(rnd.nextInt(17) + 1);
    			digivice.relocate(xVal, yVal);
    			//Toolkits.SOPln(digivice.getLayoutX() + " " + digivice.getLayoutY());
    			prevTime = now;
    		}
    	}
    };
    private EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>(){
    	public void handle(KeyEvent e){
    		KeyCode input = e.getCode();
    		switch(input){
    		case UP: 
    			if(palmon.getLayoutY()==0){	    			
    			}else{
    				palmon.setLayoutY(palmon.getLayoutY()-20);
    				//Toolkits.SOPln("up handled " + palmon.getLayoutY());
    			} break;
    		case DOWN: 
    			if(palmon.getLayoutY()==340){	    			
    			}else{
    				palmon.setLayoutY(palmon.getLayoutY()+20);
    				//Toolkits.SOPln("down handled " + palmon.getLayoutY());
    			} break;
    		case LEFT: 
    			if(palmon.getLayoutX()==0){	    			
    			}else{
    				palmon.setLayoutX(palmon.getLayoutX()-20);
    				//Toolkits.SOPln("left handled " + palmon.getLayoutX());
    			} break;
    		case RIGHT: 
    			if(palmon.getLayoutX()==660){	    			
    			}else{
    				palmon.setLayoutX(palmon.getLayoutX()+20);
    				//Toolkits.SOPln("right handled " + palmon.getLayoutX());
    			} break;
    		default: break;
    		}
    		if((digivice.getLayoutX()==palmon.getLayoutX()
    			|| palmon.getLayoutX()+20==digivice.getLayoutX()
    			|| palmon.getLayoutX()==digivice.getLayoutX()+20
    			|| palmon.getLayoutX()==digivice.getLayoutX()+40) && 
    			(digivice.getLayoutY()==palmon.getLayoutY()
    			|| digivice.getLayoutY()==palmon.getLayoutY()+20
    			|| digivice.getLayoutY()+20==palmon.getLayoutY()
    			)){
    	    		//Toolkits.SOPln("FOUND DIGIVICE!!!!!!!"); 
    	    		timer.stop();
    	    		pane.setCenter(transit.getVb());
    	    		pane.setTop(null);
    	    		bottom.getChildren().get(1).setOpacity(1);
    	    		Toolkits.getMedia("Media/mimi no theme.mp3").play();
    	    		
    	    }
    	}
    };
    private ImageView happyToge = new ImageView(Toolkits.getImage("Image/togemusic.gif", 200, 200));
    private Pane mid = createMidPane(palmon, digivice, handler);
    private HBox bottom = createHBottom(1.0, 0.6, 0.1, 0.1);
    private BorderPane pane = new BorderPane();
    Transition transit = new Transition(happyToge, "Click to Keep On Digivolving!");


	@Override
	public Scene createScene() {
		// TODO Auto-generated method stub
		pane.setTop(top);
		pane.setCenter(mid);
		pane.setBottom(bottom);
		timer.start();
		transit.getBt().setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		GameFrame.stage.setScene((new Champion()).createScene());
        	}
        });
		return new Scene(pane);
	}

}
