import java.io.FileInputStream;
import javafx.scene.media.Media;
import javafx.application.Platform;
import java.io.FileNotFoundException;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import javafx.scene.image.Image;

public class Toolkits {
	static Image img = null;
	static Media md;
	
	static Image getImage(String path, double w, double h){
		try{
		    img = new Image(new FileInputStream(path), w, h, true, false);
		}catch (FileNotFoundException e){
			SOPln("pic not found"); 
			Platform.exit();
		}
		    return img;
	}
	
	static MediaPlayer getMedia(String path){
		try{
			md = new Media(new File(path).toURI().toString());
		}catch (NullPointerException  e){
			SOPln("media not found"); 
			Platform.exit();
		}
		MediaPlayer player = new MediaPlayer(md);
		return player;		
	}
	
	public static void SOP(Object o){
		System.out.print(o);
	}
	
	public static void SOPln(Object o){
		System.out.println(o);
	}

}
