import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class Champion implements EvoStage {
	private int count = 0;
	private Label top = createTopLabel("Champion: Togemon");
	private ImageView togemon = new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/togemonmini.gif", 80, 80));
	private ImageView tag = new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/crest-mini.gif", 60, 60));
	private AnimationTimer timerT = new AnimationTimer(){
	    long prevTime = 0;
	    public void handle(long now){
	    	if((now - prevTime) >= 500000000*1.5){
	    		double xVal = 20*(rnd.nextInt(32) + 1);
	    		double yVal = 20*(rnd.nextInt(17) + 1);
	    		tag.relocate(xVal, yVal);
	    		//Toolkits.SOPln(tag.getLayoutX() + " " + tag.getLayoutY());
	    		prevTime = now;
	    	}
	    }
	};
	private ImageView crest = new ImageView(Toolkits.getImage("Image/bigcrest.png", 60, 50));
	private AnimationTimer timerC = new AnimationTimer(){
	    long prevTime = 0;
	    public void handle(long now){
	    	if((now - prevTime) >= 500000000/1.5){
	    		double xVal = 20*(rnd.nextInt(32) + 1);
	    		double yVal = 20*(rnd.nextInt(17) + 1);
	    		crest.relocate(xVal, yVal);
	    		//Toolkits.SOPln(crest.getLayoutX() + " " + crest.getLayoutY());
	    		prevTime = now;
	    	}
	    }
	};
	private EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>(){
    	public void handle(KeyEvent e){
    		KeyCode input = e.getCode();
    		switch(input){
    		case UP: 
    			if(togemon.getLayoutY()==0){	    			
    			}else{
    				togemon.setLayoutY(togemon.getLayoutY()-20);
    				//Toolkits.SOPln("up handled " + togemon.getLayoutY());
    			} break;
    		case DOWN: 
    			if(togemon.getLayoutY()==320){	    			
    			}else{
    				togemon.setLayoutY(togemon.getLayoutY()+20);
    				//Toolkits.SOPln("down handled " + togemon.getLayoutY());
    			} break;
    		case LEFT: 
    			if(togemon.getLayoutX()==0){	    			
    			}else{
    				togemon.setLayoutX(togemon.getLayoutX()-20);
    				//Toolkits.SOPln("left handled " + togemon.getLayoutX());
    			} break;
    		case RIGHT: 
    			if(togemon.getLayoutX()==620){	    			
    			}else{
    				togemon.setLayoutX(togemon.getLayoutX()+20);
    				//Toolkits.SOPln("right handled " + togemon.getLayoutX());
    			} break;
    		default: break;
    		}
    		
    		if((tag.getLayoutX()==togemon.getLayoutX()
	    		|| togemon.getLayoutX()+20==tag.getLayoutX()
	    		|| togemon.getLayoutX()+40==tag.getLayoutX()
	    		|| togemon.getLayoutX()==tag.getLayoutX()+20
	    		|| togemon.getLayoutX()==tag.getLayoutX()+40) && 
	    		(tag.getLayoutY()==togemon.getLayoutY()
	    		|| tag.getLayoutY()==togemon.getLayoutY()+20
	    		|| tag.getLayoutY()==togemon.getLayoutY()+40
	    		|| tag.getLayoutY()==togemon.getLayoutY()+60
	    		|| tag.getLayoutY()+20==togemon.getLayoutY()
	    		|| tag.getLayoutY()+40==togemon.getLayoutY()
	    		)){
    				tag.relocate(700, 400);
	    	    	//Toolkits.SOPln("FOUND TAG!!!!!!!"); 
	    	    	timerT.stop();
	    	    	bottom.getChildren().get(2).setOpacity(1);
	    	    	count++;
	    	    }
    		
    		if((crest.getLayoutX()==togemon.getLayoutX()
	    		|| togemon.getLayoutX()+20==crest.getLayoutX()
	    		|| togemon.getLayoutX()+40==crest.getLayoutX()
	    		|| togemon.getLayoutX()+60==crest.getLayoutX()
	    		|| togemon.getLayoutX()==crest.getLayoutX()+20
	    		|| togemon.getLayoutX()==crest.getLayoutX()+40) && 
	    		(crest.getLayoutY()==togemon.getLayoutY()
	    		|| crest.getLayoutY()==togemon.getLayoutY()+20
	    		|| crest.getLayoutY()==togemon.getLayoutY()+40
	    		|| crest.getLayoutY()==togemon.getLayoutY()+60
	    		|| crest.getLayoutY()+20==togemon.getLayoutY()
	    		)){
	    			crest.relocate(700, 400);
	    	    	//Toolkits.SOPln("FOUND CREST!!!!!!!"); 
	    	    	timerC.stop();
	    	    	bottom.getChildren().get(3).setOpacity(1);
	    	    	count++;
	    	    }
    		
    		if(count==2){
    			pane.setTop(null);
    			pane.setCenter(transit.getVb());
    			pane.setBottom(null);
    		}
    	}
    };
    private ImageView endTane = new ImageView(Toolkits.getImage("Image/tanemon.gif", 45, 45));
    private ImageView endPal = new ImageView(Toolkits.getImage("Image/palmon.gif", 100, 100));
    private ImageView endToge = new ImageView(Toolkits.getImage("Image/toge.gif", 190, 190));
    private ImageView endLilly = new ImageView(Toolkits.getImage("Image/lilymon-big.gif", 180, 230));
    private Pane mid = createMidPane(togemon, tag, handler);
    private HBox bottom = createHBottom(1.0, 1.0, 0.25, 0.4);
    private BorderPane pane = new BorderPane();
    private HBox end = new HBox(endTane, endPal, endToge, endLilly);
    Transition transit = new Transition(end, "Click to Play Again!");

	@Override
	public Scene createScene() {
		// TODO Auto-generated method stub
		mid.getChildren().add(crest);
		bottom.getChildren().remove(1);
		bottom.getChildren().add(1, new ImageView(Toolkits.getImage("Image/giffactory-joeyteel/mimivice.gif", 40, 40)));
		pane.setTop(top);
		pane.setCenter(mid);
		pane.setBottom(bottom);
		timerT.start();
		timerC.start();
		end.setAlignment(Pos.CENTER);
		transit.getVb().getChildren().add(1, new Label("You finished the game! Thank you for playing."));
		transit.getVb().getChildren().add(2, new Label(""));
		transit.getBt().setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent e){
        		GameFrame.stage.setScene((new Training().createScene()));
        	}
        });
		return new Scene(pane);
	}

}
