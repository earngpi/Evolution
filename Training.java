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

public class Training implements EvoStage {
	private Label top = createTopLabel("In-Training: Tanemon");
	private ImageView tanemon = new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/tanemini.gif", 50, 50));
	private ImageView mimiBody = new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/mimiview.gif", 50, 100));
	private AnimationTimer timer = new AnimationTimer(){
    	long prevTime = 0;
    	public void handle(long now){
    		if((now - prevTime) >= 500000000*2){
    			double xVal = 25*(rnd.nextInt(26) + 1);
    			double yVal = 25*(rnd.nextInt(12) + 1);
    			mimiBody.relocate(xVal, yVal);
    			//Toolkits.SOPln(mimiBody.getLayoutX() + " " + mimiBody.getLayoutY());
    			prevTime = now;
    		}
    	}
    };
    private EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>(){
    	public void handle(KeyEvent e){
    		KeyCode input = e.getCode();
    		switch(input){
    		case UP: 
    			if(tanemon.getLayoutY()==0){	    			
    			}else{
    				tanemon.setLayoutY(tanemon.getLayoutY()-25);
    				//Toolkits.SOPln("up handled " + tanemon.getLayoutY());
    			} break;
    		case DOWN: 
    			if(tanemon.getLayoutY()==350){	    			
    			}else{
    				tanemon.setLayoutY(tanemon.getLayoutY()+25);
    				//Toolkits.SOPln("down handled " + tanemon.getLayoutY());
    			} break;
    		case LEFT: 
    			if(tanemon.getLayoutX()==0){	    			
    			}else{
    				tanemon.setLayoutX(tanemon.getLayoutX()-25);
    				//Toolkits.SOPln("left handled " + tanemon.getLayoutX());
    			} break;
    		case RIGHT: 
    			if(tanemon.getLayoutX()==650){	    			
    			}else{
    				tanemon.setLayoutX(tanemon.getLayoutX()+25);
    				//Toolkits.SOPln("right handled " + tanemon.getLayoutX());
    			} break;
    		default: break;
    		}
    		if((mimiBody.getLayoutX()==tanemon.getLayoutX()
    				|| tanemon.getLayoutX()+25==mimiBody.getLayoutX()
    				|| tanemon.getLayoutX()==mimiBody.getLayoutX()+25) && 
    				(mimiBody.getLayoutY()==tanemon.getLayoutY() 
    				|| tanemon.getLayoutY()==mimiBody.getLayoutY()+25
    				|| tanemon.getLayoutY()==mimiBody.getLayoutY()+50
    				|| tanemon.getLayoutY()==mimiBody.getLayoutY()+75
    				|| tanemon.getLayoutY()+25==mimiBody.getLayoutY()
    				)){
    	    			//Toolkits.SOPln("FOUND MIMI!!!!!!!"); 
    	    			timer.stop();
    	    			pane.setCenter(transit.getVb());
    	    			pane.setTop(null);
    	    			bottom.getChildren().get(0).setOpacity(1);
    	    }
    	}
    };
    private ImageView happyPal = new ImageView(Toolkits.getImage("Image/happyPalmon.gif", 200, 200));
    private Pane mid = createMidPane(tanemon, mimiBody, handler);
    private HBox bottom = createHBottom(0.6, 0.1, 0.1, 0.1);
    private BorderPane pane = new BorderPane();
    Transition transit = new Transition(happyPal, "Click to Keep On Digivolving!");
    
	@Override
	public Scene createScene() {
		// TODO Auto-generated method stub
		pane.setTop(top);
		pane.setCenter(mid);
		pane.setBottom(bottom);
		timer.start();
		transit.getBt().setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		GameFrame.stage.setScene((new Rookie()).createScene());
        	}
        });
		return new Scene(pane);
	}

}
